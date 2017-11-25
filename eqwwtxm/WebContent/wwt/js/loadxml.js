var xmlhttp;
function loadXMLDoc(url)
{
    xmlhttp=null;
    if (window.XMLHttpRequest)
    {// code for all new browsers
        xmlhttp=new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {// code for IE5 and IE6
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (xmlhttp!=null)
    {
        //open方法，指的是 打开与文件的交互通道
        //1：get请求方式 2：文件地址 3：是否同步或异步，true为异步，false为同步
        xmlhttp.open("GET",url,true);
        //send方法 正式开始与文件交互，读取里面的数据
        //send方法里面可以传递参数，如果没有参数可以写null
        xmlhttp.send(null);  //-->读取文件里的数据
        xmlhttp.onreadystatechange=state_Change;
    }
    else
    {
        alert("Your browser does not support XMLHTTP.");
    }
}

loadXMLDoc("js/data.xml");

function state_Change() {
    if(xmlhttp.readyState == 4){
        var xmldom = xmlhttp.responseXML;
        province = xmldom.getElementsByTagName("Province");  
        showProvince(province);
    }
}

function showProvince(arr) {
	for (var i=0;i<arr.length;i++){
        if(arr[i].nodeType == 1){
            var selectpro = document.getElementById("province");
            var option = document.createElement("option");
            var pro = arr[i].getAttribute("Name");
            option.value = pro;
            option.text = pro;
            selectpro.appendChild(option);    
        }
    }
}

function selectPC() {
    for (var i=0;i<province.length;i++){
        if(province[i].nodeType == 1){
            var pro = document.getElementById("province").value;
            if(province[i].getAttribute("Name") == pro){  
            	
                document.getElementById("city").innerHTML = '';
                document.getElementById("district").innerHTML = '';
                
                var selectdistrict = document.getElementById("district");
                var option = document.createElement("option");			
				option.value = '--请选择地区--';
				option.text = '--请选择地区--';
				selectdistrict.appendChild(option);
				
                var selectcity = document.getElementById("city");               
                for(var j=0;j<province[i].childNodes.length;j++){
                    if(province[i].childNodes[j].nodeType == 1){ 
                        var option = document.createElement("option");
                        var city = province[i].childNodes[j].getAttribute("Name");
                        option.value = city;
                        option.text = city;
                        selectcity.appendChild(option); 
                    }
                } 
                flag=i;
                break;
            }
        }
    }
}

function selectCity() {
	var cit = document.getElementById("city").value;
	for (var j = 0; j < province[flag].childNodes.length; j++) {
		if (province[flag].childNodes[j].nodeType == 1) {
			if (province[flag].childNodes[j].getAttribute("Name") == cit) {
				var selectdistrict = document.getElementById("district");
				document.getElementById("district").innerHTML = '';
				for (var k = 0; k < province[flag].childNodes[j].childNodes.length; k++) {
					if (province[flag].childNodes[j].childNodes[k].nodeType == 1) {
						var option = document.createElement("option");
						var district = province[flag].childNodes[j].childNodes[k]
								.getAttribute("Name");
						option.value = district;
						option.text = district;
						selectdistrict.appendChild(option);
					}
				}
				break;
			}
		}
	}
}                  