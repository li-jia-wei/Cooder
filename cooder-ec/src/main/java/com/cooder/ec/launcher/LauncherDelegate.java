package com.cooder.ec.launcher;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.cooder.core.delegate.CooderDelegate;
import com.cooder.core.util.storage.CooderPreference;
import com.cooder.core.util.storage.PreferenceKeys;
import com.cooder.core.util.timer.BaseTimerTask;
import com.cooder.core.util.timer.ITimerListener;
import com.cooder.ec.R;
import com.cooder.ec.R2;

import java.text.MessageFormat;
import java.util.Timer;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/16 14:12
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：启动页
 */

@SuppressLint("NonConstantResourceId")
public class LauncherDelegate extends CooderDelegate implements ITimerListener {
	
	@BindView(R2.id.tv_launcher_timer)
	AppCompatTextView mTvLauncherTimer = null;
	
	private Timer mTimer = null;
	private int mCount = 3;
	
	@Override
	public Object sayLayout() {
		return R.layout.delegate_launcher;
	}
	
	@Override
	public void onBindView(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState, View rootView) {
		initTimer();
	}
	
	// 收否展示滚动图
	private void checkIsShowScroll() {
		
		if (!CooderPreference.getAppFlag(PreferenceKeys.LAUNCHER_APP_HAS_NOT_FIRST)) {   // 第一次登录
			start(new LauncherScrollDelegate(), SINGLETASK);
			
		} else {
			// 检查用户是否登录
			Toast.makeText(getContext(), "不是第一次登录", Toast.LENGTH_SHORT).show();
		}
	}
	
	// 初始化Timer
	private void initTimer() {
		mTimer = new Timer();
		final BaseTimerTask task = new BaseTimerTask(this);
		mTimer.schedule(task, 0, 1000);
	}
	
	@OnClick(R2.id.tv_launcher_timer)
	void onClickTimerView() {
		if (mTimer != null) {
			mTimer.cancel();
			mTimer = null;
		}
		checkIsShowScroll();
	}
	
	@Override
	public void onTimer() {
		getProxyActivity().runOnUiThread(() -> {
			if (mTvLauncherTimer != null) {
				mTvLauncherTimer.setText(MessageFormat.format("{0}s | 跳过", mCount));
				mCount--;
				if (mCount < 0) {
					if (mTimer != null) {
						mTimer.cancel();
						mTimer = null;
						// 检查是否展示滚动图
						checkIsShowScroll();
					}
				}
			}
		});
	}
}
