package PS_2_Zadanie2_Prototype;
import java.util.Random;

abstract class TableData implements Cloneable
{
	final static Random rnd = new Random();
	abstract public String toString();
	abstract protected void randomize();
	abstract public String getType();
	public Object clone() 
    {
    	Object referencja = null;
    	try {referencja = super.clone();} 
    	catch (CloneNotSupportedException e) {};
    	((TableData)referencja).randomize();
    	return referencja;
    }
}