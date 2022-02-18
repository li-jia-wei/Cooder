package com.cooder.app.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.cooder.core.activity.ProxyActivity;
import com.cooder.core.delegate.CooderDelegate;
import com.cooder.ec.sign.SignUpDelegate;

public class ExampleActivity extends ProxyActivity {
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public CooderDelegate setRootDelegate() {
		return new SignUpDelegate();
	}
}