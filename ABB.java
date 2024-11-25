class Nodo{
    int valor;
    Nodo izq;
    Nodo der;
    
    //Constructor
    public Nodo (int valor){
        this.valor = valor;
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
   * @param nodo actual en la recursión
   * @param "Valor" a insertar 
   * @return Nodo ya actualizado depsués de la inserción 
   */
    private Nodo insertarRecursivo (Nodo actual, int valor){
        if (actual == null) { 
            return new Nodo (valor); // se crea un nuevo nodo si se encuentra un lugar vacío
    }
    if (valor<actual.valor){
        actual.izq = insertarRecursivo(actual.izq, valor); //inserta en el subárbol izquierdo
    }else if (valor > actual.valor){
        actual.der = insertarRecursivo(actual.der, valor); //inserta enel subárbol derecho 
    }else{
        //Si el valor es el mismo, no se hace nada , (no permite duplicados)
        return actual;
    }
    return actual; // retorna el nodo actual para mantenerlo "actualizado"
  }
  
  //insertar nodo en árbol ( método público )
  public void insertar (int valor){
      raiz = insertarRecursivo (raiz, valor);
  }
  
  /**
   * Método para buscar valor en el árbol
   * @param nodo actual
   * @param "Valor" que se está buscando
   * @return true si se encuentra el valor y false en caso contrario
   */
  private boolean buscarRecursivo (Nodo actual, int valor){
      if (actual == null){
          return false; // no se encuentra valor 
      }
      
      if (valor == actual.valor){
          return true; // se encuentra valor ya que nodo actual es igual a nodo buscado
      }else if (valor < actual.valor){
          return buscarrecursiivo(actual.izq, valor); //si valor es menor se busca en el subárbol izquierdo
      }else{
          return buscarRecursivo(actual.der, valor); //si valor es mayor se busca en el subárbol derecho
      }
  }
  
  public boolean buscar(int valor) {
      return buscarRecursivo (raiz, valor);
  }
  
  private Nodo eliminarRecursivo (Nodo actual, int valor){
      if (actual == null){
          return null; // no se encuentra valor 
      }
      
      if (valor == actual.valor){
          // manejar elimnacion con o sin hijos 
          return manejarEliminacion(actual);
      }
      
      //se busca subárbol correspondiente......
      if (valor < actual.valor){
          actual.izq = eliminarRecursivo(actual.izq, valor);
      }else{
          actual.der = eliminarRecursivo(actual.der, valor);
      }
      return actual;
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
  private int encontrarMenorValor (Nodo actual){
      if (actual.izq == null){
          return actual.valor; //el nodo más a la izquierda es el menor valor 
      }
      return encontrarMenorValor(actual.izq); //continua búsqueda en el subárbol izquierdo
  }
  
  public void imprimirInOrdenRecursivo(Nodo nodo){
      if (nodo != null){
          imprimirINOrdenRecursivo(nodo.izq);
          System.out.print(nodo.valor + " ");
          imprimirInOrdenRecursivo(nodo.der);
      }
      
  }
}