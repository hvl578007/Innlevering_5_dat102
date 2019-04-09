package no.hvl.dat102;

/**
 * Oppg_d
 */
public class Oppg_d {

    public static void main(String[] args) {
        Student a = new Student(100, "Stian");
        Student b = new Student(100, "Stian");
        Student c = a;

        System.out.println("a:" + a.hashCode());
        System.out.println("b:" + b.hashCode());
        System.out.println("c:" + c.hashCode());
    }
}