package com.cooder.ec.launcher;

import android.view.View;
import android.widget.ImageView;
import com.bigkoo.convenientbanner.holder.Holder;
import com.cooder.ec.R;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/17 13:56
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：首次滚动图
 */

public class LauncherScrollHolder extends Holder<Integer> {
	
	private ImageView mImageView;
	
	public LauncherScrollHolder(View itemView) {
		super(itemView);
	}
	
	@Override
	protected void initView(View itemView) {
		mImageView = itemView.findViewById(R.id.iv_scroll);
	}
	
	@Override
	public void updateUI(Integer data) {
		mImageView.setImageResource(data);
	}
}