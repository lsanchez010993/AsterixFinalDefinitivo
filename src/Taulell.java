public class Taulell {
private int columnes;
private int files;
private static  char [][] taulell;

    public Taulell(int columnes, int files) {
        this.columnes = columnes;
        this.files = files;
    }
    public void dibu() {
        for (int i = 0; i < files; ++i) {
            for (int j = 0; j < columnes; ++j) {
                System.out.print(" " + taulell[i][j] + " ");
            }
            System.out.println();
        }
    }
    void init(Pocio p, Jugador jug, Enemic[] enemics){
        for (int i = 0; i < files; ++i) {
            for (int j = 0; j < columnes; ++j) {
                if (i == 0 || j == 0 || i == files -1 || j == columnes - 1) taulell[i][j] = '#';
                else taulell[i][j] = ' ';
            }
        }
        taulell[p.coord.fila][p.coord.columna] = p.nom;
        taulell[jug.coord.fila][jug.coord.columna] = jug.nom;
        for (Enemic e: enemics) {
            taulell[e.coord.fila][e.coord.columna] = e.nom;
        }
    }


}
