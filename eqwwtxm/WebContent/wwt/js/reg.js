function emailFocus(){
	$("#maillist").css('display','block');	
}

//显示邮箱格式
var str=["@qq.com","@163.com","@126.com","@sina.com","@hotmail.com","@yahoo.com.cn","@sohu.com","@yahoo.cn","@gmail.com","@tom.com"];
function changeemail(){
	$("#emailul li").remove();
	var inputemail=$("#regemail").val();
	if(inputemail.indexOf("@")>=0){
		inputemail=inputemail.substr(0,inputemail.length-1);
	}
	for(var i=0;i<str.length;i++){		
		$("#emailul").append("<li>"+(inputemail+str[i])+"</li>");	
		$("#emailul li").css('cursor','pointer');	
	}	
	$("#emailul li").hover(function(){
	    $(this).css("background-color","#bebebe");
	}); 
	$("#emailul li").mouseout(function(){
	    $(this).css("background-color","#f0f0f0");
	});
	$("ul#emailul").on("click","li",function(){
		$("#regemail").val($(this).text());
		closeDiv();
		//$("#maillist").css('display','none');		
	})
}

//检验邮箱格式
function closeDiv(){	
	var myEmail = document.getElementById("regemail").value;
    var emailChange = document.getElementById("regemail_msg");
    var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/g;
    if (myEmail.match(reg)) {
        $.post("../cusInfoServlet", {
            op: "checkemail",
            myEmail: myEmail
        },
        function(data) {
            if (parseInt(data) > 0) {
            	emailChange.className = 'span4';
                emailChange.innerHTML = '邮箱已存在';
            } else {
            	emailChange.className = 'span5';
                emailChange.innerHTML = '邮箱格式验证成功';
            }
        });
    } else {
    	if(myEmail==null || myEmail==""){
    		emailChange.className = 'span3';
            emailChange.innerHTML = '请填写常用电子邮件';
    	}else{
    		emailChange.className = 'span4';
            emailChange.innerHTML = '请填写常用电子邮件';
    	}      
    } 
    setTimeout(function(){
		$("#maillist").css('display','none');
	},200)
}

//检验用户名
function getUname(){
	var userChange=document.getElementById("username_msg");
    var username=document.getElementById("username").value;
    //var reg=/^[\u4e00-\u9fe5 a-zA-Z](\w|\u4e00-\u9fe5){2,17}$/g;
    var reg = /^[A-Z,a-z,\u4e00-\u9fe5][\w,\u4e00-\u9fe5]{5,18}$/g;     //大，小写字母  汉字(开头)  数字 字母(中间)  最低6位，最高19位
    if (username.match(reg)) {
        $.post("../cusInfoServlet", {
            op: "checkusername",
            username: username
        },
        function(data) {
            if (parseInt(data) > 0) {
            	userChange.className = 'span4';
                userChange.innerHTML = "会员名已存在";
            } else {
            	userChange.className = 'span5';
                userChange.innerHTML = "会员名格式验证成功";
            }
        });
    }else {
    	if(username==null || username==""){
    		userChange.className = 'span3';
            userChange.innerHTML = "由3-18位数字.字母.下划线.汉字组成";
    	}else{   		
    		userChange.className = 'span4';
            userChange.innerHTML = "由3-18位数字.字母.下划线.汉字组成";
    	}   	              
    }   
}

//检验密码
function getPassword(){
	var pwd=document.getElementById("password").value;
    var pwdChange=document.getElementById("password_msg");
    var reg=/\w{6,16}/g;
    if(pwd == ''){
        pwdChange.className = 'span3';
        pwdChange.innerHTML = '由6-16位的数字.字母.下划线组成';
    }else if(reg.test(pwd) == true){
        pwdChange.className = 'span5';
        pwdChange.innerHTML = '密码验证成功';
    }else {
        pwdChange.className = 'span4';
        pwdChange.innerHTML = '由6-16位的数字.字母.下划线组成';
    }
    
    var len=pwd.length;
    if(len>=6 && len<9){
    	$("#mimaul li").css("background","#dcdcdc");
    	$("#mimaruo").css("background","orange");
    }else if(len>=9 && len<12){
    	$("#mimaul li").css("background","#dcdcdc");
    	$("#mimazhong").css("background","orange");
    }else if(len>=12 && len<=16){
    	$("#mimaul li").css("background","#dcdcdc");
    	$("#mimaqiang").css("background","orange");
    }else{
    	$("#mimaul li").css("background","#dcdcdc");
    }
}

//重复密码
function repassword() {
    var pwd=document.getElementById("password").value;
    var repwd=document.getElementById("reppassword").value;
    var repwdChange=document.getElementById("reppassword_msg");
    if(repwd == pwd && repwd !=""){
        repwdChange.className = 'span5';
        repwdChange.innerHTML = '验证密码成功';
    }else if(repwd == ""){
        repwdChange.className = 'span3';
        repwdChange.innerHTML = '两次输入的密码必须一致';
    }else{
        repwdChange.className = 'span4';
        repwdChange.innerHTML = '两次输入的密码必须一致';
    }
}

//检验手机号码
function getTel() {
    var telphone = document.getElementById("tel").value;
    var telChange = document.getElementById("tel_msg");
    var reg = /^1[34578]\d{9}$/g;
    if(reg.test(telphone) == true){
        telChange.className = 'span5';
        telChange.innerHTML = '联系方式验证成功';
    }else if(telphone == ""){
        telChange.className = 'span3';
        telChange.innerHTML = '请输入您的常用联系方式';
    }else{
        telChange.className = 'span4';
        telChange.innerHTML = '请输入您的常用联系方式';
    }
}

//勾选按钮时改变按钮颜色
function changezhucecolor(){
	var ifcheck=$("#argee").prop("checked");
	if(ifcheck){
		$("#button").css("background","#ff9d58");
	}else{
		$("#button").css("background","#eee");
	}
}

//点击注册按钮
function panduanisselect(){
	var ifcheck=$("#argee").prop("checked");
	if(ifcheck){
		huyuanzc();
	}else{
		alert("请勾选同意协议");
	}
}

function huyuanzc(){
	
}