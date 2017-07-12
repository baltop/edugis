<%@tag import="java.util.*" pageEncoding="UTF-8"%>
<%@ tag body-content="empty"%>
<%@ attribute name="num" required="true"%>
<%
	// 숫자에 
	if ("".equals(num)) {
		num = "0";
	}
	int number = 0;
	try {
		number = Integer.parseInt(num);
		java.text.NumberFormat nf = java.text.NumberFormat.getNumberInstance();
		out.println(nf.format(number));
	} catch (Exception e) {
		out.println("0");
	}
%>
