package com.example.alishba.csvchecking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.series.DataPoint;

import org.achartengine.GraphicalView;

import java.io.InputStream;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private static GraphicalView view;
    private LineGraph line = new LineGraph();
    private static Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream inputStream = getResources().openRawResource(R.raw.apnea);

        CSVReader csv = new CSVReader(inputStream);
        csv.readCsvFile();

        final List<ecg> scoreList = ecg.ecgArrayList;
        final DataPoint[] val = new DataPoint[scoreList.size()];

        thread = new Thread() {
            public void run() {
                for (int i = 0; i <val.length; i++) {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                   // We got new data!
                    float t = scoreList.get(i).getTime();

                    float v =  scoreList.get(i).getVoltage();
                    
                    line.addNewPoints(t,v); // Add it to our graph
                    // view.repaint();
                }
            }
        };
        thread.start();
    }



    @Override
    protected void onStart() {
        super.onStart();
        view=line.getView(this);
        setContentView(view);
    }


    }

