<%@tag import="com.ziumks.common.util.DateUtil" pageEncoding="UTF-8"%>
<%@tag import="java.util.*"%>
<%@ tag body-content="empty"%>
<%@ attribute name="selected" required="false"%>
<%@ attribute name="id" required="true"%>
<%@ attribute name="firstOption" required="false"%>
<%@ attribute name="curYear" required="false"%>
<%
	String currentYear = DateUtil.getToday("yyyy");
	String requestyear = request.getParameter("s_year");
	int cyear = Integer.parseInt(currentYear);
	int selectedYear = cyear;
	if (selected != null && !"".equals(selected)) {
		selectedYear = Integer.parseInt(selected);
	}else	if( !"yes".equals(curYear)){
		selectedYear = 0;
	}

	int endYear = cyear + 3;

	int startYear = 2005;

	out.println("<select id='"+id+"' name='"+id+"' >");


	out.println(firstOption);


	for (int i = startYear; i < endYear; i++) {
		if (i == selectedYear) {
			out.println("<option value=\"" + i + "\" selected>" + i + "</option>");
		} else {
			out.println("<option value=\"" + i + "\" >" + i + "</option>");
		}
	}

	out.println("</select>");
%>
