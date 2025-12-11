import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AnalisisMovimiento {

    public static void main(String[] args) {
        ArrayList<Double> xList = new ArrayList<>();
        ArrayList<Double> yList = new ArrayList<>();

        XYSeries seriesDatos = new XYSeries("Datos Linealizados");

        String csvFile = "datos_linealizados.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // Saltar cabecera
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                double m = Double.parseDouble(values[0]);
                double t2 = Double.parseDouble(values[1]);

                xList.add(m);
                yList.add(t2);
                seriesDatos.add(m, t2);
            }
        } catch (IOException e) { e.printStackTrace(); }

        double[] xArray = xList.stream().mapToDouble(d -> d).toArray();
        double[] yArray = yList.stream().mapToDouble(d -> d).toArray();

        MinimosCuadrados mmc;
        mmc = new MinimosCuadrados(xArray, yArray);
        double A = mmc.getPendienteA();
        double B = mmc.getInterseccionB();

        System.out.println("Resultados MMC:");
        System.out.println("Pendiente (A): " + A);
        System.out.println("Intersección (B): " + B);

        XYSeries seriesAjuste = new XYSeries("Ajuste Lineal (MMC)");
        double xMin = xArray[0];
        double xMax = xArray[xArray.length - 1];

        seriesAjuste.add(xMin, A * xMin + B);
        seriesAjuste.add(xMax, A * xMax + B);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seriesDatos);
        dataset.addSeries(seriesAjuste);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Linealización: T² vs Masa",
                "Masa (m)",
                "Periodo al Cuadrado (T²)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );


        JFrame frame = new JFrame("Gráfico Final");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}