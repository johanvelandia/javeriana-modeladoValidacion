package com.puj.modelado.validacion.calculadora.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 
 * @author jvelandia
 * @version 1.0
 */
public class ConverterParameter{

    /**
     * logger de la clase
     */
    private static Logger LOG=Logger.getLogger(ConverterParameter.class);

    /**
     * 
     * @param parametros
     * @param operacion
     * @return
     * @throws Exception
     */
    public static double operarParametros(String parametros,Operacion operacion) throws Exception{
        try{
            Double result=0.00d;
            Double result1=0.00d;
            List<Double> para=convertirParametros(parametros,operacion);
            Double a=0d;
            for(int i=0;i<para.size();i++){
                a=para.get(i);
                if(operacion.equals(Operacion.SUMA)){
                    result=((a)+(result));
                }
                else if(operacion.equals(Operacion.RESTA)){
                    if(i==0){
                        result1=para.get(i+1);
                        System.out.println("Operacion: "+a+"-"+result1);
                        result=((a)-(result1));
                        System.out.println("resul: "+result);
                    }
                    else{
                        if(i<para.size()-1){
                            a=para.get(i+1);
                            System.out.println("Operacion:"+i+" "+result+"-"+a);
                            result=((result)-(a));
                            System.out.println(result);
                        }
                    }
                }
                else if(operacion.equals(Operacion.MULTIPICACION)){
                    if(i==0){
                        result1=para.get(i+1);
                        System.out.println("Operacion: "+a+"*"+result1);
                        result=((a)*(result1));
                        System.out.println("resul: "+result);
                    }
                    else{
                        if(i<para.size()-1){
                            a=para.get(i+1);
                            System.out.println("Operacion:"+i+" "+result+"*"+a);
                            result=((result)*(a));
                            System.out.println(result);
                        }
                    }                }
                else if(operacion.equals(Operacion.DIVISON)){
                    if(i==0){
                        result1=para.get(i+1);
                        System.out.println("Operacion: "+a+"/"+result1);
                        result=((a)/(result1));
                        System.out.println("resul: "+result);
                    }
                    else{
                        if(i<para.size()-1){
                            a=para.get(i+1);
                            System.out.println("Operacion:"+i+" "+result+"/"+a);

                            result=((result)/(a));
                            System.out.println(result);
                        }
                    }
                }
            }
            return result;
        }
        catch(Exception e){
            LOG.error("Error al operarParametros",e);
            throw e;
        }
    }
    /**
     * conviete los parametros
     * @param parametros
     * @param operacion
     * @return
     * @throws Exception
     */
    public static List<Double> convertirParametros(String parametros,Operacion operacion) throws Exception{
        try{
            final ArrayList<Double> lista=new ArrayList<Double>();
            final String[] valores=parametros.split("/");
            String valor="";
            for(int i=0;i<valores.length;i++){
                valor=valores[i].trim();
                if(operacion.equals(Operacion.DIVISON)&&valor.equals("0")){
                    throw new Exception("El parametro en la posicion: "+i+" es cero por lo tanto la division es invalida");
                }
                if(!valor.equals("")){
                    try{
                        lista.add(Double.valueOf(valor));
                    }
                    catch(Exception e){
                        LOG.error("Error al convertirParametro: "+valor+" no es numerico",e);
                        throw new Exception("El parametro en la posicion: "+i+" con valor: "+valor+" no es numerico");
                    }
                }
            }
            return lista;
        }
        catch(Exception e){
            LOG.error("Error al convertirParametros",e);
            throw e;
        }
    }

}
