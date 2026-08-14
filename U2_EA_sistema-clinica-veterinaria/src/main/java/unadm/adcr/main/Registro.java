package unadm.adcr.main;

import java.util.List;
import java.util.ArrayList;

public class Registro {

    private static Registro instanciaReg;
    private final List<Mascota> registroMascotas;

    private Registro() {

        registroMascotas = new ArrayList<>();
        generarMascotas();
    }

    private void generarMascotas() {

        agregarMascota(new Mascota(registroMascotas.size() + 1,
                "Kira", "Veronica Rubio", "Perro", "Hembra",
                40, 2.60, "2 — Docil", "Esterilizado/a", "Raza: chihuahua de color negro, "
                + "tiene mancha cafe en el lomo"));

        agregarMascota(new Mascota(registroMascotas.size() + 1,
                "Luna", "Araceli Eguren", "Perro", "Hembra",
                26, 1.80, "5 — Muy agresivo", "Esterilizado/a", "Raza: chihuahua de color blanco, "
                + "suelta mucho pelo."));

        agregarMascota(new Mascota(registroMascotas.size() + 1,
                "Esponjoso", "Sofia Cortes", "Conejo", "Macho",
                9, 0.6, "2 — Docil", "Sin anotaciones", "Color blanco"));

        agregarMascota(new Mascota(registroMascotas.size() + 1,
                "Pelito", "Alejandra", "Perro", "Macho",
                28, 26.0, "3 — Amistoso", "Microchip instalado", "Raza: Bulldog Terrier, "
                + "de color blanco con negro con lunar negro en el ojo derecho"));
    }

    public List<Mascota> getRegistroMascotas() {

        return registroMascotas;
    }

    public void agregarMascota(Mascota m) {
        registroMascotas.add(m);
    }

    public int comprobarIdDisponible() {
        int idSiguiente;

        idSiguiente = Registro.instanciaReg.getRegistroMascotas().getLast().getIdMascota();

        return idSiguiente + 1;
    }

    public static Registro getInstanciaRegistro() {

        if (instanciaReg == null) {
            instanciaReg = new Registro();
        }

        return instanciaReg;
    }

}
