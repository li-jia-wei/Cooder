package com.cooder.core.net.download;

import android.os.AsyncTask;
import com.cooder.core.net.RestCreator;
import com.cooder.core.net.callback.IError;
import com.cooder.core.net.callback.IFailure;
import com.cooder.core.net.callback.IRequest;
import com.cooder.core.net.callback.ISuccess;
import com.cooder.core.net.data.CallbackData;
import com.cooder.core.net.data.DownloadData;
import com.cooder.core.net.data.RestData;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Map;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/13 21:32
 * 作者姓名：lijiawei
 * 功能介绍：下载处理
 */

public class DownloadHandler {
	
	private final String URL;
	private static final Map<String, Object> PARAMS = RestData.getPARAMS();
	private final IRequest REQUEST;
	private final ISuccess SUCCESS;
	private final IFailure FAILURE;
	private final IError ERROR;
	private final String DOWNLOAD_DIR;
	private final String EXTENSION;
	private final String NAME;
	
	public DownloadHandler(String url, CallbackData callbackData, DownloadData downloadData) {
		this.URL = url;
		this.REQUEST = callbackData.getRequest();
		this.SUCCESS = callbackData.getSuccess();
		this.FAILURE = callbackData.getFailure();
		this.ERROR = callbackData.getError();
		this.DOWNLOAD_DIR = downloadData.getDownloadDir();
		this.EXTENSION = downloadData.getExtension();
		this.NAME = downloadData.getName();
	}
	
	public final void handleDownload() {
		if (REQUEST != null) {
			REQUEST.onRequestStart();
		}
		RestCreator.getRestService()
				.downloads(URL, PARAMS)
				.enqueue(new Callback<ResponseBody>() {
					@SuppressWarnings("deprecation")
					@Override
					public void onResponse(@NotNull Call<ResponseBody> call, @NotNull Response<ResponseBody> response) {
						if (response.isSuccessful()) {
							final SaveFileTask task = new SaveFileTask(REQUEST, SUCCESS);
							ResponseBody responseBody = response.body();
							task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, DOWNLOAD_DIR, EXTENSION, responseBody, NAME);
							// 一定要判断，否则文件下载不全
							if (task.isCancelled()) {
								if (REQUEST != null) {
									REQUEST.onRequestEnd();
								}
							}
						} else {
							if (ERROR != null) {
								ERROR.onError(response.code(), response.message());
							}
						}
					}
					
					@Override
					public void onFailure(@NotNull Call<ResponseBody> call, @NotNull Throwable t) {
						if (FAILURE != null) {
							FAILURE.onFailure();
						}
					}
				});
	}
}
