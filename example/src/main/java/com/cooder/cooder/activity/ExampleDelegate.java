package com.cooder.cooder.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.cooder.cooder.R;
import com.cooder.core.delegate.CooderDelegate;
import com.cooder.core.net.RestClient;
import com.cooder.core.util.log.L;

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
		testRestClient();
	}
	
	// 测试代码
	private void testRestClient() {
		RestClient.builder()
				.url("http://news.baidu.com/")
				.loader(getContext())
				.success(response -> {
					L.i(response);
				})
				.failure(() -> {
				
				})
				.error((code, msg) -> {
					Toast.makeText(getContext(), code + " : " + msg, Toast.LENGTH_LONG).show();
				})
				.dir("")
				.extension("")
				.build()
				.get();
	}
}
