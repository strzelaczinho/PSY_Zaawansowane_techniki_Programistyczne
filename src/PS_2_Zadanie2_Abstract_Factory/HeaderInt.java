
package PS_2_Zadanie2_Abstract_Factory;

public class HeaderInt implements TableHeader{
    private int name;
    public HeaderInt(int name)
    {
        this.name = name;
    }
    public String toString()
    {
        return String.valueOf(name);
    }
     public TableData getTableData() {
       return new TableDataInt();
    }
}
