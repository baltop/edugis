<%@tag import="com.ziumks.common.util.Settings"%>
<%@tag import="java.util.*"%>
<%@ tag body-content="empty"%>
<%@ attribute name="codeId" required="true"%>
<%@ attribute name="checkValue" required="true"%>
<%@ attribute name="codeGroup" required="false"%>
<%
	// 코드에 해당하는 밸류를 표시함. 서버의 settings tr_ 기능을 사용할 것.
	List oo = Settings.get(codeId);
	if (oo == null || oo.size() == 0) {
		return;
	}

	Iterator it = oo.iterator();
	while (it.hasNext()) {
		String[] item = (String[]) it.next();

		if (item[0].equals(checkValue)) {
			out.println(item[1]);
		}
	}
%>
