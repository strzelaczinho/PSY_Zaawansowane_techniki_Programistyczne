package PS_3_Zadanie3_Kompozyt;
public class DekoratorFilter extends Dekorator
    {
        private String[] filtr;
    public DekoratorFilter(IMailbox obj, String[] blokowane) 
        {
            super(obj);
            this.filtr = blokowane;
        }
        @Override
        public void push(String s)
        {
            int blad = 0;
            for(String wyraz : this.filtr)
            {
                if (s.indexOf(wyraz) >= 0)                                      //idnex
                {
                    blad = 1;
                    break;
                }
            }
            if (blad == 0)
                super.push(s);
        }
         @Override
        public  void pop()
        {
            super.pop();
        }
         @Override
        public  String getMail()
        {
            return super.getMail();
        }
    }