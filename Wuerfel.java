// Für mich ergaben sich aus der Aufgabenstellung zwei mögliche Deutungen,
// was die "Anzahl der Wiederholungen" bedeutet.
// 1. Anzahl der Würfe
// 2. Anzahl der Durchführungen des Experiments 
//    (1 Durchführung = x-mal Werfen, bis Gewinnfolge erreicht ist.)
// Plausibler erschien mir die zweite Deutung, diese ist unten implementiert.
// Damit erhalte ich auch ähnliche Ergebnisse wie im Beispiel.

public class Wuerfel {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please enter three arguments");
            System.exit(-1);
        }
        int N = Integer.parseInt(args[0]), K = Integer.parseInt(args[1]), S = Integer.parseInt(args[2]);
        // Integer, dass Anzahl notwendiger Würfe speichert.
        // Zu Beginn war dies ein Array, der für jede Wiederholung einen neuen Wert speichert.
        // Da am Ende aber für die Berechnung des Durchschnitts 
        // alle Werte addiert werden müssen, kann dies von Beginn an getan werden.
        int log = 0;
        //Schleife, die die S Wiederholungen durchgeht.
        for (int s = 0; s < S; ++s) {
            // Integer, das zählen soll, wie oft N hintereinander erhalten wurde
            int N_counter = 0;
            // Durchführung des Experiments
            // Experiment endet, wenn Gewinnfolge erreicht (vgl. Kommentar oben)
            while (N_counter < K) {
                // Erzeugung der zufälligen Augenzahl des Würfels
                int wurf = (int) (Math.random() * N) + 1;
                // Ein Wurf mehr -> log muss um eins erhöht werden
                log++;
                // Wenn N gewürfelt -> N_counter erhöht sich
                if (wurf == N) {N_counter++;}
                // Wenn nicht N gewürfelt -> N_counter zurückgesetzt
                else {N_counter = 0;}
            }
        }
        // Durchschnittsberechnung: Summe der Werte wurde schon vorher gebildet,
        // also nur noch durch Anzahl teilen.
        float durchschnitt = (float) (log) / S;
        System.out.println(durchschnitt);
        }
    }

// Für N = 6 und K = 2 ist meine Vermutung nach einigem Austesten, dass es kein S gibt, 
// ab dem das Ergebnis sich nur noch in der Nachkommastelle ändert.