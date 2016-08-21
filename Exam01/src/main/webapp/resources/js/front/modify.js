function modify( customer_id){
	var basePath = $("#basePath").val();
	$.ajax( {  
		type : "GET",  
		url : basePath+"customer/getCustomer",
		data : {
			'customer_id' :customer_id
		}, 
		dataType: "json",  
		success : function(data) {  
			if(data.success){  
				$(data.data).each(function() {
					$("#first_name").val(this.first_name);
					$("#last_name").val(this.last_name);
					$("#email").val(this.email);
					$("#address").val(this.address);
					$("#customer_id").val(this.customer_id);
				});
			}  
			else{  
				alert("获取失败！");  
			}  
		},  
		error :function(){  
			alert("网络连接出错！");  
		}  
	});  
}

$(document).ready(  
		function() {  
			var basePath = $("#basePath").val();
			$("#modifybtn").click(function() { 
				$.ajax( {  
					type : "POST",  
					url : basePath+"customer/modifyCustomer",
					data : {
						'customer_id' :$("#customer_id").val(),
						'address_id' : $("#address").find('option:selected').text(),
						'first_name' :$("#first_name").val(),
						'last_name':$("#last_name").val(),
						'email':$("#email").val(),
					}, 
					dataType: "json",  
					success : function(data) {  
						if(data.success){  
							alert("修改成功！");
						}  
						else{  
							alert("获取失败！");  
						}  
					},  
					error :function(){  
						alert("网络连接出错！");  
					}  
				});  
			});
		});

/*
$(document).ready(  
		function init() {  
			$.ajax({
				url:"<%=basePath%>/customer/allCustomers",
				data:{},
				type:"GET",
				dataType:"json",
				timeout:5000,
				success:function(json){
					var select_option;
					$.each(json.selected_option_value,function(i, item){
						select_option = item;
					});
					var options_str = "";
					$("#condition1").html("");
					$.each(json.options,function(i, item){
						options_str += "<option value=\"" + item.value + "\" >" + item.label + "</option>";
					});
					$("#condition1").append(options_str);
				},
				error:function(xhr, status){
					alert("error");
				}
			});
		});*/






