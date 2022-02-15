package com.cooder.core.util.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.cooder.core.global.Cooder;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/15 20:55
 * 作者姓名：lijiawei
 * 功能介绍：持久化存储
 */

public final class CooderPreference {
	
	private static final String APP_PREFERENCES_NAME = "configs";
	
	// Preference
	private static class PreferenceHolder {
		private static final SharedPreferences PREFERENCES = Cooder.getApplicationContext().getSharedPreferences(APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
	}
	
	// 基础的方法
	public static class Element {
		private static SharedPreferences getPreferenceGetter() {
			return PreferenceHolder.PREFERENCES;
		}
		
		private static SharedPreferences.Editor getPreferencePutter() {
			return PreferenceHolder.PREFERENCES.edit();
		}
		
		public static void setInt(Enum<PreferenceKeys> key, int value) {
			getPreferencePutter().putInt(key.name(), value);
		}
		
		public static int getInt(Enum<PreferenceKeys> key, int defaultValue) {
			return getPreferenceGetter().getInt(key.name(), defaultValue);
		}
		
		public static void setLong(Enum<PreferenceKeys> key, long value) {
			getPreferencePutter().putLong(key.name(), value);
		}
		
		public static long getLong(Enum<PreferenceKeys> key, long defaultValue) {
			return getPreferenceGetter().getLong(key.name(), defaultValue);
		}
		
		public static void setFloat(Enum<PreferenceKeys> key, float value) {
			getPreferencePutter().putFloat(key.name(), value);
		}
		
		public static float getFloat(Enum<PreferenceKeys> key, float defaultValue) {
			return getPreferenceGetter().getFloat(key.name(), defaultValue);
		}
		
		public static void setString(Enum<PreferenceKeys> key, String value) {
			getPreferencePutter().putString(key.name(), value);
		}
		
		public static String getString(Enum<PreferenceKeys> key, String defaultValue) {
			return getPreferenceGetter().getString(key.name(), defaultValue);
		}
		
		public static void setBoolean(Enum<PreferenceKeys> key, boolean value) {
			getPreferencePutter().putBoolean(key.name(), value);
		}
		
		public static boolean getBoolean(Enum<PreferenceKeys> key, boolean defaultValue) {
			return getPreferenceGetter().getBoolean(key.name(), defaultValue);
		}
	}
	
	
}