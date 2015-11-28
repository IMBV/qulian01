//package com.quliantrip.qulian.net.httpManager;
//
//import android.content.Context;
//
//import com.quliantrip.qulian.net.constant.HttpConstants;
//import com.squareup.okhttp.Call;
//import com.squareup.okhttp.Callback;
//import com.squareup.okhttp.OkHttpClient;
//import com.squareup.okhttp.Request;
//import com.squareup.okhttp.Response;
//import com.zhy.http.okhttp.L;
//import com.zhy.http.okhttp.OkHttpClientManager;
//
//import org.json.JSONException;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//
//public class HttpManage <T>{
//
//	@SuppressWarnings("unused")
//	private Context mContext;
//	private OkHttpClient mOkHttpClient ;
//	/**请求编码格式*/
//	private String mResponseTextCharset = HttpConstants.HTTP_CODING;
//	/**连接超时时长*/
//	private int mConnectTimeout = HttpConstants.HTTP_CONNECT_TIMEOUT;
//	/**读取超时时长*/
//	private int mSoTimeout = HttpConstants.HTTP_SO_TIMEOUT;
//	private HttpRequestCallBack<T> mCallBack;
//	private HttpHandler<File> mHandler;
//	private HttpHandler<String> send;
//
//	public HttpManage(Context context){
//		mContext = context;
//		mOkHttpClient = new OkHttpClient();
//
//	}
//
//	public void doGet(String url,int tag){
//
//		Request request = new Request.Builder().url(url).build();
//		Call call = mOkHttpClient.newCall(request);
//		call.equals()
//
////		L.d(url);
////		send = mHttpUtils.send(HttpRequest.HttpMethod.GET, url, new HttpRequestResult(tag));
//	}
//	public void doPost(String url, int tag,RequestParams params){
//		send = mHttpUtils.send(HttpRequest.HttpMethod.POST, url,params, new HttpRequestResult(tag));
//	}
//
//	public class MyCallBack implements Callback {
//
//		@Override
//		public void onFailure(Request request, IOException e) {
//
//		}
//
//		@Override
//		public void onResponse(Response response) throws IOException {
//
//		}
//	}
//	public class HttpRequestResult extends RequestCallBack<String>{
//		private int mTag;
//		public HttpRequestResult(int tag) {
//			mTag = tag;
//		}
//		@Override
//		public void onStart() {
//			super.onStart();
//		}
//		@Override
//		public void onFailure(HttpException arg0, String arg1) {
//			L.e(arg0.toString());
//			L.e(""+arg0.getExceptionCode());
//			if (mCallBack!= null) {
//				Map<String, String> map = new HashMap<String, String>();
//				switch (arg0.getExceptionCode()) {
//				case 0:
//					map.put("msg", "当前网络不可用");
//					break;
//				case 404:
//					map.put("msg", "当前网络不可用");
//					break;
//				case 408:
//					map.put("msg", "当前网络不给力请稍后重试");
//					break;
//				default:
//					map.put("msg", "当前网络不可用");
//					break;
//				}
//				map.put("code",""+arg0.getExceptionCode());
//				mCallBack.onFailure(mTag, map);
//			}
//		}
//
//		@Override
//		public void onSuccess(ResponseInfo<String> arg0) {
//			String result = arg0.result;
//			if(null == result)
//				return;
//			L.d(result);
//			ParserManager<T> manager = new ParserManager<T>();
//			T data = null;
//			try {
//				data =manager.getData(result,mTag);
//			}catch (JSONException e) {
//				e.printStackTrace();
//				L.e("解析出错");
//			}
//			if (mCallBack != null) {
//				if (null == data) {
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("code", "600");
//					map.put("msg", "解析错误");
//					mCallBack.onFailure(mTag, map);
//					L.e("解析数据为空");
//				}else {
//					mCallBack.onSuccess(data, mTag);
//				}
//			}
//		}
//
//	}
//	public void uploading(String url, int tag,RequestParams params){
//	}
//	/**
//	 *
//	 * @Title: stopRequest
//	 * @Description: 取消请求
//	 * @return: void
//	 */
//	public void stopRequest(){
//		if (send!=null) {
//			send.cancel();
//		}
//	}
//	/***
//	 *
//	 * @Title: download
//	 * @Description: 下载
//	 * @param url
//	 * @param path
//	 * @param back
//	 * @return: void
//	 */
//	public void download(String url,String path,RequestCallBack<File> back){
//		mHttpUtils = new HttpUtils();
//		mHandler = mHttpUtils.download(url, path, true, false, back);
//	}
//	/**
//	 *
//	 * @Title: stopDownload
//	 * @Description: 取消下载
//	 * @return: void
//	 */
//	public void stopDownload(){
//		mHandler.cancel();
//	}
//	/**
//	 *
//	 * @Title: setHttpRequestCallBack
//	 * @Description: 设置监听
//	 * @param callBack
//	 * @return: void
//	 */
//	public void setHttpRequestCallBack(HttpRequestCallBack<T> callBack){
//		mCallBack = callBack;
//	}
//	public interface HttpRequestCallBack<T> {
//		public abstract void onFailure(int tag, Map<String, String> map);
//		public abstract void onSuccess(T data, int tag);
//	}
//}
