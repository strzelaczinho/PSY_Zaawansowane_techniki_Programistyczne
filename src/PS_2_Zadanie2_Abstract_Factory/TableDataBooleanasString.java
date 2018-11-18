
package PS_2_Zadanie2_Abstract_Factory;

public class TableDataBooleanasString implements TableData{
      private boolean  data;
	public TableDataBooleanasString()
	{
		data = rnd.nextBoolean();
	}
	public String toString()
	{
		return String.valueOf(data);
	}
}
