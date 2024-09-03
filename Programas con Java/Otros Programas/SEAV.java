public class SEAV implements iSemaforo {
    private String pv_ColorSemaforo;
    private static final String[] COLOR = {"Verde", "Amarillo", "Rojo"};
    private int[] pv_Cambios;
    public SEAV() {
        pv_ColorSemaforo = "[Rojo|Verde|Amarillo]";
        pv_Cambios = new int[3];
    }     
    private String getColor() { return pv_ColorSemaforo; }

    private int getCambio(String p_Color) { return p_Color.equals(COLOR[0]) ? pv_Cambios[0] : p_Color.equals(COLOR[1]) ? pv_Cambios[0] : (pv_Cambios[2] - 1); }
   
    @Override   
    public void cambiarColor() {
        String linea = "";

        for(int i = 0; i <= (pv_Cambios.length - 1); ++i) {
            pv_Cambios[i] += 1;
            
            if(COLOR[i].equals(COLOR[0])){
                linea = "[" + COLOR[i + 1] + "|" + COLOR[(i + 2)] + "|" + COLOR[i] + "]"; 
                pv_Cambios[i] += 1;

            }else if(COLOR[i].equals(COLOR[1])) {
                linea = "[" + COLOR[i - 1] + "|" + COLOR[(i + 1)] + "|" + COLOR[i] + "]";
                pv_Cambios[i] += 1;

            } else { 
                linea = "[" + COLOR[i - 2] + "|" + COLOR[(i - 1)] + "|" + COLOR[i] + "]";
                pv_Cambios[i] += 1;
            }
        }
        pv_ColorSemaforo = linea;
    }
    @Override
    public String desplegarEstado(){ return "Tipo de producto : SEAV\nColor del Semaforo : " + getColor() + "\nVeces que ha cambiado a verde : " + getCambio("Verde") + "\nVeces que ha cambiado a Amarillo : " + getCambio("Amarillo") + "\nVeces que ha cambiado a rojo : " + getCambio("Rojo"); }

}