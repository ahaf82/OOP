package ea4.aufgabe2;

import java.lang.Comparable;

class Obst <T extends Comparable> {
};

class Apfel extends Obst {
    private final int weight;

    Apfel(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }
}

class Birne extends Obst {
    private final int weight;

    Birne(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }
}

public class TestMaximumContainer {
    public static void main(String[] args) {
        MaximumContainer heaviest = new MaximumContainer();
        Apfel Apfel1 = new Apfel(34);
        Apfel Apfel2 = new Apfel(45);
        Apfel Apfel3 = new Apfel(43);
        Birne Birne1 = new Birne(32);
        Birne Birne2 = new Birne(37);
        Birne Birne3 = new Birne(38);

        heaviest.store(Apfel1.getWeight());
        heaviest.store(Apfel2.getWeight());
        heaviest.store(Apfel3.getWeight());
        heaviest.store(Birne1.getWeight());
        heaviest.store(Birne2.getWeight());
        heaviest.store(Birne3.getWeight());

        System.out.println("Schwerstes Objekt: ");
        System.out.println("Es wiegt: " + heaviest.get() +"kg");

    }

}
