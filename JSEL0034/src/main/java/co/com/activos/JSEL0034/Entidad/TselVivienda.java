package co.com.activos.JSEL0034.Entidad;

import java.io.Serializable;
import java.util.Date;
/**
 * Modelo datos entidad TSEL_VIVIENDA.
 * 
 * @author  Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since   JDK1.6
 */
public class TselVivienda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String  tdcTdEpl;   
	private Long    eplNd;    
	private Long    vivCodigo;    
	private Long    tipCodigo;    
	private String  vivDireccion;  
	private Long    estrato;    
	private String  hipoteca;   
	private String  paiNombre;  
	private String  dptNombre;  
	private String  ciuNombre;  
	private Long    vivSecuencia=new Long(1);    
	private Date    fechaInicial;  
	private Integer fechaInicialAnio;
	private Integer fechaInicialMes;
	
	private Date    fechaFinal;          
	private Long    tiempoVivienda;
	private String  tiempoViviendaLetras; 
	private Double  valorVivienda;  
	private String  nombreArrendador; 
	private Long    telefonoInmueble;    
	private String  audUser;  
	private Date    audFecha;          
	
	public TselVivienda(){}
	
	public TselVivienda(String tdcTd,Long eplNd){
		this.tdcTdEpl=tdcTd;
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
	public Long getVivCodigo() {
		return vivCodigo;
	}
	public void setVivCodigo(Long vivCodigo) {
		this.vivCodigo = vivCodigo;
	}
	public Long getTipCodigo() {
		return tipCodigo;
	}
	public void setTipCodigo(Long tipCodigo) {
		this.tipCodigo = tipCodigo;
	}
	public String getVivDireccion() {
		return vivDireccion;
	}
	public void setVivDireccion(String vivDireccion) {
		this.vivDireccion = vivDireccion;
	}
	public Long getEstrato() {
		return estrato;
	}
	public void setEstrato(Long estrato) {
		this.estrato = estrato;
	}
	public String getHipoteca() {
		return hipoteca;
	}
	public void setHipoteca(String hipoteca) {
		this.hipoteca = hipoteca;
	}
	public String getPaiNombre() {
		return paiNombre;
	}
	public void setPaiNombre(String paiNombre) {
		this.paiNombre = paiNombre;
	}
	public String getDptNombre() {
		return dptNombre;
	}
	public void setDptNombre(String dptNombre) {
		this.dptNombre = dptNombre;
	}
	public String getCiuNombre() {
		return ciuNombre;
	}
	public void setCiuNombre(String ciuNombre) {
		this.ciuNombre = ciuNombre;
	}
	public Long getVivSecuencia() {
		return vivSecuencia;
	}
	public void setVivSecuencia(Long vivSecuencia) {
		this.vivSecuencia = vivSecuencia;
	}
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Long getTiempoVivienda() {
		return tiempoVivienda;
	}
	public void setTiempoVivienda(Long tiempoVivienda) {
		this.tiempoVivienda = tiempoVivienda;
	}
	public String getTiempoViviendaLetras() {
		return tiempoViviendaLetras;
	}
	public void setTiempoViviendaLetras(String tiempoViviendaLetras) {
		this.tiempoViviendaLetras = tiempoViviendaLetras;
	}
	public Double getValorVivienda() {
		return valorVivienda;
	}
	public void setValorVivienda(Double valorVivienda) {
		this.valorVivienda = valorVivienda;
	}
	public String getNombreArrendador() {
		return nombreArrendador;
	}
	public void setNombreArrendador(String nombreArrendador) {
		this.nombreArrendador = nombreArrendador;
	}
	public Long getTelefonoInmueble() {
		return telefonoInmueble;
	}
	public void setTelefonoInmueble(Long telefonoInmueble) {
		this.telefonoInmueble = telefonoInmueble;
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
	public Integer getFechaInicialAnio() {
		return fechaInicialAnio;
	}
	public void setFechaInicialAnio(Integer fechaInicialAnio) {
		this.fechaInicialAnio = fechaInicialAnio;
	}
	public Integer getFechaInicialMes() {
		return fechaInicialMes;
	}
	public void setFechaInicialMes(Integer fechaInicialMes) {
		this.fechaInicialMes = fechaInicialMes;
	}
}