import java.util.concurrent.CountDownLatch;

public class PruebaArreglos {
    public static void main(String[] args) {
        //int notas[] = new int[10];
        // notas[0] = 20;
        // notas[1] = 30;
        // notas[2] = 126;
        // notas[3] = 130;
        // notas[4] = 72;
        // notas[5] = 32;

        // System.out.println( "notas[0] = " + notas[0] );
        // System.out.println( "notas[1] = " + notas[1] );
        // System.out.println( "notas[2] = " + notas[2] );
        // System.out.println( "notas[3] = " + notas[3] );
        // System.out.println( "notas[4] = " + notas[4] );

        //int notas[] = {20, 17,54, 78, 91, 19, 73, 41, 60};
        int[] notas = new int[]{20, 17,54, 78, 91, 19, 73, 41, 60};

        System.out.println("Mostrando los elementos del arreglo con una estructura de repeticion.");
        for (int i = 0; i < notas.length; i++) {
            System.out.println( "notas[" + i + "] = " + notas[i] * 3 );
        }

        String[] estudiantes = new String[4];
        estudiantes[0] = "Jordan";
        estudiantes[1] = "Jeanfer";
        estudiantes[2] = "Andrés";
        estudiantes[3] = "Luis Rodolfo Abinader Corona";

        for (int i = 0; i < estudiantes.length; i++) {
            for(int j = estudiantes[i].length() - 1; j >= 0 ; j-- ) {
                System.out.println( estudiantes [ i ].charAt(j) );
            }
            System.out.println();
        }



        String[] frutas = "Naranja,Mango,Papaya,Zapote,Coco,Guayaba".split(",");

        System.out.println("\n\nMostrando frutas:");
        for (int i = 0; i < frutas.length; i++) {
            System.out.println( frutas[i]);
        }


        String saludo = "\n\nHola";
        saludo += " Mundo!\n";

        System.out.println(saludo);


        String cadenaDePrueba = "          Hello my friend. How are you?          ".trim().replace("How", "Where");

        System.out.println(cadenaDePrueba);
        System.out.println( "La palabra buscada esta en la posicion: " + cadenaDePrueba.toLowerCase().indexOf("how"));
    }
}