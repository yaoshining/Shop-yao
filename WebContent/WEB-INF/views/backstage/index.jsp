<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getContextPath()+"/" %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城后台管理系统</title>
<link rel="stylesheet" href="resources/css/extjs/ext-all-neptune.css" media="screen" />
<style>
<!--
/** message style **/
.msg .x-box-mc {
    font-size:14px;
}
#msg-div {
    position:absolute;
    left:50%;
    top:10px;
    width:400px;
    margin-left:-200px;
    z-index:20000;
}
#msg-div .msg {
    border-radius: 8px;
    -moz-border-radius: 8px;
    background: rgba(244, 244, 244,0.9);
    background-clip: border-box;
    box-shadow: inset 1px 1px 3px rgba(0,0,0,0.2);
    border: 1px solid rgba(0,0,0,0.3);
    color: rgba(0,0,0);
    line-height: 1.5;
    margin-top: 2px;
    padding: 10px 15px;
    color: #555;
}
#msg-div .msg h3 {
    margin: 0 0 8px;
    font-weight: bold;
    font-size: 15px;
}
#msg-div .msg p {
    margin: 0;
}
/** icon styles **/
p {
    margin:5px;
}
.settings {
    background-image:url(resources/images/backstage/icons/folder_wrench.png);
}
.nav {
    background-image:url(resources/images/backstage/icons/folder_go.png);
}
.info {
    background-image:url(resources/images/backstage/icons/information.png);
}
.dept {
    background-image:url(resources/images/backstage/icons/user_suit.png);
}
/** loading style **/
#loading-mask{
	background-color:white;
	height:100%;
	position:absolute;
	left:0;
	top:0;
	width:100%;
	z-index:20000;
}
#loading{
    height:auto;
    position:absolute;
    left:43%;
    top:40%;
    padding:2px;
    z-index:20001;
}
#loading a {
    color:#225588;
}
#loading .loading-indicator{
    background:white;
    color:#444;
    font:bold 13px Helvetica, Arial, sans-serif;
    height:auto;
    margin:0;
    padding:10px;
}
#loading-msg {
    font-size: 10px;
    font-weight: normal;
}
-->
</style>
</head>
<body>
<div id="loading-mask" style=""></div>
<div id="loading">
    <div class="loading-indicator">
        <img src="resources/images/backstage/loading.gif" width="32" height="32" style="margin-right:8px;float:left;vertical-align:top;"/>商城后台管理系统 - <a href="http://www.shopyao.com">shopyao.com</a>
        <br /><span id="loading-msg">正在载入样式和图片...</span>
    </div>
</div>
<!-- use class="x-hide-display" to prevent a brief flicker of the content -->
    <div id="west" class="x-hide-display">
        <p>商品管理树</p>
    </div>
    <div id="center1" class="x-hide-display">
        <p><b>Done reading me? Close me by clicking the X in the top right corner.</b></p>
        <p>Vestibulum semper. Nullam non odio. Aliquam quam. Mauris eu lectus non nunc auctor ullamcorper. Sed tincidunt molestie enim. Phasellus lobortis justo sit amet quam. Duis nulla erat, varius a, cursus in, tempor sollicitudin, mauris. Aliquam mi velit, consectetuer mattis, consequat tristique, pulvinar ac, nisl. Aliquam mattis vehicula elit. Proin quis leo sed tellus scelerisque molestie. Quisque luctus. Integer mattis. Donec id augue sed leo aliquam egestas. Quisque in sem. Donec dictum enim in dolor. Praesent non erat. Nulla ultrices vestibulum quam.</p>
        <p>Duis hendrerit, est vel lobortis sagittis, tortor erat scelerisque tortor, sed pellentesque sem enim id metus. Maecenas at pede. Nulla velit libero, dictum at, mattis quis, sagittis vel, ante. Phasellus faucibus rutrum dui. Cras mauris elit, bibendum at, feugiat non, porta id, neque. Nulla et felis nec odio mollis vehicula. Donec elementum tincidunt mauris. Duis vel dui. Fusce iaculis enim ac nulla. In risus.</p>
        <p>Donec gravida. Donec et enim. Morbi sollicitudin, lacus a facilisis pulvinar, odio turpis dapibus elit, in tincidunt turpis felis nec libero. Nam vestibulum tempus ipsum. In hac habitasse platea dictumst. Nulla facilisi. Donec semper ligula. Donec commodo tortor in quam. Etiam massa. Ut tempus ligula eget tellus. Curabitur id velit ut velit varius commodo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla facilisi. Fusce ornare pellentesque libero. Nunc rhoncus. Suspendisse potenti. Ut consequat, leo eu accumsan vehicula, justo sem lobortis elit, ac sollicitudin ipsum neque nec ante.</p>
        <p>Aliquam elementum mauris id sem. Vivamus varius, est ut nonummy consectetuer, nulla quam bibendum velit, ac gravida nisi felis sit amet urna. Aliquam nec risus. Maecenas lacinia purus ut velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Suspendisse sit amet dui vitae lacus fermentum sodales. Donec varius dapibus nisl. Praesent at velit id risus convallis bibendum. Aliquam felis nibh, rutrum nec, blandit non, mattis sit amet, magna. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam varius dignissim nibh. Quisque id orci ac ante hendrerit molestie. Aliquam malesuada enim non neque.</p>
    </div>
    <div id="props-panel" class="x-hide-display" style="width:200px;height:200px;overflow:hidden;">
    </div>
    <div id="south" class="x-hide-display">
        <p>south - generally for informational stuff, also could be for status bar</p>
    </div>
<script type="text/javascript">document.getElementById('loading-msg').innerHTML = '正在载入JS核心库...';</script>
<script type="text/javascript" src="resources/script/extjs/ext-debug.js"></script>
<script type="text/javascript">document.getElementById('loading-msg').innerHTML = '正在载入图形化界面组件...';</script>
<script type="text/javascript">document.getElementById('loading-msg').innerHTML = '初始化...';</script>
<script type="text/javascript" src="resources/script/app/backstage.js"></script>
<script type="text/javascript"> 
<!--

Ext.MyUtil = function(){
    var msgCt;

    function createBox(t, s){
       return '<div class="msg"><h3>' + t + '</h3><p>' + s + '</p></div>';
    }
    return {
        msg : function(title, format, delay){
            if(!msgCt){
                msgCt = Ext.DomHelper.insertFirst(document.body, {id:'msg-div'}, true);
            }
            var s = Ext.String.format.apply(String, Array.prototype.slice.call(arguments, 1));
            var m = Ext.DomHelper.append(msgCt, createBox(title, s), true);
            m.hide();
            m.slideIn('t').ghost("t", { delay: delay?delay:1000, remove: true});
        },

        init : function(){
            if(!msgCt){
                msgCt = Ext.DomHelper.insertFirst(document.body, {id:'msg-div'}, true);
            }
        }
    };
}();


Ext.onReady(function(){
	Ext.MyUtil.init();
	Ext.MyUtil.msg("您好","商城后台管理系统已经初始化完成！", 3000);
}, Ext.MyUtil);
//-->
</script>
</body>
</html>