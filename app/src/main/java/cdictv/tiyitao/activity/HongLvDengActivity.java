package cdictv.tiyitao.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cdictv.tiyitao.R;
import cdictv.tiyitao.adatper.HongLvDengAdapter;
import cdictv.tiyitao.bean.HongLvDengBean;
import cdictv.tiyitao.http.MyCall;
import cdictv.tiyitao.http.OkhttpApi;

public class HongLvDengActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView title;
    private Spinner hong_spinner;
    private ListView hong_listview;
    Button hong_qurey;
    List<HongLvDengBean.DataBean> dataBeanList = new ArrayList<>();
    HongLvDengAdapter adapter;
    Gson gson = new Gson();
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hong_lv_deng);
        initView();
        String[] spinner = new String[]{"路口升序", "路口降序", "红灯升序", "红灯降序", "绿灯升序", "绿灯降序", "黄灯升序", "黄灯降序"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                HongLvDengActivity.this, R.layout.spinner_hong, R.id.hong_spinner_tv, spinner);
        hong_spinner.setAdapter(arrayAdapter);
        hong_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                HongLvDengActivity.this.position = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        initRequest();
        hong_qurey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectHongLvDeng(position);
            }
        });

    }

    private void initRequest() {
        final ProgressDialog dialog = ProgressDialog.show(this, "请稍后", "正在请求中....");
        OkhttpApi.showOkhttp("https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/lamplist",
                new MyCall() {
                    @Override
                    public void success(String json) {
                        try {
                            HongLvDengBean bean = gson.fromJson(json, HongLvDengBean.class);
                            dataBeanList.addAll(bean.data);
                            selectHongLvDeng(position);
                            adapter = new HongLvDengAdapter(HongLvDengActivity.this, dataBeanList);
                            hong_listview.setAdapter(adapter);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            dialog.dismiss();
                        }
                    }

                    @Override
                    public void failed(String str) {
                        Toast.makeText(HongLvDengActivity.this, str, Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });
    }

    private void selectHongLvDeng(int position) {
        switch (position) {
            case 0:
                Collections.sort(dataBeanList, new Comparator<HongLvDengBean.DataBean>() {
                    @Override
                    public int compare(HongLvDengBean.DataBean o1, HongLvDengBean.DataBean o2) {
                        return o1.id - o2.id;
                    }
                });
                break;
            case 1:
                Collections.sort(dataBeanList, new Comparator<HongLvDengBean.DataBean>() {
                    @Override
                    public int compare(HongLvDengBean.DataBean o1, HongLvDengBean.DataBean o2) {
                        return o2.id - o1.id;
                    }
                });
                break;
            case 2:
                Collections.sort(dataBeanList, new Comparator<HongLvDengBean.DataBean>() {
                    @Override
                    public int compare(HongLvDengBean.DataBean o1, HongLvDengBean.DataBean o2) {
                        return o1.red - o2.red;
                    }
                });
                break;
            case 3:
                Collections.sort(dataBeanList, new Comparator<HongLvDengBean.DataBean>() {
                    @Override
                    public int compare(HongLvDengBean.DataBean o1, HongLvDengBean.DataBean o2) {
                        return o2.red - o1.red;
                    }
                });
                break;
            case 4:
                Collections.sort(dataBeanList, new Comparator<HongLvDengBean.DataBean>() {
                    @Override
                    public int compare(HongLvDengBean.DataBean o1, HongLvDengBean.DataBean o2) {
                        return o1.yellow - o2.yellow;
                    }
                });
                break;
            case 5:
                Collections.sort(dataBeanList, new Comparator<HongLvDengBean.DataBean>() {
                    @Override
                    public int compare(HongLvDengBean.DataBean o1, HongLvDengBean.DataBean o2) {
                        return o2.yellow - o1.yellow;
                    }
                });
                break;
            case 6:
                Collections.sort(dataBeanList, new Comparator<HongLvDengBean.DataBean>() {
                    @Override
                    public int compare(HongLvDengBean.DataBean o1, HongLvDengBean.DataBean o2) {
                        return o1.green - o2.green;
                    }
                });
                break;
            case 7:
                Collections.sort(dataBeanList, new Comparator<HongLvDengBean.DataBean>() {
                    @Override
                    public int compare(HongLvDengBean.DataBean o1, HongLvDengBean.DataBean o2) {
                        return o2.green - o1.green;
                    }
                });
                break;

        }
        adapter = new HongLvDengAdapter(HongLvDengActivity.this, dataBeanList);
        hong_listview.setAdapter(adapter);
    }


    private void initView() {
        hong_qurey = findViewById(R.id.hong_qurey);
        title = (TextView) findViewById(R.id.title);
        hong_spinner = (Spinner) findViewById(R.id.hong_spinner);
        hong_listview = (ListView) findViewById(R.id.hong_listview);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_menu:

                break;

        }
    }


}
