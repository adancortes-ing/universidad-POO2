package unadm.adcr.main;

import java.awt.*;
import javax.swing.*;

public final class FrameBase extends JFrame {

    private final PanelNavegacion pnlMenu;
    private final PanelFormulario pnlFormulario;

    public FrameBase() {
        setTitle("Registro de Socios :: Adán Cortés Rodríguez");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ImageIcon imgHeader = new ImageIcon(getClass().getResource("/header_gym.png"));
        JLabel lblHeader = new JLabel(imgHeader);
        JPanel encabezado = new JPanel();
        encabezado.add(lblHeader);
        add(encabezado, BorderLayout.NORTH);

        pnlMenu = new PanelNavegacion(this);
        pnlFormulario = new PanelFormulario(this);

        cargarPanel(pnlMenu);
    }

    public void cargarPanel(JPanel nuevoPanel) {
        BorderLayout disposicion = (BorderLayout) getContentPane().getLayout();
        Component panelActual = disposicion.getLayoutComponent(BorderLayout.CENTER);

        if (panelActual != null) {
            remove(panelActual);
        }

        add(nuevoPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public PanelNavegacion getPnlMenu() {
        return pnlMenu;
    }

    public PanelFormulario getPnlFormulario() {
        return pnlFormulario;
    }

}
