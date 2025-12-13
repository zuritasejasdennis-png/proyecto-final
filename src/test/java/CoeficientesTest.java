import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoeficientesTest {

    @Test
    public void testCalculoCoeficientesLaboratorio() {
        double[] masas = {1.0, 2.0, 3.0};
        double[] periodosCuadrados = {0.98, 2.05, 2.95};

        MinimosCuadrados mc = new MinimosCuadrados(masas, periodosCuadrados);

        double pendiente = mc.getPendienteA();
        double interseccion = mc.getInterseccionB();

        System.out.println("Pendiente calculada: " + pendiente);

        assertTrue(pendiente > 0.9 && pendiente < 1.1, "El coeficiente A está fuera del rango esperado");

        assertTrue(Math.abs(interseccion) < 0.2, "El coeficiente B debería ser cercano a cero");
    }
}