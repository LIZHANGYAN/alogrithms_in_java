package elementary_sorts;

/**
 * Cr  eated by starsea on 17-10-18.
 */
public class InsertionSort {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i< N; i++){
            for (int j=i; j>0; j--){
                if(less(a[i],a[j-1]))
                    exch(a,i,j-1);
                else
                    break;
            }
        }
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int min){
        Comparable swap = a[i];
        a[i] = a[min];
        a[min] = a[i];
    }
}
