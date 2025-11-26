import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnalisisMovimiento {

    public static void main(String[] args) {

        XYSeries series = new XYSeries("Posición vs Tiempo (Masa 4m)");

        String csvFile = "datos_masa_4m.csv";
        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(cvsSplitBy);
                double tiempo = Double.parseDouble(datos[0]);
                double posicion = Double.parseDouble(datos[1]);

                series.add(tiempo, posicion);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Movimiento Armónico Simple",
                "Tiempo (s)",
                "Posición (m)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        JFrame frame = new JFrame("Gráfico de Física");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}