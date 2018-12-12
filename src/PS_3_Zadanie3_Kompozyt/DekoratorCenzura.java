package PS_3_Zadanie3_Kompozyt;
 public class DekoratorCenzura extends Dekorator
    {
        private String[] cenzura;
 public DekoratorCenzura(IMailbox obj, String[] a)
    {
       super(obj);
       this.cenzura = a;
    }
        @Override
        public void push(String s)
        {
            for (String wyraz : this.cenzura)
            {
                if (s.indexOf(wyraz) >= 0)
                {
                    s = s.replace(wyraz, "****");
                }
            }
            super.push(s);
        }
        @Override
        public void pop()
        {
            super.pop();
        }
        @Override
        public  String getMail()
        {
            return super.getMail();
        }
    }