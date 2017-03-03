/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azptec.controlciber.server;

import com.azptec.controlciber.common.EntidadCliente;
import com.azptec.controlciber.common.EntidadServidorListener;
import com.azptec.controlciber.common.EntidadSocket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author sazpeitia
 */
public class ListenerConexion extends EntidadServidorListener {

    @Override
    public void run() {

        if (getServidor() != null) {

            while (getServidor().isConectado()) {

                if (!getServidor().isListaIterando()) {

                    System.out.println("Server va a esperar por conexion...");
                    getServidor().nuevaConexionCliente(new EntidadCliente());
                    System.out.println("Server ha establecido conexion con cliente");
                    System.out.println("Server va a limpiar conexiones rotas...");
                    limpiarClientes();
                    
                } else {

                    System.out.println("El servidor esta Iterando. No es posible iniciar nueva conexion con cliente");
                }

                esperar(5000, "Servidor-> Esperando 5 segundos antes de volver aceptar conexión");
            }

        } else {

            System.out.println("Servidor nulo. Finaliza hilo");
        }
        
    }
    
    public void limpiarClientes() {
        
        if ( getServidor().getEntidadSocketLista()!= null &  
                getServidor().getEntidadSocketLista().size() > 0 ) {
            
            getServidor().setListaIterando(true);
            
            List<EntidadSocket> clientesAEliminar = new ArrayList<>();

            Iterator<EntidadSocket> clientes = 
                    getServidor().getEntidadSocketLista().iterator();

            while( clientes.hasNext() ) {

                EntidadSocket cliente = clientes.next();
                if ( cliente.isBrockenPipe() ) {
                    
                    clientesAEliminar.add( cliente );
                }
            }
            
            clientesAEliminar.forEach((clienteAEliminar) -> {
                System.out.println("Limpiando cliente ID :" + clienteAEliminar.getIdEntidad() );
                getServidor().getEntidadSocketLista().remove( clienteAEliminar );
            });
            
            getServidor().setListaIterando(false);
        }
        else System.out.println("La lista de clientes esta vacia");
    }
}
