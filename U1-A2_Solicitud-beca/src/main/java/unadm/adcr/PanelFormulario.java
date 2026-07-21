package unadm.adcr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelFormulario extends JPanel {

    private final VentanaBase ventanaPadre;
    private final JTextField txtNombre;
    private final JTextField txtMatricula;
    private final JTextArea txtJustificacion;
    private final JComboBox listaUnidades;
    private Color colorOriginal;

    public PanelFormulario(VentanaBase vp) {

        this.ventanaPadre = vp;

        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Formulario de Solicitud de Becas", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 22));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel formulario = new JPanel();
        formulario.setLayout((new BoxLayout(formulario, BoxLayout.Y_AXIS)));
        formulario.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));

        JLabel lblNombre = new JLabel("Nombre del solicitante:");
        txtNombre = new JTextField(20);
        formulario.add(lblNombre);
        formulario.add(txtNombre);
        formulario.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel lblMatricula = new JLabel("Matricula de estudiante");
        txtMatricula = new JTextField(20);
        formulario.add(lblMatricula);
        formulario.add(txtMatricula);
        formulario.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel lblJustificacion = new JLabel("¿Cual es el principal motivo para solicitar la beca?");
        txtJustificacion = new JTextArea();
        txtJustificacion.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtJustificacion.setLineWrap(true);
        txtJustificacion.setWrapStyleWord(true);

        txtJustificacion.setPreferredSize(new Dimension(50, 80));
        formulario.add(lblJustificacion);
        formulario.add(txtJustificacion);
        formulario.add(Box.createRigidArea(new Dimension(0, 20)));

        Object[] unidades = {"-", "Ing en Biotecnológia", "Ing en Desarrollo de Software", "Ing en Telemática", "Ing en Logística y Transporte", "Licenciatura en Matemáticas",
            "Licenciatura en Desarrollo Comunitario", "Licenciatura en Gestión Territorial", "Licenciatura en Derecho"};

        JLabel lblUnidad = new JLabel("Unidad Académica");
        listaUnidades = new JComboBox(unidades);
        listaUnidades.setAlignmentX(Component.LEFT_ALIGNMENT);

        formulario.add(lblUnidad);
        formulario.add(listaUnidades);
        formulario.add(Box.createRigidArea(new Dimension(0, 40)));

        JButton btnRegistrar = new JButton("Registrar");
        colorOriginal = btnRegistrar.getBackground();
        
        btnRegistrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnRegistrar.setBackground(new Color(0, 218, 99));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                btnRegistrar.setBackground(colorOriginal);
            }
        });
        
        btnRegistrar.addActionListener(this::btnRegistrarActionPerformed);
        formulario.add(btnRegistrar);
        formulario.add(Box.createRigidArea(new Dimension(0, 40)));

        JButton btnVolver = new JButton("Volver al Menú");
        btnVolver.addActionListener(this::btnVolverActionPerformed);
        formulario.add(btnVolver);

        add(formulario, BorderLayout.CENTER);

    }

    private void btnVolverActionPerformed(ActionEvent evt) {
        ventanaPadre.cambiarPanel(new PanelMenu(ventanaPadre));

    }
    
    private void btnRegistrarActionPerformed(ActionEvent e){
        
        JOptionPane.showMessageDialog(null, "Registro completo a nombre de " + txtNombre.getText());
        txtNombre.setText("");
        txtMatricula.setText("");
        txtJustificacion.setText("");
        listaUnidades.setSelectedIndex(0);        
    }

}
