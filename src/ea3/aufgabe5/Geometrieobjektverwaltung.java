package ea3.aufgabe5;

public class Geometrieobjektverwaltung {
    public static void main(String[] args) {
        Geometrieobjekt geometrieobjekt = null;

        if (args[0].equals("Kreis"))
            geometrieobjekt = new Kreis();
        if (args[0].equals("Bogenstueck"))
            geometrieobjekt = new Bogenstueck();
        if (args[0].equals("Rechteck"))
            geometrieobjekt = new Rechteck();


        if (geometrieobjekt == null) {
            System.out.println("Ein " + args[0]
                    + " ist bisher nicht implementiert");
        } else {
            geometrieobjekt.druckeEigenschaften();
        }
    }
}

class Geometrieobjekt {
    public void druckeEigenschaften() {
        System.out.println("Ein ist ein geometrisches Objekt");
    }
}

class Kreis extends Geometrieobjekt {
    @Override
    public void druckeEigenschaften() {
        System.out.println("Das Objekt ist punktsymmetrisch und geschlossen");
    }
}

class Bogenstueck extends Geometrieobjekt {
    @Override
    public void druckeEigenschaften() {
        System.out.println("Das Objekt ist nicht punktsymmetrisch und nicht geschlossen");
    }
}

class Rechteck extends Geometrieobjekt {
    @Override
    public void druckeEigenschaften() {
        System.out.println("Das Objekt ist punktsymmetrisch und geschlossen");
    }
}

