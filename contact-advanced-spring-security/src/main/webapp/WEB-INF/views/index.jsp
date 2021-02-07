<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Hello World!</title>
	<link rel="stylesheet" type="text/css" href="assets/css/style.css">
</head>
<body>
    <h1>Hello World!</h1>
    
    <sec:authorize access="hasRole('ROLE_AUTENTICADO')">
        <!-- For login user -->
        <c:url value="/logout" var="logoutUrl" />
        <form action="${logoutUrl}" method="post" id="logoutForm">
            <input type="hidden" name="${_csrf.parameterName}"
                value="${_csrf.token}" />
        </form>
        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
        </script>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>
                User : ${pageContext.request.userPrincipal.name} | <a
                    href="javascript:formSubmit()"> Logout</a>
            </h2>
        </c:if>


    </sec:authorize>
    <h3>Oh, meu Deus.....................</h3>
    <p><sec:authentication property="principal.secao"  /> </p>
    <p><sec:authentication property="principal.idSecao"  /> </p>
     <sec:authorize access="hasRole('ROLE_CHEFE_SECAO')">
        <h4>Sou um chefe</h4>
     </sec:authorize>
     <p><sec:authentication property="principal"  /> </p>
     <sec:authorize access="hasRole('ROLE_CHEFE_SECAO')">
        <h4>Sou um SUB-chefe</h4>
     </sec:authorize>
</body>
</html>