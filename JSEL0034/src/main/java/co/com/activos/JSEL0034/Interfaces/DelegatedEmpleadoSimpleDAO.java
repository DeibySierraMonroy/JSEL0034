package co.com.activos.JSEL0034.Interfaces;

import java.util.List;

import javax.faces.model.SelectItem;

import co.com.activos.JSEL0034.Controller.EmpleadoSimpleDAO;
import co.com.activos.JSEL0034.ClassAbstract.EmpleadoSimpleDAOInterface;
import co.com.activos.JSEL0034.Entidad.EmpleadoSimpleEntity;

/**
 * Delegado manejo de datos informacion adicional empleado
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JDK1.6
 */
public class DelegatedEmpleadoSimpleDAO {

    /**
     * Retorna la informacion adicional del empleado.
     *
     * @param tdcTd
     * @param eplNd
     * @return
     */
    public static EmpleadoSimpleEntity cargarInformacionAdicionalEmpleado(String tdcTd, Long eplNd) {
        EmpleadoSimpleDAOInterface empleadoSimpleDAOInterface = new EmpleadoSimpleDAO();
        return empleadoSimpleDAOInterface.cargarInformacionAdicionalEmpleado(tdcTd, eplNd);
    }

    /**
     * Procesa la informacion adicional del empleado en la base de datos
     *
     * @param empleadoInformacionAdicional
     * @throws Exception
     */
    public static void guardarInformacionAdicionalEmpleado(EmpleadoSimpleEntity empleadoInformacionAdicional) throws Exception {
        EmpleadoSimpleDAOInterface empleadoSimpleDAOInterface = new EmpleadoSimpleDAO();
        empleadoSimpleDAOInterface.guardarInformacionAdicionalEmpleado(empleadoInformacionAdicional);
    }

    /**
     * Retorna la lista de talla disponibles para el empleado
     *
     * @param tdcTd
     * @param eplNd
     * @param tipoLista
     * @param aplicaGenero
     * @return
     */
    public static List<SelectItem> cargarListaTallasEmpleado(String tdcTd, Long eplNd, String tipoLista, String aplicaGenero) {
        EmpleadoSimpleDAOInterface empleadoSimpleDAOInterface = new EmpleadoSimpleDAO();
        return empleadoSimpleDAOInterface.cargarListaTallasEmpleado(tdcTd, eplNd, tipoLista, aplicaGenero);
    }
}
