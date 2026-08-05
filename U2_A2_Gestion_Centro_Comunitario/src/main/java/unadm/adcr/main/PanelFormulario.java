package unadm.adcr.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelFormulario extends JPanel {

    private final JTextField txtNombreCurso;
    private final JTextArea areaDescripcion;
    private final JComboBox cbxInstructores;
    private final JCheckBox chkMatutino, chkVespertino, chkTarde;
    private final eventosRaton MANEJADOR = new eventosRaton();

    private final JButton btnRegistrar, btnLimpiar;

    public PanelFormulario() {

        setLayout(new BorderLayout());

        //Panel para el titulo con disposicion flowLayout
        JPanel pnlNorte = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        JLabel lblTitulo = new JLabel("Formulario de Registro para Nuevo Curso");
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(Font.BOLD, 22.0f));
        pnlNorte.add(lblTitulo);
        add(pnlNorte, BorderLayout.NORTH);

        //Panel central con el formulario en una disposicion grid dinamica
        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints ajustes = new GridBagConstraints();

        ajustes.insets = new Insets(20, 5, 10, 5);
        ajustes.anchor = GridBagConstraints.WEST;
        ajustes.gridx = 0;
        ajustes.gridy = 0;
        ajustes.weightx = 0;
        ajustes.weighty = 0;
        ajustes.gridwidth = 1;

        JLabel lblNombreCurso = new JLabel("Nombre del curso");
        panelCentral.add(lblNombreCurso, ajustes);

        ajustes.gridx = 1;
        ajustes.gridwidth = 2;
        txtNombreCurso = new JTextField(25);
        panelCentral.add(txtNombreCurso, ajustes);

        ajustes.gridx = 0;
        ajustes.gridy = 1;
        ajustes.gridwidth = 1;
        ajustes.anchor = GridBagConstraints.NORTH;
        JLabel lblDescripcion = new JLabel("Descripción del curso");
        panelCentral.add(lblDescripcion, ajustes);

        ajustes.gridx = 1;
        ajustes.gridwidth = 3;
        areaDescripcion = new JTextArea(10, 35);
        areaDescripcion.setWrapStyleWord(true);
        areaDescripcion.setLineWrap(true);
        JScrollPane areaConBarras = new JScrollPane(areaDescripcion,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panelCentral.add(areaConBarras, ajustes);

        ajustes.gridx = 0;
        ajustes.gridy = 2;
        ajustes.gridwidth = 1;
        ajustes.anchor = GridBagConstraints.WEST;
        JLabel lblInstructor = new JLabel("Seleccione instructor:");
        panelCentral.add(lblInstructor, ajustes);

        Object[] instructores = {"-", "Jesus Fabrega Jiménez", "Gonzalo Ramos", "Leticia Pineda", "Mauricio Valadez Piña", "Sandra Pulido Galván"};

        ajustes.gridx = 1;
        ajustes.gridwidth = 2;
        cbxInstructores = new JComboBox(instructores);
        panelCentral.add(cbxInstructores, ajustes);

        ajustes.gridx = 0;
        ajustes.gridy = 3;
        ajustes.gridwidth = 1;
        JLabel lblHorarios = new JLabel("Horarios disponibles:");
        panelCentral.add(lblHorarios, ajustes);

        ajustes.gridx = 1;
        ajustes.anchor = GridBagConstraints.CENTER;
        chkMatutino = new JCheckBox("Matutino", false);
        panelCentral.add(chkMatutino, ajustes);

        ajustes.gridx = 2;
        chkVespertino = new JCheckBox("Medio Día", false);
        panelCentral.add(chkVespertino, ajustes);

        ajustes.gridx = 3;
        chkTarde = new JCheckBox("Tarde", false);
        panelCentral.add(chkTarde, ajustes);

        ajustes.weighty = 0;
        ajustes.gridx = 2;
        ajustes.gridy = 4;
        ajustes.anchor = GridBagConstraints.EAST;
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addMouseListener(MANEJADOR);
        panelCentral.add(btnLimpiar, ajustes);

        ajustes.gridx = 3;
        ajustes.anchor = GridBagConstraints.WEST;
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addMouseListener(MANEJADOR);
        panelCentral.add(btnRegistrar, ajustes);

        ajustes.gridx = 0;
        ajustes.gridy = 5;
        ajustes.gridwidth = 4;
        ajustes.weighty = 1.0;
        ajustes.fill = GridBagConstraints.VERTICAL;
        JPanel rellenoVertical = new JPanel();
        panelCentral.add(rellenoVertical, ajustes);

        add(panelCentral, BorderLayout.CENTER);

        //Panel inferior con los botones y con una disposicion horizontal
        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 10));
        JButton btnVolver = new JButton("Regresar");
        btnVolver.addActionListener(ActionEvent -> {
            Ventana.cambiarVista("Inicio");
        });
        panelSur.add(btnVolver);

        add(panelSur, BorderLayout.SOUTH);

    }

    public Boolean validarCampos() {

        if (txtNombreCurso.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre del curso");
            txtNombreCurso.requestFocus();
            return false;
        }

        if (areaDescripcion.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese la descripción del curso");
            areaDescripcion.requestFocus();
            return false;
        }

        if (cbxInstructores.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el nombre del instructor");
            cbxInstructores.requestFocus();
            return false;
        }

        if (!chkMatutino.isSelected() && !chkVespertino.isSelected() && !chkTarde.isSelected()) {
            JOptionPane.showMessageDialog(this, "Seleccione al menos un horario disponible");
            return false;
        }

        return true;
    }

    public void vaciarCampos() {
        txtNombreCurso.setText("");
        areaDescripcion.setText("");
        cbxInstructores.setSelectedIndex(0);
        chkMatutino.setSelected(false);
        chkVespertino.setSelected(false);
        chkTarde.setSelected(false);
    }

    public class eventosRaton extends MouseAdapter {

        private eventosRaton() {

        }

        private Color botonOriginal;

        @Override
        public void mouseClicked(MouseEvent e) {

            JButton botonFuente = (JButton) e.getSource();

            if (botonFuente == btnRegistrar && validarCampos()) {
                JOptionPane.showMessageDialog(PanelFormulario.this, "El curso se ha registrado correctamente");
                vaciarCampos();
            }

            if (botonFuente == btnLimpiar) {
                vaciarCampos();
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            botonOriginal = btnRegistrar.getBackground();

            if ((JButton) e.getSource() == btnRegistrar) {
                btnRegistrar.setBackground(Color.GREEN);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            btnRegistrar.setBackground(botonOriginal);

        }
    }

}
