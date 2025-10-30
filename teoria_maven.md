# Teoría de Maven

## ¿Qué es Maven?

Apache Maven es una herramienta de gestión y automatización de proyectos Java.  
Su nombre viene de una palabra yidis que significa “acumulador de conocimiento”, y su objetivo principal es simplificar la construcción (build), el manejo de dependencias y la organización de proyectos en Java.

Antes de Maven, los desarrolladores configuraban manualmente librerías y rutas, lo que podía causar conflictos entre versiones o errores de compilación. Maven resuelve esto usando un archivo de configuración central llamado pom.xml (roject Object Model).

## Objetivos principales de Maven

1. Estandarizar proyectos Java 
   Todos los proyectos Maven tienen la misma estructura de carpetas, facilitando que cualquier programador pueda entenderlos rápidamente.

2. Gestionar dependencias automáticamente 
   Ya no es necesario descargar manualmente librerías (.jar).  
   Maven las descarga desde un repositorio central de Apache o de Internet.

3. Automatizar el proceso de construcción (build) 
   Con un solo comando (mvn package), Maven puede compilar, probar, empaquetar y generar el .jar o .war del proyecto.

4. Integrar herramientas de prueba y despliegue  
   Soporta frameworks como JUnit, TestNG o Mockito, y puede integrarse con CI/CD (por ejemplo, Jenkins o GitHub Actions).

## ¿Por qué usar Maven?

| Razón | Descripción |
| Automatización | Permite compilar, probar y empaquetar con un solo comando. |

| Gestión de dependencias | Descarga e instala automáticamente las librerías necesarias. |

| Estructura estándar | Todos los proyectos Maven siguen la misma estructura de carpetas. |

| Reproducibilidad | Cualquier desarrollador puede clonar y ejecutar el proyecto fácilmente. |

| Repositorios remotos | Acceso a miles de librerías Java en el repositorio central de Maven. |

