<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- head -->
<%@ include file="../commons/_head.jsp"%>
<body class="user-select">
<section class="container-fluid">
<!-- nav -->
<%@ include file="../commons/_nav.jsp" %>
  <div class="row">
<!-- aside -->
<%@ include file="../commons/_aside.jsp" %>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
      <div class="row">
        <div class="col-md-5">
          <h1 class="page-header">添加</h1>
          <form id="categoryform" method="post" autocomplete="off">
          <input type="hidden" name="pid" id="pid"/>
          
            <div class="form-group">
              <label for="category-name">栏目名称</label>
              <input type="text" id="category-name" name="name" class="form-control" placeholder="在此处输入栏目名称" required autocomplete="off">
              <span class="prompt-text">这将是它在站点上显示的名字。</span> </div>
            <div class="form-group">
              <label for="category-name">排序</label>
              <input type="number" id="category-sort" name="sort" class="form-control" placeholder="在此处输入序号" required autocomplete="off">
              <span class="prompt-text">序号越大越靠前。</span> </div>
            <div class="form-group">
              <label for="category-fname">父节点</label>
              <select id="category-pid_0" class="form-control" name="parentId_0" level="0">
                <option value="0" selected>无</option>
                <c:if test="${pTypes != null && fn:length(pTypes) gt 0}">
                	<c:forEach items="${pTypes}" var="ptype">
		                <option value="${ptype.id}">${ptype.name}</option>
                	</c:forEach>
                </c:if>
              </select>
              <span class="prompt-text">栏目是有层级关系的，您可以有一个“音乐”分类目录，在这个目录下可以有叫做“流行”和“古典”的子目录。</span> </div>
           	  <button class="btn btn-primary" type="button" id="categorysubmit" name="submit">添加新栏目</button>
          </form>
        </div>
        <div class="col-md-7">
          <h1 class="page-header">管理 <span class="badge">3</span></h1>
          <div class="table-responsive">
            <table class="table table-striped table-hover">
              <thead>
                <tr>
                  <th><span class="glyphicon glyphicon-paperclip"></span> <span class="visible-lg">ID</span></th>
                  <th><span class="glyphicon glyphicon-file"></span> <span class="visible-lg">名称</span></th>
                  <th><span class="glyphicon glyphicon-list-alt"></span> <span class="visible-lg">别名</span></th>
                  <th><span class="glyphicon glyphicon-pushpin"></span> <span class="visible-lg">总数</span></th>
                  <th><span class="glyphicon glyphicon-pencil"></span> <span class="visible-lg">操作</span></th>
                </tr>
              </thead>
              <tbody>
              <%-- <c:if test="${pTypes != null && fn:length(pTypes) gt 0}">
                	<c:forEach items="${pTypes}" var="ptype">
		                <tr>
		                  <td>${ptype.id}</td>
		                  <td>${ptype.name}</td>
		                  <td>web</td>
		                  <td>125</td>
		                  <td><a href="update-category.html">修改</a> <a rel="1">删除</a></td>
		                </tr>
                	</c:forEach>
                </c:if> --%>
                <div id="treeview6" class=""></div>
              </tbody>
            </table>
            <span class="prompt-text"><strong>注：</strong>删除一个栏目也会删除栏目下的文章和子栏目,请谨慎删除!</span> </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!--个人信息模态框-->
<div class="modal fade" id="seeUserInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <form action="" method="post">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" >个人信息</h4>
        </div>
        <div class="modal-body">
          <table class="table" style="margin-bottom:0px;">
            <thead>
              <tr> </tr>
            </thead>
            <tbody>
              <tr>
                <td wdith="20%">姓名:</td>
                <td width="80%"><input type="text" value="王雨" class="form-control" name="truename" maxlength="10" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">用户名:</td>
                <td width="80%"><input type="text" value="admin" class="form-control" name="username" maxlength="10" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">电话:</td>
                <td width="80%"><input type="text" value="18538078281" class="form-control" name="usertel" maxlength="13" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">旧密码:</td>
                <td width="80%"><input type="password" class="form-control" name="old_password" maxlength="18" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">新密码:</td>
                <td width="80%"><input type="password" class="form-control" name="password" maxlength="18" autocomplete="off" /></td>
              </tr>
              <tr>
                <td wdith="20%">确认密码:</td>
                <td width="80%"><input type="password" class="form-control" name="new_password" maxlength="18" autocomplete="off" /></td>
              </tr>
            </tbody>
            <tfoot>
              <tr></tr>
            </tfoot>
          </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-primary">提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
<!--个人登录记录模态框-->
<div class="modal fade" id="seeUserLoginlog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" >登录记录</h4>
      </div>
      <div class="modal-body">
        <table class="table" style="margin-bottom:0px;">
          <thead>
            <tr>
              <th>登录IP</th>
              <th>登录时间</th>
              <th>状态</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>::1:55570</td>
              <td>2016-01-08 15:50:28</td>
              <td>成功</td>
            </tr>
            <tr>
              <td>::1:64377</td>
              <td>2016-01-08 10:27:44</td>
              <td>成功</td>
            </tr>
            <tr>
              <td>::1:64027</td>
              <td>2016-01-08 10:19:25</td>
              <td>成功</td>
            </tr>
            <tr>
              <td>::1:57081</td>
              <td>2016-01-06 10:35:12</td>
              <td>成功</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">朕已阅</button>
      </div>
    </div>
  </div>
</div>
<!--微信二维码模态框-->
<div class="modal fade user-select" id="WeChat" tabindex="-1" role="dialog" aria-labelledby="WeChatModalLabel">
  <div class="modal-dialog" role="document" style="margin-top:120px;max-width:280px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="WeChatModalLabel" style="cursor:default;">微信扫一扫</h4>
      </div>
      <div class="modal-body" style="text-align:center"> <img src="images/weixin.jpg" alt="" style="cursor:pointer"/> </div>
    </div>
  </div>
</div>
<!--提示模态框-->
<div class="modal fade user-select" id="areDeveloping" tabindex="-1" role="dialog" aria-labelledby="areDevelopingModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="areDevelopingModalLabel" style="cursor:default;">该功能正在日以继夜的开发中…</h4>
      </div>
      <div class="modal-body"> <img src="images/baoman/baoman_01.gif" alt="深思熟虑" />
        <p style="padding:15px 15px 15px 100px; position:absolute; top:15px; cursor:default;">很抱歉，程序猿正在日以继夜的开发此功能，本程序将会在以后的版本中持续完善！</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">朕已阅</button>
      </div>
    </div>
  </div>
</div>
<!--右键菜单列表-->
<div id="rightClickMenu">
  <ul class="list-group rightClickMenuList">
    <li class="list-group-item disabled">欢迎访问异清轩博客</li>
    <li class="list-group-item"><span>IP：</span>172.16.10.129</li>
    <li class="list-group-item"><span>地址：</span>河南省郑州市</li>
    <li class="list-group-item"><span>系统：</span>Windows10 </li>
    <li class="list-group-item"><span>浏览器：</span>Chrome47</li>
  </ul>
</div>
<!-- footer -->
<%@ include file="../commons/_footer.jsp" %>
<script>
//是否确认删除
$(function(){   
	$("#main table tbody tr td a").click(function(){
		var name = $(this);
		var id = name.attr("rel"); //对应id  
		if (event.srcElement.outerText === "删除") 
		{
			if(window.confirm("此操作不可逆，是否确认？"))
			{
				$.ajax({
					type: "POST",
					url: "/Category/delete",
					data: "id=" + id,
					cache: false, //不缓存此页面   
					success: function (data) {
						window.location.reload();
					}
				});
			};
		};
	});  
	//新增新栏目
	$("#categorysubmit").click(function(){
		if(!isNotNull("category-name")){
			wAlert("栏目名称不能为空");
			return false;
		}else if(!isLength("category-name",2,10)){
			wAlert("栏目名称长度在2-10个字符");
			return false;
		}
		if(!isNotNull("category-sort")){
			wAlert("排序不能为空");
			return false;
		}
		//上级分类赋值
        var parentId = $('select[level]').last().val();
		if(parentId==""){
			wAlert("请选择栏目");
			return false;
		}
        $('#pid').val(parentId);
		$.ajax({
				dataType:"JSON",
				type:"POST",
				url:"${webRoot}/category/create",
				data:$("#categoryform").serialize(),
				success:function(data){
					if(data.code==0){//成功
						sAlert(data.msg);
						setTimeout(function(){window.location.reload();}, 500);
					}
					if(data.code==1){//失败
						wAlert(data.msg);
						setTimeout(function(){window.location.reload();}, 500);
					}
				}
			})
	});
	//################################################
	//下拉框事件
	//################################################
	$("select[name^='parentId_']").bind("change",function(){
		var level = $(this).attr("level");
		var id = $(this).attr("id");
		var parentId = $(this).val();
		
		$("select[name^='parentId_']").each(function(){
            var subLevel = $(this).attr("level");
            if (parseInt(subLevel) > parseInt(level)) {
                $(this).remove();
            }
        })
        
		$.ajax({
            type:"get",
            url: "${webRoot}/category/getByPid?id=" + parentId,
            dataType: "json",
            cache:false,
            success:function(data){
            	data = data.data;
                if (data && data.length > 0) {
                    var children = "<select id='parentId_" + parseInt(level +1) + "' name='parentId_"+parseInt(level +1)+"' level="+parseInt(level +1) +" class='form-control'>";
                    children += "<option value=''>请选择</option>";
                    $.each(data, function(i, n){
                        children += "<option value=" + n.id + ">" + n.name + "</option>";
                    })
                    children += "</select>"
                    $('#'+id).after('&nbsp;&nbsp;&nbsp;' +children);
                }
            }
        });
	});
	//----------------
	var defaultData2 = '${treemodels}';
	defaultData2 = JSON.parse(defaultData2);
	$('#treeview6').treeview({
	//  levels: 99,	
	//  color: "#428bca",
	  //expandIcon: "glyphicon glyphicon-stop",
	//  collapseIcon: "glyphicon glyphicon-unchecked",
	  nodeIcon: "glyphicon glyphicon-user",
	  //showTags: true,
	  data: defaultData2
	});
	
});
</script>
</body>
</html>
