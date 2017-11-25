<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>物品详情|窝窝团</title>
<link rel="stylesheet" href="css/basic.css" />
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>

<script type="text/javascript">

var op = <%= request.getParameter("op")%>
	var gid = <%= request.getParameter("gid")%>
	var good;
	$(function(){
		$.post("../goodsServlet",{op:op,gid:gid},function(data){
			good=data;
			//alert("good:"+good);
			
			if(data!=""){
				//alert( good.gname);
				$("#store_name").text(good.gname);
				$("#good_mark").text(good.mark);
				$("#good_aprice").text(good.aprice);
				$("#good_price").text(good.price);
				$("#good_zhe").text(parseInt((good.aprice/good.price)*10));
				$("#good_sheng").text(good.price-good.aprice);
				$("#show_img").attr("src","../../"+good.pic);
				
			}
		},"json");
		
	});
</script>
</head>

<body id="center">

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
      <span class="cityLink"> 【<a class="Gray5a" href="http://www.55tuan.com/city_list.html 

" gae="city_list">切换城市</a>】 </span> <span id="show_city" class="cityTs"> <b class="triangbor">三角</b> <a id="ipClose" class="closeTs" href="javascript:;">关闭</a> 您是不是在 <em id="ipcityname" class="bluec4">衡阳</em> ？点击可选择其他城市 </span> </li>
    <li class="searchLi ">
      <div class="searchlf"> <span class="tri"></span>
        <div class="hd"> <a class="on deal" href="javascript:;">团购</a> <a class="shoper" href="javascript:;">商家</a> </div>
      </div>
      <form id="soso_form" method="get" action="">
        <input class="searchTxt" type="text" autocomplete="off" maxlength="140" name="w" value="请输入商品名、地址">
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
    <li class="first_nav" date-nav="index"> <a gae="click_channel1_Nav" href="http://hengyang.55tuan.com 

">团购精选</a> </li>
    <li date-nav="shangcheng"> <a gae="click_channel10_Nav" href="http://hengyang.55.com 

">窝窝商城</a> </li>
    <li class="zIndex2" date-nav="shenbian"> <a gae="click_channel12_Nav" href="http://hengyang.55tuan.com/shenbian/list 

">身边</a> </li>
    <li date-nav="meishi"> <a gae="click_channel2_Nav" href="http://hengyang.55tuan.com/meishi 

">美食</a> </li>
    <li date-nav="yule"> <a gae="click_channel3_Nav" href="http://hengyang.55tuan.com/yule 

">娱乐</a> </li>
    <li class="zIndex" date-nav="dianying"> <a gae="click_channel4_Nav" href="http://hengyang.55tuan.com/dianying/dingzuo 

">电影</a> </li>
    <li date-nav="meirongbaojian"> <a gae="click_channel5_Nav" href="http://hengyang.55tuan.com/meirongbaojian 

">美容保健</a> </li>
    <li date-nav="shenghuofuwu"> <a gae="click_channel6_Nav" href="http://hengyang.55tuan.com/shenghuofuwu 

">生活服务</a> </li>
    <li date-nav="jiehun"> <a gae="click_channel13_Nav" href="http://jiehun.55tuan.com 

">结婚</a> </li>
    <li date-nav="lvyou"> <a gae="click_channel7_Nav" href="http://lvyou.55tuan.com 

">旅行</a> </li>
    <li date-nav="jiudian"> <a gae="click_channel8_Nav" href="http://jiudian.55tuan.com 

">酒店</a> </li>
    <li date-nav="shangpin"> <a gae="click_channel9_Nav" href="http://shangpin.55tuan.com 

">网购</a> </li>
    <li date-nav="shop"> <a gae="click_channel11_Nav" href="http://shop.55tuan.com 

">品牌汇</a> </li>
  </ul>
</div>
<div class="con_box clearfix">
  <div class="con_left clearfix">
    <div class="details-ui clearfix" id="good_title">
      <h2 class="details-h2" id="store_name">【天安门】</h2>
      <p class="details-p" id="good_mark">仅8元，享价值10元2017/7/7至2017/7/10单人自助午餐1份！提供免费WIFI，提供免费停车位！提供免费专车接送，尽享环球美食！</p>
      <ul class="details-lft">
        <li class="details-rigbg"></li>
        <li class="details-buy" > <strong class="wowoprice" id="good_aprice">¥98</strong> <a class="xqbuy-a" data="buySubmit" rel="nofollow" href="#">抢购</a> </li>
        <li class="shopprice"> <span>价值</span> <span>折扣</span> <span>节省</span> <span class="ari" id="good_price">¥196</span> <span class="ari" id="good_zhe">5折</span> <span class="ari" id="good_sheng">¥98</span> </li>
        <li class="shopmsg" style="padding-bottom: 2px; padding-top: 7px;" data="groupok"> <span> <strong class="ari" data="salenum">1377</strong> 人已购买 </span> <span>已成团，可继续购买</span> </li>
        <li class="add_code" ajaxurl="">
          <div class="code_bg clearfix"> <img class="img_o" src="images/takeOrder.jpg">
            <div class="code_font clearfix">
              <p>手机窝窝</p>
              <p>扫码下单</p>
            </div>
          </div>
        </li>
        <li class="shopensure"> <a class="zhichi" title="支持未消费退款" target="_blank" href="#">支持退款</a> <a class="baiwan" title="百万消费保证金" target="_blank" href="#" style="margin-right: -1px;">百万消费保证金</a> </li>
      </ul>
      <div class="details-rit">
        <ul class="xqtag clearfix">
          <li class="myy">免预约</li>
        </ul>
        <div id="imgBox">
          <ul>
            <!-- <li> <img width="456" height="304" border="0" src="images/details1.jpg"> </li> -->
            <li> <img width="456" height="304" border="0" src="images/~6X}3MMM`XM5ERSW2Z44$)O.jpg" id="show_img"> </li>
          </ul>
        </div>
      </div>
    </div>
<div id="details-left" class="details-msg details-abeam clearfix" style="padding: 0px;">
      <div class="details-msglft">
        <div id="goodsAll_info_div" class="details-msgtxt">
          <div class="pubnav-box">
            <h2 class="xqtext_title">本单详情</h2>
            <div class="xqtext_clue">
              <h2 class="xqtext_title">温馨提示</h2>
              <dl class="clue_con clearfix">
                <dt>有效日期：</dt>
                <dd class="orange">2014年07月08日-09月20日</dd>
                <dt>限购数量：</dt>
                <dd>本商品不限购买</dd>
                <dt>使用规则：</dt>
                <dd>每张窝窝券限一位男士和一位女士/二位女士使用</dd>
                <dt>预约提醒：</dt>
                <dd class="phonemore">该商品无需预约</dd>
                <dt>其他提示：</dt>
                <dd class="clue_other">
                  <ul>
                    <li>在公共场所娱乐消费时，请您妥善保管好自己随身携带的财物，以防丢失；注意人身安全，避免发生危险。<>
                    <li>提供免费wifi<>
                    <li>提供免费停车位<>
                    <li>1m以下儿童免费，1－1.3m儿童半价,1.3m以上儿童按成人标准收费(含1.3m)，建议购买一张窝窝劵<>
                    <li>一位购票成人限带一位免费儿童，超出部分均需购儿童票； 无需预约<>
                    <li>有免费专车接送<>
                    <li>团购用户不可同时享受商家其他优惠，窝窝券不兑换、不找零<>
                  </ul>
                </dd>
              <>
            </div>
            <div class="xqtext-table">
              <h2 class="xqtext_title">套餐内容</h2>
              <table id="detailtab" cellspacing="0" cellpadding="0" style="display:block;">
                <thead>
                  <tr>
                    <th class="first" width="282" valign="middle">内容</th>
                    <th width="126" valign="middle">单价</th>
                    <th width="140" valign="middle">数量/规格</th>
                    <th class="last" width="118" valign="middle">总计</th>
                  </tr>
                </thead>
<tbody>
                  <tr>
                    <td class="title" valign="middle" align="center" colspan="4">2选1</td>
                  </tr>
                  <tr>
                    <td class="first" valign="middle" align="left">周一至周五双人自助午餐：限1位男士和1位女士</td>
                    <td valign="middle" align="center">196元</td>
                    <td valign="middle" align="center">1份</td>
                    <td class="last" valign="middle" align="center">196元</td>
                  </tr>
                  <tr>
                    <td class="first" valign="middle" align="left">周一至周五双人自助午餐：2位女士</td>
                    <td valign="middle" align="center">196元</td>
                    <td valign="middle" align="center">1份</td>
                    <td class="last" valign="middle" align="center">196元</td>
                  </tr>
                  <tr>
                    <td class="bottom" valign="middle" colspan="4"><span>价值：196元</span> <span>窝窝价：<strong>98<>元</span></td>
                  </tr>
                  <tr>
                    <td class="texcon" valign="middle" colspan="4"><p>限量供应：餐厅分欧陆情、亚洲风、日本料理、韩泰美食、海鲜超市、滋补靓汤、巴西烧烤、西式甜品等40多个美食档口，荟萃1200种环球美食，以完全自主的方式任君品尝，部分菜品随机调整，请以当天为准</p></td>
                  </tr>
                </tbody>
              </table>
              <h2 class="xqtext_title">商品介绍</h2>
              <div class="xqtext_more xqtext_sj">
                <h3>海鲜类</h3>
                <img class="lazyload" height="460" src="images/images1.jpg" visibility="hidden">
                <div class="context"></div>
                <h3>熟食类</h3>
                <img class="lazyload" height="460" src="images/images4.jpg" visibility="hidden">
                <div class="context"></div>
                <p class="gs-info">以上图片仅供参考，请以商家实际提供为准</p>
              </div>
            </div>
          </div>
        </div>
        <div class="btmbuy" style="padding: 35px;"> <span class="py">¥98</span>
          <ul class="cr">
            <li> 价值<br>
              <del class="num">¥196</del> <>
            <li> 折扣<br>
              <span class="num">5折</span> <>
            <li> 节省<br>
              <span class="num">¥98</span> <>
          </ul>
          <a class="butbtn" data="buySubmit" rel="nofollow" href="shopcart.jsp">确认购买</a>
          <div class="code_bg clearfix"> <img class="img_o" src="images/takeOrder.jpg">
            <div class="code_font clearfix">
              <p>手机窝窝</p>
              <p>扫码下单</p>
            </div>
            <div class="code_guide" style="display:none;">
              <p>手机扫码购买指导</p>
              <img class="img_i" alt="扫描指导" src="images/code2_m_guide.jpg"> </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div id="con_right" class="con_right">
    <div class="pub-rigwrap">
      <h2 class="pub-rigtitle">专卖店信息</h2>
      <div class="xq-shoplist">
        <div class="hd" style="border: 0px none;"> <a target="_blank" href="#" alt="熊猫餐谋海鲜自助"> <img width="128" height="96" src="images/pic4.png"> </a> <span class="tit">熊猫餐谋海鲜自助</span> <span class="zk"> <span> 折扣：<em>5.0</em>折起 </span> </span> </div>
      </div>
    </div>
    <div class="con-boxrig">
      <div class="pub-rigwrap"> <a rel="nofollow" target="_blank" href="#"> <img class="baozhangimg" width="218" height="120" src="images/baozhang.png"> </a> </div>
      <a href="#" gae="AD_ALL-SY-RT-00000003-0-82" target="_blank"> <img class="right_ggimg" width="218" height="120" src="images/ggs_index.gif"> </a>
      <div class="pub-rigwrap"> <a rel="nofollow" target="_blank" href="#"> <img class="baozhangimg" width="218" height="120" src="images/pic1.jpg"> </a> </div>
      <div class="pub-rigwrap"> <a rel="nofollow" target="_blank" href="#"> <img class="baozhangimg" width="218" height="120" src="images/pic2.jpg"> </a> </div>
      <div class="pub-rigwrap"> <a rel="nofollow" target="_blank" href="#"> <img class="baozhangimg" width="218" height="120" src="images/pic3.jpg"> </a> </div>
    </div>
  </div>
</div>

<%@include file="page/foot.jsp" %>
</body>
<ml>
    