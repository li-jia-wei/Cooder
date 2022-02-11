package com.cooder.core.net;

import com.cooder.core.app.ConfigType;
import com.cooder.core.app.Cooder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/12 03:42
 * 作者姓名：lijiawei
 * 功能介绍：无
 */

public class RestCreator {
	
	// 惰性加载
	private static final class ParamsHolder {
		public static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
	}
	
	public static WeakHashMap<String, Object> getParams() {
		return ParamsHolder.PARAMS;
	}
	
	// 获取rest服务
	public static RestService getRestService() {
		return RestServiceHolder.REST_SERVICE;
	}
	
	// retrofit
	private static final class RetrofitHolder {
		
		// 获取API
		private static final String BASE_URL = (String) Cooder.getConfigurator().get(ConfigType.API_HOST.name());
		// RETROFIT
		@SuppressWarnings("ConstantConditions")
		private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.client(OkHttpHolder.OK_HTTP_CLIENT)
				.addConverterFactory(ScalarsConverterFactory.create())
				.build();
	}
	
	// okhttp
	private static final class OkHttpHolder {
		private static final int TIME_OUT = 60;
		private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
				.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
				.build();
	}

	// rest服务
	private static final class RestServiceHolder {
		private static final RestService REST_SERVICE = RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
	}
}