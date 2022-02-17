package com.cooder.core.net;

import android.content.Context;
import com.cooder.core.net.callback.*;
import com.cooder.core.net.data.CallbackData;
import com.cooder.core.net.data.DownloadData;
import com.cooder.core.net.data.RestData;
import com.cooder.core.net.download.DownloadHandler;
import com.cooder.core.ui.loader.CooderLoader;
import com.cooder.core.ui.loader.LoaderStyle;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

import java.io.File;
import java.util.Map;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/11 17:01
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：网络请求实现类
 */

public class RestClient {
	private final Context CONTEXT;
	private final String URL;
	private static final Map<String, Object> PARAMS = RestData.getPARAMS();
	private final RequestBody BODY;
	private final File FILE;
	private final Enum<LoaderStyle> LOADER_STYLE;
	private final IRequest REQUEST;
	private final ISuccess SUCCESS;
	private final IFailure FAILURE;
	private final IError ERROR;
	private final String DOWNLOAD_DIR;
	private final String EXTENSION;
	private final String NAME;
	
	public RestClient(Context context, RestData restData, CallbackData callbackData, DownloadData downloadData) {
		this.CONTEXT = context;
		this.URL = restData.getUrl();
		PARAMS.putAll(RestData.getPARAMS());
		this.BODY = restData.getBody();
		this.FILE = restData.getFile();
		this.LOADER_STYLE = restData.getLoaderStyle();
		this.REQUEST = callbackData.getRequest();
		this.SUCCESS = callbackData.getSuccess();
		this.FAILURE = callbackData.getFailure();
		this.ERROR = callbackData.getError();
		this.DOWNLOAD_DIR = downloadData.getDownloadDir();
		this.EXTENSION = downloadData.getExtension();
		this.NAME = downloadData.getName();
	}
	
	// 构建
	public static RestClientBuilder builder() {
		return new RestClientBuilder();
	}
	
	// 请求方法
	private void request(HttpMethod method) {
		final RestService service = RestCreator.getRestService();
		Call<String> call = null;
		if (REQUEST != null) {
			REQUEST.onRequestStart();
		}
		if (LOADER_STYLE != null) {
			CooderLoader.showLoading(CONTEXT, LOADER_STYLE);
		}
		switch (method) {
			case GET:
				call = service.get(URL, PARAMS);
				break;
			case POST:
				call = service.post(URL, PARAMS);
				break;
			case POST_RAW:
				call = service.postRaw(URL, BODY);
				break;
			case PUT:
				call = service.put(URL, PARAMS);
				break;
			case PUT_RAW:
				call = service.putRaw(URL, BODY);
				break;
			case DELETE:
				call = service.delete(URL, PARAMS);
				break;
			case UPLOAD:
				call = RestCreator.getRestService().upload(URL, getBody());
				break;
			default:
				break;
		}
		
		if (call != null) {
			// 会在后台执行，不会印象UI主进程
			call.enqueue(getRequestCallback());
		}
	}
	
	// 获取Body
	private MultipartBody.Part getBody() {
		final RequestBody requestBody = RequestBody.create(FILE, MediaType.parse(MultipartBody.FORM.toString()));
		final MultipartBody.Part body = MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
		return body;
	}
	
	// 获取请求回调
	private Callback<String> getRequestCallback() {
		CallbackData callbackData = new CallbackData(REQUEST, SUCCESS, FAILURE, ERROR);
		return new RequestCallbacks(callbackData, LOADER_STYLE);
	}
	
	public final void get() {
		request(HttpMethod.GET);
	}
	
	public final void post() {
		if (BODY == null) {
			request(HttpMethod.POST);
		} else {
			if (!PARAMS.isEmpty()) {
				throw new RuntimeException("PARAMS必须是空的！");
			}
			request(HttpMethod.PUT_RAW);
		}
	}
	
	public final void put() {
		if (BODY == null) {
			request(HttpMethod.PUT);
		} else {
			if (!PARAMS.isEmpty()) {
				throw new RuntimeException("PARAMS必须是空的！");
			}
			request(HttpMethod.PUT_RAW);
		}
	}
	
	public final void delete() {
		request(HttpMethod.DELETE);
	}
	
	public final void upload() {
		request(HttpMethod.UPLOAD);
	}
	
	public final void download() {
		DownloadHandler handler = new DownloadHandler(URL,
				new CallbackData(REQUEST, SUCCESS, FAILURE, ERROR),
				new DownloadData(NAME, EXTENSION, DOWNLOAD_DIR)
		);
		handler.handleDownload();
	}
}