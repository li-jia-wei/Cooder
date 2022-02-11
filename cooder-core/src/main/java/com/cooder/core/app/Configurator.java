package com.cooder.core.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/11 10:19
 * 作者姓名：lijiawei
 * 功能介绍：无
 */

public class Configurator {
	
	// 程序配置
	private static final HashMap<String, Object> COODER_CONFIGS = new HashMap<>();
	
	// 字体图标库
	private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();
	
	private Configurator() {
		COODER_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
	}
	
	// 单例模式（线程安全）
	private static class Holder {
		private static final Configurator INSTANCE = new Configurator();
	}
	
	// 获取实例
	public static Configurator getInstance() {
		return Holder.INSTANCE;
	}
	
	// 配置网络请求域名
	public final Configurator withApiHost(String host) {
		COODER_CONFIGS.put(ConfigType.API_HOST.name(), host);
		return this;
	}
	
	// 配置图标
	public final Configurator withIcon(IconFontDescriptor icon) {
		ICONS.add(icon);
		return this;
	}
	
	// 检查配置
	@SuppressWarnings("ConstantConditions")
	private void checkConfiguration() {
		final boolean isReady = (boolean) COODER_CONFIGS.get(ConfigType.CONFIG_READY.name());
		if (!isReady) {
			throw new RuntimeException("配置还没有准备好！");
		}
	}
	
	// 获取所有配置
	final HashMap<String, Object> getCooderConfigs() {
		return COODER_CONFIGS;
	}
	
	// 初始化图标
	private void initIcons() {
		if (ICONS.size() > 0) {
			final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
			for (int i = 1; i < ICONS.size(); i++) {
				initializer.with(ICONS.get(i));
			}
		}
	}
	
	// 设置配置完成
	public void configure() {
		initIcons();
		COODER_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
	}
	
	// 获取配置
	@SuppressWarnings("unchecked")
	final <T> T getConfiguration(Enum<ConfigType> key) {
		checkConfiguration();
		return (T) COODER_CONFIGS.get(key.name());
	}
}