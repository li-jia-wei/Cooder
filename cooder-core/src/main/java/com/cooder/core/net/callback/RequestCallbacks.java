package com.cooder.core.net.callback;

import android.os.Handler;
import android.os.Looper;
import com.cooder.core.global.Cooder;
import com.cooder.core.net.data.CallbackData;
import com.cooder.core.ui.loader.CooderLoader;
import com.cooder.core.ui.loader.LoaderStyle;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/12 11:12
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：请求回调函数
 */

public class RequestCallbacks implements Callback<String> {
	
	private final IRequest REQUEST;
	private final ISuccess SUCCESS;
	private final IFailure FAILURE;
	private final IError ERROR;
	private final Enum<LoaderStyle> LOADER_STYLE;
	private static final Handler HANDLER = new Handler(Looper.myLooper());
	
	public RequestCallbacks(CallbackData callbackData, Enum<LoaderStyle> style) {
		this.REQUEST = callbackData.getRequest();
		this.SUCCESS = callbackData.getSuccess();
		this.FAILURE = callbackData.getFailure();
		this.ERROR = callbackData.getError();
		this.LOADER_STYLE = style;
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
		stopLoading();
		
	}
	
	@Override
	public void onFailure(@NotNull Call<String> call, @NotNull Throwable t) {
		if (FAILURE != null) {
			FAILURE.onFailure();
		}
		if (REQUEST != null) {
			REQUEST.onRequestEnd();
		}
		stopLoading();
	}
	
	private void stopLoading() {
		if (LOADER_STYLE != null) {
			HANDLER.postDelayed(() -> {
				CooderLoader.stopLoading();
			}, Cooder.getLoaderDelayed());
		}
	}
}