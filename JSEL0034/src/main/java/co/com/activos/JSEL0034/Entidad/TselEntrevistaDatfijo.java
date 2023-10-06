package co.com.activos.JSEL0034.Entidad;

import java.io.Serializable;

/**
 * Modelo de datos entidad TSEL_ENTREVISTA_DATFIJO (Version simplificada)
 * 
 * @author  Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since   JDK1.6
 */
public class TselEntrevistaDatfijo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String  tdcTdEpl;    
	private Long    eplNd;  
	private Integer edfNumeroHijos;      
	private String  edfQuienCuidaHijos;     
	private String  edfAportaVivienda;  
	private Integer edfNumHijosVivenCandt;   

	public TselEntrevistaDatfijo(){}
	
	public TselEntrevistaDatfijo(String tdcTdEpl,Long eplNd){
		this.tdcTdEpl=tdcTdEpl;
		this.eplNd=eplNd;
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
	public Integer getEdfNumeroHijos() {
		return edfNumeroHijos;
	}
	public void setEdfNumeroHijos(Integer edfNumeroHijos) {
		this.edfNumeroHijos = edfNumeroHijos;
	}
	public String getEdfQuienCuidaHijos() {
		return edfQuienCuidaHijos;
	}
	public void setEdfQuienCuidaHijos(String edfQuienCuidaHijos) {
		this.edfQuienCuidaHijos = edfQuienCuidaHijos;
	}
	public String getEdfAportaVivienda() {
		return edfAportaVivienda;
	}
	public void setEdfAportaVivienda(String edfAportaVivienda) {
		this.edfAportaVivienda = edfAportaVivienda;
	}
	public Integer getEdfNumHijosVivenCandt() {
		return edfNumHijosVivenCandt;
	}
	public void setEdfNumHijosVivenCandt(Integer edfNumHijosVivenCandt) {
		this.edfNumHijosVivenCandt = edfNumHijosVivenCandt;
	}
}