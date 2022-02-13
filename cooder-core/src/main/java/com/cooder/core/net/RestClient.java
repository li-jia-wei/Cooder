package com.cooder.core.net;

import android.content.Context;
import com.cooder.core.net.callback.*;
import com.cooder.core.ui.CooderLoader;
import com.cooder.core.ui.LoaderStyle;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

import java.util.Map;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/11 17:01
 * 作者姓名：lijiawei
 * 功能介绍：网络请求实现类
 */

public class RestClient {
	
	private final String URL;
	private static final Map<String, Object> PARAMS = RestCreator.getParams();
	private final IRequest REQUEST;
	private final ISuccess SUCCESS;
	private final IFailure FAILURE;
	private final IError ERROR;
	private final RequestBody BODY;
	private final LoaderStyle LOADER_STYLE;
	private final Context CONTEXT;
	
	public RestClient(String url,
	                  Map<String, Object> params,
	                  IRequest request,
	                  ISuccess success,
	                  IFailure failure,
	                  IError error,
	                  RequestBody body,
	                  LoaderStyle loaderStyle,
	                  Context context) {
		this.URL = url;
		PARAMS.putAll(params);
		this.REQUEST = request;
		this.SUCCESS = success;
		this.FAILURE = failure;
		this.ERROR = error;
		this.BODY = body;
		this.LOADER_STYLE = loaderStyle;
		this.CONTEXT = context;
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
			case PUT:
				call = service.put(URL, PARAMS);
				break;
			case DELETE:
				call = service.delete(URL, PARAMS);
				break;
			default:
				break;
		}
		
		if (call != null) {
			// 会在后台执行，不会印象UI主进程
			call.enqueue(getRequestCallback());
		}
	}
	
	// 获取请求回调
	private Callback<String> getRequestCallback() {
		return new RequestCallbacks(REQUEST, SUCCESS, FAILURE, ERROR, LOADER_STYLE);
	}
	
	public final void get() {
		request(HttpMethod.GET);
	}
	
	public final void post() {
		request(HttpMethod.POST);
	}
	
	public final void put() {
		request(HttpMethod.PUT);
	}
	
	public final void delete() {
		request(HttpMethod.DELETE);
	}
}