package com.cooder.core.net;

import android.content.Context;
import com.cooder.core.net.callback.IError;
import com.cooder.core.net.callback.IFailure;
import com.cooder.core.net.callback.IRequest;
import com.cooder.core.net.callback.ISuccess;
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
	
	private final RestData RESTDATA;
	
	RestClientBuilder() {
		this.RESTDATA = new RestData();
	}
	
	// 设置url
	public final RestClientBuilder url(String url) {
		this.RESTDATA.setURL(url);
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
		this.RESTDATA.setFILE(file);
		return this;
	}
	
	public final RestClientBuilder file(String url) {
		this.RESTDATA.setFILE(new File(url));
		return this;
	}
	
	// 设置raw
	@SuppressWarnings("deprecation")
	public final RestClientBuilder raw(String raw) {
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
		this.RESTDATA.setBODY(requestBody);
		return this;
	}
	
	// 请求回调
	public final RestClientBuilder onRequest(IRequest iRequest) {
		this.RESTDATA.setREQUEST(iRequest);
		return this;
	}
	
	// 请求成功回调
	public final RestClientBuilder success(ISuccess iSuccess) {
		this.RESTDATA.setSUCCESS(iSuccess);
		return this;
	}
	
	// 请求失败回调
	public final RestClientBuilder failure(IFailure iFailure) {
		this.RESTDATA.setFAILURE(iFailure);
		return this;
	}
	
	// 请求报错回调
	public final RestClientBuilder error(IError iError) {
		this.RESTDATA.setERROR(iError);
		return this;
	}
	
	// 设置加载
	public final RestClientBuilder loader(Context context, LoaderStyle loaderStyle) {
		this.RESTDATA.setCONTEXT(context);
		this.RESTDATA.setLOADER_STYLE(loaderStyle);
		return this;
	}
	
	public final RestClientBuilder loader(Context context) {
		this.RESTDATA.setCONTEXT(context);
		this.RESTDATA.setLOADER_STYLE(CooderLoader.DEFAULT_LOADER);
		return this;
	}
	
	public final RestClient build() {
		return new RestClient(RESTDATA);
	}
}