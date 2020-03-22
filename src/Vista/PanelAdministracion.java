package Vista;

import Vista.Herramientas.buttonMenuMaker;
import Vista.Herramientas.colorMaker;
import Vista.Herramientas.fontMaker;
import Vista.Herramientas.imageMaker;
import Vista.Herramientas.labelMaker;
import Vista.Herramientas.panelMaker;

import java.awt.Color;

import Controlador.PanelAdministracionController;

public class PanelAdministracion {

    /**Panel que contiene todos los elementos del menu */
    panelMaker panelMenu;

    buttonMenuMaker botonCrearReporte,
        botonGestionarProductos,
        botonGestionarClientes,
        botonGestionarUsuarios,
        botonLogOut;

    /**Variables globales de la clase */
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    int alto = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().height-30);

    /**Panel que contiene las opciones administrativas */
    private void crearPanelAdministracion(){
        panelMenu = new panelMaker(
            0,0,(int)(ancho*0.162),alto,
            new colorMaker().obtainColor("colorAdministrador")
        );

        /**Creacion titulo ventana */
        labelMaker tituloAdministrador = 
            new labelMaker(
                "Administrador",
                (int)(ancho*0.0109), (int)(alto*0.0364),
                (int)(ancho*0.15), (int)(alto*0.0507),
                new colorMaker().obtainColor("blanco"),
                new fontMaker().obtainFont("fuenteTitulo")
        );

        /**Creacion subtitulos de seccion */
        labelMaker subTituloReporte = new labelMaker(
            "Reporte",
            (int)(ancho*0.0329), (int)(alto*0.1458),
            (int)(ancho*0.0754), (int)(alto*0.0442),
            new colorMaker().obtainColor("blanco"),
            new fontMaker().obtainFont("fuenteSubtitulo")
        );

        labelMaker subTituloProductos = new labelMaker(
            "Productos",
            (int)(ancho*0.0329), (int)(alto*0.2434),
            (int)(ancho*0.0959), (int)(alto*0.0442),
            new colorMaker().obtainColor("blanco"),
            new fontMaker().obtainFont("fuenteSubtitulo")
        );

        labelMaker subTituloClientes = new labelMaker(
            "Clientes",
            (int)(ancho*0.0329), (int)(alto*0.3502),
            (int)(ancho*0.0754), (int)(alto*0.0442),
            new colorMaker().obtainColor("blanco"),
            new fontMaker().obtainFont("fuenteSubtitulo")
        );

        labelMaker subTituloUsuarios = new labelMaker(
            "Usuarios",
            (int)(ancho*0.0329), (int)(alto*0.4479),
            (int)(ancho*0.0754), (int)(alto*0.0442),
            new colorMaker().obtainColor("blanco"),
            new fontMaker().obtainFont("fuenteSubtitulo")
        );
        /**Creacion de imagenes acompañantes*/
        imageMaker imagenReporte = 
            new imageMaker(
                (int)(ancho*0.0109), (int)(alto*0.1523),
                (int)(ancho*0.0175), (int)(alto*0.0312),
                "../../Imagenes/iconos/reporteIcon.png"
        );

        imageMaker imagenProductos = 
            new imageMaker(
                (int)(ancho*0.0109), (int)(alto*0.25),
                (int)(ancho*0.0175), (int)(alto*0.0312),
                "../../Imagenes/iconos/productoIcon.png"
        );

        imageMaker imagenClientes = 
            new imageMaker(
                (int)(ancho*0.0109), (int)(alto*0.3567),
                (int)(ancho*0.0175), (int)(alto*0.0312),
                "../../Imagenes/iconos/ClienteIcon.png"
        );

        imageMaker imagenUsuarios = 
            new imageMaker(
                (int)(ancho*0.0109), (int)(alto*0.4505),
                (int)(ancho*0.0175), (int)(alto*0.0312),
                "../../Imagenes/iconos/UsuarioIcon.png"
        );
        /**Creacion de botones */
        Color panelColor = new colorMaker().obtainColor("colorAdministrador");
        Color[] focusedColor = {
            new colorMaker().obtainColor("blanco"),
            new colorMaker().obtainColor("blanco")
        };

        botonCrearReporte = 
            new buttonMenuMaker(
                "Crear",
                (int)(ancho*0.0336), (int)(alto*0.1966),
                (int)(ancho*0.0951), (int)(alto*0.0312),
                focusedColor,
                panelColor,
                new fontMaker().obtainFont("fuenteBotonesMenu"),
                "../../Imagenes/iconos/nuevoIcon.png"
        );

        botonGestionarProductos =
            new buttonMenuMaker(
                "Gestionar",
                (int)(ancho*0.0336), (int)(alto*0.3033),
                (int)(ancho*0.0951), (int)(alto*0.0312),
                focusedColor,
                panelColor,
                new fontMaker().obtainFont("fuenteBotonesMenu"),
                "../../Imagenes/iconos/gestionarIcon.png"
        );

        botonGestionarClientes = 
            new buttonMenuMaker(
                "Gestionar",
                (int)(ancho*0.0336), (int)(alto*0.4010),
                (int)(ancho*0.0951), (int)(alto*0.0312),
                focusedColor,
                panelColor,
                new fontMaker().obtainFont("fuenteBotonesMenu"),
                "../../Imagenes/iconos/gestionarIcon.png"
        );

        botonGestionarUsuarios =
            new buttonMenuMaker(
                "Gestionar",
                (int)(ancho*0.0336), (int)(alto*0.4986),
                (int)(ancho*0.0951), (int)(alto*0.0312),
                focusedColor,
                panelColor,
                new fontMaker().obtainFont("fuenteBotonesMenu"),
                "../../Imagenes/iconos/gestionarIcon.png"
        );

        botonLogOut =
            new buttonMenuMaker(
                "Cerrar sesion",
                (int)(ancho*0.0336), (int)(alto*0.9309),
                (int)(ancho*0.1151), (int)(alto*0.0312),
                focusedColor,
                panelColor,
                new fontMaker().obtainFont("fuenteBotonesMenu"),
                "../../Imagenes/iconos/logoutIcon.png"
        );
        /**Añadido de elementos al panel */
        panelMenu.add(tituloAdministrador);
        panelMenu.add(imagenReporte);
        panelMenu.add(subTituloReporte);
        panelMenu.add(botonCrearReporte);
        panelMenu.add(imagenProductos);
        panelMenu.add(subTituloProductos);
        panelMenu.add(botonGestionarProductos);
        panelMenu.add(imagenClientes);
        panelMenu.add(subTituloClientes);
        panelMenu.add(botonGestionarClientes);
        panelMenu.add(imagenUsuarios);
        panelMenu.add(subTituloUsuarios);
        panelMenu.add(botonGestionarUsuarios);
        panelMenu.add(botonLogOut);
        /**Añadiendo controlador al panel */
        addController();
    }

    protected void addController(){
        PanelAdministracionController buttonAction = new PanelAdministracionController();
        
        botonCrearReporte.addActionListener(buttonAction);
        botonGestionarProductos.addActionListener(buttonAction);
        botonGestionarClientes.addActionListener(buttonAction);
        botonGestionarUsuarios.addActionListener(buttonAction);
        botonLogOut.addActionListener(buttonAction);

        botonCrearReporte.setActionCommand("crearReporte");
        botonGestionarProductos.setActionCommand("gestionarProductos");
        botonGestionarClientes.setActionCommand("gestionarClientes");
        botonGestionarUsuarios.setActionCommand("gestionarUsuarios");
        botonLogOut.setActionCommand("logOut");
    }
    
    public panelMaker getPanel(){
		if(panelMenu == null){
            crearPanelAdministracion();
        }
        return panelMenu;
    }

}
