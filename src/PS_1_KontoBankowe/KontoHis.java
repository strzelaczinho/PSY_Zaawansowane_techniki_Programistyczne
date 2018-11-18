
package PS_1_KontoBankowe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class KontoHis extends Konto{
   private  List<Integer> listaWartosci;
    private HistoriaOperacji obiektHistoriiOperacji;
   private  KontoDeb kontodeb;
   private int zmienna;
    public KontoHis() 
    {
      stworzObiektHistorii();
      stworzObiektListyOperacji();
    }
    public  KontoDeb zwrocKontoDeb()
    {
        return kontodeb;
    }
    public void StworzKontoDeb()
    {
        this.kontodeb = new KontoDeb();
    }
    private void stworzListeWartosci()
    {
         listaWartosci = new ArrayList<>();
    }
    private List<Integer> zwrocListeWartosci()
    {
        return listaWartosci;
    }
    
    private void stworzObiektHistorii(){ obiektHistoriiOperacji = new HistoriaOperacji();}
    private void stworzObiektListyOperacji(){obiektHistoriiOperacji.createLista();}
    
public HistoriaOperacji zwrocObiektHistorii(){return obiektHistoriiOperacji;}
public List<HistoriaOperacji> zwrocListeHistoriOperacji(){  return obiektHistoriiOperacji.getMapa();  }
      
     public void wypiszWszystkieOperacje() 
      {
         zwrocListeHistoriOperacji().stream().limit(20).forEach(x-> System.out.println(x.getOperacja()));
      }
   
}
