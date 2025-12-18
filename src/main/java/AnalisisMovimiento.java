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
import java.util.ArrayList;

public class AnalisisMovimiento {

    public static void main(String[] args) {
        ArrayList<Double> xList = new ArrayList<>();
        ArrayList<Double> yList = new ArrayList<>();
        XYSeries seriesDatos = new XYSeries("Datos Experimentales");

        String csvFile = "datos_linealizados.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
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

        MinimosCuadrados mmc = new MinimosCuadrados(xArray, yArray);
        double A = mmc.getPendienteA();
        double B = mmc.getInterseccionB();

        double k_calculada = (4 * Math.PI * Math.PI) / A;

        System.out.println("=== RESULTADOS DEL ANÁLISIS ===");
        System.out.println("Pendiente (A): " + A);
        System.out.println("Intersección (B): " + B);
        System.out.println("Constante Elástica (k): " + String.format("%.2f", k_calculada) + " N/m");

        XYSeries seriesAjuste = new XYSeries("Ajuste Lineal (MMC)");
        double xMin = xArray[0];
        double xMax = xArray[xArray.length - 1];
        seriesAjuste.add(xMin, A * xMin + B);
        seriesAjuste.add(xMax, A * xMax + B);

        XYSeriesCollection datasetMMC = new XYSeriesCollection();
        datasetMMC.addSeries(seriesDatos);
        datasetMMC.addSeries(seriesAjuste);

        JFreeChart chartMMC = ChartFactory.createXYLineChart(
                "Linealización: T² vs Masa",
                "Masa (kg)",
                "Periodo al Cuadrado (s²)",
                datasetMMC,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        JFrame frameMMC = new JFrame("Gráfico 1: Ajuste Lineal");
        frameMMC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMMC.add(new ChartPanel(chartMMC));
        frameMMC.pack();
        frameMMC.setLocation(0, 0);
        frameMMC.setVisible(true);


        double masaPrediccion = 9.0;
        double T_predicho = 2 * Math.PI * Math.sqrt(masaPrediccion / k_calculada);

        System.out.println("Periodo Predicho para 9m: " + String.format("%.2f", T_predicho) + " s");

        XYSeries seriesPrediccion = new XYSeries("Predicción (Masa 9m)");
        double amplitud = 1.0;
        double omega = 2 * Math.PI / T_predicho;

        for (double t = 0; t <= T_predicho * 1.5; t += 0.05) {
            double x = amplitud * Math.cos(omega * t);
            seriesPrediccion.add(t, x);
        }

        XYSeriesCollection datasetPrediccion = new XYSeriesCollection();
        datasetPrediccion.addSeries(seriesPrediccion);

        JFreeChart chartPred = ChartFactory.createXYLineChart(
                "Simulación: Movimiento para 9kg",
                "Tiempo (s)",
                "Posición (m)",
                datasetPrediccion,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        JFrame framePred = new JFrame("Gráfico 2: Predicción");
        framePred.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePred.add(new ChartPanel(chartPred));
        framePred.pack();
        framePred.setLocation(600, 0);
        framePred.setVisible(true);
    }
}
