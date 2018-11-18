package PS_2_Zadanie2_Abstract_Factory;

import java.util.ArrayList;

public class Table 
{
	// lista nagłówków
	private ArrayList<TableHeader> headers;
	// lista wierszy (każdy wiersz to lista komórek)
	private ArrayList<ArrayList<TableData>> rows; //wszystkie wiersze . 
	
       
	public Table()
	{
		headers = new ArrayList<TableHeader>();
		rows = new ArrayList<ArrayList<TableData>>();
	}
	// dodawanie wiersza
	public void addRow()
	{
		// nowy wiersz
		ArrayList<TableData> row = new ArrayList<TableData>();// tutaj wypelniamy headerami . Typ odpowiedniego headera pod spodem 
		// wypełniamy komórkami - tyle, ile mamy kolumn
		for(TableHeader col:headers)
                {
                    if (col instanceof HeaderInt)
			row.add(new TableDataInt());
                    else if (col instanceof HeaderDouble)
                    {
                        row.add(new TableDataDouble());
                    }
                     else if (col instanceof HeaderString)
                    {
                        row.add(new TableDataBooleanasString());
                    }
                }
		// dodajemy do listy wierszy
		rows.add(row);
	}
	// dodawanie kolumny
	public void addCol(TableHeader header)
	{
		// dodajemy do listy nagłówków
		headers.add(header);
		// dodajemy po jednej komórce do każdego wiersza
		for(ArrayList<TableData> row:rows)
                {
                    if (header instanceof HeaderInt)
                    {
                        row.add(new TableDataInt());
                    }
                    else if (header instanceof HeaderDouble)
                    {
                        row.add(new TableDataDouble());
                    }
                    else if ( header instanceof HeaderString)
                    {
                        row.add(new TableDataBooleanasString());
                    }
                }	
	}
	// do wypisywania tabeli
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		for(TableHeader header : headers)
			result.append("| " + header + " ");
		result.append("|\n");
		for(TableHeader header : headers)
			result.append("+----");
		result.append("+\n");
		for(ArrayList<TableData> row : rows)
		{
			for(TableData cell : row)
				result.append("| " + cell + " ");
			result.append("|\n");
		}
		return result.toString();
	}
}