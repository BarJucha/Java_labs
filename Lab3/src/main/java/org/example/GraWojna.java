package org.example;

import java.util.ArrayList;

/**
 * Klasa GraWojna dziedziczy po klasie Gra. Posiada ona metody:
 */
public class GraWojna extends Gra{
    GraWojna(){}
    /**
     * Metoda symuluj() -> przeprowadza ona symulację gry w wojne pomiędzy dwoma graczami.
     */
    public void symuluj() throws BrakKartException {
        int tura = 1;
        Gracz gracz1 = new Gracz();
        Gracz gracz2 = new Gracz();
        talia.potasuj();
        for(int i=0; i<26; i++){
            gracz1.dodajKarte(talia.pociagnijKarte());
            gracz2.dodajKarte(talia.pociagnijKarte());
        }
        gracze.add(gracz1);
        gracze.add(gracz2);
        try{
            while (true){
                if(SprawdzarkaWygranej.Sprawdz(gracze, tura)){break;}
                ArrayList<Karta> k1 =new ArrayList<>();
                ArrayList<Karta> k2 =new ArrayList<>();
                int i=0;
                int a = 0;
                while (true){
                    k1.add(gracz1.dajKarte());
                    k2.add(gracz2.dajKarte());
                    if(k1.get(i).getNumer() > k2.get(i).getNumer()){
                        gracze.get(0).dodajKarte(k2);
                        break;
                    }
                    else if(k1.get(i).getNumer() < k2.get(i).getNumer()){
                        gracze.get(1).dodajKarte(k1);
                        break;
                    }
                    else {
                        if(SprawdzarkaWygranej.Sprawdz(gracze, tura)){a=1;break;}
                        i++;
                    }
                }
                if(SprawdzarkaWygranej.Sprawdz(gracze, tura) && a==0){break;}
                tura++;
            }
        }
        catch (BrakKartException e){
            System.out.println("Tu" + e.getMessage());
        }
    }
}
