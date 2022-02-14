package com.cooder.core.net.data;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/14 11:08
 * 作者姓名：lijiawei
 * 功能介绍：下载的数据
 */

public class DownloadData {
	private String name;
	private String extension;
	private String downloadDir;
	
	public DownloadData() {
	
	}
	
	public DownloadData(String name, String extension, String downloadDir) {
		this.name = name;
		this.extension = extension;
		this.downloadDir = downloadDir;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getExtension() {
		return extension;
	}
	
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public String getDownloadDir() {
		return downloadDir;
	}
	
	public void setDownloadDir(String downloadDir) {
		this.downloadDir = downloadDir;
	}
}
