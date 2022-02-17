package com.cooder.ec.launcher;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.cooder.core.delegate.CooderDelegate;
import com.cooder.core.ui.launcher.LauncherScrollHolderCreator;
import com.cooder.core.util.log.L;
import com.cooder.core.util.storage.CooderPreference;
import com.cooder.core.util.storage.PreferenceKeys;
import com.cooder.ec.R;

import java.util.ArrayList;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/17 13:30
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：首次加载滚动页
 */

public class LauncherScrollDelegate extends CooderDelegate implements OnItemClickListener {
	
	private ConvenientBanner<Integer> mConvenientBanner = null;
	
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
				.setOnItemClickListener(this)
				.setCanLoop(false);
	}
	
	@Override
	public Object sayLayout() {
		mConvenientBanner = new ConvenientBanner<>(getContext());
		return mConvenientBanner;
	}
	
	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
		initBanner();
	}
	
	@Override
	public void onItemClick(int position) {
		// 如果点击的是最后一个
		if (position == INTEGERS.size() - 1) {
			L.i(position);
			CooderPreference.setAppFlag(PreferenceKeys.LAUNCHER_APP_HAS_NOT_FIRST, true);
			// 检查用户是否已经登录
			
		}
	}
}