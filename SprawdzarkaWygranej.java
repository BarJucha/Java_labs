import java.util.ArrayList;

public class SprawdzarkaWygranej {
    static boolean Sprawdz(ArrayList<Gracz> gracze, int tura){
        if(gracze.get(0).kartyGracza.isEmpty() && gracze.get(1).kartyGracza.isEmpty()){
            System.out.println("REMIS! Tura: " + tura);
            return true;
        }
        if(gracze.get(0).kartyGracza.isEmpty()){
            System.out.println("Wygral gracz 2 w turze: " + tura);
            return true;
        }
        if(gracze.get(1).kartyGracza.isEmpty()){
            System.out.println("Wygral gracz 1 w turze: " + tura);
            return true;
        }
        return false;
    }
}
