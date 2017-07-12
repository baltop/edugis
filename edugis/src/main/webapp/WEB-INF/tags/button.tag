<%@ tag body-content="empty" pageEncoding = "UTF-8" %>
<%@tag import="com.ziumks.common.util.Settings"%>
<%@tag import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="value" required="true" %>
<%@ attribute name="href" required="false" %>
<%@ attribute name="auth" required="true" %>
<%@ attribute name="deptOption" required="false" %>
<%@ attribute name="id" required="false" %>
<%
	// 권한이 있으면 버튼 표시 권한 없으면 버튼 표시 안함.
	//  <t:button href="javascript:addNew('${wc}/formPlan.do');" value="신규" auth="admin" />
	//   href 안에  ""  큰 따옴표 사용하지 못함.
	
	String userAuth = ((com.ziumks.common.user.UserInfo) session.getAttribute("userInfo")).getAuthority();
	String userDept = ((com.ziumks.common.user.UserInfo) session.getAttribute("userInfo")).getDeptId();
	
	if ( deptOption == null ){
		deptOption = "";
	}
	if ( auth == null ){
		auth = "";
	}
		// 부서가 같으면 권한을 준다.
	    // if( deptOption.equals(userDept)  || auth.indexOf(userAuth) > 0 ){
		if(  auth.indexOf(userAuth) > 0 ){
%>		
			<span class="btn"><a id="${id }" href="${href}">${value}</a></span> 
<%	
		}

%>


