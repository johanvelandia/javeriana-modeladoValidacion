package com.puj.modelado.validacion.calculadora.utils;

public class Test{

    /**
     * @param args
     */
    public static void main(String[] args){
        String para="30/43/3/87/5";
        para="23/323/3/-34";
        try{
            System.out.println(ConverterParameter.operarParametros(para,Operacion.RESTA));
        }
        catch(Exception e){
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
    }

}
