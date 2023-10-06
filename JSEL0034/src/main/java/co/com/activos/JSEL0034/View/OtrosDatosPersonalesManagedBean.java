package co.com.activos.JSEL0034.View;

import co.com.activos.Utilidad.UtilidadesFACES;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import co.com.activos.JSEL0034.Interfaces.DelegatedEmpleadoSimpleDAO;
import co.com.activos.JSEL0034.Interfaces.DelegatedTselEmpleadoSGSSDAO;
import co.com.activos.JSEL0034.Interfaces.DelegatedTselEmpleadoTransporteDAO;
import co.com.activos.JSEL0034.Interfaces.DelegatedTselExpandoEmpleadoDAO;
import co.com.activos.JSEL0034.Entidad.EmpleadoSimpleEntity;
import co.com.activos.JSEL0034.Entidad.EmpresaEntity;
import co.com.activos.JSEL0034.Entidad.TselEmpleadoSGSSSimpleEntity;
import co.com.activos.JSEL0034.Entidad.TselEmpleadoTransporteEntity;
import co.com.activos.JSEL0034.Entidad.TselExpandoEmpleadoEntity;

/**
 * Controlador capa presentacion otros datos personales.
 *
 * @author Jairo Andres Rivera
 * @version 1.0
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class OtrosDatosPersonalesManagedBean implements Serializable {

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
     * Atributo que contiene el valor de listaTipoTransporte
     */
    private List<SelectItem> listaTipoTransporte;

    /**
     * Atributo que contiene el valor de empleadoTransporte
     */
    private TselEmpleadoTransporteEntity empleadoTransporte;

    /**
     * Atributo que contiene el valor de listaEmpleadoTransporte
     */
    private List<TselEmpleadoTransporteEntity> listaEmpleadoTransporte;

    /**
     * Atributo que contiene el valor de listaEmpleadoTransporteLong
     */
    private List<Long> listaEmpleadoTransporteLong;

    /**
     * Atributo que contiene el valor de listaEliminarTransporte
     */
    private HashMap<Long, Object> listaEliminarTransporte;

    /**
     * Atributo que contiene el valor de teiIdHobby
     */
    private Long teiIdHobby;

    /**
     * Atributo que contiene el valor de tevValorHobby
     */
    private String tevValorHobby;

    /**
     * Atributo que contiene el valor de teiIdDeportes
     */
    private Long teiIdDeportes;

    /**
     * Atributo que contiene el valor de tevValorDeporte
     */
    private String tevValorDeporte;

    /**
     * Atributo que contiene el valor de teiIdAntecedenteMedico
     */
    private Long teiIdAntecedenteMedico;

    /**
     * Atributo que contiene el valor de tevValorAntecedenteMedico
     */
    private String tevValorAntecedenteMedico;

    /**
     * Atributo que contiene el valor de teiIdMedicamento
     */
    private Long teiIdMedicamento;

    /**
     * Atributo que contiene el valor de tevValorMedico
     */
    private String tevValorMedico;

    /**
     * Atributo que contiene el valor de teiIdAlergia
     */
    private Long teiIdAlergia;

    /**
     * Atributo que contiene el valor de tevValorAlergia
     */
    private String tevValorAlergia;

    /**
     * Atributo que contiene el valor de expandoSeleccion
     */
    private TselExpandoEmpleadoEntity expandoSeleccion;

    /**
     * Atributo que contiene el valor de hobby
     */
    private List<TselExpandoEmpleadoEntity> hobby;

    /**
     * Atributo que contiene el valor de deportes
     */
    private List<TselExpandoEmpleadoEntity> deportes;

    /**
     * Atributo que contiene el valor de medicamentos
     */
    private List<TselExpandoEmpleadoEntity> medicamentos;

    /**
     * Atributo que contiene el valor de antecedentesMedicos
     */
    private List<TselExpandoEmpleadoEntity> antecedentesMedicos;

    /**
     * Atributo que contiene el valor de alergias
     */
    private List<TselExpandoEmpleadoEntity> alergias;

    /**
     * Atributo que contiene el valor de empleadoSimpleInformation
     */
    private EmpleadoSimpleEntity empleadoSimpleInformation;

    /**
     * Atributo que contiene el valor de listaTallaZapatos
     */
    private List<SelectItem> listaTallaZapatos;

    /**
     * Atributo que contiene el valor de listaTallaCamisa
     */
    private List<SelectItem> listaTallaCamisa;

    /**
     * Atributo que contiene el valor de listaTallaPantalon
     */
    private List<SelectItem> listaTallaPantalon;

    /**
     * Atributo que contiene el valor de listaEmpresasAFP
     */
    private List<SelectItem> listaEmpresasAFP;

    /**
     * Atributo que contiene el valor de codigoAFP
     */
    private String codigoAFP;

    /**
     * Atributo que contiene el valor de codigoEPS
     */
    private String codigoEPS;

    /**
     * Atributo que contiene el valor de listaEmpresasEPS
     */
    private List<SelectItem> listaEmpresasEPS;

    /**
     * Atributo que contiene el valor de empleadoSGSS
     */
    private TselEmpleadoSGSSSimpleEntity empleadoSGSS;

    /**
     * Atributo que contiene el valor de util
     */
    private UtilidadesFACES util;
    
    /**
     * Atributo que contiene el valor de value
     */
    private String value;

    /**
     * Constructor para la clase
     */
    public OtrosDatosPersonalesManagedBean() {
        inicializarVariable();
        obtenerDatosUsuario();
        inicializarDatos();
    }

    /**
     * Metodo encargado de inicializar las variables del bean
     */
    public void inicializarVariable() {
        util = new UtilidadesFACES();
        listaEmpleadoTransporte = new ArrayList<TselEmpleadoTransporteEntity>();
        listaEmpleadoTransporteLong = new ArrayList<Long>();
        listaEliminarTransporte = new HashMap<Long, Object>();
    }

    /**
     * Metodo encaragod de obtener los datos de usuario
     */
    private void obtenerDatosUsuario() {
        setTdcTd((String) util.consultarParam("TDC_TD_EPL"));
        setEplNd(Long.valueOf((String) util.consultarParam("EPL_ND")));
        this.setValue((String) util.consultarParam("BUTTON"));
    }

    /**
     * Inicializador datos capa presentacion.
     */
    public final void inicializarDatos() {
        //Carga los tipo de transporte
        setListaTipoTransporte(DelegatedTselEmpleadoTransporteDAO.cargarListaTiposTransporte());
        cargarListaEliminarTrans();
        //Trae los tipos de transporte que tiene el usuario
        setListaEmpleadoTransporte(DelegatedTselEmpleadoTransporteDAO.cargarInformacionEmpleadoTransporte(getTdcTd(), getEplNd()));
        if (getListaEmpleadoTransporte() != null && !getListaEmpleadoTransporte().isEmpty()) {
            for (int i = 0; i < getListaEmpleadoTransporte().size(); i++) {
                getListaEmpleadoTransporte().get(i).setTdcTd(getTdcTd());
                getListaEmpleadoTransporte().get(i).setEplNd(getEplNd());
                listaEmpleadoTransporteLong.add(getListaEmpleadoTransporte().get(i).getTveIdTipoVehiculo());
            }
        }
        //Inicializar valor de constantes y datos ExpandoEmpleado
        setTeiIdDeportes(DelegatedTselExpandoEmpleadoDAO.cargarConstanteExpando("EXP_DEP"));
        setDeportes(DelegatedTselExpandoEmpleadoDAO.cargarEstrucutraExpandoEmpleado(getTdcTd(), getEplNd(), getTeiIdDeportes()));

        setTeiIdHobby(DelegatedTselExpandoEmpleadoDAO.cargarConstanteExpando("EXP_HOBBY"));
        setHobby(DelegatedTselExpandoEmpleadoDAO.cargarEstrucutraExpandoEmpleado(getTdcTd(), getEplNd(), getTeiIdHobby()));

        setTeiIdMedicamento(DelegatedTselExpandoEmpleadoDAO.cargarConstanteExpando("EXP_MEDICA"));
        setMedicamentos(DelegatedTselExpandoEmpleadoDAO.cargarEstrucutraExpandoEmpleado(getTdcTd(), getEplNd(), getTeiIdMedicamento()));

        setTeiIdAlergia(DelegatedTselExpandoEmpleadoDAO.cargarConstanteExpando("EXP_ALERG"));
        setAlergias(DelegatedTselExpandoEmpleadoDAO.cargarEstrucutraExpandoEmpleado(getTdcTd(), getEplNd(), getTeiIdAlergia()));

        setTeiIdAntecedenteMedico(DelegatedTselExpandoEmpleadoDAO.cargarConstanteExpando("EXP_ANTMED"));
        setAntecedentesMedicos(DelegatedTselExpandoEmpleadoDAO.cargarEstrucutraExpandoEmpleado(getTdcTd(), getEplNd(), getTeiIdAntecedenteMedico()));

        // Cargar informacion adicional del empleado (Tallas, fuma , toma ..)
        setEmpleadoSimpleInformation(DelegatedEmpleadoSimpleDAO.cargarInformacionAdicionalEmpleado(getTdcTd(), getEplNd()));
        // Cargue de listas Tallas
        setListaTallaCamisa(DelegatedEmpleadoSimpleDAO.cargarListaTallasEmpleado(getTdcTd(), getEplNd(), "CAMISA", "N/A"));
        setListaTallaPantalon(DelegatedEmpleadoSimpleDAO.cargarListaTallasEmpleado(getTdcTd(), getEplNd(), "PANTALON", "S"));
        setListaTallaZapatos(DelegatedEmpleadoSimpleDAO.cargarListaTallasEmpleado(getTdcTd(), getEplNd(), "ZAPATOS", "N/A"));

        // cargar datos SGSS
        setEmpleadoSGSS(DelegatedTselEmpleadoSGSSDAO.cargarInformacionSGSSEmpleado(getTdcTd(), getEplNd()));
        setCodigoAFP(getEmpleadoSGSS().getAfp());
        setCodigoEPS(getEmpleadoSGSS().getEps());
        // lista AFP y EPS
        setListaEmpresasAFP(new ArrayList<SelectItem>());
        getListaEmpresasAFP().add(new SelectItem("NA<>0", "Ninguna / No Aplica"));
        for (EmpresaEntity em : DelegatedTselEmpleadoSGSSDAO.cargarEmpresasSGSS("AFP")) {
            getListaEmpresasAFP().add(new SelectItem((em.getTdcTd() + "<>" + em.getEmpNd()), em.getEmpNombre()));
        }

        setListaEmpresasEPS(new ArrayList<SelectItem>());
        getListaEmpresasEPS().add(new SelectItem("NA<>0", "Ninguna / No Aplica"));
        for (EmpresaEntity em : DelegatedTselEmpleadoSGSSDAO.cargarEmpresasSGSS("EPS")) {
            getListaEmpresasEPS().add(new SelectItem((em.getTdcTd() + "<>" + em.getEmpNd()), em.getEmpNombre()));
        }
    }

    /**
     * Metodo encargado de cargar la lista eliminar transporte
     */
    public void cargarListaEliminarTrans() {
        for (SelectItem item : getListaTipoTransporte()) {
            listaEliminarTransporte.put(Long.parseLong(item.getValue().toString()), item.getLabel());
        }
    }

    /**
     * Realiza proceso de guardado de los datos modificados en pantalla
     *
     * @return
     */
    public String guardarCambios() {
        try {
            DelegatedTselEmpleadoTransporteDAO.guardarInformacionEmpleadoTransporte(generarListaEmpleadosTransporte());
            Object[] arrayTemp = generarListaTransporteEliminar();
            for (int i = 0; i < arrayTemp.length; i++) {
                DelegatedTselEmpleadoTransporteDAO.eliminarIInformacionEmpleadoTransporte(getTdcTd(), getEplNd(), (Long) arrayTemp[i]);
            }
            DelegatedEmpleadoSimpleDAO.guardarInformacionAdicionalEmpleado(getEmpleadoSimpleInformation());
            getEmpleadoSGSS().setAfp(getCodigoAFP());
            getEmpleadoSGSS().setEps(getCodigoEPS());
            DelegatedTselEmpleadoSGSSDAO.guardarInformacionSGSSEmpleado(getEmpleadoSGSS());
            util.agregaMensaje("INFO2", "Informacion guardada correctamente en nuestro sistema.");
        } catch (Exception e) {
            util.agregaMensaje("ERROR2", "Lo sentimos pero en este momento no es posible guardar la Informacion");
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Agrega el nuevo registro a la estructura ExpandoEmpleado
     *
     * @param origen
     * @return
     */
    public String agregarExandoValue(String origen) {
        try {
            if (origen.equals("hobby")) {
                DelegatedTselExpandoEmpleadoDAO.asociarExpandoValueEmpleado(getTdcTd(), getEplNd(), getTeiIdHobby(), getTevValorHobby());
                setHobby(DelegatedTselExpandoEmpleadoDAO.cargarEstrucutraExpandoEmpleado(getTdcTd(), getEplNd(), getTeiIdHobby()));
                setTevValorHobby("");
                util.agregaMensaje("INFO2", "el valor fua agregado correctamente");
            } else if (origen.equals("deporte")) {
                DelegatedTselExpandoEmpleadoDAO.asociarExpandoValueEmpleado(getTdcTd(), getEplNd(), getTeiIdDeportes(), getTevValorDeporte());
                setDeportes(DelegatedTselExpandoEmpleadoDAO.cargarEstrucutraExpandoEmpleado(getTdcTd(), getEplNd(), getTeiIdDeportes()));
                setTevValorDeporte("");
                util.agregaMensaje("INFO2", "el valor fua agregado correctamente");
            } else if (origen.equals("alergia")) {
                DelegatedTselExpandoEmpleadoDAO.asociarExpandoValueEmpleado(getTdcTd(), getEplNd(), getTeiIdAlergia(), getTevValorAlergia());
                setAlergias(DelegatedTselExpandoEmpleadoDAO.cargarEstrucutraExpandoEmpleado(getTdcTd(), getEplNd(), getTeiIdAlergia()));
                setTevValorAlergia("");
                util.agregaMensaje("INFO2", "el valor fua agregado correctamente");
            } else if (origen.equals("antecedenteMedico")) {
                DelegatedTselExpandoEmpleadoDAO.asociarExpandoValueEmpleado(getTdcTd(), getEplNd(), getTeiIdAntecedenteMedico(), getTevValorAntecedenteMedico());
                setAntecedentesMedicos(DelegatedTselExpandoEmpleadoDAO.cargarEstrucutraExpandoEmpleado(getTdcTd(), getEplNd(), getTeiIdAntecedenteMedico()));
                setTevValorAntecedenteMedico("");
                util.agregaMensaje("INFO2", "el valor fua agregado correctamente");
            } else if (origen.equals("medicamento")) {
                DelegatedTselExpandoEmpleadoDAO.asociarExpandoValueEmpleado(getTdcTd(), getEplNd(), getTeiIdMedicamento(), getTevValorMedico());
                setMedicamentos(DelegatedTselExpandoEmpleadoDAO.cargarEstrucutraExpandoEmpleado(getTdcTd(), getEplNd(), getTeiIdMedicamento()));
                setTevValorMedico("");
                util.agregaMensaje("INFO2", "el valor fua agregado correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            util.agregaMensaje("ERROR2", e.getMessage().replace("java.lang.Exception:", ""));
        }
        return null;
    }

    /**
     * Borrado Expando Value
     *
     * @param origen
     * @return
     */
    public String eliminarExpandoValue(String origen) {
        try {
            if (origen.equals("hobby")) {
                DelegatedTselExpandoEmpleadoDAO.eliminarExpandoValueEmpleado(getExpandoSeleccion().getTeeId());
                setHobby(DelegatedTselExpandoEmpleadoDAO.cargarEstrucutraExpandoEmpleado(getTdcTd(), getEplNd(), getTeiIdHobby()));
            } else if (origen.equals("deporte")) {
                DelegatedTselExpandoEmpleadoDAO.eliminarExpandoValueEmpleado(getExpandoSeleccion().getTeeId());
                setDeportes(DelegatedTselExpandoEmpleadoDAO.cargarEstrucutraExpandoEmpleado(getTdcTd(), getEplNd(), getTeiIdDeportes()));
            } else if (origen.equals("alergia")) {
                DelegatedTselExpandoEmpleadoDAO.eliminarExpandoValueEmpleado(getExpandoSeleccion().getTeeId());
                setAlergias(DelegatedTselExpandoEmpleadoDAO.cargarEstrucutraExpandoEmpleado(getTdcTd(), getEplNd(), getTeiIdAlergia()));
            } else if (origen.equals("antecedenteMedico")) {
                DelegatedTselExpandoEmpleadoDAO.eliminarExpandoValueEmpleado(getExpandoSeleccion().getTeeId());
                setAntecedentesMedicos(DelegatedTselExpandoEmpleadoDAO.cargarEstrucutraExpandoEmpleado(getTdcTd(), getEplNd(), getTeiIdAntecedenteMedico()));
            } else if (origen.equals("medicamento")) {
                DelegatedTselExpandoEmpleadoDAO.eliminarExpandoValueEmpleado(getExpandoSeleccion().getTeeId());
                setMedicamentos(DelegatedTselExpandoEmpleadoDAO.cargarEstrucutraExpandoEmpleado(getTdcTd(), getEplNd(), getTeiIdMedicamento()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            util.agregaMensaje("ERROR2", "Error Eliminando asociacion, por favor intenta nuevamente");
        }
        return null;
    }

    /**
     * Genera un List<TselEmpleadoTransporteEntity> para enviarla al metodo de
     * guardarEmpleadoTransporte
     *
     * @return Una lista de tipo TselEmpleadoTransporteEntity
     */
    private List<TselEmpleadoTransporteEntity> generarListaEmpleadosTransporte() {
        List<TselEmpleadoTransporteEntity> listTemp = new ArrayList<TselEmpleadoTransporteEntity>();
        for (Long idVeh : getListaEmpleadoTransporteLong()) {
            TselEmpleadoTransporteEntity obj = new TselEmpleadoTransporteEntity();
            obj.setEplNd(getEplNd());
            obj.setTdcTd(getTdcTd());
            obj.setTveIdTipoVehiculo(idVeh);
            listTemp.add(obj);
        }
        return listTemp;
    }

    /**
     * Se crea una lista de tipos de transporte que va a ser eliminada
     */
    private Object[] generarListaTransporteEliminar() {
        cargarListaEliminarTrans();
        HashMap<Long, Object> hashTemp = getListaEliminarTransporte();
        Object[] listaTemp;
        //HashMap<Long, Object> hashTemp=getListaEliminarTransporte();		
        for (int i = 0; i < getListaEmpleadoTransporteLong().size(); i++) {
            if (hashTemp.containsKey(getListaEmpleadoTransporteLong().get(i))) {
                hashTemp.remove(getListaEmpleadoTransporteLong().get(i));
            }
        }
        listaTemp = hashTemp.keySet().toArray();
        return listaTemp;
    }

    /**
     * Filtrado de todos los Hobbyes disponibles en el sistema.
     *
     * @param query
     * @return
     */
    public List<String> filtradoHobbys(String query) {
        List<String> results = DelegatedTselExpandoEmpleadoDAO.cargarFiltroExpandoValue(getTeiIdHobby(), query);
        return results;
    }

    /**
     * Filtrado autocompletado deportes.
     *
     * @param query
     * @return
     */
    public List<String> filtradoDeportes(String query) {
        List<String> results = DelegatedTselExpandoEmpleadoDAO.cargarFiltroExpandoValue(getTeiIdDeportes(), query);
        return results;
    }

    /**
     * Filtrado Antecedentes Medicos
     *
     * @param query
     * @return
     */
    public List<String> filtradoAntecedentesMedicos(String query) {
        List<String> results = DelegatedTselExpandoEmpleadoDAO.cargarFiltroExpandoValue(getTeiIdAntecedenteMedico(), query);
        return results;
    }

    /**
     * Filtrado de Medicamentos
     *
     * @param query
     * @return
     */
    public List<String> filtradoMedicamentos(String query) {
        List<String> results = DelegatedTselExpandoEmpleadoDAO.cargarFiltroExpandoValue(getTeiIdMedicamento(), query);
        return results;
    }

    /**
     * Filtrado de Alergias
     *
     * @param query
     * @return
     */
    public List<String> filtradoAlergias(String query) {
        List<String> results = DelegatedTselExpandoEmpleadoDAO.cargarFiltroExpandoValue(getTeiIdAlergia(), query);
        return results;
    }

    /**
     * Borrado seleccion empresa EPS y AFP
     */
    public void reseteaListaAfiliaciones() {
        setCodigoAFP("NA<>0");
        setCodigoEPS("NA<>0");
    }

    //---------------------------GETTERS AND SETTERS----------------------------
    /**
     * Metodo encargado de retornar el valord de listaTipoTransporte
     *
     * @return
     */
    public List<SelectItem> getListaTipoTransporte() {
        return listaTipoTransporte;
    }

    /**
     * Metodo encargado de modificar el valor de listaTipoTransporte
     *
     * @param listaTipoTransporte
     */
    public void setListaTipoTransporte(List<SelectItem> listaTipoTransporte) {
        this.listaTipoTransporte = listaTipoTransporte;
    }

    /**
     * Metodo encargado de retornar el valord de empleadoTransporte
     *
     * @return
     */
    public TselEmpleadoTransporteEntity getEmpleadoTransporte() {
        return empleadoTransporte;
    }

    /**
     * Metodo encargado de modificar el valor de empleadoTransporte
     *
     * @param empleadoTransporte
     */
    public void setEmpleadoTransporte(TselEmpleadoTransporteEntity empleadoTransporte) {
        this.empleadoTransporte = empleadoTransporte;
    }

    /**
     * Metodo encargado de retornar el valord de tdcTd
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
     * Metodo encargado de retornar el valord de eplNd
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
     * Metodo encargado de retornar el valord de teiIdHobby
     *
     * @return
     */
    public Long getTeiIdHobby() {
        return teiIdHobby;
    }

    /**
     * Metodo encargado de modificar el valor de teiIdHobby
     *
     * @param teiIdHobby
     */
    public void setTeiIdHobby(Long teiIdHobby) {
        this.teiIdHobby = teiIdHobby;
    }

    /**
     * Metodo encargado de retornar el valord de teiIdDeportes
     *
     * @return
     */
    public Long getTeiIdDeportes() {
        return teiIdDeportes;
    }

    /**
     * Metodo encargado de modificar el valor de teiIdDeportes
     *
     * @param teiIdDeportes
     */
    public void setTeiIdDeportes(Long teiIdDeportes) {
        this.teiIdDeportes = teiIdDeportes;
    }

    /**
     * Metodo encargado de retornar el valord de hobby
     *
     * @return
     */
    public List<TselExpandoEmpleadoEntity> getHobby() {
        return hobby;
    }

    /**
     * Metodo encargado de modificar el valor de hobby
     *
     * @param hobby
     */
    public void setHobby(List<TselExpandoEmpleadoEntity> hobby) {
        this.hobby = hobby;
    }

    /**
     * Metodo encargado de retornar el valord de deportes
     *
     * @return
     */
    public List<TselExpandoEmpleadoEntity> getDeportes() {
        return deportes;
    }

    /**
     * Metodo encargado de modificar el valor de deportes
     *
     * @param deportes
     */
    public void setDeportes(List<TselExpandoEmpleadoEntity> deportes) {
        this.deportes = deportes;
    }

    /**
     * Metodo encargado de retornar el valord de tevValorHobby
     *
     * @return
     */
    public String getTevValorHobby() {
        return tevValorHobby;
    }

    /**
     * Metodo encargado de modificar el valor de tevValorHobby
     *
     * @param tevValorHobby
     */
    public void setTevValorHobby(String tevValorHobby) {
        this.tevValorHobby = tevValorHobby;
    }

    /**
     * Metodo encargado de retornar el valord de tevValorDeporte
     *
     * @return
     */
    public String getTevValorDeporte() {
        return tevValorDeporte;
    }

    /**
     * Metodo encargado de modificar el valor de tevValorDeporte
     *
     * @param tevValorDeporte
     */
    public void setTevValorDeporte(String tevValorDeporte) {
        this.tevValorDeporte = tevValorDeporte;
    }

    /**
     * Metodo encargado de retornar el valord de expandoSeleccion
     *
     * @return
     */
    public TselExpandoEmpleadoEntity getExpandoSeleccion() {
        return expandoSeleccion;
    }

    /**
     * Metodo encargado de modificar el valor de expandoSeleccion
     *
     * @param expandoSeleccion
     */
    public void setExpandoSeleccion(TselExpandoEmpleadoEntity expandoSeleccion) {
        this.expandoSeleccion = expandoSeleccion;
    }

    /**
     * Metodo encargado de retornar el valord de empleadoSimpleInformation
     *
     * @return
     */
    public EmpleadoSimpleEntity getEmpleadoSimpleInformation() {
        return empleadoSimpleInformation;
    }

    /**
     * Metodo encargado de modificar el valor de empleadoSimpleInformation
     *
     * @param empleadoSimpleInformation
     */
    public void setEmpleadoSimpleInformation(EmpleadoSimpleEntity empleadoSimpleInformation) {
        this.empleadoSimpleInformation = empleadoSimpleInformation;
    }

    /**
     * Metodo encargado de retornar el valord de listaTallaZapatos
     *
     * @return
     */
    public List<SelectItem> getListaTallaZapatos() {
        return listaTallaZapatos;
    }

    /**
     * Metodo encargado de modificar el valor de listaTallaZapatos
     *
     * @param listaTallaZapatos
     */
    public void setListaTallaZapatos(List<SelectItem> listaTallaZapatos) {
        this.listaTallaZapatos = listaTallaZapatos;
    }

    /**
     * Metodo encargado de retornar el valord de listaTallaCamisa
     *
     * @return
     */
    public List<SelectItem> getListaTallaCamisa() {
        return listaTallaCamisa;
    }

    /**
     * Metodo encargado de modificar el valor de listaTallaCamisa
     *
     * @param listaTallaCamisa
     */
    public void setListaTallaCamisa(List<SelectItem> listaTallaCamisa) {
        this.listaTallaCamisa = listaTallaCamisa;
    }

    /**
     * Metodo encargado de retornar el valord de listaTallaPantalon
     *
     * @return
     */
    public List<SelectItem> getListaTallaPantalon() {
        return listaTallaPantalon;
    }

    /**
     * Metodo encargado de modificar el valor de listaTallaPantalon
     *
     * @param listaTallaPantalon
     */
    public void setListaTallaPantalon(List<SelectItem> listaTallaPantalon) {
        this.listaTallaPantalon = listaTallaPantalon;
    }

    /**
     * Metodo encargado de retornar el valord de medicamentos
     *
     * @return
     */
    public List<TselExpandoEmpleadoEntity> getMedicamentos() {
        return medicamentos;
    }

    /**
     * Metodo encargado de modificar el valor de medicamentos
     *
     * @param medicamentos
     */
    public void setMedicamentos(List<TselExpandoEmpleadoEntity> medicamentos) {
        this.medicamentos = medicamentos;
    }

    /**
     * Metodo encargado de retornar el valord de antecedentesMedicos
     *
     * @return
     */
    public List<TselExpandoEmpleadoEntity> getAntecedentesMedicos() {
        return antecedentesMedicos;
    }

    /**
     * Metodo encargado de modificar el valor de antecedentesMedicos
     *
     * @param antecedentesMedicos
     */
    public void setAntecedentesMedicos(
            List<TselExpandoEmpleadoEntity> antecedentesMedicos) {
        this.antecedentesMedicos = antecedentesMedicos;
    }

    /**
     * Metodo encargado de retornar el valord de alergias
     *
     * @return
     */
    public List<TselExpandoEmpleadoEntity> getAlergias() {
        return alergias;
    }

    /**
     * Metodo encargado de modificar el valor de alergias
     *
     * @param alergias
     */
    public void setAlergias(List<TselExpandoEmpleadoEntity> alergias) {
        this.alergias = alergias;
    }

    /**
     * Metodo encargado de retornar el valord de teiIdAntecedenteMedico
     *
     * @return
     */
    public Long getTeiIdAntecedenteMedico() {
        return teiIdAntecedenteMedico;
    }

    /**
     * Metodo encargado de modificar el valor de teiIdAntecedenteMedico
     *
     * @param teiIdAntecedenteMedico
     */
    public void setTeiIdAntecedenteMedico(Long teiIdAntecedenteMedico) {
        this.teiIdAntecedenteMedico = teiIdAntecedenteMedico;
    }

    /**
     * Metodo encargado de retornar el valord de tevValorAntecedenteMedico
     *
     * @return
     */
    public String getTevValorAntecedenteMedico() {
        return tevValorAntecedenteMedico;
    }

    /**
     * Metodo encargado de modificar el valor de tevValorAntecedenteMedico
     *
     * @param tevValorAntecedenteMedico
     */
    public void setTevValorAntecedenteMedico(String tevValorAntecedenteMedico) {
        this.tevValorAntecedenteMedico = tevValorAntecedenteMedico;
    }

    /**
     * Metodo encargado de retornar el valord de teiIdMedicamento
     *
     * @return
     */
    public Long getTeiIdMedicamento() {
        return teiIdMedicamento;
    }

    /**
     * Metodo encargado de modificar el valor de teiIdMedicamento
     *
     * @param teiIdMedicamento
     */
    public void setTeiIdMedicamento(Long teiIdMedicamento) {
        this.teiIdMedicamento = teiIdMedicamento;
    }

    /**
     * Metodo encargado de retornar el valord de tevValorMedico
     *
     * @return
     */
    public String getTevValorMedico() {
        return tevValorMedico;
    }

    /**
     * Metodo encargado de modificar el valor de tevValorMedico
     *
     * @param tevValorMedico
     */
    public void setTevValorMedico(String tevValorMedico) {
        this.tevValorMedico = tevValorMedico;
    }

    /**
     * Metodo encargado de retornar el valord de teiIdAlergia
     *
     * @return
     */
    public Long getTeiIdAlergia() {
        return teiIdAlergia;
    }

    /**
     * Metodo encargado de modificar el valor de teiIdAlergia
     *
     * @param teiIdAlergia
     */
    public void setTeiIdAlergia(Long teiIdAlergia) {
        this.teiIdAlergia = teiIdAlergia;
    }

    /**
     * Metodo encargado de retornar el valord de tevValorAlergia
     *
     * @return
     */
    public String getTevValorAlergia() {
        return tevValorAlergia;
    }

    /**
     * Metodo encargado de modificar el valor de tevValorAlergia
     *
     * @param tevValorAlergia
     */
    public void setTevValorAlergia(String tevValorAlergia) {
        this.tevValorAlergia = tevValorAlergia;
    }

    /**
     * Metodo encargado de retornar el valord de empleadoSGSS
     *
     * @return
     */
    public TselEmpleadoSGSSSimpleEntity getEmpleadoSGSS() {
        return empleadoSGSS;
    }

    /**
     * Metodo encargado de modificar el valor de empleadoSGSS
     *
     * @param empleadoSGSS
     */
    public void setEmpleadoSGSS(TselEmpleadoSGSSSimpleEntity empleadoSGSS) {
        this.empleadoSGSS = empleadoSGSS;
    }

    /**
     * Metodo encargado de retornar el valord de listaEmpresasAFP
     *
     * @return
     */
    public List<SelectItem> getListaEmpresasAFP() {
        return listaEmpresasAFP;
    }

    /**
     * Metodo encargado de modificar el valor de listaEmpresasAFP
     *
     * @param listaEmpresasAFP
     */
    public void setListaEmpresasAFP(List<SelectItem> listaEmpresasAFP) {
        this.listaEmpresasAFP = listaEmpresasAFP;
    }

    /**
     * Metodo encargado de retornar el valord de listaEmpresasEPS
     *
     * @return
     */
    public List<SelectItem> getListaEmpresasEPS() {
        return listaEmpresasEPS;
    }

    /**
     * Metodo encargado de modificar el valor de listaEmpresasEPS
     *
     * @param listaEmpresasEPS
     */
    public void setListaEmpresasEPS(List<SelectItem> listaEmpresasEPS) {
        this.listaEmpresasEPS = listaEmpresasEPS;
    }

    /**
     * Metodo encargado de retornar el valord de codigoAFP
     *
     * @return
     */
    public String getCodigoAFP() {
        return codigoAFP;
    }

    /**
     * Metodo encargado de modificar el valor de codigoAFP
     *
     * @param codigoAFP
     */
    public void setCodigoAFP(String codigoAFP) {
        this.codigoAFP = codigoAFP;
    }

    /**
     * Metodo encargado de retornar el valord de codigoEPS
     *
     * @return
     */
    public String getCodigoEPS() {
        return codigoEPS;
    }

    /**
     * Metodo encargado de modificar el valor de codigoEPS
     *
     * @param codigoEPS
     */
    public void setCodigoEPS(String codigoEPS) {
        this.codigoEPS = codigoEPS;
    }

    /**
     * Metodo encargado de retornar el valord de listaEmpleadoTransporte
     *
     * @return
     */
    public List<TselEmpleadoTransporteEntity> getListaEmpleadoTransporte() {
        return listaEmpleadoTransporte;
    }

    /**
     * Metodo encargado de modificar el valor de listaEmpleadoTransporte
     *
     * @param listaEmpleadoTransporte
     */
    public void setListaEmpleadoTransporte(List<TselEmpleadoTransporteEntity> listaEmpleadoTransporte) {
        this.listaEmpleadoTransporte = listaEmpleadoTransporte;
    }

    /**
     * Metodo encargado de retornar el valord de listaEmpleadoTransporteLong
     *
     * @return
     */
    public List<Long> getListaEmpleadoTransporteLong() {
        return listaEmpleadoTransporteLong;
    }

    /**
     * Metodo encargado de modificar el valor de listaEmpleadoTransporteLong
     *
     * @param listaEmpleadoTransporteLong
     */
    public void setListaEmpleadoTransporteLong(
            List<Long> listaEmpleadoTransporteLong) {
        this.listaEmpleadoTransporteLong = listaEmpleadoTransporteLong;
    }

    /**
     * Metodo encargado de retornar el valord de listaEliminarTransporte
     *
     * @return
     */
    public HashMap<Long, Object> getListaEliminarTransporte() {
        return listaEliminarTransporte;
    }

    /**
     * Metodo encargado de modificar el valor de listaEliminarTransporte
     *
     * @param listaEliminarTransporte
     */
    public void setListaEliminarTransporte(
            HashMap<Long, Object> listaEliminarTransporte) {
        this.listaEliminarTransporte = listaEliminarTransporte;
    }

    /**
     * Metodo encargado de retornar el valor de value
     * @return 
     */
    public String getValue() {
        return value;
    }

    /**
     * Metodo encargado de modificar el valor de value
     * @param value 
     */
    public void setValue(String value) {
        this.value = value;
    }

}
