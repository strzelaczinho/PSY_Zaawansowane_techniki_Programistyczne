package PS_2_Zadanie2_Prototype;

class TableHeader
{
    private String type;
    public TableData td;
    public TableHeader(String type) { this.type = type; }
    public TableHeader(TableData td) {this.td = td;}
    public String toString() { return td.getType(); }
}