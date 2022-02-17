package com.cooder.app.delegate;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.cooder.app.R;
import com.cooder.core.delegate.CooderDelegate;
import com.cooder.core.net.RestClient;
import com.cooder.core.util.log.L;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/11 11:50
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：测试类
 */

public class ExampleDelegate extends CooderDelegate {
	
	@Override
	public Object sayLayout() {
		return R.layout.delegate_container;
	}
	
	@Override
	public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
//		testRestClient();
	}
	
	// 测试代码
	private void testRestClient() {
		RestClient.builder()
				.url("http://127.0.0.1/index")
				.loader(getContext())
				.success(response -> {
					L.i(response);
				})
				.failure(() -> {
					L.e("failure");
				})
				.error((code, msg) -> {
					L.e(code + ": " + msg);
				})
				.dir("")
				.extension("")
				.build()
				.get();
	}
}