/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.activos.JSEL0034.Entidad;

import java.io.Serializable;

/**
 *
 * @author anaponte
 */
public class RespuestaWs implements Serializable {
    
    private String estado;
    
    private String idcarpeta;
    
    private String idArchivo;

    public RespuestaWs() {
    
    }

    public RespuestaWs(String estado, String idcarpeta, String idArchivo) {
        this.estado = estado;
        this.idcarpeta = idcarpeta;
        this.idArchivo = idArchivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdcarpeta() {
        return idcarpeta;
    }

    public void setIdcarpeta(String idcarpeta) {
        this.idcarpeta = idcarpeta;
    }

    public String getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(String idArchivo) {
        this.idArchivo = idArchivo;
    }
    
    
    
}
