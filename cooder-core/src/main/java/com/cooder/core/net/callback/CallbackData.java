package com.cooder.core.net.data;

import com.cooder.core.net.callback.IError;
import com.cooder.core.net.callback.IFailure;
import com.cooder.core.net.callback.IRequest;
import com.cooder.core.net.callback.ISuccess;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/13 21:32
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：无
 */

public class CallbackData {
	private IRequest request;
	private ISuccess success;
	private IFailure failure;
	private IError error;
	
	public CallbackData() {
	
	}
	
	public CallbackData(IRequest request, ISuccess success, IFailure failure, IError error) {
		this.request = request;
		this.success = success;
		this.failure = failure;
		this.error = error;
	}
	
	public IRequest getRequest() {
		return request;
	}
	
	public void setRequest(IRequest request) {
		this.request = request;
	}
	
	public ISuccess getSuccess() {
		return success;
	}
	
	public void setSuccess(ISuccess success) {
		this.success = success;
	}
	
	public IFailure getFailure() {
		return failure;
	}
	
	public void setFailure(IFailure failure) {
		this.failure = failure;
	}
	
	public IError getError() {
		return error;
	}
	
	public void setError(IError error) {
		this.error = error;
	}
}
