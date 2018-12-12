package PS_3_Zadanie3_Dekorator;

 public class DekoratorSzyfrowanie extends Dekorator
    {
      private String table = "abcdefghijklmnopqrstuvwxyzáéíóúABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚ1234567890.,;_:+-*/ @$#ż?!ˇ=()[]{}\\\'\"";
        public DekoratorSzyfrowanie(IMailbox obj)
        {
            super(obj);
        }
         @Override
        public void push(String s)
        {
            super.push( Encrypt(s,2));
        
        }
         @Override
        public  void pop()
        {
            super.pop();
        }
         @Override
        public  String getMail()
        {
            String mail = super.getMail();
            if (mail.length() == 0)   
                return "Lista  jest pusta";
            
            else return Decrypt(mail, 2);
        }
  private String Clean_text(String text)
     {
        text = text.replaceAll("\n", "");  
         
        for(int x = 0; x < text.length(); x++)
        {
            int position = table.indexOf(text.charAt(x));
            
            if (position == -1)
            {
                text = text.replace(text.charAt(x), ' ');
            }
        }        
        return text;
    }        
    public String Encrypt(String text, int key)
        {       
        String cleaned_text = Clean_text(text);
        String encrypted = "";  
        for(int i = 0; i < cleaned_text.length();i++)
        {
        int position = table.indexOf(cleaned_text.charAt(i));
        if ((position + key) < table.length())
        {
        encrypted += table.charAt(position + key);
        }
        else
        {
        encrypted +=  table.charAt((position + key) - table.length());
        }         
        }        
        return encrypted;
    }
    public String Decrypt(String text, int key)
    {        
        String cleaned_text = Clean_text(text);
        String decrypted = "";   
        for(int x = 0; x < cleaned_text.length(); x++)
        {            
            int position = table.indexOf(cleaned_text.charAt(x)); 
            if ((position - key) < 0)
            {
                decrypted += table.charAt((position - key) + table.length());
            }
            else
            {
                decrypted += table.charAt(position - key );
            }         
        }        
        return decrypted;
    }
    }