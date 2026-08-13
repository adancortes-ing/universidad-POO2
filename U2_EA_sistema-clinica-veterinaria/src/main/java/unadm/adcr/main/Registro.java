package unadm.adcr.main;

import java.util.List;
import java.util.ArrayList;

public class Registro {

    private final List<Mascota> registroMascotas = new ArrayList<>();

    public Registro() {
        
        generarMascotas();
    }

    private void generarMascotas() {

        agregarMascota(new Mascota(getRegistroMascotas().size() + 1,
                "Kira", "Veronica Rubio", "Perro", "Hembra",
                40, 2.60, "2 — Docil", "Esterilizado/a", "Raza: chihuahua de color negro, "
                + "tiene mancha cafe en el lomo"));

        agregarMascota(new Mascota(getRegistroMascotas().size() + 1,
                "Luna", "Araceli Eguren", "Perro", "Hembra",
                26, 1.80, "5 — Muy agresivo", "Esterilizado/a", "Raza: chihuahua de color blanco, "
                + "suelta mucho pelo."));

        agregarMascota(new Mascota(getRegistroMascotas().size() + 1,
                "Esponjoso", "Sofia Cortes", "Conejo", "Macho",
                9, 0.6, "2 — Docil", "Sin anotaciones", "Color blanco"));

        agregarMascota(new Mascota(getRegistroMascotas().size() + 1,
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

}
