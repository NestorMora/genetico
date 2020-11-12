/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetico2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author nesto
 */
public class Genetico2 {
    static ArrayList<Individuo2> poblacion_inicial = new ArrayList();
    static int padre,madre, contador=0;
    public static void main(String[] args) {
        contador=0;
        System.out.println( funcionCostoPromedio(707));
        generar_poblacion();
        
    }
    
    
    ///////////////////////METODOS COMUNES/////////////////////////////////////
    static void generar_poblacion(){
        for (int i = 0; i < 10; i++) {
        int cont=0;
        String gen="";
        Individuo2 ind=new Individuo2();
            while (cont<6) {        
                int a=(int)Math.floor(Math.random()*(1-0+1)+0);
                gen +=""+a;
                cont++;
            }
            int c=(int)Math.floor(Math.random()*(1-0+1)+0);
            if (c==0) {
                ind.genomaBinario=gen;
                int aux=Integer.parseInt(gen,2);
                ind.genomaInt=aux;
                poblacion_inicial.add(ind);
            }else{
                ind.genomaBinario=gen;
                int aux=(Integer.parseInt(gen,2))*(-1);
                //int aux=(Integer.parseInt(gen,2));
                ind.genomaInt=aux;
                poblacion_inicial.add(ind);
            }
        }
        ciclo();
        
    }
    static void mostrar_poblacion(){
        System.out.println("\n\n poblacion");
        for(int i = 0; i< poblacion_inicial.size(); i++){
            System.out.print(poblacion_inicial.get(i));
        }
    }
    
    static void mostrar_fitnes(){
        System.out.println("\n\n fitness");
        System.out.print(poblacion_inicial.get(0));
    }
    static void ordenar(){
       Collections.sort(poblacion_inicial);
    }
    
    static void ciclo(){
        fitnesFuerzaVentas();
        ordenar();
        //mostrar_poblacion();
        mostrar_fitnes();
        mezcla();
    }
    static void mezcla(){
        if(contador==100){
            System.exit(0);
        }else{
            padre=(int) Math.floor(Math.random()*(9-0+1)+0);
            madre=(int) Math.floor(Math.random()*(9-0+1)+0);

            Individuo2 ind =poblacion_inicial.get(padre);
            String m1= ind.genomaBinario;

            Individuo2 ind2 =poblacion_inicial.get(madre);
            String m2= ind2.genomaBinario;
            
            String hijoBinario=m1.substring(0, 3)+""+m2.substring(0, 3);
            int mutacion=(int)Math.floor(Math.random()*(1-0+1)+0);
            if (mutacion==1) {
                if(hijoBinario.charAt(3)=='1'){
                    hijoBinario=hijoBinario.substring(0,3)+"0";
                }else{
                    hijoBinario=hijoBinario.substring(0,3)+"1";
                }
            }
            int hijoInt=Integer.parseInt(hijoBinario,2);
            int x=9;
            Individuo2 ind3 = poblacion_inicial.get(9);
            ind3.genomaBinario=hijoBinario; 
            int c=(int)Math.floor(Math.random()*(1-0+1)+0);
            if (c==0) {
            ind3.genomaInt=hijoInt;
            }else{
                ind3.genomaInt=(hijoInt)*(-1);
            }
            
            contador++;
            ciclo();
        }
    }
    
    ///////////////////////////METODOS PARA ENCONTRAR EL FITNES////////////////////////////////////////////
    static void fitnes(){
        for (int i = 0; i < 10; i++)
        {
            Individuo2 ind = poblacion_inicial.get(i);
            ind.fitnes=funcion(ind.genomaInt);
        }
        
    }
    static void fitnesProducto(){
        for (int i = 0; i < 10; i++)
        {
            Individuo2 ind = poblacion_inicial.get(i);
            ind.fitnes=funcionProducto(ind.genomaInt); 
        }
        
    }
    static void fitnesTransporte(){
        for (int i = 0; i < 10; i++)
        {
            Individuo2 ind = poblacion_inicial.get(i);
            ind.fitnes=funcionTransporte(ind.genomaInt); 
        }
    }
    static void fitnesInventario(){
        for (int i = 0; i < 10; i++)
        {
            Individuo2 ind = poblacion_inicial.get(i);
            ind.fitnes=funcionInventario(ind.genomaInt); 
        }
    }
    static void fitnesCostoPromedio(){
        for (int i = 0; i < 10; i++)
        {
            Individuo2 ind = poblacion_inicial.get(i);
            ind.fitnes=funcionCostoPromedio(ind.genomaInt); 
        }
    }
     static void fitnesFuerzaVentas(){
        for (int i = 0; i < 10; i++)
        {
            Individuo2 ind = poblacion_inicial.get(i);
            ind.fitnes=funcionFuerzaVentas(ind.genomaInt); 
        }
    }
    
    //////////////////////////////METODOS DE LAS FUNCIONES////////////////////////////////
    static double funcion(double x){
        return (5*x*x)-(20*x)+ 3;
    }  
    static double funcionProducto(double x){
        return (-50*x*x)+(500*x);
    }
    static double funcionTransporte(double x){
        return (10000*x)-(125*x*x);
    }
    static double funcionInventario(double x){
        return (4860/x)+(15*x)+750000;
    }
    static double funcionCostoPromedio(double x){
        return (100000/x)+(1500)+(0.2*x);
    }
    static double funcionFuerzaVentas(double x){
        return (-12.5*x*x)+(1375*x)-(1500);
    }
}
