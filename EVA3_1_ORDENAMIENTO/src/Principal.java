
import java.util.Scanner;


public class Principal {

    
    public static void main(String[] args) {
        int[] miArreglo = new int[20];
        llenar(miArreglo);
        imprimir(miArreglo);
        long ini, fin;
        ini = System.nanoTime();
        selectionSort(miArreglo);
        fin = System.nanoTime();
        imprimir(miArreglo);
        System.out.println("Tiempo = " + (fin - ini));
        
        /*llenar(miArreglo);
        imprimir(miArreglo);
        ini = System.nanoTime();
        insertionSort(miArreglo);
        fin = System.nanoTime();
        imprimir(miArreglo);
        System.out.println("Tiempo = " + (fin - ini));
        
        llenar(miArreglo);
        imprimir(miArreglo);
        ini = System.nanoTime();
        bubbleSort(miArreglo);
        fin = System.nanoTime();
        imprimir(miArreglo);
        System.out.println("Tiempo = " + (fin - ini));
        
        llenar(miArreglo);
        imprimir(miArreglo);
        ini = System.nanoTime();
        quickSort(miArreglo);
        fin = System.nanoTime();
        imprimir(miArreglo);
        System.out.println("Tiempo = " + (fin - ini));*/
        
        Scanner input = new Scanner(System.in);
        System.out.println("valor a buscar");
        int iVal = input.nextInt();
        System.out.println("Posición: " + busquedaBin(miArreglo, iVal));
    }
    
    public static void llenar(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random() * 100);
        }
    }
    
    public static void imprimir(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }
    
    public static void selectionSort(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            int min = i;
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[min]) {
                    min = j;
                }
            }
            int itemp = arreglo[i];
            arreglo[i] = arreglo[min];
            arreglo[min] = itemp;
        }
    }
    
    public static void insertionSort(int[] arreglo){
        for (int i = 1; i < arreglo.length; i++) {
            int temp = arreglo[i];
            int insP;
            for (insP = i; insP > 0; insP--) {
                int prev = insP - 1;
                if (arreglo[prev] > temp) {
                    arreglo[insP] = arreglo[prev];
                } else {
                    break;
                }
            }
            arreglo[insP] = temp;
        }
    }
    
    public static void bubbleSort(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int iTemp= arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = iTemp;
                }
            }
        }
    }
    
    public static void quickSort(int[] arreglo){
        quickSortRec(arreglo, 0, arreglo.length - 1);
    }
    
    private static void quickSortRec(int[] arreglo, int ini, int fin){
        if((ini < fin) && (ini >= 0) && (fin < arreglo.length)){
            int iPiv = ini;
            int too_big = ini + 1;
            int too_small = fin;
            int iTemp;
            while(too_big < too_small){
                while((too_big < fin) && (arreglo[too_big] < arreglo[iPiv])){
                    too_big++;
                }
                while((too_small > (ini + 1)) && (arreglo[too_small] > arreglo[iPiv])){
                    too_small--;
                }
                if (too_big < too_small) {
                    iTemp = arreglo[too_big];
                    arreglo[too_big] = arreglo[too_small];
                    arreglo[too_small] = iTemp;
                }
            }
            iTemp = arreglo[iPiv];
            arreglo[iPiv] = arreglo[too_small];
            arreglo[too_small] = iTemp;
            quickSortRec(arreglo, ini, too_small - 1);
            quickSortRec(arreglo, too_small + 1, fin);
        }
    }
    
    public static int busquedaBin(int[] arreglo, int val){
        return busquedaBinRec(arreglo, val, 0, arreglo.length - 1);
    }
    
    private static int busquedaBinRec(int[] arreglo, int val, int ini, int fin){
        if (ini <= fin){
            int mid = ini + ((fin - ini) / 2);
            if (val == arreglo[mid]) {
                return mid;
            } else  if (val > arreglo[mid]){
                return busquedaBinRec(arreglo, val, mid + 1, fin);
            } else {
                return busquedaBinRec(arreglo, val, ini, mid - 1);
            }
        } else {
           return -1;
        }
    }
    
}
