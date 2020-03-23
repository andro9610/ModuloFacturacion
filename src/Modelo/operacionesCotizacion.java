package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Mapeador.ConexionDB;

import Vista.Herramientas.tableMaker;

public class operacionesCotizacion {
    public Object[] agregarNuevaCotizacion(tableMaker creadorTabla) throws SQLException {

        Object[] nuevoCotizacion = {"F000","00/00/0000 00:00","0","0","0"};
        new CRUDCotizaciones().insertarCotizacion("F000","00/00/0000 00:00","0","0","0");
        return nuevoCotizacion;
    }

    public void cargarCotizaciones(tableMaker creadorTabla) throws SQLException {

        ConexionDB EnlaceBD= new ConexionDB();
        Connection bdObject = EnlaceBD.getConnection();
        ResultSet listaCotizaciones = bdObject.createStatement().executeQuery(
            "SELECT * FROM COTIZACION"
        );

        while (listaCotizaciones.next()){
            Object Cotizaciones[] = {
                listaCotizaciones.getString(1),
                listaCotizaciones.getString(2),
                listaCotizaciones.getString(3),
                listaCotizaciones.getString(4),
                listaCotizaciones.getString(5)
            };
            creadorTabla.agregarFila(Cotizaciones);
        }
    }
}
