package Pilas;

public class Pila {

    private Nodo cabeza = null;
    private int longitud = 0;

    private class Nodo {
        //Creación del nodo
        public Libro libro;
        public Nodo siguiente = null;

        public Nodo(Libro libro) {
            this.libro = libro;
        }
    }
    //Inserción del elemento
    public void Push(Libro libro) {
        Nodo nodo = new Nodo(libro);
        nodo.siguiente = cabeza;
        cabeza = nodo;
        longitud++;
    }
    //Elimina la Pila
    public void VaciarPila() {
        if (cabeza != null) {
            Nodo primer=cabeza;
            cabeza=cabeza.siguiente=null;
            primer.siguiente=null;
            cabeza=cabeza;
            longitud--;
        }
    }
    //Elimina el elemento del inicio, desapila
    public void Pop() {
        if (cabeza != null) {
            Nodo primer = cabeza;
            cabeza = cabeza.siguiente;
            primer.siguiente = null;
            longitud--;
        }
    }
    //Retorna el valor de la longitud de la pila
    public int Tamaño() {
        return longitud;
    }
    //Verifica si la pila está vacía o no
    public boolean Vacio() {
        return longitud == 0;
    }

    public Libro Obtener() {
        if (cabeza == null) {
            return null;
        } else {
            return cabeza.libro;
        }
    }
    //Muestra el contenido de los datos ingresados
    public String MostrarDatos() {
        String Dato = " ";
        Nodo aux = cabeza;
        while (aux != null) {
            Dato += "\nAutor: " + aux.libro.getAutor() + "\nTítulo: " + aux.libro.getTitulo() + "\nISBN: " + aux.libro.getIsbn() + "\n";
            aux = aux.siguiente;
        }
        return (Dato);
    }
    //Obtiene el libro ´por posición
    public Libro obtenerLibro(int n) {
        if (cabeza == null) {
            return null;
        } else {
            Nodo puntero = cabeza;
            int contador = 0;
            while (contador < n && puntero.siguiente != null) {
                puntero = puntero.siguiente;
                contador++;
            }
            if (contador != n) {
                return null;
            } else {
                return puntero.libro;
            }
        }
    }
}
