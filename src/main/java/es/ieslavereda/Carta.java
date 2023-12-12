package es.ieslavereda;

public class Carta {
    private NumCarta numero;
    private Palo palo;

    //Constructores
    public Carta(NumCarta numero, Palo palo){
        this.numero = numero;
        this.palo = palo;
    }

    //Getters
    public NumCarta getNumero() {
        return numero;
    }
    public Palo getPalo() {
        return palo;
    }

    //Override
    @Override
    public String toString(){
        return numero.toString()+palo;
    }
}
