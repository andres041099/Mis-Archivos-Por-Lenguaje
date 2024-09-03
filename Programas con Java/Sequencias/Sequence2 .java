public class Sequence2 {
    public final int SEQUENCE_COUNT= 10;
    public int firstNumber=0;
   public int secondNumber=1;
  
   
   public void  displaySequence2(){
       for (int nextNumber = 0; nextNumber <=SEQUENCE_COUNT; nextNumber++) {
         nextNumber= firstNumber + secondNumber;  
       }
   }
   
}