package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Vista.Herramientas.inputMaker;
import Vista.Herramientas.panelMaker;
import Vista.Herramientas.passwordMaker;

import Vista.VentanaLogin;

import Modelo.operacionesLogin;

public class LoginController implements ActionListener {

    static VentanaLogin vLogin;

    /** Elementos clon */
    inputMaker usuario;
    passwordMaker contraseña;
    panelMaker panelInformativo;

    String user, pass;

    /**
     * Metodo para pasar todo lo que necesita el controlador para hacerse funcional
     */
    public void setCampos(inputMaker campoUsuario, passwordMaker campoContraseña,panelMaker panelInformativo) {
        this.usuario = campoUsuario;
        this.contraseña = campoContraseña;
        this.panelInformativo = panelInformativo;
    }

    /** Metodo para crear una nueva ventana */
    private void crearVentana() {
        vLogin = new VentanaLogin(360, 640, "../Imagenes/iconos/iconoApp.png");
    }

    public VentanaLogin getVentana(){
        if (vLogin == null){
            crearVentana();
        }
        return vLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "login":
                user = usuario.getValue();
                pass = contraseña.getValue();
                try {
                    String tipoUsuario = new operacionesLogin().validarCredenciales(user, pass);
                    switch(tipoUsuario){
                        case "VENDEDOR":
                        vLogin.dispose();
                        new VentasController().getVentana();
                        break;
                        case "ADMINISTRADOR":
                        vLogin.dispose();
                        new AdminController().getVentana();
                        break;
                        default:
                        panelInformativo.setVisible(true);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
            case "cerrar":
                System.exit(0);
                break;
            default:
                System.out.println("Accion no soportada");
        }

    }
}