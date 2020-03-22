package Vista.Herramientas;

import java.awt.Color;

public class colorMaker{

    public Color obtainColor(String nameColor) {
        switch(nameColor){
            case("blanco"):
                return new Color(255, 255, 255);
            /**Fuentes de escala verde */
            case("verdeEnfasisMedio"):
                return new Color(16,137,62);
            case("verdeEnfasisOscuro"):
                return new Color(0,100,0);    
            /**Fuentes de escala rojo */
            case("rojoEnfasisMedio"):
                return new Color(204,51,51);
            case("rojoEnfasisOscuro"):
                return new Color(128, 1, 1);
            /**Fuentes de escala azul */    
            case "azulEnfasisMedio":
                return new Color(23,104,208);
            case "azulEnfasisOscuro":
                return new Color(7,62,132);
            /**Fuentes en escala amarillo */
            case "amarilloEnfasisMedio":
                return new Color(255,185,0);
            case "amarilloEnfasisOscuro":
                return new Color(224,165,46);    
            /**Fuentes en escala de grises */    
            case("grisEnfasisClaro"):
                return new Color(222, 222, 222);
            case("grisEnfasisMedio"):
                return new Color(209, 209, 209);
            case("grisEnfasisOscuro"):
                return new Color(74, 74, 74);
            /**Fuentes transparentes (Experimental) */    
            case("transparenteEnfasisOscuro"):
                return new Color(0,0,0,215);
            /**Fuentes con degradadoTransparente */
            case("colorAdministrador"):
                return new Color (40,0,100,205);
            case("colorVendedor"):
                return new Color (0,70,14,215);
            /**Fuente invisible, para eliminar el fondo */ 
            case("invisible"):
                return new Color(0,0,0,0);   
            default:
                return new Color(0, 0, 0);

        }
    }

}