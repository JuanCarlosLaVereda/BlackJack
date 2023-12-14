package es.ieslavereda;

import java.util.Arrays;

public class Jugador {
    private String nombre_jugador;
    private Carta[] mano;

    //Constructor
    public Jugador(String nombre_jugador){
        this.nombre_jugador = nombre_jugador;
        mano = new Carta[0];
    }

    //Getters
    public String getNombre_jugador() {
        return nombre_jugador;
    }
    public int getPuntuacion(){
        int puntos = 0;
        for (Carta carta:mano) {
            puntos = puntos+carta.getNumero().getValor()[0];
        }
        return puntos;
    }

    //Metodos
    public void addCarta(Carta carta){
        mano = Arrays.copyOf(mano, mano.length+1);
        mano[mano.length-1] = carta;
    }

    //Override
    @Override
    public String toString(){
        return nombre_jugador + " mano: " + Arrays.toString(mano) + " puntuacion: " + getPuntuacion();
    }
}
