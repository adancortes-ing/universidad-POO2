package unadm.adcr.main;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaExpedientes extends JDialog {

    private JTable tblMascotas;

    public VentanaExpedientes(VentanaMascotas owner) {
        super(owner, true);

        // Propiedades de la ventana ===============================================================
        setTitle("Mascotas — Listado de Mascotas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        cargarComponentes();

        pack();
        setMinimumSize(getSize());
        setLocationRelativeTo(owner);
    }

    private void cargarComponentes() {

        // Panel superior para el titulo ===========================================================
        JPanel pnlSuperior = new JPanel();
        pnlSuperior.setLayout(new BoxLayout(pnlSuperior, BoxLayout.Y_AXIS));
        pnlSuperior.setBorder(BorderFactory.createEmptyBorder(5, 30, 0, 30));

        JLabel lblTitulo = new JLabel("Relación de Mascotas Registradas");
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(Font.BOLD, 20.0f));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlSuperior.add(lblTitulo);

        // Panel central con la relacion de mascotas ===============================================
        String[] columnas = {"ID", "Nombre de Mascota", "Dueño", "Tipo / Especie", "Temperamento"};

        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        tblMascotas = new JTable(modeloTabla);

        for (Mascota m : Registro.INSTANCIA.getRegistroMascotas()) {
            modeloTabla.addRow(new Object[]{
                m.getIdMascota(),
                m.getNombreMascota(),
                m.getNombreCliente(),
                m.getTipoMascota(),
                m.getAgresividad()
            });
        }

        JPanel pnlCentral = new JPanel();
        pnlCentral.setLayout(new FlowLayout());

        JScrollPane areaTabla = new JScrollPane(tblMascotas);
        areaTabla.setPreferredSize(new Dimension(900, 400));
        tblMascotas.setComponentPopupMenu(menuContextual());
        pnlCentral.add(areaTabla);

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

        add(pnlSuperior, BorderLayout.PAGE_START);
        add(pnlCentral, BorderLayout.CENTER);
        add(pnlInferior, BorderLayout.PAGE_END);
    }

    private JPopupMenu menuContextual() {

        JPopupMenu menu = new JPopupMenu();

        JMenuItem verDetalles = new JMenuItem("Ver más detalles");
        JMenuItem editarMascota = new JMenuItem("Editar Datos");
        JMenuItem eliminarMascota = new JMenuItem("Eliminar Mascota");
        JMenuItem exportarDatos = new JMenuItem("Exportar datos");

        menu.add(verDetalles);
        menu.add(editarMascota);
        menu.add(exportarDatos);
        menu.addSeparator();
        menu.add(eliminarMascota);

        verDetalles.addActionListener(this::verDetallesAction);
        eliminarMascota.addActionListener(this::eliminarMascotaAction);

        return menu;
    }

    public void verDetallesAction(ActionEvent e) {

        int fila = tblMascotas.getSelectedRow();

        if (fila >= 0) {

            Mascota mascota = Registro.INSTANCIA.getRegistroMascotas().get(fila);

            JOptionPane.showMessageDialog(this,
                    "Nombre de la mascota: " + mascota.getNombreMascota()
                    + "\nNombre del dueño: " + mascota.getNombreCliente()
                    + "\nTipo de mascota: " + mascota.getTipoMascota()
                    + "\nSexo: " + mascota.getSexo()
                    + "  –  Peso: " + mascota.getPeso() + "Kg."
                    + "  –  Edad: " + mascota.getEdadMeses() + " meses"
                    + "\nTemperamento: " + mascota.getAgresividad()
                    + "\nDetalles clínicos: " + mascota.getDetallesClinicos()
                    + "\nNotas adicionales: " + mascota.getAnotaciones(),
                    "Información del registro " + mascota.getIdMascota(),
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void eliminarMascotaAction(ActionEvent e) {

        int fila = tblMascotas.getSelectedRow();

        if (fila >= 0) {
            
            Registro.INSTANCIA.getRegistroMascotas().remove(fila);
            actualizarTabla();
        }
    }

    public void actualizarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tblMascotas.getModel();

        modelo.setRowCount(0);

        for (Mascota m : Registro.INSTANCIA.getRegistroMascotas()) {
            modelo.addRow(new Object[]{
                m.getIdMascota(),
                m.getNombreMascota(),
                m.getNombreCliente(),
                m.getTipoMascota(),
                m.getAgresividad()
            });
        }
    }

}
