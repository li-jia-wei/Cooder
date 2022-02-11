package com.cooder.core.net;

import com.cooder.core.net.callback.IError;
import com.cooder.core.net.callback.IFailure;
import com.cooder.core.net.callback.IRequest;
import com.cooder.core.net.callback.ISuccess;
import okhttp3.RequestBody;

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
	
	public RestClient(String url, Map<String, Object> params, IRequest request, ISuccess success, IFailure failure, IError error, RequestBody body) {
		URL = url;
		PARAMS.putAll(params);
		REQUEST = request;
		SUCCESS = success;
		FAILURE = failure;
		ERROR = error;
		BODY = body;
	}
	
	public static RestClientBuilder builder() {
		return new RestClientBuilder();
	}
}