package PS_3_Zadanie3_Dekorator;
abstract class Dekorator implements IMailbox
    {
        protected IMailbox obiektMailbox;
        public Dekorator(IMailbox obj)
        {
            this.obiektMailbox = obj;
        }
        @Override    
        public  void push(String tekst)
        {
            obiektMailbox.push(tekst);
        }
        @Override
        public  void pop() 
        { 
            obiektMailbox.pop();
        }
        @Override
        public  String getMail()
        {
            return obiektMailbox.getMail(); 
        }
    }