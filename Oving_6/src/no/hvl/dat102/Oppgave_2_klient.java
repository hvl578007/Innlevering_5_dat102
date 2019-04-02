package no.hvl.dat102;

import no.hvl.dat102.bst.*;
import java.util.*;
/**
 * Oppgave_2_klient
 */
public class Oppgave_2_klient {

    public static void main(String[] args) {
        Random tilfeldig = new Random();

        int talPaaTre = 100;
        int talPaaNoder = 8192;

        KjedetBinaerSokeTre<Integer>[] bstTab = (KjedetBinaerSokeTre<Integer>[]) new KjedetBinaerSokeTre[talPaaTre];

        for (int i = 0; i < talPaaTre; i++) {
            bstTab[i] = new KjedetBinaerSokeTre<Integer>();

            for (int x = 0; x < talPaaNoder; x++) {
                Integer tal = tilfeldig.nextInt();
                bstTab[i].leggTil(tal);
            }
        }

        System.out.println("Tal på noder: " + talPaaNoder);
        System.out.println("Min teoretisk høgde: " + minTeoretiskHogdeBST(talPaaNoder));
        System.out.println("Maks teoretisk høgde: " + (talPaaNoder-1));

        int minHogde = talPaaNoder;
        int maksHogde = 0;
        int totHogde = 0;
        for (int i = 0; i < talPaaTre; i++) {
            int hogde = bstTab[i].hogde();
            if(hogde < minHogde) {
                minHogde = hogde;
            }
            if(hogde > maksHogde) { //else if?
                maksHogde = hogde;
            }
            totHogde += hogde;
        }

        System.out.println("Min høgde: " + minHogde + "\nMaks høgde: " + maksHogde);
        double gjnSnitthogde = (1.0*totHogde) / talPaaTre;
        System.out.println("Gjennomsnittleg høgde: " + gjnSnitthogde + ", rundaAv = " + Math.round(gjnSnitthogde));
    }

    public static int minTeoretiskHogdeBST(int n) {
        return (int)(Math.ceil(Math.log(n)/Math.log(2)));
    }
}