import function.TableFunction;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.awt.*;

public class Plotter {
    private XYChart chart;
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 600;
    private static final String DEFAULT_TITLE = "title";
    private static final String DEFAULT_X_TITLE = "x";
    private static final String DEFAULT_Y_TITLE = "y";

    public Plotter() {
        chart = new XYChartBuilder()
                .width(DEFAULT_WIDTH)
                .height(DEFAULT_HEIGHT)
                .title(DEFAULT_TITLE)
                .xAxisTitle(DEFAULT_X_TITLE)
                .yAxisTitle(DEFAULT_Y_TITLE)
                .build();
    }

    public void addGraphic(TableFunction function, String functionName, Color functionColor) {
        XYSeries series = chart.addSeries(functionName, function.x(), function.y());
        series.setLineColor(functionColor);
        series.setMarker(SeriesMarkers.NONE);
    }

    public void addDots(TableFunction function, String dotsName) {
        XYSeries series = chart.addSeries(dotsName, function.x(), function.y());
        series.setXYSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
    }

    public void display() {
        new SwingWrapper(chart).displayChart();
    }
}
