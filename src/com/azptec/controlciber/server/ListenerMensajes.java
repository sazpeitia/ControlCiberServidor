/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azptec.controlciber.server;

import com.azptec.controlciber.common.EntidadServidorListener;

/**
 *
 * @author sazpeitia
 */
public class ListenerMensajes extends EntidadServidorListener {

    @Override
    public void run() {

        if (getServidor() != null) {
            
            while (getServidor().isConectado()) {
                
                
            }
            
            
        } else {
            
            System.out.println("Servidor nulo. Finaliza hilo");
        }

    }
}
