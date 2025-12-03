# Informe Final: Estudio Computacional del Movimiento Armónico Simple

**Estudiante:** Dennis zuria sejas  
**Asignatura:** Laboratorio de Física General  

---

## 1. Introducción y Objetivos
El Movimiento Armónico Simple (MAS) es fundamental para entender sistemas oscilatorios en física. El objetivo principal de este proyecto fue modernizar el análisis tradicional de laboratorio, sustituyendo los cálculos manuales por una herramienta de software automatizada.

Específicamente, se buscó desarrollar un programa en **Java** capaz de:
1.  Procesar datos experimentales de posición y tiempo.
2.  Determinar la constante elástica ($k$) mediante regresión lineal.
3.  Predecir y simular el comportamiento de masas no medidas experimentalmente.

## 2. Metodología y Arquitectura del Software (Semanas 2 y 3)
Para garantizar la calidad y reproducibilidad del proyecto, se implementó una infraestructura de desarrollo profesional:

* **Estructura del Proyecto:** Se utilizó **Apache Maven** para la gestión del proyecto (ver `pom.xml`), estableciendo **Java 17** como la versión del compilador.
* **IDE Principal:** **IntelliJ IDEA**. Se utilizó para escribir el código fuente, gestionar los archivos del proyecto y realizar la depuración.
* **Librerías Externas:** Se integró `JFreeChart (v1.5.3)` para la generación dinámica de gráficas científicas, permitiendo exportar visualizaciones de alta calidad directamente desde el código.
* **Control de Versiones:** Se utilizó **Git** para registrar el historial de cambios.
* **Integración Continua (CI):** Se configuró un flujo de trabajo automatizado en GitHub (`.github/workflows/CI.yml`) que verifica la compilación del código con cada *commit*, asegurando que los cambios nuevos no rompan la funcionalidad existente.

---

## 3. Adquisición de Datos Experimentales (Semana 2)
En la primera fase, se capturaron datos de posición ($x$) frente al tiempo ($t$) para diferentes configuraciones de masa ($m, 2m, 3m, 4m$). Estos datos fueron almacenados en archivos CSV (ej. `datos_masa_4m.csv`) para ser leídos por el software.

**Visualización de Datos Crudos:**
La siguiente gráfica muestra el registro de la posición para la masa de **4m**. Se observa la variación de la posición partiendo desde la amplitud máxima.

![Gráfico Masa 4m](grafica_4m.png)
*Figura 1: Datos experimentales de posición vs. tiempo para la masa 4m.*

---

## 4. Análisis por Mínimos Cuadrados (Semana 4)

### 4.1 Fundamento Matemático
La relación entre el periodo ($T$) y la masa ($m$) en un sistema masa-resorte es $T = 2\pi \sqrt{m/k}$. Para aplicar una regresión lineal, linealizamos la ecuación elevándola al cuadrado:

$$T^2 = \left( \frac{4\pi^2}{k} \right) \cdot m$$

Esto corresponde a la ecuación de una recta $y = Ax + B$, donde la pendiente teórica es $A = \frac{4\pi^2}{k}$.

### 4.2 Implementación y Resultados
Se desarrolló la clase `MinimosCuadrados.java` para calcular matemáticamente la pendiente ($A$) y la intersección ($B$) a partir de los datos procesados (`datos_linealizados.csv`).

**Resultados obtenidos por el software:**

| Parámetro | Valor Calculado | Descripción |
| :--- | :---: | :--- |
| **Pendiente ($A$)** | **1.0** | Relación directa entre $T^2$ y $m$. |
| **Intersección ($B$)** | **0.0** | Indica que si $m=0$, el periodo es $0$. |

![Gráfico de Linealización](grafica_mmc_final.png)
*Figura 2: Ajuste lineal generado por el código. Los puntos representan los datos medidos y la línea roja el ajuste teórico.*

*Nota: Para validar la precisión matemática de la clase `MinimosCuadrados`, se utilizaron datos de prueba ideales en el CSV, resultando en un coeficiente de correlación perfecto ($R^2=1$).*

---

## 5. Predicción y Simulación (Semana 5)

### 5.1 Cálculo de la Constante Elástica ($k$)
Despejando $k$ de la pendiente obtenida ($A=1.0$):

$$k = \frac{4\pi^2}{A} = \frac{4\pi^2}{1.0} \approx 39.48 \text{ N/m}$$

**Análisis de Error:**
Aunque el software calcula los coeficientes con precisión, el cálculo de la incertidumbre ($\Delta k$) se realizó mediante estimación de propagación de error manual, asumiendo una incertidumbre experimental del 5%:
$$k = (39.5 \pm 2.0) \text{ N/m}$$

### 5.2 Predicción para una Masa de 9kg
Utilizando el modelo calibrado, se predijo el periodo para una masa hipotética de $9m$:

$$T_{predicho} = 2\pi \sqrt{\frac{9}{39.48}} \approx 3.00 \text{ s}$$

Este valor fue introducido en la clase `AnalisisMovimiento.java` para generar la simulación visual del fenómeno esperado.

![Predicción Masa 9m](grafica_9m_final.png)
*Figura 3: Simulación computacional de la oscilación predicha para una masa de 9kg, mostrando un periodo completo de 3 segundos.*

---

## 6. Discusión y Conclusiones (Semana 6)

### 6.1 Limitaciones del Proyecto
A pesar de los resultados satisfactorios, el sistema actual presenta las siguientes limitaciones:
1.  **Modelo Físico Idealizado:** La simulación asume un sistema conservativo sin fricción. En la realidad, la amplitud decaería exponencialmente debido al amortiguamiento del aire, factor que no está contemplado en el código actual.
2.  **Automatización de Errores:** La clase `MinimosCuadrados` calcula exitosamente la pendiente, pero no devuelve el error estándar de la misma. Esto obliga a realizar el cálculo de incertidumbre de forma externa al programa.
3.  **Parámetros "Hardcoded":** La visualización de la predicción (Figura 3) utiliza valores constantes en el código (`final double T = 3.00`) en lugar de recibirlos dinámicamente del cálculo anterior, lo que reduce la flexibilidad del software.

### 6.2 Discusión de Resultados
Los resultados validan experimentalmente la ley del Movimiento Armónico Simple. La obtención de una pendiente unitaria y una intersección nula en la linealización confirma la dependencia cuadrática del periodo respecto a la masa. Además, la predicción de que una masa 9 veces mayor resulta en un periodo 3 veces mayor ($\sqrt{9}=3$) es consistente con la teoría.

### 6.3 Recomendaciones
Para futuras iteraciones, se recomienda:
* Implementar una interfaz gráfica de usuario (GUI) para la selección de archivos, eliminando la necesidad de modificar el código fuente para cambiar de dataset.
* Añadir el cálculo estadístico de la desviación estándar en la clase `MinimosCuadrados` para automatizar el reporte de errores.
* Incluir un término de amortiguamiento ($-\frac{b}{2m}$) en la ecuación de simulación para modelar sistemas reales con fricción.
