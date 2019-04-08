package cdictv.tiyitao.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cdictv.tiyitao.R;
import cdictv.tiyitao.bean.WodeyijanBean;

public class WodeyijianAdapter extends BaseAdapter {

    Context context;
    List<WodeyijanBean> beanList;

    private TextView wodeBiaoti;
    private TextView wodeZhuangtai;
    private TextView wodeNeirong;
    private TextView wodeTime;
    private TextView wodeHuifushijian;

    public WodeyijianAdapter(Context context, List<WodeyijanBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @Override
    public int getCount() {
        return beanList.size();
    }

    @Override
    public Object getItem(int position) {
        return beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.wodeyijian_item,parent,false);
        }

        wodeBiaoti = (TextView) convertView.findViewById(R.id.wode_biaoti);
        wodeZhuangtai = (TextView) convertView.findViewById(R.id.wode_zhuangtai);
        wodeNeirong = (TextView) convertView.findViewById(R.id.wode_neirong);
        wodeTime = (TextView) convertView.findViewById(R.id.wode_time);
        wodeHuifushijian = (TextView) convertView.findViewById(R.id.wode_huifushijian);

        wodeBiaoti.setText("标题"+beanList.get(position).biaoti);
        wodeNeirong.setText("提交时间"+beanList.get(position).tijiaoshijian);
        //wodeBiaoti.setText("回复时间"+beanList.get(position).huifushijina);

        return convertView;
    }
}
