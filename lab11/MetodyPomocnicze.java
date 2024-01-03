import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MetodyPomocnicze {

    public static void main(String[] args) {
        List<String> miesiace = new ArrayList<>(Arrays.asList("Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec",
                "Lipiec", "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień"));

        miesiace.forEach(MetodyPomocnicze::wypiszOstatniaLitere);

        List<String> zmienioneMiesiace = miesiace.stream()
                .map(new MetodyPomocnicze()::zamienTrzyPierwszeLiteryNaWielkie)
                .collect(Collectors.toList());

        System.out.println(zmienioneMiesiace);

        miesiace.removeIf(miesiac -> !miesiac.contains("e"));
        System.out.println(miesiace);

        List<Double> liczby = generujLosoweLiczby(10);
        System.out.println(liczby);

        try {
            double srednia = liczby.stream()
                    .filter(x -> x >= 0)
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElseThrow(() -> new IllegalArgumentException("Brak nieujemnych liczb do obliczenia średniej."));

            System.out.println("Średnia arytmetyczna nieujemnych elementów: " + srednia);
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
    public static void wypiszOstatniaLitere(String napis) {
        if (napis != null && !napis.isEmpty()) {
            char ostatniaLitera = napis.charAt(napis.length() - 1);
            System.out.println("Ostatnia litera w \"" + napis + "\": " + ostatniaLitera);
        } else {
            System.out.println("Napis jest pusty lub null.");
        }
    }
    public String zamienTrzyPierwszeLiteryNaWielkie(String napis) {
        if (napis != null && napis.length() >= 3) {
            return napis.substring(0, 3).toUpperCase() + napis.substring(3);
        } else {
            return napis;
        }
    }
    private static List<Double> generujLosoweLiczby(int ilosc) {
        Random rand = new Random();
        List<Double> liczby = new ArrayList<>();
        for(int i=0; i<10; i++){
            liczby.add(rand.nextDouble(-100,100));
        }
        return liczby;
    }
}
