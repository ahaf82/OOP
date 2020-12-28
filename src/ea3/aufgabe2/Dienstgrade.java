package ea3.aufgabe2;

public enum Dienstgrade {
    HELFER, TRUPPFUEHRER, GRUPPENFUEHRER, ZUGTRUPPFUEHRER, ZUGFUEHRER;

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
        System.out.println(HELFER.istVorgesetzterVor(GRUPPENFUEHRER));
        System.out.println(TRUPPFUEHRER.istVorgesetzterVor(HELFER));
        System.out.println(GRUPPENFUEHRER.istVorgesetzterVor(GRUPPENFUEHRER));
    }

    @Override
    public String toString() {
        String val = super.toString();
        return val.charAt(0) + val.substring(1).toLowerCase();
    }

    public static void printAll() {
        for (Dienstgrade grad: Dienstgrade.values()) {
            System.out.println(grad.toString());
        }
    }

    public boolean istVorgesetzterVor(Dienstgrade grad) {
        return this.ordinal() > grad.ordinal();
    }

}
