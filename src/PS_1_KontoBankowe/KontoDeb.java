package PS_1_KontoBankowe;
import java.util.ArrayList;
import java.util.List;
public class KontoDeb extends KontoHis{
   private List<HistoriaOperacji> lista;
   private int debet;
   private boolean wzietoDebet = false;
   private List<Integer> listaDebetu;
    public KontoDeb() 
    {
       listaDebetu = new ArrayList();
    }
    public int obliczDebet(KontoHis kontohis)
    {
        if (wzietoDebet ==false )
        {
        this.debet = 0;
        this.debet = kontohis.zwrocListeHistoriOperacji().stream().mapToInt(x-> x.getWartosc()).sum();
        this.debet = this.debet + (this.debet)*2;
        }
        return this.debet;
    }
    public int zwrocDebet()
    {
        return debet;
    }
    public void PrzyznajDebet(Konto konto)
    {
        if (wzietoDebet == false)
        {
            wzietoDebet = true;
            konto.setStanKonta(konto.getStanKonta()+zwrocDebet());
            konto.zwrocKontohis().zwrocKontoDeb().dodajDoListyDebetu(zwrocDebet());
        }
        else
        {
             System.out.println("Debet zostal juz wczesniej przyznany musisz wykonac jakies operacje na koncie");
        }
    }
     public void wyzerujDebet()
    {
        this.debet = 0;
    }
     public void wstrzyknijReferencje(KontoHis kontohis)
    {
       lista = kontohis.zwrocObiektHistorii().getMapa();
    }
 
    public void przyznajKolejnydebet()
    {
        wzietoDebet = false;
    }
    public boolean CzyWzietoDebet()
    {
        return this.wzietoDebet;
    }
    public List<Integer> getListaDebetu() {
        return listaDebetu;
    }
    public void dodajDoListyDebetu(int wartosc)
    {
        listaDebetu.add(wartosc);
    }
    public int zwrocSumeListyDebetu()
    {
        int zmienna = getListaDebetu().stream().mapToInt(x->x.intValue()).sum();
        return zmienna;
    }
    
}
