/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii202110;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author josearielpereyra
 */
public class ManejoDeExcepciones {
  public static void main(String[] args) {
    boolean hayError = false;
    int[] numeros = {4, 8, 9, 7, 2, 18};
    do{
      try{
        Scanner entrada = new Scanner(System.in);
        int numero1, numero2;

        System.out.print("Introduzca un numero: ");
        numero1 = entrada.nextInt();
        System.out.println("El numero introducido fue: " + numero1);

        System.out.print("Introduzca otro numero: ");
        numero2 = entrada.nextInt();
        System.out.println("El numero introducido fue: " + numero2);

        System.out.println("La division es: " + numero1/numero2);
        
        System.out.println("El valor en la posicion 6 es: " + numeros[6]);
        
        hayError = false;
      }
      catch(InputMismatchException excepcion) {
        System.out.println("Debe introducir un numero entero");
        hayError = true;
      }
      catch(ArithmeticException excepcion) {
        System.out.println("No se puede dividir entre cero. Intente de nuevo.\n\n");
        hayError = true;
      }
    }while( hayError );
  }
}
