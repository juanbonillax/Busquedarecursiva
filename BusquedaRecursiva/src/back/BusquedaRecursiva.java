/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author IngSis
 */
public class BusquedaRecursiva {
    private int[] vector;
    private int longitud;
    
    
    public int[] retornarVector(){
        Random rd = new Random();
        for(int i = 0; i < vector.length; i++){
            vector[i] = rd.nextInt(20);
        }
        return vector;
    }
    
    public BusquedaRecursiva(int logitud){
        this.vector = new int[logitud];
    }
    
    public void imprimirVector(int[] vector){
        for(int i = 0; i < vector.length; i++){
            System.out.println("[" + i + "]" + vector[i]);
        }
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////// 1. BUSQUEDA SECUENCIAL RECURSIVA /////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    
    public static boolean secuencial(int[] vector, int indice, int valor){
        
        if(indice == vector.length){
            return false;
        }
        
        if(vector[indice] == valor){
            return true;
        }
        
        return secuencial(vector, indice + 1, valor);
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////
    ////////////////// 2. BUSQUEDA SECUENCIAL RECURSIVA POR INDICE //////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    
    public int buscarIndice(int[] vector, int indice, int valor){
        
        if(indice >= vector.length){
            return -1;
        }
        
        if(vector[indice] == valor){
            return indice;
        }
        
        return buscarIndice(vector, indice + 1, valor);
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////// 3. BUSQUEDA BINARIA RECURSIVA ////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    
    public int buscarBinaria(int[] vector, int inicio, int fin, int valor){
        
        if(inicio > fin){
            return -1;
        }
        
        int medio = (inicio + fin) / 2;
        
        if(vector[medio] == valor){
            return medio;
        }
        
        if(valor < vector[medio]){
            return buscarBinaria(vector, inicio, medio - 1, valor);
        }
        
        return buscarBinaria(vector, medio + 1, fin, valor);
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////
    ///////////////// 4. BUSQUEDA BINARIA RECURSIVA CON LIMITES /////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    
    public int buscarBinariaConLimites(int[] vector, int inicio, int fin, int valor){
        
        if(inicio > fin){
            return -1;
        }
        
        int medio = (inicio + fin) / 2;
        
        if(vector[medio] == valor){
            return medio;
        }
        
        if(valor < vector[medio]){
            return buscarBinariaConLimites(vector, inicio, medio - 1, valor);
        }
        
        return buscarBinariaConLimites(vector, medio + 1, fin, valor);
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////// 5. BUSQUEDA DE TODAS LAS OCURRENCIAS /////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    
    public void buscarOcurrencias(int[] vector, int indice, int valor,
                                  ArrayList<Integer> posiciones){
        
        if(indice >= vector.length){
            return;
        }
        
        if(vector[indice] == valor){
            posiciones.add(indice);
        }
        
        buscarOcurrencias(vector, indice + 1, valor, posiciones);
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////// 6. BUSQUEDA RECURSIVA DEL MINIMO /////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    
    public int buscarMinimo(int[] vector, int indice){
        
        if(indice == vector.length - 1){
            return vector[indice];
        }
        
        int minimoRestante = buscarMinimo(vector, indice + 1);
        
        if(vector[indice] < minimoRestante){
            return vector[indice];
        }
        
        return minimoRestante;
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////// 7. BUSQUEDA RECURSIVA DEL MAXIMO /////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    
    public int buscarMaximo(int[] vector, int indice){
        
        if(indice == vector.length - 1){
            return vector[indice];
        }
        
        int maximoRestante = buscarMaximo(vector, indice + 1);
        
        if(vector[indice] > maximoRestante){
            return vector[indice];
        }
        
        return maximoRestante;
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////// 8. BUSQUEDA RECURSIVA DE POSICION ////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    
    public int buscarPosicion(int[] vector, int indice, int valor){
        
        if(indice >= vector.length){
            return -1;
        }
        
        if(vector[indice] == valor){
            return indice;
        }
        
        return buscarPosicion(vector, indice + 1, valor);
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////// 9. BUSQUEDA RECURSIVA EN AMBOS EXTREMOS //////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    
    public boolean buscarAmbosExtremos(int[] vector, int inicio, int fin, int valor){
        
        if(inicio > fin){
            return false;
        }
        
        if(vector[inicio] == valor || vector[fin] == valor){
            return true;
        }
        
        return buscarAmbosExtremos(vector, inicio + 1, fin - 1, valor);
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////// MAIN //////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    
    public static void main(String[] args){
        
        BusquedaRecursiva busqueda = new BusquedaRecursiva(10);
        int[] vector = busqueda.retornarVector();
        
        busqueda.imprimirVector(vector);
        
        int valor = 12;
        
        System.out.println("Valor buscado.." + valor);
        
        
        //////////////////////////////////////////////////////////////////////////////////////
        ////////////////////// PRUEBA 1. BUSQUEDA SECUENCIAL ////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
        if(secuencial(vector, 0, valor)){
            System.out.println("Elemento encontrado");
        }else{
            System.out.println("Elemento no encontrado");
        }
        
        
        //////////////////////////////////////////////////////////////////////////////////////
        ////////////////////// PRUEBA 2. BUSQUEDA POR INDICE /////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
        int posicion = busqueda.buscarIndice(vector, 0, valor);
        
        if(posicion != -1){
            System.out.println("Elemento encontrado en la posicion:" + posicion);
        }else{
            System.out.println("Elemento no encontrado");
        }
        
        
        //////////////////////////////////////////////////////////////////////////////////////
        ////////////////////// PRUEBA 3. BUSQUEDA BINARIA ////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
        Arrays.sort(vector);
        
        System.out.println("Vector ordenado:");
        busqueda.imprimirVector(vector);
        
        int pBinaria = busqueda.buscarBinaria(
                vector, 0, vector.length - 1, valor
        );
        
        if(pBinaria != -1){
            System.out.println("Elemento encontrado en la posicion:" + pBinaria);
        }else{
            System.out.println("Elemento no encontrado");
        }
        
        //////////////////////////////////////////////////////////////////////////////////////
////////////////////// PRUEBA 4. BINARIA CON LIMITES ///////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////

int pBinariaLimites = busqueda.buscarBinariaConLimites(
        vector, 0, vector.length - 1, valor
);

if(pBinariaLimites != -1){
    System.out.println("Elemento encontrado en la posicion:" + pBinariaLimites);
}else{
    System.out.println("Elemento no encontrado");
}
        
        
        //////////////////////////////////////////////////////////////////////////////////////
        ////////////////////// PRUEBA 5. TODAS LAS OCURRENCIAS ///////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
        ArrayList<Integer> posiciones = new ArrayList<>();
        
        busqueda.buscarOcurrencias(vector, 0, valor, posiciones);
        
        System.out.println("Todas las ocurrencias de " + valor + ": " + posiciones);
        
        
        //////////////////////////////////////////////////////////////////////////////////////
        ////////////////////// PRUEBA 6. BUSQUEDA DEL MINIMO /////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
        int minimo = busqueda.buscarMinimo(vector, 0);
        
        System.out.println("Minimo: " + minimo);
        
        
        //////////////////////////////////////////////////////////////////////////////////////
        ////////////////////// PRUEBA 7. BUSQUEDA DEL MAXIMO /////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
        int maximo = busqueda.buscarMaximo(vector, 0);
        
        System.out.println("Maximo: " + maximo);
        
        
        //////////////////////////////////////////////////////////////////////////////////////
        ////////////////////// PRUEBA 8. BUSQUEDA DE POSICION ///////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
        int posicionRecursiva = busqueda.buscarPosicion(vector, 0, valor);
        
        System.out.println("Posicion: " + posicionRecursiva);
        
        
        //////////////////////////////////////////////////////////////////////////////////////
        ////////////////////// PRUEBA 9. AMBOS EXTREMOS /////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
        boolean encontradoExtremos = busqueda.buscarAmbosExtremos(
                vector, 0, vector.length - 1, valor
        );
        
        if(encontradoExtremos){
            System.out.println("Elemento encontrado desde ambos extremos");
        }else{
            System.out.println("Elemento no encontrado");
        }
    }
}