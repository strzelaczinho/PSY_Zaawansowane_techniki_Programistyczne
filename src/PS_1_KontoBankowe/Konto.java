package PS_1_KontoBankowe;
import java.util.List;
public class Konto {
  private  int stanKonta;
  private KontoHis kontohis;
  private static int counter;
  public Konto ()
  {
      counter = 1;
  }
  public void stworzKontoHis()
      {this.kontohis = new KontoHis();}
 
public KontoHis zwrocKontohis()
   { return this.kontohis;}

    public int getStanKonta() {
        return stanKonta;
    }
    public void setStanKonta(int stanKonta) {
        this.stanKonta = stanKonta;
    }
    public void dodajWartoscDoKonta(int dodaj)
    {
        if (this.stanKonta + dodaj < 0 || this.stanKonta+ dodaj < Integer.MIN_VALUE || this.stanKonta + dodaj > Integer.MAX_VALUE)
            {
                throw new ZaDuzoSrodkowExpcetion("Bank nie obsluguje takich operacji");
            }
        else  
            {
             this.stanKonta += dodaj;
             zwrocKontohis().zwrocObiektHistorii().dodajObiektDoListyHistorii(new HistoriaOperacji("Operacja nr "+counter+": Do konta wplacono wartosc "+dodaj+" (stan konta = "+getStanKonta()+")", dodaj));
            podniesCounter();
            } 
    }
    public void odejmijZeStanuKonta(int odejmij)
    {
          if (this.stanKonta - odejmij < 0 || this.stanKonta - odejmij < Integer.MIN_VALUE || this.stanKonta + odejmij > Integer.MAX_VALUE )
            {
                throw new BrakSrodkowException("Brak srodkow na koncie");
            }
        else 
            {
             this.stanKonta -= odejmij;
             zwrocKontohis().zwrocObiektHistorii().dodajObiektDoListyHistorii(new HistoriaOperacji("Operacja nr "+counter+": Z konta wyplacono wartosc "+odejmij+" (stan konta = "+getStanKonta()+")", odejmij));
            podniesCounter();
            }
    }
    public int zwrocCounter()
    {
        return counter;
    }
    public void podniesCounter()
    {
        ++counter;
    }
}
