package com.cooder.core.net.interceptors;

import androidx.annotation.RawRes;
import com.cooder.core.util.file.FileUtil;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/15 15:14
 * 作者姓名：lijiawei
 * 功能介绍：debug拦截器
 */

public class DebugInterceptor extends BaseInterceptor {
	
	private final String DEBUG_URL;
	@RawRes
	private final int DEBUG_RAW_ID;
	
	public DebugInterceptor(String debugUrl, @RawRes int debugRawId) {
		this.DEBUG_URL = debugUrl;
		this.DEBUG_RAW_ID = debugRawId;
	}
	
	private Response getResponse(Chain chain, String json) {
		return new Response.Builder()
				.code(200)
				.addHeader("Content-Type", "application/json")
				.body(ResponseBody.create(json, MediaType.parse("application/json")))
				.message("OK")
				.request(chain.request())
				.protocol(Protocol.HTTP_2)
				.build();
	}
	
	private Response debugResponse(Chain chain, @RawRes int rawId) {
		final String json = FileUtil.getRawFile(rawId);
		return getResponse(chain, json);
	}
	
	@NotNull
	@Override
	public Response intercept(@NotNull Chain chain) throws IOException {
		final String url = chain.request().url().toString();
		if (url.contains(DEBUG_URL)) {
			return debugResponse(chain, DEBUG_RAW_ID);
		}
		return chain.proceed(chain.request());
	}
}