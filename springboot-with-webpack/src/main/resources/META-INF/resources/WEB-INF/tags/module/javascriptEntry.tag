<%@ attribute name="entry" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag import="org.springframework.web.context.WebApplicationContext" %>
<%@ tag import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ tag import="com.mccormi.template.util.BuildVersion" %>
<%
  WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
  BuildVersion buildVersion = (BuildVersion)context.getBean("BuildVersion");
  if(buildVersion.isDev()){
    %>
    <script src="http://localhost:9090/dist/${entry}.js"></script>
    <%
  }else{
    %>
    <script src="/dist/${entry}.js"></script>
    <%
  }
%>



