package Vista.Herramientas;

import java.awt.Font;

public class fontMaker{
    public Font obtainFont(String fontName){
        switch(fontName){
            /**Para entradas de texto y contraseñas */
            case "fuenteInput":
                return new Font("Caviar Dreams",Font.PLAIN,14);
            /**Fuente unica para el boton de cierre en la pantalla de login */
            case "fuenteBotonCerrar":
                return new Font("Caviar Dreams",Font.PLAIN,10);
            /**Fuente para los botones del sistema */
            case "fuenteBotones":
                return new Font("Caviar Dreams",Font.PLAIN,14);
            /**Fuente para las entradas del menu principal de opciones de vendedor o administrador */
            case "fuenteBotonesMenu":
                return new Font("Caviar Dreams",Font.PLAIN,20);
            /**Fuente para los titulos de cada formulario de la aplicacion */    
            case "fuenteTitulo":
                return new Font("Caviar Dreams",Font.BOLD,31);
            /**Fuente para las listas desplegables de los formularios */
            case "fuenteListaDesplegable":
                return new Font("Caviar Dreams",Font.PLAIN,14);            
            /**Fuente para las tablas de la aplicacion */    
            case "fuenteTituloTabla":
                return new Font("Caviar Dreams",Font.BOLD,14);
            case "fuenteItemTabla":
                return new Font("Caviar Dreams",Font.PLAIN,14);
            /**Fuente para los avisos de la parte inferior de la pantalla */    
            case "fuenteTextoEmergente":
                return new Font("Caviar Dreams",Font.PLAIN,14);
            /**Fuente de subtitulos */    
            case "fuenteSubtitulo":
                return new Font("Caviar Dreams",Font.BOLD,27);
            default:
                return new Font("Caviar Dreams",Font.PLAIN,15);
        }
    }
}