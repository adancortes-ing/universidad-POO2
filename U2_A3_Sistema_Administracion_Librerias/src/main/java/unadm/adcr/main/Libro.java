package unadm.adcr.main;

public class Libro {

    private final String nombre;
    private final String autor;
    private final String isbn;
    private final String editorial;
    private final int anio;
    private final double precio;
    private final int stock;

    public Libro(String nombre, String autor, String isbn, String editorial, int anio, double precio, int stock) {

        this.nombre = nombre;
        this.autor = autor;
        this.isbn = isbn;
        this.editorial = editorial;
        this.anio = anio;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAnio() {
        return anio;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
    
    

}
