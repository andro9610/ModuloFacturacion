package Vista;

import Vista.Herramientas.buttonMaker;
import Vista.Herramientas.colorMaker;
import Vista.Herramientas.fontMaker;
import Vista.Herramientas.imageMaker;
import Vista.Herramientas.inputMaker;
import Vista.Herramientas.labelMaker;
import Vista.Herramientas.panelMaker;
import Vista.Herramientas.passwordMaker;

import java.awt.Color;

import Controlador.LoginController;

public class PanelLogin {


    /**Elementos de la interfaz */
    panelMaker panelLogin;

    buttonMaker botonCerrar,botonLogin;

    inputMaker campoUsuario;
    passwordMaker campoContraseña;

    panelMaker panelInformativo;

    private void crear(){
        panelLogin = new panelMaker(
            0, 0, 360, 640,
            new colorMaker().obtainColor("transparente")
        );

        /**---------------------------------------- */
        /**Creacion de elementos graficos */
        Color[] botonLoginNormalColor = {
            new colorMaker().obtainColor("azulEnfasisMedio"),
            new colorMaker().obtainColor("blanco")
        };

        Color[] botonLoginFocusColor = {
            new colorMaker().obtainColor("azulEnfasisOscuro"),
            new colorMaker().obtainColor("blanco")
        };

        Color[] botonCerrarNormalColor = {
            new colorMaker().obtainColor("invisible"),
            new colorMaker().obtainColor("blanco")
        };

        Color[] botonCerrarFocusColor = {
            new colorMaker().obtainColor("rojoEnfasisMedio"),
            new colorMaker().obtainColor("blanco")
        };

        /**Creacion de componentes */
        botonLogin = new buttonMaker(
            "Iniciar sesion",
            120, 474, 120, 32,
            botonLoginNormalColor,
            botonLoginFocusColor,
            new fontMaker().obtainFont("fuenteBotones"),
            new fontMaker().obtainFont("fuenteBotones")
        );

        botonCerrar = new buttonMaker(
            "X", 
            319, 1, 40, 40,
            botonCerrarNormalColor,
            botonCerrarFocusColor,
            new fontMaker().obtainFont("fuenteBotonCerrar"),
            new fontMaker().obtainFont("fuenteBotonCerrar")
        );

        campoUsuario = new inputMaker(
            32, 344, 296, 32,
            new colorMaker().obtainColor("azulEnfasisMedio"),
            new colorMaker().obtainColor("grisEnfasisOscuro"),
            new fontMaker().obtainFont("fuenteInput")
        );

        campoContraseña = new passwordMaker(
            32, 405, 296, 32,
            new colorMaker().obtainColor("azulEnfasisMedio"),
            new colorMaker().obtainColor("grisEnfasisOscuro"),
            new fontMaker().obtainFont("fuenteInput")
        );

        /** Creacion de recursos multimedia */
        imageMaker panelImagen  = new imageMaker(
            115, 120, 140, 140,
            "../../Imagenes/defaultUserImage.png"
        );
        
        /** Creacion de elementos de ayuda */
        panelMaker labelUsuario = new panelMaker(
            32, 320, 52, 19,
            new colorMaker().obtainColor("invisible")
        );

        labelUsuario.add(
            new labelMaker(
                "Usuario",
                0,0,52,19,
                new colorMaker().obtainColor("blanco"),
                new fontMaker().obtainFont("fuenteTextoEmergente")
            )
        );

        panelMaker labelContraseña = new panelMaker(
            32, 381, 70, 19,
            new colorMaker().obtainColor("invisible")
        );

        labelContraseña.add(
            new labelMaker(
                "Contraseña",
                0,0,70,19,
                new colorMaker().obtainColor("blanco"),
                new fontMaker().obtainFont("fuenteTextoEmergente")
            )
        );

        panelInformativo = new panelMaker(
            0,610,640,30,
            new colorMaker().obtainColor("rojoEnfasisOscuro")
        );

        panelInformativo.add(
            new labelMaker(
                "Verifique sus credenciales e intentelo de nuevo",
                36,0,360,30,
                new colorMaker().obtainColor("blanco"),
                new fontMaker().obtainFont("fuenteTextoEmergente")
                )
            );
        panelInformativo.setVisible(false);
        /**---------------------------------------- */
        panelLogin.add(panelImagen);
        panelLogin.add(labelUsuario);
        panelLogin.add(campoUsuario);
        panelLogin.add(labelContraseña);
        panelLogin.add(campoContraseña);
        panelLogin.add(botonLogin);
        panelLogin.add(botonCerrar);
        panelLogin.add(panelInformativo);

        addController();
        campoUsuario.isFocusOwner();
    }

    public panelMaker getPanel(){
        if(panelLogin == null){
            crear();
        }
        return panelLogin;
    }

    protected void addController() {
        LoginController buttonActionController  = new LoginController();
        buttonActionController.setCampos(campoUsuario,campoContraseña,panelInformativo);

        botonLogin.addActionListener(buttonActionController);
        botonCerrar.addActionListener(buttonActionController);

        botonLogin.setActionCommand("login");
        botonCerrar.setActionCommand("cerrar");
    }

}