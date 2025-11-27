package org.example;
public class MinimosCuadrados {

    private double[] x;
    private double[] y;

    public MinimosCuadrados(double[] xData, double[] yData) {
        this.x = xData;
        this.y = yData;
    }

    public double getPendienteA() {
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        double numerador = (n * sumXY) - (sumX * sumY);
        double denominador = (n * sumX2) - (sumX * sumX);

        return numerador / denominador;
    }

    public double getInterseccionB() {
        int n = x.length;
        double promedioY = 0;
        double promedioX = 0;
        double sumY = 0;
        double sumX = 0;

        for(int i=0; i<n; i++){
            sumY += y[i];
            sumX += x[i];
        }
        promedioY = sumY / n;
        promedioX = sumX / n;

        return promedioY - (getPendienteA() * promedioX);
    }
}
