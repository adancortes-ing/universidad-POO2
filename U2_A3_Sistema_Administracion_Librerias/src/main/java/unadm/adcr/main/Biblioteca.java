package unadm.adcr.main;

import java.util.ArrayList;

public class Biblioteca {
    
    private final ArrayList<Libro> libros = new ArrayList<>();
    
    public void agregarLibro(Libro libro){
        libros.add(libro);
    }
    
    public ArrayList<Libro> obtenerListado(){
        return libros;
    }
    
}
