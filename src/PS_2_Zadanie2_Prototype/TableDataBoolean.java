package PS_2_Zadanie2_Prototype;

class TableDataBoolean extends TableData
{
    private boolean data;
    protected void randomize() {data = rnd.nextBoolean();}
    public TableDataBoolean() { this.randomize(); }
    public String toString() { return Boolean.toString(data); }
    public String getType() {return "BOOLEAN";}
}