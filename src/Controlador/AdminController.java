package Controlador;

import Vista.VentanaAdministracion;

public class AdminController {

    VentanaAdministracion vAdmin;

    public void crearVentana(){
        new VentanaAdministracion(
            java.awt.Toolkit.getDefaultToolkit().getScreenSize().width,
            (java.awt.Toolkit.getDefaultToolkit().getScreenSize().height-30),
            "../Imagenes/iconos/adminIcon.png");
    }

}