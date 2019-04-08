package cdictv.tiyitao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.query.In;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cdictv.tiyitao.R;
import cdictv.tiyitao.adatper.WodeyijianAdapter;
import cdictv.tiyitao.bean.WodeyijanBean;
import cdictv.tiyitao.database.DataBaseHelp;

public class WodeyijinaActivity extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Dao dao;
    private ImageView wode_fanghui;
    private TextView title;
    private RelativeLayout tool_bar;
    private ListView wode_listview;
    List<WodeyijanBean> wodeyijanBeans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wodeyijina);
        initView();
        try {
            dao = DataBaseHelp.getDataBase(WodeyijinaActivity.this).getDao(WodeyijanBean.class);
            wodeyijanBeans.addAll(dao.queryForAll());
            WodeyijianAdapter adapter = new WodeyijianAdapter(WodeyijinaActivity.this,wodeyijanBeans);
            wode_listview.setAdapter(adapter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    private void initView() {
        wode_fanghui = (ImageView) findViewById(R.id.wode_fanghui);
        title = (TextView) findViewById(R.id.title);
        tool_bar = (RelativeLayout) findViewById(R.id.tool_bar);
        wode_listview = (ListView) findViewById(R.id.wode_listview);

        wode_fanghui.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wode_fanghui:
                startActivity(new Intent(WodeyijinaActivity.this,YijianActivity.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
