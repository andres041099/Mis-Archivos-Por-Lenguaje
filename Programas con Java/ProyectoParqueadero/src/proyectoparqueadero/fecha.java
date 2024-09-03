package objetosDeDatos;

import java.util.Calendar;//para los valores de la fecha actual en el constructor
import java.util.Scanner;//para utilizar entrada por teclado a traves de la consola
import javax.swing.JOptionPane;

/**
 *
 * @author JoseAriel
 *
 * Clase para manejar fechas (valida que las entradas sean correctas)
 */
public class Fecha {

   //***************************************************************************
   //Campos / Datos miembro / Atributos / Variables de instancia
   //***************************************************************************
   private int dia;
   private int mes;
   private int anio;


   //***************************************************************************
   //metodos accesores
   //***************************************************************************

   /**
    * @return el dia
    */
   public int obtenerDia() {
      return dia;
   }

   /**
    * @return el mes
    */
   public int obtenerMes() {
       return mes;
   }

   /**
    * @return el año
    */
   public int obtenerAnio() {
      return anio;
   }

   /**
    * Metodo que verifica si el dia es valido y lo asigna a la fecha
    * @param dia el dia a establecer
    */
   public void establecerDia(int dia) {
      int[] diasPorMes = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
      
      //si el anio es bisiesto la cantidad de dias en diasPorMes[2] es 29
      if(esAnioBisiesto(anio)) diasPorMes[2] = 29;

      Scanner entrada = new Scanner(System.in); //variable para introducir valores apropiados
      String error = "";//variable para contener el mensaje a mostrar en caso de error

      while(true) //bucle infinito para obligar a introducir un valor apropiado para el dia
      {
         error  = ""; //evitando que el mensaje de error contenga texto de mas

         // verificar que el dia esta dentro del rango apropiado para el mes, si es asi,  asignarlo a dia y salir
         if ( dia > 0 && dia <= diasPorMes[ mes ] )
         {
            this.dia = dia;
            return;
         }

         
         //si el valor no es valido recibir un nuevo valor para el dia
         error += "EL DIA (" + dia + ") NO ES VALIDO PARA EL MES "+ mes +"!!\n";
         error += "El valor debe estar entre 1 y " + diasPorMes[mes] + "\n";
         error += "Digite un valor apropiado para el dia: ";

         //imprimir el mensaje de error
         JOptionPane.showMessageDialog(null, error);
         dia = entrada.nextInt();//recibir el nuevo valor para el dia
      } //fin del while
      
   } // fin del metodo establecerDia

   /**
    * Metodo que verifica si el mes es valido y lo asigna a la fecha
    * @param mes El mes a establecer
    */
   public void establecerMes(int mes)
   {
      Scanner entrada = new Scanner(System.in);
      String error = "";//variable para contener el mensaje de error a mostrar

      while(true)//bucle para asegurar que el valor introducido a mes sea valido
      {
         error  = ""; //evitando que el mensaje de error contenga texto de mas
         //si el mes es valido asignarselo al atributo mes
         if(mes >= 1 && mes <=12)
         {
            this.mes = mes;
            return;
         }
         else //si el valor no es valido, leer un nuevo valor para asignarselo a mes
         {
            //si el valor no es valido recibir un nuevo valor para el mes
            error += "ERROR EN EL MES\n";
            error += "EL VALOR ("+ mes +") PARA MES NO ES VALIDO!!!, DEBE SER UN VALOR ENTRE 1 Y 12 \n";
            error += "Digite un valor apropiado para el mes: ";
            
            //imprimir el mensaje de error
            System.out.print(error);
            mes = entrada.nextInt();//recibir el nuevo valor para el dia
         }
      } //fin del while

    }//fin del metodo establecerMes

   /**
    * @param anio el a�o a establecer
    */
   public void establecerAnio(int anio) {
      this.anio = anio;
   }


   //***************************************************************************
   //constructor(es)
   //***************************************************************************

   //constructor por defecto este va a asignar a las variables de instancia, los
   //valores de la fecha actual del sistema
   public Fecha()
   {
      //obtener una nueva instancia de la clase Calendar para tener acceso a la 
      //fecha actual.
      Calendar fecha = Calendar.getInstance();

      //No he utilizado los metodos accesores para validar los datos,
      //pues por logica, no deberia darnos datos fuera de rango
      dia = fecha.get(Calendar.DAY_OF_MONTH); //dia actual
      mes = fecha.get(Calendar.MONTH) + 1; //mes actual
      anio = fecha.get(Calendar.YEAR); //anio actual
   }
   
   //constructor para cuando queremos asignar una fecha especifica pasando los
   //tres parametros
   public Fecha(int dia, int mes, int anio)
   {
      //utilizar los metodos accesores para validar que los datos esten dentro
      //del rango apropiado
      establecerAnio(anio);
      establecerMes(mes);
      establecerDia(dia);
   }

   //constructor para cuando se pasa como parametro otra fecha
   public Fecha(Fecha laFecha)
   {
      this(laFecha.obtenerDia(), laFecha.obtenerMes(), laFecha.obtenerAnio());
   }


   //***************************************************************************
   //Metodos Miembro / Comportamiento
   //***************************************************************************
   public String toString()
   {
      return dia + "/" + mes + "/" + anio;
   }

 
   /**
    * Metodo que evalua si un anio es bisiesto o no
    * @param elAnio el anio a ser evaluado
    * @return true si el anio es bisiesto, false si no lo es...
    */
   private boolean esAnioBisiesto(int elAnio)
   {
      if( ( elAnio % 400 == 0) || ( elAnio % 4 == 0 && elAnio % 100 != 0 ) )
      {
         return true;
      }
      else
      {
         return false;
      }
   }//fin del metodo esAnioBisiesto

   /**
    * Metodo que calcula la cantidad de dias transcurridos  en un anio, dada una fecha especifica
    * @param fecha fecha de la que se va a calcular la cantidad de dias transcurridos en el anio
    * @return
    */
   public int obtenerDiaDelAnio(Fecha fecha)
   {
      //arreglo de los dias contenidos en un anio no bisiesto, contiene trece elementos para 
      //poder llamar a cada mes por su numero (el elemento en la posicion cero no se utiliza)
      int[] diasPorMes = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
      
      //si el anio es bisiesto, la cantidad de dias en el mes 2 (febrero) es igual a 29
      if( esAnioBisiesto(fecha.obtenerAnio()) ) diasPorMes[2] = 29;

      int diaDelAnio = 0;//variable que va a contener la cantidad de dias transcurridos en el anio especificado

      //sumar a diaDelAnio el valor de los meses transcurridos (excluyendo el mes actual)
      for(int i = 1; i < fecha.obtenerMes(); i++)
      {
         diaDelAnio += diasPorMes[i];
      }

      //sumar a diaDelAnio el valor del dia (la cantidad de dias transcurridos en el mes actual)
      diaDelAnio += fecha.obtenerDia();

      //devolver el total de dias transcurridos
      return diaDelAnio;

   }//fin del metodo obtenerDiaDelAnio

//##############################################################################
   //metodo para restar fechas
//##############################################################################
      /**
    * Metodo para calcular la cantidad de dias transcurridos desde una fecha
    * inicial hasta la fecha actual que se esta utilizando
    * @param fechaInicial la fecha en la que se inicio la transaccion (en este caso, la entrada del vehiculo)
    * @return El metodo devuelve uno de tres valores posibles:
    * <ol>
    *    <li>la cantidad de dias entre las dos fechas si la fecha a restar es menor que la fecha final,</li>
    *    <li>un numero negativo si la fecha final es menor que la inicial,</li>
    *    <li>cero (0) si las fechas son iguales.</li>
    * <ol>
    */
   public int restarFecha(Fecha fechaInicial)
   {
      int anioBase = 1;//utilizando como base el anio 1
      int dias = 0;

      //cuando el anioBase sea mayor que el anio en la fecha final, o sea, que
      //sea mayor que el anio de la fecha a la que se va a restar la fecha inicial
      //la aplicacion nos devolveria resultados erroneos lo controlamos con el sigte
      //bloque condicional y devolvemos menor que cero cuando se da este caso (aqui -1).
      //en este caso lo hago solo por prevenir, pues dudo mucho que alguien vaya
      //a utilizar un anio menor que el anio 1.
      if(anioBase > this.obtenerAnio() || anioBase > fechaInicial.obtenerAnio())
      {
         dias = -1;
      }
      else
      {
         int diaDelAnioInicial = fechaInicial.obtenerDiaPorBase(fechaInicial, anioBase);
         int diaDelAnioFinal = this.obtenerDiaPorBase(this, anioBase);

         //una vez tenemos los valores en una
         dias = diaDelAnioFinal - diaDelAnioInicial;
      }

      return dias;
   }

   /**
    * Metodo para calcular la cantidad de dias transcurridos desde un anio base 
    * hasta una fecha especifica
    * @param fecha la fecha para la que se van a calcular los dias transcurridos
    * @param anioBase el anio que se utiliza como base para calcular la cantidad de dias
    * @return la cantidad de dias transcurridos desde el anio base hasta la fecha
    */
   public int obtenerDiaPorBase(Fecha fecha, int anioBase)
   {
      int dias = 0;

      //si la diferencia entre los anios es mayor que 1, entonces sumar a la
      //variable dias los dias contenidos en cada anio dentro del intervalo
      //usar una sentencia de repeticion para sumar los anios
      for(int i= anioBase; i < fecha.obtenerAnio(); i++)
      {
         //si el anio es bisieto sumar 366 a dias de lo contrario, sumar 365
         dias += esAnioBisiesto(i)? 366 : 365;
      }//fin de la sentencia for

      //obtener el valor de los dias transcurridos en el anio de la variable fecha
      dias += obtenerDiaDelAnio(fecha);

      return dias;
   }

//#############################################################################
   //metodo main para probar la clase
//#############################################################################
   public static void main(String[] args)
   {
      //para utilizar una fecha determinada por el usuario se usan los costructores con parametros
      Fecha fechaEntrada = new Fecha(25,3, 2011);
      System.out.println( "Fecha Entrada: " + fechaEntrada.toString() );

      //al usar el costructor sin parametros nos da la fecha de hoy
      Fecha fechaSalida = new Fecha();
      System.out.println( "Fecha Salida: " + fechaSalida.toString() );

		int dias = fechaSalida.restarFecha(fechaEntrada);
		
      System.out.println( "Diferencia entre fechas: " + dias  + " dias" );
   }//fin del metodo main

}//fin de la clase fecha