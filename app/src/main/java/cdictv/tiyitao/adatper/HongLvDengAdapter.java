package cdictv.tiyitao.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cdictv.tiyitao.R;
import cdictv.tiyitao.bean.HongLvDengBean;

public class HongLvDengAdapter extends BaseAdapter {
    Context context;
    List<HongLvDengBean.DataBean> list;


    public HongLvDengAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.honglvdeng_item,parent,false);
        }

        TextView hongLukou = (TextView) convertView.findViewById(R.id.hong_lukou);
        TextView hongHongdeng = (TextView)convertView. findViewById(R.id.hong_hongdeng);
        TextView hongHuangdeng= (TextView) convertView.findViewById(R.id.hong_huangdeng);
        TextView hongLvdeng = (TextView) convertView.findViewById(R.id.hong_lvdeng);

        hongLukou.setText(list.get(position).id+"");
        hongHongdeng.setText(list.get(position).red+"");
        hongHuangdeng.setText(list.get(position).yellow+"");
        hongLvdeng.setText(list.get(position).green+"");



        return convertView;
    }
}
