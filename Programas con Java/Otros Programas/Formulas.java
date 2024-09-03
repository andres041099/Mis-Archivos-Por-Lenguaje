public class Formulas {
    public static void main(String[] args) {
        double vo = 2.5, g = 6.23, h = 10.8;

        // Primeras formula
        double tfMas = ((-2 * vo) / g) + Math.sqrt(Math.pow(((2.0 * vo) / g), 2) + (8 * h / 2));
        double tfMenos = ((-2 * vo) / g) - Math.sqrt(Math.pow(((2.0 * vo) / g), 2) + (8 * h / 2));

        System.out.println(tfMas);
        System.out.println(tfMenos);

        // segundas formulas
        double tf = (-vo / g) + Math.sqrt(Math.pow((vo / g), 2.0)) + (2 * h / g);
        System.out.println(tf);
    }

}
