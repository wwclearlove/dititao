package cdictv.tiyitao.http;


import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cdictv.tiyitao.App;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkApi {
    private static Handler mHander=new Handler(Looper.getMainLooper());
    private static OkHttpClient mOkHttpClient=new OkHttpClient.Builder()
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10,TimeUnit.SECONDS)
            .connectTimeout(10,TimeUnit.SECONDS)
            .build();
    public static void request(Request request,final MyCall myCall){
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHander.post(new Runnable() {
                    @Override
                    public void run() {
                        myCall.failed(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String str=response.body().string();
                mHander.post(new Runnable() {
                    @Override
                    public void run() {
                        if(TextUtils.isEmpty(str)){
                             Toast.makeText(App.INSTANCE,"请求数据为空",Toast.LENGTH_SHORT).show();
                        }else {
                            myCall.success(str);
                        }
                    }
                });
            }
        });
    }
}
