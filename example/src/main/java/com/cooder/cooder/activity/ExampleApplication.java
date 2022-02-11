package com.cooder.cooder.activity;

import android.app.Application;
import com.cooder.core.app.Cooder;
import com.cooder.ec.icon.FontModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/11 10:47
 * 作者姓名：lijiawei
 * 功能介绍：无
 */

public class ExampleApplication extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		// 配置初始化信息
		Cooder.init(this)
				.withApiHost("http://127.0.0.1/")
				.withIcon(new FontAwesomeModule())
				.withIcon(new FontModule())
				.configure();
	}
}
