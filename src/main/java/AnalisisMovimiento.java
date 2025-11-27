import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;

public class AnalisisMovimiento {

    public static void main(String[] args) {

        final double T = 3.00;
        final double AMPLITUD = 1.0;
        final double OMEGA = 2 * Math.PI / T;

        XYSeries seriesOscilacion = new XYSeries("Posición vs Tiempo (Masa 9m)");

        double tiempoMax = T * 1.5;
        int numPuntos = 100;
        double dt = tiempoMax / numPuntos;

        for (int i = 0; i <= numPuntos; i++) {
            double t = i * dt;
            double x_posicion = AMPLITUD * Math.cos(OMEGA * t);
            seriesOscilacion.add(t, x_posicion);
        }

        System.out.println("Gráfico generado para M=9m, T=" + T + "s");

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seriesOscilacion);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Movimiento Armónico Simple (Predicción 9m)",
                "Tiempo (t) [s]",
                "Posición (x) [m]",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        JFrame frame = new JFrame("Gráfico Final - Predicción 9m");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}