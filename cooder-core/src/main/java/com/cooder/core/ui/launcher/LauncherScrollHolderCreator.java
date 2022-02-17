package com.cooder.core.ui.launcher;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/17 13:55
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：启动滚动图创建者
 */

public class LauncherScrollHolderCreator implements CBViewHolderCreator<LauncherScrollHolder> {
	
	@Override
	public LauncherScrollHolder createHolder() {
		return new LauncherScrollHolder();
	}
}
