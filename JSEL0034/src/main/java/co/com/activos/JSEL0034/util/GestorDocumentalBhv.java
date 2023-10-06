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
public class GestorDocumentalBhv {

    /**
     * Atributo que contiene el valor de deaCodigo
     */
    private Long deaCodigo;

    /**
     * Atributo que contiene el valor de azCodigoCli
     */
    private Long azCodigoCli;

    /**
     * Atributo que contiene el valor de estadoProceso
     */
    private String estadoProceso;

    /**
     * Atributo que contiene el valor de mensajeProceso
     */
    private String mensajeProceso;

    /**
     * Constructor por defecto para la clase
     */
    public GestorDocumentalBhv() {
    }

    /**
     * Constructor para la clase
     *
     * @param deaCodigo
     * @param azCodigoCli
     * @param estadoProceso
     * @param mensajeProceso
     */
    public GestorDocumentalBhv(String deaCodigo, String azCodigoCli,
            String estadoProceso, String mensajeProceso) {
        if (deaCodigo != null) {
            this.deaCodigo = Long.valueOf(deaCodigo);
        } else {
            this.deaCodigo = null;
        }
        if (azCodigoCli != null) {
            this.azCodigoCli = Long.valueOf(azCodigoCli);
        } else {
            this.azCodigoCli = null;
        }
        this.estadoProceso = estadoProceso;
        this.mensajeProceso = mensajeProceso;
    }

    //-----------------------GETTERS AND SETTERS--------------------------
    /**
     * Metodo encargado de retornar el valor de deaCodigo
     *
     * @return
     */
    public Long getDeaCodigo() {
        return deaCodigo;
    }

    /**
     * Metodo encargado de modificar el valor de deaCodigo
     *
     * @param deaCodigo
     */
    public void setDeaCodigo(Long deaCodigo) {
        this.deaCodigo = deaCodigo;
    }

    /**
     * Metodo encargado de retornar el valor de azCodigoCli
     *
     * @return
     */
    public Long getAzCodigoCli() {
        return azCodigoCli;
    }

    /**
     * Metodo encargado de modificar el valor de azCodigoCli
     *
     * @param azCodigoCli
     */
    public void setAzCodigoCli(Long azCodigoCli) {
        this.azCodigoCli = azCodigoCli;
    }

    /**
     * Metodo encargado de retornar el valor de estadoProceso
     *
     * @return
     */
    public String getEstadoProceso() {
        return estadoProceso;
    }

    /**
     * Metodo encargado de modificar el valor de estadoProceso
     *
     * @param estadoProceso
     */
    public void setEstadoProceso(String estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

    /**
     * Metodo encargado de retornar el valor de mensajeProceso
     *
     * @return
     */
    public String getMensajeProceso() {
        return mensajeProceso;
    }

    /**
     * Metodo encargado de modificar el valor de mensajeProceso
     *
     * @param mensajeProceso
     */
    public void setMensajeProceso(String mensajeProceso) {
        this.mensajeProceso = mensajeProceso;
    }

}
