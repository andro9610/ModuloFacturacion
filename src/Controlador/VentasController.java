package Controlador;

import Vista.VentanaVentas;

public class VentasController {

    static VentanaVentas vVentas;

    private void crearVentana(){
        vVentas = new VentanaVentas(
            java.awt.Toolkit.getDefaultToolkit().getScreenSize().width,
            (java.awt.Toolkit.getDefaultToolkit().getScreenSize().height-30),
            "../Imagenes/iconos/vendorIcon.png");
    }

    public VentanaVentas getVentana(){
        if(vVentas == null){
            crearVentana();
        }
        return vVentas;
    }

}