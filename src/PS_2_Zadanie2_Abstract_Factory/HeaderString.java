
package PS_2_Zadanie2_Abstract_Factory;
public class HeaderString implements TableHeader {
    
    private String name;
    public HeaderString(String name)
    {
        this.name = name;
    }
    public String toString()
    {
        return name;
    }

    @Override
    public TableData getTableData() {
      
        return new TableDataInt();
    }
}
