<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
input, button {
	width: 100%;
	padding: 5px;
	font-family: 맑은 고딕;
}
b {
	font-size: 12pt;
}
</style>
<div align="center">
	<div style="width: 380px;" align="left">
		<h3>Join HUB</h3>
		<h4>The BestWay to Study Software</h4>
		<h3 style="margin-top: 50px;">CREATE YOUR ACCOUNT</h3>
		<c:if test="${!empty temp }">
			<b style="color:red">join failed..</b>	
		</c:if>
		<form action="/join" method="post" autocomplete="off">
			<p>
				<b>ID</b><br /> <input type="text" name="id" id="id" required /><br />
				<span id="chkId_rst"></span>
			</p>
			<p>
				<b>PASS</b><br /> <input type="password" name="pass" required />
			</p>
			<p>
				<b>EMAIL</b><br /> <input type="email" name="email" id="email" required /><br/>
				<span id="chkEmail_rst"></span>
			</p>
			<button id="sbt" type="submit">C R E A T E</button>
		</form>
	</div>
</div>
<script>
	document.getElementById("id").onblur = function(){
		if(this.value.length != 0){
			var xhr = new XMLHttpRequest();
			var id = this.value;
			xhr.open("post","/signup_check/id",true);
			xhr.send(id);
			xhr.onreadystatechange = function(){
				if(this.readyState == 4){
					if(this.responseText.trim()=="YYYY"){
						document.getElementById("chkId_rst").innerHTML = "<b style=\"color:blue\">사용 가능합니다</b>";
						document.getElementById("sbt").disabled = false;
					}else{
						document.getElementById("chkId_rst").innerHTML = "<b style=\"color:red\">사용 불가능합니다</b>";
						document.getElementById("sbt").disabled = true;
					}
				}
			}
		}
	}
	document.getElementById("email").onblur = function(){
		if(this.value.length != 0){
			var xhr = new XMLHttpRequest();
			var email = this.value;
			xhr.open("post","/signup_check/email",true);
			xhr.send(email);
			xhr.onreadystatechange = function(){
				if(this.readyState == 4){
					if(this.responseText.trim()=="YYYY"){
						document.getElementById("chkEmail_rst").innerHTML = "<b style=\"color:blue\">사용 가능합니다</b>";
						document.getElementById("sbt").disabled = false;
					}else{
						document.getElementById("chkEmail_rst").innerHTML = "<b style=\"color:red\">사용 불가능합니다</b>";
						document.getElementById("sbt").disabled = true;
					}
				}
			}
		}
	}
</script>