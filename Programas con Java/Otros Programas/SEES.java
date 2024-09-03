public class SEES implements iSemaforo {
    private String pv_ColorSemaforo;
    private int pv_CambiosColor;
    
    public SEES(){
        pv_ColorSemaforo = "[Amarillo|Rojo|Verde]";
        pv_CambiosColor = 0;
    }
    private String getColor() { return pv_ColorSemaforo; }
    private int getCambios() { return pv_CambiosColor; }

    @Override
    public void cambiarColor(){
        pv_ColorSemaforo = "[Verde|Amarillo|Rojo]";
        pv_CambiosColor += 2;
    }
    @Override
    public String desplegarEstado() { return "Tipo de producto : SEES\nColor del Semaforo : " + getColor() + "\nVeces que ha cambiado : " + getCambios() + "\n"; } 
}