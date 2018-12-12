package PS_3_Zadanie3_Dekorator;
public class DekoratorNumerowanieWiadomosci extends Dekorator
    {
     private int numer = 1;
    public DekoratorNumerowanieWiadomosci(IMailbox obj)
    {
        super(obj);
    }
      @Override
    public void push(String s)
        {
            super.push( "[" + numer + "] " + s);
            this.numer += 1;
        }
        @Override
        public  void pop()
        {
            super.pop();
        }
         @Override
        public String getMail()
        {
            return super.getMail();
        }
    }