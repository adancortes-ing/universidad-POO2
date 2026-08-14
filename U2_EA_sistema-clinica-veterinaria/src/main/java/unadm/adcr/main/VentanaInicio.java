package unadm.adcr.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaInicio extends JFrame {

    private final ControlBotones controladorBotones;

    private final String[] botones = {
        "Registro de Mascotas",
        "Agenda de Consultas",
        "Control de Vacunación",
        "Hospitalización de Pacientes",
        "Inventario de Medicamentos",
        "Registro de Adopciones",
        "Salir del Sistema"
    };

    private JPanel centro;

    public VentanaInicio() {
        this.controladorBotones = new ControlBotones(this);

        // Propiedades de la ventana principal =================================
        setTitle("Sistema Integral para la Administración de Veterinarias");
        setSize(480, 750);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ImageIcon icono = new ImageIcon(Main.class.getResource("/icono.png"));
        setIconImage(icono.getImage());

        cargarComponentes();
    }

    private void cargarComponentes() {

        JLabel lblFondo = new JLabel();
        lblFondo.setIcon(new ImageIcon(Main.class.getResource("/inicio_header.png")));
        add(lblFondo, BorderLayout.NORTH);

        centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBorder(BorderFactory.createEmptyBorder(20, 10, 15, 10));
        centro.setBackground(new Color(227, 173, 132));

        JLabel lblTitulo = new JLabel("Módulos del Sistema");
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(Font.BOLD, 20.0f));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        centro.add(lblTitulo);
        centro.add(new JSeparator());

        for (String boton : botones) {
            crearBoton(boton);
        }

        add(centro, BorderLayout.CENTER);
    }

    private void crearBoton(String etiqueta) {

        JButton boton = new JButton(etiqueta);

        boton.setPreferredSize(new Dimension(300, 50));
        boton.setMaximumSize(boton.getPreferredSize());
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setFocusable(false);
        boton.addActionListener(controladorBotones);

        if (!etiqueta.equals("Salir del Sistema")) {
            centro.add(boton);
            centro.add(Box.createVerticalStrut(10));
        } else {
            centro.add(new JSeparator());
            centro.add(Box.createVerticalGlue());
            centro.add(boton);
        }

    }

    private class ControlBotones implements ActionListener {

        private final VentanaInicio ventanaPadre;

        public ControlBotones(VentanaInicio ventana) {
            this.ventanaPadre = ventana;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            JButton botonPulsado = (JButton) e.getSource();

            switch (botonPulsado.getText()) {

                case "Registro de Mascotas" -> {
                    VentanaMascotas mascotas = new VentanaMascotas(ventanaPadre);
                    mascotas.setVisible(true);
                }

                case "Salir del Sistema" ->
                    System.exit(0);

                default ->
                    JOptionPane.showMessageDialog(ventanaPadre, "Este módulo no se ha implementado");
            }

        }

    }

}
