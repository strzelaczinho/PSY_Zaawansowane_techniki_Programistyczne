
package PS_3_Zadanie3_Kompozyt;

import java.util.Date;

 public class DekoratorGodzinaNadania extends Dekorator
    {
     private Date date;
    public DekoratorGodzinaNadania(IMailbox obj) {
        super(obj);
        date = new Date();
    }
     @Override
       public void push(String s)
        {
            super.push( "Został zapisany: " + date.getHours()+":"+date.getMinutes()+":"+date.getSeconds() + " " + s );
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