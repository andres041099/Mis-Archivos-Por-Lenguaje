public class Customer {
    int ID = 100520391;
    String EstadoCliente = "nuevo";
    float totalDecomprasF = 3000;

    public void displayCustomerInfo() {
        System.out.println("Cliente Id:" + ID);
        System.out.println("Estado del cliente:" + EstadoCliente);
        System.out.println("El total de compras:" + totalDecomprasF);

    }

    public static void main(String args[]) {

    }
}