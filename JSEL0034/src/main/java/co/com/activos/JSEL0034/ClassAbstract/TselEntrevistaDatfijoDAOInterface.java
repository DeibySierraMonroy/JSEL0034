package co.com.activos.JSEL0034.ClassAbstract;

import co.com.activos.JSEL0034.Entidad.TselEntrevistaDatfijo;

/**
 * <interface>
 * Controlador de acceso a datos entidad TSEL_ENTREVISTA_DATFIJO.
 * 
 * @author  Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since   JDK1.6
 */
public interface TselEntrevistaDatfijoDAOInterface {

	/**
	 * Retorna los datos encontrados en tsel_entrevista_dat fijo para el modulo qbjsel0011.
	 * @param tdcTdEpl
	 * @param eplNd
	 * @return
	 */
	public TselEntrevistaDatfijo cargarEntrevistaDatFijoEmpleado(String tdcTdEpl,Long eplNd);
	
	/**
	 * Proceso de persistencia valores de entrevista DatFijo
	 * @param darFijo
	 */
	public void guardarEntrevistaDatFijo(TselEntrevistaDatfijo datFijo) throws Exception;
	
}
