package Controlador;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import Modelo.operacionesGestionUsuarios;
import Vista.Herramientas.tableMaker;

import java.awt.event.ActionEvent;

public class GestionUsuariosController implements ActionListener {

    tableMaker tablaUsuarios;

    public void setCampos(tableMaker creadorTablas) {
        this.tablaUsuarios = creadorTablas;
        try {
            new operacionesGestionUsuarios().cargarUsuarios(tablaUsuarios);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "agregarUsuario":
                try {
                    tablaUsuarios.agregarFila(
                        new operacionesGestionUsuarios()
                        .agregarNuevoUsuario(tablaUsuarios)
                    );
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
        }
    }
    
}