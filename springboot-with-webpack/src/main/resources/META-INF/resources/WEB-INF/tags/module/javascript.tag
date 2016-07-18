<%@ tag import="org.springframework.web.context.WebApplicationContext" %>
<%@ tag import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ tag import="com.mccormi.template.util.BuildVersion" %>
<!-- Javascript start -->
<%
  WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
  BuildVersion buildVersion = (BuildVersion)context.getBean("BuildVersion");
  if(buildVersion.isDev()){
    %>
    <script src="http://localhost:9090/dist/vendor.js"></script>
    <%
  }else{
    %>
    <script src="/dist/vendor.js"></script>
    <%
  }
%>
<!-- Javascript end -->
