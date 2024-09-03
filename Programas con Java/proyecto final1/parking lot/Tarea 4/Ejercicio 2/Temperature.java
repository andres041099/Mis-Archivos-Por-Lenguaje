import javax.swing.JOptionPane;

public class Temperature {
    public int fahrenheit = 78;
    public double convertir;

    public void calculateCelsius() {
        convertir = (fahrenheit - 32);
        convertir = convertir * 5;
        convertir = convertir / 9;

        System.out.println("Celsiu es: " + convertir);
    }

    public static void main(String[] args) {

    }
}