<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--[if gte IE 9]>
  <script src="${webRoot}/resources/js/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="${webRoot}/resources/js/html5shiv.min.js" type="text/javascript"></script>
  <script src="${webRoot}/resources/js/respond.min.js" type="text/javascript"></script>
  <script src="${webRoot}/resources/js/selectivizr-min.js" type="text/javascript"></script>
<![endif]-->
<!--[if lt IE 9]>
  <script>window.location.href='${webRoot}/upgrade-browser.html';</script>
<![endif]-->
<script src="${webRoot}/resources/js/jquery-2.1.4.min.js"></script>
<script src="${webRoot}/resources/js/bootstrap.min.js"></script>
<script src="${webRoot}/resources/js/bootstrap-treeview.js"></script>
<script src="https://cdn.bootcss.com/toastr.js/latest/js/toastr.min.js"></script>
<script src="https://cdn.bootcss.com/layer/3.1.0/mobile/layer.js"></script>
<script src="${webRoot}/resources/js/validate.js"></script>
<script src="${webRoot}/resources/js/alertMsg.js"></script>
<script src="${webRoot}/resources/js/admin-scripts.js"></script>
<script type="text/javascript">
	$(function(){
		var url = window.location.href;
		console.dir(url);
		if(url.indexOf("article") > 0){
			$("#article_act").addClass("active");
		}
		if(url.indexOf("index") > 0){
			$("#report_act").addClass("active");
		}
		if(url.indexOf("category") > 0){
			$("#category_act").addClass("active");
		}
	})
</script>