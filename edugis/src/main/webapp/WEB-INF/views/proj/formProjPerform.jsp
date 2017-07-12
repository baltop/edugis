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

		<input type="hidden" id="proj_total_cost" name="proj_total_cost" value="${item.proj_total_cost}" />

		<!-- 서치조건  -->
		<input type="hidden" name="s_project_name" id="s_project_name" value="${param.s_project_name }" />
		<input type="hidden" name="s_proj_start_month" id="s_proj_start_month" value="${param.s_proj_start_month }" />
		<input type="hidden" name="s_proj_end_month" id="s_proj_end_month" value="${param.s_proj_end_month }" />
		<input type="hidden" name="s_status" id="s_status" value="${param.s_status }" />
		<input type="hidden" name="s_year" id="s_year" value="${param.s_year }" />
		<input type="hidden" name="s_plan_id" id="s_plan_id" value="${param.s_plan_id }" />
		<input type="hidden" name="s_plan_name" id="s_plan_name" value="${param.s_plan_name }" />





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
				<col width="25%" />
				<col width="25%" />
				<col width="25%" />
			</colgroup>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업수행 내용</td>
				<td colspan="3"><textarea id="proj_content" name="proj_content" class="" cols="75" rows="5"
						style="width: 660px; height: 100px; font-size: 9pt; " 
						maxlength="1600" onkeyup="return textarea_maxlength(this);" onChange="return textarea_maxlength(this);" >${item.proj_content}</textarea></td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업유형</td>
				<td colspan="3"><t:radiobox codeId="projtp" name="proj_type" checkValue="${item.proj_type }" defaultCheck="001" />
				<input type="text" size="40" maxlength="200" name="proj_type_verbose" id="proj_type_verbose" value="${item.proj_type_verbose}" />
				</td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업비용세부정보</td>
				<td colspan="3">
					<table style="width: 70%;">
						<tr>
							<td style="width: 40%; text-align: right; padding-right: 20px;">H/W비용</td>
							<td style="width: 60%; text-align: right; padding-right: 20px;"><input type='text' size='25' style='text-align: right'
									value='<fmt:formatNumber value="${item.proj_hardware_cost }" />' name='proj_hardware_cost' id='proj_hardware_cost' class='input01' onkeyup='fn_checkNumber3(this);'
									onblur="fn_calc();" />&nbsp;백만원</td>
						</tr>
						<tr>
							<td style="width: 40%; text-align: right; padding-right: 20px;">S/W비용</td>
							<td style="width: 60%; text-align: right; padding-right: 20px;"><input type='text' size='25' style='text-align: right'
									value='<fmt:formatNumber value="${item.proj_software_cost }" />' name='proj_software_cost' id='proj_software_cost' class='input01' onkeyup='fn_checkNumber3(this);'
									onblur="fn_calc();" />&nbsp;백만원</td>
						</tr>
						<tr>
							<td style="width: 40%; text-align: right; padding-right: 20px;">시스템개발비용</td>
							<td style="width: 60%; text-align: right; padding-right: 20px;"><input type='text' size='25' style='text-align: right'
									value='<fmt:formatNumber value="${item.proj_develope_cost }" />' name='proj_develope_cost' id='proj_develope_cost' class='input01' onkeyup='fn_checkNumber3(this);'
									onblur="fn_calc();" />&nbsp;백만원</td>
						</tr>
						<tr>
							<td style="width: 40%; text-align: right; padding-right: 20px;">컨설팅비용</td>
							<td style="width: 60%; text-align: right; padding-right: 20px;"><input type='text' size='25' style='text-align: right'
									value='<fmt:formatNumber value="${item.proj_consulting_cost }" />' name='proj_consulting_cost' id='proj_consulting_cost' class='input01'
									onkeyup='fn_checkNumber3(this);' onblur="fn_calc();" />&nbsp;백만원</td>
						</tr>
						<tr>
							<td style="width: 40%; text-align: right; padding-right: 20px;">정보자원유지보수비용</td>
							<td style="width: 60%; text-align: right; padding-right: 20px;"><input type='text' size='25' style='text-align: right'
									value='<fmt:formatNumber value="${item.proj_resource_maintenance_cost }" />' name='proj_resource_maintenance_cost' id='proj_resource_maintenance_cost'
									class='input01' onkeyup='fn_checkNumber3(this);' onblur="fn_calc();" />&nbsp;백만원</td>
						</tr>
						<tr>
							<td style="width: 40%; text-align: right; padding-right: 20px;">개발시스템유지보수비용</td>
							<td style="width: 60%; text-align: right; padding-right: 20px;"><input type='text' size='25' style='text-align: right'
									value='<fmt:formatNumber value="${item.proj_system_maintenance_cost }" />' name='proj_system_maintenance_cost' id='proj_system_maintenance_cost' class='input01'
									onkeyup='fn_checkNumber3(this);' onblur="fn_calc();" />&nbsp;백만원</td>
						</tr>
						<tr>
							<td style="width: 40%; text-align: right; padding-right: 20px;">정보서비스운영비용</td>
							<td style="width: 60%; text-align: right; padding-right: 20px;"><input type='text' size='25' style='text-align: right'
									value='<fmt:formatNumber value="${item.proj_operation_cost }" />' name='proj_operation_cost' id='proj_operation_cost' class='input01'
									onkeyup='fn_checkNumber3(this);' onblur="fn_calc();" />&nbsp;백만원</td>
						</tr>
						<tr>
							<td style="width: 40%; text-align: right; padding-right: 20px; background-color: #D7DEE0;">총사업비용</td>
							<td style="width: 60%; text-align: right; padding-right: 20px;"><span id='proj_total_cost_span'><fmt:formatNumber value="${item.proj_total_cost }" /></span>&nbsp;백만원
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

		var proj_hardware_cost = Number(document.formx.proj_hardware_cost.value
				.replace(/,/g, ""));
		var proj_software_cost = Number(document.formx.proj_software_cost.value
				.replace(/,/g, ""));
		var proj_develope_cost = Number(document.formx.proj_develope_cost.value
				.replace(/,/g, ""));
		var proj_consulting_cost = Number(document.formx.proj_consulting_cost.value
				.replace(/,/g, ""));
		var proj_resource_maintenance_cost = Number(document.formx.proj_resource_maintenance_cost.value
				.replace(/,/g, ""));
		var proj_system_maintenance_cost = Number(document.formx.proj_system_maintenance_cost.value
				.replace(/,/g, ""));
		var proj_operation_cost = Number(document.formx.proj_operation_cost.value
				.replace(/,/g, ""));

		var inc = fn_commaSplit(proj_hardware_cost + proj_software_cost
				+ proj_develope_cost + proj_consulting_cost
				+ proj_resource_maintenance_cost + proj_system_maintenance_cost
				+ proj_operation_cost);

		document.formx.proj_total_cost.value = inc;
		$("#proj_total_cost_span").text(inc);
	}

	function fn_insert() {

		if (!$('#formx').valid()) {
			return;
		}
		document.formx.proj_hardware_cost.value = document.formx.proj_hardware_cost.value
				.replace(/,/g, "");
		document.formx.proj_software_cost.value = document.formx.proj_software_cost.value
				.replace(/,/g, "");
		document.formx.proj_develope_cost.value = document.formx.proj_develope_cost.value
				.replace(/,/g, "");
		document.formx.proj_consulting_cost.value = document.formx.proj_consulting_cost.value
				.replace(/,/g, "");
		document.formx.proj_resource_maintenance_cost.value = document.formx.proj_resource_maintenance_cost.value
				.replace(/,/g, "");
		document.formx.proj_system_maintenance_cost.value = document.formx.proj_system_maintenance_cost.value
				.replace(/,/g, "");
		document.formx.proj_operation_cost.value = document.formx.proj_operation_cost.value
				.replace(/,/g, "");
		document.formx.proj_total_cost.value = document.formx.proj_total_cost.value
				.replace(/,/g, "");

		if (confirm('<spring:message code="common.regist.msg" />')) {
			document.formx.action = "<c:url value='saveProj.do'/>";
			document.formx.submit();
		}

	}

	
	
	/* khs */
	$(document).ready(function() {
		
		
		$("input[name=proj_type]").change(function() {
			var radioValue = $(this).val();
			
			if ( radioValue != '010'){
				
				$("#proj_type_verbose").val("");
			}
		});

		$('#formx').validate({

			rules : {
				proj_content : {
					required : true,
					minlength : 3
				}
			},
			messages : {
				proj_content : {
					required : "수행내용을 입력하시오.",
					minlength : jQuery.format("수행내용은 {0}자 이상")
				}
			}
		});

	});
//-->
</script>




<%@include file="/WEB-INF/inc/end.jspf"%>
