<%@tag import="java.util.*" pageEncoding="UTF-8"%>
<%@ tag body-content="empty"%>
<%@ attribute name="value" required="true"%>
<%
	if( value.length() != 6){
		value = "";
		out.print("");
		return;
	}
	out.print( value.substring(0, 4) +"-"+value.substring(4,6));
	
%>
