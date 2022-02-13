package com.cooder.core.net;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * 项目名称：Cooder
 * 创建时间：2022/2/11 18:59
 * 作者姓名：lijiawei
 * 功能介绍：请求接口
 */

public interface RestService {
	
	@GET
	Call<String> get(@Url String url, @QueryMap Map<String, Object> params);
	
	@FormUrlEncoded
	@POST
	Call<String> post(@Url String url, @FieldMap Map<String, Object> params);
	
	@POST
	Call<String> postRaw(@Url String url, @Body RequestBody body);
	
	@FormUrlEncoded
	@PUT
	Call<String> put(@Url String url, @FieldMap Map<String, Object> params);
	
	@PUT
	Call<String> putRaw(@Url String url, @Body RequestBody body);
	
	@DELETE
	Call<String> delete(@Url String url, @QueryMap Map<String, Object> params);
	
	@Streaming
	@GET
	Call<ResponseBody> downloads(@Url String url, @QueryMap Map<String, Object> params);
	
	@Multipart
	@POST
	Call<String> upload(@Url String url, @Part MultipartBody.Part file);
}