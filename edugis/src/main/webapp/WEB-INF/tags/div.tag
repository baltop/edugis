<%@ tag body-content="empty" pageEncoding = "UTF-8" %>
<%@tag import="com.ziumks.common.util.Settings"%>
<%@tag import="java.util.*"%>
<%@ attribute name="value" required="true" %>
<%@ attribute name="id" required="true" %>
<%@ attribute name="className" required="false" %>
<%@ attribute name="size" required="false" %>
<%@ attribute name="maxlength" required="false" %>
<%@ attribute name="readonly" required="false" %>
<%

	String method = request.getParameter("subMethod");

	if ( "insert".equals(method) || "update".equals(method) ){
		//<input name="plan_name" caption="이름" id="plan_name" type="text" size="60" value="${item.plan_name }" maxlength="100" class="input01 essence" />
		out.print("<input name='" + id + "' id='" + id + "' type='text' class='"+className+"' size='" + size + "' value='"+value+"' maxlength='" + maxlength + "' "+ readonly +"/>"  );
	}
	else if ("view".equals(method) ){
		out.print("+value+");
	}
	else {
		out.print("param.subMethod is not found.");
	}


%>
