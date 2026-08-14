package unadm.adcr.main;

public class Mascota {

    private final int idMascota;
    private final String nombreMascota, nombreCliente;
    private final String tipoMascota, sexo;
    private final int edadMeses;
    private final double peso;
    private final String agresividad;
    private final String detallesClinicos;
    private final String anotaciones;

    public Mascota(int idMascota, String nombreMascota, String nombreCliente, String tipoMascota,
            String sexo, int edadMeses, double peso, String agresividad,
            String detallesClinicos, String anotaciones) {

        this.idMascota = idMascota;
        this.nombreMascota = nombreMascota;
        this.nombreCliente = nombreCliente;
        this.tipoMascota = tipoMascota;
        this.sexo = sexo;
        this.edadMeses = edadMeses;
        this.peso = peso;
        this.agresividad = agresividad;
        this.detallesClinicos = detallesClinicos;
        this.anotaciones = anotaciones;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getTipoMascota() {
        return tipoMascota;
    }

    public String getSexo() {
        return sexo;
    }

    public int getEdadMeses() {
        return edadMeses;
    }

    public double getPeso() {
        return peso;
    }

    public String getAgresividad() {
        return agresividad;
    }

    public String getDetallesClinicos() {
        return detallesClinicos;
    }

    public String getAnotaciones() {
        return anotaciones;
    }

}
