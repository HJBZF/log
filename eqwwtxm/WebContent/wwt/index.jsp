<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>窝窝团</title>
<link rel="stylesheet" href="css/basic.css" />
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
var goods;

$(function(){
	$.post("../goodsServlet",{op:"findGod"},function(data){
		goods = data;
		//alert(goods[1].gname);

		if(data!=null){
			var str="";
			for(var i=0;i<data.length;i++){
				str="";
				str +="<li class='good-list'> <h2 class='good-title'> <a class='biaoa' title="+data[i].gid+" target='_blank' ";
				str +=" href='showGood.jsp?op=\"findGood\"&gid="+data[i].gid+"'><strong>"+data[i].gname+"<>"+data[i].mark+"</a> </h2>";
				str +="<div class='index-smalllogo'> <a class='yuy' target='_blank' href='#'>免预约</a> </div>";
				str +="<a class='picture' target='_blank' href='#'> <img width='348' height='232' rel='nofollow' src='../../"+data[i].pic+"'> </a><div class='buy-boxInd clearfix'>";
				str +="<a class='bh buy_a' rel='nofollow' href='showGood.jsp'?op='findGood'&gid='"+data[i].gid+"' target='_blank' status='0'>去看看</a> <span class='num'>¥"+data[i].aprice+"</span> <span class='past'>价值 ¥"+data[i].price+"</span> </div> <>";
				
				$("#showGoods").append( $(str) );
			}
		}
	},"json");
});
</script>
</head>

<%@include file="top.jsp" %>
	<div id="headMin">
		<ul class="headConul clearfix">
			<li class="logoLi"><a gae="click_logo" href="#">
					<h1 class="bh logo">窝窝团</h1>
			</a></li>
			<li class="wowoTitLi"><a gae="click_slogan" href="#">
					<h2 class="bh wowoTit">精挑细选</h2>
			</a></li>
			<li class="cityBox">
				<h2 id="cityname" class="cityName">衡阳</h2> <span class="cityLink">
					【<a class="Gray5a" href="#" gae="city_list">切换城市</a>】
			</span> <span id="show_city" class="cityTs"> <b class="triangbor">三角</b>
					<a id="ipClose" class="closeTs" href="#">关闭</a> 您是不是在 <em
					id="ipcityname" class="bluec4">衡阳</em> ？点击可选择其他城市
			</span>
			</li>
			<li class="searchLi ">
				<div class="searchlf">
					<span class="tri"></span>
					<div class="hd">
						<a class="on deal" href="#">团购</a> <a class="shoper" href="#">商家</a>
					</div>
				</div>
				<form id="soso_form" method="get" action="">
					<input class="searchTxt" type="text" autocomplete="off"
						maxlength="140" name="w" placeholder="请输入商品名、地址"> <a
						id="soso_submit" class="searchBtn" href="#">搜索</a> <input
						id="sg_from" type="hidden" name="sg_from" value="1"> <input
						id="searchType" type="hidden" name="searchType" value="0">
				</form>
				<div class="hotkey" style="display: block" data-title="data_T">
					<a target="_self" href="#">月饼</a> <a class="on" target="_self"
						href="#">KTV</a> <a target="_self" href="#">蛋糕</a> <a
						target="_self" href="#">希朵曼</a> <a target="_self" href="#">万达</a>
					<a target="_self" href="#">水上乐园</a>
				</div>
				<div class="hotkey" data-title="data_S" style="display: none;">
					<a target="_self" href="#">月饼</a> <a class="on" target="_self"
						href="#">KTV</a> <a target="_self" href="#">蛋糕</a> <a
						target="_self" href="#">希朵曼</a> <a target="_self" href="#">万达</a>
					<a target="_self" href="#">水上乐园</a>
				</div>
				<div class="searchBox">
					<p class="searchTip">最近搜索过</p>
					<ul class="clearfix">
					</ul>
				</div>
			</li>
			<li id="userPointDiv" class="pointnum"><b class="triangbor">三角</b>
				<span class="Gray7"> 积分：<strong id="userPointStrong"
					class="red21"></strong>
			</span></li>
		</ul>
	</div>
	<div id="headNav">
		<ul id="navList" class="navUl clearfix">
			<li class="first_nav" date-nav="index"><a href="#">团购精选</a></li>
			<li date-nav="shangcheng"><a href="#">窝窝商城</a></li>
			<li class="zIndex2" date-nav="shenbian"><a href="#">身边</a></li>
			<li date-nav="meishi"><a href="#">美食</a></li>
			<li date-nav="yule"><a href="#">娱乐</a></li>
			<li class="zIndex" date-nav="dianying"><a href="#">电影</a></li>
			<li date-nav="meirongbaojian"><a href="#">美容保健</a></li>
			<li date-nav="shenghuofuwu"><a href="#">生活服务</a></li>
			<li date-nav="jiehun"><a href="#">结婚</a></li>
			<li date-nav="lvyou"><a href="#">旅行</a></li>
			<li date-nav="jiudian"><a href="#">酒店</a></li>
			<li date-nav="shangpin"><a href="#">网购</a></li>
			<li date-nav="shop"><a href="#">品牌汇</a></li>
		</ul>
	</div>
	<div id="wowoFocus" class="focuswowo">
		<ul style="height: 540px; top: -90px;">
			<li><a target="_blank" href="#"> <img class="lazyload"
					width="960" height="90" original="images/ggs1.jpg"
					src="images/ggs1.jpg" visibility="hidden">
			</a></li>
			<li><a target="_blank" href="#"> <img width="960"
					height="90" src="images/ggs2.jpg">
			</a></li>
			<li><a target="_blank" href="#"> <img class="lazyload"
					width="960" height="90" original="images/ggs3.jpg"
					src="images/ggs3.jpg" visibility="hidden">
			</a></li>
			<li><a target="_blank" href="#"> <img class="lazyload"
					width="960" height="90" original="images/ggs4.jpg"
					src="images/ggs4.jpg" visibility="hidden">
			</a></li>
			<li><a target="_blank" href="#"> <img class="lazyload"
					width="960" height="90" original="images/ggs5.jpg"
					src="images/ggs5.jpg" visibility="hidden">
			</a></li>
			<li><a target="_blank" href="#"> <img class="lazyload"
					width="960" height="90" original="images/ggs1.jpg"
					src="images/ggs1.jpg" visibility="hidden">
			</a></li>
		</ul>
	</div>
	<div class="con-boxIndex clearfix">
		<ul class="goods-allInd clearfix" id="showGoods">
			<!-- <li class="good-list">
				<h2 class="good-title">
					<a class="biaoa"
						title="【石鼓区】仅98元，享价值196元『熊猫餐谋环球海鲜自助餐厅』周一至周五双人自助午餐1份！提供免费WIFI，提供免费停车位！必含女士1名，提供免费专车接送，尽享环球美食！"
						target="_blank" href="#"> <strong>【石鼓区】熊猫餐谋环球海鲜自助餐厅</strong>
						周一至周五双人自助午餐1份！提供免费WIFI，提供免费停车位！
					</a>
				</h2>
				<div class="index-smalllogo">
					<a class="yuy" target="_blank" href="#">免预约</a>
				</div> <a class="picture" target="_blank" href="#"> <img width="348"
					height="232" rel="nofollow" src="images/show1.jpg">
			</a>
				<div class="buy-boxInd clearfix">
					<a class="bh buy_a" rel="nofollow" href="shopcart.jsp"
						target="_blank" status="0">去看看</a> <span class="num">¥98</span> <span
						class="past">价值 ¥196</span>
				</div>
			</li>
			<li class="good-list">
				<h2 class="good-title">
					<a class="biaoa"
						title="【雁峰区】仅67.5元，享价值160元『崇尚国际影城』3D单场双人套票1份！免费停车，高清巨幕多厅影城！"
						target="_blank" href="#"> <strong>【雁峰区】崇尚国际影城</strong>
						3D单场双人套票1份！
					</a>
				</h2>
				<div class="index-smalllogo">
					<a class="yuy" target="_blank" href="#">免预约</a>
				</div> <a class="picture" target="_blank" href="#"> <img width="348"
					height="232" rel="nofollow" src="images/show2.jpg">
			</a>
				<div class="buy-boxInd clearfix">
					<a class="bh buy_a" rel="nofollow" href="#" target="_blank"
						status="0">去看看</a> <span class="num">¥67.5</span> <span
						class="past">价值 ¥160</span>
				</div>
			</li>
			<li class="good-list">
				<h2 class="good-title">
					<a class="biaoa"
						title="【南方大厦】仅8.5元，享价值10元『方燕烤鸡腿』烤鸡腿1份！肉香皮脆，口感极佳，先卤再烤，回味无穷！"
						target="_blank" href="showGood.jsp?op='findGood'&gid=1005"> <strong>【南方大厦】方燕烤鸡腿</strong> 烤猪脚1份！
					</a>
				</h2>
				<div class="index-smalllogo">
					<a class="yuy" target="_blank" href="#">免预约</a>
				</div> <a class="picture" target="_blank" href=""> <img
					class="lazyload" width="348" height="232" rel="nofollow"
					original="images/show3.jpg" src="images/~6X}3MMM`XM5ERSW2Z44$)O.jpg"
					visibility="hidden">
			</a>
				<div class="buy-boxInd clearfix">
					<a class="bh buy_a" rel="nofollow" href="#" target="_blank"
						status="0">去看看</a> <span class="num">¥8.5</span> <span
						class="past">价值 ¥10</span>
				</div>
			</li>
			<li class="good-list">
				<h2 class="good-title">
					<a class="biaoa" title="【石鼓区】仅6.9元，享价值9元『沐沐果茶』西米露4选1！提供免费wifi！"
						target="_blank" href=""> <strong>【石鼓区】沐沐果茶</strong>
						西米露4选1！提供免费wifi！
					</a>
				</h2>
				<div class="index-smalllogo">
					<a class="yuy" target="_blank" href="#">免预约</a>
				</div> <a class="picture" target="_blank" href="#"> <img
					class="lazyload" width="348" height="232" rel="nofollow"
					original="images/show4.jpg" src="images/show4.jpg"
					visibility="hidden">
			</a>
				<div class="buy-boxInd clearfix">
					<a class="bh buy_a" rel="nofollow" href="#" target="_blank"
						status="0">去看看</a> <span class="num">¥6.9</span> <span
						class="past">价值 ¥9</span>
				</div>
			</li> -->
		</ul>
		<div class="con-boxrig">
			<div class="pub-rigwrap">
				<a rel="nofollow" target="_blank" href="#"> <img
					class="baozhangimg" width="218" height="120"
					src="images/baozhang.png">
				</a>
			</div>
			<a href="#" gae="AD_ALL-SY-RT-00000003-0-82" target="_blank"> <img
				class="right_ggimg" width="218" height="120"
				src="images/ggs_index.gif">
			</a>
			<div class="pub-rigwrap">
				<a rel="nofollow" target="_blank" href="#"> <img
					class="baozhangimg" width="218" height="120" src="images/pic1.jpg">
				</a>
			</div>
			<div class="pub-rigwrap">
				<a rel="nofollow" target="_blank" href="#"> <img
					class="baozhangimg" width="218" height="120" src="images/pic2.jpg">
				</a>
			</div>
			<div class="pub-rigwrap">
				<a rel="nofollow" target="_blank" href="#"> <img
					class="baozhangimg" width="218" height="120" src="images/pic3.jpg">
				</a>
			</div>
		</div>
	</div>
	<dl id="FriendLink">
		<dt class="hd">
			<ul class="tit">
				<li class="titlist"><a class="aBtn" href="#">热门城市</a></li>
				<li class="titlist"><a class="aBtn" href="#">友情链接</a></li>
			</ul>
		</dt>
		<dd class="bd">
			<ul class="linkbox" style="display: block;">
				<li class="linkList"><a class="aLink" href="#" target="_blank">湘潭团购</a>
				</li>
				<li class="linkList"><a class="aLink" href="#" target="_blank">常德团购</a>
				</li>
				<li class="linkList"><a class="aLink" href="#" target="_blank">株洲团购</a>
				</li>
				<li class="linkList"><a class="aLink" href="#" target="_blank">衡阳团购</a>
				</li>
				<li class="linkList"><a class="aLink" href="#" target="_blank">长沙团购</a>
				</li>
			</ul>
			<ul class="linkbox" style="display: none;">
				<li class="linkList"><a class="aLink" href="#" target="_blank">衡阳招聘</a>
				</li>
				<li class="linkList"><a class="aLink" href="#" target="_blank">衡阳租房</a>
				</li>
				<li class="linkList"><a class="aLink" href="#" target="_blank">衡阳旅游线路</a>
				</li>
				<li class="linkList"><a class="aLink" href="#" target="_blank">衡阳团购</a>
				</li>
				<li class="linkList"><a class="aLink" href="#" target="_blank">衡阳天气</a>
				</li>
			</ul>
		</dd>
	</dl>
	<div id="footer">
		<div class="bottom-box clearfix">
			<div class="boul">
				<ul class="boul-list">
					<li class="li-x">
						<h2 class="">用户帮助</h2>
					</li>
					<li><a class="bolist-a" rel="nofollow" href="#">玩转窝窝</a></li>
					<li><a class="bolist-a" rel="nofollow" href="#">常见问题</a></li>
					<li><a class="bolist-a" rel="nofollow" href="#">秒杀规则</a></li>
					<li><a class="bolist-a" rel="nofollow" href="#">积分规则</a></li>
					<li><a class="bolist-a" rel="nofollow" href="#">代金券说明</a></li>
					<li><a class="bolist-a" rel="nofollow" href="#">评价说明</a></li>
				</ul>
				<b class="ico"></b>
			</div>
			<div class="boul">
				<ul class="boul-list">
					<li class="li-x">
						<h2 class="h2-1">获取更新</h2>
					</li>
					<li><a class="bolist-a" href="#" target="_blank">窝窝团新浪微博</a></li>
					<li><a class="bolist-a" href="#" target="_blank">窝窝团腾讯微博</a></li>
					<li><a class="bolist-a" rel="nofollow" href="#">手机版下载</a></li>
				</ul>
				<b class="ico ico2"></b>
			</div>
			<div class="boul">
				<ul class="boul-list">
					<li class="li-x">
						<h2 class="h2-2">商务合作</h2>
					</li>
					<li><a class="bolist-a" rel="nofollow" href="#">商家入驻</a></li>
					<li><a class="bolist-a" rel="nofollow" href="#">提供团购信息</a></li>
					<li><a class="bolist-a" rel="nofollow" href="#">友情链接</a></li>
					<li><a class="bolist-a" rel="nofollow" href="#">开放API </a></li>
				</ul>
				<b class="ico ico3"></b>
			</div>
			<div class="boul">
				<ul class="boul-list">
					<li class="li-x">
						<h2 class="h2-3">公司信息</h2>
					</li>
					<li><a class="bolist-a" rel="nofollow" href="#">关于我们</a></li>
					<li><a class="bolist-a" rel="nofollow" href="#">媒体报道</a></li>
					<li><a class="bolist-a" rel="nofollow" href="#">加入我们</a></li>
					<li><a class="bolist-a" rel="nofollow" href="#">隐私声明</a></li>
					<li><a class="bolist-a" rel="nofollow" href="#">用户协议</a></li>
					<li><a class="bolist-a" rel="nofollow" href="#">营业执照</a></li>
				</ul>
				<b class="ico ico4"></b>
			</div>
			<div class="kefu">
				<div class="kefu-bottom">
					<h2 class="kh2-0 bh">不满意就退款</h2>
					<h2 class="kh2-1">24小时客服热线</h2>
					<h2 class="kh2-2 bh">400-105-5555</h2>
					<a class="bh kfwwweibo" target="_blank" href="#">窝窝团客服微博</a>
				</div>
			</div>
		</div>
	</div>
	<div class="footer-btm">
		<div class="footer">
			&copy; 2010-2014 55tuan.com 京ICP证100702号 京公海网安备110108000829号&nbsp; <a
				target="_blank" href="#">营业执照</a>
		</div>
		<div class="footer">名称：北京窝窝团信息技术有限公司&nbsp;&nbsp;&nbsp;&nbsp;地址
			：北京市海淀区上地信息路18号三层3001&nbsp;&nbsp;&nbsp;&nbsp;电话 ：010-59065200</div>
		<div class="footer">营业执照注册号
			：110108011056221&nbsp;&nbsp;&nbsp;&nbsp;食品流通许可证：SP1101081110124921</div>
		<div class="wowofawu">
			<a class="fawu-1" rel="nofollow" href="#">支付宝</a> <a class="fawu-3"
				rel="nofollow" href="#" target="_blank">可信网站</a> <a class="fawu-5"
				rel="nofollow" href="#" target="_blank">经营性网站备案信息</a>
		</div>
	</div>
	<div id="ritfllow">
		<a class="gotopBtn" href="#"
			style="visibility: visible; height: 38px;">top</a>
		<div class="mobileBtn" style="visibility: hidden;">
			<div class="codeImg">
				<a gae="click_apr_erweima" target="_blank" href="#"> <img
					width="116" height="148" src="images/ritcodes0807.png">
				</a>
			</div>
		</div>
		<a class="fee_opin" target="_blank" href="#">意见反馈</a>
	</div>
	<div id="ritCode">
		<div class="imgbox">
			<a gae="click_apr_erweima" target="_blank" href="#"> <img
				width="108" height="183" src="images/ritcodeb.png">
			</a> <a class="cCode" href="#">close</a>
		</div>
	</div>
</body>
</html>
