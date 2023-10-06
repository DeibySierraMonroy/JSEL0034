package co.com.activos.JSEL0034.Controller;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import oracle.jdbc.OracleTypes;
import co.com.activos.Utilidad.OracleFactory;
import co.com.activos.Utilidad.UtilidadesFACES;
import co.com.activos.JSEL0034.ClassAbstract.TSelNucleoFamiliarDAOInterface;
import co.com.activos.JSEL0034.Entidad.RespuestaWs;
import co.com.activos.JSEL0034.Entidad.TSelNucleoFamiliar;
import co.com.activos.JSEL0034.Entidad.TipoDocumento;
import co.com.activos.JSEL0034.util.GestionRetornoObjeto;
import co.com.activos.JSEL0034.util.GestorDocumentalBhv;
import java.sql.Types;

/**
 * Controlador de acceso a datos modelo Nucleo Familiar.
 *
 * @author Jairo Andres Rivera Rodriguez
 * @version 1.0
 * @since JDK1.6
 */
public class TSelNucleoFamiliarDAO implements Serializable, TSelNucleoFamiliarDAOInterface {

    private static final long serialVersionUID = 1L;
    UtilidadesFACES util = new UtilidadesFACES();

    /**
     * Retorna el nucleo familiar el empleado
     *
     * @param tdcTd
     * @param eplNd
     * @return
     */
    public List<TSelNucleoFamiliar> cargarNucleoFamiliarEmpleado(String tdcTd, Long eplNd) {
        List<TSelNucleoFamiliar> nucleoFamiliar = new ArrayList<TSelNucleoFamiliar>();
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ CALL SEL.QB_APLICATION_JSEL0034.PL_CARGAR_NUCLEO_FAMILIAR(?,?,?,?)}");
            cs.setString(1, tdcTd);
            cs.setLong(2, eplNd);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.CURSOR);
            cs.execute();

            if (cs.getString(3) == null) {
                ResultSet rs = (ResultSet) cs.getObject(4);
                TSelNucleoFamiliar tnfp;
                while (rs.next()) {
                    tnfp = new TSelNucleoFamiliar();
                    tnfp.setApellidos(rs.getString("APELLIDOS"));
                    tnfp.setCelular(rs.getLong("CELULAR"));
                    tnfp.setDcmRadicacion(rs.getLong("DCM_RADICACION"));
                    tnfp.setEdad(rs.getLong("EDAD"));
                    tnfp.setEplNd(rs.getLong("EPL_ND"));
                    tnfp.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
                    tnfp.setItem(rs.getLong("ITEM"));
                    tnfp.setNombres(rs.getString("NOMBRES"));
                    tnfp.setObservaciones(rs.getString("OBSERVACIONES"));
                    tnfp.setTdcTdEpl(rs.getString("TDC_TD_EPL"));
                    tnfp.setTocuId(rs.getLong("TOCU_ID"));
                    tnfp.setParSigla(rs.getString("PAR_SIGLA"));;
                    tnfp.setTteCodigo(rs.getLong("TTE_CODIGO"));
                    tnfp.setViveConCandidato(rs.getString("VIVE_CON_CANDIDATO").equals("S"));
                    tnfp.setParDescripcion(rs.getString("PAR_DESCRIPCION"));
                    tnfp.setTocuDescripcion(rs.getString("TOCU_OCUPACION"));
                    tnfp.setTteDescripcion(rs.getString("TTE_DESCRIPCION"));
                    nucleoFamiliar.add(tnfp);
                }
            } else {
                System.out.println("TSelNucleoFamiliarDAO->cargarNucleoFamiliarEmpleado:" + cs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("TSelNucleoFamiliarDAO->cargarNucleoFamiliarEmpleado: Error cargando nucleo familiar, causado por " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nucleoFamiliar;
    }

    /**
     * Persistencia registro nuclero familiar
     *
     * @param nucleoFamiliar
     * @throws Exception
     */
    public void guardarRegistroNucleoFamiliar(TSelNucleoFamiliar nucleoFamiliar) throws Exception {
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ CALL SEL.QB_APLICATION_JSEL0034.PL_GUARDAR_NUCLEO_FAMILIAR(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
            cs.setString(1, nucleoFamiliar.getTdcTdEpl());
            cs.setLong(2, nucleoFamiliar.getEplNd());
            cs.setLong(3, nucleoFamiliar.getItem());

            try {
                cs.setLong(4, nucleoFamiliar.getEdad());
            } catch (Exception e) {
                cs.setObject(4, null);
            }

            cs.setString(5, nucleoFamiliar.getParSigla());
            cs.setLong(6, nucleoFamiliar.getTocuId());
            cs.setString(7, nucleoFamiliar.getNombres());
            cs.setString(8, nucleoFamiliar.getApellidos());

            try {
                cs.setDate(9, new java.sql.Date(nucleoFamiliar.getFechaNacimiento().getTime()));
            } catch (Exception e) {
                cs.setObject(9, null);
            }

            try {
                cs.setLong(10, nucleoFamiliar.getCelular());
            } catch (Exception e) {
                cs.setObject(10, null);
            }

            cs.setString(11, nucleoFamiliar.getViveConCandidato() ? "S" : "N");
            cs.setLong(12, nucleoFamiliar.getTteCodigo());
            cs.setString(13, nucleoFamiliar.getTnfGenero());
            cs.registerOutParameter(14, OracleTypes.VARCHAR);
            cs.execute();
            if (!(cs.getString(14) == null)) {
                throw new Exception(cs.getString(14));
            }
        } catch (Exception e) {
        } finally {
            conexion.close();
        }
    }

    /**
     * Borrado registro Nucleo Familiar.
     *
     * @param nucleoFamiliar
     * @throws Exception
     */
    public void eliminarRegistroNucleoFamiliar(TSelNucleoFamiliar nucleoFamiliar) throws Exception {
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ CALL SEL.QB_APLICATION_JSEL0034.PL_ELIMINAR_NUCLEO_FAMILIAR(?,?,?,?)}");
            cs.setString(1, nucleoFamiliar.getTdcTdEpl());
            cs.setLong(2, nucleoFamiliar.getEplNd());
            cs.setLong(3, nucleoFamiliar.getItem());
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.execute();
            if (!(cs.getString(4) == null)) {
                util.agregaMensaje("INFO2", cs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("TSelNucleoFamiliarDAO->eliminarRegistroNucleoFamiliar: Error eliminando registro nucleo familiar, causado por " + e);
        } finally {
            conexion.close();
        }
    }

    /**
     * *
     * Retorna la lista dependiendo del tipo invocado.
     *
     * @param tipo
     * @return
     */
    public List<SelectItem> cargarListaDependenciasNucleoFamiliar(String tipo) {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{ CALL SEL.QB_APLICATION_JSEL0034.PL_CARGAR_LISTAS_NUCLEO_FAM(?,?,?)}");
            cs.setString(1, tipo);
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.execute();

            if (cs.getString(2) == null) {
                ResultSet rs = (ResultSet) cs.getObject(3);

                while (rs.next()) {
                    if (tipo.equals("PARENTESCO")) {
                        lista.add(new SelectItem(rs.getString("VALUE"), rs.getString("LABEL")));
                    } else {
                        lista.add(new SelectItem(rs.getLong("VALUE"), rs.getString("LABEL")));
                    }
                }
            } else {
                System.out.println("TSelNucleoFamiliarDAO->cargarListaOcupaciones :" + cs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("TSelNucleoFamiliarDAO->cargarListaOcupaciones : error cargando lista ocupacioens causado por: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    @Override
    public String desEncriptarParametrosServlet(String desEncriptar) {
        String desEncripatado = "";
        Connection conexion = OracleFactory.getConexion();
        try {
            CallableStatement cs = conexion.prepareCall("{?= call ADM.QB_SINMA_CORE_UTIL.FB_DESCENCRIPTAR(?)}");
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.setString(2, desEncriptar);
            cs.executeQuery();
            desEncripatado = cs.getString(1);
            cs.close();
        } catch (Exception sQLException) {
            System.out.println("Error devolviendo el asunto:" + sQLException.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (Exception ee) {
                System.out.println("Error cerrando conexion causado por " + ee);
            }
        }
        return desEncripatado;
    }

    @Override
    public GestionRetornoObjeto wsCargarArchivo(Long idDirectorio, String nombreArchivo) {
        GestionRetornoObjeto gestionRetornoObjeto;
        Connection conexion = OracleFactory.getConexion();
        String endPoint;
        String tramaXml;

        try {
            CallableStatement cs = conexion.prepareCall("{ call ADM.QB_APP_GESTORDOC.PL_WSDL_CARGARARCHIVO(?,?,?,?) }");

            //Parametros de entrada
            if (idDirectorio != null) {
                cs.setLong("NMIDDIRECTORIO", idDirectorio);
            } else {
                cs.setString("NMIDDIRECTORIO", null);
            }
            cs.setString("VCNOMBRE", nombreArchivo);

            //Parametros de salida
            cs.registerOutParameter("VCEND_POINT", OracleTypes.VARCHAR);
            cs.registerOutParameter("VCTRAMAXML", OracleTypes.VARCHAR);

            cs.execute();

            endPoint = (String) cs.getString("VCEND_POINT");
            tramaXml = (String) cs.getString("VCTRAMAXML");

            cs.close();

            return gestionRetornoObjeto = new GestionRetornoObjeto(endPoint, "S", tramaXml);

        } catch (Exception e) {
            return gestionRetornoObjeto = new GestionRetornoObjeto(null, "N", e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (Exception ee) {
                gestionRetornoObjeto = new GestionRetornoObjeto(null, "N", ee.getMessage());
            }
        }
    }

    @Override
    public GestorDocumentalBhv crearDeaCodigo(String deaCodigo, Long tipoDoc, String usuario, String nombreArchivo) {
        GestorDocumentalBhv gestorDocumentalBhv;
        Connection conexion = OracleFactory.getConexion();
        String deaCodigoRetorno;
        String estadoProceso;
        String mensajeProceso;
        String versionArchivo;

        try {
            CallableStatement cs = conexion.prepareCall("{ call ADM.QB_LGC_GESTOR_DOCUMENTAL.pl_ins_gestor(?,?,?,?,?,?,?,?,?,?) }");

            //Parametros de entrada
            cs.setString("nmTIP_FLUJO", null);
            cs.setString("vcNOMTABLA", null);
            cs.setString("vcTXP_DESCRIPCION", null);
            if (deaCodigo != null) {
                cs.setLong("nmdea_codigoPAdre", Long.valueOf(deaCodigo));
            } else {
                cs.setString("nmdea_codigoPAdre", null);
            }
            if (tipoDoc != null) {
                cs.setLong("nmPRD_CODIGO", tipoDoc);
            } else {
                cs.setString("nmPRD_CODIGO", null);
            }
            cs.setString("VCAUD_USUARIO", usuario);
            cs.setString("VCNOM_ARCHIVO", nombreArchivo);

            //Parametros de salida
            cs.registerOutParameter("nmDEA_CODIGO", OracleTypes.VARCHAR);
            cs.registerOutParameter("VCNOM_ARCHIVO", OracleTypes.VARCHAR);
            cs.registerOutParameter("vcmensajeproceso", OracleTypes.VARCHAR);
            cs.registerOutParameter("vcestadoproceso", OracleTypes.VARCHAR);

            cs.execute();

            deaCodigoRetorno = (String) cs.getString("nmDEA_CODIGO");
            versionArchivo = (String) cs.getString("VCNOM_ARCHIVO");
            estadoProceso = (String) cs.getString("vcestadoproceso");
            mensajeProceso = (String) cs.getString("vcmensajeproceso");

            cs.close();
            
            if(estadoProceso != null && estadoProceso.equals("S")){
                mensajeProceso = versionArchivo;
            }
            
            return gestorDocumentalBhv = new GestorDocumentalBhv(deaCodigoRetorno, null, estadoProceso, mensajeProceso);

        } catch (Exception e) {
            return gestorDocumentalBhv = new GestorDocumentalBhv(null, null, "N", e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (Exception ee) {
                gestorDocumentalBhv = new GestorDocumentalBhv(null, null, "N", ee.getMessage());
            }
        }
    }

    @Override
    public GestionRetornoObjeto procesarRespuestaWs(String xmlInput, String respuesta) {
        GestionRetornoObjeto gestionRetornoObjeto;
        Connection conexion = OracleFactory.getConexion();
        String estadoProceso;
        String mensajeProceso;
        RespuestaWs respuestaWs = null;

        try {
            CallableStatement cs = conexion.prepareCall("{ call ADM.QB_LGC_GESTOR_DOCUMENTAL.pl_ins_respuesta_ws(?,?,?,?,?) }");

            //Parametros de entrada
            cs.setString("cltramaEnviaXML", xmlInput);
            cs.setString("cltramaRespuestaXML", respuesta);

            //Parametros de salida
            cs.registerOutParameter("CSCONSULTA", OracleTypes.CURSOR);
            cs.registerOutParameter("vcmensajeproceso", OracleTypes.VARCHAR);
            cs.registerOutParameter("vcestadoproceso", OracleTypes.VARCHAR);

            cs.execute();

            mensajeProceso = (String) cs.getString("vcmensajeproceso");
            estadoProceso = (String) cs.getString("vcestadoproceso");

            ResultSet rs = (ResultSet) cs.getObject("CSCONSULTA");

            if (rs == null) {
                return gestionRetornoObjeto = new GestionRetornoObjeto(null, mensajeProceso, estadoProceso);
            }

            while (rs.next()) {
                respuestaWs = new RespuestaWs(rs.getString("ESTADO"),
                        rs.getString("IDCARPETANUEVA"),
                        rs.getString("IDARCHIVONUEVO"));
            }

            cs.close();

            return gestionRetornoObjeto = new GestionRetornoObjeto(respuestaWs, estadoProceso, mensajeProceso);

        } catch (Exception e) {
            return gestionRetornoObjeto = new GestionRetornoObjeto(null, "N", e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (Exception ee) {
                gestionRetornoObjeto = new GestionRetornoObjeto(null, "N", ee.getMessage());
            }
        }
    }

    @Override
    public GestionRetornoObjeto actualizaAzCodigoCli(Long deaCodigo, String idArchivo, String fileName) {
        GestionRetornoObjeto gestionRetornoObjeto;
        Connection conexion = OracleFactory.getConexion();
        String estadoProceso;
        String mensajeProceso;

        try {
            CallableStatement cs = conexion.prepareCall("{ call ADM.QB_LGC_GESTOR_DOCUMENTAL.PL_UPD_CODIGO_CLI(?,?,?,?,?) }");

            //Parametros de entrada
            if (deaCodigo != null) {
                cs.setLong("nmDEA_CODIGO", deaCodigo);
            } else {
                cs.setString("nmDEA_CODIGO", null);
            }
            if (idArchivo != null) {
                cs.setLong("NMAZ_CODIGO_CLI", Long.valueOf(idArchivo));
            } else {
                cs.setString("NMAZ_CODIGO_CLI", null);
            }
            cs.setString("vcnombreArchivo", fileName);

            //Parametros de salida
            cs.registerOutParameter("vcmensajeproceso", OracleTypes.VARCHAR);
            cs.registerOutParameter("vcestadoproceso", OracleTypes.VARCHAR);

            cs.execute();

            estadoProceso = (String) cs.getString("vcestadoproceso");
            mensajeProceso = (String) cs.getString("vcmensajeproceso");

            cs.close();

            return gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);

        } catch (Exception e) {
            return gestionRetornoObjeto = new GestionRetornoObjeto(null, "N", e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (Exception ee) {
                gestionRetornoObjeto = new GestionRetornoObjeto(null, "N", ee.getMessage());
            }
        }
    }

    @Override
    public TipoDocumento obtenerTipoDocumento(String documento) {
        Connection conexion = OracleFactory.getConexion();
        String estadoProceso;
        String mensajeProceso;
        TipoDocumento tipoDocumentoRetorna = null;

        try {
            CallableStatement cs = conexion.prepareCall("{ call ADM.QB_LGC_GESTOR_DOCUMENTAL.PL_OBTENER_TIPODOC(?,?,?,?) }");

            //Parametros de entrada
            cs.setString("VCDOCUMENTO", documento);

            //Parametros de salida
            cs.registerOutParameter("RCTIPO_DOC", OracleTypes.CURSOR);
            cs.registerOutParameter("vcestadoproceso", OracleTypes.VARCHAR);
            cs.registerOutParameter("vcmensajeproceso", OracleTypes.VARCHAR);

            cs.execute();

            estadoProceso = (String) cs.getString("vcestadoproceso");
            mensajeProceso = (String) cs.getString("vcmensajeproceso");
            ResultSet rs = (ResultSet) cs.getObject("RCTIPO_DOC");

            if (rs == null) {
                return null;
            }

            while (rs.next()) {
                tipoDocumentoRetorna = new TipoDocumento(rs.getString("TPD_CODIGO"),
                        rs.getString("TPD_DESCRIPCION"),
                        rs.getString("DTD_CODIGO"),
                        rs.getDate("AUD_FECHA"),
                        rs.getString("AUD_USUARIO"));
            }

            rs.close();
            cs.close();

            return tipoDocumentoRetorna;

        } catch (Exception e) {
            return null;
        } finally {
            try {
                conexion.close();
            } catch (Exception ee) {
                return null;
            }
        }
    }

    @Override
    public GestionRetornoObjeto generarPdf(String tdcTd, Long eplNd) {
        GestionRetornoObjeto gestionRetornoObjeto;
        Connection conexion = OracleFactory.getConexion();
        String url;
        String error;

        try {
            CallableStatement cs = conexion.prepareCall("{ call ADM.QB_LGC_GESTOR_DOCUMENTAL.pb_generar_HV_PDF(?,?,?,?,?) }");

            //Parametros de entrada
            cs.setString("vctdc_td", tdcTd);
            if (eplNd != null) {
                cs.setLong("nmepl_nd", eplNd);
            } else {
                cs.setString("nmepl_nd", null);
            }
            cs.setString("nmrequisicion", null);

            //Parametros de salida
            cs.registerOutParameter("VCurl", OracleTypes.VARCHAR);
            cs.registerOutParameter("VCERROR", OracleTypes.VARCHAR);

            cs.execute();

            url = (String) cs.getString("VCurl");
            error = (String) cs.getString("VCERROR");

            cs.close();

            return gestionRetornoObjeto = new GestionRetornoObjeto(url, "S", error);

        } catch (Exception e) {
            return gestionRetornoObjeto = new GestionRetornoObjeto(null, "N", e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (Exception ee) {
                gestionRetornoObjeto = new GestionRetornoObjeto(null, "N", ee.getMessage());
            }
        }
    }

    @Override
    public GestionRetornoObjeto eliminarDataErp(Long deaCodigo) {
        GestionRetornoObjeto gestionRetornoObjeto;
        Connection conexion = OracleFactory.getConexion();
        String estadoProceso;
        String mensajeProceso;

        try {
            CallableStatement cs = conexion.prepareCall("{ call ADM.QB_LGC_GESTOR_DOCUMENTAL.PL_DELETE_DATA_ERP(?,?,?) }");

            //Parametros de entrada
            if (deaCodigo != null) {
                cs.setLong("NMDEA_CODIGO", deaCodigo);
            } else {
                cs.setString("NMDEA_CODIGO", null);
            }

            //Parametros de salida
            cs.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            cs.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            cs.execute();

            estadoProceso = (String) cs.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) cs.getString("VCMENSAJE_PROCESO");

            cs.close();

            return gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);

        } catch (Exception e) {
            return gestionRetornoObjeto = new GestionRetornoObjeto(null, "N", e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (Exception ee) {
                gestionRetornoObjeto = new GestionRetornoObjeto(null, "N", ee.getMessage());
            }
        }
    }

}
