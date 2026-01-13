public class MergeSort {

    // O(n)
    public static void diviser(int[] t, int[] t1, int[] t2, int n) {
        int i = 0, j = 0;
        int m = n / 2;

        for (; i < m; i++)
            t1[i] = t[i];

        for (; i < n; i++, j++)
            t2[j] = t[i];
    }

    // O(n)
    public static void fusionner(int[] t, int[] t1, int[] t2, int n) {
        int i = 0, j = 0, k = 0;
        int m1 = n / 2;
        int m2 = n - m1;

        while (i < m1 && j < m2) t[k++] = (t1[i] < t2[j]) ? t1[i++] : t2[j++];

        while (i < m1) t[k++] = t1[i++];

        while (j < m2) t[k++] = t2[j++];
    }

    public static void triFusion(int[] t, int n) {
        if (n > 1) {
            int m1 = n / 2;
            int m2 = n - m1;

            int[] t1 = new int[m1];
            int[] t2 = new int[m2];

            diviser(t, t1, t2, n);
            triFusion(t1, m1);
            triFusion(t2, m2);
            fusionner(t, t1, t2, n);
        }
    }

    public static void main(String[] args) {
        int[] t = {10, 2, 5, 1, 8, 3, 7, 6, 4, 9};
        int n = t.length;

        triFusion(t, n);

        for (int i = 0; i < n; i++) System.out.print(t[i] + " ");
    }


}
