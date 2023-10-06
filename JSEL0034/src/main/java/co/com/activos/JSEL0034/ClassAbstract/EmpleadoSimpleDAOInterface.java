package co.com.activos.JSEL0034.ClassAbstract;

import java.util.List;

import javax.faces.model.SelectItem;

import co.com.activos.JSEL0034.Entidad.EmpleadoSimpleEntity;

/**
 * <interface>
 * Gestor de datos accedo a datos empleado
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JDK1.6
 */
public interface EmpleadoSimpleDAOInterface {

    /**
     * Retorna la informacion adicional del empleado.
     *
     * @param tdcTd
     * @param eplNd
     * @return
     */
    public EmpleadoSimpleEntity cargarInformacionAdicionalEmpleado(String tdcTd, Long eplNd);

    /**
     * Procesa la informacion adicional del empleado en la base de datos
     *
     * @param empleadoInformacionAdicional
     * @throws Exception
     */
    public void guardarInformacionAdicionalEmpleado(EmpleadoSimpleEntity empleadoInformacionAdicional) throws Exception;

    /**
     * Retorna la lista de talla disponibles para el empleado
     *
     * @param tdcTd
     * @param eplNd
     * @param tipoLista
     * @param aplicaGenero
     * @return
     */
    public List<SelectItem> cargarListaTallasEmpleado(String tdcTd, Long eplNd, String tipoLista, String aplicaGenero);

}
