package Controlador;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import Modelo.operacionesGestionClientes;
import Vista.Herramientas.tableMaker;

import java.awt.event.ActionEvent;

public class GestionClientesController implements ActionListener {

    tableMaker tablaClientes;

    public void setCampos(tableMaker creadorTablas) {
        this.tablaClientes = creadorTablas;
        try {
            new operacionesGestionClientes().cargarClientes(tablaClientes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "agregarCliente":
                try {
                    tablaClientes.agregarFila(
                        new operacionesGestionClientes()
                        .agregarNuevoCliente(tablaClientes)
                    );
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
        }
    }
    
}