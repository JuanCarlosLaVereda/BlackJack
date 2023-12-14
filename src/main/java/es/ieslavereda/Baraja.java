package es.ieslavereda;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baraja {
    private Carta[] baraja;

    //Constructor
    public Baraja(){
        baraja = new Carta[Palo.values().length*NumCarta.values().length];
        int posicion = 0;
        for (Palo palo: Palo.values()) {
            for (NumCarta tipoCarta:NumCarta.values()){
                baraja[posicion] = new Carta(tipoCarta,palo);
                posicion++;
            }
        }
        shuffle();
    }

    //Metodos
    private void shuffle(){
        List<Carta> listCarta = Arrays.asList(baraja);
        Collections.shuffle(listCarta);
        listCarta.toArray(baraja);
    }
    public Carta repartirPrimera(){
        Carta carta = null;
        if(baraja.length>0){
            carta = baraja[0];
            baraja = Arrays.copyOfRange(baraja, 1, baraja.length);
            return carta;
        }
        return carta;
    }
    public Carta repartirUltima(){
        Carta carta = null;
        if (baraja.length>0){
            carta = baraja[baraja.length-1];
            baraja = Arrays.copyOfRange(baraja, 0, baraja.length-1);
            return carta;
        }
        return carta;
    }

    //Override
    @Override
    public String toString(){
        return Arrays.toString(baraja);
    }
}
