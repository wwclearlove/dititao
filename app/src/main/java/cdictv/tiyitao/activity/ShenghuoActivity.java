package cdictv.tiyitao.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import cdictv.tiyitao.R;
import cdictv.tiyitao.bean.ZhushouBean;
import cdictv.tiyitao.http.MyCall;
import cdictv.tiyitao.http.OkhttpApi;

public class ShenghuoActivity extends AppCompatActivity {
    private ImageView left_menu;
    private TextView title;
    private TextView pm;
    private TextView wd;
    private TextView sd;
    private TextView zhi_1;
    private TextView zhi_2;
    private TextView sport_1;
    private TextView sport_2;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            mHandler.postDelayed(this, 3000);
            OkhttpApi.showOkhttp("https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/shenghuozushou"
                    , new MyCall() {
                        @Override
                        public void success(String json) {
                            Log.d("json", "success: " + json);
                            Gson gson = new Gson();
                            try {
                                ZhushouBean bean = gson.fromJson(json, ZhushouBean.class);
                             ZhushouBean.DataBean data=bean.data;
                             xuanyan(data);
                            } catch (Exception e) {

                            }
                        }

                        @Override
                        public void failed(String str) {

                        }
                    });
        }
    };

    private void xuanyan(ZhushouBean.DataBean data) {
        pm.setText("PM2.5:"+data.pm);
        wd.setText("温 度:"+data.wendu);
        sd.setText("湿 度:"+data.shidu);
        if(data.pm>=0&&data.pm<100){
            sport_1.setText("良好");
            sport_1.setTextColor(Color.parseColor("#000000"));
            sport_2.setText("气象条件会对晨练影响不大");
        }else if(data.pm>=100&&data.pm<200){
            sport_1.setText("轻度");
            sport_1.setTextColor(Color.parseColor("#000000"));
            sport_2.setText("受天气影响，较不宜晨练");
        }else if(data.pm>=200&&data.pm<300){
            sport_1.setText("重度");
            sport_1.setTextColor(Color.parseColor("#ef0101"));
            sport_2.setText("减少外出，出行注意戴口罩");
        }else if(data.pm>300){
            sport_1.setText("爆表");
            sport_1.setTextColor(Color.parseColor("#ef0101"));
            sport_2.setText("停止一切外出活动");
        }
        //截取字符串
//        int gz1=Integer.parseInt(data.guangzhao.substring(8,9));
//        int gz2=Integer.parseInt(data.guangzhao.substring(10,13));
        //    光照。0-100。  最小阀值。30。最大阀值60。
        if(Integer.parseInt(data.guangzhao)<30){
            zhi_1.setText("非常弱");
            zhi_1.setTextColor(Color.parseColor("#000000"));
            zhi_2.setText("您无需担心紫外线");
        }else if(Integer.parseInt(data.guangzhao)>=30&&Integer.parseInt(data.guangzhao)<60){
            zhi_1.setText("弱");
            zhi_1.setTextColor(Color.parseColor("#000000"));
            zhi_2.setText("外出适当涂抹低倍数防晒霜");
        }else if(Integer.parseInt(data.guangzhao)>60){
            zhi_1.setText("强");
            zhi_1.setTextColor(Color.parseColor("#ef0101"));
            zhi_2.setText("外出需要涂抹中倍数防晒霜");
        }
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shenghuo);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mHandler.postDelayed(mRunnable, 3000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacks(mRunnable);
    }

    private void initView() {
        left_menu = (ImageView) findViewById(R.id.left_menu);
        title = (TextView) findViewById(R.id.title);
        pm = (TextView) findViewById(R.id.pm);
        wd = (TextView) findViewById(R.id.wd);
        sd = (TextView) findViewById(R.id.sd);
        zhi_1 = (TextView) findViewById(R.id.zhi_1);
        zhi_2 = (TextView) findViewById(R.id.zhi_2);
        sport_1 = (TextView) findViewById(R.id.sport_1);
        sport_2 = (TextView) findViewById(R.id.sport_2);
    }

}
