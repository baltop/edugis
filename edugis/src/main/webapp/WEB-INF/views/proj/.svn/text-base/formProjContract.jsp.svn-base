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
		
		<input type="hidden" id="contractee_id" name="contractee_id" value="${item.contractee_id}" />
		<input type="hidden" id="contractee" name="contractee" value="${item.contractee}" />

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
				<col width="75%" />

			</colgroup>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 계약일</td>
				<td><input name="contract_date" id="contract_date" type="text" size="12" value="<t:dispDate value='${item.contract_date }' />" maxlength="12"
						class="input01 essence" readOnly /></td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 계약종료일</td>
				<td><input name="contract_end_date" id="contract_end_date" type="text" size="12" value="<t:dispDate value='${item.contract_end_date }'/>" maxlength="12"
						class="input01 essence" readOnly /></td>
				</td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 계약금액</td>
				<td><input type='text' size='25' style='text-align: right' value='<fmt:formatNumber value="${item.contract_price }" />' name='contract_price' id='contract_price'
						class='input01' onkeyup='fn_checkNumber3(this);' onblur="fn_calc();" />&nbsp;백만원 <span style="display: inline; padding-left: 120px;">&nbsp;</span> <t:radiobox
						codeId="vat" name="contract_price_type" checkValue="${item.contract_price_type }" defaultCheck="001" /></td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 계약업체</td>
				<td><span id="contractee_span"
						style="display: inline-block; height: 18px; width: 200px; padding-left: 20px; padding-right: 40px; color: #9E9C9C; background-color: #EAEBE8">&nbsp;${item.contractee }</span>
				</a> <img src="${wc}/img/btn_find02.gif" align="absmiddle" onclick="javascript:popContractSearch();" /></td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 계약업체 담당자</td>
				<td><span class="pms_sub">담당자명 : </span><input name="contractee_staff_name" id="contractee_staff_name" type="text" size="10" value="${item.contractee_staff_name }" maxlength="20"
						class="input01 essence" />
						<span class="pms_sub">직위 : </span><input name="contractee_staff_position" id="contractee_staff_position" type="text" size="6"
						value="${item.contractee_staff_position }" maxlength="20" class="input01 essence" />
						<span class="pms_sub">연락처 : </span><input name="contractee_staff_phone"
						id="contractee_staff_phone" type="text" size="16" value="${item.contractee_staff_phone }" maxlength="20" class="input01 essence" /></td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 계약 관련자료</td>
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


	function contactee_change(id, name){
		$("#contractee_span").text(name);
		document.formx.contractee_id.value = id;
		document.formx.contractee.value = name;
	}
	
	function popContractSearch() {
		var url = "${wc}/listContractor.do?pageUnit=10&curPage=1";
		/*		var openParam = "resizable: 0; scroll: 1; center: 1; scroll: no; dialogHeight:520px; dialogWidth:820px; ";
		window.showModalDialog(url,"p_tmplatInqire", openParam);  */
		var sw = screen.availWidth;
		var sh = screen.availHeight;
		var px = (sw - 680) / 2;
		var py = (sh - 480) / 2;
		var searchPlan = window
				.open(
						url,
						'searchPlan',
						'height=520px,width=680px,menubar=no,toolbar=no,location=no, resizable=no, status=no,scrollbars=no,top='
								+ py + ',left=' + px);
		searchPlan.focus();
	
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

	function plan_name_change(id, name) {
		if (id == '') {
			document.formx.plan_id.value = document.formx.original_plan_id.value;
			document.formx.plan_name.value = document.formx.original_plan_name.value;
			$("#plan_name_span").text(document.formx.original_plan_name.value);
		} else {
			$("#plan_name_span").text(name);
		}
	}

	function fn_insert() {

		if (!$('#formx').valid()) {
			return;
		}
		document.formx.contract_date.value = document.formx.contract_date.value
				.replace(/-/g, "");
		document.formx.contract_end_date.value = document.formx.contract_end_date.value
				.replace(/-/g, "");
		document.formx.contract_price.value = document.formx.contract_price.value
				.replace(/,/g, "");
		if (confirm('<spring:message code="common.regist.msg" />')) {
			document.formx.action = "<c:url value='saveProj.do'/>";
			document.formx.submit();
		}

	}

	$(document).ready(function() {
		
		
	    $('#contract_date').datepicker( {
	        changeMonth: true,
	        changeYear: true,
	        showButtonPanel: true,
	        dateFormat: 'yy-MM-dd',
	        buttonText : "달력",
			monthNames : [ '01', '02', '03', '04', '05', '06', '07',
							'08', '09', '10', '11', '12' ],
					monthNamesShort : [ '01', '02', '03', '04', '05', '06',
							'07', '08', '09', '10', '11', '12' ],
	            showOn: "button",
	            buttonImage: "img/calendar.gif",
	            buttonImageOnly: false
	    });
		
	    $('#contract_date').datepicker('setDate', new Date());
	    
	    
	    $('#contract_end_date').datepicker( {
	        changeMonth: true,
	        changeYear: true,
	        showButtonPanel: true,
	        dateFormat: 'yy-MM-dd',
	        buttonText : "달력",
			monthNames : [ '01', '02', '03', '04', '05', '06', '07',
							'08', '09', '10', '11', '12' ],
					monthNamesShort : [ '01', '02', '03', '04', '05', '06',
							'07', '08', '09', '10', '11', '12' ],
	            showOn: "button",
	            buttonImage: "img/calendar.gif",
	            buttonImageOnly: false
	    });
		
	    $('#contract_end_date').datepicker('setDate', new Date());

		$('#formx').validate({

			rules : {
				contract_date : {
					required : true
				},
				contract_end_date : {
					required : true
				},
				contract_price : {
					required : true
				}
			},
			messages : {
				contract_date : {
					required : "계약일을 입력하시오."
				}
				, contract_end_date : {
					required : "계약종료일을 입력하시오."
				}
				, contract_price : {
					required : "계약금액을 입력하시오."
				}

			}
		});

	});
//-->
</script>




<%@include file="/WEB-INF/inc/end.jspf"%>
