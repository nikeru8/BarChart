package com.hello.kaiser.barchart;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BarChart barChart;

    private float COUNT = 10;
    BarDataSet barDataSet;
    BarData theData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barChart = (BarChart) findViewById(R.id.chart);
        configChartAxis(barChart);

        final ArrayList<Float> number = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            number.add(0f);
        }

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                COUNT = (float) Math.random() * 10;

                number.add(0, COUNT);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setBarChart(number);
                        barChart.setData(theData);
                        barChart.invalidate();
                    }
                });
                handler.postDelayed(this, 1000);
            }
        });


    }

    private void setBarChart(ArrayList<Float> no) {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            barEntries.add(new BarEntry(no.get(i), i));
        }

        barDataSet = new BarDataSet(barEntries, "Dates");

        ArrayList<String> theDates = new ArrayList<>();
        theDates.add("Aprill");
        theDates.add("May");
        theDates.add("JUNE");
        theDates.add("JULY");
        theDates.add("AUGEST");
        theDates.add("Aprill");
        theDates.add("May");
        theDates.add("JUNE");
        theDates.add("JULY");
        theDates.add("AUGEST");
        theDates.add("Aprill");
        theDates.add("May");
        theDates.add("JUNE");
        theDates.add("JULY");
        theDates.add("AUGEST");

        theData = new BarData(theDates, barDataSet);

        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(false);
        barChart.setScaleEnabled(false);
        barChart.setDescription("");


        barChart.setData(theData);

    }

    private void configChartAxis(BarChart chart_bar) {
        XAxis xAxis = chart_bar.getXAxis();
        xAxis.setDrawGridLines(false);

        YAxis leftYAxis = chart_bar.getAxisLeft();
        leftYAxis.setDrawGridLines(false);

        YAxis RightYAxis = chart_bar.getAxisRight();
        RightYAxis.setEnabled(false);   //不顯示右側
    }


}
