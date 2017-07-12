<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>


<!-- ///////////////////오른쪽 내용 영역/////////////////////-->
<!-- contGen +++ start -->
<div id="contGen" class="s_contain">
	<div class="ttl">
		<h2>중장기정보화계획</h2>
		<div class="category">정보화사업 &gt; 중장기정보화계획</div>
	</div>

	<form name="formx" id="formx" action="" method="post">
		<input name="curPage" type="hidden" value="${param.curPage}" />
		<input name="pageUnit" id="pageUnit" type="hidden" value="${param.pageUnit }" />
		<input name="subMethod" type="hidden" value="update" />
		<input name="plan_id" type="hidden" value="${item.plan_id }" />
		<input name="s_plan_name" type="hidden" value="${param.s_plan_name }" />
		<input name="s_plan_start_month" type="hidden" value="${param.s_plan_start_month }" />
		<input name="s_plan_end_month" type="hidden" value="${param.s_plan_end_month }" />
		<input name="s_ptype" type="hidden" value="${param.s_ptype }" />

		<table width="910" cellpadding="6" cellspacing="0" border="0" class="tb_03">
			<colgroup>
				<col width="25%" />
				<col width="25%" />
				<col width="25%" />
				<col width="25%" />
			</colgroup>
			<tr>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 중장기정보화계획 명칭</td>
				<td colspan="3" width="75%">${item.plan_name }</td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 중장기정보화계획 유형</td>
				<td colspan="3"><t:radiobox codeId="pltype" name="ptype" checkValue="${item.ptype }" defaultCheck="001" readOnly="yes" /></td>
			</tr>
			<tr>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업시작년월</td>
				<td width="25%"><t:yearMon value="${item.PLAN_START_MONTH }" /></td>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업종료년월</td>
				<td widht="25%"><t:yearMon value="${item.PLAN_END_MONTH }" /></td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 총사업비</td>
				<td colspan="3"><fmt:formatNumber value="${item.total_budget }" />&nbsp;백만원</td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업설명</td>
				<td colspan="3"><textarea id="plan_desc" name="plan_desc" class="" cols="75" rows="5" style="width: 660px; height: 100px; font-size: 9pt;"
						readonly="readonly">${item.plan_desc}</textarea></td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업관련자료</td>
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
		</table>
		<!-- 여백 -->
		<div class="btnArea">
			<t:button href="javascript:updateItem('${wc}/formPlan.do');" value="수정" auth="admin,AUTHOR_ADMIN" />
			<c:if test="${subItem == true }">
				<t:button href="javascript:deleteItem('${wc}/deletePlan.do');" value="삭제" auth="admin,AUTHOR_ADMIN" />
			</c:if>
			<span class="btn"><a href="javascript:goList('${wc}/listPlan.do');">목록</a></span>
		</div>
		<div class="btnArea2">
			<span class="btn"><a href="javascript:window.close();">닫기</a></span>
		</div>
	</form>
</div>
<!-- contGen +++ end -->
<!-- ///////////////////오른쪽 내용 영역/////////////////////-->








<script type="text/javascript">
<!--
	$(document).ready(function() {
		$('div.category').addClass('categoryhelp');
		
		$('div.category').qtip({
			   content: 'EA 관리자 권한이 있는 경우에 \
					   <br>수정, 삭제가 가능하고 그외 사용자는\
					   <br>조회만 가능합니다. 딸린 연간시행계획이 \
				       <br>없으면 삭제 버튼이 표시됩니다.',
			   show: 'mouseover',
			   hide: 'mouseout',
			   position: {
			      corner: {
			         target: 'bottomRight',
			         tooltip: 'topRight'
			      }
			   },
			   style: { 
			      name: 'dark', 
				   width: {
					   min : 10,
					   max: 500
				   }
			   }
			});
	});
//-->
</script>


<%@include file="/WEB-INF/inc/end.jspf"%>
