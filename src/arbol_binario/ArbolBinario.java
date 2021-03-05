/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_binario;

import javax.swing.JOptionPane;

/**
 *
 * @author paiz2
 */
public class ArbolBinario {
    
    private Nodo raiz;
    
    public ArbolBinario(){
        raiz = null;
    }

    
    
    public void insertar(int i, String contenido){
        Nodo n = new Nodo(i);
        n.valor = contenido;
        
        //INICIALIZANDO LA RAÍZ DEL ÁRBOL
        if(raiz == null)
            raiz = n;
        else{
            //RECORRIENDO EL ARBOL
            Nodo aux = raiz;
            while(aux != null){
                n.padre = aux;
                
                if(n.llave >= aux.llave)
                    aux = aux.derecha;
                else
                    aux = aux.izquierda;
            }
            
            //INSERCIÓN DEL NUEVO NODO
            if(n.llave < n.padre.llave)
                n.padre.izquierda = n;
            else
                n.padre.derecha = n;        
        }
    }
    
    public void inOrden(Nodo n){
        if(n != null){
            inOrden(n.izquierda);
            System.out.println(n.valor + ", ");
            inOrden(n.derecha);
        }
    }
    
    public void preOrden(Nodo n){
        JOptionPane.showMessageDialog(null, n.valor);
        if(n != null){
            System.out.println(n.valor + ", ");
            
            inOrden(n.izquierda);
            inOrden(n.derecha);
        }
    }
    
    public void posOrden(Nodo n){
        if(n != null){
            inOrden(n.izquierda);
            inOrden(n.derecha);
            System.out.println(n.valor + ", ");
        }
    }
    
    
    
    public void recorrer(Nodo n){
        if(n != null)
        {
            recorrer(n.izquierda);
            System.out.println("Indice: " + n.llave + ", Valor: " + n.valor);
            recorrer(n.derecha);
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
 
    private class Nodo{
        public Nodo padre;
        public Nodo derecha;
        public Nodo izquierda;
        public int llave;
        public String valor;
        
        public Nodo(int indice){
            padre = null;
            derecha = null;
            izquierda = null;
            llave = indice;
            valor = null;
        }
    }
}
