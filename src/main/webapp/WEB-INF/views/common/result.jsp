<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	if('${result==1}'){
		opener.location.href="../";
		window.close();
	}else{
		alert('${msg}');
	}
	
		
</script>



