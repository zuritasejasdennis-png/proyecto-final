# Informe Final: Estudio Computacional del Movimiento Armónico Simple

**Estudiante:** Dennis zurita sejas 
**Asignatura:** Laboratorio de Física General

---

## 1. Resumen Ejecutivo
El objetivo principal de este proyecto fue modernizar el análisis del Movimiento Armónico Simple (MAS) mediante el desarrollo de una herramienta de software en **Java**. El sistema automatiza el procesamiento de datos experimentales, calcula la constante elástica ($k$) mediante regresión lineal y simula el comportamiento de masas no medidas, asegurando la calidad del código mediante prácticas de ingeniería de software.

## 2. Metodología y Entorno de Desarrollo
Para cumplir con los estándares profesionales exigidos en la etapa final del proyecto (Semana 6), se implementó la siguiente infraestructura técnica:

* **Lenguaje:** Java 17.
* **Gestión de Dependencias:** **Apache Maven** (ver `pom.xml`), utilizado para integrar librerías y gestionar el ciclo de vida del proyecto.
* **Librerías Externas:**
    * `JFreeChart (v1.5.3)`: Para la generación profesional de gráficas científicas.
    * `JUnit 5 (v5.10.0)`: Para la implementación de pruebas unitarias automatizadas.
* **Control de Versiones:**
    * **Git & GitHub:** Se utilizó un archivo `.gitignore` para mantener el repositorio limpio, excluyendo archivos binarios (`target/`, `.class`) y configuraciones locales.
    * **Flujo de Trabajo:** Se emplearon ramas (branches) y Pull Requests para la integración segura de cambios.

---

## 3. Análisis Experimental (Semanas 2-4)

### 3.1 Adquisición de Datos
Se registraron oscilaciones para distintas masas ($m, 2m, 3m, 4m$). Los datos de posición vs. tiempo fueron digitalizados en archivos CSV para su procesamiento masivo.

![Gráfico Masa 4m](grafica_4m.png)
*Figura 1: Datos experimentales de posición vs. tiempo.*

### 3.2 Algoritmo de Mínimos Cuadrados
Se desarrolló la clase `MinimosCuadrados.java` para linealizar la relación $T^2 \propto m$. Esta clase fue **refactorizada** para incluir validaciones de seguridad que impiden el cálculo con conjuntos de datos vacíos o insuficientes.

Al procesar los datos, el software determinó los coeficientes de la recta $y = Ax + B$:
* **Pendiente ($A$):** Calculada computacionalmente.
* **Intersección ($B$):** Cercana a cero, validando el modelo teórico.
* **Constante Elástica ($k$):** Derivada de la pendiente como $k = 4\pi^2 / A$.

![Gráfico de Linealización](grafica_mmc_final.png)
*Figura 2: Ajuste lineal generado por el software ($R^2 \approx 1.0$).*

---

## 4. Predicción y Simulación (Semana 5 - Corregido)

### 4.1 Cálculo del Periodo para 9kg
Basado en los datos experimentales donde la masa unitaria ($m$) presentó un periodo base de $T \approx 2.0 \text{ s}$, se utilizó el modelo calibrado para predecir el comportamiento de una masa de **9 kg**.

Según la ley del MAS ($T \propto \sqrt{m}$), al aumentar la masa 9 veces, el periodo debe triplicarse ($\sqrt{9}=3$):
$$T_{9m} = T_m \cdot 3 = 2.0 \text{ s} \cdot 3 = \mathbf{6.00 \text{ s}}$$

### 4.2 Simulación Visual
El código principal (`AnalisisMovimiento.java`) fue actualizado para reflejar este cálculo físico. La simulación genera una onda senoidal con un periodo de 6 segundos, guardando automáticamente la evidencia visual.

![Predicción Masa 9m](grafica_9m_final.png)
*Figura 3: Simulación computacional corregida para la masa 9m (Periodo = 6.0s).*

---

## 5. Aseguramiento de Calidad (Semana 6)

Siguiendo los requerimientos de robustez y calidad de software, se implementó un módulo de pruebas unitarias (`Unit Testing`) en la carpeta `src/test/java`.

### 5.1 Módulos de Prueba (JUnit)
Se crearon tres clases de prueba para validar la integridad del código antes de la entrega:

1.  **`LinearLeastSquaresTest`:** Verifica la exactitud matemática del algoritmo usando datos ideales conocidos (pendiente unitaria).
2.  **`CoeficientesTest`:** Valida que el cálculo de $A$ y $B$ con datos experimentales simulados arroje valores dentro de rangos físicos posibles.
3.  **`SumaTest` (Integridad):** Prueba la resistencia del código ante datos atípicos (negativos, ceros) y asegura que se lancen excepciones controladas si los arrays son inválidos.

### 5.2 Limpieza del Repositorio
Se depuró el historial de Git eliminando la carpeta `target` y agregando un archivo `.gitignore`. Esto asegura que el repositorio sea portable y pueda ser clonado y compilado en cualquier máquina sin conflictos de versiones compiladas.

---

## 6. Conclusiones
1.  **Validación del Modelo:** La predicción computacional ($T=6s$ para $9m$) coincide con la teoría física, demostrando la validez del modelo linealizado.
2.  **Robustez:** La implementación de manejo de excepciones y validaciones en el constructor de `MinimosCuadrados` previene fallos en tiempo de ejecución.
3.  **Ingeniería de Software:** El uso combinado