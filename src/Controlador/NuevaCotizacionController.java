package Controlador;

import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.TableColumn;

import Vista.Herramientas.colorMaker;
import Vista.Herramientas.fontMaker;
import Vista.Herramientas.inputMaker;
import Vista.Herramientas.listMaker;
import Vista.Herramientas.tableMaker;

import java.awt.event.ActionEvent;

public class NuevaCotizacionController implements ActionListener{

    inputMaker idCliente, busquedaProducto, subTotal,
    Fletes, total;

tableMaker tableCreator;

public NuevaCotizacionController(
    inputMaker idCliente,
    inputMaker busquedaProducto,
    inputMaker subTotal,
    inputMaker Fletes,
    inputMaker total,
    tableMaker creadorTablas
){
    this.idCliente = idCliente;
    this.busquedaProducto = busquedaProducto;
    this.subTotal = subTotal;
    this.Fletes = Fletes;
    this.total = total;
    this.tableCreator = creadorTablas;
}

@Override
public void actionPerformed(ActionEvent e) {
    switch(e.getActionCommand()){
        case "agregarProducto":
            Object [] datas = {
                "XXXXXXXX",
                "BlankProduct",
                agregarListaProductos(),
                agregarListaTallas(),
                agregarListaColores(),
                agregarListaMarcas(),
                "0",
                "0",
                "0"
            };
            tableCreator.agregarFila(datas);
            break;
        case "borrarSeleccion":
            tableCreator.quitarFilaSeleccionada();
            break;
        case "Cotizacion":
            break;
    }

}
private JComboBox<String> agregarListaTallas(){     
    String [] opcionesTipoUsuario = {"XS","S","M","L","XL"};
    listMaker creadorListas = new listMaker();
    JComboBox<String> tipoTalla = creadorListas.crear(
        0, 0,100, 32,
        new colorMaker().obtainColor("grisEnfasisMedio"),
        new fontMaker().obtainFont("fuenteListaDesplegable"),
        opcionesTipoUsuario
    );

    TableColumn usuarioColumn = 
        tableCreator.getMetatabla().getColumnModel().getColumn(3);
    usuarioColumn.setCellEditor(new DefaultCellEditor(tipoTalla));
    return tipoTalla;
}

private JComboBox<String> agregarListaMarcas(){     
    String [] opcionesTipoUsuario = {"TOTTO","ADIDAS","NIKE"};
    listMaker creadorListas = new listMaker();
    JComboBox<String> tipoUsuario = creadorListas.crear(
        0, 0,100, 32,
        new colorMaker().obtainColor("grisEnfasisMedio"),
        new fontMaker().obtainFont("fuenteListaDesplegable"),
        opcionesTipoUsuario
    );

    TableColumn usuarioColumn = 
        tableCreator.getMetatabla().getColumnModel().getColumn(5);
    usuarioColumn.setCellEditor(new DefaultCellEditor(tipoUsuario));
    return tipoUsuario;
    }

    private JComboBox<String> agregarListaProductos(){     
        String [] opcionesTipoUsuario = {"Camisa","Pantalon"};
        listMaker creadorListas = new listMaker();
        JComboBox<String> tipoUsuario = creadorListas.crear(
            0, 0,100, 32,
            new colorMaker().obtainColor("grisEnfasisMedio"),
            new fontMaker().obtainFont("fuenteListaDesplegable"),
            opcionesTipoUsuario
        );

        TableColumn usuarioColumn = 
            tableCreator.getMetatabla().getColumnModel().getColumn(2);
        usuarioColumn.setCellEditor(new DefaultCellEditor(tipoUsuario));
        return tipoUsuario;
    }

    private JComboBox<String> agregarListaColores(){
        String [] opcionesTipoUsuario = {"Rojo","Negro"};
        listMaker creadorListas = new listMaker();
        JComboBox<String> tipoUsuario = creadorListas.crear(
            0, 0,100, 32,
            new colorMaker().obtainColor("grisEnfasisMedio"),
            new fontMaker().obtainFont("fuenteListaDesplegable"),
            opcionesTipoUsuario
        );

        TableColumn usuarioColumn = 
            tableCreator.getMetatabla().getColumnModel().getColumn(4);
        usuarioColumn.setCellEditor(new DefaultCellEditor(tipoUsuario));
        return tipoUsuario;
    }
}