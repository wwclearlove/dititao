package cdictv.tiyitao.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import cdictv.tiyitao.R;
import cdictv.tiyitao.adatper.ViewPagerAdapter;
import cdictv.tiyitao.fragment.Bar1Fragment;
import cdictv.tiyitao.fragment.Bar2Fragment;
import cdictv.tiyitao.fragment.Bar3Fragment;
import cdictv.tiyitao.fragment.Pic1Fragment;
import cdictv.tiyitao.fragment.Pic2Fragment;

public class SJFXActivity extends AppCompatActivity {
    private ImageButton back;
    private ViewPager viewPager;
    private List<Fragment> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sjfx);
        init();
        setOnClick();
        setFragment();
        setAdapter();
    }

    private void setFragment() {
        list.add(new Pic1Fragment(SJFXActivity.this,R.layout.pic1_layout));
        list.add(new Pic2Fragment(SJFXActivity.this,R.layout.pic2_layout));
        list.add(new Bar1Fragment(SJFXActivity.this,R.layout.bar1_layout));
        list.add(new Bar2Fragment(SJFXActivity.this,R.layout.bar2_layout));
        list.add(new Bar3Fragment(SJFXActivity.this,R.layout.bar3_layout));
    }

    private void setAdapter() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void setOnClick() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void init() {

        back = (ImageButton) findViewById(R.id.back);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

    }
}
