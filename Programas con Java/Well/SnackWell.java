public class SnackWell {
    private int moneda;

    public int getMoneda() {
        switch (moneda) {
        case 25:
            System.out.print("masmas");
            break;
        case 30:
            System.out.print("pltanito");
            break;
        case 35:
            System.out.print("yuquita");
            break;
        case 60:
            System.out.print("MyM");
            break;

        default:
            System.out.print("Producto no Existente");
            break;
        }
        return moneda;
    }

    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }

}