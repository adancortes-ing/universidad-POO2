package unadm.adcr.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaMascotas extends JDialog {

    private final String[] elementosArchivo = {"Guardar Datos", "Importar Datos", "Exportar Datos",
        "Imprimir", "Configuración", "Salir"};
    private final String[] elementosMascotas = {"Registrar Nueva Mascota",
        "Modificar/Eliminar Mascota", "Consulta de Expedientes", "Exportar Expediente"};
    private final String[] elementosHerramientas = {"Carnet de Vacunación",
        "Calculadora de Alimentos", "Calculadora de Medicamentos"};
    private final String[] elementosAyuda = {"Manual del Usuario", "Atajos de Teclado",
        "Actualizaciones", "Acerca de"};
    
    public Registro registroMascotas;
    
    public VentanaMascotas(VentanaInicio ventanaPadre) {

        super(ventanaPadre, true);

        // Propiedades de la ventana principal =====================================================
        setTitle("Módulo: Registro de Mascotas - Adán Cortes Rodríguez");
        setMinimumSize(getSize());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        registroMascotas = new Registro();
        cargarMenu();
        cargarComponentes();
        
        pack();
        setMinimumSize(getSize());
        setLocationRelativeTo(ventanaPadre);
    }

    private void cargarComponentes() {

        JPanel pnlCentral = new JPanel();
        pnlCentral.setBackground(new Color(227, 173, 132));
        pnlCentral.setLayout(new GridBagLayout());

        JLabel lblImgLogo = new JLabel();
        ImageIcon fondo = new ImageIcon(Main.class.getResource("/bg_mascotas.png"));
        Image fondoOriginal = fondo.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        ImageIcon fondoEscalado = new ImageIcon(fondoOriginal);
        lblImgLogo.setIcon(fondoEscalado);

        pnlCentral.add(lblImgLogo);

        // Barra de estado inferior ================================================================
        JPanel pnlInferior = new JPanel();
        pnlInferior.setLayout(new BoxLayout(pnlInferior, BoxLayout.X_AXIS));
        pnlInferior.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        pnlInferior.setBackground(Color.DARK_GRAY);

        JLabel lblInfoSoftware = new JLabel(
                "Sistema Integral para la Administración de Veterinarias | versión 1.0.0");
        lblInfoSoftware.setForeground(Color.WHITE);
        JLabel lblDesarrollador = new JLabel(
                "Desarrollado por: Adán Cortés Rodríguez");
        lblDesarrollador.setForeground(Color.WHITE);

        pnlInferior.add(lblInfoSoftware);
        pnlInferior.add(Box.createHorizontalGlue());
        pnlInferior.add(lblDesarrollador);

        add(pnlCentral, BorderLayout.CENTER);
        add(pnlInferior, BorderLayout.SOUTH);
    }

    private void cargarMenu() {

        JMenuBar barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);
        ControlMenu.setVentana(this);

        JMenu archivo = new JMenu("Archivo");
        JMenu mascotas = new JMenu("Mascotas");
        JMenu herramientas = new JMenu("Herramientas");
        JMenu ayuda = new JMenu("Ayuda");

        for (String opcion : elementosArchivo) {
            crearElementoMenu(opcion, archivo);
        }

        for (String opcion : elementosMascotas) {
            crearElementoMenu(opcion, mascotas);
        }

        for (String opcion : elementosHerramientas) {
            crearElementoMenu(opcion, herramientas);
        }

        for (String opcion : elementosAyuda) {
            crearElementoMenu(opcion, ayuda);
        }

        barraMenu.add(archivo);
        barraMenu.add(mascotas);
        barraMenu.add(herramientas);
        barraMenu.add(ayuda);
    }

    private void crearElementoMenu(String etiqueta, JMenu menu) {

        JMenuItem opcion = new JMenuItem(etiqueta);
        opcion.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 30));
        opcion.addActionListener(ControlMenu.INSTANCIA);

        if (etiqueta.equals("Salir") || etiqueta.equals("Imprimir")) {
            menu.addSeparator();
        }

        menu.add(opcion);
    }

    private static class ControlMenu implements ActionListener {

        private static final ControlMenu INSTANCIA = new ControlMenu();
        private static VentanaMascotas ventana;

        public static void setVentana(VentanaMascotas ventana) {
            ControlMenu.ventana = ventana;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem opcion = (JMenuItem) e.getSource();

            switch (opcion.getText()) {
                case "Registrar Nueva Mascota":
                    new VentanaRegistro(ventana).setVisible(true);
                    break;
                case "Consulta de Expedientes":
                    break;
                case "Salir":
                    ventana.dispose();
                    break;
                default:
                    JOptionPane.showMessageDialog(ventana,
                            "Botón simulado sin ninguna funcionalidad");
            }

        }

    }

}
