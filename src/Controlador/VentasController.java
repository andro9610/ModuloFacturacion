package Controlador;

import Vista.VentanaVentas;

public class VentasController {

    VentanaVentas vVentas;

    public void crearVentana(){
        new VentanaVentas(
            java.awt.Toolkit.getDefaultToolkit().getScreenSize().width,
            (java.awt.Toolkit.getDefaultToolkit().getScreenSize().height-30),
            "../Imagenes/iconos/vendorIcon.png");
    }

}