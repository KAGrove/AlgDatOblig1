package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.Arrays;
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
        if (a.length <= 1) {
            return;
        }
        int v = 0;
        int h = a.length - 1;

        // Flytt oddetall/partall
        while(true){
            for (; (a[v] % 2 != 0) && (v < a.length - 1); v++) {
            }
            for (; (a[h] % 2 == 0) && h > 0; h--) {
            }
            if (v < h) {
                int tmp = a[v];
                a[v] = a[h];
                a[h] = tmp;
            } else break;
        }

        // Spesialtilfeller
        if(a[v] % 2 != 0) {v++;}

        // Oddetall først og fremst
        if (v > 1)
            kvikksortering0(a, 0, v-1);

        // Kun partall
        if (a[a.length-1] % 2 == 0)
            kvikksortering0(a, v, a.length-1);
    }

    // Resten er programkode fra kompendiet
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    private static int parter0(int[] a, int v, int h, int skilleverdi)
    {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }

    private static int sParter0(int[] a, int v, int h, int indeks)
    {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h - 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }

    private static void kvikksortering0(int[] a, int v, int h)  // en privat metode
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = sParter0(a, v, h, (v + h)/2);  // bruker midtverdien
        kvikksortering0(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }

//    public static void main(String[] args) {
//        int[] a = {7,5,9,13,3};
//        delsortering(a);
//        System.out.println(Arrays.toString(a));
//    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        if(a.length <= 1) return;

        char tmp1 = a[0];
        char tmp2 = 'A';
        for(int i = 1; i < a.length; i++){
            tmp2 = a[i];
            a[i] = tmp1;
            tmp1 = tmp2;
        }
        a[0] = tmp2;
    }

//    public static void rotasjonTall(int[] a) {
//        int tmp1 = a[0];
//        int tmp2 = 0;
//        for(int i = 1; i < a.length; i++){
//            tmp2 = a[i];
//            a[i] = tmp1;
//            tmp1 = tmp2;
//        }
//        a[0] = tmp2;
//    }

//    public static void main(String[] args) {
//        char[] a = {'A', 'B', 'C', 'D'};
//        rotasjon(a);
//        System.out.println(Arrays.toString(a));
//    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        if(a.length <= 1) return;

        // Snur hele arrayet
        for (int i = 0; i < a.length/2; i++){
            char tmp = a[i];
            a[i] = a[a.length-1-i];
            a[a.length-1-i] = tmp;
        }

        if(k < 0){
            k = a.length+k;
        }
        // Snur det første
        for (int i = 0; i < k/2; i++){
            char tmp = a[i];
            a[i] = a[k-1-i];
            a[k-1-i] = tmp;
        }

        // Snur det andre
        for (int i = 0; k+i <= a.length-1; k++, i++){
            char tmp = a[k];
            a[k] = a[a.length-1-i];
            a[a.length-1-i] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        rotasjon(a, -3);
        System.out.println(Arrays.toString(a));
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        char[] resultat = new char[a.length+b.length];
        int a_indeks = 0;
        int b_indeks = 0;

        int i = 0;
        while (i < (a.length+b.length)){
            if (a.length != 0 && a_indeks < a.length){
                resultat[i] = a[a_indeks];
                a_indeks++;
                i++;
            }

            if (b.length != 0 && b_indeks < b.length){
                resultat[i] = b[b_indeks];
                b_indeks++;
                i++;
            }

        }

        String flett = String.valueOf(resultat);
        return flett;
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
