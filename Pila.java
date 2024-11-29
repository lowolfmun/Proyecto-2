public class Pila {
    // Atributos que representan los extremos de la pila (doblemente enlazada)
    private Nodo primero; // Primer nodo de la pila
    private Nodo ultimo;  // Último nodo de la pila

    // Clase interna que define un nodo de la pila
    private class Nodo {
        private int valor;       // Valor almacenado en el nodo
        private Nodo siguiente;  // Referencia al siguiente nodo
        private Nodo anterior;   // Referencia al nodo anterior

        // Constructor que inicializa un nodo con un valor
        public Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null; // Inicialmente no apunta a ningún nodo siguiente
            this.anterior = null;  // Inicialmente no apunta a ningún nodo anterior
        }
    }

    // Constructor que inicializa una pila vacía
    public Pila() {
        this.primero = this.ultimo = null; // Ambos extremos son nulos al inicio
    }

    // Método para agregar un elemento al final de la pila
    public void push(int elemento) {
        Nodo nuevo = new Nodo(elemento); // Crea un nuevo nodo con el valor dado
        if (primero == null) { 
            // Si la pila está vacía, este nodo es el primero y el último
            primero = nuevo;
            ultimo = nuevo;
        } else { 
            // Si la pila no está vacía, se enlaza al final
            Nodo actual = this.ultimo;
            actual.siguiente = nuevo; // El último nodo apunta al nuevo
            nuevo.anterior = actual; // El nuevo nodo apunta al anterior
            this.ultimo = nuevo;     // Se actualiza el último nodo
        }
    }

    // Método para eliminar el último elemento de la pila
    public void pop() {
        if (ultimo != null) { 
            // Si la pila no está vacía, el último se mueve al nodo anterior
            ultimo = ultimo.anterior;
        }
    }

    // Método para buscar un valor en la pila
    public boolean buscar(int elemento) {
        boolean existe = false; // Indica si el elemento fue encontrado
        Nodo actual = this.primero; // Comienza desde el primer nodo
        while (actual != null && !existe) {
            if (actual.valor == elemento) {
                existe = true; // Se encontró el valor
            } else {
                actual = actual.siguiente; // Avanza al siguiente nodo
            }
        }
        return existe; // Devuelve true si lo encontró, false si no
    }

    // Método auxiliar para dibujar la pila de forma recursiva
    private void dibujarPilaRecursivo(Nodo nodo, StringBuilder concatenador) {
        if (nodo != null) { 
            dibujarPilaRecursivo(nodo.anterior, concatenador); // Llama al anterior
            concatenador.append("| ").append(nodo.valor).append("\n"); // Agrega el valor
        }
    }

    // Método para devolver una representación textual de la pila
    public String dibujarPila() {
        if (ultimo == null) { 
            return "Pila vacia"; // Mensaje si la pila está vacía
        }
        StringBuilder concatenador = new StringBuilder();
        dibujarPilaRecursivo(ultimo, concatenador); // Llama al método recursivo
        return concatenador.toString();
    }
}
