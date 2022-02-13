package com.cooder.core.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.cooder.core.app.Cooder;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/13 12:25
 * 作者姓名：lijiawei
 * 功能介绍：屏幕工具
 */

public class Screen {
	
	// 获得屏幕的宽度
	public static int getWidthPixels() {
		final Resources resources = Cooder.getApplication().getResources();
		final DisplayMetrics dm = resources.getDisplayMetrics();
		return dm.widthPixels;
	}
	
	// 获得屏幕的高度
	public static int getHeightPixels() {
		final Resources resources = Cooder.getApplication().getResources();
		final DisplayMetrics dm = resources.getDisplayMetrics();
		return dm.heightPixels;
	}
	
	// 获得屏幕的宽度的dpi
	public static float getXdpi() {
		final Resources resources = Cooder.getApplication().getResources();
		final DisplayMetrics dm = resources.getDisplayMetrics();
		return dm.xdpi;
	}
	
	// 获得屏幕的高度的dpi
	public static float getYdpi() {
		final Resources resources = Cooder.getApplication().getResources();
		final DisplayMetrics dm = resources.getDisplayMetrics();
		return dm.ydpi;
	}
}