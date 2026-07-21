package unadm.adcr.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class PanelFormulario extends JPanel {

    private final FrameBase ventanaPrincipal;
    private final JTextField txtNombre;
    private final JTextField txtApellidos;
    private final JComboBox cbxGeneros;
    private final JTextArea txtDescripcion;
    private final JButton btnRegistrar, btnVolver, btnLimpiar;

    public PanelFormulario(FrameBase marcoBase) {

        ventanaPrincipal = marcoBase;

        setLayout(null);

        JLabel lblTitulo = new JLabel("Formulario de Registro Para Socios");
        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 18));
        lblTitulo.setBounds(235, 10, 400, 25);
        add(lblTitulo);

        JLabel lblNombre = new JLabel("Nombre(s):");
        lblNombre.setBounds(250, 50, 100, 15);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(240, 70, 270, 20);
        add(txtNombre);

        JLabel lblApellidos = new JLabel("Apellido(s):");
        lblApellidos.setBounds(250, 100, 100, 15);
        add(lblApellidos);

        txtApellidos = new JTextField();
        txtApellidos.setBounds(240, 120, 270, 20);
        add(txtApellidos);

        JLabel lblGenero = new JLabel("Género:");
        lblGenero.setBounds(250, 150, 100, 15);
        add(lblGenero);

        cbxGeneros = new JComboBox();
        cbxGeneros.addItem("-");
        cbxGeneros.addItem("Hombre");
        cbxGeneros.addItem("Mujer");
        cbxGeneros.addItem("No se especifíca");
        cbxGeneros.setBounds(240, 170, 100, 20);
        add(cbxGeneros);

        JLabel lblDescripcion = new JLabel("<html>Acerca de mi:<br><i>Cuentanos tus gustos, ábitos, pasatiempos</i></html>");
        lblDescripcion.setBounds(250, 200, 300, 40);
        add(lblDescripcion);

        txtDescripcion = new JTextArea();
        txtDescripcion.setBounds(240, 240, 270, 100);
        txtDescripcion.setLineWrap(true);
        add(txtDescripcion);

        JLabel lblMinimo = new JLabel("(mínimo 100 caracteres)");
        lblMinimo.setBounds(240, 340, 200, 15);
        add(lblMinimo);

        EventosRaton llamarEventos = new EventosRaton();

        btnVolver = new JButton("Regresar");
        btnVolver.setBounds(15, 30, 100, 25);
        btnVolver.addMouseListener(llamarEventos);
        add(btnVolver);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(260, 370, 90, 25);
        btnLimpiar.addMouseListener(llamarEventos);
        add(btnLimpiar);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(390, 370, 90, 25);
        btnRegistrar.addMouseListener(llamarEventos);
        add(btnRegistrar);

    }

    class EventosRaton extends MouseAdapter {

        private Color btnJavaOriginal;

        @Override
        public void mouseClicked(MouseEvent e) {
            JButton botonFuente = (JButton) e.getSource();

            if (botonFuente == btnVolver) {
                ventanaPrincipal.cargarPanel(ventanaPrincipal.getPnlMenu());
            }

            if (botonFuente == btnLimpiar) {
                if (JOptionPane.showConfirmDialog(ventanaPrincipal, "¿Seguro que quieres borrar todos los campos?", "Confirmacion", 0) == 0) {
                    limpiarCampos();
                }
            }

            if (botonFuente == btnRegistrar) {

                if (comprobarDatos()) {
                    JOptionPane.showMessageDialog(ventanaPrincipal, "Registro completado con exito");
                    limpiarCampos();
                }
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {

            JButton botonFuente = (JButton) e.getSource();
            btnJavaOriginal = btnRegistrar.getBackground();

            if (botonFuente == btnRegistrar) {
                botonFuente.setBackground(Color.GREEN);
            } else {
                botonFuente.setBackground(Color.CYAN);
            }

        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton botonFuente = (JButton) e.getSource();

            botonFuente.setBackground(btnJavaOriginal);
        }
    }

    private void limpiarCampos() {

        txtNombre.setText(null);
        txtApellidos.setText(null);
        txtDescripcion.setText(null);
        cbxGeneros.setSelectedIndex(0);
    }

    private boolean comprobarDatos() {

        boolean todoCorrecto = true;

        if (txtNombre.getText().isBlank() || txtApellidos.getText().isBlank()) {
            JOptionPane.showMessageDialog(ventanaPrincipal, "Nombre y Apellidos no pueden estar vacios", "Información incompleta", 2);
            return false;
        }

        if (cbxGeneros.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(ventanaPrincipal, "Por favor elige una opción en género");
            return false;
        }

        int longitudTexto = txtDescripcion.getText().length();

        if (longitudTexto < 100) {
            JOptionPane.showMessageDialog(ventanaPrincipal, "Cuentanos un poco más sobre ti", "Texto descriptivo demasiado corto", 1);
            return false;
        }

        return todoCorrecto;

    }

}
