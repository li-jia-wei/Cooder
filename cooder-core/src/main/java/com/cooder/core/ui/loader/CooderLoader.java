package com.cooder.core.ui.loader;

import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialog;
import com.cooder.core.R;
import com.cooder.core.util.screen.ScreenUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/13 09:47
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：Cooder加载
 */

public class CooderLoader {
	
	private static final int LOADER_SIZE = 9;
	private static final int LOADER_OFFSET_SCALE = 5;
	
	// 加载Dialog集合
	private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();
	
	// 默认动画
	public static final Enum<LoaderStyle> DEFAULT_LOADER = LoaderStyle.BallPulseIndicator;
	
	// 开始动画
	public static void showLoading(Context context, String type) {
		final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);
		final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(type, context);
		dialog.setContentView(avLoadingIndicatorView);
		final int width = ScreenUtil.getWidthPixels();
		final int height = ScreenUtil.getHeightPixels();
		final Window dialogWindow = dialog.getWindow();
		
		if (dialogWindow != null) {
			WindowManager.LayoutParams lp = dialogWindow.getAttributes();
			lp.width = width / LOADER_SIZE;
			lp.height = height / LOADER_SIZE;
			lp.height += height / LOADER_OFFSET_SCALE;
			lp.gravity = Gravity.CENTER;
		}
		LOADERS.add(dialog);
		dialog.show();
	}
	
	public static void showLoading(Context context, Enum<LoaderStyle> type) {
		showLoading(context, type.name());
	}
	
	public static void showLoading(Context context) {
		showLoading(context, DEFAULT_LOADER.name());
	}
	
	// 停止动画
	public static void stopLoading() {
		for (AppCompatDialog dialog : LOADERS) {
			if (dialog != null) {
				if (dialog.isShowing()) {
					dialog.cancel();
				}
			}
		}
	}
}
