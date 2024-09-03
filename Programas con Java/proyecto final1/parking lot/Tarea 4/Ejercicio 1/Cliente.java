public class Cliente {
    public int ID = 100520391;
    public int totalDecompras = 32938;
    public char estadociente = 'n';

    public void Desplegar() {
        System.out.println("ID: " + ID);
        System.out.println("Total de Compras: " + totalDecompras);
        System.out.println("Estado del Ciente: " + estadociente);
    }

    public static void main(String[] args) {
        Cliente ver = new Cliente();
        ver.Desplegar();
    }
}