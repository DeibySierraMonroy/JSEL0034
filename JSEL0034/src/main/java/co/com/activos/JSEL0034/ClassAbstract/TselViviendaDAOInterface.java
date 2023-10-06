package co.com.activos.JSEL0034.ClassAbstract;

import java.util.List;

import javax.faces.model.SelectItem;

import co.com.activos.JSEL0034.Entidad.TselVivienda;
/**
 * Gestor de datos entidad TSEL_VIVIENDA.
 * 
 * @author  Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since   JDK1.6
 */
public interface TselViviendaDAOInterface {	
	/**
	 * Carga la informacion de vivienda del empleado.
	 * @param tdcTdEpl
	 * @param eplNd
	 * @return
	 */
	public TselVivienda cargarInformacionVivienda(String tdcTdEpl,Long eplNd);
	
	/**
	 * Guardado de la informacion de vivienda del empleado.
	 * @param viviendaEmpleado
	 * @throws Exception
	 */
	public void guardarInformacionViviendaEmpleado(TselVivienda viviendaEmpleado) throws Exception;
	
	/**
	 * Retorna la lista de opciones para las llaves forneas TSEL_VIVIENDA.
	 * @param tipo
	 * @return
	 */
	public List<SelectItem> cargarListaTipoLlaveVivienda(String tipo);

}