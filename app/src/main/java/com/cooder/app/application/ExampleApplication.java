package com.cooder.app.application;

import android.app.Application;
import com.cooder.app.R;
import com.cooder.core.global.Cooder;
import com.cooder.core.net.interceptors.DebugInterceptor;
import com.cooder.ec.icon.FontModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/11 10:47
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：ExampleApplication
 */

public class ExampleApplication extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		// 配置初始化信息
		Cooder.init(this)
				.withApiHost("http://127.0.0.1/")
				.withLoaderDelayed(1000)
				.withIcon(new FontAwesomeModule())
				.withIcon(new FontModule())
				.withInterceptor(new DebugInterceptor("index", R.raw.test))
				.configure();
	}
}