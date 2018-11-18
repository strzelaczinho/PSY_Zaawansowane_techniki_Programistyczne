
package PS_2_Zadanie2_Abstract_Factory;

public class TableDataDouble implements TableData {
    private double  data;
	public TableDataDouble()
	{
		this.data = 10.0 + rnd.nextDouble();
                
                
	}
	public String toString()
	{
		return String.valueOf(data);
	}
    
}
