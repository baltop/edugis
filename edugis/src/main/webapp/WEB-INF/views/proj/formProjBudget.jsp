<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>

<!-- ///////////////////오른쪽 내용 영역/////////////////////-->
<!-- contGen +++ start -->
<div id="contGen" class="s_contain">
	<div class="ttl">
		<h2>연간시행계획 등록</h2>
		<div class="category">정보화사업 &gt; 연간시행계획 등록</div>
	</div>

	<form name="formx" id="formx" action="" method="post" enctype="multipart/form-data">
		<input type="hidden" id="curPage" name="curPage" value="${param.curPage}" />
		<input name="pageUnit" id="pageUnit" type="hidden" value="${param.pageUnit }" />
		<input type="hidden" id="subMethod" name="subMethod" value="${param.subMethod }" />

		<input type="hidden" id="project_id" name="project_id" value="${item.project_id}" />
		<input type="hidden" id="plan_id" name="plan_id" value="${item.plan_id}" />
		<input type="hidden" id="plan_name" name="plan_name" value="${item.plan_name}" />
		<input type="hidden" id="original_plan_id" name="original_plan_id" value="${item.plan_id}" />
		<input type="hidden" id="original_plan_name" name="original_plan_name" value="${item.plan_name}" />
		<input type="hidden" id="status" name="status" value="${item.status}" />
		<input type="hidden" id="tid" name="tid" value="${param.tid}" />

		<input type="hidden" id="budget_increase" name="budget_increase" value="${item.budget_increase}" />

		<!-- 서치조건  -->
		<input type="hidden" name="s_project_name" id="s_project_name" value="${param.s_project_name }" />
		<input type="hidden" name="s_proj_start_month" id="s_proj_start_month" value="${param.s_proj_start_month }" />
		<input type="hidden" name="s_proj_end_month" id="s_proj_end_month" value="${param.s_proj_end_month }" />
		<input type="hidden" name="s_status" id="s_status" value="${param.s_status }" />
		<input type="hidden" name="s_year" id="s_year" value="${param.s_year }" />
		<input type="hidden" name="s_plan_id" id="s_plan_id" value="${param.s_plan_id }" />
		<input type="hidden" name="s_plan_name" id="s_plan_name" value="${param.s_plan_name }" />

		<input type="hidden" name="budget_decision_yn" id = "budget_decision_yn" value="Y" />



		<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
			<colgroup>
				<col width="25%" />
				<col width="25%" />
				<col width="25%" />
				<col width="25%" />
			</colgroup>
			<tr>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 연간시행계획 명칭</td>
				<td colspan="3" width="75%">${item.project_name }</td>
			</tr>
			<tr>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 중장기정보화계획 명칭</td>
				<td colspan="3" width="75%"><a href="#" onclick="javascript:popPlanView('${item.plan_id }', '${wc}/viewPlan.do');">${item.plan_name }</a></td>
			</tr>
			<tr>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업시작년월</td>
				<td width="25%"><t:yearMon value="${item.proj_start_month }" /></td>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업종료년월</td>
				<td width="25%"><t:yearMon value="${item.proj_end_month }" /></td>
			</tr>
		</table>
		<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
			<colgroup>
				<col width="25%" />
				<col width="75%" />

			</colgroup>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 예산편성정보</td>
				<td>
					<table style="width: 80%;">
						<tr>
							<td style="width: 50%; text-align: right; padding-right: 20px;">신청사업예산</td>
							<td style="width: 50%; text-align: right; padding-right: 20px;"><input type='text' size='25' style='text-align: right'
									value='<fmt:formatNumber value="${item.request_budget }" />' name='request_budget' class='input01' onkeyup='fn_checkNumber3(this);' onblur="fn_calc();" />&nbsp;백만원
							</td>
						</tr>
						<tr>
							<td style="width: 50%; text-align: right; padding-right: 20px;">배정예산</td>
							<td style="width: 50%; text-align: right; padding-right: 20px;"><input type='text' size='25' style='text-align: right'
									value='<fmt:formatNumber value="${item.allocation_budget }" />' name='allocation_budget' class='input01' onkeyup='fn_checkNumber3(this);' onblur="fn_calc();" />&nbsp;백만원
							</td>
						</tr>
						<tr>
							<td style="width: 50%; text-align: right; padding-right: 20px; background-color: #D7DEE0;">예산증감액</td>
							<td style="width: 50%; text-align: right; padding-right: 20px;"><span id='budget_increase_span'><fmt:formatNumber value="${item.budget_increase }" /></span>&nbsp;백만원
								<%-- 
												<input type='text' size='25' style='text-align: right' value='<fmt:formatNumber value="${item.budget_increase }" />' name='budget_increase' class='input01'
														readOnly />&nbsp;백만원
 --%></td>
						</tr>
						<tr>
							<td style="width: 50%; text-align: right; padding-right: 20px;">예산코드</td>
							<td style="width: 50%; text-align: right; padding-right: 60px;"><input type='text' size='25' class="input01 essence" style='text-align: left;'
									value='${item.wbs_code }' name='wbs_code' /></td>
						</tr>

					</table>

				</td>
			</tr>
<%--
 			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 예산확정 여부</td>
				<td><t:radiobox codeId="bdg_yn" name="budget_decision_yn" checkValue="${item.budget_decision_yn }" defaultCheck="N" /></td>
			</tr> 
--%>
			
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 예산편성관련자료</td>
				<td>
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
		</table>
		<!-- 여백 -->
		<div class="btnArea">
			<span class="btn"><a href="javascript:fn_insert();">저장</a></span>
			<c:if test="${param.subMethod=='update' }">
				<span class="btn"><a href="javascript:goViewProj('${item.project_id }', '${wc}/viewProj.do');">취소</a></span>
			</c:if>
			<span class="btn"><a href="javascript:goList('${wc}/listProj.do');">목록</a></span>
		</div>

	</form>
</div>
<!-- contGen +++ end -->
<!-- ///////////////////오른쪽 내용 영역/////////////////////-->







<script type="text/javascript">
<!--
	function fn_calc() {

		var request = Number(document.formx.request_budget.value.replace(/,/g,
				""));

		var alloc = Number(document.formx.allocation_budget.value.replace(/,/g,
				""));
		var inc = fn_commaSplit(request - alloc);

		document.formx.budget_increase.value = inc;
		$("#budget_increase_span").text(inc);
	}



	function popPlanView() {
		var url = "${wc}/viewPlan.do?subMethod=viewPop&plan_id="
				+ document.formx.plan_id.value;

		var sw = screen.availWidth;
		var sh = screen.availHeight;
		var px = (sw - 680) / 2;
		var py = (sh - 480) / 2;
		var viewPlan = window
				.open(
						url,
						'searchPlan',
						'height=420px,width=960px,menubar=no,toolbar=no,location=no, resizable=yes, status=no,scrollbars=yes,top='
								+ py + ',left=' + px);
		viewPlan.focus();
	}



	function fn_insert() {
/* 
		if (!$('#formx').valid()) {
			return;
		} */
		document.formx.request_budget.value = document.formx.request_budget.value
				.replace(/,/g, "");
		document.formx.allocation_budget.value = document.formx.allocation_budget.value
				.replace(/,/g, "");
		document.formx.budget_increase.value = document.formx.budget_increase.value
				.replace(/,/g, "");

		if (confirm('<spring:message code="common.regist.msg" />')) {
			document.formx.action = "<c:url value='saveProj.do'/>";
			document.formx.submit();
		}

	}

	$(document).ready(function() {

/* 		$('#formx').validate({

			rules : {
				wbs_code : {
					required : true
				}
			},
			messages : {
				wbs_code : {
					required : "예산코드를 입력하시오."
				}
			}
		}); */
		
		
		$('div.category').addClass('categoryhelp');
		
		$('div.category').qtip({
			   content: '예산코드는 예산관리시스템의 코드를 입력. \
					   <br>하십시요. ',
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
					   max: 600
				   }
			   }
			});

	});
//-->
</script>




<%@include file="/WEB-INF/inc/end.jspf"%>
