import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SumaTest {

    @Test
    public void testSumatoriasConsistentes() {

        double[] x = {-1.0, 0.0, 1.0};
        double[] y = {-1.0, 0.0, 1.0};

        MinimosCuadrados mc = new MinimosCuadrados(x, y);

        assertEquals(1.0, mc.getPendienteA(), 0.0001, "Error sumando valores negativos");
        assertEquals(0.0, mc.getInterseccionB(), 0.0001, "Error en intersección con negativos");
    }

    @Test
    public void testIntegridadDatos() {
        double[] x = {10.0, 15.0};
        double[] y = {20.0, 30.0};

        MinimosCuadrados mc = new MinimosCuadrados(x, y);

        assertNotNull(mc, "El objeto no debería ser nulo");
    }
}