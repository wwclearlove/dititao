package cdictv.tiyitao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cdictv.tiyitao.R;
import cdictv.tiyitao.bean.WodeyijanBean;
import cdictv.tiyitao.database.DataBaseHelp;

public class YijianActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView title;
    private TextView yijian_wodeyijian;
    private EditText yijiian_biaoti;
    private EditText yijiian_yijianleirong;
    private EditText yijiian_shouiji;
    private Button yijian_submt;
    Dao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yijian);
        initView();
        try {
            dao = DataBaseHelp.getDataBase(YijianActivity.this).getDao(WodeyijanBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void initView() {
        title = (TextView) findViewById(R.id.title);
        yijian_wodeyijian = (TextView) findViewById(R.id.yijian_wodeyijian);
        yijiian_biaoti = (EditText) findViewById(R.id.yijiian_biaoti);
        yijiian_yijianleirong = (EditText) findViewById(R.id.yijiian_yijianleirong);
        yijiian_shouiji = (EditText) findViewById(R.id.yijiian_shouiji);
        yijian_submt = (Button) findViewById(R.id.yijian_submt);

        yijian_submt.setOnClickListener(this);
        yijian_wodeyijian.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_menu:

                break;
            case R.id.yijian_submt:
                submit();
                startActivity(new Intent(YijianActivity.this,WodeyijinaActivity.class));
                break;
            case R.id.yijian_wodeyijian:
                startActivity(new Intent(YijianActivity.this,WodeyijinaActivity.class));
                break;
        }
    }


    private void submit() {
        // validate
        String biaoti = yijiian_biaoti.getText().toString().trim();
        if (TextUtils.isEmpty(biaoti)) {
            Toast.makeText(this, "标题", Toast.LENGTH_SHORT).show();
            return;
        }

        String yijianleirong = yijiian_yijianleirong.getText().toString().trim();
        if (TextUtils.isEmpty(yijianleirong)) {
            Toast.makeText(this, "输入你的意见", Toast.LENGTH_SHORT).show();
            return;
        }

        String shouiji = yijiian_shouiji.getText().toString().trim();
        if (TextUtils.isEmpty(shouiji)) {
            Toast.makeText(this, "手机", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
      careatDataBase(biaoti,yijianleirong,shouiji);

    }

    private void careatDataBase(String biaoti, String yijianleirong, String shouiji) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date  = format.format(new Date());
        WodeyijanBean bean = new WodeyijanBean();
        bean.biaoti = biaoti;
        bean.shouji =shouiji;
        bean.wodeyijian = yijianleirong;
        bean.tijiaoshijian = date;
        try {
            dao.create(bean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
