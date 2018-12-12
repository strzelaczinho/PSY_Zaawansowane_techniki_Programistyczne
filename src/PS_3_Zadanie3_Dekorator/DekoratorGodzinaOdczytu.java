package PS_3_Zadanie3_Dekorator;

import java.util.Date;

public class DekoratorGodzinaOdczytu extends  Dekorator
{
    private Date date;
    public DekoratorGodzinaOdczytu(IMailbox obj) 
     {
            super(obj);
            date = new Date();
     }
     @Override
    public  void push(String s)
     {
      super.push(s);
     }
     @Override
     public  void pop()
     {
      super.pop();
     }
      @Override
     public String getMail()
     {
     String mail = super.getMail();

     if (mail != "")
     {
         return "Został odczytany: " + date.getHours()+":"+date.getMinutes() + ":" +date.getSeconds()+" "+ mail;
     }
     else return "";
        }
    }