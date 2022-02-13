package com.cooder.core.util;

import android.util.Log;
import com.cooder.core.R;
import com.cooder.core.app.Cooder;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/12 14:50
 * 作者姓名：lijiawei
 * 功能介绍：日志
 */

public class L {
	
	private static final class LogHolder {
		private static final String TAG = Cooder.getApplication().getString(R.string.app_name);
		private static final boolean DEBUG = true;
	}
	
	public static void i(String msg) {
		if (LogHolder.DEBUG) {
			Log.i(LogHolder.TAG, msg);
		}
	}
}
