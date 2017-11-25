<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>

	<div id="headTop">
		<ul class="headTopUl clearfix">
			<li class="headTopUser">
				<ul class="headTopList clearfix">
					<li class="headRelat listmore"><em class="moreico">woico</em>
						<a class="Gray7" href="#">更多</a> <b class="triangleT">triangle</b>
						<ul class="ulbox linkmorbox">
							<li><a href="#">手机版下载</a></li>
							<li><a id="addEmailBtn" href="#">邮件订阅</a></li>
							<li><a href="#">收藏本站</a></li>
						</ul> <b class="bh whiteBor">遮盖</b></li>
					<li class="headRelat listsec"><a class="Gray7" href="#">关注</a>
						<b class="triangleT">triangle</b>
						<ul class="ulbox linkBoxsec">
							<li><a class="wowo-sina" href="#" target="_blank"
								title="窝窝团新浪微博">窝窝团新浪微博</a></li>
							<li><a class="wowo-qq" href="#" target="_blank"
								title="窝窝团腾讯微博">窝窝团腾讯微博</a></li>
							<li><a class="wowo-sina" href="#" title="窝窝团新浪客服微博"
								target="_blank">窝窝团新浪客服微博</a></li>
						</ul> <b class="bh whiteBor">遮盖</b></li>
					<li class="headRelat headline"><em class="l-ico"></em></li>
					<li class="headRelat list"><em class="woico">woico</em> <a
						class="Gray7" rel="nofollow" href="#">我的窝窝</a> <b
						class="triangleT">triangle</b>
						<ul class="ulbox linkBox">
							<li><a rel="nofollow" href="#">我的订单</a></li>
							<li><a rel="nofollow" href="#">我的收藏</a></li>
							<li><a rel="nofollow" href="#">我的积分</a></li>
							<li><a rel="nofollow" href="#">我的评价</a></li>
							<li><a rel="nofollow" href="#">帐号设置</a></li>
							<li><a rel="nofollow" href="#">账户余额</a></li>
							<li><a rel="nofollow" href="#">代金券</a></li>
							<li><a rel="nofollow" href="#">消息中心</a></li>
						</ul> <b class="bh whiteBor">遮盖</b></li>
				</ul>
			</li>
			<li class="headTopLogin">
			<span class="Gray7" id="loginInfo"> 
				<c:choose>
					<c:when test="${not empty currentLogin }">
					您好！${currentLogin.uname }<b class='borderdc'>|</b>
					[<a class="yellowd1" rel="nofollow" href="javascript:userOutlogin()" target="_blank">注销</a>]
					</c:when>
					<c:otherwise>
					您好！请[<a class="yellowd1" rel="nofollow" href="login.jsp" target="_blank">登录</a>]
					<b class="borderdc">|</b>[
					<a class="yellowd1" rel="nofollow" href="reg.jsp" target="_blank">注册</a>]
					<b class="borderdc p_0_10"></b>
					
					</c:otherwise>
				
				</c:choose>
			</span>
				<ul class="clearfix">
					<li id="msgCount" class="headTopUlist no"><em class="messico">messico</em>
						<a class="Gray7" rel="nofollow" href="#">消息</a></li>
					<b class="borderdc p_1_10">|</b>
				</ul> <a id="integration" href="#"> <em></em> 领积分抵钱
			</a></li>
		</ul>
	</div>
	
	</div>
