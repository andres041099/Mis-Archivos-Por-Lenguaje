public class DateTwo {
    public int dayNumber;

    public void displayDay() {
        if (dayNumber == 1) {
            System.out.println("Es Lunes");

        } else if (dayNumber == 2) {
            System.out.println("Es Martes");
        } else if (dayNumber == 3) {
            System.out.println("Es Miercoles");
        } else if (dayNumber == 4) {
            System.out.println("Es Jueves");
        } else if (dayNumber == 7) {
            System.out.println("Es Domingo");
        }

        else {
            System.out.println("no es ningun dia de semana");
        }
    }
}