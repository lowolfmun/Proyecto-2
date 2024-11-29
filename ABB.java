class Nodo{
    int valor;
    Nodo izq;
    Nodo der;

    //Constructor
    public Nodo (int valor){
        this.valor = valor; //valor dentro del nodo (numero)
        this.izq = null;
        this.der = null;
    }
}

//árbol
public class ABB {
    private Nodo raiz;

    // Constructor
    public ABB() {
        this.raiz = null; //inicializa arbol vacío
    }

    /**
     * Método recursivo para inserción.
     * @param nodo nodoActual en la recursión
     * @param "Valor" a insertar 
     * @return Nodo ya nodoActualizado depsués de la inserción 
     */
    private Nodo insertarRecursivo (Nodo nodoActual, int valor){
        if (nodoActual == null) { 
            return new Nodo (valor); // se crea un nuevo nodo si se encuentra un lugar vacío
        }
        if (valor<nodoActual.valor){
            nodoActual.izq = insertarRecursivo(nodoActual.izq, valor); //inserta en el subárbol izquierdo
        }else if (valor > nodoActual.valor){
            nodoActual.der = insertarRecursivo(nodoActual.der, valor); //inserta enel subárbol derecho 
        }else{
            //Si el valor es el mismo, no se hace nada , (no permite duplicados)
            return nodoActual;
        }
        return nodoActual; // retorna el nodo nodoActual para mantenerlo "nodoActualizado"
    }

    //insertar nodo en árbol ( método público )
    public void insertar (int valor){
        raiz = insertarRecursivo (raiz, valor);
    }
    
    public Nodo getRaiz(){
        return raiz; 
    }

    /**
     * Método para buscar valor en el árbol
     * @param nodo nodoActual
     * @param "Valor" que se está buscando
     * @return true si se encuentra el valor y false en caso contrario
     */
    private boolean buscarRecursivo (Nodo nodoActual, int valor){
        if (nodoActual == null){
            return false; // no se encuentra valor 
        }

        if (valor == nodoActual.valor){
            return true; // se encuentra valor ya que nodo nodoActual es igual a nodo buscado
        }else if (valor < nodoActual.valor){
            return buscarRecursivo(nodoActual.izq, valor); //si valor es menor se busca en el subárbol izquierdo
        }else{
            return buscarRecursivo(nodoActual.der, valor); //si valor es mayor se busca en el subárbol derecho
        }
    }

    public boolean buscar(int valor) {
        return buscarRecursivo (raiz, valor);
    }

    private Nodo eliminarRecursivo (Nodo nodoActual, int valor){
        if (nodoActual == null){
            return null; // no se encuentra valor 
        }

        if (valor == nodoActual.valor){
            // manejar elimnacion con o sin hijos 
            return manejarEliminacion(nodoActual);
        }

        //se busca subárbol correspondiente......
        if (valor < nodoActual.valor){
            nodoActual.izq = eliminarRecursivo(nodoActual.izq, valor);
        }else{
            nodoActual.der = eliminarRecursivo(nodoActual.der, valor);
        }
        return nodoActual;
    }

    //Método público para eliminar valor (público)
    public void eliminar (int valor){
        raiz = eliminarRecursivo(raiz, valor);
    }

    /**
     * Método para el manejo del caso de un nodo con dos hijos, se separa del método "eliminar" grande para que se tenga un mayor orden en el código 
     */
    private Nodo manejarNodoConDosHijos(Nodo nodo){
        int menorValor = encontrarMenorValor(nodo.der); //se encuentra "sucesor" (el menor en el subárbol derecho), se utiliza menor del subárbol derecho ya que se respeto el "inorder"
        nodo.valor = menorValor; //reemplaza el valor del nodo por sucesor
        nodo.der = eliminarRecursivo (nodo.der, menorValor);
        return nodo;
    }

    /**
     * Método para distintos casos específicos de eliminación
     * - Nodo sin hijos
     * - Nodo con solo un hijo
     * - Nodo con dos hijos
     */
    private Nodo manejarEliminacion(Nodo nodo) {
        //primer caso
        if (nodo.izq == null && nodo.der == null){
            return null;
        }
        //segundo caso
        if (nodo.izq == null) {
            return nodo.der; // retorna hijo derecho 
        }
        if (nodo.der == null) {
            return nodo.izq; // retorna hijo izquierdo
        }
        //tercer caso 
        return manejarNodoConDosHijos(nodo);
    }

    /**
     * Método para encontrar menor valor de algún subárbol
     */
    private int encontrarMenorValor (Nodo nodoActual){
        if (nodoActual.izq == null){
            return nodoActual.valor; //el nodo más a la izquierda es el menor valor 
        }
        return encontrarMenorValor(nodoActual.izq); //continua búsqueda en el subárbol izquierdo
    }

    public void imprimirInOrdenRecursivo(StringBuilder concatenador, Nodo nodo){
        if (nodo != null){
            imprimirInOrdenRecursivo(concatenador, nodo.izq); //recorre subárbol izq
            concatenador.append(nodo.valor).append(" "); //se añade el valor del nodo nodoActual
            imprimirInOrdenRecursivo(concatenador, nodo.der); //recorre subárbol derecho
        }

    }
    


    /**
     * Método recursivo para graficar árbol
     * @param Nodo nodo: nodo nodoActual del árbol qu ese esta procesando
     * @param String marcador líneas o espacios para acomodar los nodos
     * @param boolean esUltimo Indica si es el nodo es el último hijo de su padre
     * @param StringBuilder concatenador 
     * 
     * └── --> para el último hijo
     * ├── --> para otros hijos
     * Para espacios entre niveles se utiliza │ (incluído en el marcador)
     * 
     * Prefijo: al inicio es un String vacío  ya que la raíz llega de una y no necesita espacio adicional, , en la raiz esUltimo es true
     * ya que es el último y único en el primer nivel 
     * 
     * para hijos izquierdos: se hace un nuevoPrefijo como marcador + │
     * como no es ultimo se agreganla linea vertical junto con los guiones (├──) ya que aún queda otro hijo por dibujar 
     * 
     * para hijos derechos: se tiene el marcador + un espacio (" ")
     * es último es true asi que se agrega (└──) ya que es el nodo final de su nivel 
     */
    private void dibujarArbolRecursivo(Nodo nodo, String marcador, boolean esUltimo, StringBuilder concatenador) {
        if (nodo != null) { //Si no hay nada no va a dibujar nada
            concatenador.append(marcador);
            concatenador.append(esUltimo ? "└── " : "├── "); //si es true (último) se pone └──, si no (false) se pone ├──
            concatenador.append(nodo.valor).append("\n"); //Se agrega valor de nodo actual y hace salto de linea

            String nuevoPrefijo = marcador + (esUltimo ? "    " : "│   "); //Construye nuevo marcador para loshiijos, si es el último solo se agrega un espacio vacío pero si no es el ultimo se agrega una linea vertical que conecta con más nodos
            dibujarArbolRecursivo(nodo.izq, nuevoPrefijo, false, concatenador);
            dibujarArbolRecursivo(nodo.der, nuevoPrefijo, true, concatenador);
        }
    }
    //  método para representar el árbol de forma gráfica 
    public String dibujarArbol() {
        if (raiz == null) {
            return "Árbol vacío";
        }
        StringBuilder concatenador = new StringBuilder();
        dibujarArbolRecursivo(raiz, "", true, concatenador);
        return concatenador.toString();
    }
}
