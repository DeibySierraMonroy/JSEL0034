/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.activos.JSEL0034.Entidad;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author anaponte
 */
public class TipoDocumento implements Serializable {

    /**
     * Atributo que contiene el valor de tpdCodigo
     */
    private Long tpdCodigo;

    /**
     * Atributo que contiene el valor de tpdDescripcion
     */
    private String tpdDescripcion;

    /**
     * Atributo que contiene el valor de dtdCodigo
     */
    private Long dtdCodigo;

    /**
     * Atributo que contiene el valor de audFecha
     */
    private Date audFecha;

    /**
     * Atributo que contiene el valor de audUsuario
     */
    private String audUsuario;

    /**
     * Constructor por defecto para la clase
     */
    public TipoDocumento() {
    }

    /**
     * Constructor para la clase
     *
     * @param tpdCodigo
     * @param tpdDescripcion
     * @param dtdCodigo
     * @param audFecha
     * @param audUsuario
     */
    public TipoDocumento(String tpdCodigo, String tpdDescripcion, String dtdCodigo, Date audFecha, String audUsuario) {
        if (tpdCodigo != null) {
            this.tpdCodigo = Long.valueOf(tpdCodigo);
        } else {
            this.tpdCodigo = null;
        }
        this.tpdDescripcion = tpdDescripcion;
        if (dtdCodigo != null) {
            this.dtdCodigo = Long.valueOf(dtdCodigo);
        } else {
            this.dtdCodigo = null;
        }
        this.audFecha = audFecha;
        this.audUsuario = audUsuario;
    }

    //---------------------------GETTERS AND SETTERS----------------------------
    /**
     * Metodo encargado de retornar el valor de tpdCodigo
     *
     * @return
     */
    public Long getTpdCodigo() {
        return tpdCodigo;
    }

    /**
     * Metodo encargado de modificar el valor de tpdCodigo
     *
     * @param tpdCodigo
     */
    public void setTpdCodigo(Long tpdCodigo) {
        this.tpdCodigo = tpdCodigo;
    }

    /**
     * Metodo encargado de retornar el valor de tpdDescripcion
     *
     * @return
     */
    public String getTpdDescripcion() {
        return tpdDescripcion;
    }

    /**
     * Metodo encargado de modificar el valor de tpdDescripcion
     *
     * @param tpdDescripcion
     */
    public void setTpdDescripcion(String tpdDescripcion) {
        this.tpdDescripcion = tpdDescripcion;
    }

    /**
     * Metodo encargado de retornar el valor de dtdCodigo
     *
     * @return
     */
    public Long getDtdCodigo() {
        return dtdCodigo;
    }

    /**
     * Metodo encargado de modificar el valor de dtdCodigo
     *
     * @param dtdCodigo
     */
    public void setDtdCodigo(Long dtdCodigo) {
        this.dtdCodigo = dtdCodigo;
    }

    /**
     * Metodo encargado de retornar el valor de audFecha
     *
     * @return
     */
    public Date getAudFecha() {
        return audFecha;
    }

    /**
     * Metodo encargado de modificar el valor de audFecha
     *
     * @param audFecha
     */
    public void setAudFecha(Date audFecha) {
        this.audFecha = audFecha;
    }

    /**
     * Metodo encargado de retornar el valor de audUsuario
     *
     * @return
     */
    public String getAudUsuario() {
        return audUsuario;
    }

    /**
     * Metodo encargado de modificar el valor de audUsuario
     *
     * @param audUsuario
     */
    public void setAudUsuario(String audUsuario) {
        this.audUsuario = audUsuario;
    }

}
