package Controlador;

import Vista.VentanaAdministracion;

public class AdminController {

    static VentanaAdministracion vAdmin;

    private void crearVentana(){
        vAdmin = new VentanaAdministracion(
            java.awt.Toolkit.getDefaultToolkit().getScreenSize().width,
            (java.awt.Toolkit.getDefaultToolkit().getScreenSize().height-30),
            "../Imagenes/iconos/adminIcon.png");
    }

    public VentanaAdministracion getVentana(){
        if(vAdmin == null){
            crearVentana();
        }
        return vAdmin;
    }

}