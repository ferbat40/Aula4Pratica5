/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author PARTICULAR
 */

@MessageDriven(activationConfig ={
    @ActivationConfigProperty(
            propertyName="destinationLookup",
            propertyValue= "Java/Fila"),
        @ActivationConfigProperty(
        propertyName="destinationType",
                propertyValue="javax.jms.Queue"
        )

}
)
public class EJBConsumidor implements MessageListener {

    @Override
    public void onMessage(Message msg) {
   
   
   
   try{
       TextMessage tm = (TextMessage) msg;
       System.out.println(tm.getText());
   }catch(Exception ex){
       
   }
   
   
           }
    
}
