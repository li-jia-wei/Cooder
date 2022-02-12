package com.cooder.cooder.activity;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.cooder.cooder.R;
import com.cooder.core.delegate.CooderDelegate;
import com.cooder.core.net.RestClient;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/11 11:50
 * 作者姓名：lijiawei
 * 功能介绍：无
 */

public class ExampleDelegate extends CooderDelegate {
	
	@Override
	public Object sayLayout() {
		return R.layout.delegate_container;
	}
	
	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
	
	}
	
	// 测试代码
	private void testRestClient() {
		RestClient.builder()
				.url("")
				.params("", "")
				.success(response -> {
				
				}).failure(() -> {
				
				}).error((code, msg) -> {
				
				}).build();
	}
}
