package co.com.activos.JSEL0034.ClassAbstract;

import java.util.List;
import co.com.activos.JSEL0034.Entidad.TselExpandoEmpleadoEntity;
/**
 * <interface>
 * Controlador acceso a datos modelo de ExpandoEmpleado
 * 
 * @author  Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since   JDK1.6
 */
public interface TselExpandoEmpleadoDAOInterface {	
	/**
	 * Retorna el valor llave del ExpandoValue
	 * @param nombreConstante
	 * @return
	 */
	public Long cargarConstanteExpando(String nombreConstante);	
	/**
	 * Retorna la estructura de datos ExpandoEmpleado asociado al Tipo (HOBBY, DEPORTES ......)
	 * @param tdcTd
	 * @param eplNd
	 * @param teiId
	 * @return
	 */
	public List<TselExpandoEmpleadoEntity> cargarEstrucutraExpandoEmpleado(String tdcTd,Long eplNd,Long teiId);	
	/**
	 * Retorna el filtrado de la lista de opciones ExpandoValue
	 * @param tedId
	 * @param filtro
	 * @return
	 */
	public List<String> cargarFiltroExpandoValue(Long tedId,String filtro);	
	/**
	 * Asociar Expando Value al Empleado
	 * @param tdcTd
	 * @param eplNd
	 * @param teiId
	 * @param valor
	 * @throws Exception
	 */
	public void asociarExpandoValueEmpleado(String tdcTd,Long eplNd,Long teiId,String valor) throws Exception;
	/**
	 * Eliminar asociacion del ExpandoValue con empleado.
	 * @param teeId
	 * @throws Exception
	 */
	public void eliminarExpandoValueEmpleado(Long teeId) throws Exception;

}
