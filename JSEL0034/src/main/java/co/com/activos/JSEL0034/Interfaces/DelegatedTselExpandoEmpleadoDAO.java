package co.com.activos.JSEL0034.Interfaces;

import java.util.List;

import co.com.activos.JSEL0034.Controller.TselExpandoEmpleadoDAO;
import co.com.activos.JSEL0034.ClassAbstract.TselExpandoEmpleadoDAOInterface;
import co.com.activos.JSEL0034.Entidad.TselExpandoEmpleadoEntity;

/**
 * Delegado manejo de datos modelo ExpandoEmpleado
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JDK1.6
 */
public class DelegatedTselExpandoEmpleadoDAO {

    /**
     * Retorna el valor llave del ExpandoValue
     *
     * @param nombreConstante
     * @return
     */
    public static Long cargarConstanteExpando(String nombreConstante) {
        TselExpandoEmpleadoDAOInterface tselExpandoEmpleadoDAOInterface = new TselExpandoEmpleadoDAO();
        return tselExpandoEmpleadoDAOInterface.cargarConstanteExpando(nombreConstante);
    }

    /**
     * Retorna la estructura de datos ExpandoEmpleado asociado al Tipo (HOBBY,
     * DEPORTES ......)
     *
     * @param tdcTd
     * @param eplNd
     * @param teiId
     * @return
     */
    public static List<TselExpandoEmpleadoEntity> cargarEstrucutraExpandoEmpleado(String tdcTd, Long eplNd, Long teiId) {
        TselExpandoEmpleadoDAOInterface tselExpandoEmpleadoDAOInterface = new TselExpandoEmpleadoDAO();
        return tselExpandoEmpleadoDAOInterface.cargarEstrucutraExpandoEmpleado(tdcTd, eplNd, teiId);
    }

    /**
     * Retorna el filtrado de la lista de opciones ExpandoValue
     *
     * @param tedId
     * @param filtro
     * @return
     */
    public static List<String> cargarFiltroExpandoValue(Long tedId, String filtro) {
        TselExpandoEmpleadoDAOInterface tselExpandoEmpleadoDAOInterface = new TselExpandoEmpleadoDAO();
        return tselExpandoEmpleadoDAOInterface.cargarFiltroExpandoValue(tedId, filtro);
    }

    /**
     * Asociar Expando Value al Empleado
     *
     * @param tdcTd
     * @param eplNd
     * @param teiId
     * @param valor
     * @throws Exception
     */
    public static void asociarExpandoValueEmpleado(String tdcTd, Long eplNd, Long teiId, String valor) throws Exception {
        TselExpandoEmpleadoDAOInterface tselExpandoEmpleadoDAOInterface = new TselExpandoEmpleadoDAO();
        tselExpandoEmpleadoDAOInterface.asociarExpandoValueEmpleado(tdcTd, eplNd, teiId, valor);
    }

    /**
     * Eliminar asociacion del ExpandoValue con empleado.
     *
     * @param teeId
     * @throws Exception
     */
    public static void eliminarExpandoValueEmpleado(Long teeId) throws Exception {
        TselExpandoEmpleadoDAOInterface tselExpandoEmpleadoDAOInterface = new TselExpandoEmpleadoDAO();
        tselExpandoEmpleadoDAOInterface.eliminarExpandoValueEmpleado(teeId);
    }
}
