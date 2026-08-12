package unadm.adcr.main;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class VentanaCatalogo extends JDialog {

    private final Biblioteca biblioteca;
    DefaultTableModel modeloTabla;
    private JTree arbol;
    private final JTable tablaLibros;
    private final JPanel pnlInferior;

    public VentanaCatalogo(PrincipalFrame padre, Biblioteca biblioteca) {

        super(padre, true);
        this.biblioteca = biblioteca;

        setTitle("Módulo \"Catalogo de Libros\" - Adan Cortés Rodríguez");
        setSize(1000, 720);
        setResizable(false);
        setIconImage(PrincipalFrame.favicon);
        setLayout(new BorderLayout());
        setLocationRelativeTo(padre);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Panel superior "Titulo
        //======================================================================
        JPanel pnlTitulo = new JPanel(new FlowLayout());
        pnlTitulo.setAlignmentX(FlowLayout.CENTER);

        JLabel titulo = new JLabel("Catalogo de Libros");
        titulo.setFont(new Font("Verdana", Font.BOLD, 22));
        titulo.setForeground(new Color(0, 48, 100));
        pnlTitulo.add(titulo);
        add(pnlTitulo, BorderLayout.NORTH);

        // Panel central "Tabla
        //======================================================================
        String[] columnas = {"Título", "Autor", "Editorial", "Año"};

        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaLibros = new JTable(modeloTabla);

        cargarLibros();

        JPanel pnlLibros = new JPanel();
        pnlLibros.setLayout(new FlowLayout());
        pnlLibros.setBorder(BorderFactory.createEmptyBorder(5, 30, 10, 30));

        JScrollPane scrollTabla = new JScrollPane(tablaLibros);
        scrollTabla.setPreferredSize(new Dimension(940, 350));
        pnlLibros.add(scrollTabla, BorderLayout.CENTER);
        add(pnlLibros);

        // Panel inferior "Categorias"
        //======================================================================
        pnlInferior = new JPanel();
        pnlInferior.setLayout(new BoxLayout(pnlInferior, BoxLayout.Y_AXIS));
        pnlInferior.setBorder(BorderFactory.createEmptyBorder(10, 30, 50, 30));

        JLabel lblCategorias = new JLabel("Arbol de Categorias");
        lblCategorias.setFont(new Font("Verdana", Font.BOLD, 22));
        lblCategorias.setForeground(new Color(0, 48, 100));
        lblCategorias.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlInferior.add(lblCategorias);

        generarArbol();
        JScrollPane scrollArbol = new JScrollPane(arbol);
        scrollArbol.setMaximumSize(new Dimension(500, 200));
        scrollArbol.setPreferredSize(new Dimension(500, 200));
        pnlInferior.add(scrollArbol);

        add(pnlInferior, BorderLayout.SOUTH);

        //Menu Emergente
        //======================================================================
        tablaLibros.setComponentPopupMenu(generarMenuEmergente());

    }

    // <editor-fold defaultstate="expanded" desc="Metodos de clase">
    private void cargarLibros() {
        for (Libro libro : biblioteca.obtenerListado()) {
            modeloTabla.addRow(new Object[]{
                libro.getNombre(),
                libro.getAutor(),
                libro.getIsbn(),
                libro.getEditorial(),
                libro.getAnio(),
                libro.getPrecio(),
                libro.getStock()
            }
            );
        }
    }

    private JPopupMenu generarMenuEmergente() {
        JPopupMenu menuEmergente = new JPopupMenu();

        JMenuItem verDetalles = new JMenuItem("Ver Detalles");
        JMenuItem editarLibro = new JMenuItem("Editar Libro");
        JMenuItem eliminarLibro = new JMenuItem("Eliminar Libro");

        menuEmergente.add(verDetalles);
        menuEmergente.addSeparator();
        menuEmergente.add(editarLibro);
        menuEmergente.add(eliminarLibro);

        verDetalles.addActionListener(e -> {

            int fila = tablaLibros.getSelectedRow();

            if (fila >= 0) {

                Libro libro = biblioteca.obtenerListado().get(fila);

                JOptionPane.showMessageDialog(
                        this,
                        "Título: " + libro.getNombre()
                        + "\nAutor: " + libro.getAutor()
                        + "\nISBN: " + libro.getIsbn()
                        + "\nEditorial: " + libro.getEditorial()
                        + "\nAño: " + libro.getAnio()
                        + "\nPrecio: $" + libro.getPrecio()
                        + "\nStock: " + libro.getStock(),
                        "Información del libro",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        editarLibro.addActionListener(ActionEvent -> {
            JOptionPane.showMessageDialog(menuEmergente, "Función \"Editar\" simulada!");
        });

        eliminarLibro.addActionListener(ActionEvent -> {
            JOptionPane.showMessageDialog(menuEmergente, "Función \"Eliminar\" simulada!");
        });

        return menuEmergente;
    }

    private void generarArbol() {
        //Categorias------------------------------------------------------------
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Categorias");
        DefaultMutableTreeNode infantiles = new DefaultMutableTreeNode("Infantiles", false);
        DefaultMutableTreeNode arte = new DefaultMutableTreeNode("Arte");
        DefaultMutableTreeNode ciencias = new DefaultMutableTreeNode("Ciencias");
        DefaultMutableTreeNode literatura = new DefaultMutableTreeNode("Literatura", false);
        DefaultMutableTreeNode historia = new DefaultMutableTreeNode("Historia");
        DefaultMutableTreeNode novelas = new DefaultMutableTreeNode("Novelas", false);
        DefaultMutableTreeNode informatica = new DefaultMutableTreeNode("Informática");

        //Subcategorias---------------------------------------------------------
        DefaultMutableTreeNode artesPlasticas = new DefaultMutableTreeNode("Artes Plasticas");
        DefaultMutableTreeNode cine = new DefaultMutableTreeNode("Cine");
        DefaultMutableTreeNode teatro = new DefaultMutableTreeNode("Teatro");
        DefaultMutableTreeNode cienciasAplicadas = new DefaultMutableTreeNode("Ciencias Aplicadas");
        DefaultMutableTreeNode cienciasNaturales = new DefaultMutableTreeNode("Ciencias Naturales");
        DefaultMutableTreeNode historiaMexico = new DefaultMutableTreeNode("Historia de México");
        DefaultMutableTreeNode primeraGuerra = new DefaultMutableTreeNode("Libros de la 1ª Guerra Mundial");
        DefaultMutableTreeNode programacion = new DefaultMutableTreeNode("Programación Orientada a Objetos");
        DefaultMutableTreeNode segInformatica = new DefaultMutableTreeNode("Seguridad Informática");
        DefaultMutableTreeNode disenioGrafico = new DefaultMutableTreeNode("Diseño Gráfico");

        raiz.add(infantiles);
        raiz.add(arte);
        raiz.add(ciencias);
        raiz.add(literatura);
        raiz.add(historia);
        raiz.add(novelas);
        raiz.add(informatica);

        arte.add(cine);
        arte.add(artesPlasticas);
        arte.add(teatro);
        ciencias.add(cienciasAplicadas);
        ciencias.add(cienciasNaturales);
        historia.add(historiaMexico);
        historia.add(primeraGuerra);
        informatica.add(programacion);
        informatica.add(segInformatica);
        informatica.add(disenioGrafico);

        arbol = new JTree(raiz);

    }

// </editor-fold>
}
