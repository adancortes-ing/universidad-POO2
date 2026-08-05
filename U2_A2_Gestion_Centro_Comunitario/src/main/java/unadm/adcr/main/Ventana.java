package unadm.adcr.main;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Ventana extends JFrame {

    private static CardLayout navegacion;
    private static JPanel contenedor1;

    public Ventana(int ancho, int alto) {

        Dimension tamanioVentana = new Dimension(ancho, alto);
        setTitle("Sistema de Gestión del Centro Comunitario - Adán Cortes Rodríguez");
        setSize(tamanioVentana);
        setMinimumSize(tamanioVentana);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ImageIcon favicon = new ImageIcon(getClass().getResource("/Kite.png"));
        setIconImage(favicon.getImage());

        //Administrador de diseño CardLayout y sus diferentes vistas
        navegacion = new CardLayout();
        contenedor1 = new JPanel(navegacion);
        JPanel pnlMain = new JPanel(new GridBagLayout());
        PanelFormulario pnlFormulario = new PanelFormulario();

        //Contenido del panel principal y resto de paneles
        ImageIcon logo = new ImageIcon(getClass().getResource("/logo_necc.png"));
        JLabel lblLogotipo = new JLabel(logo);
        pnlMain.add(lblLogotipo);

        contenedor1.add(pnlMain, "Inicio");
        contenedor1.add(pnlFormulario, "Formulario");

        add(contenedor1, BorderLayout.CENTER);
        cargarPaneles();

    }

    public static void cambiarVista(String vista) {
        navegacion.show(contenedor1, vista);
    }

    public final void cargarPaneles() {

        //Panel superior con el encabezado
        PanelHeader encabezado = new PanelHeader();
        add(encabezado, BorderLayout.NORTH);

        //Panel inferior con la barra de estado
        JPanel barraEstado = new JPanel();
        barraEstado.setBackground(Color.DARK_GRAY);
        barraEstado.setLayout(new BoxLayout(barraEstado, BoxLayout.X_AXIS));
        barraEstado.setBorder(BorderFactory.createEmptyBorder(3, 15, 3, 15));
        JLabel lblInfo = new JLabel("Sistema de Gestion SGCC v0.1-BETA");
        JLabel lblAutor = new JLabel("Developed by: Adán Cortes Rodríguez");
        lblInfo.setForeground(Color.LIGHT_GRAY);
        lblAutor.setForeground(Color.LIGHT_GRAY);
        barraEstado.add(lblInfo);
        barraEstado.add(Box.createHorizontalGlue());
        barraEstado.add(lblAutor);
        add(barraEstado, BorderLayout.SOUTH);

        PanelMenu menuNavegacion = new PanelMenu();
        add(menuNavegacion, BorderLayout.WEST);

    }

}

class PanelHeader extends JPanel {

    private final Image fondoHeader;

    public PanelHeader() {
        URL headerURL = getClass().getResource("/bg_header_extended.jpg");
        ImageIcon headerImagen = new ImageIcon(headerURL);
        fondoHeader = headerImagen.getImage();

        setBackground(new Color(251, 204, 13));
        setPreferredSize(new Dimension(800, 120));
        setLayout(new FlowLayout(FlowLayout.LEFT, 50, 50));

        JLabel lblTitulo = new JLabel("Sistema de Gestión de Centros Comunitarios");
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(Font.BOLD, 26.0f));
        //add(lblTitulo);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (fondoHeader != null) {
            g.drawImage(fondoHeader, 0, 0, 1500, getHeight(), this);
        }
    }
}
