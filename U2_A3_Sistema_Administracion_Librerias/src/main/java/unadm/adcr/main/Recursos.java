package unadm.adcr.main;

import javax.swing.ImageIcon;

public class Recursos {

    public static ImageIcon cargarImagen(String nombre) {

        ImageIcon imagen;

        imagen = new ImageIcon(Recursos.class.getResource("/" + nombre));

        return imagen;

    }

}
