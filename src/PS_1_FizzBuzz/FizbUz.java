package PS_1_FizzBuzz;

public class FizbUz {

     public static void main(String[]args)
    {
        runme(101);
    }
    public static void runme(int n){

int num = n;
for (int i = 0; i<num; i++)
{
    if (i ==0)
    {
        System.out.println(i);
    }
{
    if (i % 3==0 && i % 5 == 0 && i != 0)
{
   System.out.println("FizzBuzz");
}
    
else if (i % 3 == 0) 
{   
System.out.println("Fizz");
}
else if (i % 5 == 0)
{
   System.out.println("Buzz");
}
else  
{
    System.out.println(i);
}

}
    
}
}
}