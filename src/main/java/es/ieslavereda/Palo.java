package es.ieslavereda;

import static com.diogonunes.jcolor.Ansi.colorize;

public enum Palo {
    TREBOL("\u2663", Color.NEGRO),
    PICA("\u2660", Color.NEGRO),
    ROMBO("\u2666", Color.ROJO),
    CORAZON("\u2665", Color.ROJO);

    private String typeOf;
    private Color color;

    //Constructores
    Palo(String typeOf, Color color){
        this.typeOf = typeOf;
        this.color = color;
    }

    //Override
    @Override
    public String toString(){
        return colorize(typeOf,color.getAtColor());
    }
}
