public class Person {
    public int edad = 22;
    public int dias;
    public int minutos;
    public int segundos;
    public int milisegundos;

    public void calculateAge() {
        dias = edad * 365;
        minutos = dias * 1440;
        segundos = minutos * 60;
        milisegundos = segundos * 1000;

        System.out.println("Tu tienes:" + " " + edad + " " + "Edad");
        System.out.println("Tu tienes:" + " " + dias + " " + "Dias");
        System.out.println("Tu tienes:" + " " + minutos + " " + "Minutos");
        System.out.println("Tu tienes:" + " " + segundos + " " + "Segundos");
        System.out.println("Tu tienes:" + " " + milisegundos + " " + "MiliSegundos");

    }

    public static void main(String[] args) {

    }
}