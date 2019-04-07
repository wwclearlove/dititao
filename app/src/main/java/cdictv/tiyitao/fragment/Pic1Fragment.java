package cdictv.tiyitao.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import cdictv.tiyitao.R;

public class Pic1Fragment  extends Fragment{
    private Context context;
    private int layout;
    public Pic1Fragment() {

    }
    @SuppressLint("ValidFragment")
    public Pic1Fragment(Context context, int layout) {
        this.context=context;
        this.layout=layout;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layout, container, false);
        LinearLayout linearLayout=inflate.findViewById(R.id.linear);
        double[] values = new double[]{71.3,28.6};
        CategorySeries series = new CategorySeries("");

        series.add("无违章："+values[0]+"%", values[0]);
        series.add("有违章："+values[1]+"%", values[1]);

        int[] colors = new int[]{Color.parseColor("#AA4643"), Color.parseColor("#4572A7")};
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(20);
        renderer.setShowLegend(false);

        renderer.setMargins(new int[]{2, 3});

        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        renderer.setChartTitle("平台上有违章车辆和没违章车辆的占比统计");
        renderer.setChartTitleTextSize(35f);
        renderer.setClickEnabled(false);
        renderer.setZoomButtonsVisible(false);
        renderer.setZoomEnabled(false);
        renderer.setDisplayValues(false);
        renderer.setAxesColor(Color.RED);
        renderer.setShowLabels(true);
        renderer.setLabelsColor(Color.parseColor("#000000"));
        renderer.setPanEnabled(false);

        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(1);
        r.setGradientEnabled(true);
        r.setGradientStart(0, Color.parseColor("#4572A7"));
        r.setGradientStop(0, Color.parseColor("#4572A7"));
        r.setHighlighted(true);

        GraphicalView pieChartView = ChartFactory.getPieChartView(context, series, renderer);
        linearLayout.removeAllViews();
        linearLayout.addView(pieChartView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

        return inflate;
    }
}
