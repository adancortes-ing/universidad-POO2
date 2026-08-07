package unadm.adcr.main;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanelMenu extends JPanel {

    private JButton btnLibros, btnClientes, btnEmpleados, btnProveedores, btnVentas, btnSucursales, btnSalir;
    private PrincipalFrame ventanaPadre;

    public PanelMenu(PrincipalFrame vp) {

        this.ventanaPadre = vp;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(25, 20, 10, 20));
        setBackground(new Color(115, 179, 207));
        setPreferredSize(new Dimension(320, 0));

        btnLibros = crearBoton("Administración de Libros", "books.png");
        btnClientes = crearBoton("Administración de Clientes", "clientes.png");
        btnEmpleados = crearBoton("Administración de Empleados", "empleados.png");
        btnProveedores = crearBoton("Administración de Proveedores", "proveedores.png");
        btnVentas = crearBoton("Administración de Ventas", "ventas.png");
        btnSucursales = crearBoton("Administración de Sucursales", "library.png");
        btnSalir = crearBoton("Salir del Sistema", "");

        JButton[] botones = {btnLibros, btnClientes, btnEmpleados, btnProveedores, btnVentas, btnSucursales};

        for (JButton boton : botones) {
            boton.addActionListener(listener);
            this.add(boton);
            this.add(Box.createVerticalStrut(20));
        }

        add(Box.createVerticalGlue());
        add(btnSalir);
        btnSalir.addActionListener(listener);
    }

    ActionListener listener = e -> {

        JButton botonPulsado = (JButton) e.getSource();

        if (botonPulsado == btnSalir) {
            System.exit(0);
        }

        if (botonPulsado == btnLibros) {
            JOptionPane.showMessageDialog(ventanaPadre, "Este es el módulo de Libros");
        } else {
            JOptionPane.showMessageDialog(ventanaPadre, "Este módulo no se ha implementado todavía!", "Mensaje de aviso", JOptionPane.WARNING_MESSAGE);
        }
    };

    private JButton crearBoton(String nombre, String icono) {

        Dimension sizeBotones = new Dimension(280, 40);
        JButton boton = new JButton();

        boton.setText(nombre);
        boton.setMinimumSize(sizeBotones);
        boton.setMaximumSize(sizeBotones);
        boton.setPreferredSize(sizeBotones);
        boton.setIcon(Recursos.cargarImagen(icono));
        boton.setIconTextGap(20);
        boton.setHorizontalAlignment(SwingConstants.LEFT);
        boton.setFocusable(false);

        return boton;
    }

}
