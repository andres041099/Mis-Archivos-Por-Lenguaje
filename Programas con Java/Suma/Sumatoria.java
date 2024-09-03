import java.util.Scanner;

public class Sumatoria {
    private int suma;

    public int getSuma() {
        suma = suma + suma;
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public static void main(String[] args) {
        Sumatoria sumatoria = new Sumatoria();
        Scanner sc = new Scanner(System.in);
        setsuma;
        System.out.print("introdusca un numero");
        sumatoria.setSuma() = sc.nextInt();
        System.out.println("La suma es" + sumatoria.getSuma());
    }
}