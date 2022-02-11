package com.cooder.core.delegate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.cooder.core.net.RestClientBuilder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/11 10:57
 * 作者姓名：lijiawei
 * 功能介绍：Delegate基类
 */

public abstract class BaseDelegate extends SwipeBackFragment {
	
	private Unbinder mUnbinder = null;
	
	public abstract Object sayLayout();
	
	public abstract void onBindView(@Nullable Bundle savedInstanceState, View rootView);
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = null;
		if (sayLayout() instanceof Integer) {
			rootView = inflater.inflate((Integer) sayLayout(), container, false);
		} else if (sayLayout() instanceof View) {
			rootView = (View) sayLayout();
		}
		if (rootView != null) {
			mUnbinder = ButterKnife.bind(this, rootView);
			onBindView(savedInstanceState, rootView);
		}
		return rootView;
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		// 解除绑定
		if (mUnbinder != null) {
			mUnbinder.unbind();
		}
	}
}
