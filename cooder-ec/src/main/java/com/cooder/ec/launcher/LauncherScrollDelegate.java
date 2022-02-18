package com.cooder.ec.launcher;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bigkoo.convenientbanner.listener.OnPageChangeListener;
import com.cooder.core.delegate.CooderDelegate;
import com.cooder.ec.R;
import com.cooder.ec.R2;

import java.util.ArrayList;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/17 13:30
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：首次加载滚动页
 */

@SuppressLint("NonConstantResourceId")
public class LauncherScrollDelegate extends CooderDelegate implements OnItemClickListener, OnPageChangeListener {
	
	@BindView(R2.id.cb_scroll)
	ConvenientBanner<Integer> mConvenientBanner = null;
	
	private static final ArrayList<Integer> INTEGERS = new ArrayList<>();
	
	private void initBanner() {
		INTEGERS.add(R.drawable.launcher_scroll_1);
		INTEGERS.add(R.drawable.launcher_scroll_2);
		INTEGERS.add(R.drawable.launcher_scroll_3);
		INTEGERS.add(R.drawable.launcher_scroll_4);
		INTEGERS.add(R.drawable.launcher_scroll_5);
		INTEGERS.add(R.drawable.launcher_scroll_6);
		
		mConvenientBanner
				.setPages(new LauncherScrollHolderCreator(), INTEGERS)
				.setPageIndicator(new int[]{R.drawable.launcher_scroll_dot_off, R.drawable.launcher_scroll_dot_on})
				.setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
				.setOnPageChangeListener(this)
				.setCanLoop(false);
	}
	
	@Override
	public Object sayLayout() {
		return R.layout.delegate_launcher_scroll;
	}
	
	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
		initBanner();
	}
	
	@Override
	public void onItemClick(int position) {
	
	}
	
	@Override
	public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
	
	}
	
	@Override
	public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
	
	}
	
	@Override
	public void onPageSelected(int index) {
	
	}
}