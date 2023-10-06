package co.com.activos.JSEL0034.Entidad;

import java.io.Serializable;
import java.util.Date;
/** 
 * Modelo de datos entidad TSEL_EXPANDO_EMPLEADO
 * 
 * @author  Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since   JDK1.6
 */
public class TselExpandoEmpleadoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long   teeId;    
	private Long   tevId;    
	private String tdcTdEpl;   
	private Long   eplNd;
	private String tevValor; 
	private String teeOtroValor; 
	private Date   audFecha;          
	private String audUsuario;  
	
	public TselExpandoEmpleadoEntity(){}

	public Long getTeeId() {
		return teeId;
	}
	public void setTeeId(Long teeId) {
		this.teeId = teeId;
	}
	public Long getTevId() {
		return tevId;
	}
	public void setTevId(Long tevId) {
		this.tevId = tevId;
	}
	public String getTdcTdEpl() {
		return tdcTdEpl;
	}
	public void setTdcTdEpl(String tdcTdEpl) {
		this.tdcTdEpl = tdcTdEpl;
	}
	public Long getEplNd() {
		return eplNd;
	}
	public void setEplNd(Long eplNd) {
		this.eplNd = eplNd;
	}
	public String getTeeOtroValor() {
		return teeOtroValor;
	}
	public void setTeeOtroValor(String teeOtroValor) {
		this.teeOtroValor = teeOtroValor;
	}
	public Date getAudFecha() {
		return audFecha;
	}
	public void setAudFecha(Date audFecha) {
		this.audFecha = audFecha;
	}
	public String getAudUsuario() {
		return audUsuario;
	}
	public void setAudUsuario(String audUsuario) {
		this.audUsuario = audUsuario;
	}

	public String getTevValor() {
		return tevValor;
	}

	public void setTevValor(String tevValor) {
		this.tevValor = tevValor;
	}	
}