package cdictv.tiyitao.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cdictv.tiyitao.R;
import cdictv.tiyitao.activity.ShengHuozhishuActivity;
import cdictv.tiyitao.bean.ShenghuoBean;

public class ShengHuoAdapter extends BaseAdapter {

    Context context;
    List<Integer> list;
    String [] strings;

    ImageView shenghuoImg ;
    TextView  shenghuoLevel;
    TextView  shenghuoText;
    TextView  shenghuomiaoshu;

    public ShengHuoAdapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
        strings = new String[list.size()];
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
            convertView = LayoutInflater.from(context).inflate(R.layout.shenghuo_item,parent,false);
        }

         shenghuoImg = (ImageView) convertView.findViewById(R.id.shenghuo_img);
          shenghuoLevel = (TextView) convertView.findViewById(R.id.shenghuo_level);
          shenghuoText = (TextView) convertView.findViewById(R.id.shenghuo_text);
          shenghuomiaoshu = (TextView) convertView.findViewById(R.id.shenghuo_miaoshu);

          selectTextView(position,list.get(position),shenghuoImg);

        return convertView;
    }

    void selectTextView(int position,int num,ImageView shenghuoImg){
       switch (position){
           case 0:
               shenghuoImg.setImageResource(R.mipmap.qin);
               shenghuomiaoshu.setText("紫外线指数");
               if(num < 1000){
                   shenghuoLevel.setText("弱("+num+")");
                   shenghuoText.setText("辐射较弱，涂擦SPF12~15、PA+护肤品");
               }else if(num<3000){
                   shenghuoLevel.setText("中等("+num+")");
                   shenghuoText.setText("涂擦SPF大于15、PA+防晒护肤品");
               }else {
                   shenghuoLevel.setText("强("+num+")");
                   shenghuoText.setText("尽量减少外出，需要涂抹高倍数防晒霜");
               }
               break;
           case 1:
               shenghuomiaoshu.setText("感冒指数");
               shenghuoImg.setImageResource(R.mipmap.yaowan);
                if(num<8){
                    shenghuoLevel.setText("较易发("+num+")");
                    shenghuoText.setText("温度低，风较大，较易发生感冒，注意防护");
                }else {
                    shenghuoLevel.setText("少发("+num+")");
                    shenghuoText.setText("无明显降温，感冒机率较低");
                }
               break;
           case 2:
               shenghuomiaoshu.setText("舒适指数");
               shenghuoImg.setImageResource(R.mipmap.yifu);
               if(num<12){
               shenghuoLevel.setText("冷("+num+")");
               shenghuoText.setText("建议穿长袖衬衫、单裤等服装");
           }else if(num<21){
               shenghuoLevel.setText("舒适("+num+")");
               shenghuoText.setText("建议穿短袖衬衫、单裤等服装");
           }else {
                   shenghuoLevel.setText("热("+num+")");
                   shenghuoText.setText("适合穿T恤、短薄外套等夏季服装");
               }
               break;
           case 3:
               shenghuomiaoshu.setText("运动指数");
               shenghuoImg.setImageResource(R.mipmap.lanqiu);
               if(num<3000){
                   shenghuoLevel.setText("适宜("+num+")");
                   shenghuoText.setText("气候适宜，推荐您进行户外运动");
               }else if(num<6000){
                   shenghuoLevel.setText("中("+num+")");
                   shenghuoText.setText("易感人群应适当减少室外活动");
               }else {
                   shenghuoLevel.setText("较不宜("+num+")");
                   shenghuoText.setText("空气氧气含量低，请在室内进行休闲运动");
               }
               break;
           case 4:
               shenghuomiaoshu.setText("空气污染扩散指数");
               shenghuoImg.setImageResource(R.mipmap.yun);
               if(num<30){
                   shenghuoLevel.setText("优("+num+")");
                   shenghuoText.setText("空气质量非常好，非常适合户外活动，趁机出去多呼吸新鲜空气");
               }else if(num<100){
                   shenghuoLevel.setText("良("+num+")");
                   shenghuoText.setText("易感人群应适当减少室外活动");
               }else {
                   shenghuoLevel.setText("污染("+num+")");
                   shenghuoText.setText("空气质量差，不适合户外活动");
               }
               break;
       }

    }
}
