package co.com.activos.JSEL0034.Entidad;

import java.io.Serializable;
import java.util.Date;

/**
 * Modelo de datos entidad TSEL_NUCLEO_FAMILIAR.
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JDK1.6
 */
public class TSelNucleoFamiliar implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tdcTdEpl;
    private Long eplNd;
    private Long dcmRadicacion = new Long(0);
    private Long item = new Long(0);
    private Long edad = new Long(0);
    private String observaciones;
    private String parSigla;
    private String parDescripcion;
    private Long tocuId;
    private String tocuDescripcion;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private Long celular;
    private boolean viveConCandidato;
    private Long tteCodigo;
    private String tteDescripcion;
    private String tnfGenero;

    public TSelNucleoFamiliar() {
    }

    public TSelNucleoFamiliar(String tdcTd, Long eplNd) {
        this.tdcTdEpl = tdcTd;
        this.eplNd = eplNd;
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

    public Long getDcmRadicacion() {
        return dcmRadicacion;
    }

    public void setDcmRadicacion(Long dcmRadicacion) {
        this.dcmRadicacion = dcmRadicacion;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }

    public Long getEdad() {
        return edad;
    }

    public void setEdad(Long edad) {
        this.edad = edad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getTocuId() {
        return tocuId;
    }

    public void setTocuId(Long tocuId) {
        this.tocuId = tocuId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public boolean getViveConCandidato() {
        return viveConCandidato;
    }

    public void setViveConCandidato(boolean viveConCandidato) {
        this.viveConCandidato = viveConCandidato;
    }

    public Long getTteCodigo() {
        return tteCodigo;
    }

    public void setTteCodigo(Long tteCodigo) {
        this.tteCodigo = tteCodigo;
    }

    public String getTocuDescripcion() {
        return tocuDescripcion;
    }

    public void setTocuDescripcion(String tocuDescripcion) {
        this.tocuDescripcion = tocuDescripcion;
    }

    public String getTteDescripcion() {
        return tteDescripcion;
    }

    public void setTteDescripcion(String tteDescripcion) {
        this.tteDescripcion = tteDescripcion;
    }

    public String getParSigla() {
        return parSigla;
    }

    public void setParSigla(String parSigla) {
        this.parSigla = parSigla;
    }

    public String getParDescripcion() {
        return parDescripcion;
    }

    public void setParDescripcion(String parDescripcion) {
        this.parDescripcion = parDescripcion;
    }

    public String getTnfGenero() {
        return tnfGenero;
    }

    public void setTnfGenero(String tnfGenero) {
        this.tnfGenero = tnfGenero;
    }
    
}
