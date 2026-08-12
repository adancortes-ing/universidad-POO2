package unadm.adcr.main;

import javax.swing.*;
import java.awt.*;

public class PrincipalFrame extends JFrame {

    public final Biblioteca biblioteca = new Biblioteca();

    //Declaración de variables
    public static Image favicon;
    private JMenuBar barraMenu;
    private static CardLayout navegacion;
    private static JPanel pnlCentral;

    public PrincipalFrame() {

        setTitle("Sistema de Administración de Librerías - Adán Cortés Rodríguez");
        setSize(1024, 768);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        favicon = Recursos.cargarImagen("favicon.png").getImage();
        setIconImage(favicon);

        cargarBarraDeMenu();
        cargarComponentes();
        generarLibrosPrueba();

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
        navegacion = new CardLayout();
        pnlCentral = new JPanel(navegacion);

        PanelProvisional pnlInicio = new PanelProvisional("Bienvenido al Sistema");
        PanelProvisional pnlLibros = new PanelProvisional("Módulo de Administración de Libros");
        JScrollPane scrollCentral = new JScrollPane(pnlCentral);

        pnlCentral.add(pnlInicio, "Inicio");
        pnlCentral.add(pnlLibros, "Libros");

        add(cabecera, BorderLayout.NORTH);
        add(menu, BorderLayout.WEST);
        add(scrollCentral, BorderLayout.CENTER);

        cambiarVista("Inicio");

    }

    public static void cambiarVista(String destino) {

        navegacion.show(pnlCentral, destino);
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

        ver.setEnabled(false);
        herramientas.setEnabled(false);

        JMenu[] elementosMenu = {archivo, ver, libros, herramientas, ayuda};

        JMenuItem nuevoLibro = crearItemMenu("Nuevo Libro…", "new_book.png");
        JMenuItem nuevaCategoria = crearItemMenu("Nueva categoria…", "categoria.png");
        JMenuItem guardar = crearItemMenu("Guardar Datos", "save.png");
        JMenuItem configuracion = crearItemMenu("Configuración", "config.png");
        JMenuItem salir = crearItemMenu("Salir", "");
        JMenuItem busqueda = crearItemMenu("Catalogo de Libros", "buscar.png");
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

        nuevoLibro.addActionListener(ActionEvent -> {
            VentanaRegistrar registrar = new VentanaRegistrar(this, biblioteca);
            registrar.setVisible(true);
        });

        busqueda.addActionListener(ActionEvent -> {
            VentanaCatalogo catalogo = new VentanaCatalogo(this, biblioteca);
            catalogo.setVisible(true);
        });

        salir.addActionListener(ActionEvent -> {
            System.exit(0);
        });
    }

    class PanelProvisional extends JPanel {

        public PanelProvisional(String texto) {

            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JLabel titulo = new JLabel(texto);
            titulo.setFont(new Font("Verdana", Font.BOLD, 20));
            titulo.setForeground(new Color(0, 48, 100));
            titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel mensaje = new JLabel("Vista provisional para prueba de CardLayout");
            mensaje.setAlignmentX(Component.CENTER_ALIGNMENT);

            add(Box.createVerticalStrut(100));
            add(titulo);
            add(mensaje);

        }

    }

    private JMenuItem crearItemMenu(String texto, String icono) {

        JMenuItem item = new JMenuItem();
        item.setText(texto);
        item.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 30));
        item.setIcon(Recursos.cargarImagen(icono));
        item.setIconTextGap(10);

        return item;
    }

    private void generarLibrosPrueba() {
        Libro libro1 = new Libro(
                "Cien años de soledad",
                "Gabriel García Márquez",
                "9780307474728",
                "Editorial Sudamericana",
                1967,
                350.00,
                12
        );

        Libro libro2 = new Libro(
                "El principito",
                "Antoine de Saint-Exupéry",
                "9780156012195",
                "Salamandra",
                1943,
                280.00,
                8
        );

        Libro libro3 = new Libro(
                "Don Quijote de la Mancha",
                "Miguel de Cervantes",
                "9788420412146",
                "Alfaguara",
                1605,
                420.00,
                6
        );

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
    }

}
