package co.com.activos.JSEL0034.ClassAbstract;

import java.util.List;
import javax.faces.model.SelectItem;
import co.com.activos.JSEL0034.Entidad.TselEmpleadoTransporteEntity;
/**
 * <interface>
 * Controlador de acceso a datos Empleado Transporte.
 * 
 * @author  Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since   JDK1.6
 */
public interface TselEmpleadoTransporteDAOInterface{	
	/**
	 * Retorna la informacion de transporte asociada al empleado
	 * @param tdcTd
	 * @param eplNd
	 * @return
	 */
	public List<TselEmpleadoTransporteEntity> cargarInformacionEmpleadoTransporte(String tdcTd,Long eplNd);	
	/**
	 * Retorna la lista de tipos de transporte.
	 * @return
	 */
	public List<SelectItem> cargarListaTiposTransporte();	
	/**
	 * Guardado Informacion Empleado Transporte
	 * @param empleadoTransporte
	 * @throws Exception
	 */
	public void guardarInformacionEmpleadoTransporte(TselEmpleadoTransporteEntity empleadoTransporte) throws Exception;
	/**
	 * Elimina el tipo de transporte no seleccionado
	 * @param empleadoTransporte
	 * @throws Exception
	 */
	public void eliminarInfoTransporte(TselEmpleadoTransporteEntity empleadoTransporte) throws Exception;
	
}