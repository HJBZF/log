package com.ss.erqiwwt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendMailServlet extends HttpServlet {
	private static final long serialVersionUID = -4845183154909514161L;
	private ServletConfig config = null;
	private static final String CONTENT_TYPE = "text/html";

	public void init(ServletConfig config1) throws ServletException {
		this.config = config1;
	}

	final public ServletConfig getServletConfig() {
		return config;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String to_mail = codeToString(request.getParameter("miss"));
		String to_title = codeToString(request.getParameter("title"));
		String to_content = codeToString(request.getParameter("content"));

		Properties props = new Properties();// 也可用Properties props = System.getProperties();
										
		props.put("mail.smtp.host", "smtp.sina.com");// 存储发送邮件服务器的信息
		props.put("mail.smtp.auth", "true");// 同时通过验证
		Session s = Session.getInstance(props);// 根据属性新建一个邮件会话
		s.setDebug(true);

		MimeMessage message = new MimeMessage(s);// 由邮件会话新建一个消息对象
		// 设置邮件
		InternetAddress from;
		try {
			from = new InternetAddress("miss");
			message.setFrom(from);// 设置发件人
			InternetAddress to = new InternetAddress(to_mail);
			message.setRecipient(Message.RecipientType.TO, to);// 设置收件人,并设置其接收类型为TO
			message.setSubject(to_title);// 设置主题
			message.setText(to_content);// 设置信件内容
			message.setSentDate(new Date());// 设置发信时间
			// 发送邮件
			message.saveChanges();// 存储邮件信息
			Transport transport = s.getTransport("smtp");
			// 以smtp方式登录邮箱,第一个参数是发送邮件用的邮件服务器SMTP地址,第二个参数为用户名,第三个参数为密码
			transport.connect("smtp.sina.com", 4, "imissyournai@sina.com", "#####");
			transport.sendMessage(message, message.getAllRecipients());// 发送邮件,其中第二个参数是所有已设好的收件人地址
			transport.close();
			response.setContentType(CONTENT_TYPE);
			PrintWriter out = response.getWriter();
			out.print("success");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public String codeToString(String str) {// 处理中文字符串的函数
		String s = str;
		try {
			byte tempB[] = s.getBytes("ISO-8859-1");
			s = new String(tempB);
			return s;
		} catch (Exception e) {
			return s;
		}
	}
}
