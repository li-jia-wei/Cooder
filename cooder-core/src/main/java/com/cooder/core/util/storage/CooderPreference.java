package com.cooder.core.util.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cooder.core.global.Cooder;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/15 20:55
 * 作者姓名：lijiawei
 * 文件类型：类
 * 功能介绍：持久化存储
 */

public final class CooderPreference {
	
	private static final String APP_PREFERENCES_NAME = "configs";
	
	// Preference
	private static class PreferenceHolder {
		private static final SharedPreferences PREFERENCES = Cooder.getApplicationContext().getSharedPreferences(APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
	}
	
	// 基础的方法
	private static class ElementMethod {
		private static SharedPreferences getPreferenceGetter() {
			return PreferenceHolder.PREFERENCES;
		}
		
		private static SharedPreferences.Editor getPreferencePutter() {
			return PreferenceHolder.PREFERENCES.edit();
		}
		
		private static void setInt(Enum<PreferenceKeys> key, int value) {
			getPreferencePutter().putInt(key.name(), value).apply();
		}
		
		private static int getInt(Enum<PreferenceKeys> key, int defaultValue) {
			return getPreferenceGetter().getInt(key.name(), defaultValue);
		}
		
		private static void setString(Enum<PreferenceKeys> key, String value) {
			getPreferencePutter().putString(key.name(), value).apply();
		}
		
		private static String getString(Enum<PreferenceKeys> key, String defaultValue) {
			return getPreferenceGetter().getString(key.name(), defaultValue);
		}
		
		private static void setBoolean(Enum<PreferenceKeys> key, boolean value) {
			getPreferencePutter().putBoolean(key.name(), value).apply();
		}
		
		private static boolean getBoolean(Enum<PreferenceKeys> key, boolean defaultValue) {
			return getPreferenceGetter().getBoolean(key.name(), defaultValue);
		}
		
		private static void remove(Enum<PreferenceKeys> key) {
			getPreferencePutter().remove(key.name()).apply();
		}
		
		private static void clear() {
			getPreferencePutter().clear().apply();
		}
	}
	
	public static void setAppProfile(String value) {
		ElementMethod.setString(PreferenceKeys.APP_PREFERENCES_KEY, value);
	}
	
	public static String getAppProfile() {
		return ElementMethod.getString(PreferenceKeys.APP_PREFERENCES_KEY, null);
	}
	
	public static void removeAppProfile() {
		ElementMethod.remove(PreferenceKeys.APP_PREFERENCES_KEY);
	}
	
	public static void clearAppPreferences() {
		ElementMethod.clear();
	}
	
	public static JSONObject getAppProfileJson() {
		final String profile = getAppProfile();
		return JSON.parseObject(profile);
	}
	
	public static void setAppFlag(Enum<PreferenceKeys> key, boolean flag) {
		ElementMethod.setBoolean(key, flag);
	}
	
	public static boolean getAppFlag(Enum<PreferenceKeys> key) {
		return ElementMethod.getBoolean(key, false);
	}
	
	public static void setCustomAppProfile(Enum<PreferenceKeys> key, String value) {
		ElementMethod.setString(key, value);
	}
	
	public static String getCustomAppProfile(Enum<PreferenceKeys> key) {
		return ElementMethod.getString(key, null);
	}
	
	public static void setParameterAppProfile(Enum<PreferenceKeys> key, int value) {
		ElementMethod.setInt(key, value);
	}
	
	public static int getParameterAppProfile(Enum<PreferenceKeys> key) {
		return ElementMethod.getInt(key, 0);
	}
	
	public static void removeCustomAppProfile(Enum<PreferenceKeys> key) {
		ElementMethod.remove(key);
	}
}