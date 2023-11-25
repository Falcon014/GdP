public class Caesar {
    public static void main(String[] args) {
        //Einlesen des Schlüssels und Erstellung eines Alphabet-Arrays mit Groß- und Kleinbuchstaben
        if (args.length < 2) {
            System.out.println("Please enter a key (integer) and at least one string to be converted.");
            System.exit(-1);
        }
        int k = Integer.parseInt(args[0]);
        char[] alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz".toCharArray();

        //Schleife, die jeden String aus dem Input durchgeht
        for (int index = 1; index < args.length; ++index) {
            //String aus dem Input auslesen
            char[] string_to_convert = args[index].toCharArray();
            //Erstellung eines leeren Strings, wird später mit den umgewandelten Zeichen gefüllt
            String string_converted = "";
            //Schleife, die jedes Zeichen im String durchgeht
            for (char character : string_to_convert) {
                //Schleife, die das Zeichen mit denen aus dem Alphabet-Array abgleicht
                for (int i = 0; i < 52; ++i) {
                    if (character == alphabet[i]) {
                        //Grunlegend muss auf den alten Index der Schlüssel addiert werden, um den neuen Index zu erhalten.
                        //Hier k*2, denn es sind zwei ineinander verschachtelte Alphabete (Groß u. klein)
                        //Nutzung der Modulo-Funktion, um zyklische Verschiebung zu erreichen
                        string_converted += alphabet[(i+2*k)%52];
                        break;
                    }
                    //Für den Fall, dass das Zeichen nicht gefunden wurde: Einfach beibehalten
                    if (i == 51) {
                        string_converted += character;
                    }
                }
            }
            //Ausgabe des umgewandelten Strings
            System.out.println(string_converted);
        }

    }
}
