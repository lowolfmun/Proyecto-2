public class Pila{
    private Nodo primero;

    private class Nodo{
        private int valor;
        private Nodo siguiente;

        public Nodo(int valor){
            this.valor = valor;
            this.siguiente = null;
        }
    }

    public Pila(){
        this.primero = null;
    }

    public void agregarAlInicio(int elemento){
		Nodo nuevo = new Nodo(elemento);
		nuevo.siguiente = primero;
		primero = nuevo;
	}

    public void agregarAlFinal(int elemento){
		Nodo nuevo = new Nodo(elemento);
		if(primero == null){ 
			primero = nuevo;
		}
		else{ 
			Nodo actual = primero;
			while(actual.siguiente != null){
				actual = actual.siguiente;
			}
			actual.siguiente = nuevo;
		}
	}

	public Nodo buscarAnterior(int posicion){
		int posicionActual = 0;
		Nodo actual = this.primero;
		while(actual != null  && posicionActual + 1 != posicion){
			posicionActual++;
			actual = actual.siguiente;
		}
		return actual;
	}

	public boolean push (int posicion, int elemento){
		boolean insertado = false;
		if(posicion == 0){
			agregarAlInicio(elemento);
			insertado = true;
		}
		else if(posicion > 0 && primero != null){
			Nodo anterior = buscarAnterior(posicion);
			if(anterior != null){
				Nodo nuevo = new Nodo(elemento);
				nuevo.siguiente = anterior.siguiente;
				anterior.siguiente = nuevo;
				insertado = true;
			}
		}
		return insertado;
	}

    public boolean pop(int posicion){
		boolean borrado = false;
		if(posicion >= 0 && primero != null){
			if(posicion == 0){
				Nodo temporal = primero;
				this.primero = primero.siguiente;
				temporal.siguiente = null;
				temporal = null;
				borrado = true;
			}
			else{
				Nodo actual = buscarAnterior(posicion);
				if(actual != null){
					Nodo borrar = actual.siguiente;
					if(borrar == null || borrar.siguiente == null){
						actual.siguiente = null;
						borrar = null;
						borrado = true;
					}
					else{
						actual.siguiente = borrar.siguiente;
						borrar.siguiente = null;
						borrar = null;
						borrado = true;
					}
				}
			}
		}
		return borrado;
	}


}