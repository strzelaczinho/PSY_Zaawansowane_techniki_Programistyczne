package PS_2_Zadanie2_Abstract_Factory;
public class ztp03
{
	public static void main(String[] args)
	{
		Table table = new Table();
		table.addCol(new HeaderString("AS"));
		table.addCol(new HeaderInt(5));
		table.addCol(new HeaderDouble(5.0));
		
		table.addRow();
		table.addRow();
		table.addRow();
		table.addRow();
		table.addRow();
		System.out.println(table);


		table.addCol(new HeaderString("AS"));
		table.addRow();
		table.addRow();
		System.out.println(table);
	}
}
// odnosnie zadania
// mozna bylo wybrac typ kolumny ktory dodajemy . Pare typow zdefiniowac . 
// Wykorzystac wzorzec abstract factory 
// trzeba zamienic header jednego typu , na header rozengo typu 

//w 2 
// jedna klasa ktora bedzie tworzyc instacje headerów , czy typow i dalej bedzie tworzyc 