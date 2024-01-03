import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Osoba> osoby = new ArrayList<>();
        osoby.add(new Osoba("Kowalski", 20));
        osoby.add(new Osoba("Nowak", 74));
        osoby.add(new Osoba("Kot", 12));
        osoby.add(new Osoba("Czerepach", 56));
        osoby.add(new Osoba("Solejuk", 4));

        double sredniaWieku = osoby.stream()
                .mapToInt(Osoba::getWiek)
                .average()
                .orElse(0.0);

        System.out.println(sredniaWieku);

        int maxWiek = osoby.stream()
                .filter(osoba -> osoba.getNazwisko().contains("a"))
                .mapToInt(Osoba::getWiek)
                .max()
                .orElse(0);

        System.out.println(maxWiek);

        String nazwikaOsob = osoby.stream()
                .map(Osoba::getNazwisko)
                .reduce((s1, s2) -> s1 + "," + s2)
                .orElse("");
        System.out.println(nazwikaOsob);

        double sredniWiekReduce = osoby.stream()
                .mapToDouble(Osoba::getWiek)
                .reduce(Double::sum)
                .orElse(0.0) / osoby.size();
        System.out.println("Średni wiek metodą reduce: " + sredniWiekReduce);
    }

}
