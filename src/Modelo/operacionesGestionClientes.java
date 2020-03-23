package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.TableColumn;

import Mapeador.ConexionDB;
import Vista.Herramientas.colorMaker;
import Vista.Herramientas.fontMaker;
import Vista.Herramientas.listMaker;
import Vista.Herramientas.tableMaker;

public class operacionesGestionClientes {
    public Object[] agregarNuevoCliente(tableMaker creadorTabla) throws SQLException {
        /**Creacion de listas desplegables */
        String [] opcionesTipoDocumento = {"CEDULA DE CIUDADANIA","OTRO"};
        String [] opcionesSexo = {"FEMENINO","MASCULINO"};
        
        JComboBox<String> tipoDocumento = agregarLista(opcionesTipoDocumento);
        JComboBox<String> sexoCliente = agregarLista(opcionesSexo);

        /**Formateo de las columnas */
        TableColumn tipoDocumentoColumn = 
        creadorTabla.getMetatabla().getColumnModel().getColumn(1);
        tipoDocumentoColumn.setCellEditor(new DefaultCellEditor(tipoDocumento));

        TableColumn sexoClienteColumn = 
        creadorTabla.getMetatabla().getColumnModel().getColumn(4);
        sexoClienteColumn.setCellEditor(new DefaultCellEditor(sexoCliente));

        Object[] nuevoCliente = {"00000000",tipoDocumento,"SIN NOMBRE","SIN APELLIDO",sexoCliente,"18"};
        new CRUDClientes().insertarCliente("00000000", "CEDULA DE CIUDADANIA", "SIN NOMBRE","SIN APELLIDO", "NINGUNO","18");
        return nuevoCliente;
    }

    public void cargarClientes(tableMaker creadorTabla) throws SQLException {
        String [] opcionesTipoDocumento = {"CEDULA DE CIUDADANIA","OTRO"};
        String [] opcionesSexo = {"FEMENINO","MASCULINO"};
        
        JComboBox<String> tipoDocumento = agregarLista(opcionesTipoDocumento);
        JComboBox<String> sexoCliente = agregarLista(opcionesSexo);

        ConexionDB EnlaceBD= new ConexionDB();
        Connection bdObject = EnlaceBD.getConnection();
        ResultSet listaClientes = bdObject.createStatement().executeQuery(
            "SELECT * FROM CLIENTES"
        );

        while (listaClientes.next()){
            TableColumn tipoDocumentoColumn = 
            creadorTabla.getMetatabla().getColumnModel().getColumn(1);
            tipoDocumentoColumn.setCellEditor(new DefaultCellEditor(tipoDocumento));
    
            TableColumn sexoClienteColumn = 
            creadorTabla.getMetatabla().getColumnModel().getColumn(4);
            sexoClienteColumn.setCellEditor(new DefaultCellEditor(sexoCliente));
            Object Clientes[] = {
                listaClientes.getString(1),
                listaClientes.getString(2),
                listaClientes.getString(3),
                listaClientes.getString(4),
                listaClientes.getString(5),
                listaClientes.getString(6),
            };
            creadorTabla.agregarFila(Clientes);
        }
    }

    /**Operacion que permite añadir listas desplegables a la tabla */
    private JComboBox<String> agregarLista(String[] opciones){     
        listMaker creadorListas = new listMaker();
        return creadorListas.crear(
            0, 0,100, 32,
            new colorMaker().obtainColor("grisEnfasisMedio"),
            new fontMaker().obtainFont("fuenteListaDesplegable"),
            opciones
        );
    }
}
