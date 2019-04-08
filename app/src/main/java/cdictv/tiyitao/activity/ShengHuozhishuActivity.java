package cdictv.tiyitao.activity;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.List;

import cdictv.tiyitao.R;
import cdictv.tiyitao.adatper.ShengHuoAdapter;
import cdictv.tiyitao.bean.ShenghuoBean;
import cdictv.tiyitao.http.MyCall;
import cdictv.tiyitao.http.OkhttpApi;

public class ShengHuozhishuActivity extends AppCompatActivity {

    ShengHuoAdapter adapter;
    Gson gson = new Gson();
    List<Integer> list = new ArrayList<>();
    GridView shenghuo_grideview;
    Handler handler = new Handler();
    boolean flag = true;
    ProgressDialog dialog;
    Runnable mRunnable=new Runnable() {
        @Override
        public void run() {

            initRequest();
            handler.postDelayed(this,3000);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheng_huozhishu);
        if(flag){
            dialog = ProgressDialog.show(ShengHuozhishuActivity.this, "请稍后", "正在请求中....");
        }
        shenghuo_grideview = findViewById(R.id.shenghuo_grideview);
        adapter = new ShengHuoAdapter(ShengHuozhishuActivity.this,list);
        shenghuo_grideview.setAdapter(adapter);
//        initRequest();
        initRequest();
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler.postDelayed(mRunnable,3000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(mRunnable);
    }

    void initRequest(){

        OkhttpApi.showOkhttp("https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/shenghuozhishu", new MyCall() {
            @Override
            public void success(String json) {
                try {
                    if(list.size() != 0){
                        list.clear();
                    }
                    ShenghuoBean bean = gson.fromJson(json, ShenghuoBean.class);
                    list.add(bean.data.ziwaixian);
                    list.add(bean.data.ganmao);
                    list.add(bean.data.chuanyi);
                    list.add(bean.data.yundong);
                    list.add(bean.data.wuran);
                   adapter.notifyDataSetChanged();
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
                if(flag){
                    dialog.dismiss();
                    flag = false;
                }

            }

            @Override
            public void failed(String str) {
                dialog.dismiss();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
