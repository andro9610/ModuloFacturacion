package Controlador;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import Modelo.operacionesGestionProductos;
import Vista.Herramientas.tableMaker;

import java.awt.event.ActionEvent;

public class GestionProductosController implements ActionListener {

    tableMaker tablaProductos;

    public void setCampos(tableMaker creadorTablas) {
        this.tablaProductos = creadorTablas;
        try {
            new operacionesGestionProductos().cargarProductos(tablaProductos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "agregarProducto":
                try {
                    tablaProductos.agregarFila(
                        new operacionesGestionProductos()
                        .agregarNuevoProducto(tablaProductos)
                    );
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
        }
    }
    
}