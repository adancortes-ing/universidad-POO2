package unadm.adcr;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class VentanaBase extends JFrame {

    private final JPanel pnlContenido, pnlCabecera;
    private final PanelMenu pnlMenu;

    public VentanaBase() {
        setTitle("Solicitud de Becas - Adán Cortés Rodríguez");
        setBounds(500, 300, 700, 700);
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnlCabecera = new PanelCabecera();
        pnlCabecera.setPreferredSize(new Dimension(700, 170));
        add(pnlCabecera, BorderLayout.NORTH);

        pnlContenido = new JPanel();
        pnlMenu = new PanelMenu(this);
        pnlContenido.add(pnlMenu);
        add(pnlContenido, BorderLayout.CENTER);

    }

    public void cambiarPanel(JPanel nuevoPanel) {
        pnlContenido.removeAll();
        pnlContenido.add(nuevoPanel);
        pnlContenido.revalidate();
        pnlContenido.repaint();
    }
}

class PanelCabecera extends JPanel {

    private Image cabecera;

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        File url = new File("src/main/resources/header_becas.png");

        try {
            cabecera = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println("No se pudo localizar la imagen");
        }

        g.drawImage(cabecera, 0, 0, this);

    }
}