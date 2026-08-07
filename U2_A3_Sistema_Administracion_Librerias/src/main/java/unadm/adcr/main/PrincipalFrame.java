package unadm.adcr.main;

import javax.swing.*;
import java.awt.*;

public class PrincipalFrame extends JFrame {

    //Declaración de variables
    private JMenuBar barraMenu;

    public PrincipalFrame() {

        setTitle("Sistema de Administración de Librerías - Adán Cortés Rodríguez");
        setSize(1024, 768);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Image favicon = Recursos.cargarImagen("favicon.png").getImage();
        setIconImage(favicon);

        cargarBarraDeMenu();
        cargarComponentes();

    }

    private void cargarComponentes() {

        class HeaderPanel extends JPanel {

            private final Image fondo;

            public HeaderPanel() {

                fondo = Recursos.cargarImagen("header_bg.png").getImage();
                setBackground(new Color(45, 142, 184));
                setPreferredSize(new Dimension(0, 100));
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(fondo, 0, 0, 1500, getHeight(), this);
            }
        }

        HeaderPanel cabecera = new HeaderPanel();
        PanelMenu menu = new PanelMenu(this);

        add(cabecera, BorderLayout.NORTH);
        add(menu, BorderLayout.WEST);

    }

    private void cargarBarraDeMenu() {

        //Estructura de la barra de menu
        barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);

        JMenu archivo = new JMenu("Archivo");
        JMenu ver = new JMenu("Ver");
        JMenu libros = new JMenu("Libros");
        JMenu herramientas = new JMenu("Herramientas");
        JMenu ayuda = new JMenu("Ayuda");

        JMenu[] elementosMenu = {archivo, ver, libros, herramientas, ayuda};

        JMenuItem nuevoLibro = crearItemMenu("Nuevo Libro…", "new_book.png");
        JMenuItem nuevaCategoria = crearItemMenu("Nueva categoria…", "categoria.png");
        JMenuItem guardar = crearItemMenu("Guardar Datos", "save.png");
        JMenuItem configuracion = crearItemMenu("Configuración", "config.png");
        JMenuItem salir = crearItemMenu("Salir", "");
        JMenuItem busqueda = crearItemMenu("Buscar Libros", "buscar.png");
        JMenuItem editar = crearItemMenu("Editar Libro", "editar.png");
        JMenuItem eliminar = crearItemMenu("Eliminar Libro", "eliminar.png");
        JMenuItem manual = crearItemMenu("Manual de Uso", "user_manual.png");
        JMenuItem reporte = crearItemMenu("Reportar Problema", "");
        JMenuItem actualizar = crearItemMenu("Buscar Actualizaciones", "");
        JMenuItem acerca = crearItemMenu("Acerca de…", "");

        archivo.add(nuevoLibro);
        archivo.add(nuevaCategoria);
        archivo.add(guardar);
        archivo.addSeparator();
        archivo.add(configuracion);
        archivo.addSeparator();
        archivo.add(salir);
        libros.add(busqueda);
        libros.add(editar);
        libros.add(eliminar);
        ayuda.add(manual);
        ayuda.addSeparator();
        ayuda.add(reporte);
        ayuda.add(actualizar);
        ayuda.add(acerca);

        for (JMenu e : elementosMenu) {
            barraMenu.add(e);
        }

        salir.addActionListener(ActionEvent -> {
            System.exit(0);
        });
    }

    private JMenuItem crearItemMenu(String texto, String icono) {

        JMenuItem item = new JMenuItem();
        item.setText(texto);
        item.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 30));
        item.setIcon(Recursos.cargarImagen(icono));
        item.setIconTextGap(10);

        return item;
    }

}
