package unadm.adcr.main;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class VentanaRegistro extends JDialog {

    private JTextField txtNombreMascota, txtNombreCliente, txtEspecie;
    private JRadioButton sexoM, sexoF;
    private JSpinner spnEdad, spnPeso;
    private JComboBox cbxTemperamento;
    private JCheckBox chkEsterilizado, chkAlergico, chkChip, chkSeguro, chkBozal, chkEnfermedad;
    private JTextArea txtNotas;
    private ButtonGroup botonesSexo;

    private JButton btnLimpiar, btnCancelar, btnRegistrar;

    private final String[] listaTemperamentos = {"—", "1 — Pasivo / Muy Tranquilo", "2 — Docil / Cauto",
        "3 — Amigable / Juguetón", "4 — Desconfiado / Poco Agresivo", "5 — Muy Agresivo"};

    public VentanaRegistro(VentanaMascotas owner) {
        super(owner, true);

        // Propiedades de la ventana ===============================================================
        setTitle("Mascotas — Registrar Nueva Mascota");
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

        JLabel lblTitulo = new JLabel("Formulario de Nueva Mascota");
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(Font.BOLD, 20.0f));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlSuperior.add(lblTitulo);

        pnlSuperior.add(Box.createVerticalStrut(8));

        Box filaNota = Box.createHorizontalBox();
        filaNota.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblNota = new JLabel("Con * se indican los campos obligatorios");
        filaNota.add(lblNota);
        filaNota.add(Box.createHorizontalGlue());

        pnlSuperior.add(filaNota);

        //<editor-fold defaultstate="collapsed" desc="Componentes del formulario">
        // Panel central con el formulario =========================================================
        JPanel pnlCentral = new JPanel(new GridBagLayout());
        pnlCentral.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 10, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlCentral.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LINE_END;
        pnlCentral.add(new JLabel("* Nombre de la Mascota:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        txtNombreMascota = new JTextField(10);
        txtNombreMascota.setPreferredSize(new Dimension(0, 25));
        pnlCentral.add(txtNombreMascota, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        pnlCentral.add(new JLabel("* Nombre del Cliente:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        txtNombreCliente = new JTextField(20);
        txtNombreCliente.setPreferredSize(new Dimension(0, 25));
        pnlCentral.add(txtNombreCliente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        pnlCentral.add(new JLabel("* Tipo de Mascota:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        txtEspecie = new JTextField(10);
        txtEspecie.setPreferredSize(new Dimension(0, 25));
        pnlCentral.add(txtEspecie, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        pnlCentral.add(new JLabel("Sexo:"), gbc);

        botonesSexo = new ButtonGroup();
        sexoM = new JRadioButton("Macho");
        sexoF = new JRadioButton("Hembra");
        sexoM.setActionCommand("Macho");
        sexoF.setActionCommand("Hembra");
        botonesSexo.add(sexoM);
        botonesSexo.add(sexoF);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        pnlCentral.add(sexoM, gbc);

        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.WEST;
        pnlCentral.add(sexoF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        pnlCentral.add(new JLabel("Edad (meses):"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        SpinnerNumberModel modeloEdad = new SpinnerNumberModel(1, 0, Integer.MAX_VALUE, 1);
        spnEdad = new JSpinner(modeloEdad);
        spnEdad.setPreferredSize(new Dimension(70, 25));
        pnlCentral.add(spnEdad, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_END;
        pnlCentral.add(new JLabel("Peso (Kg.):"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        SpinnerNumberModel modeloPeso = new SpinnerNumberModel(0.1, 0.1, Double.MAX_VALUE, 0.5);
        spnPeso = new JSpinner(modeloPeso);
        spnPeso.setPreferredSize(new Dimension(70, 25));
        pnlCentral.add(spnPeso, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_END;
        pnlCentral.add(new JLabel("* Temperamento"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        cbxTemperamento = new JComboBox(listaTemperamentos);
        pnlCentral.add(cbxTemperamento, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlCentral.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.ABOVE_BASELINE;
        pnlCentral.add(new JLabel("DETALLES CLÍNICOS"), gbc);

        chkEsterilizado = new JCheckBox("Esterilizado/a");
        chkAlergico = new JCheckBox("Alergias");
        chkChip = new JCheckBox("Chip Implantado");
        chkSeguro = new JCheckBox("Tiene Seguro");
        chkBozal = new JCheckBox("Requiere Bozal");
        chkEnfermedad = new JCheckBox("Enfermedad Crónica");

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.LINE_START;
        pnlCentral.add(chkEsterilizado, gbc);
        gbc.gridx = 1;
        pnlCentral.add(chkAlergico, gbc);
        gbc.gridx = 2;
        pnlCentral.add(chkEnfermedad, gbc);
        gbc.gridx = 0;
        gbc.gridy = 11;
        pnlCentral.add(chkChip, gbc);
        gbc.gridx = 1;
        pnlCentral.add(chkSeguro, gbc);
        gbc.gridx = 2;
        pnlCentral.add(chkBozal, gbc);

        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlCentral.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = (new Insets(2, 5, 2, 5));
        pnlCentral.add(new JLabel("Notas adicionales:"), gbc);

        gbc.gridy = 14;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNotas = new JTextArea(6, 40);
        txtNotas.setWrapStyleWord(true);
        txtNotas.setLineWrap(true);
        JScrollPane scrollArea = new JScrollPane(txtNotas,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pnlCentral.add(scrollArea, gbc);
        //</editor-fold>

        // Panel inferior con los botones ==========================================================
        JPanel pnlInferior = new JPanel();
        pnlInferior.setLayout(new BoxLayout(pnlInferior, BoxLayout.X_AXIS));
        pnlInferior.setBorder(BorderFactory.createEmptyBorder(15, 30, 20, 30));

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setFocusable(false);
        btnLimpiar.addActionListener(this::btnLimpiarAction);
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFocusable(false);
        btnCancelar.addActionListener(this::btnCancelarAction);
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFocusable(false);
        btnRegistrar.addActionListener(this::btnRegistrarAction);

        pnlInferior.add(btnLimpiar);
        pnlInferior.add(Box.createHorizontalGlue());
        pnlInferior.add(btnRegistrar);
        pnlInferior.add(Box.createHorizontalStrut(10));
        pnlInferior.add(btnCancelar);

        add(pnlSuperior, BorderLayout.NORTH);
        add(pnlCentral, BorderLayout.CENTER);
        add(pnlInferior, BorderLayout.SOUTH);
    }

    private boolean comprobarFormulario() {

        if (txtNombreMascota.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "El nombre de la mascota no puede quedar vacio");
            txtNombreMascota.requestFocus();
            return false;
        }

        if (txtNombreCliente.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "El nombre del cliente no puede quedar vacio");
            txtNombreCliente.requestFocus();
            return false;
        }

        if (txtEspecie.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa el tipo/especie de mascota");
            txtEspecie.requestFocus();
            return false;
        }

        if (cbxTemperamento.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor indica el temperamento de la mascota");
            cbxTemperamento.requestFocus();
            return false;
        }

        return true;
    }

    private void vaciarFormulario() {
        txtNombreMascota.setText("");
        txtNombreCliente.setText("");
        txtEspecie.setText("");
        botonesSexo.clearSelection();
        spnEdad.setValue(1);
        spnPeso.setValue(0.1);
        cbxTemperamento.setSelectedIndex(0);
        chkAlergico.setSelected(false);
        chkBozal.setSelected(false);
        chkChip.setSelected(false);
        chkEnfermedad.setSelected(false);
        chkEsterilizado.setSelected(false);
        chkSeguro.setSelected(false);
        txtNotas.setText("");
    }

    private void btnLimpiarAction(ActionEvent e) {

        if (JOptionPane.showConfirmDialog(this, "¿Seguro que quieres borrar todos los campos?", "Confirmación", JOptionPane.YES_NO_OPTION) == 0) {
            vaciarFormulario();
        }

    }

    private void btnCancelarAction(ActionEvent e) {

        if (JOptionPane.showConfirmDialog(this, "¿Seguro que desea salir sin registrar la mascota?", "Confirmación", JOptionPane.YES_NO_OPTION) == 0) {

            this.dispose();
        }

    }

    private void btnRegistrarAction(ActionEvent e) {

        String sexo = "No especificado";
        if (sexoM.isSelected() || sexoF.isSelected()) {
            sexo = botonesSexo.getSelection().getActionCommand();
        }

        List<String> listaDetalles = new ArrayList<>();

        if (chkSeguro.isSelected()) {
            listaDetalles.add("Tiene seguro");
        }

        if (chkAlergico.isSelected()) {
            listaDetalles.add("Es alergico");
        }

        if (chkEnfermedad.isSelected()) {
            listaDetalles.add("Presenta enfermedad crónica");
        }

        if (chkEsterilizado.isSelected()) {
            listaDetalles.add("Esta esterilizado/a");
        }

        if (chkChip.isSelected()) {
            listaDetalles.add("Tiene implantado un microchip");
        }

        if (chkBozal.isSelected()) {
            listaDetalles.add("¡Cuidado, requiere bozal!");
        }

        String cadenaDetalles = String.join(", ", listaDetalles);

        if (comprobarFormulario()) {
            Mascota mascota = new Mascota(Registro.INSTANCIA.comprobarIdDisponible(),
                    txtNombreMascota.getText(),
                    txtNombreCliente.getText(),
                    txtEspecie.getText(),
                    sexo,
                    (int) spnEdad.getValue(),
                    (double) spnPeso.getValue(),
                    cbxTemperamento.getSelectedItem().toString(),
                    cadenaDetalles,
                    txtNotas.getText());

            Registro.INSTANCIA.agregarMascota(mascota);
            JOptionPane.showMessageDialog(this, "Mascota registrada con exito");
            vaciarFormulario();
        }
        
    }

}
