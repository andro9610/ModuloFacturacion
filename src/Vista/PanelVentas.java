package Vista;

import Vista.Herramientas.buttonMenuMaker;
import Vista.Herramientas.colorMaker;
import Vista.Herramientas.fontMaker;
import Vista.Herramientas.imageMaker;
import Vista.Herramientas.labelMaker;
import Vista.Herramientas.panelMaker;

import java.awt.Color;

import Controlador.PanelVentasController;


public class PanelVentas {

    /**Panel que contiene todos los elementos del menu */
    panelMaker panelMenu;

    buttonMenuMaker botonCrearFactura,
        botonBuscarFactura,
        botonCrearCotizacion,
        botonBuscarCotizacion,
        botonGestionarClientes,
        botonLogOut;

    /**Variables globales de la clase */
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    int alto = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().height-30);

    /**Panel que contiene las opciones administrativas */
    private void crearPanelAdministracion(){
        panelMenu = new panelMaker(
            0,0,(int)(ancho*0.162),alto,
            new colorMaker().obtainColor("colorVendedor")
        );

        /**Creacion titulo ventana */
        labelMaker tituloVendedor = 
            new labelMaker(
                "Vendedor",
                (int)(ancho*0.0109), (int)(alto*0.0364),
                (int)(ancho*0.15), (int)(alto*0.0507),
                new colorMaker().obtainColor("blanco"),
                new fontMaker().obtainFont("fuenteTitulo")
        );

        /**Creacion subtitulos de seccion */
        labelMaker subTituloFactura = new labelMaker(
            "Factura",
            (int)(ancho*0.0329), (int)(alto*0.1458),
            (int)(ancho*0.1068), (int)(alto*0.0442),
            new colorMaker().obtainColor("blanco"),
            new fontMaker().obtainFont("fuenteSubtitulo")
        );

        labelMaker subTituloCotizacion = new labelMaker(
            "Cotizacion",
            (int)(ancho*0.0329), (int)(alto*0.3007),
            (int)(ancho*0.1068), (int)(alto*0.0442),
            new colorMaker().obtainColor("blanco"),
            new fontMaker().obtainFont("fuenteSubtitulo")
        );

        labelMaker subTituloClientes = new labelMaker(
            "Clientes",
            (int)(ancho*0.0329), (int)(alto*0.4557),
            (int)(ancho*0.1068), (int)(alto*0.0442),
            new colorMaker().obtainColor("blanco"),
            new fontMaker().obtainFont("fuenteSubtitulo")
        );

        /**Creacion de imagenes acompañantes*/
        imageMaker imagenFactura = 
            new imageMaker(
                (int)(ancho*0.0109), (int)(alto*0.1523),
                (int)(ancho*0.0175), (int)(alto*0.0312),
                "../../Imagenes/iconos/facturaIcon.png"
        );

        imageMaker imagenCotizacion = 
            new imageMaker(
                (int)(ancho*0.0109), (int)(alto*0.3072),
                (int)(ancho*0.0175), (int)(alto*0.0312),
                "../../Imagenes/iconos/cotizacionIcon.png"
        );

        imageMaker imagenClientes = 
            new imageMaker(
                (int)(ancho*0.0109), (int)(alto*0.4648),
                (int)(ancho*0.0175), (int)(alto*0.0312),
                "../../Imagenes/iconos/ClienteIcon.png"
        );
        /**Creacion de botones */
        Color panelColor = new colorMaker().obtainColor("colorVendedor");
        Color[] focusedColor = {
            new colorMaker().obtainColor("blanco"),
            new colorMaker().obtainColor("blanco")
        };

        botonCrearFactura = 
            new buttonMenuMaker(
                "Crear",
                (int)(ancho*0.0336), (int)(alto*0.1966),
                (int)(ancho*0.0951), (int)(alto*0.0312),
                focusedColor,
                panelColor,
                new fontMaker().obtainFont("fuenteBotonesMenu"),
                "../../Imagenes/iconos/nuevoIcon.png"
        );

        botonBuscarFactura =
            new buttonMenuMaker(
                "Buscar",
                (int)(ancho*0.0336), (int)(alto*0.2434),
                (int)(ancho*0.0951), (int)(alto*0.0312),
                focusedColor,
                panelColor,
                new fontMaker().obtainFont("fuenteBotonesMenu"),
                "../../Imagenes/iconos/buscarIcon.png"
        );

        botonCrearCotizacion = 
            new buttonMenuMaker(
                "Crear",
                (int)(ancho*0.0336), (int)(alto*0.3515),
                (int)(ancho*0.0951), (int)(alto*0.0312),
                focusedColor,
                panelColor,
                new fontMaker().obtainFont("fuenteBotonesMenu"),
                "../../Imagenes/iconos/nuevoIcon.png"
        );

        botonBuscarCotizacion =
            new buttonMenuMaker(
                "Buscar",
                (int)(ancho*0.0336), (int)(alto*0.3984),
                (int)(ancho*0.0951), (int)(alto*0.0312),
                focusedColor,
                panelColor,
                new fontMaker().obtainFont("fuenteBotonesMenu"),
                "../../Imagenes/iconos/buscarIcon.png"
        );

        botonGestionarClientes =
        new buttonMenuMaker(
            "Gestionar",
            (int)(ancho*0.0336), (int)(alto*0.5065),
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
        panelMenu.add(tituloVendedor);
        panelMenu.add(imagenFactura);
        panelMenu.add(subTituloFactura);
        panelMenu.add(botonCrearFactura);
        panelMenu.add(botonBuscarFactura);
        panelMenu.add(imagenCotizacion);
        panelMenu.add(subTituloCotizacion);
        panelMenu.add(botonCrearCotizacion);
        panelMenu.add(botonBuscarCotizacion);
        panelMenu.add(imagenClientes);
        panelMenu.add(subTituloClientes);
        panelMenu.add(botonGestionarClientes);
        panelMenu.add(botonLogOut);

        /**Añadiendo controlador al panel */
        addController();
    }

    protected void addController(){
        PanelVentasController buttonAction = new PanelVentasController();

        botonCrearFactura.addActionListener(buttonAction);
        botonBuscarFactura.addActionListener(buttonAction);
        botonCrearCotizacion.addActionListener(buttonAction);
        botonBuscarCotizacion.addActionListener(buttonAction);
        botonGestionarClientes.addActionListener(buttonAction);
        botonLogOut.addActionListener(buttonAction);

        botonCrearFactura.setActionCommand("crearFactura");
        botonBuscarFactura.setActionCommand("buscarFactura");
        botonCrearCotizacion.setActionCommand("crearCotizacion");
        botonBuscarCotizacion.setActionCommand("buscarCotizacion");
        botonGestionarClientes.setActionCommand("gestionarClientes");
        botonLogOut.setActionCommand("logOut");
    }
    
    public panelMaker getPanel(){
		if(panelMenu == null){
            crearPanelAdministracion();
        }
        return panelMenu;
    }

}
