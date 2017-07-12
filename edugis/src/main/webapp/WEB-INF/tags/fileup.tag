<%@ tag body-content="empty" pageEncoding = "UTF-8" %>
<%@tag import="com.ziumks.common.util.Settings"%>
<%@tag import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="value" required="true" %>
<%@ attribute name="id" required="true" %>
<%@ attribute name="className" required="false" %>
<%@ attribute name="size" required="false" %>
<%@ attribute name="maxlength" required="false" %>
<%@ attribute name="readonly" required="false" %>
<%@ attribute name="type" required="false" %>

<c:if test="${param.subMethod == 'view' }">
			<tr>
				<td class="td_title"><img src='${wc}/eams/images/eams/common/icon_bul2.gif' /> ${value}</td>
				<td colspan="3"><c:if test="${fn:length(files) > 0 }">
						<table style="border: 0px; border-bottom: 0px; border-top: 0px; width: 100%;">
							<c:forEach items="${files}" var="file">
								<tr>
									<td style="border: 0px;"><a href="javascript:fn_egov_downFile('${file.file_id }')"> ${file.file_name }&nbsp;[<fmt:formatNumber value="${file.file_size }" />&nbsp;byte]
									</a></td>
								</tr>
							</c:forEach>


							<div id="idxFileDelMsg"></div>
						</table>
					</c:if> <c:if test="${fn:length(files) < 1 }">
								첨부파일이 없습니다.
								</c:if></td>
			</tr>
</c:if>
<c:if test="${param.subMethod == 'insert' ||param.subMethod == 'update'  }">
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> ${value}</td>
				<td colspan="3">
					<table style="border: 0px; border-bottom: 0px; border-top: 0px; width: 100%;">
						<c:forEach items="${files}" var="file">
							<tr id="idxFile${file.file_id }">
								<td style="border: 0px;"><a href="javascript:fn_egov_downFile('${file.file_id }')"> ${file.file_name }&nbsp;[${file.ref_id }&nbsp;byte] </a> <img
									src="${wc }/eams/images/button/btn_del2.gif" style="vertical-align: middle;" onclick="javascript:fn_ajax_deleteFile('${file.file_id}')" /></td>
							</tr>
						</c:forEach>


						<div id="idxFileDelMsg"></div>
					</table>
					<table width="100%" cellspacing="0" cellpadding="0" border="0" align="center" class="tb_in01">
						<tr>
							<td><input name="file_0" id="FileUploader" type="file" title="첨부파일" style="width: 90px;height:26px;" /></td>
						</tr>
						<tr>
							<td>
								<div id="egovComFileList"></div>
							</td>
						</tr>
					</table>

				</td>
			</tr>
</c:if>
