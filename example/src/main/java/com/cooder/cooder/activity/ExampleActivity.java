package com.cooder.cooder.activity;

import com.cooder.core.activity.ProxyActivity;
import com.cooder.core.delegate.CooderDelegate;

public class ExampleActivity extends ProxyActivity {
	
	@Override
	public CooderDelegate setRootDelegate() {
		return new ExampleDelegate();
	}
}