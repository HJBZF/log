package com.ss.erqiwwt.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ss.erqiwwt.bean.CusInfo;
import com.ss.erqiwwt.biz.IUserInfoBiz;
import com.ss.erqiwwt.biz.impl.UserInfoBizImpl;
import com.ss.erqiwwt.util.MailConnect;
import com.ss.erqiwwt.util.RequestToObject;


@WebServlet("/userInfoServlet")
public class UserInfoServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		if("userReg".equals(op)){
			userReg(request,response);
		}else if("jihuo".equals(op)){
			jihuo(request,response);
		}else if("userLogin".equals(op)){
			userLogin(request,response);
		}
		
	}


	private void userLogin(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String regsafecode=request.getParameter("regsafecode");
		
		HttpSession session=request.getSession();
		String rand=String.valueOf(session.getAttribute("rand"));
		
		int result=-1;
		
		IUserInfoBiz userInfoBiz=new UserInfoBizImpl();
		CusInfo cf=userInfoBiz.login(name, pwd);

		if(cf==null){
			result=2;   //用户名或密码错误
		}else if(!regsafecode.equals(rand)){    //说明验证码错误
			result=1;
		}else{
			//将当前登录用户存到session，以便于其他页面获取
			session.setAttribute("currentLoginAdmin", cf);
			//request.getSession().setAttribute(SessionAttributeInfo.CURRENTLOGININFO, cf);
			result=3;  //说明成功
		}

	this.out(response, result);
}

	private void jihuo(HttpServletRequest request, HttpServletResponse response) {
		String code=request.getParameter("code");
		String usid=request.getParameter("usid");
	
		//根据这个usid查找注册用户
		IUserInfoBiz userInfoBiz=new UserInfoBizImpl();
		CusInfo cf=userInfoBiz.getByUsid(usid);
		
		String flag=cf.getFlag();
		System.out.println(flag);
		
		String result="";
		response.setContentType("text/html;charset=utf-8");
		String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		
		if(flag!=null && !"".equals(flag) && flag.contains(";")){
			
			String[] flags=flag.split(";");
			if(!code.equals(flags[0])){
				result="<script>alert('激活地址有误，请重新注册...');location.href='"+basePath+"/wwt/reg.jsp';</script>;";
			}else{ //校验链接有没有过期
				Date d=new Date();
				long time=d.getTime()-Long.valueOf(flags[1]);
				if(time-20*60*1000>0){ //说明已经过时
					result="<script>alert('该激活地址已经过时，请重新注册...');location.href='"+basePath+"/wwt/reg.jsp';</script>;";

				}else{
					//修改地址
					if(userInfoBiz.active(usid, 1)>0){
						result="<script>alert('账号激活成功，请登录...');location.href='"+basePath+"/wwt/login.jsp';</script>;";

					}else{
						result="<script>alert('账号激活失败，请重新注册...');location.href='"+basePath+"/wwt/reg.jsp';</script>;";

					}
				}
			}
		}else{
			result="<script>alert('激活地址有误，请重新注册...');location.href='"+basePath+"/wwt/reg.jsp';</script>;";
		}
		this.out(response, result);
	}



	private void userReg(HttpServletRequest request, HttpServletResponse response) {
		RequestToObject requestToObject=new RequestToObject();
		CusInfo custInfo=requestToObject.setHelp(request,CusInfo.class);
		//发送一个激活邮件到指定邮箱
		String usid=UUID.randomUUID().toString();
		usid=usid.replace("-", "");
		custInfo.setUsid(usid);
		//System.out.println(usid);
		
		//发送邮件到邮箱
		long time=new Date().getTime(); //用来校验链接是否过期
		Random rd=new Random();
		String code=String.valueOf(rd.nextInt(100000)); //随机校验码
		custInfo.setFlag(code+";"+time);
		
		//发送邮件
		boolean bl=MailConnect.sendQQmail("3053558399@qq.com","kqthntyfbvlcdgia", custInfo.getEmail(), code, custInfo.getUname(),usid);
		int result=0;
		
		if(bl){//邮件发送是成功的，则将数据添加到数据库
			IUserInfoBiz userInfoBiz=new UserInfoBizImpl();
			result=userInfoBiz.user(custInfo);
		}
		this.out(response, result);
	}

}
