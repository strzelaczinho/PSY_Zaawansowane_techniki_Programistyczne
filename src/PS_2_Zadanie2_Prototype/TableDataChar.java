package PS_2_Zadanie2_Prototype;

class TableDataChar extends TableData
{
    private char data;
    protected void randomize() {data = (char)rnd.nextInt(255);}
    public TableDataChar() { this.randomize(); }
    public String toString() { return Character.toString(data); }
    public String getType() {return "CHAR";}
}
