import java.util.HashSet;

public class Arrays {
    
    // Soit une suite de clés dans une liste L de N entiers tous différents et appartenant à l’intervalle [1..N]. Par
    // exemple pour N= 8, L = [5, 8, 2, 6, 3, 4, 1, 7]
    
    /**
     * 1. Ecrire la fonction verifierListe qui vérifie que les éléments de la liste appartiennent à l’intervalle
     * [1..N] et sont tous différents.
     * 
     * @param L
     * @param N
     * @return
     */
    public static boolean verifierListe(int[] L, int N) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : L) {
            // verifie si x est dans l'intervalle [1..N]
            if (x < 1 || x > N) return false;
            // verifie si x et deja existe dans le set 
            if (set.contains(x)) {
                return false;
            }
            set.add(x);
        }
        return true;
    }

    // Calcule la complexite temporelle et spatiale de la fonction verifierListe
    // Complexite temporelle : O(N)
    // Complexite spatiale : O(N)

    public static void main(String[] args) {
        int[] L = {5, 8, 2, 6, 3, 4, 1, 7};
        int N = 8;
        System.out.println(verifierListe(L, N));
    }
}
