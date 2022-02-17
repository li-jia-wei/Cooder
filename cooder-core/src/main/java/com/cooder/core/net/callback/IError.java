package com.cooder.core.net.callback;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/12 06:36
 * 作者姓名：lijiawei
 * 文件类型：接口
 * 功能介绍：请求错误回调
 */

public interface IError {
	
	void onError(int code, String msg);
}
