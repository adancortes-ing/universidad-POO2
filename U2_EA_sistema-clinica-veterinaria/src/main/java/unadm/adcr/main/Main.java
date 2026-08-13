package unadm.adcr.main;

import javax.swing.SwingUtilities;

/**
 *
 * @author Adan Cortes Rodriguez
 * @matricula ES251118724
 *
 */
public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            VentanaInicio inicio = new VentanaInicio();
            VentanaInicio.ControlBotones.setVentanaPrincipal(inicio);
            inicio.setVisible(true);
        });
    }
}
