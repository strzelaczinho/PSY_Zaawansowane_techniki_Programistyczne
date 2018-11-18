
package PS_2_Zadanie2_Abstract_Factory;
public class HeaderDouble implements TableHeader{
    private Double name;
    public HeaderDouble(Double name)
    {
        this.name = name;
    }
    public String toString()
    {
      
        return String.valueOf(name);
    }
    @Override
    public TableData getTableData() {
       return new TableDataDouble();
    }
}
