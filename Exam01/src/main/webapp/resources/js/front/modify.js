function modify( customer_id){
	alert(customer_id+"nice");
	
	$.ajax( {  
	    type : "GET",  
	    url : "getCustomer",
	    data : {
	    'customer_id' :customer_id
	     }, 
	    dataType: "json",  
	    success : function(data) {  
	        if(data.success){  
	            $(data.data).each(function() {

	            	$("#first_name").val(this.first_name);
	               });
	        	
	        	
	        	
	        	$("#last_name").val("LastName");
	        	$("#email").val("Email");
	        	$("#address").val("address");
	            alert("设置成功！");  
	            
	        }  
	        else{  
	            alert("设置失败！");  
	        }  
	    },  
	    error :function(){  
	        alert("网络连接出错！");  
	    }  
	});  
	
	
	
}

