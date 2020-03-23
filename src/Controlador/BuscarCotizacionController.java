package Controlador;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import Modelo.operacionesCotizacion;
import Vista.Herramientas.tableMaker;

import java.awt.event.ActionEvent;

public class BuscarCotizacionController implements ActionListener {

    tableMaker tablaCotizacions;

    public void setCampos(tableMaker creadorTablas) {
        this.tablaCotizacions = creadorTablas;
        try {
            new operacionesCotizacion().cargarCotizaciones(tablaCotizacions);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "agregarCotizacion":
                try {
                    tablaCotizacions.agregarFila(
                        new operacionesCotizacion()
                        .agregarNuevaCotizacion(tablaCotizacions)
                    );
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
        }
    }
    
}