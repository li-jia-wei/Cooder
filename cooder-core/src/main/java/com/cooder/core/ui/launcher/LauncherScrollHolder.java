package com.cooder.core.ui.launcher;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bigkoo.convenientbanner.holder.Holder;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/17 13:56
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：首次滚动图
 */

public class LauncherScrollHolder implements Holder<Integer> {
	
	private ImageView mImageView;
	
	@Override
	public View createView(Context context) {
		mImageView = new ImageView(context);
		return mImageView;
	}
	
	@Override
	public void UpdateUI(Context context, int position, Integer data) {
		mImageView.setImageResource(data);
	}
}