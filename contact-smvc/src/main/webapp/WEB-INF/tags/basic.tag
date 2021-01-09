<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ attribute name="titulo" required="true" description="Título da página"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ attribute name="extraStyle" fragment="true"  %>
<%@ attribute name="extraScript" fragment="true"  %>
<!doctype html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" /> 
    <title>${titulo}</title>
    <link rel="apple-touch-icon" sizes="180x180" href="<c:url value="/assets/favicon/apple-touch-icon.png"/>" />
    <link rel="icon" type="image/png" sizes="32x32" href="<c:url value="/assets/favicon/favicon-32x32.png"/>" />
    <link rel="icon" type="image/png" sizes="16x16" href="<c:url value="/assets/favicon/favicon-16x16.png"/>" />
    <link rel="manifest" href="<c:url value="/assets/site.webmanifest"/>" />
    <jsp:invoke fragment="extraStyle" />  
  </head>
  <body>
    <h1>Hello, world!</h1>
    <jsp:doBody />
    <jsp:invoke fragment="extraScript" />  
  </body>
</html>