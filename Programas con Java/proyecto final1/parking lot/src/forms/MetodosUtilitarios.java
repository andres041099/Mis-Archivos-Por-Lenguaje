/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import javax.swing.JOptionPane;

/**
 *
 * @author josearielpereyra
 */
public class MetodosUtilitarios {
  public static void cambiarAparencia(String apariencia) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ( apariencia.equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
        }
        
        System.out.println( info.getName() );
      }
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "No se pudo cambiar la apariencia visual");
    }
  }
}
