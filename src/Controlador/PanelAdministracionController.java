package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.Herramientas.panelMaker;

public class PanelAdministracionController implements ActionListener {
    
    /**Paneles de la interfaz */
    panelMaker panelCrearReporte,
        panelGestionProductos,
        panelGestionClientes,
        panelGestionUsuarios;

    public void setPaneles(panelMaker panelCrearReporte,
        panelMaker panelGestionProductos,
        panelMaker panelGestionClientes,
        panelMaker panelGestionUsuarios){
        
            this.panelCrearReporte = panelCrearReporte;
            this.panelGestionProductos = panelGestionProductos;
            this.panelGestionClientes = panelGestionClientes;
            this.panelGestionUsuarios = panelGestionUsuarios;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "crearReporte":
                break;
            case "gestionarProductos":
                break;
            case "gestionarClientes":
                break;
            case "gestionarUsuarios":
                break;
            case "logOut":
                System.out.println("Saliendo");
                break;
            default:
                System.out.println("Accion no soportada");
        }

    }

}