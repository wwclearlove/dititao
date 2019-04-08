package cdictv.tiyitao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cdictv.tiyitao.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView left_menu;
    private TextView title;
    private TextView zhuxiao;
    private RelativeLayout tool_bar;
    private ImageView top_bac;
    private LinearLayout honglvdeng;
    private LinearLayout fazhi;
    private LinearLayout chuxing;
    private LinearLayout shujufenxi;
    private LinearLayout shenghuo;
    private LinearLayout shenghzs;
    private LinearLayout yijian;
    private LinearLayout tianqi;
    private LinearLayout yule;
    private LinearLayout navigation_view;
    private DrawerLayout drawer_yout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        left_menu = (ImageView) findViewById(R.id.left_menu);
        title = (TextView) findViewById(R.id.title);
        zhuxiao = (TextView) findViewById(R.id.zhuxiao);
        tool_bar = (RelativeLayout) findViewById(R.id.tool_bar);
        top_bac = (ImageView) findViewById(R.id.top_bac);
        honglvdeng = (LinearLayout) findViewById(R.id.honglvdeng);
        fazhi = (LinearLayout) findViewById(R.id.fazhi);
        chuxing = (LinearLayout) findViewById(R.id.chuxing);
        shujufenxi = (LinearLayout) findViewById(R.id.shujufenxi);
        shenghuo = (LinearLayout) findViewById(R.id.shenghuo);
        shenghzs = (LinearLayout) findViewById(R.id.shenghzs);
        yijian = (LinearLayout) findViewById(R.id.yijian);
        tianqi = (LinearLayout) findViewById(R.id.tianqi);
        yule = (LinearLayout) findViewById(R.id.yule);
        navigation_view = (LinearLayout) findViewById(R.id.navigation_view);
        drawer_yout = (DrawerLayout) findViewById(R.id.drawer_yout);

        left_menu.setOnClickListener(this);
        honglvdeng.setOnClickListener(this);
        fazhi.setOnClickListener(this);
        chuxing.setOnClickListener(this);
        shujufenxi.setOnClickListener(this);
        shenghuo.setOnClickListener(this);
        shenghzs.setOnClickListener(this);
        yijian.setOnClickListener(this);
        tianqi.setOnClickListener(this);
        yule.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_menu:
                //侧滑
                if (drawer_yout.isDrawerOpen(Gravity.LEFT)) {
                    drawer_yout.closeDrawer(Gravity.LEFT);
                } else {
                    drawer_yout.openDrawer(Gravity.LEFT);
                }
                break;
            case R.id.honglvdeng:
                startActivity(new Intent(MainActivity.this,HongLvDengActivity.class));
                break;
            case R.id.fazhi:
                startActivity(new Intent(MainActivity.this, FazhiActivity.class));
                break;
            case R.id.chuxing:
                startActivity(new Intent(MainActivity.this, ChuxingActivity.class));
                break;
            case R.id.shujufenxi:
                startActivity(new Intent(this, SJFXActivity.class));
                break;
            case R.id.shenghuo:
                startActivity(new Intent(MainActivity.this,ShengHuozhishuActivity.class));
                break;
            case R.id.shenghzs:
                startActivity(new Intent(MainActivity.this,ShenghuoActivity.class));
                break;
            case R.id.yijian:
                startActivity(new Intent(MainActivity.this,YijianActivity.class));
                break;
            case R.id.tianqi:
                startActivity(new Intent(this, WeatherInformationActivity.class));
                break;
            case R.id.yule:
                startActivity(new Intent(this, NewsActivity.class));
                break;
        }
    }
}
