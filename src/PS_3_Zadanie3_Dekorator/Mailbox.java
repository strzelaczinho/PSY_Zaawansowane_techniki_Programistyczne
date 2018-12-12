package PS_3_Zadanie3_Dekorator;

import java.util.LinkedList;

public class Mailbox implements IMailbox
{
private LinkedList<String> mailbox = new LinkedList<String>();
    @Override
    public void push(String s) {
        mailbox.addLast(s);
    }

    @Override
    public void pop() {
       mailbox.removeFirst();
    }

    @Override
    public String getMail()
    {
        for(String mail :mailbox)
            {
                mailbox.removeFirst();
                return mail;
            }

            return "Mail jest pusty";
    }

}