<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ tag import="com.vpodobano.textblog.service.I18NService"%>
<%@ tag import="com.vpodobano.textblog.service.impl.ServiceManager"%>

<%@ attribute name="key"  required="true" type="java.lang.String" %>
<%@ attribute name="args" required="false" type="java.lang.String" %>

<%
I18NService i18nService = ServiceManager.getInstance(request.getServletContext()).getI18nService();
String value = null;
if(args != null) {
	String arguments[] = args.split(",");
	value = i18nService.getMessage(key, request.getLocale(), (Object[]) arguments);
}
else{
	value = i18nService.getMessage(key, request.getLocale());
}
%>
<%=value %>