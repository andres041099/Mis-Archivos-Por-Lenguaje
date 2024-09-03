/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bucle;

/**
 *
 * @author Andres
 */
public class Sequence2 {
    public final int SEQUENCE_COUNT= 10;
    public int firstNumber=0;
   public int secondNumber=1;
  
   
   public void  display(){
       for (int nextNumber = 0; nextNumber <=SEQUENCE_COUNT; nextNumber++) {
         nextNumber= firstNumber + secondNumber;  
       }
   }
   
}
