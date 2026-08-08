package unadm.adcr.main;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class VentanaRegistrar extends JDialog {

    private final JPanel pnlFormulario;
    private final JTextField txtTitulo, txtAutor, txtISBN, txtEditorial, txtAnio, txtPrecioCompra;
    private final JSpinner selectorInventario;
    private final Biblioteca biblioteca;

    public VentanaRegistrar(PrincipalFrame padre, Biblioteca biblioteca) {

        super(padre, true);

        this.biblioteca = biblioteca;

        setTitle("Módulo \"Registrar Libro\" - Adan Cortés Rodríguez");
        setSize(350, 600);
        setResizable(false);
        setIconImage(PrincipalFrame.favicon);
        setLayout(new BorderLayout());
        setLocationRelativeTo(padre);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Panel superior para el título
        JPanel pnlTitulo = new JPanel(new FlowLayout());
        pnlTitulo.setAlignmentX(FlowLayout.CENTER);

        JLabel titulo = new JLabel("Registrar Libro");
        titulo.setFont(new Font("Verdana", Font.BOLD, 22));
        titulo.setForeground(new Color(0, 48, 100));
        pnlTitulo.add(titulo);
        add(pnlTitulo, BorderLayout.NORTH);

        //Componentes del panel central (formulario)
        pnlFormulario = new JPanel();
        pnlFormulario.setLayout(new BoxLayout(pnlFormulario, BoxLayout.Y_AXIS));
        pnlFormulario.setBorder(BorderFactory.createEmptyBorder(20, 35, 20, 35));

        txtTitulo = crearCampo("Titulo del libro:", 400);
        txtAutor = crearCampo("Nombre del autor:", 400);
        txtISBN = crearCampo("ISBN:", 300);
        txtEditorial = crearCampo("Editorial", 400);
        txtAnio = crearCampo("Año de publicación:", 100);
        txtPrecioCompra = crearCampo("Precio de compra:", 100);

        //Aqui se implementa el componente JSpinner para seleccionar una cantidad
        pnlFormulario.add(new JLabel("Cantidad en inventario:"));
        selectorInventario = new JSpinner();
        selectorInventario.setMaximumSize(new Dimension(50, 25));
        pnlFormulario.add(selectorInventario);

        add(pnlFormulario, BorderLayout.CENTER);

        //Componentes del panel inferior (Botones de accion)
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new BoxLayout(pnlBotones, BoxLayout.X_AXIS));
        pnlBotones.setBorder(BorderFactory.createEmptyBorder(15, 30, 30, 30));

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarAction);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(this::btnRegistrarAction);

        pnlBotones.add(Box.createHorizontalGlue());
        pnlBotones.add(btnLimpiar);
        pnlBotones.add(Box.createHorizontalStrut(15));
        pnlBotones.add(btnRegistrar);

        add(pnlBotones, BorderLayout.SOUTH);

    }

    private JTextField crearCampo(String etiqueta, int ancho) {

        JTextField campo = new JTextField();
        campo.setMaximumSize(new Dimension(ancho, 25));

        pnlFormulario.add(new JLabel(etiqueta));
        pnlFormulario.add(campo);
        pnlFormulario.add(Box.createVerticalStrut(20));

        return campo;

    }

    private void btnLimpiarAction(ActionEvent e) {

        Object[] respuestas = {"Sí", "No"};

        if (JOptionPane.showOptionDialog(this, "¿Está seguro que desea vaciar todos los campos?", "Pregunta confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, respuestas, respuestas[0]) == 0) {

            vaciarCampos();
        }

    }

    private void btnRegistrarAction(ActionEvent e) {

        if (validarDatos()) {

            Libro libro = new Libro(
                    txtTitulo.getText(),
                    txtAutor.getText(),
                    txtISBN.getText(),
                    txtEditorial.getText(),
                    Integer.parseInt(txtAnio.getText()),
                    Double.parseDouble(txtPrecioCompra.getText()),
                    (int) selectorInventario.getValue()
            );

            biblioteca.agregarLibro(libro);
            vaciarCampos();

        }
    }

    private boolean validarDatos() {

        if (txtTitulo.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese el título del libro");
            txtTitulo.requestFocus();
            return false;
        }

        if (txtAutor.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese el nombre del autor");
            txtAutor.requestFocus();
            return false;
        }

        if (txtISBN.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese el ISBN");
            txtISBN.requestFocus();
            return false;
        }

        if (txtEditorial.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese la editorial");
            txtEditorial.requestFocus();
            return false;
        }

        if (Integer.parseInt(txtAnio.getText()) < 1500 || Integer.parseInt(txtAnio.getText()) > 2030) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un año válido");
            txtAnio.requestFocus();
            return false;
        }

        if (txtPrecioCompra.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un precio");
            return false;
        }

        if (Double.parseDouble(txtPrecioCompra.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un precio válido");
            txtPrecioCompra.requestFocus();
            return false;
        }

        if ((int) selectorInventario.getValue() < 0) {
            JOptionPane.showConfirmDialog(this, "El numero ingresado no puede ser negativo");
            selectorInventario.requestFocus();
            return false;
        }

        return true;
    }

    private void vaciarCampos() {

        txtAnio.setText("");
        txtAutor.setText("");
        txtEditorial.setText("");
        txtISBN.setText("");
        txtPrecioCompra.setText("");
        txtTitulo.setText("");
        selectorInventario.setValue(0);
    }

}
