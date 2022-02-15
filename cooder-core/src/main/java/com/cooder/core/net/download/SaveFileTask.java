package com.cooder.core.net.download;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.cooder.core.global.Cooder;
import com.cooder.core.net.callback.IRequest;
import com.cooder.core.net.callback.ISuccess;
import com.cooder.core.util.file.FileUtil;
import okhttp3.ResponseBody;

import java.io.File;
import java.io.InputStream;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/14 18:05
 * 作者姓名：lijiawei
 * 功能介绍：保存文件任务
 */

@SuppressWarnings("deprecation")
public class SaveFileTask extends AsyncTask<Object, Void, File> {
	
	private final IRequest REQUEST;
	private final ISuccess SUCCESS;
	
	public SaveFileTask(IRequest iRequest, ISuccess iSuccess) {
		this.REQUEST = iRequest;
		this.SUCCESS = iSuccess;
	}
	
	@Override
	protected File doInBackground(Object... params) {
		String downloadDir = (String) params[0];
		String extension = (String) params[1];
		final ResponseBody body = (ResponseBody) params[2];
		final String name = (String) params[3];
		final InputStream is = body.byteStream();
		if (downloadDir == null || downloadDir.equals("")) {
			downloadDir = "downloads";
		}
		if (extension == null || extension.equals("")) {
			extension = "";
		}
		File file;
		if (name == null) {
			file = FileUtil.writeToDisk(is, downloadDir, extension.toUpperCase(), extension);
		} else {
			file = FileUtil.writeToDisk(is, downloadDir, name);
		}
		return file;
	}
	
	// 执行完异步任务回到主线程
	@Override
	protected void onPostExecute(File file) {
		super.onPostExecute(file);
		if (SUCCESS != null) {
			SUCCESS.onSuccess(file.getPath());
		}
		if (REQUEST != null) {
			REQUEST.onRequestEnd();
		}
	}
	
	private void autoInstallApk(File file) {
		if (FileUtil.getExtension(file.getPath()).equals("apk")) {
			final Intent install = new Intent();
			install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			install.setAction(Intent.ACTION_VIEW);
			install.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
			Cooder.getApplicationContext().startActivity(install);
		}
	}
}





