public class Customer1 {
    public int ID = 100520391;
    public string EstadoCliente = nuevo;
    public int TotalCompras = 3000;

    public void displayCustomerInfo() {
        System.out.println("Cliente Id:" + ID);
        System.out.println("Estado del cliente:" + EstadoCliente);
        System.out.println("El total de compras:" + TotalCompras);

    }

    public static void main(String args[]) {

        Customer1 desplegar = new Customer1();
        desplegar.displayCustomerInfo();

    }
}