package com.cooder.ec.launcher;

import android.view.View;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.cooder.ec.R;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/17 13:55
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：启动滚动图创建者
 */

public class LauncherScrollHolderCreator implements CBViewHolderCreator {
	
	@Override
	public LauncherScrollHolder createHolder(View itemView) {
		return new LauncherScrollHolder(itemView);
	}
	
	@Override
	public int getLayoutId() {
		return R.layout.item_scroll;
	}
}
