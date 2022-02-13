package com.cooder.core.net;

import android.content.Context;
import com.cooder.core.net.callback.IError;
import com.cooder.core.net.callback.IFailure;
import com.cooder.core.net.callback.IRequest;
import com.cooder.core.net.callback.ISuccess;
import com.cooder.core.ui.LoaderStyle;
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
	
	private String mUrl = null;
	private static final Map<String, Object> PARAMS = RestCreator.getParams();
	private IRequest mIRequest = null;
	private ISuccess mISuccess = null;
	private IFailure mIFailure = null;
	private IError mIError = null;
	private RequestBody mBody = null;
	private LoaderStyle mLoaderStyle = null;
	private Context mContext = null;
	
	RestClientBuilder() {
	
	}
	
	// 设置url
	public final RestClientBuilder url(String url) {
		this.mUrl = url;
		return this;
	}
	
	// 设置参数
	public final RestClientBuilder params(Map<String, Object> params) {
		PARAMS.putAll(params);
		return this;
	}
	
	// 设置参数
	public final RestClientBuilder params(String key, Object value) {
		PARAMS.put(key, value);
		return this;
	}
	
	// 设置raw
	@SuppressWarnings("deprecation")
	public final RestClientBuilder raw(String raw) {
		this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
		return this;
	}
	
	// 请求回调
	public final RestClientBuilder onRequest(IRequest iRequest) {
		this.mIRequest = iRequest;
		return this;
	}
	
	// 请求成功回调
	public final RestClientBuilder success(ISuccess iSuccess) {
		this.mISuccess = iSuccess;
		return this;
	}
	
	// 请求失败回调
	public final RestClientBuilder failure(IFailure iFailure) {
		this.mIFailure = iFailure;
		return this;
	}
	
	// 请求报错回调
	public final RestClientBuilder error(IError iError) {
		this.mIError = iError;
		return this;
	}
	
	// 设置加载
	public final RestClientBuilder loader(Context context, LoaderStyle loaderStyle) {
		this.mContext = context;
		this.mLoaderStyle = loaderStyle;
		return this;
	}
	
	public final RestClientBuilder loader(Context context) {
		this.mContext = context;
		this.mLoaderStyle = LoaderStyle.BallClipRotateIndicator;
		return this;
	}
	
	public final RestClient build() {
		return new RestClient(mUrl, PARAMS, mIRequest, mISuccess, mIFailure, mIError, mBody, mLoaderStyle, mContext);
	}
}
