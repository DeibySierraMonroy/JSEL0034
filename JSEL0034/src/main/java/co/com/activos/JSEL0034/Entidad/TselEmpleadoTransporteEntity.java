package co.com.activos.JSEL0034.Entidad;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author  Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since   JDK1.6
 */
public class TselEmpleadoTransporteEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String tdcTd;   
	private Long   eplNd;    
	private Long   item=new Long(0);     
	private String tetPropio;   
	private Long   tveIdTipoVehiculo=new Long(99);     
	private String tetModelo; 
	private String audUser;  
	private Date   audFecha;          
	private Long   tetMarca;   
	
	private boolean nuevoRegistro=true;
	
	public TselEmpleadoTransporteEntity(){}

	public String getTdcTd() {
		return tdcTd;
	}
	public void setTdcTd(String tdcTd) {
		this.tdcTd = tdcTd;
	}
	public Long getEplNd() {
		return eplNd;
	}
	public void setEplNd(Long eplNd) {
		this.eplNd = eplNd;
	}
	public Long getItem() {
		return item;
	}
	public void setItem(Long item) {
		this.item = item;
	}
	public String getTetPropio() {
		return tetPropio;
	}
	public void setTetPropio(String tetPropio) {
		this.tetPropio = tetPropio;
	}
	public Long getTveIdTipoVehiculo() {
		return tveIdTipoVehiculo;
	}
	public void setTveIdTipoVehiculo(Long tveIdTipoVehiculo) {
		this.tveIdTipoVehiculo = tveIdTipoVehiculo;
	}
	public String getTetModelo() {
		return tetModelo;
	}
	public void setTetModelo(String tetModelo) {
		this.tetModelo = tetModelo;
	}
	public String getAudUser() {
		return audUser;
	}
	public void setAudUser(String audUser) {
		this.audUser = audUser;
	}
	public Date getAudFecha() {
		return audFecha;
	}
	public void setAudFecha(Date audFecha) {
		this.audFecha = audFecha;
	}
	public Long getTetMarca() {
		return tetMarca;
	}
	public void setTetMarca(Long tetMarca) {
		this.tetMarca = tetMarca;
	}

	public boolean isNuevoRegistro() {
		return nuevoRegistro;
	}

	public void setNuevoRegistro(boolean nuevoRegistro) {
		this.nuevoRegistro = nuevoRegistro;
	}
}