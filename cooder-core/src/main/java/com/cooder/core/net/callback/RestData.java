package com.cooder.core.net.data;

import com.cooder.core.net.RestCreator;
import com.cooder.core.ui.LoaderStyle;
import okhttp3.RequestBody;

import java.io.File;
import java.util.Map;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/13 18:58
 * 作者姓名：lijiawei
 * 功能介绍：Rest参数
 */

public class RestData {
	private String url;
	private static final Map<String, Object> PARAMS = RestCreator.getParams();
	private RequestBody body;
	private LoaderStyle loaderStyle;
	private File file;
	
	public static void setPARAMS(String key, Object value) {
		PARAMS.put(key, value);
	}
	
	public static void setPARAMS(Map<String, Object> params) {
		PARAMS.putAll(params);
	}
	
	public static Map<String, Object> getPARAMS() {
		return PARAMS;
	}
	
	public static Object getPARAMS(String key) {
		return PARAMS.get(key);
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public RequestBody getBody() {
		return body;
	}
	
	public void setBody(RequestBody body) {
		this.body = body;
	}
	
	public LoaderStyle getLoaderStyle() {
		return loaderStyle;
	}
	
	public void setLoaderStyle(LoaderStyle loaderStyle) {
		this.loaderStyle = loaderStyle;
	}
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
}
