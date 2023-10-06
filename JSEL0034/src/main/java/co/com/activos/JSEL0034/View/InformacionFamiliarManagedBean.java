package co.com.activos.JSEL0034.View;

import co.com.activos.Utilidad.UtilidadesFACES;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import co.com.activos.JSEL0034.Interfaces.DelegatedEmpleadoSimpleDAO;
import co.com.activos.JSEL0034.Interfaces.DelegatedTSelNucleoFamiliarDAO;
import co.com.activos.JSEL0034.Interfaces.DelegatedTselEntrevistaDatfijoDAO;
import co.com.activos.JSEL0034.Interfaces.DelegatedTselViviendaDAO;
import co.com.activos.JSEL0034.Entidad.EmpleadoSimpleEntity;
import co.com.activos.JSEL0034.Entidad.RespuestaWs;
import co.com.activos.JSEL0034.Entidad.TselEntrevistaDatfijo;
import co.com.activos.JSEL0034.Entidad.TSelNucleoFamiliar;
import co.com.activos.JSEL0034.Entidad.TipoDocumento;
import co.com.activos.JSEL0034.Entidad.TselVivienda;
import co.com.activos.JSEL0034.util.ConsumoWsUtil;
import co.com.activos.JSEL0034.util.GestionRetornoObjeto;
import co.com.activos.JSEL0034.util.GestorDocumentalBhv;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 * Controlador ManagedBean Informacion Familiar.
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class InformacionFamiliarManagedBean implements Serializable {

    /**
     * Atributo que contiene el valor de serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Atributo que contiene el valor de tdcTd
     */
    private String tdcTd;

    /**
     * Atributo que contiene el valor de eplNd
     */
    private Long eplNd;

    /**
     * Atributo que contiene el valor de listaParentesco
     */
    private List<SelectItem> listaParentesco;

    /**
     * Atributo que contiene el valor de listaOcupaciones
     */
    private List<SelectItem> listaOcupaciones;

    /**
     * Atributo que contiene el valor de listaNivelEducativo
     */
    private List<SelectItem> listaNivelEducativo;

    /**
     * Atributo que contiene el valor de nucleoFamiliarRegistro
     */
    private TSelNucleoFamiliar nucleoFamiliarRegistro;

    /**
     * Atributo que contiene el valor de nucleoFamiliar
     */
    private List<TSelNucleoFamiliar> nucleoFamiliar;

    /**
     * Atributo que contiene el valor de capaRenderizadoParientesPopup
     */
    private boolean capaRenderizadoParientesPopup = false;

    /**
     * Atributo que contiene el valor de entrevistaDatfijo
     */
    private TselEntrevistaDatfijo entrevistaDatfijo;

    /**
     * Atributo que contiene el valor de listaTipoVivienda
     */
    private List<SelectItem> listaTipoVivienda;

    /**
     * Atributo que contiene el valor de listaTipoPropiedad
     */
    private List<SelectItem> listaTipoPropiedad;

    /**
     * Atributo que contiene el valor de vivienda
     */
    private TselVivienda vivienda;

    /**
     * Atributo que contiene el valor de empleadoInformacionAdicional
     */
    private EmpleadoSimpleEntity empleadoInformacionAdicional;

    /**
     * Atributo que contiene el valor de listaAnios
     */
    private List<SelectItem> listaAnios;

    /**
     * Atributo que contiene el valor de minFecCalendar
     */
    private Date minFecCalendar;

    /**
     * Atributo que contiene el valor de maxFecCalendar
     */
    private Date maxFecCalendar;

    /**
     * Atributo que contiene el valor de util
     */
    private UtilidadesFACES util;

    /**
     * Atributo que contiene el valor de sesion
     */
    private static HttpSession sesion;

    /**
     * Atributo que contiene el valor de value
     */
    private String value;

    /**
     * Atributo que contiene el valor de listaGenero
     */
    private List<String> listaGenero;

    /**
     * Atributo que contiene el valor de consumoWsUtil
     */
    private ConsumoWsUtil consumoWsUtil;

    /**
     * Atributo que contiene el valor de deaCodigo
     */
    private String deaCodigo;

    /**
     * Atributo que contiene el valor de azCodigoCli
     */
    private String azCodigoCli;

    /**
     * Constructor para la clase
     */
    public InformacionFamiliarManagedBean() {
        this.sesion = ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true));
        util = new UtilidadesFACES();
        if (!util.consultar_session()) {
            util.ir("index.html");
            return;
        }
        consumoWsUtil = new ConsumoWsUtil();

        // Fechas limites calendarios
        setMinFecCalendar(new Date());
        Calendar c = Calendar.getInstance();
        c.setTime(getMinFecCalendar());
        c.add(Calendar.YEAR, -99);
        setMaxFecCalendar(c.getTime());
        InicializarVariables();
        obtenerDatos();
        inicializarDatos();
    }

    /**
     * Metodo encargado de inicializar los datos del bean
     */
    public void InicializarVariables() {
        listaGenero = new ArrayList<String>();
        String masculino = "M";
        String femenino = "F";
        listaGenero.add(masculino);
        listaGenero.add(femenino);
    }

    /**
     * Metodo encargado de obterner los datos del usuario
     */
    private void obtenerDatos() {
        // Cargar datos del usuario conectado en el Liferay
        setTdcTd((String) util.consultarParam("TDC_TD_EPL"));
        setEplNd(Long.valueOf((String) util.consultarParam("EPL_ND")));
        this.setValue((String) util.consultarParam("BUTTON"));
        deaCodigo = (String) util.consultarParam("DEA_CODIGO");
        azCodigoCli = (String) util.consultarParam("AZCODIGO_CLI");
    }

    /**
     * Inicializados de datos
     */
    public final void inicializarDatos() {
        // Listas
        setListaNivelEducativo(DelegatedTSelNucleoFamiliarDAO.cargarListaDependenciasNucleoFamiliar("NIVEL_ESTUDIO"));
        setListaOcupaciones(DelegatedTSelNucleoFamiliarDAO.cargarListaDependenciasNucleoFamiliar("OCUPACION"));
        setListaParentesco(DelegatedTSelNucleoFamiliarDAO.cargarListaDependenciasNucleoFamiliar("PARENTESCO"));
        // Nucleo Familiar
        setNucleoFamiliar(DelegatedTSelNucleoFamiliarDAO.cargarNucleoFamiliarEmpleado(getTdcTd(), getEplNd()));
        // Informacion extra del empleado
        setEmpleadoInformacionAdicional(DelegatedEmpleadoSimpleDAO.cargarInformacionAdicionalEmpleado(getTdcTd(), getEplNd()));

        // cargar informacion entrevista dat fijo y vivienda empleado
        setEntrevistaDatfijo(DelegatedTselEntrevistaDatfijoDAO.cargarEntrevistaDatFijoEmpleado(getTdcTd(), getEplNd()));
        setVivienda(DelegatedTselViviendaDAO.cargarInformacionVivienda(getTdcTd(), getEplNd()));
        // asignar valores numericos para año y mes vivienda
        if ((getVivienda().getFechaInicial() != null)) {
            getVivienda().setFechaInicialAnio(getVivienda().getFechaInicial().getYear());
            getVivienda().setFechaInicialMes(getVivienda().getFechaInicial().getMonth());
        }
        inicializarListaAnios();
        setListaTipoPropiedad(DelegatedTselViviendaDAO.cargarListaTipoLlaveVivienda("TIPO_PROPIEDAD"));
        setListaTipoVivienda(DelegatedTselViviendaDAO.cargarListaTipoLlaveVivienda("TIPO_VIVIENDA"));
    }

    /**
     * Agrega nuevo registro de nucleo familiar
     *
     * @return
     */
    public String agregarRegistroNucleoFamiliar() {
        setNucleoFamiliarRegistro(new TSelNucleoFamiliar(getTdcTd(), getEplNd()));
        setCapaRenderizadoParientesPopup(true);
        return null;
    }

    /**
     * Proceso de Modidicacion registro nucleo familiar.
     *
     * @return
     */
    public String modificarRegistroNucleoFamiliar() {
        setCapaRenderizadoParientesPopup(true);
        return null;
    }

    /**
     * Borrado registro Nucleo Familiar
     *
     * @return
     */
    public String eliminarRegistroNucleoFamiliar() {
        try {
            DelegatedTSelNucleoFamiliarDAO.eliminarRegistroNucleoFamiliar(getNucleoFamiliarRegistro());
            inicializarDatos();
            setCapaRenderizadoParientesPopup(false);
            setNucleoFamiliarRegistro(new TSelNucleoFamiliar(getTdcTd(), getEplNd()));
            util.agregaMensaje("INFO2", "Registro eliminado correctamente");
        } catch (Exception e) {
            util.agregaMensaje("ERROR2", "En este momento no es posible eliminar esta informacion, por favor intenta nuevamente");
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Guardado informacion Familiar.
     *
     * @return
     */
    @SuppressWarnings("deprecation")
    public String guardar() {
        try {
            if (getEntrevistaDatfijo().getEdfNumeroHijos() == null || getEntrevistaDatfijo().getEdfNumHijosVivenCandt() == null) {
                getEntrevistaDatfijo().setEdfNumeroHijos(0);
                getEntrevistaDatfijo().setEdfNumHijosVivenCandt(0);
            }

            // asignar valores numericos para año y mes vivienda
            if (getVivienda().getFechaInicial() == null) {
                getVivienda().setFechaInicial(new Date());
            }

            if (getVivienda().getFechaInicialAnio() != null && getVivienda().getFechaInicialMes() != null) {
                getVivienda().getFechaInicial().setYear(getVivienda().getFechaInicialAnio());
                getVivienda().getFechaInicial().setMonth(getVivienda().getFechaInicialMes());
                getVivienda().getFechaInicial().setDate(1);
            }

            if (getEntrevistaDatfijo().getEdfNumHijosVivenCandt() > getEntrevistaDatfijo().getEdfNumeroHijos()) {
                util.agregaMensaje("ERROR2", "Usted no puede Vivir con mas Hijos de los que tiene, Verifique la informacion");
            } else {
                DelegatedTSelNucleoFamiliarDAO.guardarRegistroNucleoFamiliar(getNucleoFamiliarRegistro());
                DelegatedTselEntrevistaDatfijoDAO.guardarEntrevistaDatFijo(getEntrevistaDatfijo());
                DelegatedTselViviendaDAO.guardarInformacionViviendaEmpleado(getVivienda());
                setCapaRenderizadoParientesPopup(false);
                inicializarDatos();
                setNucleoFamiliarRegistro(new TSelNucleoFamiliar(getTdcTd(), getEplNd()));
                generarHvActivos();
                util.agregaMensaje("INFO2", "Informacion familiar almacenada correctamente en el sistema");
            }
        } catch (Exception e) {
            e.printStackTrace();
            util.agregaMensaje("ERROR2", "En este momento no es posible guardar tu informacion, por favor intenta nuevamente");
            setCapaRenderizadoParientesPopup(false);
        }
        return null;
    }

    /**
     * Metodo encargado de crear el archivo PDF de la hoja de vida de activos y
     * subirla al gestor documental
     *
     * @author Andres Aponte - anaponte@activos.com.co
     */
    private void generarHvActivos() {
        if (deaCodigo != null && azCodigoCli != null) {
            GestionRetornoObjeto ruta = DelegatedTSelNucleoFamiliarDAO.generarPdf(getTdcTd(), getEplNd());
            if (ruta != null && ruta.getEstadoProceso().equals("S")) {
                String objetoRetorno = (String) ruta.getObjetoRetorno();
                TipoDocumento tipoDocumento = DelegatedTSelNucleoFamiliarDAO.obtenerTipoDocumento("HVINFGEN");
                String archivoB64 = getContenidoHTML(objetoRetorno, 1);
                cargarArchivo(archivoB64, tipoDocumento, "pdf");
            }
        } else {
            util.agregaMensaje("ERROR", "Estimado usuario su cuenta, no tiene una carpeta donde almacenar los archivos");
        }
    }

    /**
     * Metodo encargado de obtener el archivo en servidor de impresion de la
     * hoja de vida, para cargarlo al gestor documental
     *
     * @param URL
     * @param contador
     * @return
     */
    public static String getContenidoHTML(String URL, Integer contador) {
        try {
            long n = System.currentTimeMillis();
            HttpURLConnection conn = (HttpURLConnection) new URL(URL).openConnection();
            conn.connect();
            if (conn.getResponseCode() == 500) {
                if (contador < 3) {
                    contador += 1;
                    String respuestaError = getContenidoHTML(URL, contador);
                    if (respuestaError != null) {
                        return respuestaError;
                    }
                } else if (contador > 3) {
                    return null;
                }
            }
            InputStream in = conn.getInputStream();

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[16384];

            while ((nRead = in.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.toByteArray();

            byte[] name = Base64.encodeBase64(buffer.toByteArray());
            String myString = new String(name, Charset.forName("UTF-8"));
            return myString;

        } catch (MalformedURLException ex) {
            return ex.getMessage();
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }

    /**
     * Cerrar ventana de edicion
     *
     * @return
     */
    public String cancelarEdicion() {
        setCapaRenderizadoParientesPopup(false);
        setNucleoFamiliarRegistro(new TSelNucleoFamiliar(getTdcTd(), getEplNd()));
        return null;
    }

    /**
     * Inicializacion de lista de anios disponibles para la fecha desde
     */
    @SuppressWarnings("deprecation")
    public void inicializarListaAnios() {
        if (getEmpleadoInformacionAdicional().getFechaNacimientoEmpleado() != null) {
            setListaAnios(new ArrayList<SelectItem>());
            Integer anioDesde = getEmpleadoInformacionAdicional().getFechaNacimientoEmpleado().getYear();
            Integer anioHasta = new Date().getYear();

            for (int t = anioDesde; t <= anioHasta; t++) {
                getListaAnios().add(new SelectItem(t, (String.valueOf(t + 1900))));
            }
        }
    }

    /**
     * Metodo encargado de convertir un archivo en base64 para ser enviado al
     * webservice de gestor documental
     *
     * @author Andres Aponte - anaponte@activos.com.co
     * @return
     */
    private String encodeb64(UploadedFile uploadedFile) {
        String encodedString = null;
        try {
            byte[] content = uploadedFile.getContents();
            byte[] encoded = Base64.encodeBase64(content);
            encodedString = new String(encoded);
        } catch (Exception e) {
            System.out.println(e);
        }
        return encodedString;
    }

    /**
     * Metodo encargado de enviar el archivo seleccionado por el usuario como
     * referencia personal al gestor documental
     *
     * @author Andres Aponte - anaponte@activos.com.co
     * @param event
     */
    public void cargarRefFamiliar(FileUploadEvent event) {
        if (azCodigoCli != null && deaCodigo != null) {
            UploadedFile uploadedFile = event.getFile();
            String extension = FilenameUtils.getExtension(uploadedFile.getFileName());
            TipoDocumento tipoDocumento = DelegatedTSelNucleoFamiliarDAO.obtenerTipoDocumento("REFPERSONAL");
            String refFamBase64 = encodeb64(uploadedFile);
            cargarArchivo(refFamBase64, tipoDocumento, extension);
        } else {
            util.agregaMensaje("ERROR", "Estimado usuario, su cuenta no tiene carpeta para cargar archivos");
        }
    }

    /**
     * Metodo encargado de cargar achivos a azDigital
     *
     * @author Andres Aponte - anaponte@activos.com.co
     * @param base64
     * @param tipoDocumento
     * @param extension
     */
    private void cargarArchivo(String base64, TipoDocumento tipoDocumento, String extension) {
        if ((base64 != null) && (tipoDocumento != null)) {
            GestorDocumentalBhv retornoCreaArchivo = DelegatedTSelNucleoFamiliarDAO.crearDeaCodigo(this.deaCodigo, tipoDocumento.getTpdCodigo(), this.util
                    .getUsuarioSesionControlador().getUsuarioSesion().getUsuUsuario(), tipoDocumento
                            .getTpdCodigo() + " " + tipoDocumento.getTpdDescripcion().toLowerCase());
            if ((retornoCreaArchivo != null) && (retornoCreaArchivo.getEstadoProceso().equals("S"))) {
                GestionRetornoObjeto retorno = DelegatedTSelNucleoFamiliarDAO.wsCargarArchivo(Long.valueOf(this.azCodigoCli), retornoCreaArchivo
                        .getMensajeProceso().toLowerCase() + "." + extension);
                String xmlInput = retorno.getMensajeProceso().replace("$CLARCHIVO$", base64);
                String respuesta = this.consumoWsUtil.consumirWebService((String) retorno.getObjetoRetorno(), xmlInput);

                GestionRetornoObjeto retornoRespuestaWs = DelegatedTSelNucleoFamiliarDAO.procesarRespuestaWs(xmlInput, respuesta);
                if ((retornoRespuestaWs != null) && (retornoRespuestaWs.getEstadoProceso().equals("S")) && (retornoRespuestaWs.getObjetoRetorno() != null)) {
                    RespuestaWs respuestaWs = (RespuestaWs) retornoRespuestaWs.getObjetoRetorno();
                    GestionRetornoObjeto retornoActualizaAzCodigo = DelegatedTSelNucleoFamiliarDAO.actualizaAzCodigoCli(retornoCreaArchivo.getDeaCodigo(), respuestaWs
                            .getIdArchivo(), retornoCreaArchivo.getMensajeProceso() + "." + extension);
                    this.util.agregaMensaje("INFO", "Archivo cargado con exito");
                } else {
                    GestionRetornoObjeto retornoEliminarData = DelegatedTSelNucleoFamiliarDAO.eliminarDataErp(retornoCreaArchivo.getDeaCodigo());
                    this.util.agregaMensaje("ERROR", retornoRespuestaWs.getMensajeProceso());
                }
            } else if ((retornoCreaArchivo != null) && (retornoCreaArchivo.getEstadoProceso().equals("N"))) {
                this.util.agregaMensaje("ERROR", retornoCreaArchivo.getMensajeProceso());
            }
        } else if (base64 == null) {
            this.util.agregaMensaje("ERROR", "No es posible convertir el archivo a base64");
        } else if (tipoDocumento == null) {
            this.util.agregaMensaje("ERROR", "No existe el tipo de documento");
        }
    }

    //--------------------------GETTERS AND SETTERS-----------------------------
    /**
     * Metodo encargado de retornar el valor de tdcTd
     *
     * @return
     */
    public String getTdcTd() {
        return tdcTd;
    }

    /**
     * Metodo encargado de modificar el valor de tdcTd
     *
     * @param tdcTd
     */
    public void setTdcTd(String tdcTd) {
        this.tdcTd = tdcTd;
    }

    /**
     * Metodo encargado de retornar el valor de eplNd
     *
     * @return
     */
    public Long getEplNd() {
        return eplNd;
    }

    /**
     * Metodo encargado de modificar el valor de eplNd
     *
     * @param eplNd
     */
    public void setEplNd(Long eplNd) {
        this.eplNd = eplNd;
    }

    /**
     * Metodo encargado de retornar el valor de nucleoFamiliarRegistro
     *
     * @return
     */
    public TSelNucleoFamiliar getNucleoFamiliarRegistro() {
        return nucleoFamiliarRegistro;
    }

    /**
     * Metodo encargado de modificar el valor de nucleoFamiliarRegistro
     *
     * @param nucleoFamiliarRegistro
     */
    public void setNucleoFamiliarRegistro(TSelNucleoFamiliar nucleoFamiliarRegistro) {
        this.nucleoFamiliarRegistro = nucleoFamiliarRegistro;
    }

    /**
     * Metodo encargado de retornar el valor de nucleoFamiliar
     *
     * @return
     */
    public List<TSelNucleoFamiliar> getNucleoFamiliar() {
        return nucleoFamiliar;
    }

    /**
     * Metodo encargado de modificar el valor de nucleoFamiliar
     *
     * @param nucleoFamiliar
     */
    public void setNucleoFamiliar(List<TSelNucleoFamiliar> nucleoFamiliar) {
        this.nucleoFamiliar = nucleoFamiliar;
    }

    /**
     * Metodo encargado de retornar el valor de listaOcupaciones
     *
     * @return
     */
    public List<SelectItem> getListaOcupaciones() {
        return listaOcupaciones;
    }

    /**
     * Metodo encargado de modificar el valor de listaOcupaciones
     *
     * @param listaOcupaciones
     */
    public void setListaOcupaciones(List<SelectItem> listaOcupaciones) {
        this.listaOcupaciones = listaOcupaciones;
    }

    /**
     * Metodo encargado de retornar el valor de listaNivelEducativo
     *
     * @return
     */
    public List<SelectItem> getListaNivelEducativo() {
        return listaNivelEducativo;
    }

    /**
     * Metodo encargado de modificar el valor de listaNivelEducativo
     *
     * @param listaNivelEducativo
     */
    public void setListaNivelEducativo(List<SelectItem> listaNivelEducativo) {
        this.listaNivelEducativo = listaNivelEducativo;
    }

    /**
     * Metodo encargado de retornar el valor de listaParentesco
     *
     * @return
     */
    public List<SelectItem> getListaParentesco() {
        return listaParentesco;
    }

    /**
     * Metodo encargado de modificar el valor de listaParentesco
     *
     * @param listaParentesco
     */
    public void setListaParentesco(List<SelectItem> listaParentesco) {
        this.listaParentesco = listaParentesco;
    }

    /**
     * Metodo encargado de retornar el valor de capaRenderizadoParientesPopup
     *
     * @return
     */
    public boolean isCapaRenderizadoParientesPopup() {
        return capaRenderizadoParientesPopup;
    }

    /**
     * Metodo encargado de modificar el valor de capaRenderizadoParientesPopup
     *
     * @param capaRenderizadoParientesPopup
     */
    public void setCapaRenderizadoParientesPopup(
            boolean capaRenderizadoParientesPopup) {
        this.capaRenderizadoParientesPopup = capaRenderizadoParientesPopup;
    }

    /**
     * Metodo encargado de retornar el valor de vivienda
     *
     * @return
     */
    public TselVivienda getVivienda() {
        return vivienda;
    }

    /**
     * Metodo encargado de modificar el valor de vivienda
     *
     * @param vivienda
     */
    public void setVivienda(TselVivienda vivienda) {
        this.vivienda = vivienda;
    }

    /**
     * Metodo encargado de retornar el valor de entrevistaDatfijo
     *
     * @return
     */
    public TselEntrevistaDatfijo getEntrevistaDatfijo() {
        return entrevistaDatfijo;
    }

    /**
     * Metodo encargado de modificar el valor de entrevistaDatfijo
     *
     * @param entrevistaDatfijo
     */
    public void setEntrevistaDatfijo(TselEntrevistaDatfijo entrevistaDatfijo) {
        this.entrevistaDatfijo = entrevistaDatfijo;
    }

    /**
     * Metodo encargado de retornar el valor de listaTipoVivienda
     *
     * @return
     */
    public List<SelectItem> getListaTipoVivienda() {
        return listaTipoVivienda;
    }

    /**
     * Metodo encargado de modificar el valor de listaTipoVivienda
     *
     * @param listaTipoVivienda
     */
    public void setListaTipoVivienda(List<SelectItem> listaTipoVivienda) {
        this.listaTipoVivienda = listaTipoVivienda;
    }

    /**
     * Metodo encargado de retornar el valor de listaTipoPropiedad
     *
     * @return
     */
    public List<SelectItem> getListaTipoPropiedad() {
        return listaTipoPropiedad;
    }

    /**
     * Metodo encargado de modificar el valor de listaTipoPropiedad
     *
     * @param listaTipoPropiedad
     */
    public void setListaTipoPropiedad(List<SelectItem> listaTipoPropiedad) {
        this.listaTipoPropiedad = listaTipoPropiedad;
    }

    /**
     * Metodo encargado de retornar el valor de empleadoInformacionAdicional
     *
     * @return
     */
    public EmpleadoSimpleEntity getEmpleadoInformacionAdicional() {
        return empleadoInformacionAdicional;
    }

    /**
     * Metodo encargado de modificar el valor de empleadoInformacionAdicional
     *
     * @param empleadoInformacionAdicional
     */
    public void setEmpleadoInformacionAdicional(
            EmpleadoSimpleEntity empleadoInformacionAdicional) {
        this.empleadoInformacionAdicional = empleadoInformacionAdicional;
    }

    /**
     * Metodo encargado de retornar el valor de listaAnios
     *
     * @return
     */
    public List<SelectItem> getListaAnios() {
        return listaAnios;
    }

    /**
     * Metodo encargado de modificar el valor de listaAnios
     *
     * @param listaAnios
     */
    public void setListaAnios(List<SelectItem> listaAnios) {
        this.listaAnios = listaAnios;
    }

    /**
     * Metodo encargado de retornar el valor de minFecCalendar
     *
     * @return
     */
    public Date getMinFecCalendar() {
        return minFecCalendar;
    }

    /**
     * Metodo encargado de modificar el valor de minFecCalendar
     *
     * @param minFecCalendar
     */
    public void setMinFecCalendar(Date minFecCalendar) {
        this.minFecCalendar = minFecCalendar;
    }

    /**
     * Metodo encargado de retornar el valor de maxFecCalendar
     *
     * @return
     */
    public Date getMaxFecCalendar() {
        return maxFecCalendar;
    }

    /**
     * Metodo encargado de modificar el valor de maxFecCalendar
     *
     * @param maxFecCalendar
     */
    public void setMaxFecCalendar(Date maxFecCalendar) {
        this.maxFecCalendar = maxFecCalendar;
    }

    /**
     * Metodo encargado de retornar el valor de value
     *
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     * Metodo encargado de modificar el valor de value
     *
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Metodo encargado de retornar el valor de listaGenero
     *
     * @return
     */
    public List<String> getListaGenero() {
        return listaGenero;
    }

    /**
     * Metodo encargado de modificar el valor de listaGenero
     *
     * @param listaGenero
     */
    public void setListaGenero(List<String> listaGenero) {
        this.listaGenero = listaGenero;
    }

}
