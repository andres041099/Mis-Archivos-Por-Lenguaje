/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ingenieria1202410;

import figuras.Figura;
import figuras.Rectangulo;
import figuras.Linea;
import figuras.Borrador;
import figuras.Contorno;
import figuras.DibujoLibre;
import figuras.FiguraRellenable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Stack;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author josearielpereyra
 */
public class PanelDeDibujo extends JPanel {

    Figura figuraActual;
    BufferedImage cargadaImage = null;
    Color colorDePrimerPlano;
    int grosorFigura;
    String figuraSeleccionada;

    ArrayList<Figura> listaFiguras = new ArrayList<>();
    Stack<Figura> almacenamientoFigura = new Stack<>();

    public PanelDeDibujo() {
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        this.add(Contorno.puntoArrastreNO);
        this.add(Contorno.puntoArrastreN);
        this.add(Contorno.puntoArrastreNE);
        this.add(Contorno.puntoArrastreE);
        this.add(Contorno.puntoArrastreSE);
        this.add(Contorno.puntoArrastreS);
        this.add(Contorno.puntoArrastreSO);
        this.add(Contorno.puntoArrastreO);

        //Pasos para manejar eventos en java
        //1- Crear una clase para que funcione como manejador de eventos
        //2- Hacer que la clase del paso 1 implemente la interfaz de manejo de evento deseada
        //3- Decirle al objeto para el cual manejaremos el evento a cual objeto de la clase creada debe 
        //  notificarle cuando suceda el evento
        class Manejador extends MouseAdapter {

            @Override
            public void mousePressed(MouseEvent e) {

                if ("DibujoLibre".equals(figuraSeleccionada)) {
                    figuraActual = new DibujoLibre(e.getPoint(), colorDePrimerPlano, grosorFigura);
                    listaFiguras.add(figuraActual);
                } else if ("Linea".equals(figuraSeleccionada)) {
                    figuraActual = new Linea(e.getPoint(), colorDePrimerPlano, grosorFigura);
                    listaFiguras.add(figuraActual);

                } else if ("Rectangulo".equals(figuraSeleccionada)) {
                    figuraActual = new Rectangulo(e.getPoint(), Color.WHITE, colorDePrimerPlano, grosorFigura);
                    listaFiguras.add(figuraActual);

                } else if ("Borrador".equals(figuraSeleccionada)) {
                    figuraActual = new Borrador(e.getPoint(), grosorFigura);
                    listaFiguras.add(figuraActual);
                }
                repaint(); // Permite crear punto en pantalla

            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (figuraSeleccionada != null) {
                    figuraActual.actualizar(e.getPoint());

                    repaint();
                }

            }
        }

        Manejador manejador = new Manejador();

        this.addMouseListener(manejador);
        this.addMouseMotionListener(manejador);
    }

    // Método para guardar una imagen en formato PNG y JPG
    public void guardarImagen(String seleccion) {
        BufferedImage imagen = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imagen.createGraphics();
        paint(g2d);
        g2d.dispose();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);

        FileNameExtensionFilter filtroDeImagenPNG = new FileNameExtensionFilter("Imagen PNG", "png");
        fileChooser.addChoosableFileFilter(filtroDeImagenPNG);

        FileNameExtensionFilter filtroDeImagenJPG = new FileNameExtensionFilter("Imagen JPG", "jpg", "jpeg", "jpe", "jfif");
        fileChooser.addChoosableFileFilter(filtroDeImagenJPG);

        if ("JPG".equals(seleccion)) {
            fileChooser.setFileFilter(filtroDeImagenJPG);
        }

        int resultado = fileChooser.showSaveDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File seleccionArchivo = fileChooser.getSelectedFile();
            FileNameExtensionFilter filtroSeleccionado = (FileNameExtensionFilter) fileChooser.getFileFilter();

            if (seleccionArchivo != null) {
                String filePath = seleccionArchivo.getAbsolutePath();
                String extension = "";

                if (filtroSeleccionado == filtroDeImagenPNG) {
                    extension = "png";
                    if (!filePath.endsWith(".png")) {
                        filePath += "." + extension;
                    }
                } else if (filtroSeleccionado == filtroDeImagenJPG) {
                    extension = "jpg";
                    if (!filePath.endsWith(".jpg")) {
                        filePath += "." + extension;
                    }
                }

                File archivo = new File(filePath);

                if (archivo.exists()) {
                    int opcionVentana = JOptionPane.showConfirmDialog(this, "El archivo ya existe. ¿Desea sobrescribirlo?",
                            "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (opcionVentana != JOptionPane.YES_OPTION) {
                        return; // No sobrescribir el archivo
                    }
                }

                try {
                    ImageIO.write(imagen, extension, archivo);
                    JOptionPane.showMessageDialog(this, "Dibujo guardado correctamente como " + filePath);
                    listaFiguras.clear();
                    cargadaImage = null;
                    repaint();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el dibujo.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    // Método para cargar una imagen en formato PNG y JPG
    public void cargarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false); // Desactivar la opción "Todos los archivos"

        FileNameExtensionFilter filtroDeImagenPNG = new FileNameExtensionFilter("Imagen PNG", "png");
        fileChooser.setFileFilter(filtroDeImagenPNG);

        FileNameExtensionFilter filtroDeImagenJPG = new FileNameExtensionFilter("Imagen JPG", "jpg", "jpeg", "jpe", "jfif");
        fileChooser.addChoosableFileFilter(filtroDeImagenJPG);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            if (selectedFile != null) {
                try {
                    if (listaFiguras.isEmpty()) {
                        // Si listaFiguras está vacía, cargar la imagen directamente
                        cargadaImage = ImageIO.read(selectedFile);
                        Graphics g = this.getGraphics();
                        g.drawImage(cargadaImage, 0, 0, null);
                    } else {
                        // Si listaFiguras no está vacía, preguntar si desea guardar antes de cargar la imagen
                        int respuesta = JOptionPane.showConfirmDialog(this,
                                "¿Desea guardar los cambios en el dibujo sin título?", "Guardar Cambios",
                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (respuesta == JOptionPane.YES_OPTION) {
                            guardarImagen("PNG");

                        } else if (respuesta == JOptionPane.NO_OPTION) {
                            listaFiguras.clear();
                            cargadaImage = null;
                            guardarDibujoTemporal();
                        }

                        // Cargar la imagen después de guardar o si se elige no guardar
                        cargadaImage = ImageIO.read(selectedFile);
                        Graphics g = this.getGraphics();
                        g.drawImage(cargadaImage, 0, 0, null);
                    }

                    repaint();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error al cargar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    // Método para guardar la lista de figuras en un archivo temporal
    public void guardarDibujoTemporal() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("dibujoTemporal.dat"))) {
            salida.writeObject(listaFiguras);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el dibujo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        repaint();
    }

    // Método para cargar la lista de figuras desde el archivo temporal
    public void cargarDibujoTemporal() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("dibujoTemporal.dat"))) {
            listaFiguras = (ArrayList<Figura>) entrada.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar el dibujo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Método para imprimir el contenido del jpanel
    public void imprimirImigen() {
     
        PrinterJob printerJob = PrinterJob.getPrinterJob();

        // Establecer el panel como el objeto imprimible
        printerJob.setPrintable((Graphics graphics, PageFormat pageFormat, int pageIndex) -> {
            if (pageIndex > 0) {
                return NO_SUCH_PAGE;
            }
            
            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            
            // Escalar la imagen para ajustarla a la página
            double scaleX = pageFormat.getImageableWidth() / (double) getWidth();
            double scaleY = pageFormat.getImageableHeight() / (double) getHeight();
            double scale = Math.min(scaleX, scaleY);
            
            g2d.scale(scale, scale);
            
            // Dibujar el contenido del panel en el área imprimible
            paint(g2d);
            
            return PAGE_EXISTS;
        }, printerJob.defaultPage()); // Establecer el formato de página por defecto

        // Mostrar el diálogo de impresión
        if (printerJob.printDialog()) {
            try {
                printerJob.print();
            } catch (PrinterException ex) {
                //JOptionPane.showMessageDialog(this, "Error al imprimir.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    //Método para recibir datos desde VentanaPrinciapl para el manejo de las variables    
    /*   public void coordinador(String figuraSeleccionada, Color colorDePrimerPlano, int grosorFigura) {
        this.figuraSeleccionada = figuraSeleccionada;
        this.colorDePrimerPlano = colorDePrimerPlano;
        this.grosorFigura = grosorFigura;

    }*/
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D gDibujo = (Graphics2D) g;
        super.paintComponent(gDibujo);
        
        //Dibujo la imagen cargada en el jpanel
        gDibujo.drawImage(cargadaImage, 0, 0, null);
        for (Figura figura : listaFiguras) {
            figura.dibujar(gDibujo);

            if (figura.equals(figura) && figura instanceof FiguraRellenable) {
                ((FiguraRellenable) figura).getContorno().actualizarPuntosDeArrastre(gDibujo);
            }
        }
    }
}
