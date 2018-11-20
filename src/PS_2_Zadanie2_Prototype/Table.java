package PS_2_Zadanie2_Prototype;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

class Table extends AbstractTableModel {
    private ArrayList<TableHeader> headers;
    private ArrayList<List<TableData>> data;
    
    public Table() {
        headers = new ArrayList<TableHeader>();
        data = new ArrayList<List<TableData>>();
    }
    public void addRow() {
        ArrayList<TableData> row = new ArrayList<TableData>();
        for(TableHeader col:headers)
            row.add((TableData)col.td.clone()); // wywołanie metody fabrykującej
        data.add(row);
        fireTableStructureChanged(); //refresz
    }
    public void addCol(TableHeader type) {
        headers.add(type);
        for(List<TableData> row:data)
            row.add((TableData)type.td.clone()); // wywołanie metody fabrykującej
        fireTableStructureChanged();//refresz
    }

    public int getRowCount() { return data.size(); }
    public int getColumnCount() { return headers.size(); }
    public String getColumnName(int column) {
        return headers.get(column).toString();
    }
    public Object getValueAt(int row, int column) {
        return data.get(row).get(column);
    }
    	public String toString()
	{
		StringBuilder result = new StringBuilder();
		for(TableHeader header : headers)
			result.append("| " + header + " ");
		result.append("|\n");
		for(TableHeader header : headers)
			result.append("+----");
		result.append("+\n");
		for(List<TableData> row : data)
		{
			for(TableData cell : row)
				result.append("| " + cell + " ");
			result.append("|\n");
		}
		return result.toString();
	}
}