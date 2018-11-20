package PS_2_Zadanie2_Prototype;

class TableDataDouble extends TableData
{
    private double data;
    protected void randomize() {data = rnd.nextDouble();}
    public TableDataDouble() { this.randomize(); }
    public String toString() { return Double.toString(data); }
    public String getType() {return "DOUBLE";}
}