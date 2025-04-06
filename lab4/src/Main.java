public class Main {
    public static void main(String[] args) {

        List<Object> lista = new List<>();
        for (int i = 1; i <= 5; i++) {
            lista.add(i);
        }
        System.out.println(lista.size());
        for(int i=0;i<5;i++){
            System.out.println(lista.get(i));
        }
    }
}