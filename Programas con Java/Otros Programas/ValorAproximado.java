import java.util.Scanner; // libreria para lectura de datos

public class ValorAproximado {

    public static void main(String[] agrs) {

        double x;

        double resultado;
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese el calor de X");
        x = leer.nextInt();

        ValorProximo factores;
        factores = new ValorProximo();

        resultado = 1 - x;
        resultado += Math.pow(x, 2) / factores.factorizar(2);
        resultado += Math.pow(x, 3) / factores.factorizar(3);
        resultado += Math.pow(x, 4) / factores.factorizar(4);
        resultado += Math.pow(x, 5) / factores.factorizar(5);
        resultado += Math.pow(x, 6) / factores.factorizar(6);
        resultado += Math.pow(x, 7) / factores.factorizar(7);
        resultado += Math.pow(x, 8) / factores.factorizar(8);

        System.out.println("El resultado es = " + resultado);
    }
}
