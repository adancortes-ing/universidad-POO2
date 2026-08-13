package unadm.adcr.main;

import java.awt.BorderLayout;
import javax.swing.*;

public class VentanaMascotas extends JDialog {
    
    private final String[] elementosArchivo= {"Guardar Datos", "Importar Datos", "Exportar Datos", "Imprimir", "Configuración", "Salir"};

    public VentanaMascotas(VentanaInicio ventanaPadre) {

        super(ventanaPadre, true);

        // Propiedades de la ventana principal =================================
        setTitle("Módulo: Registro de Mascotas - Adán Cortes Rodríguez");
        setSize(1024, 768);
        setMinimumSize(getSize());
        setLocationRelativeTo(ventanaPadre);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        cargarMenu();
    }

    private void cargarMenu() {

        JMenuBar barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);

        JMenu archivo = new JMenu("Archivo");
        JMenu ayuda = new JMenu("Ayuda");
        
        for (String opcion : elementosArchivo){
            
            crearElementoMenu(opcion, archivo);
        }

        barraMenu.add(archivo);
        barraMenu.add(ayuda);
    }

    private final void crearElementoMenu(String etiqueta, JMenu menu) {

        JMenuItem opcion = new JMenuItem(etiqueta);
        opcion.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 30));
        menu.add(opcion);
    }

}
