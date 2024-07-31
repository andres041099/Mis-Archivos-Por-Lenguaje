/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebaandres;

/**
 *
 * @author Usuario
 */
/**public class PruebaAndres {

    public static void main(String[] args) {
        int a= 3;
        int b= 2;
        int resultado= a+b;
                
        System.out.println("Hello World! "+"Your Result is: "+ resultado);
    }
}*/
/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PruebaAndres extends JFrame {

    public PruebaAndres() {
        // Configuración de la ventana
        setTitle("Programa de Dibujo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el panel de dibujo
        DibujoPanel dibujoPanel = new DibujoPanel();
        add(dibujoPanel);

        // Crear el menú
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu dibujoMenu = new JMenu("Dibujo");
        menuBar.add(dibujoMenu);

        JMenuItem lineaRectaItem = new JMenuItem("Dibujo Linea Recta");
        lineaRectaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dibujoPanel.dibujarLineaRecta();
            }
        });
        dibujoMenu.add(lineaRectaItem);

        JMenuItem dibujoLibreItem = new JMenuItem("Dibujo Libre");
        dibujoLibreItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dibujoPanel.dibujarLibre();
            }
        });
        dibujoMenu.add(dibujoLibreItem);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PruebaAndres().setVisible(true);
            }
        });
    }
}

class DibujoPanel extends JPanel {

    private int startX, startY, endX, endY;
    private boolean dibujoLibre = false;
    private Graphics2D g2d;

    public DibujoPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();

                if (dibujoLibre) {
                    dibujarLinea(g2d, startX, startY, endX, endY);
                }
                repaint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (!dibujoLibre) return;

                endX = e.getX();
                endY = e.getY();
                dibujarLinea(g2d, startX, startY, endX, endY);
                startX = endX;
                startY = endY;
                repaint();
            }
        });
    }

    public void dibujarLineaRecta() {
        dibujoLibre = false;
    }

    public void dibujarLibre() {
        dibujoLibre = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
    }

    private void dibujarLinea(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        g2d.drawLine(x1, y1, x2, y2);
    }
}*/

/*import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PruebaAndres extends JFrame {
    private int startX, startY, endX, endY;
    private Color currentColor = Color.RED;

    public PruebaAndres() {
        setTitle("Programa de Dibujo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu dibujoMenu = new JMenu("Dibujo");
        JMenuItem lineaRectaItem = new JMenuItem("Dibujo Linea Recta");
        JMenuItem dibujoLibreItem = new JMenuItem("Dibujo Libre");

        dibujoMenu.add(lineaRectaItem);
        dibujoMenu.add(dibujoLibreItem);
        menuBar.add(dibujoMenu);

        setJMenuBar(menuBar);

        lineaRectaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dibujarLineaRecta();
            }
        });

        dibujoLibreItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dibujoLibre();
            }
        });

        getContentPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }
        });

        getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();

                repaint();
            }
        });
    }

    private void dibujarLineaRecta() {
        // Código para dibujar línea recta
        Graphics g = getGraphics();
        g.setColor(currentColor);
        g.drawLine(startX, startY, endX, endY);
    }

    private void dibujoLibre() {
        // Código para dibujar libremente
        Graphics g = getGraphics();
        g.setColor(currentColor);
        g.drawLine(startX, startY, endX, endY);
        startX = endX;
        startY = endY;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PruebaAndres().setVisible(true);
            }
        });
    }
}*/

/*import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PruebaAndres extends JFrame {

    private enum ModoDibujo {
        LINEA_RECTA,
        DIBUJO_LIBRE
    }

    private ModoDibujo modoActual = ModoDibujo.LINEA_RECTA;
    private Point puntoInicio;

    public PruebaAndres() {
        setTitle("Programa de Dibujo");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuDibujo = new JMenu("Dibujo");
        JMenuItem dibujaLineaRecta = new JMenuItem("Dibuja Linea Recta");
        JMenuItem dibujaLibre = new JMenuItem("Dibuja Libre");

        dibujaLineaRecta.addActionListener(e -> cambiarModoDibujo(ModoDibujo.LINEA_RECTA));
        dibujaLibre.addActionListener(e -> cambiarModoDibujo(ModoDibujo.DIBUJO_LIBRE));

        menuDibujo.add(dibujaLineaRecta);
        menuDibujo.add(dibujaLibre);
        menuBar.add(menuDibujo);

        setJMenuBar(menuBar);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                puntoInicio = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                dibujar(e.getPoint());
            }
        });
    }

    private void cambiarModoDibujo(ModoDibujo nuevoModo) {
        modoActual = nuevoModo;
    }

    private void dibujar(Point puntoFinal) {
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);

        switch (modoActual) {
            case LINEA_RECTA:
                g.drawLine(puntoInicio.x, puntoInicio.y, puntoFinal.x, puntoFinal.y);
                puntoInicio = puntoFinal;
                break;
            case DIBUJO_LIBRE:
                g.drawLine(puntoInicio.x, puntoInicio.y, puntoFinal.x, puntoFinal.y);
                puntoInicio = puntoFinal;
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PruebaAndres app = new PruebaAndres();
            app.setVisible(true);
        });
    }
}*/
/*import javax.swing.*;
import java.awt.*;

class VentanaComun {
    private JFrame frame;
    private JButton boton;

    public VentanaComun() {
        frame = new JFrame("Ventana Común");
        boton = new JButton("Haz clic");

        // Configuración de la ventana
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Agregar componentes a la ventana
        frame.add(boton);

        // Asociar evento al botón
        boton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Hola desde la Ventana Común"));

        // Mostrar la ventana
        frame.setVisible(true);
    }
}

public class PruebaAndres {
    public static void main(String[] args) {
        // Crear dos instancias de la clase VentanaComun
        VentanaComun ventana1 = new VentanaComun();
        VentanaComun ventana2 = new VentanaComun();
    }
}*/
/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Diseño {
    // Clase para definir el diseño común
    public static void aplicarDiseño(Container container) {
        container.setLayout(new BorderLayout());
        JButton abrirVentanaBtn = new JButton("Abrir Ventana");
        container.add(abrirVentanaBtn, BorderLayout.CENTER);

        abrirVentanaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana ventana = new Ventana();
                ventana.mostrarVentana();
            }
        });
    }
}

class Ventana {
    // Clase para la ventana con su propio JPanel
    private JFrame frame;
    private JPanel panel;

    public Ventana() {
        frame = new JFrame("Ventana");
        panel = new JPanel();

        // Configurar la ventana
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Agregar diseño al panel de esta ventana
        Diseño.aplicarDiseño(panel);

        // Agregar panel a la ventana
        frame.add(panel);
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}

public class PruebaAndres {
    // Clase principal con su propio JPanel
    private JFrame frame;
    private JPanel panel;

    public PruebaAndres() {
        frame = new JFrame("Prueba Andrés");
        panel = new JPanel();

        // Configurar la ventana
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Agregar diseño al panel de esta ventana
        Diseño.aplicarDiseño(panel);

        // Agregar panel a la ventana
        frame.add(panel);
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Crear instancia de la clase PruebaAndres y mostrar la ventana
        PruebaAndres pruebaAndres = new PruebaAndres();
        pruebaAndres.mostrarVentana();
    }
}*/



/*//rectangulo

class Rectangulo {
    private Point puntoInicial;
    private Point puntoFinal;

    public Rectangulo(Point puntoInicial) {
        this.puntoInicial = puntoInicial;
    }

    public void actualizar(Point puntoFinal) {
        this.puntoFinal = puntoFinal;
    }

    public void dibujar(Graphics g) {
        int x = Math.min(puntoInicial.x, puntoFinal.x);
        int y = Math.min(puntoInicial.y, puntoFinal.y);
        int ancho = Math.abs(puntoInicial.x - puntoFinal.x);
        int altura = Math.abs(puntoInicial.y - puntoFinal.y);

        g.setColor(Color.BLUE);
        g.drawRect(x, y, ancho, altura);
    }
}*/





/*//otra clase
Linea miLinea;
    private Rectangulo miRectangulo;
    private ArrayList<Rectangulo> rectangulos = new ArrayList<>();
 
    public PanelDeDibujo() {
        this.setBackground(Color.WHITE);
        
        
        class Manejador extends MouseAdapter{
            @Override
            public void mousePressed(MouseEvent e) {
                miRectangulo = new Rectangulo(e.getPoint());
                rectangulos.add(miRectangulo);
                
            }



           @Override
           public void mouseDragged(MouseEvent e) {
                
                miRectangulo.actualizar(e.getPoint());
                
                repaint();
            }
    }
        
        Manejador manejador = new Manejador();
        
        this.addMouseListener( manejador );
        this.addMouseMotionListener( manejador );
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Linea lineaActual : lineas) {
            lineaActual.dibujar(g);
        }
    
        if (miDibujoLibre != null) {
            miDibujoLibre.dibujar(g);
        }
        for (Rectangulo rectanguloActual : rectangulos) {
            rectanguloActual.dibujar(g);
        }
    }
}

*/
/*//Ejemplo rectangulo 1
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PruebaAndres extends JFrame {
    private JButton btnPruebaAndres;
    private JPanel panelDibujo;
    private Point inicioArrastre;
    private Point finArrastre;

    public PruebaAndres() {
        setTitle("Dibujar Cuadrado");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelDibujo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (inicioArrastre != null && finArrastre != null) {
                    int width = Math.abs(finArrastre.x - inicioArrastre.x);
                    int height = Math.abs(finArrastre.y - inicioArrastre.y);
                    int x = Math.min(inicioArrastre.x, finArrastre.x);
                    int y = Math.min(inicioArrastre.y, finArrastre.y);
                    g.drawRect(x, y, width, height);
                }
            }
        };

        btnPruebaAndres = new JButton("Dibujar Cuadrado");
        btnPruebaAndres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDibujo.repaint();
            }
        });

        panelDibujo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                inicioArrastre = e.getPoint();
                finArrastre = inicioArrastre;
                panelDibujo.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                finArrastre = e.getPoint();
                panelDibujo.repaint();
            }
        });

        panelDibujo.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                finArrastre = e.getPoint();
                panelDibujo.repaint();
            }
        });

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelDibujo, BorderLayout.CENTER);
        getContentPane().add(btnPruebaAndres, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PruebaAndres ventana = new PruebaAndres();
                ventana.setVisible(true);
            }
        });
    }
}
*/

/*// Ejemplo 2 recta 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PruebaAndres extends JFrame {
    private JButton btnPruebaAndres;
    private JPanel panelDibujo;
    private ArrayList<Rectangle> cuadrados;

    public PruebaAndres() {
        setTitle("Dibujar Cuadrados");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cuadrados = new ArrayList<>();

        panelDibujo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Rectangle cuadrado : cuadrados) {
                    g.drawRect(cuadrado.x, cuadrado.y, cuadrado.width, cuadrado.height);
                }
            }
        };

        btnPruebaAndres = new JButton("Dibujar Cuadrado");
        btnPruebaAndres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDibujo.repaint();
            }
        });

        panelDibujo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                cuadrados.add(new Rectangle(x, y, 0, 0));
                panelDibujo.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int x1 = cuadrados.get(cuadrados.size() - 1).x;
                int y1 = cuadrados.get(cuadrados.size() - 1).y;
                int x2 = e.getX();
                int y2 = e.getY();
                cuadrados.set(cuadrados.size() - 1, new Rectangle(Math.min(x1, x2), Math.min(y1, y2),
                        Math.abs(x2 - x1), Math.abs(y2 - y1)));
                panelDibujo.repaint();
            }
        });

        panelDibujo.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x1 = cuadrados.get(cuadrados.size() - 1).x;
                int y1 = cuadrados.get(cuadrados.size() - 1).y;
                int x2 = e.getX();
                int y2 = e.getY();
                cuadrados.set(cuadrados.size() - 1, new Rectangle(Math.min(x1, x2), Math.min(y1, y2),
                        Math.abs(x2 - x1), Math.abs(y2 - y1)));
                panelDibujo.repaint();
            }
        });

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelDibujo, BorderLayout.CENTER);
        getContentPane().add(btnPruebaAndres, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PruebaAndres ventana = new PruebaAndres();
                ventana.setVisible(true);
            }
        });
    }
}*/

