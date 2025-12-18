public class MinimosCuadrados {

    private final double[] x;
    private final double[] y;

    public MinimosCuadrados(double[] xData, double[] yData) {
        if (xData == null || yData == null) {
            throw new IllegalArgumentException("Los datos no pueden ser nulos.");
        }
        if (xData.length != yData.length) {
            throw new IllegalArgumentException("Los arrays x e y deben tener la misma longitud.");
        }
        if (xData.length < 2) {
            throw new IllegalArgumentException("Se necesitan al menos 2 puntos para calcular una recta.");
        }

        this.x = xData.clone();
        this.y = yData.clone();
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

        if (denominador == 0) {
            throw new ArithmeticException("El denominador es 0. No se puede calcular la pendiente.");
        }

        return numerador / denominador;
    }

    public double getInterseccionB() {
        int n = x.length;
        double sumX = 0, sumY = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
        }

        double promedioX = sumX / n;
        double promedioY = sumY / n;

        return promedioY - (getPendienteA() * promedioX);
    }
}
