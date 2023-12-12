package es.ieslavereda;

import com.diogonunes.jcolor.Attribute;

public enum Color {
    ROJO(Attribute.RED_TEXT()),
    NEGRO(Attribute.WHITE_TEXT());

    private Attribute atColor;

    //Contructores
    Color (Attribute atColor){
        this.atColor = atColor;
    }

    //Getters
    public Attribute getAtColor() {
        return atColor;
    }
}
