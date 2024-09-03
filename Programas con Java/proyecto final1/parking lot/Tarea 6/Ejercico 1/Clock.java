public class Clock {
    public double currentTime;

    public void displayPartOfDay() {
        if (currentTime >= 8.01 && currentTime <= 12.00) {
            System.out.println("La mañana");
        }

        else if (currentTime >= 12.01 && currentTime <= 17.00) {
            System.out.println("La Tarde");

        }

        else if (currentTime >= 17.01 && currentTime <= 24.00) {
            System.out.println("La Noche");
        }

        else if (currentTime >= 00.01 && currentTime <= 8.00) {
            System.out.println("La Madrugada");
        } else {
            System.out.println("No coincide con ningun horario establecido.");
        }
    }

}