public class TesterClass {
    public static void main(String [] args){
        iSemaforo poli = new SEBA();

        if(args[0].toUpperCase().equals("SEBA")){  
            poli.cambiarColor();
            System.out.println (poli.desplegarEstado());
            
        } else if(args[0].toUpperCase().equals("SEES")) {
            poli = new SEES();
            poli.cambiarColor();
            System.out.println (poli.desplegarEstado());

        } else if(args[0].toUpperCase().equals("SEAV")) {
            poli = new SEAV();
            poli.cambiarColor();
            System.out.println (poli.desplegarEstado());

        } else if(args[0].isBlank()) System.exit(0);
        else System.exit(0); 
    }
}