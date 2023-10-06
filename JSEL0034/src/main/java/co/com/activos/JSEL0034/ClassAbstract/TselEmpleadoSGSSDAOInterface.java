package co.com.activos.JSEL0034.ClassAbstract;

import java.util.List;
import co.com.activos.JSEL0034.Entidad.EmpresaEntity;
import co.com.activos.JSEL0034.Entidad.TselEmpleadoSGSSSimpleEntity;
/**
 * <interface>
 * Controlador de datos TselEmpleadoSGSS
 * 
 * @author  Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since   JDK1.6
 */
public interface TselEmpleadoSGSSDAOInterface {
	/**
	 * Retorna la informacion SGSS del empleado
	 * @param tdcTd
	 * @param eplNd
	 * @return
	 */
	public TselEmpleadoSGSSSimpleEntity cargarInformacionSGSSEmpleado(String tdcTd,Long eplNd);
	
	/**
	 * Procesa el guardado de la informacion SGSS del empleado
	 * @param infoSGSS
	 * @throws Exception
	 */
	public void guardarInformacionSGSSEmpleado(TselEmpleadoSGSSSimpleEntity infoSGSS) throws Exception;
	
	/**
	 * Retorna la lista de empresas por Tipo (EPS y AFP)
	 * @param tipo
	 * @return
	 */
	public List<EmpresaEntity> cargarEmpresasSGSS(String tipo);
	
}