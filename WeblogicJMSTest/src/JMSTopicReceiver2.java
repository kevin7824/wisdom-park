import java.util.Properties;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;

public class JMSTopicReceiver2 implements MessageListener{
	public JMSTopicReceiver2(){   
		TopicConnectionFactory tcf = null;         
		Topic topic = null;          
		try {      
			String m_url="t3://localhost:7001";        
			Properties h = new Properties();          
			h.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");      
			h.put(Context.PROVIDER_URL, m_url);       
			Context jndiContext = new InitialContext(h);       
			tcf = (TopicConnectionFactory) jndiContext.lookup("jms/ConnectionFactory");           
			topic = (Topic) jndiContext.lookup("jms/Topic");            
			TopicConnection tc = null;             
			tc = tcf.createTopicConnection();                        
			String clientID = "client2";                  
			tc.setClientID(clientID);            
			TopicSession ts = tc.createTopicSession(false,  Session.AUTO_ACKNOWLEDGE);            
			TopicSubscriber tsu = ts.createDurableSubscriber(topic, clientID);  
			//异步调用时使用             
			tsu.setMessageListener(this);            
			tc.start();            
		} catch(Exception ex){    
			ex.printStackTrace();   
		}   
	}  
	
	public static void main(String []a){   
		new JMSTopicReceiver2();    
	}    

	public void onMessage(Message message) { 
		try {    
			String MessageText = null;    
			if (message instanceof TextMessage){    
				MessageText = ((TextMessage)message).getText();     
				System.out.println("client2已收到消息："+MessageText);     
			}        
		} catch (Exception e) {    
			e.printStackTrace();   
		}    
	}
}
