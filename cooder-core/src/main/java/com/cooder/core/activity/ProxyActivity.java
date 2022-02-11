package com.cooder.core.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ContentFrameLayout;
import com.cooder.core.R;
import com.cooder.core.delegate.CooderDelegate;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/11 10:19
 * 作者姓名：lijiawei
 * 功能介绍：代理Activity
 */

public abstract class ProxyActivity extends SupportActivity {
	
	// 委托
	public abstract CooderDelegate setRootDelegate();
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initContainer(savedInstanceState);
	}
	
	// 初始化容器
	@SuppressLint("RestrictedApi")
	private void initContainer(@Nullable Bundle saveInstanceState) {
		final ContentFrameLayout container = new ContentFrameLayout(this);
		container.setId(R.id.delegate_container);
		setContentView(container);
		if (saveInstanceState == null) {
			loadRootFragment(R.id.delegate_container, setRootDelegate());
		}
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		// 垃圾回收
		System.gc();
		System.runFinalization();
	}
}
