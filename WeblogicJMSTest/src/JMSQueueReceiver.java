import java.util.Properties;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class JMSQueueReceiver {
	
	public static void main(String[] args) throws NamingException, JMSException {
		String m_url="t3://localhost:7001";        
		Properties h = new Properties();          
		h.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");      
		h.put(Context.PROVIDER_URL, m_url);       
		Context ctx = new InitialContext(h);
		
		//jms connectionFactory JNDI name
		QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.lookup("ConnectionFactory-0");
		//create queue connection
		QueueConnection qConn = (QueueConnection) connFactory.createConnection();
		//create session
		QueueSession qSession = qConn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		//find queue by JNDI lookup
		Queue queue = (Queue) ctx.lookup("SevenQueue");
		
		//create receiver
		QueueReceiver qReceiver = qSession.createReceiver(queue);
		//create message listener
		qReceiver.setMessageListener(new MessageListener() {

			public void onMessage(Message msg) {
				String msgText = "";
				double d = 0;
				 try {
					if (msg instanceof TextMessage) {   
					        msgText = ((TextMessage) msg).getText();   
					    } else if (msg instanceof StreamMessage) {   
					        msgText = ((StreamMessage) msg).readString();   
					        d = ((StreamMessage) msg).readDouble();   
					    } else if (msg instanceof BytesMessage) {   
					        byte[] block = new byte[1024];   
					        ((BytesMessage) msg).readBytes(block);   
					        msgText = String.valueOf(block);   
					    } else if (msg instanceof MapMessage) {   
					        msgText = ((MapMessage) msg).getString("bb");   
					    } 
				} catch (JMSException e) {
					e.printStackTrace();
				}   
				
				System.out.println(msgText + " " + d);
			}});

		qConn.start();
		
	}
	
}
