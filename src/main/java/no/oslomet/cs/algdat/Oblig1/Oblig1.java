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

//    public static void main(String[] args) {
//        char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
//        rotasjon(a, -3);
//        System.out.println(Arrays.toString(a));
//    }

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
        //Håndtere tomme strenger
        if (s.length == 0) {
            return "";
        }

        //finne lengden på lengste ord
        int ordlengde = s[0].length();
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() > ordlengde) {
                ordlengde = s[i].length();
            }
        }

        //loope gjennom alle ordene n antall ganger
        //hvor n er ordlengde på lengste ord
        String ut = "";
        for (int bokstav = 0; bokstav < ordlengde; bokstav++) {
            for (int ord = 0; ord < s.length; ord++) {
                if (bokstav < s[ord].length()) {
                    ut += s[ord].charAt(bokstav);
                }
            }
        }
        return ut;
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        if (a.length == 0) return a;

        int[] indeks = new int[a.length];

        int[] sortert = Arrays.copyOf(a, a.length);
        Arrays.sort(sortert);

        for (int i = 0; i < indeks.length; i++){
            for (int j = 0; j < a.length; j++){
                if (a[j] == sortert[i]){
                    indeks[i] = j;
                }
            }
        }
        return indeks;
    }

    public static void main(String[] args) {
        int[] a = {6,10,16,11,7,12,3,9,8,5};
        int[] indeks = indekssortering(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(indeks));
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        if (a.length < 3){
            throw new NoSuchElementException();
        }

        // Finne maks (jeg ville egentlig ikke gjøre dette, men
        int maks = 0;
        for (int i = 0; i < a.length; i++){
            if ( a[i] > maks) maks = a[i];
        }

        int[] b = new int[3];
        int min = maks;
        int nestMin = maks;
        int tredjeMin = maks;

        int minIndeks = 0;
        int nestMinIndeks = 0;
        int tredjeMinIndeks = 0;

        // Minste
        for (int i = 0; i < a.length; i++){
            if (a[i] < min){
                min = a[i];
                minIndeks = i;
            }
        }

        // Nest minste
        for (int i = 0; i < a.length; i++){
            if ((a[i] <= nestMin) && i != minIndeks){
                nestMin = a[i];
                nestMinIndeks = i;
            }
        }

        // Tredje minste
        for (int i = 0; i < a.length; i++){
            if ((a[i] <= tredjeMin) && i != minIndeks && i != nestMinIndeks){
                tredjeMin = a[i];
                tredjeMinIndeks = i;
            }
        }

        b[0] = minIndeks;
        b[1] = nestMinIndeks;
        b[2] = tredjeMinIndeks;
        return b;
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  // Oblig1
