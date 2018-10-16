package PS_1_KontoBankowe;
public class ZaDuzoSrodkowExpcetion extends RuntimeException {
    public ZaDuzoSrodkowExpcetion()
    {
       
    }
    public ZaDuzoSrodkowExpcetion(String message) {
		super(message);
                System.out.println(message);
	}
    
}
