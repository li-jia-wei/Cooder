package com.cooder.core.net;

import com.cooder.core.net.callback.IError;
import com.cooder.core.net.callback.IFailure;
import com.cooder.core.net.callback.IRequest;
import com.cooder.core.net.callback.ISuccess;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.util.Map;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/12 06:33
 * 作者姓名：lijiawei
 * 功能介绍：网络请求建造者
 */

public class RestClientBuilder {
	
	private String mUrl;
	private static final Map<String, Object> PARAMS = RestCreator.getParams();
	private IRequest mIRequest;
	private ISuccess mISuccess;
	private IFailure mIFailure;
	private IError mIError;
	private RequestBody mBody;
	
	RestClientBuilder() {
	
	}
	
	public final RestClientBuilder url(String url) {
		this.mUrl = url;
		return this;
	}
	
	public final RestClientBuilder params(Map<String, Object> params) {
		PARAMS.putAll(params);
		return this;
	}
	
	public final RestClientBuilder params(String key, Object value) {
		PARAMS.put(key, value);
		return this;
	}
	
	@SuppressWarnings("deprecation")
	public final RestClientBuilder raw(String raw) {
		this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
		return this;
	}
	
	public final RestClientBuilder onRequest(IRequest iRequest) {
		this.mIRequest = iRequest;
		return this;
	}
	
	public final RestClientBuilder success(ISuccess iSuccess) {
		this.mISuccess = iSuccess;
		return this;
	}
	
	public final RestClientBuilder failure(IFailure iFailure) {
		this.mIFailure = iFailure;
		return this;
	}
	
	public final RestClientBuilder error(IError iError) {
		this.mIError = iError;
		return this;
	}
	
	public final RestClient build() {
		return new RestClient(mUrl, PARAMS, mIRequest, mISuccess, mIFailure, mIError, mBody);
	}
}
