public class SEBA implements iSemaforo{
     private String pv_ColorSemaforo;
     public SEBA(){ pv_ColorSemaforo = "[Amarillo|Rojo|Verde]"; }

     private String getColor() { return pv_ColorSemaforo; }

     @Override  
    
    public void cambiarColor() { pv_ColorSemaforo = "[Verde|Amarillo|Rojo]"; }
    @Override
     public String desplegarEstado() { return "Tipo de producto :SEBA\nColor del semaforo :" + getColor() + "\n"; }
    }
