<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- head -->
<%@ include file="../commons/_head.jsp" %>

<body class="user-select">
<div class="container">
  <div class="siteIcon"><img src="${webRoot}/resources/images/icon/icon.png" alt="" data-toggle="tooltip" data-placement="top" title="欢迎使用博客管理系统-快敲网络" draggable="false" /></div>
  <form autocomplete="off" class="form-signin" id="loginform">
    <h2 class="form-signin-heading">管理员登录</h2>
    <div class="form-group">
	    <label for="username">用户名</label>
	    <input type="text" id="username" name="username" class="form-control" placeholder="请输入用户名" autofocus autocomplete="off">
    </div>
    <div class="form-group">
	    <label for="password">密码</label>
	    <input type="password" id="password" name="password" class="form-control" placeholder="请输入密码" autocomplete="off">
	</div>    
    <div class="form-group">
	    <a href="javascript:;"><button class="btn btn-lg btn-primary btn-block" type="button" id="loginsubmit">登录</button></a>
    </div>
  </form>
  <div class="footer">
    <p><a href="javascript:;" data-toggle="tooltip" data-placement="left" title="暂未开通 此功能">我要注册 →</a></p>
  </div>
</div>

<!-- footer -->
<%@ include file="../commons/_footer.jsp" %>

<script type="text/javascript">

$(function(){
	/* 提示信息 */
	$('[data-toggle="tooltip"]').tooltip();
	window.oncontextmenu = function(){
		//return false;
	};
	$('.siteIcon img').click(function(){
		window.location.reload();
	});
	/*登陆按钮*/	
	$("#loginsubmit").click(function(){
		if(validate()){
			$.ajax({
				dataType:"JSON",
				type:"POST",
				url:"${webRoot}/member/dologin",
				data:$("#loginform").serialize(),
				success:function(data){
					if(data.code==0){
						sAlert(data.msg);
						setTimeout(function(){window.location.href = "${webRoot}/index";}, 2000);
					}
					if(data.code==1){
						wAlert(data.msg);
						setTimeout(function(){window.location.reload();}, 2000);
					}
				}
			})			
		}
	})
})
//~~~~~~~~~~~~~~~~~~~~~~~~~
function validate(){
	if(!isNotNull("username")){
		wAlert("用户名不能为空");
		return false;
	}else if(!isLength("username",5,12)){
		wAlert("用户名长度在5-12个字符");
		return false;
	}
	
	if(!isNotNull("password")){
		wAlert("密码不能为空");
		return false;
	}else if(!isLength("password",5,12)){
		wAlert("密码长度在5-12个字符");
		return false;
	}
	
	return true;
}
</script>
</body>
</html>
