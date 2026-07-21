package unadm.adcr.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class PanelNavegacion extends JPanel {

    private FrameBase ventanaPrincipal;

    public PanelNavegacion(FrameBase marcoPadre) {

        ventanaPrincipal = marcoPadre;

        BoxLayout disposicion = new BoxLayout(this, BoxLayout.Y_AXIS);
        setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));
        setLayout(disposicion);

        JLabel lblTitulo = new JLabel("MENÚ DE NAVEGACIÓN");
        lblTitulo.setAlignmentX(CENTER_ALIGNMENT);
        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 18));
        add(lblTitulo);
        add(Box.createVerticalStrut(30));

        Dimension tamanioBotones = new Dimension(200, 30);

        JButton btnRegSocios = new JButton("Registro de Socios");
        btnRegSocios.setMaximumSize(tamanioBotones);
        btnRegSocios.setAlignmentX(CENTER_ALIGNMENT);
        btnRegSocios.addActionListener(this::btnSociosActionPerformed);
        add(btnRegSocios);
        add(Box.createVerticalStrut(10));

        JButton btnInscripciones = new JButton("Inscripcion a Clases");
        btnInscripciones.setMaximumSize(tamanioBotones);
        btnInscripciones.setAlignmentX(CENTER_ALIGNMENT);
        btnInscripciones.setEnabled(false);
        add(btnInscripciones);
        add(Box.createVerticalStrut(10));

        JButton btnReserva = new JButton("Reserva de Entrenadores");
        btnReserva.setMaximumSize(tamanioBotones);
        btnReserva.setAlignmentX(CENTER_ALIGNMENT);
        btnReserva.setEnabled(false);;
        add(btnReserva);
        add(Box.createVerticalStrut(10));

        JButton btnRutinas = new JButton("Registro de Rutinas");
        btnRutinas.setMaximumSize(tamanioBotones);
        btnRutinas.setAlignmentX(CENTER_ALIGNMENT);
        btnRutinas.setEnabled(false);;
        add(btnRutinas);
        add(Box.createVerticalStrut(10));

        JButton btnAsistencias = new JButton("Registro de Asistencias");
        btnAsistencias.setMaximumSize(tamanioBotones);
        btnAsistencias.setAlignmentX(CENTER_ALIGNMENT);
        btnAsistencias.setEnabled(false);
        add(btnAsistencias);
        add(Box.createVerticalStrut(10));

        JButton btnEvaluacion = new JButton("Evaluación Física");
        btnEvaluacion.setMaximumSize(tamanioBotones);
        btnEvaluacion.setAlignmentX(CENTER_ALIGNMENT);
        btnEvaluacion.setEnabled(false);
        add(btnEvaluacion);
        add(Box.createVerticalGlue());

        JButton btnSalir = new JButton("Salir");
        btnSalir.setMaximumSize(tamanioBotones);
        btnSalir.setAlignmentX(CENTER_ALIGNMENT);
        btnSalir.setBackground(new Color(200, 60, 40));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.addActionListener(this::btnSalirActionPerformed);
        add(btnSalir);

    }

    private void btnSalirActionPerformed(ActionEvent e) {

        System.exit(0);
    }

    private void btnSociosActionPerformed(ActionEvent e) {

        ventanaPrincipal.cargarPanel(ventanaPrincipal.getPnlFormulario());
    }

}
