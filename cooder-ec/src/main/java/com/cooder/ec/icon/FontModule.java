package com.cooder.ec.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/11 10:11
 * 作者姓名：lijiawei
 * 功能介绍：图标组件
 */

public class FontModule implements IconFontDescriptor {
	
	@Override
	public String ttfFileName() {
		return "iconfont1.ttf";
	}
	
	@Override
	public Icon[] characters() {
		return Icons.values();
	}
}
