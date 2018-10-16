package PS_1_KontoBankowe;
import java.util.ArrayList;
import java.util.List;
public class HistoriaOperacji {
   private List<HistoriaOperacji> listaHistoriaOperacji;
   private String operacja;
   private int wartosc;
   public HistoriaOperacji()
   {
   }
    public HistoriaOperacji(String nazwaOperacji,int wartosc)
    {
        this.operacja = nazwaOperacji;
        this.wartosc = wartosc;
    }
    public void createLista()
    {
        listaHistoriaOperacji = new ArrayList();
    }
    public void dodajObiektDoListyHistorii(HistoriaOperacji historia)
    {
        if (listaHistoriaOperacji.size() > 20)
        {
            System.out.println("Nie mozna wykonac wiecej operacji");
        }
        else
        {
           listaHistoriaOperacji.add(historia); 
        }
    }
    public List<HistoriaOperacji> getMapa() {
        return listaHistoriaOperacji;
    }
    private HistoriaOperacji zwrocPojedynczaopearacje(int numerOperacji)
    {
        if (listaHistoriaOperacji.get(numerOperacji) != null)
        {
           return listaHistoriaOperacji.get(numerOperacji);
        }
        else return null;
    }
    public String getOperacja() {
        return operacja;
    }
    public void setHistoriaOperacji(String historiaOperacji) {
        this.operacja = historiaOperacji;
    }
    public int getWartosc() {
        return wartosc;
    }
    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }
    
}
