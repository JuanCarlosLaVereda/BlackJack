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
/*    public int getPuntuacion(){
        int puntos = 0;
        for (Carta carta:mano) {
            puntos = puntos+carta.getNumero().getValor()[0];
        }
        return (puntos>21?-1:puntos);
    }*/

    public int getPuntuacion(){
        return getPuntuacionRecursiva(0,0);
    }

    private int getPuntuacionRecursiva(int index, int suma){
        if (suma>21){
            return -1;
        }
        if (index==mano.length){
            return suma;
        }

        if (mano[index].getNumero().getValor().length ==1){
            return getPuntuacionRecursiva(index+1,suma+mano[index].getNumero().getValor()[0]);
        }
        return Math.max(
                getPuntuacionRecursiva(index+1,suma+mano[index].getNumero().getValor()[0]),
                getPuntuacionRecursiva(index+1,suma+mano[index].getNumero().getValor()[1])
        );
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
