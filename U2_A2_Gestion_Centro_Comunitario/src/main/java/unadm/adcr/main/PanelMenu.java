package unadm.adcr.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanelMenu extends JPanel implements ActionListener {

    private final JButton btnRegCurso, btnInscripcion, btnReservaSalas, btnRegInstructores, btnCtrlPrestamos, btnRegEventos, btnSalir;
    private final Dimension tamanioBotones = new Dimension(280, 50);

    public PanelMenu() {

        BoxLayout estructuraMenu = new BoxLayout(this, BoxLayout.Y_AXIS);
        setPreferredSize(new Dimension(300, 500));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setLayout(estructuraMenu);

        setBackground(new Color(105, 186, 227));

        JLabel lblMenu = new JLabel("Menú");
        lblMenu.setAlignmentX(CENTER_ALIGNMENT);
        lblMenu.setFont(new Font("Verdana", Font.BOLD, 24));
        add(lblMenu);

        btnRegCurso = crearBoton("Registrar Curso");
        btnRegCurso.setEnabled(true);
        btnInscripcion = crearBoton("Inscripción a Talleres");
        btnReservaSalas = crearBoton("Reserva de Salas");
        btnRegInstructores = crearBoton("Registro de Instructores");
        btnCtrlPrestamos = crearBoton("Control de Préstamos de Equipo");
        btnRegEventos = crearBoton("Registro de Eventos Comunitarios");

        add(Box.createVerticalGlue());
        btnSalir = crearBoton("Salir");
        btnSalir.setEnabled(true);
        btnSalir.setFont(btnSalir.getFont().deriveFont(Font.BOLD, 24.0f));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBackground(new Color(214, 32, 56));
        btnSalir.addActionListener(this);

    }

    private JButton crearBoton(String etiqueta) {

        JButton boton = new JButton(etiqueta);
        boton.setAlignmentX(CENTER_ALIGNMENT);
        boton.setMinimumSize(tamanioBotones);
        boton.setMaximumSize(tamanioBotones);
        boton.setPreferredSize(tamanioBotones);
        boton.setFocusable(false);
        boton.setEnabled(false);
        boton.addActionListener(this);
        add(Box.createVerticalStrut(15));

        add(boton);
        return boton;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton botonPulsado = (JButton) e.getSource();

        switch (botonPulsado.getText()) {
            case "Registrar Curso" ->
                Ventana.cambiarVista("Formulario");
            case "Inscripción a Talleres" ->
                Ventana.cambiarVista("");
            case "Reserva de Salas" ->
                Ventana.cambiarVista("");
            case "Salir" ->
                System.exit(0);
            default ->
                System.exit(0);
        }

    }

}
