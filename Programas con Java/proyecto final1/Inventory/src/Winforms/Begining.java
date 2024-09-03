/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Winforms;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
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
 * @author virginia
 */
public class Begining extends JFrame {
    public Begining(String username){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(800, 600);
        setTitle("Inventary Actual Username: " + username);
        /*JPanel panel = new  JPanel(){ 
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
              Image picture = new ImageIcon( getClass().getResource("E:\\Programacion\\proyecto final1\\Inventory\\src\\Picture\\inventario-periodico.png")).getImage();
        g.drawImage(picture, 10, 29, this.getWidth(), this.getHeight(), Begining.this);
                
         }
        };
        
          this.setLayout(new BorderLayout());
          this.add(panel,BorderLayout.CENTER);
        */
       JMenuBar fMenu = new JMenuBar();
            this.setJMenuBar(fMenu);
       
            JMenu menuFile = new JMenu("File");
             fMenu.add(menuFile);
             JMenu menuClients = new JMenu("Clients");
             fMenu.add(menuClients);
             JMenu menuHelp = new JMenu("Help");
             fMenu.add(menuHelp);
             
           JMenuItem menuItemSignout= new JMenuItem("Sign out");
             menuFile.add(menuItemSignout );
             
             JMenuItem menuItemExit = new JMenuItem("Exit");
             menuFile.add(menuItemExit );
             
             JMenuItem menuItemAdd= new JMenuItem("Add New Client");
             menuClients.add(menuItemAdd );
             
             JMenuItem menuItemAbout= new JMenuItem("About");
             menuHelp.add(menuItemAbout );
             
             menuItemAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Formaddnewclients  fv = new Formaddnewclients();
                fv.setVisible(true);
            }
             });
             
             menuItemAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormCredict fv = new FormCredict();
                fv.setVisible(true);
            }
             });
             
             
       
              menuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindClose();
            }
             });
             
             addWindowListener(new WindowAdapter() {
            

            @Override
            public void windowClosing(WindowEvent e) {
                WindClose();
               }

           });
             menuItemSignout.addActionListener( new ActionListener() {
            @Override
      public void actionPerformed(ActionEvent e) {
          Out();
            
              }
         
           });
        }

    Begining(Formacess aThis, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void  WindClose(){
    int opcion = JOptionPane.showConfirmDialog(
                     Begining.this, "Would you Like to Close The APP?",
                     "Confirm", JOptionPane.YES_NO_OPTION);
                if(opcion == JOptionPane.YES_OPTION) {
                   System.exit( 0 );
    }
    
    }
                private void  Out(){
                  int select;
        
                 select = JOptionPane.showConfirmDialog(
                     Begining.this, "Would you Like to Sign Out?",
                     "Confirm", JOptionPane.YES_NO_OPTION);
            
                if (select == JOptionPane.YES_OPTION ) {
                this.dispose();
                Formacess fv = new Formacess();
                fv.setVisible(true);
                  
                }
    }
            
    public static void main(String[] args) {
        MetodosUtilitarios.cambiarAparencia("Nimbus");
         Begining view = new Begining("none");
            view.setVisible(true);
    }
    
}
