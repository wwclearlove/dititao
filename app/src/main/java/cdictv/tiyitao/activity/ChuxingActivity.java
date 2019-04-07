package cdictv.tiyitao.activity;

import android.app.DatePickerDialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Calendar;

import cdictv.tiyitao.R;
import cdictv.tiyitao.util.DateUtil;

public class ChuxingActivity extends AppCompatActivity {

    private ImageView left_menu;
    private TextView title;
    private TextView dateid;
    private TextView cheliangid;
    private TextView xiaoche_1;
    private TextView kongzhi_1;
    private Switch btn_switch1;
    private TextView xiaoche_2;
    private TextView kongzhi_2;
    private Switch btn_switch2;
    private TextView xiaoche_3;
    private TextView kongzhi_3;
    private Switch btn_switch3;
    private ImageView img_ryg;
    private DatePickerDialog mDatePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuxing);
        initView();
        linister();
    }

    private void linister() {
        //设置当前
        dateid.setText(DateUtil.showYMD());
        xuanyan(Integer.parseInt(DateUtil.showD()));
     img_ryg.setImageResource(R.drawable.amintion);
        AnimationDrawable animationDrawable= (AnimationDrawable) img_ryg.getDrawable();
        animationDrawable.start();
    }

    private void showDataDialog() {
        Calendar cadar=Calendar.getInstance();
        xuanyan(Integer.parseInt(DateUtil.showD()));
        int year=cadar.get(Calendar.YEAR);
        int month=cadar.get(Calendar.MONTH);
        int day=cadar.get(Calendar.DAY_OF_MONTH);
       new DatePickerDialog(ChuxingActivity.this, new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
               dateid.setText(year+"年"+(month+1)+"月"+dayOfMonth+"日");
               xuanyan(dayOfMonth);
           }
       },year,month,day).show();
    }

    private void xuanyan(int dayOfMonth) {
        if(dayOfMonth%2==0){
            btn_switch1.setChecked(false);
            btn_switch1.setEnabled(false);
            btn_switch2.setEnabled(true);
            btn_switch3.setChecked(false);
            btn_switch3.setEnabled(false);
            cheliangid.setText("双号出行车辆：2");
        }else {
            btn_switch1.setEnabled(true);
            btn_switch2.setChecked(false);
            btn_switch2.setEnabled(false);
            btn_switch3.setEnabled(true);
            cheliangid.setText("单号出行车辆：1,3");
        }
    }

    private void initView() {
        left_menu = (ImageView) findViewById(R.id.left_menu);
        title = (TextView) findViewById(R.id.title);
        dateid = (TextView) findViewById(R.id.dateid);
        cheliangid = (TextView) findViewById(R.id.cheliangid);
        xiaoche_1 = (TextView) findViewById(R.id.xiaoche_1);
        kongzhi_1 = (TextView) findViewById(R.id.kongzhi_1);
        btn_switch1 = (Switch) findViewById(R.id.btn_switch1);
        xiaoche_2 = (TextView) findViewById(R.id.xiaoche_2);
        kongzhi_2 = (TextView) findViewById(R.id.kongzhi_2);
        btn_switch2 = (Switch) findViewById(R.id.btn_switch2);
        xiaoche_3 = (TextView) findViewById(R.id.xiaoche_3);
        kongzhi_3 = (TextView) findViewById(R.id.kongzhi_3);
        btn_switch3 = (Switch) findViewById(R.id.btn_switch3);
        img_ryg = (ImageView) findViewById(R.id.img_ryg);
    }

}
