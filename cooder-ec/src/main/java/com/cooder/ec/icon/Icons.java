package com.cooder.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/11 10:12
 * 作者姓名：lijiawei
 * 文件类型：枚举
 * 功能介绍：图标
 */

public enum Icons implements Icon {
	ic_qr_code('\ue704'),
	ic_scanning('\ue762');
	
	private final char character;
	
	Icons(char character) {
		this.character = character;
	}
	
	@Override
	public String key() {
		return name().replace('_', '-');
	}
	
	@Override
	public char character() {
		return character;
	}
}
