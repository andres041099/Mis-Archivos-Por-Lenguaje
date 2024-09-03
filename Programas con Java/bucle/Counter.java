public class Counter {
    public final int MAX_COUNTER= 50;
	public int count= 1;
	public int step = 1 ;
	
	
	public void  displayCount() {
		while (count<=MAX_COUNTER) {
			count = count+ step;
                        
			
		                  System.out.println(count);
                    }	
	
	}

   

    

    
	
}
