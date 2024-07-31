/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ingenieria1202410;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author josearielpereyra
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private PanelDeDibujo panelDeDibujo;
    private final String titulo = "Dibujador";

    @SuppressWarnings("empty-statement")
    public VentanaPrincipal() {
        initComponents();
        CursorMano();
        this.setSize(1000, 600);

        System.err.println("Inicio");
        panelDeDibujo = new PanelDeDibujo();
        // panelDeDibujo.setPreferredSize(new Dimension(1280, 720));
        areaDibujoPanel.add(panelDeDibujo);

        // Ajustar el tamaño del panel de dibujo al contenedor
        panelDeDibujo.setBounds(0, 0, 1280, 600);

        // Establecer el layout del área de dibujo
        areaDibujoPanel.setLayout(null); // Usando un layout absoluto

        // Establecer el tamaño preferido del área de dibujo
        areaDibujoPanel.setPreferredSize(new Dimension(1280, 600));
        this.setTitle(titulo);
        // La ventana pueda recibir eventos de teclado
        setFocusable(true);
        requestFocusInWindow();
        //Inicializa el valor del pincel
        panelDeDibujo.grosorFigura = jSliderTamañoPincel.getValue();
        //Inicializa el valor del color de primer plano
        panelDeDibujo.colorDePrimerPlano = jPanelColorPrincipal.getBackground();
        panelDeDibujo.colorDeSegundoPlano = jPanelColorSecundario.getBackground();

        resolucionText.setText("R: " + panelDeDibujo.getWidth() + " X " + panelDeDibujo.getHeight());
        panelDeDibujo.addMouseMotionListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                coordenadaText.setText("C: " + evt.getX() + ", " + evt.getY());
            }
        });

        Color[] coloresPrincipales = {
            new Color(255, 182, 193), // Rojo claro
            Color.RED, // Rojo
            new Color(139, 0, 0), // Rojo oscuro
            new Color(173, 255, 47), // Verde claro
            Color.GREEN, // Verde
            new Color(0, 100, 0), // Verde oscuro
            new Color(173, 216, 230), // Azul claro
            Color.BLUE, // Azul
            new Color(0, 0, 139), // Azul oscuro
            Color.WHITE,
            new Color(255, 128, 192), // Magenta claro
            new Color(255, 0, 255), // Magenta
            new Color(192, 0, 128), // Magenta oscuro
            new Color(255, 255, 150), // Amarillo claro
            new Color(255, 255, 0), // Amarillo
            new Color(128, 128, 0), // Amarillo oscuro
            new Color(150, 255, 255), // Cyan claro
            new Color(0, 255, 255), // Cyan
            new Color(0, 128, 128), // Cyan oscuro
            Color.BLACK
        };

        for (Color coloresPrincipale : coloresPrincipales) {
            JPanel color = new JPanel();
            color.setBackground(coloresPrincipale);
            color.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    if (SwingUtilities.isLeftMouseButton(evt)) {
                        jPanelColorPrincipal.setBackground(color.getBackground());
                        panelDeDibujo.colorDePrimerPlano = jPanelColorPrincipal.getBackground();
                    } else if (SwingUtilities.isRightMouseButton(evt)) {
                        jPanelColorSecundario.setBackground(color.getBackground());
                        panelDeDibujo.colorDeSegundoPlano = jPanelColorSecundario.getBackground();
                    }
                }
            });
            jPanelBarraColores.add(color);
        }
    }

    private void redimensionarLienzo() {
        JTextField anchoLienzo = new JTextField(5);
        JTextField largoLienzo = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Ancho:"));
        myPanel.add(anchoLienzo);
        myPanel.add(Box.createHorizontalStrut(1)); // Espacio horizontal
        myPanel.add(new JLabel("Largo:"));
        myPanel.add(largoLienzo);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Introduzca la resolución", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            // Obtener las dimensiones ingresadas y actualizar el lienzo
            int width = Integer.parseInt(anchoLienzo.getText());
            int height = Integer.parseInt(largoLienzo.getText());

            // Actualizar el tamaño del panel de dibujo
            panelDeDibujo.setPreferredSize(new Dimension(width, height));
            panelDeDibujo.setBounds(0, 0, width, height);

            // Revalidar y repintar el área de dibujo
            areaDibujoPanel.revalidate();
            areaDibujoPanel.repaint();
        }
        resolucionText.setText("R: " + panelDeDibujo.getWidth() + ", " + panelDeDibujo.getHeight());
    }

    private void actualizarSlider() {
        int valorSlider = (int) (panelDeDibujo.getEscala() * 10);
        jSliderZoom.setValue(valorSlider);
    }

    private void CursorPincel() {
        ImageIcon Icono = new ImageIcon("src/Icons/Punto.png");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Cursor cursorPincel = tk.createCustomCursor(Icono.getImage(), new Point(20, 20), "Cursor Pincel");
        setCursor(cursorPincel);
    }

    private void CursorMano() {
        Cursor mano = new Cursor(Cursor.HAND_CURSOR);
        botonPincel.setCursor(mano);
        jSliderTamañoPincel.setCursor(mano);
        botonBorrador.setCursor(mano);
        botonBalde.setCursor(mano);
        botonGotero.setCursor(mano);
        botonLupa.setCursor(mano);
        jPanelColorPrincipal.setCursor(mano);
        botonColor.setCursor(mano);
        botonLinea.setCursor(mano);
        botonTriangulo.setCursor(mano);
        botonRectangulo.setCursor(mano);
        botonOvalo.setCursor(mano);
        jCheckBoxRellenar.setCursor(mano);
        jCheckBoxSimétrico.setCursor(mano);
        reducirZoom.setCursor(mano);
        aumentarZoom.setCursor(mano);
        jSliderZoom.setCursor(mano);
        jMenuItemArchivo.setCursor(mano);
        jMenuItemNuevo.setCursor(mano);
        jMenuItemAbrir.setCursor(mano);
        jMenuItemGuardar.setCursor(mano);
        jMenuItemGuardarComo.setCursor(mano);
        jMenuItemImprimir.setCursor(mano);
        jImagenPNG.setCursor(mano);
        jImagenJPG.setCursor(mano);
        jMenuItemCambiarTamano.setCursor(mano);
        jMenuItemCortar.setCursor(mano);
        jMenuItemCopiar.setCursor(mano);
        jjMenuItemPegar.setCursor(mano);
        jMenuItemDeshacer.setCursor(mano);
        jMenuItemRehacer.setCursor(mano);
        menuAyuda.setCursor(mano);
        menuItemTemasDeAyuda.setCursor(mano);
        menuItemAcercaDe.setCursor(mano);
        jMenuItemEditar.setCursor(mano);
    }
    private void CursorBorrador() {
        ImageIcon Icono = new ImageIcon("src/Icons/eraser.png");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Cursor cursorPincel = tk.createCustomCursor(Icono.getImage(), new Point(20, 20), "Cursor Borrador");
        setCursor(cursorPincel);
    }
    private void CursorBaldeDePintura() {
        ImageIcon Icono = new ImageIcon("src/Icons/paint-bucket.png");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Cursor cursorPincel = tk.createCustomCursor(Icono.getImage(), new Point(20, 20), "Cursor Balde de Pintura");
        setCursor(cursorPincel);
    }
    private void CursorGotero() {
        ImageIcon Icono = new ImageIcon("src/Icons/color-selector.png");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Cursor cursorPincel = tk.createCustomCursor(Icono.getImage(), new Point(20, 20), "Gotero");
        setCursor(cursorPincel);
    }
        private void CursorLupa() {
        ImageIcon Icono = new ImageIcon("src/Icons/loupe.png");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Cursor cursorPincel = tk.createCustomCursor(Icono.getImage(), new Point(20, 20), "Lupa");
        setCursor(cursorPincel);
    }
//        private void CursorFiguraLinea() {
//        ImageIcon Icono = new ImageIcon("src/Icons/remove.png");
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        Cursor cursorPincel = tk.createCustomCursor(Icono.getImage(), new Point(20, 20), "Figura Linea");
//        setCursor(cursorPincel);
//    }   
    private void cursorRetorno() {
        Cursor retorno = new Cursor(Cursor.DEFAULT_CURSOR);
        setCursor(retorno);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupPanel = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanelDeHerramientas = new javax.swing.JPanel();
        jToolBarPincelYHerramientas = new javax.swing.JToolBar();
        botonPincel = new javax.swing.JToggleButton();
        jPanelSeparador = new javax.swing.JPanel();
        jPanelTamañoPincel = new javax.swing.JPanel();
        textoPincel = new javax.swing.JLabel();
        jSliderTamañoPincel = new javax.swing.JSlider();
        jPanelSeparador2 = new javax.swing.JPanel();
        botonBorrador = new javax.swing.JToggleButton();
        botonBalde = new javax.swing.JToggleButton();
        botonGotero = new javax.swing.JToggleButton();
        botonLupa = new javax.swing.JToggleButton();
        jToolBarColores = new javax.swing.JToolBar();
        jPanelSeparador3 = new javax.swing.JPanel();
        jPanelColorPrincipal = new javax.swing.JPanel();
        jPanelSeparador4 = new javax.swing.JPanel();
        jPanelColorSecundario = new javax.swing.JPanel();
        jPanelSeparador5 = new javax.swing.JPanel();
        jPanelContenedorColores = new javax.swing.JPanel();
        jPanelBarraColores = new javax.swing.JPanel();
        botonColor = new javax.swing.JToggleButton();
        jToolBarFiguras = new javax.swing.JToolBar();
        botonLinea = new javax.swing.JToggleButton();
        botonTriangulo = new javax.swing.JToggleButton();
        botonRectangulo = new javax.swing.JToggleButton();
        botonOvalo = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jCheckBoxRellenar = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jCheckBoxSimétrico = new javax.swing.JCheckBox();
        jScrollPanelAreaDibujo = new javax.swing.JScrollPane();
        areaDibujoPanel = new javax.swing.JPanel();
        jPanelInformacion = new javax.swing.JPanel();
        propiedades = new javax.swing.JPanel();
        propiedadesDatos = new javax.swing.JPanel();
        coordenadaText = new javax.swing.JLabel();
        resolucionText = new javax.swing.JLabel();
        zoom = new javax.swing.JPanel();
        zoomAjuste = new javax.swing.JPanel();
        zoomTexto = new javax.swing.JLabel();
        zoomValor = new javax.swing.JLabel();
        reducirZoom = new javax.swing.JButton();
        jSliderZoom = new javax.swing.JSlider();
        aumentarZoom = new javax.swing.JButton();
        jMenuGeneral = new javax.swing.JMenuBar();
        jMenuItemArchivo = new javax.swing.JMenu();
        jMenuItemNuevo = new javax.swing.JMenuItem();
        jMenuItemAbrir = new javax.swing.JMenuItem();
        jMenuItemGuardar = new javax.swing.JMenuItem();
        jMenuItemGuardarComo = new javax.swing.JMenu();
        jImagenPNG = new javax.swing.JMenuItem();
        jImagenJPG = new javax.swing.JMenuItem();
        jMenuItemImprimir = new javax.swing.JMenuItem();
        jMenuItemEditar = new javax.swing.JMenu();
        jMenuItemCambiarTamano = new javax.swing.JMenuItem();
        jMenuItemCortar = new javax.swing.JMenuItem();
        jMenuItemCopiar = new javax.swing.JMenuItem();
        jjMenuItemPegar = new javax.swing.JMenuItem();
        jMenuItemDeshacer = new javax.swing.JMenu();
        jMenuItemRehacer = new javax.swing.JMenu();
        menuAyuda = new javax.swing.JMenu();
        menuItemTemasDeAyuda = new javax.swing.JMenuItem();
        menuItemAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanelDeHerramientas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelDeHerramientas.setToolTipText("Herramientas");
        jPanelDeHerramientas.setMaximumSize(new java.awt.Dimension(235, 56));
        jPanelDeHerramientas.setName("Herramientas"); // NOI18N
        jPanelDeHerramientas.setPreferredSize(new java.awt.Dimension(789, 50));
        jPanelDeHerramientas.setLayout(new javax.swing.BoxLayout(jPanelDeHerramientas, javax.swing.BoxLayout.LINE_AXIS));

        jToolBarPincelYHerramientas.setRollover(true);
        jToolBarPincelYHerramientas.setToolTipText("Herramientas");
        jToolBarPincelYHerramientas.setBorderPainted(false);

        buttonGroupPanel.add(botonPincel);
        botonPincel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/brush.png"))); // NOI18N
        botonPincel.setToolTipText("Pincel");
        botonPincel.setBorder(null);
        botonPincel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonPincel.setMaximumSize(new java.awt.Dimension(40, 40));
        botonPincel.setMinimumSize(new java.awt.Dimension(40, 40));
        botonPincel.setPreferredSize(new java.awt.Dimension(40, 40));
        botonPincel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonPincel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPincelActionPerformed(evt);
            }
        });
        jToolBarPincelYHerramientas.add(botonPincel);

        jPanelSeparador.setPreferredSize(new java.awt.Dimension(3, 42));

        javax.swing.GroupLayout jPanelSeparadorLayout = new javax.swing.GroupLayout(jPanelSeparador);
        jPanelSeparador.setLayout(jPanelSeparadorLayout);
        jPanelSeparadorLayout.setHorizontalGroup(
            jPanelSeparadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanelSeparadorLayout.setVerticalGroup(
            jPanelSeparadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        jToolBarPincelYHerramientas.add(jPanelSeparador);

        jPanelTamañoPincel.setPreferredSize(new java.awt.Dimension(110, 39));

        textoPincel.setText("Tamaño 5");

        jSliderTamañoPincel.setMaximum(10);
        jSliderTamañoPincel.setMinimum(1);
        jSliderTamañoPincel.setToolTipText("Tamaño pincel");
        jSliderTamañoPincel.setValue(5);
        jSliderTamañoPincel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderTamañoPincelStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelTamañoPincelLayout = new javax.swing.GroupLayout(jPanelTamañoPincel);
        jPanelTamañoPincel.setLayout(jPanelTamañoPincelLayout);
        jPanelTamañoPincelLayout.setHorizontalGroup(
            jPanelTamañoPincelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textoPincel, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
            .addComponent(jSliderTamañoPincel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanelTamañoPincelLayout.setVerticalGroup(
            jPanelTamañoPincelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTamañoPincelLayout.createSequentialGroup()
                .addComponent(textoPincel)
                .addGap(0, 0, 0)
                .addComponent(jSliderTamañoPincel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jToolBarPincelYHerramientas.add(jPanelTamañoPincel);

        jPanelSeparador2.setPreferredSize(new java.awt.Dimension(3, 42));

        javax.swing.GroupLayout jPanelSeparador2Layout = new javax.swing.GroupLayout(jPanelSeparador2);
        jPanelSeparador2.setLayout(jPanelSeparador2Layout);
        jPanelSeparador2Layout.setHorizontalGroup(
            jPanelSeparador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanelSeparador2Layout.setVerticalGroup(
            jPanelSeparador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        jToolBarPincelYHerramientas.add(jPanelSeparador2);

        buttonGroupPanel.add(botonBorrador);
        botonBorrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eraser.png"))); // NOI18N
        botonBorrador.setToolTipText("Borrador");
        botonBorrador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonBorrador.setMaximumSize(new java.awt.Dimension(40, 40));
        botonBorrador.setMinimumSize(new java.awt.Dimension(40, 40));
        botonBorrador.setPreferredSize(new java.awt.Dimension(40, 40));
        botonBorrador.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonBorrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorradorActionPerformed(evt);
            }
        });
        jToolBarPincelYHerramientas.add(botonBorrador);

        buttonGroupPanel.add(botonBalde);
        botonBalde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/paint-bucket.png"))); // NOI18N
        botonBalde.setToolTipText("Cubeta de pintura");
        botonBalde.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonBalde.setMaximumSize(new java.awt.Dimension(40, 40));
        botonBalde.setMinimumSize(new java.awt.Dimension(40, 40));
        botonBalde.setPreferredSize(new java.awt.Dimension(40, 40));
        botonBalde.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonBalde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBaldeActionPerformed(evt);
            }
        });
        jToolBarPincelYHerramientas.add(botonBalde);

        buttonGroupPanel.add(botonGotero);
        botonGotero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/color-selector.png"))); // NOI18N
        botonGotero.setToolTipText("Extractor de color");
        botonGotero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonGotero.setMaximumSize(new java.awt.Dimension(40, 40));
        botonGotero.setMinimumSize(new java.awt.Dimension(40, 40));
        botonGotero.setPreferredSize(new java.awt.Dimension(40, 40));
        botonGotero.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonGotero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGoteroActionPerformed(evt);
            }
        });
        jToolBarPincelYHerramientas.add(botonGotero);

        buttonGroupPanel.add(botonLupa);
        botonLupa.setForeground(new java.awt.Color(51, 51, 255));
        botonLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/loupe.png"))); // NOI18N
        botonLupa.setToolTipText("Lupa");
        botonLupa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonLupa.setMaximumSize(new java.awt.Dimension(40, 40));
        botonLupa.setMinimumSize(new java.awt.Dimension(40, 40));
        botonLupa.setPreferredSize(new java.awt.Dimension(40, 40));
        botonLupa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonLupa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLupaActionPerformed(evt);
            }
        });
        jToolBarPincelYHerramientas.add(botonLupa);

        jPanelDeHerramientas.add(jToolBarPincelYHerramientas);

        jToolBarColores.setBorder(null);
        jToolBarColores.setRollover(true);
        jToolBarColores.setBorderPainted(false);
        jToolBarColores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jToolBarColores.setName("Colores"); // NOI18N

        jPanelSeparador3.setPreferredSize(new java.awt.Dimension(3, 46));

        javax.swing.GroupLayout jPanelSeparador3Layout = new javax.swing.GroupLayout(jPanelSeparador3);
        jPanelSeparador3.setLayout(jPanelSeparador3Layout);
        jPanelSeparador3Layout.setHorizontalGroup(
            jPanelSeparador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanelSeparador3Layout.setVerticalGroup(
            jPanelSeparador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jToolBarColores.add(jPanelSeparador3);

        jPanelColorPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        jPanelColorPrincipal.setToolTipText("Color Principal");
        jPanelColorPrincipal.setMaximumSize(new java.awt.Dimension(40, 40));
        jPanelColorPrincipal.setMinimumSize(new java.awt.Dimension(40, 40));
        jPanelColorPrincipal.setPreferredSize(new java.awt.Dimension(40, 40));
        jPanelColorPrincipal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanelColorPrincipalPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanelColorPrincipalLayout = new javax.swing.GroupLayout(jPanelColorPrincipal);
        jPanelColorPrincipal.setLayout(jPanelColorPrincipalLayout);
        jPanelColorPrincipalLayout.setHorizontalGroup(
            jPanelColorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanelColorPrincipalLayout.setVerticalGroup(
            jPanelColorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jToolBarColores.add(jPanelColorPrincipal);

        jPanelSeparador4.setPreferredSize(new java.awt.Dimension(3, 40));

        javax.swing.GroupLayout jPanelSeparador4Layout = new javax.swing.GroupLayout(jPanelSeparador4);
        jPanelSeparador4.setLayout(jPanelSeparador4Layout);
        jPanelSeparador4Layout.setHorizontalGroup(
            jPanelSeparador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanelSeparador4Layout.setVerticalGroup(
            jPanelSeparador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jToolBarColores.add(jPanelSeparador4);

        jPanelColorSecundario.setBackground(new java.awt.Color(255, 255, 255));
        jPanelColorSecundario.setToolTipText("Color secundario");
        jPanelColorSecundario.setMinimumSize(new java.awt.Dimension(40, 40));
        jPanelColorSecundario.setPreferredSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout jPanelColorSecundarioLayout = new javax.swing.GroupLayout(jPanelColorSecundario);
        jPanelColorSecundario.setLayout(jPanelColorSecundarioLayout);
        jPanelColorSecundarioLayout.setHorizontalGroup(
            jPanelColorSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanelColorSecundarioLayout.setVerticalGroup(
            jPanelColorSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jToolBarColores.add(jPanelColorSecundario);

        jPanelSeparador5.setPreferredSize(new java.awt.Dimension(3, 46));

        javax.swing.GroupLayout jPanelSeparador5Layout = new javax.swing.GroupLayout(jPanelSeparador5);
        jPanelSeparador5.setLayout(jPanelSeparador5Layout);
        jPanelSeparador5Layout.setHorizontalGroup(
            jPanelSeparador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanelSeparador5Layout.setVerticalGroup(
            jPanelSeparador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jToolBarColores.add(jPanelSeparador5);

        jPanelContenedorColores.setBackground(new java.awt.Color(100, 100, 100));

        jPanelBarraColores.setToolTipText("Paleta de colores");
        jPanelBarraColores.setMaximumSize(new java.awt.Dimension(200, 20));
        jPanelBarraColores.setMinimumSize(new java.awt.Dimension(200, 20));
        jPanelBarraColores.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanelBarraColores.setLayout(new java.awt.GridLayout(2, 0, 2, 2));

        javax.swing.GroupLayout jPanelContenedorColoresLayout = new javax.swing.GroupLayout(jPanelContenedorColores);
        jPanelContenedorColores.setLayout(jPanelContenedorColoresLayout);
        jPanelContenedorColoresLayout.setHorizontalGroup(
            jPanelContenedorColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanelBarraColores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelContenedorColoresLayout.setVerticalGroup(
            jPanelContenedorColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBarraColores, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jToolBarColores.add(jPanelContenedorColores);

        buttonGroupPanel.add(botonColor);
        botonColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/a7e7090593f500c_resized.png"))); // NOI18N
        botonColor.setToolTipText("Seleccionar Color");
        botonColor.setBorderPainted(false);
        botonColor.setFocusable(false);
        botonColor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonColor.setMargin(new java.awt.Insets(0, 0, 0, 0));
        botonColor.setMaximumSize(new java.awt.Dimension(40, 40));
        botonColor.setMinimumSize(new java.awt.Dimension(40, 40));
        botonColor.setPreferredSize(new java.awt.Dimension(42, 42));
        botonColor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonColorMouseClicked(evt);
            }
        });
        jToolBarColores.add(botonColor);

        jPanelDeHerramientas.add(jToolBarColores);

        jToolBarFiguras.setRollover(true);
        jToolBarFiguras.setBorderPainted(false);

        buttonGroupPanel.add(botonLinea);
        botonLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/remove.png"))); // NOI18N
        botonLinea.setToolTipText("Linea");
        botonLinea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonLinea.setMaximumSize(new java.awt.Dimension(40, 40));
        botonLinea.setMinimumSize(new java.awt.Dimension(40, 40));
        botonLinea.setPreferredSize(new java.awt.Dimension(40, 40));
        botonLinea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLineaActionPerformed(evt);
            }
        });
        jToolBarFiguras.add(botonLinea);

        buttonGroupPanel.add(botonTriangulo);
        botonTriangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/triangle.png"))); // NOI18N
        botonTriangulo.setToolTipText("Triangulo");
        botonTriangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonTriangulo.setMaximumSize(new java.awt.Dimension(40, 40));
        botonTriangulo.setMinimumSize(new java.awt.Dimension(40, 40));
        botonTriangulo.setPreferredSize(new java.awt.Dimension(40, 40));
        botonTriangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonTriangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTrianguloActionPerformed(evt);
            }
        });
        jToolBarFiguras.add(botonTriangulo);

        buttonGroupPanel.add(botonRectangulo);
        botonRectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/rectangle.png"))); // NOI18N
        botonRectangulo.setToolTipText("Rectangulo");
        botonRectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonRectangulo.setMaximumSize(new java.awt.Dimension(40, 40));
        botonRectangulo.setMinimumSize(new java.awt.Dimension(40, 40));
        botonRectangulo.setPreferredSize(new java.awt.Dimension(40, 40));
        botonRectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonRectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRectanguloActionPerformed(evt);
            }
        });
        jToolBarFiguras.add(botonRectangulo);

        buttonGroupPanel.add(botonOvalo);
        botonOvalo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ellipse-outline-shape-variant.png"))); // NOI18N
        botonOvalo.setToolTipText("Ovalo");
        botonOvalo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonOvalo.setMaximumSize(new java.awt.Dimension(40, 40));
        botonOvalo.setMinimumSize(new java.awt.Dimension(40, 40));
        botonOvalo.setPreferredSize(new java.awt.Dimension(40, 40));
        botonOvalo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonOvalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOvaloActionPerformed(evt);
            }
        });
        jToolBarFiguras.add(botonOvalo);

        jPanel2.setPreferredSize(new java.awt.Dimension(3, 42));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        jToolBarFiguras.add(jPanel2);

        jCheckBoxRellenar.setText("Rellenar");
        jCheckBoxRellenar.setFocusable(false);
        jCheckBoxRellenar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jCheckBoxRellenar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jCheckBoxRellenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRellenarActionPerformed(evt);
            }
        });
        jToolBarFiguras.add(jCheckBoxRellenar);

        jPanel1.setPreferredSize(new java.awt.Dimension(5, 42));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        jToolBarFiguras.add(jPanel1);

        jCheckBoxSimétrico.setText("Simétrico");
        jCheckBoxSimétrico.setFocusable(false);
        jCheckBoxSimétrico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jCheckBoxSimétrico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jCheckBoxSimétrico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSimétricoActionPerformed(evt);
            }
        });
        jToolBarFiguras.add(jCheckBoxSimétrico);

        jPanelDeHerramientas.add(jToolBarFiguras);

        getContentPane().add(jPanelDeHerramientas, java.awt.BorderLayout.PAGE_START);

        areaDibujoPanel.setRequestFocusEnabled(false);

        javax.swing.GroupLayout areaDibujoPanelLayout = new javax.swing.GroupLayout(areaDibujoPanel);
        areaDibujoPanel.setLayout(areaDibujoPanelLayout);
        areaDibujoPanelLayout.setHorizontalGroup(
            areaDibujoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1463, Short.MAX_VALUE)
        );
        areaDibujoPanelLayout.setVerticalGroup(
            areaDibujoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        jScrollPanelAreaDibujo.setViewportView(areaDibujoPanel);

        getContentPane().add(jScrollPanelAreaDibujo, java.awt.BorderLayout.CENTER);
        //areaDibujo.setLayout(null);
        //areaDibujo.setViewportView(lienzo);

        jPanelInformacion.setPreferredSize(new java.awt.Dimension(789, 30));

        propiedadesDatos.setMaximumSize(new java.awt.Dimension(334, 30));
        propiedadesDatos.setMinimumSize(new java.awt.Dimension(334, 30));

        coordenadaText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        coordenadaText.setText("Coordenada");

        resolucionText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        resolucionText.setText("Resolucion");

        javax.swing.GroupLayout propiedadesDatosLayout = new javax.swing.GroupLayout(propiedadesDatos);
        propiedadesDatos.setLayout(propiedadesDatosLayout);
        propiedadesDatosLayout.setHorizontalGroup(
            propiedadesDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(propiedadesDatosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(coordenadaText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resolucionText)
                .addGap(73, 73, 73))
        );
        propiedadesDatosLayout.setVerticalGroup(
            propiedadesDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(propiedadesDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(coordenadaText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resolucionText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout propiedadesLayout = new javax.swing.GroupLayout(propiedades);
        propiedades.setLayout(propiedadesLayout);
        propiedadesLayout.setHorizontalGroup(
            propiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(propiedadesDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        propiedadesLayout.setVerticalGroup(
            propiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(propiedadesDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        zoomAjuste.setPreferredSize(new java.awt.Dimension(150, 30));
        zoomAjuste.setLayout(new javax.swing.BoxLayout(zoomAjuste, javax.swing.BoxLayout.LINE_AXIS));

        zoomTexto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        zoomTexto.setText("Zoom  ");
        zoomAjuste.add(zoomTexto);

        zoomValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        zoomValor.setText("100%");
        zoomAjuste.add(zoomValor);

        reducirZoom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reducirZoom.setText("-");
        reducirZoom.setBorderPainted(false);
        reducirZoom.setContentAreaFilled(false);
        reducirZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reducirZoomActionPerformed(evt);
            }
        });
        zoomAjuste.add(reducirZoom);

        jSliderZoom.setMaximum(10);
        jSliderZoom.setMinimum(1);
        jSliderZoom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderZoomStateChanged(evt);
            }
        });
        zoomAjuste.add(jSliderZoom);

        aumentarZoom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        aumentarZoom.setText("+");
        aumentarZoom.setBorderPainted(false);
        aumentarZoom.setContentAreaFilled(false);
        aumentarZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aumentarZoomActionPerformed(evt);
            }
        });
        zoomAjuste.add(aumentarZoom);

        javax.swing.GroupLayout zoomLayout = new javax.swing.GroupLayout(zoom);
        zoom.setLayout(zoomLayout);
        zoomLayout.setHorizontalGroup(
            zoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
            .addGroup(zoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zoomLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(zoomAjuste, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        zoomLayout.setVerticalGroup(
            zoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(zoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(zoomLayout.createSequentialGroup()
                    .addComponent(zoomAjuste, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanelInformacionLayout = new javax.swing.GroupLayout(jPanelInformacion);
        jPanelInformacion.setLayout(jPanelInformacionLayout);
        jPanelInformacionLayout.setHorizontalGroup(
            jPanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacionLayout.createSequentialGroup()
                .addComponent(propiedades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addComponent(zoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelInformacionLayout.setVerticalGroup(
            jPanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacionLayout.createSequentialGroup()
                .addGroup(jPanelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(propiedades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanelInformacion, java.awt.BorderLayout.PAGE_END);

        jMenuItemArchivo.setText("Archivo");

        jMenuItemNuevo.setText("Nuevo");
        jMenuItemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuevoActionPerformed(evt);
            }
        });
        jMenuItemArchivo.add(jMenuItemNuevo);

        jMenuItemAbrir.setText("Abrir");
        jMenuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirActionPerformed(evt);
            }
        });
        jMenuItemArchivo.add(jMenuItemAbrir);

        jMenuItemGuardar.setText("Guardar");
        jMenuItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardarActionPerformed(evt);
            }
        });
        jMenuItemArchivo.add(jMenuItemGuardar);

        jMenuItemGuardarComo.setText("Guardar como...");

        jImagenPNG.setText("Imagen PNG");
        jImagenPNG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jImagenPNGActionPerformed(evt);
            }
        });
        jMenuItemGuardarComo.add(jImagenPNG);

        jImagenJPG.setText("Imegen JPG");
        jImagenJPG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jImagenJPGActionPerformed(evt);
            }
        });
        jMenuItemGuardarComo.add(jImagenJPG);

        jMenuItemArchivo.add(jMenuItemGuardarComo);

        jMenuItemImprimir.setText("Imprimir");
        jMenuItemImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImprimirActionPerformed(evt);
            }
        });
        jMenuItemArchivo.add(jMenuItemImprimir);

        jMenuGeneral.add(jMenuItemArchivo);

        jMenuItemEditar.setText("Editar");

        jMenuItemCambiarTamano.setText("Cambiar tamaño");
        jMenuItemCambiarTamano.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemCambiarTamanoMousePressed(evt);
            }
        });
        jMenuItemEditar.add(jMenuItemCambiarTamano);

        jMenuItemCortar.setText("Cortar");
        jMenuItemEditar.add(jMenuItemCortar);

        jMenuItemCopiar.setText("Copiar");
        jMenuItemEditar.add(jMenuItemCopiar);

        jjMenuItemPegar.setText("Pegar");
        jMenuItemEditar.add(jjMenuItemPegar);

        jMenuGeneral.add(jMenuItemEditar);

        jMenuItemDeshacer.setText("🢀");
        jMenuItemDeshacer.setToolTipText("Deshacer");
        jMenuItemDeshacer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemDeshacerMousePressed(evt);
            }
        });
        jMenuGeneral.add(jMenuItemDeshacer);
        jMenuItemDeshacer.getAccessibleContext().setAccessibleDescription("");

        jMenuItemRehacer.setText("🢂");
        jMenuItemRehacer.setToolTipText("Rehacer");
        jMenuItemRehacer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemRehacerMousePressed(evt);
            }
        });
        jMenuGeneral.add(jMenuItemRehacer);

        menuAyuda.setText("Ayuda");

        menuItemTemasDeAyuda.setText("Temas de Ayuda");
        menuItemTemasDeAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTemasDeAyudaActionPerformed(evt);
            }
        });
        menuAyuda.add(menuItemTemasDeAyuda);

        menuItemAcercaDe.setText("Acerca de");
        menuItemAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAcercaDeActionPerformed(evt);
            }
        });
        menuAyuda.add(menuItemAcercaDe);

        jMenuGeneral.add(menuAyuda);

        setJMenuBar(jMenuGeneral);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCambiarTamanoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemCambiarTamanoMousePressed
        redimensionarLienzo();
    }//GEN-LAST:event_jMenuItemCambiarTamanoMousePressed

    private void jMenuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardarActionPerformed
        // TODO add your handling code here:
        panelDeDibujo.guardarImagen("PNG");
        this.setTitle(titulo);
    }//GEN-LAST:event_jMenuItemGuardarActionPerformed

    private void jMenuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirActionPerformed
        // TODO add your handling code here:
        panelDeDibujo.cargarImagen();
    }//GEN-LAST:event_jMenuItemAbrirActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        //Verifica si esta precionado Ctrl + Z presionado y Ctrl + Y presionado
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_Z) {
            // Ctrl + Z presionado
            jMenuItemDeshacerMousePressed(null); // Llama al método de deshacer
        } else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_Y) {
            // Ctrl + Y presionado
            jMenuItemRehacerMousePressed(null); // Llama al método de rehacer
        }
    }//GEN-LAST:event_formKeyPressed

    private void jImagenPNGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jImagenPNGActionPerformed
        // TODO add your handling code here:
        panelDeDibujo.guardarImagen("PNG");
        this.setTitle(titulo);
    }//GEN-LAST:event_jImagenPNGActionPerformed

    private void jImagenJPGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jImagenJPGActionPerformed
        // TODO add your handling code here:
        panelDeDibujo.guardarImagen("JPG");
        this.setTitle(titulo);
    }//GEN-LAST:event_jImagenJPGActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        boolean SeleccionDeAvisoDeGuardado = true;
        if (panelDeDibujo.cargadaImage != null && !panelDeDibujo.listaFiguras.isEmpty()) {
            SeleccionDeAvisoDeGuardado = panelDeDibujo.avisoDeGuardado();
        } else {
            panelDeDibujo.guardarDibujoTemporal();
        }
        if (SeleccionDeAvisoDeGuardado == false) {
            setDefaultCloseOperation(VentanaPrincipal.DO_NOTHING_ON_CLOSE);// El programa permanecera abierto cuando el usuario presiona cancelar
        } else {
            setDefaultCloseOperation(VentanaPrincipal.EXIT_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        panelDeDibujo.cargarDibujoTemporal();
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNuevoActionPerformed
        if (!panelDeDibujo.listaFiguras.isEmpty()) {
            panelDeDibujo.avisoDeGuardado();
        } else {
            panelDeDibujo.cargadaImage = null; // eliminara la imagen si ha sido cargada en jpanel
            repaint();
        }
        this.setTitle(titulo); // Retornara el nombre del programa sin el estado (Sin Guardar)
    }//GEN-LAST:event_jMenuItemNuevoActionPerformed

    private void jMenuItemImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImprimirActionPerformed
        panelDeDibujo.imprimirImigen();
    }//GEN-LAST:event_jMenuItemImprimirActionPerformed

    private void jSliderZoomStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderZoomStateChanged
        // TODO add your handling code here:
        int value = jSliderZoom.getValue();
        float nuevaEscala = value / 10.0f;
        panelDeDibujo.setEscala(nuevaEscala);

    }//GEN-LAST:event_jSliderZoomStateChanged

    private void jMenuItemDeshacerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemDeshacerMousePressed
        //limita la cantidad de figura se puede Deshacer y Rehacer
        panelDeDibujo.deshacer();
        repaint();
    }//GEN-LAST:event_jMenuItemDeshacerMousePressed

    private void jMenuItemRehacerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemRehacerMousePressed
        panelDeDibujo.rehacer();
        repaint();
    }//GEN-LAST:event_jMenuItemRehacerMousePressed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        //Cuando la ventana pierda el Focus lo recuperar nuevamente para que pueda recibir eventos de teclado
        setFocusable(true);
        requestFocusInWindow();
        if (!panelDeDibujo.listaFiguras.isEmpty()) {
            this.setTitle(titulo + " - Sin Guardar");
        }
    }//GEN-LAST:event_formFocusLost

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        if (!panelDeDibujo.listaFiguras.isEmpty()) {
            this.setTitle(titulo + " - Sin Guardar");
        }
    }//GEN-LAST:event_formFocusGained

    private void botonOvaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOvaloActionPerformed
        panelDeDibujo.figuraSeleccionada = "Ovalo";
        cursorRetorno();
    }//GEN-LAST:event_botonOvaloActionPerformed

    private void botonRectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRectanguloActionPerformed
        panelDeDibujo.figuraSeleccionada = "Rectangulo";
        cursorRetorno();
    }//GEN-LAST:event_botonRectanguloActionPerformed

    private void botonTrianguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTrianguloActionPerformed
        panelDeDibujo.figuraSeleccionada = "Triangulo";
        cursorRetorno();
    }//GEN-LAST:event_botonTrianguloActionPerformed

    private void botonLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLineaActionPerformed
        panelDeDibujo.figuraSeleccionada = "Linea";
        cursorRetorno();
//        CursorFiguraLinea();
    }//GEN-LAST:event_botonLineaActionPerformed

    private void botonColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonColorMouseClicked
        Color color = JColorChooser.showDialog(null, "Color", Color.GRAY);
        jPanelColorPrincipal.setBackground(color);
    }//GEN-LAST:event_botonColorMouseClicked

    private void botonBaldeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBaldeActionPerformed
        panelDeDibujo.figuraSeleccionada = "Balde";
        CursorBaldeDePintura();
    }//GEN-LAST:event_botonBaldeActionPerformed

    private void botonLupaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLupaActionPerformed
        // TODO add your handling code here:
        System.out.println("Lupa");
        panelDeDibujo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    panelDeDibujo.zoomAcercar();
                    actualizarSlider();
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    panelDeDibujo.zoomAlejar();
                    actualizarSlider();
                }
                CursorLupa();
            }
        });
    }//GEN-LAST:event_botonLupaActionPerformed

    private void botonGoteroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGoteroActionPerformed

        if (botonGotero.isSelected()) {
            // Activar la captura del color al hacer clic
            panelDeDibujo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Obtener el color del pixel en las coordenadas del mouse
                    panelDeDibujo.colorDePrimerPlano = panelDeDibujo.getColorAtMouseLocation(panelDeDibujo, e.getPoint());
                    //panelDeDibujo.colorDePrimerPlano = JColorChooser.showDialog(panelDeDibujo, "Colores", panelDeDibujo.colorDePrimerPlano);
                    panelDeDibujo.figuraSeleccionada = "Balde";
                    botonBalde.setSelected(true);
                }
            });
        } else {
            // Desactivar la captura del color al hacer clic
            panelDeDibujo.removeMouseListener(panelDeDibujo.getMouseListeners()[0]);
        }
        CursorGotero();
    }//GEN-LAST:event_botonGoteroActionPerformed

    private void botonBorradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorradorActionPerformed
        
        panelDeDibujo.figuraSeleccionada = "Borrador";
        //Futura Implementacion de cambio de icono
        /*      Image imagen = new ImageIcon(getClass().getResource("/Icons/Borra.png")).getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(imagenRedimensionada, new Point(0,32),"Borra");
        setCursor(cursor);*/
        CursorBorrador();
    }//GEN-LAST:event_botonBorradorActionPerformed

    private void botonPincelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPincelActionPerformed
        if (botonPincel.isSelected()) {
            panelDeDibujo.figuraSeleccionada = "DibujoLibre";
            CursorPincel();
        }
    }//GEN-LAST:event_botonPincelActionPerformed

    private void reducirZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reducirZoomActionPerformed
        // TODO add your handling code here:
        panelDeDibujo.zoomAlejar();
        actualizarSlider();
    }//GEN-LAST:event_reducirZoomActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

    private void aumentarZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aumentarZoomActionPerformed
        // TODO add your handling code here:
        panelDeDibujo.zoomAcercar();
        actualizarSlider();
    }//GEN-LAST:event_aumentarZoomActionPerformed

    private void jSliderTamañoPincelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderTamañoPincelStateChanged
        // TODO add your handling code here:
        textoPincel.setText("Tamaño " + String.valueOf(jSliderTamañoPincel.getValue()));
        panelDeDibujo.grosorFigura = jSliderTamañoPincel.getValue();
    }//GEN-LAST:event_jSliderTamañoPincelStateChanged

    private void jPanelColorPrincipalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelColorPrincipalPropertyChange
        // TODO add your handling code here:
        if (panelDeDibujo != null) {
            panelDeDibujo.colorDePrimerPlano = jPanelColorPrincipal.getBackground();
            panelDeDibujo.colorDeSegundoPlano = jPanelColorSecundario.getBackground();
        }
    }//GEN-LAST:event_jPanelColorPrincipalPropertyChange

    private void menuItemTemasDeAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTemasDeAyudaActionPerformed
        VentanaDeAyuda.obtenerInstancia(this).setVisible(true);
    }//GEN-LAST:event_menuItemTemasDeAyudaActionPerformed

    private void jCheckBoxRellenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRellenarActionPerformed
        // TODO add your handling code here:
        if (panelDeDibujo.rellenarFigura) {
            panelDeDibujo.rellenarFigura = false;
        } else if (!panelDeDibujo.rellenarFigura) {
            panelDeDibujo.rellenarFigura = true;
        }
    }//GEN-LAST:event_jCheckBoxRellenarActionPerformed

    private void jCheckBoxSimétricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSimétricoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxSimétricoActionPerformed

    private void menuItemAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAcercaDeActionPerformed
        AcercaDe ver= new AcercaDe();
        ver.setVisible(true);
    }//GEN-LAST:event_menuItemAcercaDeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaDibujoPanel;
    private javax.swing.JButton aumentarZoom;
    private javax.swing.JToggleButton botonBalde;
    private javax.swing.JToggleButton botonBorrador;
    private javax.swing.JToggleButton botonColor;
    private javax.swing.JToggleButton botonGotero;
    private javax.swing.JToggleButton botonLinea;
    private javax.swing.JToggleButton botonLupa;
    private javax.swing.JToggleButton botonOvalo;
    private javax.swing.JToggleButton botonPincel;
    private javax.swing.JToggleButton botonRectangulo;
    private javax.swing.JToggleButton botonTriangulo;
    private javax.swing.ButtonGroup buttonGroupPanel;
    private javax.swing.JLabel coordenadaText;
    private javax.swing.JCheckBox jCheckBoxRellenar;
    private javax.swing.JCheckBox jCheckBoxSimétrico;
    private javax.swing.JMenuItem jImagenJPG;
    private javax.swing.JMenuItem jImagenPNG;
    private javax.swing.JMenuBar jMenuGeneral;
    private javax.swing.JMenuItem jMenuItemAbrir;
    private javax.swing.JMenu jMenuItemArchivo;
    private javax.swing.JMenuItem jMenuItemCambiarTamano;
    private javax.swing.JMenuItem jMenuItemCopiar;
    private javax.swing.JMenuItem jMenuItemCortar;
    private javax.swing.JMenu jMenuItemDeshacer;
    private javax.swing.JMenu jMenuItemEditar;
    private javax.swing.JMenuItem jMenuItemGuardar;
    private javax.swing.JMenu jMenuItemGuardarComo;
    private javax.swing.JMenuItem jMenuItemImprimir;
    private javax.swing.JMenuItem jMenuItemNuevo;
    private javax.swing.JMenu jMenuItemRehacer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelBarraColores;
    private javax.swing.JPanel jPanelColorPrincipal;
    private javax.swing.JPanel jPanelColorSecundario;
    private javax.swing.JPanel jPanelContenedorColores;
    private javax.swing.JPanel jPanelDeHerramientas;
    private javax.swing.JPanel jPanelInformacion;
    private javax.swing.JPanel jPanelSeparador;
    private javax.swing.JPanel jPanelSeparador2;
    private javax.swing.JPanel jPanelSeparador3;
    private javax.swing.JPanel jPanelSeparador4;
    private javax.swing.JPanel jPanelSeparador5;
    private javax.swing.JPanel jPanelTamañoPincel;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPanelAreaDibujo;
    private javax.swing.JSlider jSliderTamañoPincel;
    private javax.swing.JSlider jSliderZoom;
    private javax.swing.JToolBar jToolBarColores;
    private javax.swing.JToolBar jToolBarFiguras;
    private javax.swing.JToolBar jToolBarPincelYHerramientas;
    private javax.swing.JMenuItem jjMenuItemPegar;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenuItem menuItemAcercaDe;
    private javax.swing.JMenuItem menuItemTemasDeAyuda;
    private javax.swing.JPanel propiedades;
    private javax.swing.JPanel propiedadesDatos;
    private javax.swing.JButton reducirZoom;
    private javax.swing.JLabel resolucionText;
    private javax.swing.JLabel textoPincel;
    private javax.swing.JPanel zoom;
    private javax.swing.JPanel zoomAjuste;
    private javax.swing.JLabel zoomTexto;
    private javax.swing.JLabel zoomValor;
    // End of variables declaration//GEN-END:variables
}
