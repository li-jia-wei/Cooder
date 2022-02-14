package com.cooder.core.app;

import android.content.Context;

import java.util.HashMap;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/11 10:20
 * 作者姓名：lijiawei
 * 功能介绍：无
 */

public class Cooder {
	
	// 初始化
	public static Configurator init(Context context) {
		getConfigurator().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
		return Configurator.getInstance();
	}
	
	// 获取配置信息
	public static HashMap<String, Object> getConfigurator() {
		return Configurator.getInstance().getCooderConfigs();
	}
	
	// 获取Application
	public static Context getApplicationContext() {
		return (Context) getConfigurator().get(ConfigType.APPLICATION_CONTEXT.name());
	}
}
