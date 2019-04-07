package cdictv.tiyitao.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import cdictv.tiyitao.R;
import cdictv.tiyitao.util.Sputil;

public class FazhiActivity extends AppCompatActivity {

    private ImageView left_menu;
    private TextView title;
    private RelativeLayout tool_bar;
    private Switch btn_switch;
    private EditText ed_wd;
    private EditText ed_sd;
    private EditText ed_gz;
    private EditText ed_co2;
    private EditText ed_pm;
    private EditText ed_road;
    private Button save;
    private String mWd;
    private String mSd;
    private String mGz;
    private String mCo2;
    private String mPm;
    private String mRoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fazhi);
        initView();
        initlinsr();
    }

    private void initlinsr() {
        btn_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ed_wd.setEnabled(false);
                    ed_sd.setEnabled(false);
                    ed_gz.setEnabled(false);
                    ed_co2.setEnabled(false);
                    ed_pm.setEnabled(false);
                    ed_road.setEnabled(false);
                } else {
                    ed_wd.setEnabled(true);
                    ed_sd.setEnabled(true);
                    ed_gz.setEnabled(true);
                    ed_co2.setEnabled(true);
                    ed_pm.setEnabled(true);
                    ed_road.setEnabled(true);
                }
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdata();
                if(!TextUtils.isEmpty(mWd)&&Integer.parseInt(mWd)>0 &&
                        !TextUtils.isEmpty(mSd)&&Integer.parseInt(mSd)>0
                &&!TextUtils.isEmpty(mGz)&&Integer.parseInt(mGz)>0
                     &&!TextUtils.isEmpty(mCo2)&&Integer.parseInt(mCo2)>0
                 &&!TextUtils.isEmpty(mPm)&&Integer.parseInt(mPm)>0
                 &&!TextUtils.isEmpty(mRoad)&&Integer.parseInt(mRoad)>0){
                    Sputil.putString("wd",mWd);
                    Sputil.putString("sd",mSd);
                    Sputil.putString("gz",mGz);
                    Sputil.putString("co2",mCo2);
                    Sputil.putString("pm",mPm);
                    Sputil.putString("road",mRoad);
                     Toast.makeText(getApplicationContext(),"保存成功",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"请检查以上阀值是否符合要求",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getdata() {
        mWd = ed_wd.getText().toString().trim();
        mSd = ed_sd.getText().toString().trim();
        mGz = ed_gz.getText().toString().trim();
        mCo2 = ed_co2.getText().toString().trim();
        mPm = ed_pm.getText().toString().trim();
        mRoad = ed_road.getText().toString().trim();
    }

    private void initView() {
        left_menu = (ImageView) findViewById(R.id.left_menu);
        title = (TextView) findViewById(R.id.title);
        tool_bar = (RelativeLayout) findViewById(R.id.tool_bar);
        btn_switch = (Switch) findViewById(R.id.btn_switch);
        ed_wd = (EditText) findViewById(R.id.ed_wd);
        ed_sd = (EditText) findViewById(R.id.ed_sd);
        ed_gz = (EditText) findViewById(R.id.ed_gz);
        ed_co2 = (EditText) findViewById(R.id.ed_co2);
        ed_pm = (EditText) findViewById(R.id.ed_pm);
        ed_road = (EditText) findViewById(R.id.ed_road);
        save = (Button) findViewById(R.id.save);
    }


}
