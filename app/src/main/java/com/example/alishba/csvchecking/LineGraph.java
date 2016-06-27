package com.example.alishba.csvchecking;

import android.content.Context;
import android.graphics.Color;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/**
 * Created by Alishba on 6/24/2016.
 */
public class LineGraph {
    private GraphicalView view;

    TimeSeries series = new TimeSeries("ECG");
  private  XYSeriesRenderer renderer = new XYSeriesRenderer();
   private XYMultipleSeriesDataset mdataset = new XYMultipleSeriesDataset();
    XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();



    public LineGraph(){
        mdataset.addSeries(series);

        renderer.setColor(Color.RED);

        mRenderer.setShowGrid(true);
        mRenderer.setGridColor(Color.BLACK);
        mRenderer.setZoomButtonsVisible(true);
        mRenderer.setMarginsColor(Color.WHITE);

        mRenderer.addSeriesRenderer(renderer);

    }
    public GraphicalView getView(Context context) {


        view = ChartFactory.getCubeLineChartView(context, mdataset, mRenderer, 0.33f);

return view;
    }




public void addNewPoints(float t, float v){

ecg e=new ecg(t,v);

        float ti = e.getTime();

        float vo = e.getVoltage();
       series.add(ti,vo);

}



    }
