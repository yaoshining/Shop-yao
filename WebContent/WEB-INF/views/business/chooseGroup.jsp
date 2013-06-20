<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath() %>/resources/css/jquery/component/zTreeStyle.css" rel="stylesheet" media="screen" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery/component/zTree/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery/component/zTree/jquery.ztree.excheck-3.5.min.js"></script>
<title>选择用户</title>
<script type="text/javascript">
<!--
var selectedGroupIds = new Array();
var deptTreeSetting = {
		view: {
			dblClickExpand: function(treeId, treeNode){
				return treeNode.level > 0;
			}
		},
		async: {
			enable: true,
			url:'<s:url value="/biz/depts"></s:url>',
			autoParam:["id", "name=n", "level=lv"],
			otherParam:{"otherParam":"zTreeAsyncTest"},
			type: "get",
			dataType: "text",
			dataFilter: filter
		},
		callback: {
			onClick: function(event, treeId, treeNode, clickFlag){
				if(!treeNode.isParent){
					var url = '<s:url value="/biz/groups"></s:url>/'+treeNode.id;
					$.ajax({
						url : url,
						type : "get",
						dataType : "json",
						beforeSend : function(){
							var deptNode = {
									id : treeNode.id,
									name : treeNode.name,
									isParent : true,
									nocheck : true
							};
							var $source = $("#deptTree a.level"+treeNode.level+"[title="+treeNode.name+"]");
							var $helper = $("<li>").text("TransferHelper").css({visibility:  "hidden",height: $source.height(),width: $source.width()-10,"list-style": "none"});
							$("#groupTree").empty().append($helper);
							$source.effect("transfer", {
								to:$helper,
								className:"ui-effects-transfer",
								html: $source.html()
							}, 800, function(){
								$helper.remove();
								$.fn.zTree.init($("#groupTree"), groupTreeSetting,deptNode);
							} );
						},
						success : function(data) {
							setTimeout(function(){
								var groupTree = $.fn.zTree.getZTreeObj("groupTree");
								var node = groupTree.getNodeByParam("id",treeNode.id,null);
								groupTree.addNodes(node,data,true);
								groupTree.expandNode(node, true, false, false);
							},1500);
						}
					});
				}
			},
			onAsyncSuccess: function(event, treeId, treeNode, msg){
				if(!treeNode){
					var tree = $.fn.zTree.getZTreeObj(treeId);
					setTimeout(function(){
//						tree.getNodes()[0].iconSkin = "asdasd";
//						tree.updateNode(tree.getNodes()[0],false);
						tree.expandNode(tree.getNodes()[0], true, false, true, true);
					},1000);
				}
			}
		}
	};
var groupTreeSetting = {
		data: {
			simpleData: {
				enable: true
			}
		},	
		callback: {
			onClick : function(event,treeId,treeNode,clickkFlag) {
				var tree = $.fn.zTree.getZTreeObj(treeId);
				if(treeNode.checked){
					tree.checkNode(treeNode,false,false,true);
				}else{
					tree.checkNode(treeNode,true,false,true);
				}
			},
			onCheck : function(event,treeId,treeNode){
				if(treeNode.checked){
					selectedGroupIds.push(treeNode.id);
				}else{
					selectedGroupIds.pop(treeNode.id);
				}
			}
		},
		check: {
			enable : true,
			chkStyle : "checkbox"
		}
	};
 	
	function filter(treeId, parentNode, childNodes) {
		if (!childNodes) return null;
		return childNodes;
	}
	var curExpandNode = null;
	function beforeExpand(treeId, treeNode) {
		var pNode = curExpandNode ? curExpandNode.getParentNode():null;
		var treeNodeP = treeNode.parentTId ? treeNode.getParentNode():null;
		var zTree = $.fn.zTree.getZTreeObj("deptTree");
		for(var i=0, l=!treeNodeP ? 0:treeNodeP.children.length; i<l; i++ ) {
			if (treeNode !== treeNodeP.children[i]) {
				zTree.expandNode(treeNodeP.children[i], false);
			}
		}
		while (pNode) {
			if (pNode === treeNode) {
				break;
			}
			pNode = pNode.getParentNode();
		}
		if (!pNode) {
			singlePath(treeNode);
		}

	}
	function singlePath(newNode) {
		if (newNode === curExpandNode) return;
		if (curExpandNode && curExpandNode.open==true) {
			var zTree = $.fn.zTree.getZTreeObj("deptTree");
			if (newNode.parentTId === curExpandNode.parentTId) {
				zTree.expandNode(curExpandNode, false);
			} else {
				var newParents = [];
				while (newNode) {
					newNode = newNode.getParentNode();
					if (newNode === curExpandNode) {
						newParents = null;
						break;
					} else if (newNode) {
						newParents.push(newNode);
					}
				}
				if (newParents!=null) {
					var oldNode = curExpandNode;
					var oldParents = [];
					while (oldNode) {
						oldNode = oldNode.getParentNode();
						if (oldNode) {
							oldParents.push(oldNode);
						}
					}
					if (newParents.length>0) {
						zTree.expandNode(oldParents[Math.abs(oldParents.length-newParents.length)-1], false);
					} else {
						zTree.expandNode(oldParents[oldParents.length-1], false);
					}
				}
			}
		}
		curExpandNode = newNode;
	}
$(function(){
	$("body").outerHeight($(document).height());
	$("#main .content").height($("body").innerHeight()-$("#footer").height());
	$("#main .ym-cbox").outerHeight($("#main .content").innerHeight());
	$.fn.zTree.init($("#deptTree"), deptTreeSetting);
	$("#cancelBtn").on("click",function(){
		parent.$.lightbox().close();
	});
	$("#confirmBtn").on("click",function(ev){
		if(validate()){
			parent.$.lightbox().close();
		} else{
			parent.$.lightbox().shake();
			showMessage("请至少选择一个角色");
			ev.preventDefault();
		}
		return false;
	});
});
function showMessage(message) {
	setTimeout(function(){
		$(".message p.error").text(message).show("bounce",{},1000,function(){
			setTimeout(function(){
				$(".message p.error").hide("blind",1000,function(){
					$(this).empty();
				});
			},2000);
		});
	},1000);
}
function validate(){
	var groupTree = $.fn.zTree.getZTreeObj("groupTree");
	return groupTree&&groupTree.getCheckedNodes(true).length>0;
}
//-->
</script>
<style type="text/css">
.ztree li span.button.switch.level0 {visibility:hidden; width:1px;}
.ztree li ul.level0 {padding:0; background:none;}
.ui-effects-transfer {
	border: 2px dotted gray;
	background-color: #FFF;
}
.left{
	float: left;
	width: 49%;
	height: 100%;
	overflow: auto;
}
.right{
	float: right;
	width: 49%;
	height: 100%;
	overflow: auto;
}
.bottom{
	text-align: center;
}
.chooser{
	/*border: 1px solid #000;*/
	height: 100%;
}
#deptChooser{
}
#userChooser{
}
#main .box {
	margin: 0px;
	overflow: hidden;
}
.message {
	position: absolute;
	width: 300px;
	height: 20px;
	top: 0px;
	left: 50%;
	margin-left: -150px;
	text-align: center;
}
</style>
</head>
<body>
  <div id="main">
    <div class="ym-wrapper">
      <div class="ym-wbox content">
      	<div class="ym-column">
		  <div class="ym-col1" style="width: 49%;">
		    <div class="ym-cbox box info">
				<div id="deptChooser" class="chooser">
					<ul id="deptTree" class="ztree"></ul>
				</div>
		    </div>
		  </div>
		  <div class="ym-col2" style="width: 49%;">
		    <div class="ym-cbox box info">
				<div id="userChooser" class="chooser">
					<ul id="groupTree" class="ztree">
					</ul>
				</div>
		    </div>
		  </div>
		</div>
      </div>
    </div>
  </div>
  <div id="footer">
    <div class="ym-wrapper">
      <div class="ym-wbox bottom">
		<button id="confirmBtn" class="ym-button ym-save">确定</button>
		<button id="cancelBtn" class="ym-button ym-delete">取消</button>
      </div>
    </div>
  </div>
  <div class="message">
  	<p class="box error" style="margin: 0px;display: none;"></p>
  </div>
</body>
</html>