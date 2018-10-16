package PS_1_KontoBankowe;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Main {
    private static int stan;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        boolean zalogowany = true;
        Konto konto = new Konto();
        konto.setStanKonta(PodajStanKonta(sc));
        konto.stworzKontoHis();
        konto.zwrocKontohis().StworzKontoDeb();
        String wybor="";
        while (zalogowany)         {
           System.out.println("Wybierz operacje \n1 = Wplac    2 = Wyplac    3 = Podaj Saldo   4 = Wyjscie    \n5 = Historia   6 = Pokaz Dostepny Debet    7 = Wez Debet1    8 = Popros bank o kolejny debet");
           try{
                 wybor = sc.next();
           }catch(NumberFormatException exc){  System.out.println("Zly format danych");;}
           switch(wybor)
           {
               case "1":
               {
                   try  {
             konto.dodajWartoscDoKonta(sc.nextInt());      
                   }catch (ZaDuzoSrodkowExpcetion | NumberFormatException | InputMismatchException exc)
                           {
                            System.out.println("BLAD! Bank nie obsluguje takich kwot ");  //           e.printStackTrace(System.out);
                           } break;
               }
               case "2":
               {
                   try
                   {
                     konto.odejmijZeStanuKonta(sc.nextInt());     
                   }catch(BrakSrodkowException | NumberFormatException | InputMismatchException exc)
                   {
                       System.out.println("Brak takich srodkow na koncie  ");  //          exc.printStackTrace(System.out);
                   } break;
               }
                case "3":{ System.out.println("Twoje saldo wynosi "+konto.getStanKonta());break;   }
                case "4":{     Wyjdz();   System.exit(0); }
                case "5":{ konto.zwrocKontohis().wypiszWszystkieOperacje();break;}
                case "6":
                {
                    if (konto.zwrocKontohis().zwrocKontoDeb().CzyWzietoDebet())
                    {
                       System.out.println("Twoj debet wynosi 0");
                    }
                    else
                    {
                        System.out.println("Debet do wziecia wynosi "+konto.zwrocKontohis().zwrocKontoDeb().obliczDebet(konto.zwrocKontohis()));  
                    }
                  break;
                }
                case "7":
                {
                    if (konto.zwrocKontohis().zwrocKontoDeb().CzyWzietoDebet())
                    {
                       System.out.println("Twoj debet wynosi 0");
                    }
                    else if (konto.zwrocKontohis().zwrocKontoDeb().zwrocDebet() == 0)
                    {
                        System.out.println("Twoj debet wynosi 0");
                    }
                    else
                    {
                        System.out.println("Debet zostal przyznany");
                        konto.zwrocKontohis().zwrocKontoDeb().PrzyznajDebet(konto);
                        konto.podniesCounter();
konto.zwrocKontohis().zwrocObiektHistorii().dodajObiektDoListyHistorii(new HistoriaOperacji("Operacja nr "+konto.
zwrocCounter()+" Przyznano debet w wysokosci "+konto.zwrocKontohis().
zwrocKontoDeb().zwrocDebet()+"(stan konta = "+konto.getStanKonta()+")"+" (debet = "+konto.zwrocKontohis().
zwrocKontoDeb().zwrocSumeListyDebetu()+")", 0));  

konto.zwrocKontohis().zwrocKontoDeb().wyzerujDebet();
                    }
                    break;
                }
                 case "8":
                    {
                        System.out.println("Debet zostal przyznany, mozesz budowac historie transakcji");
                        konto.zwrocKontohis().zwrocKontoDeb().przyznajKolejnydebet();
                        break;
                    }
           }}}
    private static void Wyjdz() throws InterruptedException {
         System.out.println("Dziekujemy za wpsolprace. Polecamy dział pozyczki , kredyty ");
                    String kropka = ".";
                    System.out.print("Saving.");
                    for (int i = 0;i<5;i++)
                    {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(kropka);
                    } }
    private static int PodajStanKonta(Scanner sc){
        System.out.println("Podaj stan konta");
        stan =0;
        while (stan <= 0 ) {
       try {
             stan = Integer.parseInt(sc.next());
        } catch(NumberFormatException exc)
            {System.out.println("Podane dane sa nieprawidlowe. Sproboj ponownie"); }
        }
        return stan;}}

