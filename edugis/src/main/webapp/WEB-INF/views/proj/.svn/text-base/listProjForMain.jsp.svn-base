<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/knkal.tld" prefix="cx"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko" >
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>KOSPO EA</title>
<link rel="stylesheet" type="text/css" href="${wc}/eams/css/eams/tgeams.css" />
<link rel="stylesheet" href="${wc}/css/base/jquery.ui.all.css" />
<script>

function goViewProj(id, url) {
	document.formx.subMethod.value = 'view';
	document.formx.project_id.value = id;
	document.formx.action = '/pms/viewProj.do';
	document.formx.submit();
	return false;
}


</script>
</head>
<body>
				<form name="formx" id="formx" action="" method="post">
					<input name="curPage" id="curPage" type="hidden" value="${param.curPage }" />
					<input name="subMethod" id="subMethod" type="hidden" value="insert" />
					<input name="project_id" id="project_id" type="hidden" value="" />
					<input name="s_plan_id" id="s_plan_id" type="hidden" value="${param.s_plan_id }" />


					<div class="tb_list">
						<table class="tb_02" style="TABLE-layout: fixed" width="100%" border="0" cellspacing="0" cellpadding="0">
							<col width="40%" />
							<col width="20%" />							
							<col width="15%" />
							<col width="15%" />
							<col width="10%" />
							<tr>
								<td class="tb_title">연간시행계획명</td>
								<td class="tb_title">진행상태</td>
								<td class="tb_title">사업시작년월</td>
								<td class="tb_title">사업종료년월</td>
								<td class="tb_title">총사업비용</td>
							</tr>
							<c:if test="${fn:length(list) < 1 }">
								<tr>
									<td colspan="5">자료가 없습니다. 다른 검색조건을 선택해주세요.</td>
								</tr>
							</c:if>
							<c:forEach items="${list }" var="item">
								<tr>
									
									<td class="left" style="padding-left:30px;">
										<%-- <a href="#" onclick="parent.go_pms_project('${item.project_id}');"> --%>
										${item.project_name }
										<%-- </a> --%>
										</td>
									<td class="left">${item.tr_status }</td>
									<td><t:yearMon value="${item.proj_start_month }" /></td>
									<td><t:yearMon value="${item.proj_end_month }" /></td>
									<td style="text-align: right; padding-right: 14px;" ><fmt:formatNumber value="${item.proj_total_budget }" /></td>
								</tr>
							</c:forEach>

						</table>
					</div>
				</form> <!-- ********** 여기까지 내용 *************** -->

</body>
</html>