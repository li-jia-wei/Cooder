package com.cooder.core.net;

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
	private String URL;
	private static final Map<String, Object> PARAMS = RestCreator.getParams();
	private RequestBody BODY;
	private LoaderStyle LOADER_STYLE;
	private File FILE;
	
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
	
	public String getURL() {
		return URL;
	}
	
	public void setURL(String URL) {
		this.URL = URL;
	}
	
	public RequestBody getBODY() {
		return BODY;
	}
	
	public void setBODY(RequestBody BODY) {
		this.BODY = BODY;
	}
	
	public LoaderStyle getLOADER_STYLE() {
		return LOADER_STYLE;
	}
	
	public void setLOADER_STYLE(LoaderStyle LOADER_STYLE) {
		this.LOADER_STYLE = LOADER_STYLE;
	}
	
	public File getFILE() {
		return FILE;
	}
	
	public void setFILE(File FILE) {
		this.FILE = FILE;
	}
}
