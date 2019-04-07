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

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.formatter.XAxisValueFormatter;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import java.util.ArrayList;
import java.util.List;

import cdictv.tiyitao.R;

public class Bar1Fragment extends Fragment {
    private Context context;
    private int layout;
    private List<String> xVals=new ArrayList<>();
    private List<BarDataSet> dataSets=new ArrayList<>();
    private List<BarEntry> yVals = new ArrayList<>();
    public Bar1Fragment() {

    }

    @SuppressLint("ValidFragment")
    public Bar1Fragment(Context context, int layout) {
        this.context = context;
        this.layout = layout;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layout, container, false);
        HorizontalBarChart barChart = inflate.findViewById(R.id.barChart);
        barChart.setBackgroundColor(Color.WHITE);
        getData();



        Legend legend = barChart.getLegend();
        legend.setEnabled(false);
        barChart.setDescription("");
        barChart.setGridBackgroundColor(Color.WHITE);
        BarDataSet barDataSet = new BarDataSet(yVals, "");
        barDataSet.setBarSpacePercent(55f);

        int[] ints = {Color.parseColor("#C10100"),
                Color.parseColor("#5082C0"),Color.parseColor("#90D34F")};
        barDataSet.setColors(ints);


        barDataSet.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                float val = entry.getVal();
                return String.format("%.2f",val)+"%";
            }
        });


        barDataSet.setValueTextSize(20f);
        barDataSet.setValueTextColor(Color.RED);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisLineColor(Color.TRANSPARENT);
        xAxis.setDrawGridLines(false);
        xAxis.setGridColor(Color.TRANSPARENT);
        xAxis.setTextSize(15f);
        xAxis.setLabelsToSkip(0);
        xAxis.setXOffset(20f);
        xAxis.setGridColor(Color.WHITE);

        YAxis axisLeft = barChart.getAxisLeft();
        axisLeft.setAxisLineColor(Color.TRANSPARENT);
        axisLeft.setTextColor(Color.TRANSPARENT);
        axisLeft.setDrawAxisLine(false);
        axisLeft.setXOffset(20f);
        axisLeft.setGridColor(Color.TRANSPARENT);



        YAxis axisRight = barChart.getAxisRight();
        axisRight.setAxisLineColor(Color.TRANSPARENT);
        axisRight.setDrawAxisLine(false);
        axisRight.setXOffset(20f);
        axisRight.setAxisMaxValue(30);
        axisRight.setLabelCount(12,true);
        axisRight.setValueFormatter(new YAxisValueFormatter() {
            @Override
            public String getFormattedValue(float v, YAxis yAxis) {
                return String.format("%.2f",v)+"%";
            }
        });
        axisRight.setAxisMaxValue(60f);
        axisRight.setLabelCount(7,true);





        dataSets.add(barDataSet);
        BarData barData = new BarData(xVals, dataSets);
        barChart.setData(barData);

        return inflate;
    }

    private void getData() {
        xVals.add("1-2条违章");
        xVals.add("3-5条违章");
        xVals.add("5条以上违章");
        yVals.add(new BarEntry(13.20f,2));
        yVals.add(new BarEntry(26.28f,1));
        yVals.add(new BarEntry(60.51f,0));
    }
}
