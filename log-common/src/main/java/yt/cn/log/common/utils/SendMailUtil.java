package yt.cn.log.common.utils;
import java.util.*;


import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class SendMailUtil {

	 
	    
	    public static String sendEmail(String fromEmail, String fromName,
				String toEmail, String toName, String subject, String message)
				throws EmailException {

			// 发送者的电邮地址和名称无效时设置为系统设置内容
			if (fromEmail == null)
				fromEmail = "rrgy@gongyishibao.com";
			if (fromName == null)
				fromName = "人人公益网";

			try {
				HtmlEmail email = new HtmlEmail();
				email.setHostName("smtp.163.com");
				email.setAuthentication("yt0902@163.com", "yuantao123");
				email.setCharset("UTF-8");
				email.setFrom(fromEmail, fromName);
				email.addTo(toEmail, toName);
				email.setSubject(subject);
				email.setHtmlMsg(message);
				email.send();
			} catch (Exception e) {
				return "FAIL";
			}
			return "SUCCESS";
		}


		public static String sendEmail(String subject, String message) throws Exception{
			try {
				HtmlEmail email = new HtmlEmail();
				email.setHostName("smtp.163.com");
				email.setAuthentication("yt0902@163.com", "yuantao123");
				email.setCharset("UTF-8");
				email.setFrom("yt0902@163.com","邮件验证");
				email.addTo("463861615@qq.com","验证码");
				email.setSubject(subject);
				email.setHtmlMsg(message);
				email.send();
			} catch (Exception e) {
				return "FAIL";
			}
			return "SUCCESS";
		}
		/**
		 * 邮件标题，邮件内容，邮箱
		 * @param subject
		 * @param message
		 * @param emailName
		 * @return
		 * @throws Exception
		 */
	/*	public static String CodeEmail(String subject, String message,String emailName) throws Exception{
			try {
				HtmlEmail email = new HtmlEmail();
				email.setHostName("smtp.163.com");
				email.setAuthentication("yt0902@163.com", "yuantao123");
				email.setCharset("UTF-8");
				email.setFrom("yt0902@163.com","邮件验证");
				email.addTo(emailName,"验证码");
				email.setSubject(subject);
				email.setHtmlMsg(message);
				email.send();
			} catch (Exception e) {
				e.printStackTrace();
				return "FAIL";
			}
			return "SUCCESS";
		}*/
		public static String CodeEmail(String subject, String message,String emailName) throws Exception{
			try {
				HtmlEmail email = new HtmlEmail();
				email.setHostName("smtp.163.com");
				email.setAuthentication("yijavot@163.com", "yuantao123");
				email.setCharset("UTF-8");
				email.setFrom("yijavot@163.com","邮件验证");
				email.addTo(emailName,"验证码");
				email.setSubject(subject);
				email.setHtmlMsg(message);
				email.send();
			} catch (Exception e) {
				e.printStackTrace();
				return "FAIL";
			}
			return "SUCCESS";
		}
		
		public static void main(String[] args) {
			try {
				CodeEmail("ss","ss","413143906@qq.com");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}



		public static String sendEmail(String toEmail, String toName,
				String subject, String message) throws EmailException {
			// 检查邮件服务器信息和账号信息是否有效，无效时不发送邮件
			return sendEmail(null, null, toEmail, toName, subject, message);
		}
		
		public static String getSixDom(){
			 String str = "";       
			 char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
					 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
					 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};    
			 Random random = new Random();      
			 for (int i = 0; i <6; i++){    
				 char num = ch[random.nextInt(ch.length)];   
				 str += num;     
				 }
			 return str;
		}


		
}