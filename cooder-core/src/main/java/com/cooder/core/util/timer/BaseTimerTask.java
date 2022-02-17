package com.cooder.core.util.timer;

import java.util.TimerTask;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/16 14:13
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：定时任务
 */

public class BaseTimerTask extends TimerTask {
	
	private ITimerListener mITimerListener = null;
	
	public BaseTimerTask(ITimerListener mITimerListener) {
		this.mITimerListener = mITimerListener;
	}
	
	@Override
	public void run() {
		if (mITimerListener != null) {
			mITimerListener.onTimer();
		}
	}
}
