/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azptec.controlciber.server.run;

import com.azptec.controlciber.common.EntidadServidor;
import com.azptec.controlciber.common.EntidadServidorListener;
import com.azptec.controlciber.server.ListenerConexion;

/**
 *
 * @author sazpeitia
 */
public class ServerRun {
    public static void main(String[] args) {
        
        EntidadServidor entidadServidor = new EntidadServidor();
        entidadServidor.setPort(42001);
        entidadServidor.iniciarConexion();
        
        ListenerConexion listenerConexion = new ListenerConexion();
        listenerConexion.setServidor(entidadServidor);
        
        Thread hiloListenerConexion = new Thread(listenerConexion);
        hiloListenerConexion.start();
    }
}
