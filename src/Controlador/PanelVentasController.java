package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.Herramientas.panelMaker;

public class PanelVentasController implements ActionListener {
    
    /**Paneles de la interfaz */
    panelMaker panelCrearFactura,
        panelBuscarFactura,
        panelCrearCotizacion,
        panelBuscarCotizacion,
        panelGestionClientes;


    public void setPaneles(panelMaker panelCrearFactura,
        panelMaker panelBuscarFactura,
        panelMaker panelCrearCotizacion,
        panelMaker panelBuscarCotizacion,
        panelMaker panelGestionClientes){
        
            this.panelCrearFactura = panelCrearFactura;
            this.panelBuscarFactura = panelBuscarFactura;
            this.panelCrearCotizacion = panelCrearCotizacion;
            this.panelBuscarCotizacion = panelBuscarCotizacion;
            this.panelGestionClientes = panelGestionClientes;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "crearFactura":
                break;
            case "buscarFactura":
                break;
            case "crearCotizacion":
                break;
            case "buscarCotizacion":
                break;
            case "gestionarClientes":
                break;
            case "logOut":
                System.out.println("Saliendo");
                break;
            default:
                System.out.println("Accion no soportada");
        }

    }

}