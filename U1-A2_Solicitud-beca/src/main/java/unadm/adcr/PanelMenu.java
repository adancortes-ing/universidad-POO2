package unadm.adcr;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class PanelMenu extends JPanel {

    private final JButton btnSolicitud;
    private final JButton btnRegTutorias;
    private final JButton btnPrestamos;
    private final JButton btnRegPracticas;
    private final JButton btnSolicitudConst;
    private final JButton btnSalir;
    private final JLabel lblTitulo;
    
    private final VentanaBase ventanaPadre;

    public PanelMenu(VentanaBase vp) {
        this.ventanaPadre = vp;

        setLayout(new GridLayout(7, 1, 30, 15));

        lblTitulo = new JLabel("MENÚ PRINCIPAL", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 22));
        add(lblTitulo);

        btnSolicitud = new JButton("Solicitud de Beca");
        btnSolicitud.addActionListener(this::btnSolicitarActionPerformed);
        add(btnSolicitud);

        btnRegTutorias = new JButton("Registro de Tutorías");
        btnRegTutorias.setEnabled(false);
        add(btnRegTutorias);

        btnPrestamos = new JButton("Prestamo de Libros");
        btnPrestamos.setEnabled(false);
        add(btnPrestamos);

        btnRegPracticas = new JButton("Registro de Prácticas Profesionales");
        btnRegPracticas.setEnabled(false);
        add(btnRegPracticas);

        btnSolicitudConst = new JButton("Solicitud de Constancias");
        btnSolicitudConst.setEnabled(false);
        add(btnSolicitudConst);

        btnSalir = new JButton("Salir");
        btnSalir.setBackground(Color.RED);
        btnSalir.addActionListener(this::btnSalirActionPerformed);
        add(btnSalir);

    }
    
    private void btnSolicitarActionPerformed(ActionEvent e){
        
        ventanaPadre.cambiarPanel(new PanelFormulario(ventanaPadre));
    }
    
    private void btnSalirActionPerformed(ActionEvent e) {
        System.exit(0);
    }

}
