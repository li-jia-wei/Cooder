package com.cooder.core.net.interceptors;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/15 14:04
 * 作者姓名：lijiawei
 * 文件类型：抽象类
 * 功能介绍：拦截器
 */

public abstract class BaseInterceptor implements Interceptor {
	
	@NotNull
	@Override
	public Response intercept(@NotNull Chain chain) throws IOException {
		return null;
	}
	
	protected LinkedHashMap<String, String> getUrlParameters(Chain chain) {
		final HttpUrl url = chain.request().url();
		// 获取url个数
		int size = url.querySize();
		final LinkedHashMap<String, String> params = new LinkedHashMap<>();
		for (int i = 0; i < size; i++) {
			params.put(url.queryParameterName(i), url.queryParameterValue(i));
		}
		return params;
	}
	
	protected String getUrlParameters(Chain chain, String key) {
		final Request request = chain.request();
		return request.url().queryParameter(key);
	}
	
	protected LinkedHashMap<String, String> getBodyParameters(Chain chain) {
		final FormBody formBody = (FormBody) chain.request().body();
		int size = 0;
		if (formBody != null) {
			size = formBody.size();
		}
		final LinkedHashMap<String, String> params = new LinkedHashMap<>();
		for (int i = 0; i < size; i++) {
			params.put(formBody.name(i), formBody.value(i));
		}
		return params;
	}
	
	protected String getBodyParameters(Chain chain, String key) {
		return getBodyParameters(chain).get(key);
	}
}