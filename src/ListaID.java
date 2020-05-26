import java.util.NoSuchElementException;

class Nodo{
    int value;

    Nodo next;

    public Nodo(int value) {

        this.value = value;
    }
}

public class ListaID {
    private Nodo root;
    private int size;
    private  Nodo actual;
    public void add(int x){
        Nodo n = new Nodo(x);
        n.next= root;
        root = n;
        size++;
    }
    public int get(int pos){
        if (pos < 0 || pos >= size){
            throw new NoSuchElementException();
        }
        Nodo p = root;
        for (int i = 0; i < pos; i++) {
            p=p.next;
        }
        return p.value;
    }
    public boolean contains(int x){
        return false;
    }

    public  boolean isEmpty(){
        return size == 0;
    }

    public int size() {
        return size;
    }
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("[");
        Nodo p = root;
        /*asi como esta el root se rompe, hayq ue suar un auxiliar:
        * while(root != null){
        * result.append(root.value);
        * result.append(", ");
        * root = root.next;
        * bad code!!!!*/
        while (p != null){
            result.append(p.value);
            result.append(",");
            p = p.next;
        }

        result.append("]");
        return result.toString();
    }
    public static void main(String[] args) {
        ListaID l = new ListaID();
        l.add(3);
        l.add(5);
        System.out.println(l.toString());
    }
    public void start(){
        actual = root;

    }
    public boolean hasNext(){
        return actual != null;
    }
    public int next(){
        int value = actual.value;
        actual = actual.next;
        return value;
    }
}


