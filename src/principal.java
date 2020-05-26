import java.util.Random;

public class principal {
    public static void main(String[] args) {
        ListaID l = new ListaID();
        Random random = new Random();
        for (int i = 0; i <10000000 ; i++) {
            l.add(random.nextInt(500));
        }
        long suma = 0;
        l.start();
        while (l.hasNext()){
            suma += l.next();
        }
        System.out.println("la suma es: "+suma);
    }
}
