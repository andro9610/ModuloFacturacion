package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Mapeador.ConexionDB;

import Vista.Herramientas.tableMaker;

public class operacionesFactura {
    public Object[] agregarNuevaFactura(tableMaker creadorTabla) throws SQLException {

        Object[] nuevoFactura = {"F000","00/00/0000 00:00","0","0","0"};
        new CRUDFacturas().insertarFactura("F000","00/00/0000 00:00","0","0","0");
        return nuevoFactura;
    }

    public void cargarFacturas(tableMaker creadorTabla) throws SQLException {

        ConexionDB EnlaceBD= new ConexionDB();
        Connection bdObject = EnlaceBD.getConnection();
        ResultSet listaFacturas = bdObject.createStatement().executeQuery(
            "SELECT * FROM FACTURA"
        );

        while (listaFacturas.next()){
            Object Facturas[] = {
                listaFacturas.getString(1),
                listaFacturas.getString(2),
                listaFacturas.getString(3),
                listaFacturas.getString(4),
                listaFacturas.getString(5)
            };
            creadorTabla.agregarFila(Facturas);
        }
    }
}
