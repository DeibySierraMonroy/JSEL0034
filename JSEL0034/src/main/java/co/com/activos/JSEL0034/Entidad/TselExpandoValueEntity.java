package co.com.activos.JSEL0034.Entidad;

import java.io.Serializable;
import java.util.Date;
/**
 * Modelo de datos entidad TSEL_EXPANDO_VALUE.
 * 
 * @author  Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since   JDK1.6
 */
public class TselExpandoValueEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long   tevId;   
	private Long   teiId;   
	private String tevValor; 
	private Date   audFecha;         
	private String audUsuario; 
	
	public boolean otroValor=false;
	
	public TselExpandoValueEntity(){}

	public Long getTevId() {
		return tevId;
	}
	public void setTevId(Long tevId) {
		this.tevId = tevId;
	}
	public Long getTeiId() {
		return teiId;
	}
	public void setTeiId(Long teiId) {
		this.teiId = teiId;
	}
	public String getTevValor() {
		return tevValor;
	}
	public void setTevValor(String tevValor) {
		this.tevValor = tevValor;
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

	public boolean isOtroValor() {
		return otroValor;
	}

	public void setOtroValor(boolean otroValor) {
		this.otroValor = otroValor;
	}
}