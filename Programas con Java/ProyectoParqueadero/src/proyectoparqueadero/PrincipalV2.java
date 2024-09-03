/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author jordan zorrilla gonzalez
 */
public class Principal extends JFrame{
     public Principal(String username){
        setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(800, 600);
        setTitle("Tom&jerry  Parking- Actual Username: " + username);
        
         JPanel panelPrincipal = new JPanel(){
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Image imagen = new ImageIcon( getClass().getResource("/picture/Tom&Jerry.png")).getImage();
        g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), Principal.this);
      }
      
    };
    
    this.setLayout(new BorderLayout());
    panelPrincipal.setBackground(Color.WHITE);
    this.add(panelPrincipal, BorderLayout.CENTER);
            
    JMenuBar barraDeMenu = new JMenuBar();
            this.setJMenuBar(barraDeMenu);
                    
             JMenu menuArchivo = new JMenu("Option");
             barraDeMenu.add(menuArchivo);
             JMenu menuEstacionamiento = new JMenu("parking lot");
             barraDeMenu.add(menuEstacionamiento);
             JMenu menuAyuda = new JMenu("Help");
             barraDeMenu.add(menuAyuda);
             
             
             
             JMenuItem menuItemSignout= new JMenuItem("Sign out");
             menuArchivo.add(menuItemSignout );
             
             JMenuItem menuItemSalir = new JMenuItem("Exit");
             menuArchivo.add(menuItemSalir );
             menuItemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Close();
                }
             });
           
             JMenuItem menuItemAcerca= new JMenuItem("Acerca");
             menuAyuda.add(menuItemAcerca );
             
             
             JMenuItem menuItemRegisterClient= new JMenuItem("Reistro cliente");
             menuEstacionamiento.add(menuItemRegisterClient);
              
             JMenuItem menuItemRegisterVehicle= new JMenuItem("Register Vehiculo");
             menuEstacionamiento.add(menuItemRegisterVehicle );
              
             JMenuItem menuItemChargingParking= new JMenuItem("Cobro");
             menuEstacionamiento.add(menuItemChargingParking );
             
             
             menuItemRegisterClient.addActionListener( new ActionListener() {
            @Override
      public void actionPerformed(ActionEvent e) {
            FormCliente form = new FormCliente();
              form.setVisible(true);
              }
         
           });
             menuItemRegisterVehicle.addActionListener( new ActionListener() {
            @Override
      public void actionPerformed(ActionEvent e) {
            FormVehiculo form = new FormVehiculo();
              form.setVisible(true);
              }
         
           });
             menuItemChargingParking.addActionListener( new ActionListener() {
            @Override
      public void actionPerformed(ActionEvent e) {
            FormCobrar form = new FormCobrar();
              form.setVisible(true);
              }
         
           });
              
             menuItemAcerca.addActionListener( new ActionListener() {
            @Override
      public void actionPerformed(ActionEvent e) {
            FormAcerca form = new FormAcerca();
              form.setVisible(true);
              }
         
           });
             
             menuItemSignout.addActionListener( new ActionListener() {
            @Override
      public void actionPerformed(ActionEvent e) {
          Signout();
            
              }
         
           });
             
                addWindowListener(new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
                Close();
                }
        });
    }
      private void Signout (){
           int select;
        
                 select = JOptionPane.showConfirmDialog(Principal.this, "Would you Like to Sign Out?",
                     "Confirm", JOptionPane.YES_NO_OPTION);
            
                if (select == JOptionPane.YES_OPTION ) {
                this.dispose();
                Forminiciar fv = new Forminiciar();
                fv.setVisible(true);
                  
                }
     }
     private void Close(){
          int opcion = JOptionPane.showConfirmDialog(Principal.this, "Would you Like to Close The APP?",
                     "Confirm", JOptionPane.YES_NO_OPTION);
                if(opcion == JOptionPane.YES_OPTION) {
                   System.exit( 0 );
    }
     }
    public static void main(String[] args) {
        MetodosUtilitarios.cambiarAparencia("Nimbus");
         Principal window = new Principal("none");
    window.setVisible(true);
    }
}
