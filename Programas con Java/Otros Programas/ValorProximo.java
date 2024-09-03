//import java.util.Scanner; // libreria para lectura de datos

public class ValorProximo {

    public int num = 0;
    public int factorial = 1;
    // Scanner leer = new Scanner(System.in);

    public int factorizar(int num) {
        while (num != 0) {
            factorial *= num;
            num--;
        }
        return factorial;
    }

}
