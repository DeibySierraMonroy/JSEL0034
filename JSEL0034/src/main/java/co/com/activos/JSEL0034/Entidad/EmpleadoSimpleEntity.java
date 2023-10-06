package co.com.activos.JSEL0034.Entidad;

import java.io.Serializable;
import java.util.Date;
/**
 * Modelo datos simplificado (solo campos necesarios) entidad Empleado
 * 
 * @author  Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since   JDK1.5
 */
public class EmpleadoSimpleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String tdcTd;
	private Long eplNd;
	private String eplFuma;
	private boolean fuma;
	private String eplUsaLentes;
	private boolean usalentes;
	private String eplToma;
	private String eplTallaCamisa;   
	private String eplTallaZapatos;   
	private String eplTallaPantalon; 
	
	private Integer estatura;
	private Integer peso;
	
	private Date fechaNacimientoEmpleado;
	
	public EmpleadoSimpleEntity(){		
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
	public String getEplFuma() {
		return eplFuma;
	}
	public void setEplFuma(String eplFuma) {
		this.eplFuma = eplFuma;
	}
	public String getEplUsaLentes() {
		return eplUsaLentes;
	}
	public void setEplUsaLentes(String eplUsaLentes) {
		this.eplUsaLentes = eplUsaLentes;
	}
	public String getEplToma() {
		return eplToma;
	}
	public void setEplToma(String eplToma) {
		this.eplToma = eplToma;
	}
	public String getEplTallaCamisa() {
		return eplTallaCamisa;
	}
	public void setEplTallaCamisa(String eplTallaCamisa) {
		this.eplTallaCamisa = eplTallaCamisa;
	}
	public String getEplTallaZapatos() {
		return eplTallaZapatos;
	}
	public void setEplTallaZapatos(String eplTallaZapatos) {
		this.eplTallaZapatos = eplTallaZapatos;
	}
	public Integer getEstatura() {
		return estatura;
	}
	public void setEstatura(Integer estatura) {
		this.estatura = estatura;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	public boolean isFuma() {
		return this.fuma;		
	}
	public void setFuma(boolean fuma) {
		this.fuma = fuma;
	}
	public boolean isUsalentes() {
		return this.usalentes;
	}
	public void setUsalentes(boolean usalentes) {
		this.usalentes = usalentes;
	}
	public String getEplTallaPantalon() {
		return eplTallaPantalon;
	}
	public void setEplTallaPantalon(String eplTallaPantalon) {
		this.eplTallaPantalon = eplTallaPantalon;
	}
	public Date getFechaNacimientoEmpleado() {
		return fechaNacimientoEmpleado;
	}
	public void setFechaNacimientoEmpleado(Date fechaNacimientoEmpleado) {
		this.fechaNacimientoEmpleado = fechaNacimientoEmpleado;
	}
}