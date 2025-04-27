# Requerimientos y explicación
### En este pequeño documento haré un repaso rápdio y dividiré la explicación en: 

* Lo que tenemos. 
* Lo que necesitamos.
* Cómo lo abordaremos.

## Lo que tenemos y cómo lo abordaremos:

#### Actualmente tenemos 3 clases. Clase Cliente, GestorCSV y Indice. ahora haŕe un análisis de las 3 y veré que es lo que hacen.

## Resumen breve

#### 1. `GestorCSV`
- Administra una tabla de datos (`String[][] datos`).
- Carga datos, imprime, crea índices en columnas.
- Permite buscar rápidamente usando esos índices.

#### 2. `Indice`
- Guarda valores únicos de una columna y sus posiciones (filas).
- Facilita búsquedas rápidas de un valor sin recorrer toda la tabla.

#### 3. `Cliente`
- Clase principal que **usa** `GestorCSV`.
- Carga un conjunto de datos (estudiantes y asignaturas).
- Crea índices y (comentado) podría buscar, imprimir o listar datos.
- Es quien **prueba** y **usa** toda la lógica de `GestorCSV` e `Indice`.

#### 4. Relación entre `GestorCSV` e `Indice`
- `GestorCSV` crea un `Indice` para cada columna indexada.
- Usa el `Indice` para buscar valores de forma eficiente.

#### Resumen en una línea
- `GestorCSV`: Gestor de datos tipo CSV con soporte para índices.
- `Indice`: Estructura para búsquedas rápidas por valor en columnas.

## Lo que necesitamos

Refactorizar la estructura de clases relacionada a los índices para permitir distintas estrategias de indexación (ordenada, no ordenada, etc.).

---

#### Cambios a Realizar

1. **Crear una clase abstracta `Indice`**
   - Será la base para todas las implementaciones de índices.
   - Definirá los métodos esenciales que deben implementar las clases hijas:
     - `agregar(String valor, int posicion)`
     - `buscar(String valor)`
     - `contiene(String valor)`
     - `obtenerTodos()`

2. **Renombrar la clase actual `Indice` a `IndiceTabla`**
   - `IndiceTabla` extenderá la clase `Indice`.
   - Mantendrá el comportamiento actual (almacena valores sin ordenarlos).

3. **Crear una nueva clase `IndiceOrdenado`**
   - Extenderá también de `Indice`.
   - Implementará una estrategia de almacenamiento ordenado de los valores:
     - Al agregar, los datos se insertarán en la posición correcta para mantener el orden.
     - La búsqueda se podrá hacer de forma más eficiente (por ejemplo, usando búsqueda binaria).

---


