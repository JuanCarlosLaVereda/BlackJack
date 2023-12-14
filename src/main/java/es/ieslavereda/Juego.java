package es.ieslavereda;

public class Juego {
    private Jugador[] jugadores;
    private Jugador jugadorPC;
    private Baraja baraja;

    //Constructores
    public Juego(Jugador[] jugadores){
        baraja = new Baraja();
        this.jugadores = jugadores;
        jugadorPC = new Jugador("BANCA");
    }

    //Metodos
    public void start(){
        //repartir las 2 cartas
        for (Jugador jugador: jugadores) {
            juegaJugador();
        }
        juegaPC(jugadorPC);
    }
    public void juegaJugador(){

    }
    public void juegaPC(Jugador jugadorPC){

    }

}
