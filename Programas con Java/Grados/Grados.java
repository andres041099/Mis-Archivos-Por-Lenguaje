import java.util.Scanner;

public class Grados {
    public double convc;
    public double convf;

    public void Convertiraf() {
        Scanner entrar = new Scanner(System.in);
        in f;
        System.out.println("Entrar Un Grado");
        f = entrar.nextInt();

        convf = f * 9;
        convf = convf / 5;
        convf = convf + 32;
        System.out.println("farenhiet es:");
    }

    public static void main(String[] args) {

    }
}