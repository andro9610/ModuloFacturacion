package Controlador;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import Modelo.operacionesFactura;
import Vista.Herramientas.tableMaker;

import java.awt.event.ActionEvent;

public class BuscarFacturaController implements ActionListener {

    tableMaker tablaFacturas;

    public void setCampos(tableMaker creadorTablas) {
        this.tablaFacturas = creadorTablas;
        try {
            new operacionesFactura().cargarFacturas(tablaFacturas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "agregarFactura":
                try {
                    tablaFacturas.agregarFila(
                        new operacionesFactura()
                        .agregarNuevaFactura(tablaFacturas)
                    );
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
        }
    }
    
}