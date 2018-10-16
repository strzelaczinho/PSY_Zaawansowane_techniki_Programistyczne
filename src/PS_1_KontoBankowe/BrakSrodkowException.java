package PS_1_KontoBankowe;
public class BrakSrodkowException extends RuntimeException {
    public BrakSrodkowException()
    {
       
    }
    public BrakSrodkowException(String message) {
		super(message);
                System.out.println(message);
	}
}
