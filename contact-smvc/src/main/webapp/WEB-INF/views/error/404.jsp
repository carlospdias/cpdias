<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true" %>
<%@taglib  prefix="tpl" tagdir="/WEB-INF/tags"   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<tpl:basic titulo="Generic Error Page">
  <jsp:attribute name="extraStyle">
    <link rel="stylesheet" href="<c:url value="/assets/css/main.css"/>" />
  </jsp:attribute>
  <jsp:attribute name="extraScript">
    <script src="<c:url value="/assets/js/main.js"/>" ></script>
  </jsp:attribute>
  
  <jsp:body>
    
    <div class="container">
      <div class="banner">
        <h2>Unknown Error Occured, please contact support.</h2>
        ${URL}
      </div>
    </div>
    <br />
  </jsp:body>  
</tpl:basic>
