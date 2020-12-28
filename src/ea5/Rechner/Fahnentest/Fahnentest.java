package ea5.Rechner.Fahnentest;

import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.sql.SQLOutput;
import java.util.*;

class Fahnenmast {
    Fahnenposition fahnenStatus;
    ArrayList<Fahnenbeobachter> beobachter = new ArrayList<Fahnenbeobachter>();

    public void addFahnenbeobachter(Fahnenbeobachter neuerbeobachter) {
        // Hinzufuegen eines Fahnenbeobachters. Um die Beobachter zu verwalten,
        // koennte eine java.util.ArrayList dienen.
        beobachter.add(neuerbeobachter);
    }

    public void removeFahnenbeobachter(Fahnenbeobachter neuerbeobachter) {
        // Entfernen eines Fahnenbeobachters.
        beobachter.remove(neuerbeobachter);
    }

    public void setStatus(Fahnenposition fahnenposition) {
        // Aendern des Fahnenstatus. Die Fahnenbeobachter sollten hierueber
        // informiert werden.
        this.fahnenStatus=fahnenposition;
        for (Fahnenbeobachter achter: beobachter)
            achter.fahnenstatusGeaendert(this);;
    }

    public Fahnenposition getFahnenposition() {
        // Zurueckgeben der aktuellen Fahnenposition
        return this.fahnenStatus;
    }
}

enum Fahnenposition {
    OBEN, HALBMAST, UNBEFLAGGT;
}

// Der View
class Tourist implements Fahnenbeobachter {
    private String name = "Unbekannt";

    public Tourist(String name) {
        this.name = name;
    }

    @Override
    public void fahnenstatusGeaendert(Fahnenmast fahnenmast) {
        System.out.println(name + " vermeldet fuer den Fahnenmast: "
                + fahnenmast.getFahnenposition());
    }
}

interface Fahnenbeobachter {
    // Interfaces sollte man so schlank wie moeglich halten.
    // Welche Methode(n) wird/werden benoetigt?
    public void fahnenstatusGeaendert(Fahnenmast fahnenmast);
}

class Fahnenbedienung {
    private Fahnenmast fahnenmast;

    public Fahnenbedienung(Fahnenmast fahnenmast) {
        this.fahnenmast = fahnenmast;
    }

    public void aendereBeflaggung(Fahnenposition fahnenposition) {
        fahnenmast.setStatus(fahnenposition);
    }
}

public class Fahnentest {
    public static void main(String[] args) {

        Fahnenmast meinFahnenmast = new Fahnenmast();

        Fahnenbedienung bedienung1 = new Fahnenbedienung(meinFahnenmast);
        Fahnenbedienung bedienung2 = new Fahnenbedienung(meinFahnenmast);

        Fahnenbeobachter anna = new Tourist("Anna");
        Fahnenbeobachter bernd = new Tourist("Bernd");
        Fahnenbeobachter charly = new Tourist("Charly");

        bedienung1.aendereBeflaggung(Fahnenposition.OBEN);

        meinFahnenmast.addFahnenbeobachter(bernd);

        /* Hier Teilaufgabe d) */

        // anonyme Klasse
        meinFahnenmast.addFahnenbeobachter(new Fahnenbeobachter() {
            @Override
            public void fahnenstatusGeaendert(Fahnenmast fahnenmast) {
                System.out.println("Michael vermeldet für den Fahnenmast: " + fahnenmast.getFahnenposition());
            }
        });

        // Methodenreferenz
        meinFahnenmast.addFahnenbeobachter((fahnenmast) -> {
            System.out.println("Sabine" + " vermeldet fuer den Fahnenmast: "
                            + fahnenmast.getFahnenposition());
        });

        bedienung1.aendereBeflaggung(Fahnenposition.HALBMAST);

        meinFahnenmast.addFahnenbeobachter(anna);
        meinFahnenmast.addFahnenbeobachter(charly);
        meinFahnenmast.removeFahnenbeobachter(bernd);

        bedienung2.aendereBeflaggung(Fahnenposition.UNBEFLAGGT);
        bedienung2.aendereBeflaggung(Fahnenposition.OBEN);


        meinFahnenmast.addFahnenbeobachter(bernd);
    }
}
