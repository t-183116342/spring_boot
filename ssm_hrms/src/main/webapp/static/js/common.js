Date.prototype.format = function(fmt) { 
    var o = { 
       "M+" : this.getMonth()+1,                 //月份 
       "d+" : this.getDate(),                    //日 
       "h+" : this.getHours(),                   //小时 
       "m+" : this.getMinutes(),                 //分 
       "s+" : this.getSeconds(),                 //秒 
       "q+" : Math.floor((this.getMonth()+3)/3),  
       "S"  : this.getMilliseconds()             //毫秒 
   }; 
   if(/(y+)/.test(fmt)) {
           fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
   }
    for(var k in o) {
       if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
   return fmt; 
}

function getDefaultString(input) {
	if (input == null || input == "") {
		return "--";
	} else {
		return input;
	}
}

function getLimitString(input) {
	if (input == null || input == "") {
		return "--";
	} else {
		return input.substring(0,5)+"......";
	}
}

function getDefaultDateString(input) {
	if (input == null || input == "") {
		return "--";
	} else {
		return new Date(input).format("yyyy-MM-dd");
	}
}