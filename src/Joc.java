import java.util.Scanner;

public class Joc {
    private static Jugador asterix;
    private static Taulell bosc;
    static final int COLUMNES = 20;
    static final int FILES = 20;
    private static boolean fi;
    private static Enemic[] legionaris;
    private static Pocio pocio;
    private static Scanner scan;

    public Joc() {
    }
    public static boolean mouEnemics() {
        int dir;
        for (int i = 0; i < legionaris.length; ++i) {
            // TODO: s'haurien de moure cap l'Asterix
            dir = (int)(Math.random() * 4);
            switch(dir) {
                case 0:
                    legionaris[i].mouL();
                    break;
                case 1:
                    legionaris[i].mouR();
                    break;
                case 2:
                    legionaris[i].mouU();
                    break;
                case 3:
                    legionaris[i].mouD();
                    break;
            }
        }
        return false;
    }

    public static boolean mouJugador() {
        char op;

        do {
            System.out.println("A - Left");
            System.out.println("D - Right");
            System.out.println("W - Up");
            System.out.println("S - Down");
            System.out.println("Z - Exit");
            op = scan.nextLine().toUpperCase().charAt(0);
        } while(!(op == 'A' || op == 'D' || op == 'W' || op == 'S' || op == 'Z'));

        switch(op) {
            case 'A':
                asterix.mouL();
                break;
            case 'D':
                asterix.mouR();
                break;
            case 'W':
                asterix.mouU();
                break;
            case 'S':
                asterix.mouD();
                break;
        }

        return op == 'Z';
    }

    public static Coordenades posicioAleatoria() {
        return new Coordenades(1, FILES - 2, 1, COLUMNES - 2);
    }

    public static void main(String[] args) {
        bosc = new Taulell(FILES, COLUMNES);
        pocio = new Pocio('P', posicioAleatoria());
        asterix = new Jugador('J', posicioAleatoria());
        for (int i = 0; i < legionaris.length; ++i) {
            legionaris[i] = new Enemic((char)('1' + i), posicioAleatoria());
        }
        fi = false;

        do {
            bosc.init(pocio, asterix, legionaris);
            bosc.dibu();
            fi = mouJugador();
            if (!fi) fi = mouEnemics();
        } while(!fi);
    }
    }

