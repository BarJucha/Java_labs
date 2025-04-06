import java.util.ArrayList;
/**
 * Klasa gra posiada dwa pola:
 *  1) Array<Gracz> gracze -> przechowuje liste graczy uczestniczących w grze.
 *  2) Talia talia -> przechowuje talie do gry
 */

public class Gra {
    Gra(){
        gracze = new ArrayList<>();
        talia = Talia.utworzPelnaTalie();
    }
    public ArrayList<Gracz> gracze;
    public Talia talia;
}
