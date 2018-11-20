package PS_2_Zadanie2_Prototype;

public class TableDataInt extends TableData{
      private int data;
    protected void randomize() {data = rnd.nextInt(100);}
    public TableDataInt() { this.randomize(); }
    public String toString() { return Integer.toString(data); }
    public String getType() {return "INT";}
    
}
