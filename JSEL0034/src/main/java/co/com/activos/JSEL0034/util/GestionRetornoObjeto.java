/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.activos.JSEL0034.util;

/**
 *
 * @author anaponte
 */
public class GestionRetornoObjeto {

    private Object objetoRetorno;
    private String estadoProceso;
    private String mensajeProceso;

    public GestionRetornoObjeto() {
    }

    public GestionRetornoObjeto(Object objetoRetorno, String estadoProceso, String mensajeProceso) {
        this.objetoRetorno = objetoRetorno;
        this.estadoProceso = estadoProceso;
        this.mensajeProceso = mensajeProceso;
    }

    public String getMensajeProceso() {
        return this.mensajeProceso;
    }

    public void setMensajeProceso(String mensajeProceso) {
        this.mensajeProceso = mensajeProceso;
    }

    public Object getObjetoRetorno() {
        return this.objetoRetorno;
    }

    public void setObjetoRetorno(Object objetoRetorno) {
        this.objetoRetorno = objetoRetorno;
    }

    public String getEstadoProceso() {
        return this.estadoProceso;
    }

    public void setEstadoProceso(String estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

}
