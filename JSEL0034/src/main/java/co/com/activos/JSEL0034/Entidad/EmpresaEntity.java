package co.com.activos.JSEL0034.Entidad;

import java.io.Serializable;


/**
 * Modelo de datos Empresa
 * 
 * @author  Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since   JDK1.6
 */
public class EmpresaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String tdcTd;  
	private Long   empNd;   
	private Long   empDv;    
	private String empNombre; 
	private String ateCodigo; 
	
	public EmpresaEntity(){}
	
	public EmpresaEntity(String tdcTd,Long empNd){
		this.tdcTd=tdcTd;
		this.empNd=empNd;
	}
	
	public EmpresaEntity(String tdcTd,Long empNd,String empNombre){
		this.tdcTd=tdcTd;
		this.empNd=empNd;
		this.empNombre=empNombre;
	}
	
	public String getTdcTd() {
		return tdcTd;
	}
	public void setTdcTd(String tdcTd) {
		this.tdcTd = tdcTd;
	}
	public Long getEmpNd() {
		return empNd;
	}
	public void setEmpNd(Long empNd) {
		this.empNd = empNd;
	}
	public Long getEmpDv() {
		return empDv;
	}
	public void setEmpDv(Long empDv) {
		this.empDv = empDv;
	}
	public String getEmpNombre() {
		return empNombre;
	}
	public void setEmpNombre(String empNombre) {
		this.empNombre = empNombre;
	}
	public String getAteCodigo() {
		return ateCodigo;
	}
	public void setAteCodigo(String ateCodigo) {
		this.ateCodigo = ateCodigo;
	}
	
}