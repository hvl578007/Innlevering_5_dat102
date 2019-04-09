package no.hvl.dat102;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * Oppg_e
 */
public class Oppg_e {

    public static void main(String[] args) {

        int antElement = 100000;
        int antSoek = 10000;
        int maksVerdi = 1000000;
        
        HashSet<Integer> hashTab = new HashSet<Integer>();
        Integer[] intTab = new Integer[antElement];

        int tal = 376;
        //legg til tal i tabell(ane)
        for (int i = 0; i < antElement; i++) {
            intTab[i] = tal;
            hashTab.add(tal);
            tal = (tal + 45713) % maksVerdi;
        }

        Integer[] soekIntTab = new Integer[antSoek];
        Random tilfeldig = new Random();
        //gererer 10000 tilfeldige tal:
        for (int i = 0; i < antSoek; i++) {
            soekIntTab[i] = tilfeldig.nextInt(maksVerdi);
        }

        //sorterer Integer-tabellen:
        Arrays.sort(intTab);

        //søker i HashSet:
        int fantTalHashSet = 0;
        Instant foer = Instant.now();
        for (int i = 0; i < antSoek; i++) {
            if(hashTab.contains(soekIntTab[i])) {
                fantTalHashSet++;
            }
        }
        Instant etter = Instant.now();
        Duration tidHashSet = Duration.between(foer, etter);

        //søker i Integer-tabell:
        int fantTalTabell = 0;
        Instant foer2 = Instant.now();
        for (int i = 0; i < antSoek; i++) {
            if(Arrays.binarySearch(intTab, soekIntTab[i]) >= 0) {
                fantTalTabell++;
            }
        }
        Instant etter2 = Instant.now();
        Duration tidTabell = Duration.between(foer2, etter2);

        System.out.println("Antall element: " + antElement + " Antall element som blir søkt etter: " + antSoek);
        System.out.println("Tid HashSet: " + tidHashSet + ". Tal på gangar det ein søkte etter blei funne: " + fantTalHashSet);
        System.out.println("Tid tabell: " + tidTabell + ". Tal på gangar det ein søkte etter blei funne: " + fantTalTabell);
    }    
}