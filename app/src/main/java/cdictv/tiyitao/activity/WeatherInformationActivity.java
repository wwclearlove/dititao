package cdictv.tiyitao.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Date;
import java.util.List;

import cdictv.tiyitao.R;
import cdictv.tiyitao.bean.Weather;
import cdictv.tiyitao.http.MyCall;
import cdictv.tiyitao.http.OkhttpApi;
import cdictv.tiyitao.util.DateUtil;

public class WeatherInformationActivity extends AppCompatActivity {
    private TextView date;
    private TextView city;
    private TextView temperature1;
    private LinearLayout group;

    private TextView date1;

    private TextView date2;

    private TextView date3;

    private TextView date4;

    private TextView date5;

    private String url = "https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/tianqi";
    private Weather.DataBean data;
    private List<Weather.DataBean.TianqiBean> tianqi;
    private int[] src = new int[]{R.mipmap.sun, R.mipmap.fine, R.mipmap.cloudy};

    private String[] color1 = new String[]{"#1080DF", "#3C9CE8", "#66B6EF"};
    private String[] color2 = new String[]{"#5BB6FA", "#84C6F8", "#A4D3F6"};
    private String[] color3 = new String[]{"#96B4D1", "#A7C2D9", "#BAD2E2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_information);
        init();
        getData();

    }

    private void setData() {


        date.setText(DateUtil.showYMD() + "    " + DateUtil.getWeek(new Date()));
        city.setText(data.getDidian() + "");
        temperature1.setText(data.getWendu() + "度");
        date1.setText(DateUtil.getDay(0) + "（今天）");
        date2.setText(DateUtil.getDay(1) + "（明天）");
        date3.setText(DateUtil.getDay(2) + "（后天）");
        date4.setText(DateUtil.getDay(3) + "（" + DateUtil.getWeek2(3) + "）");
        date5.setText(DateUtil.getDay(4) + "（" + DateUtil.getWeek2(4) + "）");


        for (int i = 0; i < group.getChildCount(); i++) {
            LinearLayout linear1 = (LinearLayout) group.getChildAt(i);
            for (int j = 0; j < linear1.getChildCount(); j++) {
                LinearLayout linear2 = (LinearLayout) linear1.getChildAt(j);
                linear2.setBackgroundColor(Color.parseColor("#fff000"));
                setColor(tianqi.get(i), linear2, j);
                if (j==0) {
                    ImageView imageView = (ImageView) ((LinearLayout) linear2.getChildAt(1)).getChildAt(0);
                    setImg(tianqi.get(i),imageView);
                }
                if (j==1) {
                    TextView tv1=(TextView)linear2.getChildAt(0);
                    TextView tv2=(TextView)linear2.getChildAt(1);
                    setText(tv1,tv2,i);
                }

            }

        }


    }

    private void setText(TextView tv1, TextView tv2, int j) {
        String state = tianqi.get(j).getState();
        String wendu = tianqi.get(j).getWendu();
        tv1.setText(state);
        tv2.setText(wendu+"℃");
    }

    private void setImg(Weather.DataBean.TianqiBean tianqiBean, ImageView imageView) {
        Log.e("tianqiBean.getState()", "tianqiBean.getState()" + tianqiBean.getState());
        switch (tianqiBean.getState()) {
            case "晴":
                imageView.setImageResource(src[0]);
                break;
            case "多云转阴":
                imageView.setImageResource(src[1]);
                break;
            case "阴转多云":
                imageView.setImageResource(src[2]);
                break;
        }
    }
    private void setColor(Weather.DataBean.TianqiBean tianqiBean, LinearLayout linear2, int j) {
        Log.e("tianqiBean.getState()", "tianqiBean.getState()" + tianqiBean.getState());
        switch (tianqiBean.getState()) {
            case "晴":
                linear2.setBackgroundColor(Color.parseColor(color1[j]));
                break;
            case "多云转阴":
                linear2.setBackgroundColor(Color.parseColor(color2[j]));
                break;
            case "阴转多云":
                linear2.setBackgroundColor(Color.parseColor(color3[j]));
                break;
        }
    }

    private void init() {
        date = (TextView) findViewById(R.id.date);
        city = (TextView) findViewById(R.id.city);
        temperature1 = (TextView) findViewById(R.id.temperature1);
        group = (LinearLayout) findViewById(R.id.group);
        date1 = (TextView) findViewById(R.id.date1);
        date2 = (TextView) findViewById(R.id.date2);
        date3 = (TextView) findViewById(R.id.date3);
        date4 = (TextView) findViewById(R.id.date4);
        date5 = (TextView) findViewById(R.id.date5);
    }

    private void getData() {
        final AlertDialog dialog = new ProgressDialog.Builder(this).setTitle("网络").setMessage("正在加载中。。。").show();
        OkhttpApi.showOkhttp(url, new MyCall() {
            @Override
            public void success(String json) {
                try {
                    Log.e("trag", "onSucceed: " + json);
                    Weather weather = new Gson().fromJson(json, Weather.class);
                    data = weather.getData();
                    tianqi = data.getTianqi();
                    Log.e("trag", "onSucceed: " + data.toString());
                    Log.e("trag", "onSucceed: " + tianqi.toString());
                    setData();
                    dialog.dismiss();
                } catch (Exception e) {
                    dialog.dismiss();
                    Toast.makeText(WeatherInformationActivity.this, "加载失败！！！", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void failed(String str) {
                dialog.dismiss();
                Toast.makeText(WeatherInformationActivity.this, "加载失败！！！", Toast.LENGTH_SHORT).show();
                return;
            }
        });


    }

    public void refresh(View view) {

        getData();

    }

    public void back(View view) {
        finish();
    }
}
