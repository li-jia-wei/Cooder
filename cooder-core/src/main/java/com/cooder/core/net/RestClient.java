package com.cooder.core.net;

import android.content.Context;
import com.cooder.core.net.callback.*;
import com.cooder.core.ui.CooderLoader;
import com.cooder.core.ui.LoaderStyle;
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
 * 功能介绍：网络请求实现类
 */

public class RestClient {
	
	private final String URL;
	private static final Map<String, Object> PARAMS = RestData.getPARAMS();
	private final IRequest REQUEST;
	private final ISuccess SUCCESS;
	private final IFailure FAILURE;
	private final IError ERROR;
	private final RequestBody BODY;
	private final LoaderStyle LOADER_STYLE;
	private final File FILE;
	private final Context CONTEXT;
	
	public RestClient(RestData data) {
		this.URL = data.getURL();
		PARAMS.putAll(RestData.getPARAMS());
		this.REQUEST = data.getREQUEST();
		this.SUCCESS = data.getSUCCESS();
		this.FAILURE = data.getFAILURE();
		this.ERROR = data.getERROR();
		this.BODY = data.getBODY();
		this.FILE = data.getFILE();
		this.LOADER_STYLE = data.getLOADER_STYLE();
		this.CONTEXT = data.getCONTEXT();
	}
	
	public static RestClientBuilder builder() {
		return new RestClientBuilder();
	}
	
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
	
	// upload -- get multipartBody.Part
	private MultipartBody.Part getBody() {
		final RequestBody requestBody = RequestBody.create(FILE, MediaType.parse(MultipartBody.FORM.toString()));
		final MultipartBody.Part body = MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
		return body;
	}
	
	// 获取请求回调
	private Callback<String> getRequestCallback() {
		return new RequestCallbacks(REQUEST, SUCCESS, FAILURE, ERROR, LOADER_STYLE);
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
}