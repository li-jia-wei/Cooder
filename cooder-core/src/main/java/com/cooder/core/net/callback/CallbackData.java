package com.cooder.core.net.callback;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/13 21:32
 * 作者姓名：lijiawei
 * 功能介绍：无
 */

public class CallbackData {
	private IRequest REQUEST;
	private ISuccess SUCCESS;
	private IFailure FAILURE;
	private IError ERROR;
	
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
}
