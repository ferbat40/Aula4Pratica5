/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author PARTICULAR
 */
@Named(value = "jSFProdutor")
@RequestScoped

public class JSFProdutor {

     @Resource(lookup="java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory contexts;
    
    @Resource(lookup="Java/Fila")
    private Queue fila;

    @Setter @Getter
    private String mensagem;
    
    /**
     * Creates a new instance of JSFProdutor
     */
    public JSFProdutor() {
    }
    
    public void send(){
       try{
           JMSContext context = contexts.createContext();
        context.createProducer().send(fila, mensagem);
       } catch(Exception ex){
           
       }
       }
}
