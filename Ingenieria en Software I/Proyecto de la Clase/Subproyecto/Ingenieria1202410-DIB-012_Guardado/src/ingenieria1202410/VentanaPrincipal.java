/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ingenieria1202410;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.Box;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author josearielpereyra
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private PanelDeDibujo panelDeDibujo;
    private final String titulo = "Dibujador";

    public VentanaPrincipal() {
        initComponents();
        this.setSize(800, 600);

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
        grosorPincel.setValue(1);
       
        // La ventana pueda recibir eventos de teclado
        setFocusable(true);
        requestFocus();
    }


    private void redimencionarLienzo() {
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
        jPanelDeHerramientas = new javax.swing.JPanel();
        botonPincel = new javax.swing.JToggleButton();
        botonCuadrado = new javax.swing.JToggleButton();
        botonBorrador = new javax.swing.JToggleButton();
        botonSelector = new javax.swing.JToggleButton();
        botonRectangulo = new javax.swing.JToggleButton();
        botonTriangulo = new javax.swing.JToggleButton();
        botonLupa = new javax.swing.JToggleButton();
        botonLinea = new javax.swing.JToggleButton();
        botonValde = new javax.swing.JToggleButton();
        botonColor = new javax.swing.JToggleButton();
        botonOvalo = new javax.swing.JToggleButton();
        grosorPincel = new javax.swing.JSlider();
        jTextoPincel = new javax.swing.JLabel();
        areaDibujo = new javax.swing.JScrollPane();
        areaDibujoPanel = new javax.swing.JPanel();
        jMenuGeneral = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jNuevo = new javax.swing.JMenuItem();
        jAbrir = new javax.swing.JMenuItem();
        jGuardar = new javax.swing.JMenuItem();
        jGuardarComo = new javax.swing.JMenu();
        jImagenPNG = new javax.swing.JMenuItem();
        jImagenJPG = new javax.swing.JMenuItem();
        jImprimir = new javax.swing.JMenuItem();
        jEditar = new javax.swing.JMenu();
        jCambiarTamano = new javax.swing.JMenuItem();
        jCortar = new javax.swing.JMenuItem();
        jCopiar = new javax.swing.JMenuItem();
        jPegar = new javax.swing.JMenuItem();
        jDeshacer = new javax.swing.JMenu();
        jRehacer = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
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
        jPanelDeHerramientas.setMaximumSize(new java.awt.Dimension(240, 56));
        jPanelDeHerramientas.setName("Herramientas"); // NOI18N

        buttonGroupPanel.add(botonPincel);
        botonPincel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/brush.png"))); // NOI18N
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

        buttonGroupPanel.add(botonCuadrado);
        botonCuadrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/stop-button.png"))); // NOI18N
        botonCuadrado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCuadrado.setMaximumSize(new java.awt.Dimension(40, 40));
        botonCuadrado.setMinimumSize(new java.awt.Dimension(40, 40));
        botonCuadrado.setPreferredSize(new java.awt.Dimension(40, 40));
        botonCuadrado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCuadrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCuadradoActionPerformed(evt);
            }
        });

        buttonGroupPanel.add(botonBorrador);
        botonBorrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eraser.png"))); // NOI18N
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

        buttonGroupPanel.add(botonSelector);
        botonSelector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/color-selector.png"))); // NOI18N
        botonSelector.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonSelector.setMaximumSize(new java.awt.Dimension(40, 40));
        botonSelector.setMinimumSize(new java.awt.Dimension(40, 40));
        botonSelector.setPreferredSize(new java.awt.Dimension(40, 40));
        botonSelector.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSelectorActionPerformed(evt);
            }
        });

        buttonGroupPanel.add(botonRectangulo);
        botonRectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/rectangle.png"))); // NOI18N
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

        buttonGroupPanel.add(botonTriangulo);
        botonTriangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/triangle.png"))); // NOI18N
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

        buttonGroupPanel.add(botonLupa);
        botonLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/loupe.png"))); // NOI18N
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

        buttonGroupPanel.add(botonLinea);
        botonLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/remove.png"))); // NOI18N
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

        buttonGroupPanel.add(botonValde);
        botonValde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/paint-bucket.png"))); // NOI18N
        botonValde.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonValde.setMaximumSize(new java.awt.Dimension(40, 40));
        botonValde.setMinimumSize(new java.awt.Dimension(40, 40));
        botonValde.setPreferredSize(new java.awt.Dimension(40, 40));
        botonValde.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonValde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonValdeActionPerformed(evt);
            }
        });

        botonColor.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroupPanel.add(botonColor);
        botonColor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonColor.setMaximumSize(new java.awt.Dimension(40, 40));
        botonColor.setMinimumSize(new java.awt.Dimension(40, 40));
        botonColor.setPreferredSize(new java.awt.Dimension(40, 40));
        botonColor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonColorMouseClicked(evt);
            }
        });
        botonColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColorActionPerformed(evt);
            }
        });

        buttonGroupPanel.add(botonOvalo);
        botonOvalo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ellipse-outline-shape-variant.png"))); // NOI18N
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

        grosorPincel.setMaximum(10);
        grosorPincel.setMinimum(1);
        grosorPincel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                grosorPincelStateChanged(evt);
            }
        });

        jTextoPincel.setText("Tamaño del pincel 1");

        javax.swing.GroupLayout jPanelDeHerramientasLayout = new javax.swing.GroupLayout(jPanelDeHerramientas);
        jPanelDeHerramientas.setLayout(jPanelDeHerramientasLayout);
        jPanelDeHerramientasLayout.setHorizontalGroup(
            jPanelDeHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeHerramientasLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(botonPincel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(botonBorrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(botonValde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(botonSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(botonLupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(botonColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(botonLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(botonCuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(botonTriangulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(botonRectangulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(botonOvalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelDeHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDeHerramientasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grosorPincel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDeHerramientasLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jTextoPincel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDeHerramientasLayout.setVerticalGroup(
            jPanelDeHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeHerramientasLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanelDeHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonPincel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBorrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonValde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonLupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonTriangulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRectangulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonOvalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDeHerramientasLayout.createSequentialGroup()
                .addComponent(jTextoPincel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grosorPincel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelDeHerramientas, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout areaDibujoPanelLayout = new javax.swing.GroupLayout(areaDibujoPanel);
        areaDibujoPanel.setLayout(areaDibujoPanelLayout);
        areaDibujoPanelLayout.setHorizontalGroup(
            areaDibujoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 787, Short.MAX_VALUE)
        );
        areaDibujoPanelLayout.setVerticalGroup(
            areaDibujoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        areaDibujo.setViewportView(areaDibujoPanel);

        getContentPane().add(areaDibujo, java.awt.BorderLayout.CENTER);
        //areaDibujo.setLayout(null);
        //areaDibujo.setViewportView(lienzo);

        jMenuArchivo.setText("Archivo");
        jMenuArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuArchivoMouseClicked(evt);
            }
        });
        jMenuArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArchivoActionPerformed(evt);
            }
        });

        jNuevo.setText("Nuevo");
        jNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNuevoActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jNuevo);

        jAbrir.setText("Abrir");
        jAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAbrirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jAbrir);

        jGuardar.setText("Guardar");
        jGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGuardarActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jGuardar);

        jGuardarComo.setText("Guardar como...");

        jImagenPNG.setText("Imagen PNG");
        jImagenPNG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jImagenPNGActionPerformed(evt);
            }
        });
        jGuardarComo.add(jImagenPNG);

        jImagenJPG.setText("Imegen JPG");
        jImagenJPG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jImagenJPGActionPerformed(evt);
            }
        });
        jGuardarComo.add(jImagenJPG);

        jMenuArchivo.add(jGuardarComo);

        jImprimir.setText("Imprimir");
        jImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jImprimirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jImprimir);

        jMenuGeneral.add(jMenuArchivo);

        jEditar.setText("Editar");

        jCambiarTamano.setText("Cambiar tamaño");
        jCambiarTamano.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCambiarTamanoMousePressed(evt);
            }
        });
        jEditar.add(jCambiarTamano);

        jCortar.setText("Cortar");
        jEditar.add(jCortar);

        jCopiar.setText("Copiar");
        jEditar.add(jCopiar);

        jPegar.setText("Pegar");
        jEditar.add(jPegar);

        jMenuGeneral.add(jEditar);

        jDeshacer.setText("🢀");
        jDeshacer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jDeshacerMousePressed(evt);
            }
        });
        jMenuGeneral.add(jDeshacer);
        jDeshacer.getAccessibleContext().setAccessibleDescription("");

        jRehacer.setText("🢂");
        jRehacer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jRehacerMousePressed(evt);
            }
        });
        jMenuGeneral.add(jRehacer);

        setJMenuBar(jMenuGeneral);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonSelectorActionPerformed

    private void botonValdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonValdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonValdeActionPerformed

    private void botonBorradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorradorActionPerformed
        // TODO add your handling code here:
        panelDeDibujo.figuraSeleccionada = "Borrador";
        //Futura Implementacion de cambio de icono
        /*      Image imagen = new ImageIcon(getClass().getResource("/Icons/Borra.png")).getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(imagenRedimensionada, new Point(0,32),"Borra");
        setCursor(cursor);*/
    }//GEN-LAST:event_botonBorradorActionPerformed

    private void botonPincelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPincelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonPincelActionPerformed

    private void botonCuadradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCuadradoActionPerformed
        // TODO add your handling code here:
        panelDeDibujo.figuraSeleccionada = "Rectangulo";
    }//GEN-LAST:event_botonCuadradoActionPerformed

    private void botonRectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRectanguloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonRectanguloActionPerformed

    private void botonTrianguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTrianguloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonTrianguloActionPerformed

    private void botonLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLineaActionPerformed
        // TODO add your handling code here:
        panelDeDibujo.figuraSeleccionada = "Linea";
    }//GEN-LAST:event_botonLineaActionPerformed

    private void botonLupaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLupaActionPerformed
        // TODO add your handling code here:
        System.out.println("lupa");
    }//GEN-LAST:event_botonLupaActionPerformed

    private void jMenuArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuArchivoActionPerformed

    private void jMenuArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuArchivoMouseClicked

    }//GEN-LAST:event_jMenuArchivoMouseClicked

    private void botonColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColorActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_botonColorActionPerformed

    private void botonColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonColorMouseClicked
        Color color = JColorChooser.showDialog(null, "Color", Color.GRAY);
        botonColor.setBackground(color);
        panelDeDibujo.colorDePrimerPlano = color;
    }//GEN-LAST:event_botonColorMouseClicked

    private void botonOvaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOvaloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonOvaloActionPerformed

    private void jCambiarTamanoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCambiarTamanoMousePressed
        redimencionarLienzo();
    }//GEN-LAST:event_jCambiarTamanoMousePressed

    private void jGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGuardarActionPerformed
        // TODO add your handling code here:
        panelDeDibujo.guardarImagen("PNG");
        this.setTitle(titulo);
    }//GEN-LAST:event_jGuardarActionPerformed

    private void jAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAbrirActionPerformed
        // TODO add your handling code here:
        panelDeDibujo.cargarImagen();
    }//GEN-LAST:event_jAbrirActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        //Verifica si esta precionado Ctrl + Z presionado y Ctrl + Y presionado
         if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_Z) {
                    // Ctrl + Z presionado
                    jDeshacerMousePressed(null); // Llama al método de deshacer
                } else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_Y) {
                    // Ctrl + Y presionado
                    jRehacerMousePressed(null); // Llama al método de rehacer
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
        // TODO add your handling code here:
        if (panelDeDibujo.cargadaImage != null && !panelDeDibujo.listaFiguras.isEmpty()) {
            int respuesta = JOptionPane.showConfirmDialog(this,
                    "¿Desea guardar los cambios en el dibujo sin título?", "Guardar Cambios",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (respuesta == JOptionPane.YES_OPTION) {
                panelDeDibujo.guardarImagen("PNG");
                dispose();
            } else if (respuesta == JOptionPane.NO_OPTION) {
                panelDeDibujo.listaFiguras.clear();
                panelDeDibujo.cargadaImage = null;
                panelDeDibujo.guardarDibujoTemporal();
            }

        } else {
            panelDeDibujo.guardarDibujoTemporal();
        }

    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        panelDeDibujo.cargarDibujoTemporal();
    }//GEN-LAST:event_formWindowOpened

    private void jNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNuevoActionPerformed
        // TODO add your handling code here:
        if (!panelDeDibujo.listaFiguras.isEmpty()) {
            int respuesta = JOptionPane.showConfirmDialog(this,
                    "¿Desea guardar los cambios en el dibujo sin título?", "Guardar Cambios",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (respuesta == JOptionPane.YES_OPTION) {
                panelDeDibujo.guardarImagen("PNG");
                dispose();
            } else if (respuesta == JOptionPane.NO_OPTION) {
                panelDeDibujo.listaFiguras.clear();
                panelDeDibujo.cargadaImage = null;
                panelDeDibujo.guardarDibujoTemporal();
            }

        } else {
            panelDeDibujo.cargadaImage = null;
            repaint();
        }
        this.setTitle(titulo);
    }//GEN-LAST:event_jNuevoActionPerformed

    private void jImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jImprimirActionPerformed
        // TODO add your handling code here:
        panelDeDibujo.imprimirImigen();
    }//GEN-LAST:event_jImprimirActionPerformed

    private void grosorPincelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_grosorPincelStateChanged
        // TODO add your handling code here:
        jTextoPincel.setText("Tamaño del pincel " + String.valueOf(grosorPincel.getValue()));
        panelDeDibujo.grosorFigura = grosorPincel.getValue();
    }//GEN-LAST:event_grosorPincelStateChanged

    private void jDeshacerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDeshacerMousePressed
        // TODO add your handling code here:
        //limita la cantidad de figura se puede Deshacer y Rehacer
        if (!panelDeDibujo.listaFiguras.isEmpty() && panelDeDibujo.almacenamientoFigura.size() < 50) {
            panelDeDibujo.almacenamientoFigura.add(panelDeDibujo.listaFiguras.getLast());
            panelDeDibujo.listaFiguras.removeLast();
            repaint();
        }
    }//GEN-LAST:event_jDeshacerMousePressed

    private void jRehacerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRehacerMousePressed
        // TODO add your handling code here:
        if (!panelDeDibujo.almacenamientoFigura.empty()) {
            panelDeDibujo.listaFiguras.add(panelDeDibujo.almacenamientoFigura.pop());
            repaint();
        }
    }//GEN-LAST:event_jRehacerMousePressed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        // TODO add your handling code here:
        //Cuando la ventana pierda el Focus lo recuperar nuevamente para que pueda recibir eventos de teclado
        setFocusable(true);
        requestFocus();
       if (!panelDeDibujo.listaFiguras.isEmpty()) {
            this.setTitle(titulo + " - Sin Guardar");
        }
    }//GEN-LAST:event_formFocusLost

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
         if (!panelDeDibujo.listaFiguras.isEmpty()) {
            this.setTitle(titulo + " - Sin Guardar");
        }
    }//GEN-LAST:event_formFocusGained

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JScrollPane areaDibujo;
    private javax.swing.JPanel areaDibujoPanel;
    private javax.swing.JToggleButton botonBorrador;
    private javax.swing.JToggleButton botonColor;
    private javax.swing.JToggleButton botonCuadrado;
    private javax.swing.JToggleButton botonLinea;
    private javax.swing.JToggleButton botonLupa;
    private javax.swing.JToggleButton botonOvalo;
    private javax.swing.JToggleButton botonPincel;
    private javax.swing.JToggleButton botonRectangulo;
    private javax.swing.JToggleButton botonSelector;
    private javax.swing.JToggleButton botonTriangulo;
    private javax.swing.JToggleButton botonValde;
    private javax.swing.ButtonGroup buttonGroupPanel;
    private javax.swing.JSlider grosorPincel;
    private javax.swing.JMenuItem jAbrir;
    private javax.swing.JMenuItem jCambiarTamano;
    private javax.swing.JMenuItem jCopiar;
    private javax.swing.JMenuItem jCortar;
    private javax.swing.JMenu jDeshacer;
    private javax.swing.JMenu jEditar;
    private javax.swing.JMenuItem jGuardar;
    private javax.swing.JMenu jGuardarComo;
    private javax.swing.JMenuItem jImagenJPG;
    private javax.swing.JMenuItem jImagenPNG;
    private javax.swing.JMenuItem jImprimir;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuBar jMenuGeneral;
    private javax.swing.JMenuItem jNuevo;
    private javax.swing.JPanel jPanelDeHerramientas;
    private javax.swing.JMenuItem jPegar;
    private javax.swing.JMenu jRehacer;
    private javax.swing.JLabel jTextoPincel;
    // End of variables declaration//GEN-END:variables
}