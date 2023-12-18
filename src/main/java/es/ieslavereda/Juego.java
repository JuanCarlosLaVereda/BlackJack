package es.ieslavereda;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

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
        for (Jugador jugador:jugadores) {
            repartoInicial(jugador);
        }
        repartoInicial(jugadorPC);

        for (Jugador jugador: jugadores) {
            juegaJugador(jugador);
        }
        juegaPC(jugadorPC);
    }

    private void repartoInicial(Jugador jugador) {
        jugador.addCarta(baraja.repartirPrimera());
        jugador.addCarta(baraja.repartirPrimera());
    }

    public void juegaJugador(Jugador jugador){
        System.out.println(colorize("Turno del jugador: " + jugador.getNombre_jugador(), Attribute.BLUE_TEXT()));
        System.out.println(jugador);
        String opcion = Input.getOption("Quieres coger otra carta? (YES/NO): ");
        while (opcion.equals("Y") && jugador.getPuntuacion()>=0) {
            System.out.println(colorize("Repartiendo carta...", Attribute.MAGENTA_TEXT()));
            esperar(1000);
            jugador.addCarta(baraja.repartirPrimera());
            System.out.println(jugador);
            if (jugador.getPuntuacion() >= 0) {
                opcion = Input.getOption("Quieres coger otra carta? (YES/NO): ");
            } else {
                System.out.println(colorize("Te has pasado!!", Attribute.RED_TEXT()));
            }
        }
    }

    private int maxPuntuacionJugadores(){
        int maxPuntuacion = Integer.MIN_VALUE;
        for (Jugador jugador:jugadores) {
            if (jugador.getPuntuacion()>maxPuntuacion) {
                maxPuntuacion = jugador.getPuntuacion();
            }
        }
        return maxPuntuacion;
    }

    public void juegaPC(Jugador jugadorPC){
        System.out.println(colorize("Turno de la banca.", Attribute.GREEN_TEXT()));
        System.out.println(jugadorPC);
        int maxPuntuacion = maxPuntuacionJugadores();
        while (jugadorPC.getPuntuacion()>=0 && jugadorPC.getPuntuacion()<maxPuntuacion){
            System.out.println(colorize("Repartiendo carta...", Attribute.MAGENTA_TEXT()));
            esperar(1000);
            jugadorPC.addCarta(baraja.repartirPrimera());
            System.out.println(jugadorPC);
            if (jugadorPC.getPuntuacion()<0){
                System.out.println(colorize("Se ha pasado la banca.", Attribute.RED_TEXT()));
            }
        }
    }

    private void esperar(int tiempoMili){
        try {
            Thread.sleep(tiempoMili);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void mostrarGanador(){
        int maxPuntuacion = maxPuntuacionJugadores();
        if (maxPuntuacion<=jugadorPC.getPuntuacion()){
            System.out.println("GANA LA BANCA!!");
        }else {
            int numGanadores = 0;
            String[] ganadores = new String[jugadores.length];
            for (Jugador jugador:jugadores) {
                if (jugador.getPuntuacion()== maxPuntuacion){
                    ganadores[numGanadores++] = jugador.getNombre_jugador();
                }
            }
            for (int i=0; i<numGanadores; i++){
                System.out.println("GANADOR: " + ganadores[i]);
            }
        }

    }

}
