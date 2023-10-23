import java.util.ArrayList;

public class Gra {
    Gra(){
        gracze = new ArrayList<>();
        talia = Talia.utworzPelnaTalie();
    }
    public ArrayList<Gracz> gracze;
    public Talia talia;
}
