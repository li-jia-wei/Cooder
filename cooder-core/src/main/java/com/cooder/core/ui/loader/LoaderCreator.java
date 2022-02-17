package com.cooder.core.ui.loader;

import android.content.Context;
import com.wang.avi.AVLoadingIndicatorView;
import com.wang.avi.Indicator;

import java.util.Objects;
import java.util.WeakHashMap;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/13 09:32
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：加载创建者
 */

public final class LoaderCreator {
	
	private static final WeakHashMap<String, Indicator> LOADING_MAP = new WeakHashMap<>();
	
	static AVLoadingIndicatorView create(String type, Context context) {
		final AVLoadingIndicatorView avLoadingIndicatorView = new AVLoadingIndicatorView(context);
		if (LOADING_MAP.get(type) == null) {
			final Indicator indicator = getIndicator(type);
			LOADING_MAP.put(type, indicator);
		}
		avLoadingIndicatorView.setIndicator(LOADING_MAP.get(type));
		return avLoadingIndicatorView;
	}
	
	private static Indicator getIndicator(String name) {
		if (name == null || name.isEmpty()) {
			return null;
		}
		final StringBuilder drawableClassName = new StringBuilder();
		if (!name.contains(".")) {
			final String defaultPackageName = Objects.requireNonNull(AVLoadingIndicatorView.class.getPackage()).getName();
			drawableClassName.append(defaultPackageName)
					.append(".indicators")
					.append(".");
		}
		drawableClassName.append(name);
		try {
			final Class<?> drawableClass = Class.forName(drawableClassName.toString());
			return (Indicator) drawableClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
