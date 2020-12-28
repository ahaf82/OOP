/*
package ea3.aufgabe4;

class Fahrzeug { */
/* ... *//*
 }

class Personenwagen extends Fahrzeug { */
/* ... *//*
 }

class Smart extends Personenwagen { */
/* ... *//*
 }

class Lastwagen extends Fahrzeug { */
/* ... *//*
 }

class Mercedes extends Lastwagen { */
/* ... *//*
 }

class Crash {
    void adac_testen(Fahrzeug a, Lastwagen d) { */
/* ... *//*

    } // Deklaration #1

    void adac_testen(Personenwagen b, Fahrzeug a) { */
/* ... *//*

    } // Deklaration #2

    void adac_testen(Smart c, Lastwagen d) { */
/* ... *//*

    } // Deklaration #3

    public static void main(String[] args) {

    }

    CrashTest() {
        Fahrzeug a = new Fahrzeug();
        Personenwagen b = new Personenwagen();
        Smart c = new Smart();
        Lastwagen d = new Lastwagen();
        Mercedes e = new Mercedes();

        adac_testen(a, d); // Aufruf #1 ruft die erste Deklaration mit den Typen Fahrzeug a und Lastwagen d auf
        adac_testen(c, a); // Aufruf #2 ruft Deklaration 2 auf, Smart C spezialisiert Typ Personenwagen b und Fahrzeug a passt genau
        adac_testen(c, e); // Aufruf #3 ruft Deklaration 3 auf, Smart c passt vom Typ her ganau, Typ e spezialisiert Typ d Lastwagen
        adac_testen(b, d); // Aufruf #4 hat Probleme, 1 und 2 gleichh valide daher da für den speziellen Typen die Methode 3 aufgerufen werden müsste. Dafür ist aber Personenwagentyp b für den geforderten Smart Typ c zu ungenau.
    }
}
*/
