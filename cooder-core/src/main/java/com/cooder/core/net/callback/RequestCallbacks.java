package com.cooder.core.net.callback;

import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/12 11:12
 * 作者姓名：lijiawei
 * 功能介绍：请求回调函数
 */

public class RequestCallbacks implements Callback<String> {
	
	private final IRequest REQUEST;
	private final ISuccess SUCCESS;
	private final IFailure FAILURE;
	private final IError ERROR;
	
	public RequestCallbacks(IRequest request, ISuccess success, IFailure failure, IError error) {
		REQUEST = request;
		SUCCESS = success;
		FAILURE = failure;
		ERROR = error;
	}
	
	@Override
	public void onResponse(@NotNull Call<String> call, Response<String> response) {
		if (response.isSuccessful()) {
			if (call.isExecuted()) {
				if (SUCCESS != null) {
					SUCCESS.onSuccess(response.body());
				}
			}
		} else {
			if (ERROR != null) {
				ERROR.onError(response.code(), response.message());
			}
		}
	}
	
	@Override
	public void onFailure(@NotNull Call<String> call, @NotNull Throwable t) {
		if (FAILURE != null) {
			FAILURE.onFailure();
		}
		if (REQUEST != null) {
			REQUEST.onRequestEnd();
		}
	}
}