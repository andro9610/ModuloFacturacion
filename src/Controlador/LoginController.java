package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.Herramientas.windowMaker;
import Vista.Herramientas.inputMaker;
import Vista.Herramientas.passwordMaker;

import Vista.VentanaLogin;

public class LoginController implements ActionListener {

    public windowMaker vLogin;

    /**Elementos clon */
    inputMaker usuario;
    passwordMaker contraseña;

    String user,pass;

    /**Metodo para pasar todo lo que necesita el controlador para hacerse funcional */
    public void setCampos(inputMaker campoUsuario, passwordMaker campoContraseña){
        this.usuario = campoUsuario;
        this.contraseña = campoContraseña;
    }

    /**Metodo para crear una nueva ventana */
    public void crearVentana(){
        vLogin = new VentanaLogin(360, 640, "../Imagenes/iconos/iconoApp.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "login":
                user = usuario.getValue();
                pass = contraseña.getValue();
                //new AdminController().crearVentana();
                //new VentasController().crearVentana();
                break;
            case "cerrar":
                System.exit(0);
                break;
            default:
                System.out.println("Accion no soportada");
        }

    }
}