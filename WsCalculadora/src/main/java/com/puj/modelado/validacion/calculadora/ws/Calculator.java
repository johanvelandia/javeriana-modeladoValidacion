package com.puj.modelado.validacion.calculadora.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.puj.modelado.validacion.calculadora.utils.ConverterParameter;
import com.puj.modelado.validacion.calculadora.utils.Operacion;

/**
 * Servicio de calculadora
 * @author jvelandia
 * @version 1.0
 */
@Path("/calculator")
public class Calculator{

    /**
     * logger de la clase
     */
    private static final Logger LOG=Logger.getLogger(Calculator.class);

    private static final String PATH_MULTIPARAMETRO="{parametros:(/?(-?[0-9]+))*}";

    private static final String PATH_MULTIPARAMETRO_DIV="{parametros:(/?(-?[0-9]+))*}";

    private static final String PATH_PARAM_MULTIPARAMETRO="parametros";

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/add"+PATH_MULTIPARAMETRO)
    public String add(@PathParam(PATH_PARAM_MULTIPARAMETRO) String parametros){
        String html="";
        String respuesta="";
        try{
            double suma=ConverterParameter.operarParametros(parametros,Operacion.SUMA);
            respuesta=String.valueOf(suma);
            html=conformarHtml(respuesta);
        }
        catch(Exception e){
            LOG.error("Error al ejecutar carga de doc  LLAMADO GET: "+e.getMessage(),e);
            System.out.println("RESPUESTA EXCEPTION  LLAMADO GET: "+e.getCause()+" ---- "+e.getLocalizedMessage());
            respuesta=e.getMessage();
            html=conformarHtml(respuesta);
        }
        return html;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/subs"+PATH_MULTIPARAMETRO)
    public String subs(@PathParam(PATH_PARAM_MULTIPARAMETRO) String parametros){
        String html="";
        String respuesta="";
        try{
            double suma=ConverterParameter.operarParametros(parametros,Operacion.RESTA);
            respuesta=String.valueOf(suma);
            html=conformarHtml(respuesta);
        }
        catch(Exception e){
            LOG.error("Error al ejecutar carga de doc  LLAMADO GET: "+e.getMessage(),e);
            System.out.println("RESPUESTA EXCEPTION  LLAMADO GET: "+e.getCause()+" ---- "+e.getLocalizedMessage());
            respuesta=e.getMessage();
            html=conformarHtml(respuesta);
        }
        return html;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/mult"+PATH_MULTIPARAMETRO)
    public String mult(@PathParam(PATH_PARAM_MULTIPARAMETRO) String parametros){
        String html="";
        String respuesta="";
        try{
            double suma=ConverterParameter.operarParametros(parametros,Operacion.MULTIPICACION);
            respuesta=String.valueOf(suma);
            html=conformarHtml(respuesta);
        }
        catch(Exception e){
            LOG.error("Error al ejecutar carga de doc  LLAMADO GET: "+e.getMessage(),e);
            System.out.println("RESPUESTA EXCEPTION  LLAMADO GET: "+e.getCause()+" ---- "+e.getLocalizedMessage());
            respuesta=e.getMessage();
            html=conformarHtml(respuesta);
        }
        return html;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/div"+PATH_MULTIPARAMETRO_DIV)
    public String div(@PathParam(PATH_PARAM_MULTIPARAMETRO) String parametros){
        String html="";
        String respuesta="";
        try{
            double suma=ConverterParameter.operarParametros(parametros,Operacion.DIVISON);
            respuesta=String.valueOf(suma);
            html=conformarHtml(respuesta);
        }
        catch(Exception e){
            LOG.error("Error al ejecutar carga de doc  LLAMADO GET: "+e.getMessage(),e);
            System.out.println("RESPUESTA EXCEPTION  LLAMADO GET: "+e.getCause()+" ---- "+e.getLocalizedMessage());
            respuesta=e.getMessage();
            html=conformarHtml(respuesta);
        }
        return html;
    }

    /**
     * 
     * @param respuesta
     * @return
     * @throws Exception
     */
    private String conformarHtml(String respuesta){
        if(respuesta==null){
            respuesta="null";
        }
        String html="<html> "+"<title>"+"Calculator suma resultado"+"</title>"+"<body><h1>"+"Resultado: "+respuesta+"</body></h1>"+"</html>";
        return html;
    }

}
