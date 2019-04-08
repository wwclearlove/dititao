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

import java.util.ArrayList;
import java.util.List;

import cdictv.tiyitao.R;

public class Bar2Fragment extends Fragment {
    private Context context;
    private int layout;
    private List<String> xVals=new ArrayList<>();
    private List<BarDataSet> datasets=new ArrayList<>();
    private List<BarEntry> yVals = new ArrayList<>();


    public Bar2Fragment() {

    }

    @SuppressLint("ValidFragment")
    public Bar2Fragment(Context context, int layout) {
        this.context = context;
        this.layout = layout;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layout, container, false);
        BarChart barChart = inflate.findViewById(R.id.barChart);

        xVals.clear();
        yVals.clear();
        datasets.clear();

        getData();

        barChart.setEnabled(false);
        barChart.setGridBackgroundColor(Color.TRANSPARENT);
        barChart.setClickable(false);
        BarDataSet barDataSet = new BarDataSet(yVals, "dffds");
        barDataSet.setColor(Color.parseColor("#6A9800"));
        barDataSet.setValueTextColor(Color.parseColor("#B93953"));
        barDataSet.setDrawValues(false);
        barDataSet.setColors(new int[]{Color.parseColor("#6A9800")
                ,Color.parseColor("#EB7208")});

        barDataSet.setBarSpacePercent(70f);
        Legend legend = barChart.getLegend();
        legend.setEnabled(false);


        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisLineColor(Color.TRANSPARENT);
        xAxis.setDrawGridLines(false);

        xAxis.setTextSize(15f);
        xAxis.setLabelsToSkip(0);


        barChart.setDescription("");

        YAxis axisLeft = barChart.getAxisLeft();
        //axisLeft.setAxisLineColor(Color.TRANSPARENT);
        axisLeft.setDrawAxisLine(false);
        axisLeft.setXOffset(20f);
        axisLeft.setAxisMaxValue(1200);
        axisLeft.setTextSize(30f);
        axisLeft.setLabelCount(7, true);

        YAxis axisRight = barChart.getAxisRight();
        axisRight.setAxisLineColor(Color.TRANSPARENT);
        axisRight.setTextColor(Color.TRANSPARENT);
        axisRight.setDrawAxisLine(false);
        axisRight.setXOffset(20f);
        axisRight.setGridColor(Color.TRANSPARENT);

        barChart.setDescription("");

        datasets.add(barDataSet);
        BarData barData = new BarData(xVals, datasets);
        barChart.setData(barData);

        return inflate;
    }

    private void getData() {
        xVals.add("90后");
        xVals.add("80后");
        xVals.add("70后");
        xVals.add("60后");
        xVals.add("50后");

        yVals.add(new BarEntry(new float[]{getInt(),getInt()},4));
        yVals.add(new BarEntry(new float[]{getInt(),getInt()},3));
        yVals.add(new BarEntry(new float[]{getInt(),getInt()},2));
        yVals.add(new BarEntry(new float[]{getInt(),getInt()},1));
        yVals.add(new BarEntry(new float[]{getInt(),getInt()},0));
    }
    public int getInt() {
        return (int) (Math.random() * 600 + 1);
    }
}
