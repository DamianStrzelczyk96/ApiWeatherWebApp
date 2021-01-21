package Project;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DrawChart extends JFrame {


 private List<Dni> dayList = new ArrayList<>();



    public int  DrawChart(List<Dni> listadni) throws IOException {
        if (listadni != null) {
            this.dayList = listadni;
        } else {
            System.out.println("MUKA");
        }
        return initUI();
    }


    public void LineChartEx() throws IOException {

            initUI();
    }
int number = 0;
    private int initUI() throws IOException {
        if(number<5){
        number = number + 1;}
        else { number = 0;}
        BufferedImage bImage = null;
        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Line chart");

        System.out.println("Rysuje");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bImage = chart.createBufferedImage(450,450);
        ClassLoader classLoader = getClass().getClassLoader();


        String filename = "image";
        String fileEnd = ".png";
        String path = new File("").getAbsolutePath();
        StringBuffer fileN = new StringBuffer();
        fileN.append(filename);
        fileN.append(number);
        fileN.append(fileEnd);
        String fullFileName = fileN.toString();
        System.out.println(fullFileName);
        File inputfile = new File(path + File.separator +"src" +File.separator +"main" + File.separator + "resources" + File.separator + "Static" + File.separator + "Image" + File.separator + fullFileName);

        ChartUtils.saveChartAsPNG(inputfile, chart, 450, 400);

        return number;
    }

    private XYDataset createDataset() {
int days = 0;
        XYSeries series = new XYSeries("2016");
        for (Dni day:dayList) {
            CheckDay day1 = new CheckDay(day);
        if(day1.WitchHour()==00){
            days = days + 1;}

            System.out.println(days+((day1.WitchHour()/3)*0.125));
            series.add(days+((day1.WitchHour()/3)*0.125),day.getTemp());
        }



        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Average temperature per day",
                "Day",
                "Temperature [C]",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Average Temperature per Day",
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;

}


}
