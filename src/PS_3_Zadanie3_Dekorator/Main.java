package PS_3_Zadanie3_Dekorator;
public class Main
    {
   public  static void main(String[] args)
        {
            String[] filtr1 = {"adam","jurek"};
            String[] filtr2 = {"przemek"};
            String[] filtr3 = {"marynarz"};
            
            System.out.println("Obiekt nr 1");
            
            Dekorator mailbox  = new DekoratorFilter(
                                 new DekoratorFilter(
                                 new DekoratorFilter(
                                 new DekoratorNumerowanieWiadomosci(
                                 new DekoratorGodzinaOdczytu(
                                 new DekoratorGodzinaNadania(
                                 new Mailbox()))), filtr1 ),filtr2),filtr3);
            
            mailbox.push("adam");
            mailbox.push("jurek");
            mailbox.push("zdzislaw");
            mailbox.push("przemek");
            mailbox.push("marynarz"); 
            System.out.println(mailbox.getMail());
            System.out.println(mailbox.getMail());
            
            System.out.println("Obiekt nr 2");
            
            String[] cenzura   = { "zdzislaw" };
            
           Dekorator mailbox2  = new DekoratorCenzura(
                                 new DekoratorFilter(
                                 new DekoratorFilter(
                                 new DekoratorFilter(
                                 new DekoratorNumerowanieWiadomosci(
                                 new DekoratorGodzinaOdczytu(
                                 new DekoratorGodzinaNadania(
                                 new Mailbox()))), filtr1 ),filtr2),filtr3),cenzura);
            mailbox2.push("adam");
            mailbox2.push("jurek");
            mailbox2.push("zdzislaw");
            mailbox2.push("przemek");
            mailbox2.push("marynarz");
            System.out.println(mailbox2.getMail());
            System.out.println(mailbox2.getMail());
            System.out.println(mailbox2.getMail());
            
            System.out.println("Obiekt nr 3");
             Dekorator mailbox3  = new DekoratorCenzura(
                                   new DekoratorCenzura(
                                   new DekoratorNumerowanieWiadomosci(
                                   new DekoratorGodzinaOdczytu(
                                   new DekoratorGodzinaNadania(
                                   new Mailbox()))),cenzura),filtr1);
            mailbox3.push("adam");
            mailbox3.push("jurek");
            mailbox3.push("zdzislaw");
            mailbox3.push("przemek");
            mailbox3.push("marynarz");
            System.out.println(mailbox3.getMail());
            System.out.println(mailbox3.getMail());
            System.out.println(mailbox3.getMail());
            System.out.println(mailbox3.getMail());
            System.out.println(mailbox3.getMail());
            System.out.println(mailbox3.getMail());
            
                    
            
            System.out.println("\nSzyfrowanie pierwsze:");
            Dekorator mailbox_szyfrowanie2 = new DekoratorSzyfrowanie2(new Mailbox());
            mailbox_szyfrowanie2.push("Kolejny tekst do rozszyfrowania");
            System.out.println(mailbox_szyfrowanie2.getMail());
            
            
            System.out.println("\nSzyfrowanie drugie:");
            Dekorator mailbox_szyfrowanie = new DekoratorSzyfrowanie(new Mailbox());
            mailbox_szyfrowanie.push("rozszyfruj ");
            mailbox_szyfrowanie.push("mnie");
            System.out.println(mailbox_szyfrowanie.getMail());
            System.out.println(mailbox_szyfrowanie.getMail());   
            
           
    }
}