public class Sequence {
   public int firstNumber=0;
   public int secondNumber=1;
   public  int nextNumber;
 public void displaySequence (){
     while (nextNumber<=100) {   
         nextNumber= firstNumber + secondNumber;
         ++secondNumber;
         System.out.println("los daos son: "+firstNumber+" "+ secondNumber+" ");
          System.out.println("El resultado es "+ nextNumber);
         
     }
 }
}
