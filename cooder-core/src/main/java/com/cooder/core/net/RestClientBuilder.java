package com.cooder.core.net;

import android.content.Context;
import com.cooder.core.net.callback.*;
import com.cooder.core.ui.CooderLoader;
import com.cooder.core.ui.LoaderStyle;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.File;
import java.util.Map;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/12 06:33
 * 作者姓名：lijiawei
 * 功能介绍：网络请求建造者
 */

public class RestClientBuilder {
	
	private Context mContext;
	private final CallbackData mCallbackData;
	private final RestData mRestData;
	
	RestClientBuilder() {
		this.mCallbackData = new CallbackData();
		this.mRestData = new RestData();
	}
	
	// 设置url
	public final RestClientBuilder url(String url) {
		this.mRestData.setURL(url);
		return this;
	}
	
	// 设置参数
	public final RestClientBuilder params(Map<String, Object> params) {
		RestData.setPARAMS(params);
		return this;
	}
	
	// 设置参数
	public final RestClientBuilder params(String key, Object value) {
		RestData.setPARAMS(key, value);
		return this;
	}
	
	// 上传文件
	public final RestClientBuilder file(File file) {
		this.mRestData.setFILE(file);
		return this;
	}
	
	// 上传文件
	public final RestClientBuilder file(String url) {
		this.mRestData.setFILE(new File(url));
		return this;
	}
	
	// 设置raw
	@SuppressWarnings("deprecation")
	public final RestClientBuilder raw(String raw) {
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
		this.mRestData.setBODY(requestBody);
		return this;
	}
	
	// 请求回调
	public final RestClientBuilder onRequest(IRequest iRequest) {
		this.mCallbackData.setREQUEST(iRequest);
		return this;
	}
	
	// 请求成功回调
	public final RestClientBuilder success(ISuccess iSuccess) {
		this.mCallbackData.setSUCCESS(iSuccess);
		return this;
	}
	
	// 请求失败回调
	public final RestClientBuilder failure(IFailure iFailure) {
		this.mCallbackData.setFAILURE(iFailure);
		return this;
	}
	
	// 请求报错回调
	public final RestClientBuilder error(IError iError) {
		this.mCallbackData.setERROR(iError);
		return this;
	}
	
	// 设置加载
	public final RestClientBuilder loader(Context context, LoaderStyle loaderStyle) {
		this.mContext = context;
		this.mRestData.setLOADER_STYLE(loaderStyle);
		return this;
	}
	
	public final RestClientBuilder loader(Context context) {
		this.mContext = context;
		this.mRestData.setLOADER_STYLE(CooderLoader.DEFAULT_LOADER);
		return this;
	}
	
	public final RestClient build() {
		return new RestClient(mContext, mRestData, mCallbackData);
	}
}