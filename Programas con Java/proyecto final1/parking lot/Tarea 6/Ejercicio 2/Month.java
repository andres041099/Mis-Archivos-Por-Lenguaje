public class Month {
    public int monthNumber;

    public void displayMonth() {
        switch (monthNumber) {
        case 1:
            System.out.println("Enero");
            break;
        case 2:
            System.out.println("Febrero");
            break;
        case 3:
            System.out.println("Marzo");
            break;
        case 4:
            System.out.println("Abril");
            break;
        case 5:
            System.out.println("Mayo");
            break;
        case 12:
            System.out.println("Diciembre");
            break;

        default:
            System.out.println("Numero Erroneo");
            break;
        }
    }
}