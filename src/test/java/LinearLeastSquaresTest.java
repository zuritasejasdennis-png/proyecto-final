import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinearLeastSquaresTest {

    @Test
    public void testAjusteLinealPerfecto() {

        double[] x = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] y = {1.0, 2.0, 3.0, 4.0, 5.0};

        MinimosCuadrados mc = new MinimosCuadrados(x, y);

        //la Pendiente (A)
        assertEquals(1.0, mc.getPendienteA(), 0.0001, "El algoritmo falla en la pendiente ideal");

        //Intersección (B)
        assertEquals(0.0, mc.getInterseccionB(), 0.0001, "El algoritmo falla en la intersección ideal");
    }
}
