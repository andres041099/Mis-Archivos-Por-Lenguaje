public class Orden {
    long orderValue = (Integer) 0L;
    int itemQuantity = 10000000;
    int itemPrice = 555500;
    int Total;

    public void calculateTotal() {
        Total = orderValue * itemQuantity * itemPrice;
        System.out.println("El Resultado es: " + " " + Total);

    }

    public static void main(String[] args) {

    }
}