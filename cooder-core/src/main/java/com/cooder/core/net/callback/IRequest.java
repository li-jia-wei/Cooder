package com.cooder.core.net.callback;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/12 06:45
 * 作者姓名：lijiawei
 * 文件类型：接口
 * 功能介绍：无
 */

public interface IRequest {
	
	void onRequestStart();
	
	void onRequestEnd();
}
