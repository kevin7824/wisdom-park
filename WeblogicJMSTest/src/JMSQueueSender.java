import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class JMSQueueSender {

	/**
	 * @param args
	 * @throws NamingException 
	 * @throws JMSException 
	 */
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
		//create sender
		QueueSender qSender = qSession.createSender(queue);
		//create message
		Message msg = qSession.createTextMessage("贺--------------凯!!!");
/*		MapMessage msg2 = qSession.createMapMessage();
		msg2.setString("name", "asdf");
		qSender.send(msg2);*/
		qSender.send(msg);
		qSender.close();
		qSession.close();
		qConn.close();
	}

}
