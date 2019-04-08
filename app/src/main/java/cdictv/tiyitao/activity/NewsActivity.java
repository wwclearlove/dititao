package cdictv.tiyitao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cdictv.tiyitao.R;
import cdictv.tiyitao.adatper.NesAdatper;
import cdictv.tiyitao.bean.NewsBean;
import cdictv.tiyitao.http.MyCall;
import cdictv.tiyitao.http.OkhttpApi;

public class NewsActivity extends AppCompatActivity {
    private ImageView left_menu;
    private TextView title;
    private ListView list;
    List<NewsBean.NewslistBean> newslist;
    private NesAdatper mAdatper;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newslist=new ArrayList<>();
        setContentView(R.layout.activity_news);
        initView();
        okhttpGeda();
    }

    private void okhttpGeda() {
        OkhttpApi.showOkhttp("http://api.tianapi.com/keji/?key=6edb9118c6ce61c710140aeb03b10e2c&num=50&rand=1",
                new MyCall() {
                    @Override
                    public void success(String json) {
                        try {
                            Gson gson=new Gson();
                            NewsBean newsBean=gson.fromJson(json,NewsBean.class);
                            List<NewsBean.NewslistBean> list=newsBean.newslist;
                            newslist.clear();
                            newslist.addAll(list);
                            mAdatper.notifyDataSetChanged();
                        }catch (Exception e){

                        }
                    }

                    @Override
                    public void failed(String str) {

                    }
                });
    }

    private void initView() {
        left_menu = (ImageView) findViewById(R.id.left_menu);
        title = (TextView) findViewById(R.id.title);
        list = (ListView) findViewById(R.id.list);
        mAdatper = new NesAdatper(newslist,NewsActivity.this);
        list.setAdapter(mAdatper);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(NewsActivity.this, WebViewActivity.class);
                intent.putExtra("title",newslist.get(position).title);
                intent.putExtra("uri",newslist.get(position).url);
                startActivity(intent);
            }
        });
    }


}
