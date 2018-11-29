package yt.cn.log.common.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailUtils {
	
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
			email.setFrom("yt0902@163.com","产业集群");
			email.addTo("463861615@qq.com","预警功能");
			email.setSubject(subject);
			email.setHtmlMsg(message);
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
			return "FAIL";
		}
		return "SUCCESS";
	}
	
	public static void main(String[] args) throws Exception {
		SendEmailCode("测试","413143906@qq.com","测试成功");
		//sendEmail("000","sss");
	}

	public static String SendEmailCode(String subject,String mail,String messageCode) throws Exception{
		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName("smtp.163.com");
			email.setAuthentication("yijavot@163.com", "yuantao123");
			email.setCharset("UTF-8");
			email.setFrom("yijavot@163.com",subject); //邮箱主题
			email.addTo(mail); //发送邮箱
			email.setSubject(subject);
			email.setHtmlMsg(messageCode); //邮箱内容
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
			return "fall";
		}
		return "success";
	}


	public static String sendEmail(String toEmail, String toName,
			String subject, String message) throws EmailException {
		// 检查邮件服务器信息和账号信息是否有效，无效时不发送邮件
		return sendEmail(null, null, toEmail, toName, subject, message);
	}

}
