package com.cooder.core.global;

import android.content.Context;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/11 10:20
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：Cooder
 */

public class Cooder {
	
	// 初始化
	public static Configurator init(Context context) {
		// 配置全局上下文
		setConfiguration(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
		return getConfigurator();
	}
	
	// 获取配置实例
	private static Configurator getConfigurator() {
		return Configurator.getInstance();
	}
	
	// 设置参数
	public static void setConfiguration(Object key, Object value) {
		getConfigurator().getCooderConfigs().put(key, value);
	}
	
	// 设置加载延迟
	public static void setLoaderDelayed(int millisecond) {
		setConfiguration(ConfigKeys.LOADER_DELAYED, millisecond);
	}
	
	// 获取配置信息
	public static <T> T getConfiguration(Object key) {
		return getConfigurator().getConfiguration(key);
	}
	
	// 获取Application
	public static Context getApplicationContext() {
		return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
	}
	
	// 获取加载信息
	public static int getLoaderDelayed() {
		return getConfiguration(ConfigKeys.LOADER_DELAYED);
	}
	
	// 获取请求域名
	public static String getApiHost() {
		return getConfiguration(ConfigKeys.API_HOST);
	}
	
	// 获取拦截器
	public static <T> T getInterceptors() {
		return getConfiguration(ConfigKeys.INTERCEPTOR);
	}
}
