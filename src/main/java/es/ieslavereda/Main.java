package es.ieslavereda;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
/*        System.out.println(Palo.TREBOL);
        for (Palo palo: Palo.values()) {
            System.out.println(palo);
        }

        Baraja baraja = new Baraja();
        System.out.println(baraja);*/

        int numero_jugadores = 0;
        while (numero_jugadores<1 || numero_jugadores>6) {
            numero_jugadores = Input.getInteger("Cuantos jugadores van a jugar (Sin incluir la banca, entre 1-5)");
        }

        Jugador[] jugadores = new Jugador[numero_jugadores];

        for (int i=0; i<jugadores.length; i++){
            jugadores[i] = new Jugador(Input.getString("Nombre del " + (i+1) +  "º jugador: "));
        }

        Juego juego = new Juego(jugadores);
        juego.start();
        juego.mostrarGanador();

    }
}