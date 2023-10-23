import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] var0) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ile symulacji: ");
        int liczbaSymulacji = scanner.nextInt();
        for(int i=0; i<liczbaSymulacji; i++){
            try {
                GraWojna var1 = new GraWojna();
                var1.symuluj();
            } catch (BrakKartException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
