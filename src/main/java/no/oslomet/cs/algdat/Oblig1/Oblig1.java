package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if(a.length == 0){
            throw new NoSuchElementException("Listen er tom!");
        }
        for(int i = 0; i < a.length-1; i++)
            if(a[i] > a[i+1]){
                int tmp = a[i];
                a[i] = a[i+1];
                a[i+1] = tmp;
            }
        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) {
        if(a.length == 0){
            throw new NoSuchElementException("Listen er tom!");
        }
        int antOmbyttinger = 0;
        for(int i = 0; i < a.length-1; i++)
            if(a[i] > a[i+1]){
                int tmp = a[i];
                a[i] = a[i+1];
                a[i+1] = tmp;
                antOmbyttinger++;
            }
        return antOmbyttinger;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        if (a.length == 0){
            return 0;
        }
        int ulike = 1;
        for(int i = 1; i < a.length; i++){
            if(a[i] < a[i-1]){
                throw new IllegalStateException();
            }
            if(a[i] > a[i-1]){
                ulike++;
            }
        }
        return ulike;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        if (a.length == 0) {
            return 0;
        }

        int count = 1;
        for (int i = 1; i < a.length; i++) {
            int j;
            for (j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    break;
                }
            }
            if (i == j) {
                count++;
            }
        }
        return count;
    }


    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        if (a.length <= 1){
            return;
        }
        int v = 0;
        int h = a.length - 1;

        // Flytt oddetall/partall
        for (int i = 0; i < a.length - 1; i++) {
            for (; a[v] % 2 != 0; v++) {
                System.out.println(v);
            }
            for (; (a[h] % 2 == 0) && h > 0; h--) {
                System.out.println(h);
            }
            if (v < h) {
                int tmp = a[v];
                a[v] = a[h];
                a[h] = tmp;
            } else break;
        }

        int i = 0;
        for (; (a[i] % 2 != 0) && (i < a.length); i++){
            for (int j = i+1; (a[j] % 2 != 0) && (j < a.length); j++) {
                if (a[j-1] > a[j]) {
                    int tmp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = tmp;
                }
            }
        }
        for (; (a[i] % 2 == 0) && (i < a.length); i++){
            for (int j = i+1; (a[j] % 2 == 0) && (j < a.length); j++) {
                if (a[j-1] > a[j]) {
                    int tmp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new UnsupportedOperationException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  // Oblig1
