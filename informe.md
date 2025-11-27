# Informe del Laboratorio de Física General: Movimiento Armónico Simple

## 1. Fundamento Teórico

El Movimiento Armónico Simple es un movimiento periódico, oscilatorio y vibratorio, producido por la acción de una fuerza recuperadora que es directamente proporcional al desplazamiento respecto a la posición de equilibrio ($x=0$).

La fuerza restauradora, según la Ley de Hooke, está dada por:

   ## F = -kx ##

Donde $k$ es la constante elástica. La relación para el Periodo ($T$) es:

$$T = 2\pi \sqrt{\frac{m}{k}}$$

## 2. Resultados de los Cálculos

### 2.1 Cálculo de la Constante Elástica del Resorte ($k$)

Utilizando los datos de la Tabla 6 (Masa $m$), se observa que el Periodo ($T_m$) es de $2.0$ segundos (pues de $t=0.0s$ a $t=1.0s$ se recorre medio periodo, $T/2$).

Despejando $k$ de la fórmula del Periodo:
$$k = 4\pi^2 \frac{m}{T^2}$$
$$k = 4\pi^2 \frac{m}{(2.0)^2} = \pi^2 m$$

**Resultado:** La constante elástica es $k = \pi^2 m$.

### 2.2 Cálculo del Periodo de Oscilación para una masa $9m$

El Periodo es proporcional a la raíz cuadrada de la masa ($T \propto \sqrt{m}$).

$$T_{9m} = T_m \cdot \sqrt{\frac{9m}{m}} = 3 \cdot T_m$$

Dado que $T_m = 2.0s$:
$$T_{9m} = 3 \cdot 2.0 \text{ s} = 6.0 \text{ s}$$

**Resultado:** El periodo para una masa de $9m$ es de **$6.0$ segundos**.

## 3. Consideraciones de Error

El análisis de datos debe considerar los siguientes errores de medición, con la posición de equilibrio en $x=0$:
* Tiempo ($t_e$): $0.001 [s]$
* Posición ($x_e$): $0.001 [m]$
* Velocidad ($v_e$): $0.001 [m/s]$

## 4. Adjunto de Gráficos
![Gráfico de Posición vs. Tiempo (Masa 4m)](grafica_4m.png)

## 4. Resultados del Análisis de Mínimos Cuadrados (MMC)

El ajuste lineal de los datos transformados ($T^2$ vs $m$) produjo una línea recta con los siguientes coeficientes, validando la relación teórica $T^2 \propto m$:

| Coeficiente | Valor Obtenido |
| :---: | :---: |
| Pendiente (A) | **1.0** |
| Intersección (B) | **0.0** |

### Cálculo de la Constante Elástica (k)

Utilizando la Pendiente $A$, se calcula la constante $k$ con la fórmula $k = 4\pi^2 / A$:

$$k = \frac{4\pi^2}{1.0} \approx 39.48$$

**Resultado Final:** La constante elástica del resorte es **$k = 39.48 \text{ N/m}$**.

### Gráfico de Ajuste Lineal:

aqui el gráfico que muestra la linealización de los datos y la recta de ajuste obtenida.

![Gráfico Linealizado de T² vs Masa](grafica_mmc_final.png)
