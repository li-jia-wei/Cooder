package com.cooder.core.util.log;

import android.util.Log;
import com.cooder.core.R;
import com.cooder.core.global.Cooder;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/12 14:50
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：日志
 */

public class L {
	
	private static final class LogHolder {
		private static final String TAG = Cooder.getApplicationContext().getString(R.string.app_name);
		private static final boolean DEBUG = true;
	}
	
	public static void i(Object msg) {
		if (LogHolder.DEBUG) {
			Log.i(LogHolder.TAG, msg.toString());
		}
	}
	
	public static void e(Object msg) {
		if (LogHolder.DEBUG) {
			Log.e(LogHolder.TAG, msg.toString());
		}
	}
}
