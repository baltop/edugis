<%@ tag body-content="empty" pageEncoding = "UTF-8" %>
<%@tag import="com.ziumks.common.util.Settings"%>
<%@tag import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="value" required="true" %>
<%@ attribute name="id" required="false" %>
<%@ attribute name="classnm" required="false" %>
<%@ attribute name="maxLength" required="true" type="java.lang.Integer"%>

<%
	String contents = "";
	if ( value.length() >  maxLength ) {
		contents = value.substring(0, maxLength) + "...";
	} 
	else {
		contents = value;
	}
%>	
<span id='${id }' class='${classnm }' title='${value }' ><%=contents %></span>

