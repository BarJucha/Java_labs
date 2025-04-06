public class Main {
    public Main() {
    }

    public static void main(String[] var0) {
        try {
            GraWojna var1 = new GraWojna();
            var1.symuluj();
        } catch (BrakKartException e) {
            System.out.println(e.getMessage());
        }
    }
}
