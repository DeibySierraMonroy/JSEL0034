package co.com.activos.JSEL0034.Entidad;

import java.io.Serializable;
import co.com.activos.JSEL0034.Entidad.EmpresaEntity;
/**
 * Modelo de datos entidad TselEmpleadoSGSS.
 * 
 * @author  Jairo Andres Rivera Rodriguez
 * @since   JDK1.6
 * @version 1.0
 */
public class TselEmpleadoSGSSSimpleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String tdcTd;
	private Long eplNd;
	private Integer tipoBeneficiario=0;
	private String eps;
	private String afp;	
	public TselEmpleadoSGSSSimpleEntity(){}
	
	public TselEmpleadoSGSSSimpleEntity(String tdcTd,Long eplNd){
		this.tdcTd=tdcTd;
		this.eplNd=eplNd;
	}
	
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
	public String getEps() {
		return eps;
	}
	public void setEps(String eps) {
		this.eps = eps;
	}
	public String getAfp() {
		return afp;
	}
	public void setAfp(String afp) {
		this.afp = afp;
	}
	public Integer getTipoBeneficiario() {
		return tipoBeneficiario;
	}
	public void setTipoBeneficiario(Integer tipoBeneficiario) {
		this.tipoBeneficiario = tipoBeneficiario;
	}	
}