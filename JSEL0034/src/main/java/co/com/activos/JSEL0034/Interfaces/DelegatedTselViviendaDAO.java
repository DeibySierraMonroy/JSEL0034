package co.com.activos.JSEL0034.Interfaces;

import java.util.List;

import javax.faces.model.SelectItem;

import co.com.activos.JSEL0034.Controller.TselViviendaDAO;
import co.com.activos.JSEL0034.ClassAbstract.TselViviendaDAOInterface;
import co.com.activos.JSEL0034.Entidad.TselVivienda;

/**
 * Delegado datos TselVivienda.
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JDK1.6
 */
public class DelegatedTselViviendaDAO {

    /**
     * Carga la informacion de vivienda del empleado.
     *
     * @param tdcTdEpl
     * @param eplNd
     * @return
     */
    public static TselVivienda cargarInformacionVivienda(String tdcTdEpl, Long eplNd) {
        TselViviendaDAOInterface tselViviendaDAOInterface = new TselViviendaDAO();
        return tselViviendaDAOInterface.cargarInformacionVivienda(tdcTdEpl, eplNd);
    }

    /**
     * Guardado de la informacion de vivienda del empleado.
     *
     * @param viviendaEmpleado
     * @throws Exception
     */
    public static void guardarInformacionViviendaEmpleado(TselVivienda viviendaEmpleado) throws Exception {
        TselViviendaDAOInterface tselViviendaDAOInterface = new TselViviendaDAO();
        tselViviendaDAOInterface.guardarInformacionViviendaEmpleado(viviendaEmpleado);
    }

    /**
     * Retorna la lista de opciones para las llaves forneas TSEL_VIVIENDA.
     *
     * @param tipo
     * @return
     */
    public static List<SelectItem> cargarListaTipoLlaveVivienda(String tipo) {
        TselViviendaDAOInterface tselViviendaDAOInterface = new TselViviendaDAO();
        return tselViviendaDAOInterface.cargarListaTipoLlaveVivienda(tipo);
    }
}
