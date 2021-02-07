<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Hello World!</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>
    <h1>Hello World!</h1>
  
    <c:if test="${not empty error}">
      <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
      <div class="msg">${msg}</div>
    </c:if>
  
    <form action="<c:url value='/login' />" method='POST' method="post">
      <label>Usuário <input type="text" name="username" /></label> <label>Senha: <input
        type="password" name="password" /></label> <input type="submit" value="Entrar" />
        
        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
    </form>
  </body>
</html>