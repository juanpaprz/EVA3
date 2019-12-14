
import java.util.Comparator;
import java.util.LinkedList;


public class Principal {

    public static void main(String[] args) {
        LinkedList<Integer> iLista = new LinkedList<Integer>();
        for (int i = 0; i < 15; i++) {
            iLista.add((int) Math.random() * 100);
        }
        LinkedList<String> listaStr = new LinkedList<String>();
        listaStr.add("HOLA");
        listaStr.add(" ");
        listaStr.add("MUNDO");
        listaStr.add(" ");
        listaStr.add("CRUEL");
        listaStr.add("!!");
        Comparator cmpStr = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                String cade1 = (String) o1;
                String cade2 = (String) o2;
                char c1 = cade1.charAt(0);
                char c2 = cade2.charAt(0);
                return c1 - c2;
            }
        };
        System.out.println(listaStr);
        listaStr.sort(cmpStr);
        System.out.println(listaStr);
    }
}
