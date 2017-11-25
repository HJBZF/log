<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>用户登录|窝窝团</title>
<link rel="stylesheet" href="css/basic.css" />
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
function userLogin(){
	var name=$.trim($("#email").val());
	var pwd=$.trim($("#password").val());
	var regsafecode=$.trim($("#regsafecode").val());
	
	$.post("../userInfoServlet",{op:"userLogin",name:name,pwd:pwd,regsafecode:regsafecode},function(data){
		data=$.trim(data);
		if(data==3){
			var str="您好!"+data+"<b class='borderdc'>|</b>";
			str+='[<a class="yellowd1" rel="nofollow" href="javascript:userOutlogin()" target="_blank">注销</a>]';
			str+='<b class="borderdc">|</b>';
			$("#loginInfo").html(str);
			location.href="index.jsp";
		}else if(data==2){
			alert("用户名或密码错误，请重新输入...")
		}else if(data==1){
			alert("验证码错误，请重新输入...")
		}
		
	},"text");
}

//勾选按钮时改变按钮颜色
function changezhucecolor(){
	var uname=$.trim( $("#email").val() );
	var uname=$.trim( $("#password").val() );
	var uname=$.trim( $("#regsafecode").val() );
	
	if(uname){
		$("#userLogin").css("background","#ff9d58");
	}else{
		$("#userLogin").css("background","#eee");
	}
}

</script>



</head>

<body>

<%@include file="top.jsp" %>

<div id="headMin">
  <ul class="headConul clearfix">
    <li class="logoLi"> <a gae="click_logo" href="#">
      <h1 class="bh logo">窝窝团</h1>
      </a> </li>
    <li class="wowoTitLi"> <a gae="click_slogan" href="#">
      <h2 class="bh wowoTit">精挑细选</h2>
      </a> </li>
    <li class="cityBox">
      <h2 id="cityname" class="cityName">衡阳</h2>
      <span class="cityLink"> 【<a class="Gray5a" href="http://www.55tuan.com/city_list.html" gae="city_list">切换城市</a>】 </span> <span id="show_city" class="cityTs"> <b class="triangbor">三角</b> <a id="ipClose" class="closeTs" href="javascript:;">关闭</a> 您是不是在 <em id="ipcityname" class="bluec4">衡阳</em> ？点击可选择其他城市 </span> </li>
    <li class="searchLi ">
      <div class="searchlf"> <span class="tri"></span>
        <div class="hd"> <a class="on deal" href="javascript:;">团购</a> <a class="shoper" href="javascript:;">商家</a> </div>
      </div>
      <form id="soso_form" method="get" action="">
        <input class="searchTxt" type="text" autocomplete="off" maxlength="140" name="w" placeholder="请输入商品名、地址">
        <a id="soso_submit" class="searchBtn" href="#">搜索</a>
        <input id="sg_from" type="hidden" name="sg_from" value="1">
        <input id="searchType" type="hidden" name="searchType" value="0">
      </form>
      <div class="hotkey" style="display:block" data-title="data_T"> <a target="_self" gae="click_search_top-月饼" href="#">月饼</a> <a class="on" target="_self" gae="click_search_top-KTV" href="#">KTV</a> <a target="_self" gae="click_search_top-蛋糕" href="#">蛋糕</a> <a target="_self" gae="click_search_top-希朵曼" href="#">希朵曼</a> <a target="_self" gae="click_search_top-万达" href="#">万达</a> <a target="_self" gae="click_search_top-水上乐园" href="#">水上乐园</a> </div>
      <div class="hotkey" data-title="data_S" style="display: none;"> <a target="_self" gae="click_search_top-月饼" href="#">月饼</a> <a class="on" target="_self" gae="click_search_top-KTV" href="#">KTV</a> <a target="_self" gae="click_search_top-蛋糕" href="#">蛋糕</a> <a target="_self" gae="click_search_top-希朵曼" href="#">希朵曼</a> <a target="_self" gae="click_search_top-万达" href="#">万达</a> <a target="_self" gae="click_search_top-水上乐园" href="#">水上乐园</a> </div>
      <div class="searchBox">
        <p class="searchTip">最近搜索过 </p>
        <ul class="clearfix">
        </ul>
      </div>
    </li>
    <li id="userPointDiv" class="pointnum"> <b class="triangbor">三角</b> <span class="Gray7"> 积分：<strong id="userPointStrong" class="red21"></strong> </span> </li>
  </ul>
</div>
<div id="headNav">
  <ul id="navList" class="navUl clearfix">
    <li class="first_nav" date-nav="index"> <a gae="click_channel1_Nav" href="http://hengyang.55tuan.com">团购精选</a> </li>
    <li date-nav="shangcheng"> <a gae="click_channel10_Nav" href="http://hengyang.55.com">窝窝商城</a> </li>
    <li class="zIndex2" date-nav="shenbian"> <a gae="click_channel12_Nav" href="http://hengyang.55tuan.com/shenbian/list">身边</a> </li>
    <li date-nav="meishi"> <a gae="click_channel2_Nav" href="http://hengyang.55tuan.com/meishi">美食</a> </li>
    <li date-nav="yule"> <a gae="click_channel3_Nav" href="http://hengyang.55tuan.com/yule">娱乐</a> </li>
    <li class="zIndex" date-nav="dianying"> <a gae="click_channel4_Nav" href="http://hengyang.55tuan.com/dianying/dingzuo">电影</a> </li>
    <li date-nav="meirongbaojian"> <a gae="click_channel5_Nav" href="http://hengyang.55tuan.com/meirongbaojian">美容保健</a> </li>
    <li date-nav="shenghuofuwu"> <a gae="click_channel6_Nav" href="http://hengyang.55tuan.com/shenghuofuwu">生活服务</a> </li>
    <li date-nav="jiehun"> <a gae="click_channel13_Nav" href="http://jiehun.55tuan.com">结婚</a> </li>
    <li date-nav="lvyou"> <a gae="click_channel7_Nav" href="http://lvyou.55tuan.com">旅行</a> </li>
    <li date-nav="jiudian"> <a gae="click_channel8_Nav" href="http://jiudian.55tuan.com">酒店</a> </li>
    <li date-nav="shangpin"> <a gae="click_channel9_Nav" href="http://shangpin.55tuan.com">网购</a> </li>
    <li date-nav="shop"> <a gae="click_channel11_Nav" href="http://shop.55tuan.com">品牌汇</a> </li>
  </ul>
</div>
<div class="ucenter clearfix">
  <div class="uc-box clearfix">
    <div class="title_main"> 用户登录 </div>
    <div id="loginbox" class="ucon">
      <div class="msgerror">
        <p><span id="login_msg" class="error"></span></p>
      </div>
      <form id="loginform" class="formbox" action="" method="get" name="form1" style="display: block">
        <input type="hidden" value="" name="callbackparam">
        <input type="hidden" value="" name="service">
        <input id="url" type="hidden" value="" name="url">
        <input id="source" type="hidden" value="1" name="source">
        <table class="log-reg-table" width="620" cellspacing="0" cellpadding="0" border="0">
          <tbody>
            <tr>
              <td width="160" align="right">登录名：</td>
              <td><input class="int-type w-fir grey" type="text" id="email" name="email" placeholder="手机号/邮箱/用户名" tips="手机号/邮箱/用户名" rule=""></td>
            </tr>
            <tr>
              <td width="160" align="right">密  码：</td>
              <td><input class="int-type w-fir" type="password" id="password" name="password" tips="密码" value="" status="error"></td>
            </tr>
            <tr>
		<td align="right">验证码：</td>
	    <td>
	    	<div class="intbox">
	      		<input id="regsafecode" class="int-type w-sec" type="text" name="regsafecode" tips="验证码" rule="required" codedata="" maxlength="4">
	      		<img id="safecoderegimg" class="pic" src="js/valiCodeImg.jsp" border="0" title="点击图片刷新验证码" size="10" />
	      		<a onclick="$('#safecoderegimg').attr('src','js/valiCodeImg.jsp?d='+new Date().getTime())" id="safecodereglink" class="tips" href="javascript:void(0)">看不清？换一张</a>
	      	</div>
	    	<label id="regsafecode_msg" class="labelbox"></label>
	    </td>
	</tr>
            <tr>
              <td></td>
              <!-- <td><a id="userLogin" class="ubg bigtn redbig" gae="click_login_normal_login" href="javascript:userLogin()">登录</a> <a class="tips" href="#" gae="click_user-login/password">忘记密码？</a></td> -->
              <td><a id="userLogin" class="ubg bigtn redbig" gae="click_login_normal_login" href="javascript:userLogin()" onclick="changezhucecolor()">登录</a> <a class="tips" href="#" gae="click_user-login/password">忘记密码？</a></td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
    <div class="uside">
      <div class="side-top nonebor">
        <p class="tit">还不是窝窝团用户?</p>
        <a class="ubg bigtn secbig" href="reg.jsp" target="_self" gae="click_user-login/register">注册新用户</a> </div>
      <div class="side-min">
        <p class="tit">使用合作网站账号登录窝窝团</p>
        <div class="otherlogin"> <a class="weibo" href="#" gae="click_user-login/weibo" alt="新浪微博" target="_blank">新浪微博</a> <a class="zh60" href="#" gae="click_user-login/360" alt="360" target="_blank">360帐号</a> <a class="t800" href="#" gae="click_user-login/tuan800" alt="团800" target="_blank">团800</a> <a class="qq" href="#" gae="click_user-login/QQ" alt="QQ" target="_blank">QQ</a> <a class="baid" href="#" gae="click_user-login/baidu" alt="百度" target="_blank">百度</a> <a class="zfb" href="#" gae="click_user-login/zhifubao" alt="支付宝" target="_blank">支付宝</a> </div>
      </div>
    </div>
  </div>
</div>
<div id="footer">
  <div class="bottom-box clearfix">
    <div class="boul">
      <ul class="boul-list">
        <li class="li-x">
          <h2 class="">用户帮助</h2>
        </li>
        <li> <a class="bolist-a" rel="nofollow" href="#">玩转窝窝</a> </li>
        <li> <a class="bolist-a" rel="nofollow" href="#">常见问题</a> </li>
        <li> <a class="bolist-a" rel="nofollow" href="#">秒杀规则</a> </li>
        <li> <a class="bolist-a" rel="nofollow" href="#">积分规则</a> </li>
        <li> <a class="bolist-a" rel="nofollow" href="#">代金券说明</a> </li>
        <li> <a class="bolist-a" rel="nofollow" href="#">评价说明</a> </li>
      </ul>
      <b class="ico"></b> </div>
    <div class="boul">
      <ul class="boul-list">
        <li class="li-x">
          <h2 class="h2-1">获取更新</h2>
        </li>
        <li> <a class="bolist-a" gae="weibo" href="#" target="_blank">窝窝团新浪微博</a> </li>
        <li> <a class="bolist-a" gae="tencentbtm" href="#" target="_blank">窝窝团腾讯微博</a> </li>
        <li> <a class="bolist-a" rel="nofollow" gae="click_mobile_bottom" href="#">手机版下载</a> </li>
      </ul>
      <b class="ico ico2"></b> </div>
    <div class="boul">
      <ul class="boul-list">
        <li class="li-x">
          <h2 class="h2-2">商务合作</h2>
        </li>
        <li> <a class="bolist-a" rel="nofollow" href="#">商家入驻</a> </li>
        <li> <a class="bolist-a" rel="nofollow" href="#">提供团购信息</a> </li>
        <li> <a class="bolist-a" rel="nofollow" href="#">友情链接</a> </li>
        <li> <a class="bolist-a" rel="nofollow" href="#">开放API </a> </li>
      </ul>
      <b class="ico ico3"></b> </div>
    <div class="boul">
      <ul class="boul-list">
        <li class="li-x">
          <h2 class="h2-3">公司信息</h2>
        </li>
        <li> <a class="bolist-a" rel="nofollow" href="#">关于我们</a> </li>
        <li> <a class="bolist-a" rel="nofollow" href="#">媒体报道</a> </li>
        <li> <a class="bolist-a" rel="nofollow" href="#">加入我们</a> </li>
        <li> <a class="bolist-a" rel="nofollow" href="#">隐私声明</a> </li>
        <li> <a class="bolist-a" rel="nofollow" href="#">用户协议</a> </li>
        <li> <a class="bolist-a" rel="nofollow" href="#">营业执照</a> </li>
      </ul>
      <b class="ico ico4"></b> </div>
    <div class="kefu">
      <div class="kefu-bottom">
        <h2 class="kh2-0 bh">不满意就退款</h2>
        <h2 class="kh2-1">24小时客服热线</h2>
        <h2 class="kh2-2 bh">400-105-5555</h2>
        <a class="bh kfwwweibo" target="_blank" href="#">窝窝团客服微博</a> </div>
    </div>
  </div>
</div>
<div class="footer-btm">
  <div class="footer"> &copy; 2010-2014 55tuan.com 京ICP证100702号 京公海网安备110108000829号&nbsp; <a target="_blank" href="#">营业执照</a> </div>
  <div class="footer">名称：北京窝窝团信息技术有限公司&nbsp;&nbsp;&nbsp;&nbsp;地址 ：北京市海淀区上地信息路18号三层3001&nbsp;&nbsp;&nbsp;&nbsp;电话 ：010-59065200</div>
  <div class="footer">营业执照注册号 ：110108011056221&nbsp;&nbsp;&nbsp;&nbsp;食品流通许可证：SP1101081110124921</div>
  <div class="wowofawu"> <a class="fawu-1" rel="nofollow" href="#">支付宝</a> <a class="fawu-3" rel="nofollow" href="#" target="_blank">可信网站</a> <a class="fawu-5" rel="nofollow" href="#" target="_blank">经营性网站备案信息</a> </div>
</div>
<div id="ritfllow"> <a class="gotopBtn" href="#" style="visibility: visible; height: 38px;">top</a>
  <div class="mobileBtn" style="visibility: hidden;">
    <div class="codeImg"> <a gae="click_apr_erweima" target="_blank" href="#"> <img width="116" height="148" src="images/ritcodes0807.png"> </a> </div>
  </div>
  <a class="fee_opin" target="_blank" href="#">意见反馈</a> </div>
<div id="ritCode">
  <div class="imgbox"> <a gae="click_apr_erweima" target="_blank" href="#"> <img width="108" height="183" src="images/ritcodeb.png"> </a> <a class="cCode" href="#">close</a> </div>
</div>
</body>
</html>
