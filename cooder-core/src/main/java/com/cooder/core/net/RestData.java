package com.cooder.core.net;

import android.content.Context;
import com.cooder.core.net.callback.IError;
import com.cooder.core.net.callback.IFailure;
import com.cooder.core.net.callback.IRequest;
import com.cooder.core.net.callback.ISuccess;
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
	private IRequest REQUEST;
	private ISuccess SUCCESS;
	private IFailure FAILURE;
	private IError ERROR;
	private RequestBody BODY;
	private LoaderStyle LOADER_STYLE;
	private File FILE;
	private Context CONTEXT;
	
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
	
	public IRequest getREQUEST() {
		return REQUEST;
	}
	
	public void setREQUEST(IRequest REQUEST) {
		this.REQUEST = REQUEST;
	}
	
	public ISuccess getSUCCESS() {
		return SUCCESS;
	}
	
	public void setSUCCESS(ISuccess SUCCESS) {
		this.SUCCESS = SUCCESS;
	}
	
	public IFailure getFAILURE() {
		return FAILURE;
	}
	
	public void setFAILURE(IFailure FAILURE) {
		this.FAILURE = FAILURE;
	}
	
	public IError getERROR() {
		return ERROR;
	}
	
	public void setERROR(IError ERROR) {
		this.ERROR = ERROR;
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
	
	public Context getCONTEXT() {
		return CONTEXT;
	}
	
	public void setCONTEXT(Context CONTEXT) {
		this.CONTEXT = CONTEXT;
	}
}
