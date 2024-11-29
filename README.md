Proyecto 2: Pila y Árbol Binario

Este proyecto implementa una interfaz gráfica en Java utilizando Swing que permite a los usuarios interactuar con dos estructuras de datos: una pila y un árbol binario de búsqueda (ABB). El proyecto permite realizar operaciones básicas sobre estas estructuras como insertar, eliminar, buscar y mostrar sus contenidos.
Requisitos

    Java 8 o superior: El proyecto fue desarrollado utilizando Java 8 y hace uso de la biblioteca Swing para la interfaz gráfica.
    IDE recomendado: IntelliJ IDEA, Eclipse o cualquier IDE que soporte desarrollo en Java.

Estructura del Proyecto

El proyecto está compuesto por varias clases que interactúan entre sí para proporcionar una interfaz visual que permite trabajar con las estructuras de datos mencionadas. Las clases principales son:

    Main: Clase que inicia la aplicación.
    VentanaPrincipal: Ventana principal de la aplicación que permite seleccionar entre las funcionalidades de la pila y el árbol binario.
    VentanaPila: Ventana gráfica para interactuar con la pila, permitiendo operaciones como Push, Pop y Buscar.
    VentanaArbol: Ventana gráfica para interactuar con el árbol binario de búsqueda, permitiendo operaciones como Insertar, Eliminar y Buscar.
    Pila: Implementación de la estructura de datos pila con operaciones de inserción, eliminación y búsqueda.
    ABB: Implementación del árbol binario de búsqueda con operaciones de inserción, eliminación, búsqueda y representación gráfica del árbol.

Funcionalidad
Ventana Principal (VentanaPrincipal)

    Permite al usuario seleccionar entre dos opciones:
        Árbol Binario: Abre una ventana para interactuar con el árbol binario de búsqueda.
        Pila: Abre una ventana para interactuar con la pila.

Ventana de la Pila (VentanaPila)

    El usuario puede realizar las siguientes operaciones:
        Push: Inserta un número en la pila.
        Pop: Elimina el último número insertado de la pila.
        Buscar: Busca un número en la pila y muestra si está presente o no.

Ventana del Árbol Binario (VentanaArbol)

    El usuario puede realizar las siguientes operaciones:
        Insertar: Inserta un número en el árbol binario de búsqueda.
        Eliminar: Elimina un número del árbol.
        Buscar: Busca un número en el árbol y muestra si está presente o no.
        Mostrar: Representa gráficamente el árbol utilizando una estructura de texto.

Pila (Pila)

    Implementa una pila utilizando una lista doblemente enlazada. Las operaciones disponibles son:
        Push: Inserta un número al final de la pila.
        Pop: Elimina el último número de la pila.
        Buscar: Busca un número dentro de la pila.

Árbol Binario de Búsqueda (ABB)

    Implementa un árbol binario de búsqueda con las siguientes operaciones:
        Insertar: Inserta un número en el árbol respetando las reglas de un árbol binario de búsqueda.
        Eliminar: Elimina un número del árbol. Maneja los tres casos de eliminación:
            Nodo sin hijos.
            Nodo con un solo hijo.
            Nodo con dos hijos.
        Buscar: Busca un número en el árbol.
        Mostrar: Representa gráficamente el árbol en formato textual.

Instalación y Ejecución

    Clonar el repositorio:

git clone https://github.com/lowolfmun/Proyecto-2

Compilar el proyecto:

Si estás utilizando un IDE como IntelliJ IDEA o Eclipse, simplemente importa el proyecto y compílalo. Si prefieres compilar desde la línea de comandos:

javac *.java

Ejecutar la aplicación:

Después de compilar el proyecto, ejecuta la clase Main para iniciar la aplicación.

    java Main

    Interfaz gráfica:

    La ventana principal te permitirá elegir entre trabajar con la pila o el árbol binario. Sigue las instrucciones en pantalla para insertar, eliminar y buscar elementos.

Detalles Técnicos
Clase Nodo:

    Define los nodos tanto para la pila como para el árbol binario.
    Cada nodo tiene un valor y enlaces a los nodos vecinos (siguiente y anterior en la pila, izquierdo y derecho en el árbol).

Clase Pila:

    Implementación de una pila utilizando una lista doblemente enlazada.
    Métodos:
        push(int valor): Inserta un valor en la pila.
        pop(): Elimina el último valor de la pila.
        buscar(int valor): Busca un valor en la pila.

Clase ABB:

    Implementación de un árbol binario de búsqueda.
    Métodos:
        insertar(int valor): Inserta un valor en el árbol.
        eliminar(int valor): Elimina un valor del árbol.
        buscar(int valor): Busca un valor en el árbol.
        dibujarArbol(): Representa gráficamente el árbol de manera textual.