# Teoría de Git

## ¿Qué es Git?
Git es un sistema de control de versiones distribuido creado por Linus Torvalds (el mismo creador de Linux) en 2005.  
Su propósito es registrar los cambios realizados en los archivos de un proyecto a lo largo del tiempo, de modo que varios desarrolladores puedan trabajar simultáneamente sin perder información ni sobrescribir el trabajo de otros.

En lugar de guardar copias completas del proyecto cada vez que se hace un cambio, Git almacena diferencias (deltas) entre versiones, lo que hace el proceso eficiente y rápido.

## ¿Por qué usar Git?

Git se ha convertido en una herramienta fundamental en el desarrollo de software moderno por las siguientes razones:

1. Colaboración eficiente:
   Permite que varios programadores trabajen en el mismo proyecto, combinando sus cambios sin conflictos.

2. Historial completo del proyecto:
   Cada modificación queda registrada con la fecha, el autor y un mensaje descriptivo.

3. Seguridad y respaldo:  
   Al ser distribuido, cada desarrollador tiene una copia completa del historial del proyecto.  
   Aunque el servidor (por ejemplo, GitHub) falle, el repositorio puede recuperarse desde cualquier clon.

4. Control y reversión de errores: 
   Si algo sale mal, se puede volver fácilmente a una versión anterior.

5. Integración con plataformas modernas:
   Git se integra con herramientas como GitHub, GitLab y Bitbucket, que facilitan el trabajo en equipo, revisiones de código y despliegues automáticos.
   
## ¿Cuándo usar Git?

Git puede usarse prácticamente en cualquier proyecto de software, sin importar su tamaño.  
Se recomienda usarlo:

- Desde el inicio de un proyecto, para mantener un registro de todos los cambios.  
- Cuando se trabaja en equipo y se necesita una forma ordenada de integrar código.  
- En proyectos académicos o profesionales, para entregar versiones claras y verificables.  
- En experimentación: puedes crear ramas (branches) para probar nuevas ideas sin afectar el código principal.

## Comandos fundamentales de Git

| Comando | Descripción |

| git init | Inicializa un nuevo repositorio Git local. |

| git clone <url> | Crea una copia local de un repositorio remoto. |

| git status | Muestra los archivos modificados y pendientes de confirmar. |

| git add <archivo> | Añade un archivo al área de preparación (staging). |

| git commit -m "mensaje` | Guarda los cambios en el historial local. |

| git push | Envía los commits locales al repositorio remoto (por ejemplo, GitHub). |

| git pull | Descarga y fusiona los cambios del repositorio remoto. |



| git branch | Muestra o crea ramas en el proyecto. |

| git checkout <rama> | Cambia entre ramas o versiones del código. |

| git merge <rama> | Combina los cambios de una rama en otra. |
