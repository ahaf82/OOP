package ea3.aufgabe2;

public class Dienstgradausgabe {
    private Object Dienstgrade;

    /*
     * Erwartete Ausgabe ist:
     *
     * Helfer
     * Truppfuehrer
     * Gruppenfuehrer
     * Zugtruppfuehrer
     * Zugfuehrer
     * false
     * true
     * false
     *
     */
    public static void main(String[] args) {
        printAll();
        // System.out.println(HELFER.istVorgesetzterVor(GRUPPENFUEHRER));
//        System.out.println(TRUPPFUEHRER.istVorgesetzterVor(HELFER));
//        System.out.println(GRUPPENFUEHRER.istVorgesetzterVor(GRUPPENFUEHRER));
    }

    void printAll() {
        System.out.println(Dienstgrade);
    }
}
