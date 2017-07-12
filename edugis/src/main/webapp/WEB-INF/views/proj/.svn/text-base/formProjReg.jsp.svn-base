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
		<input type="hidden" name="pageUnit" id="pageUnit" value="${param.pageUnit }" />
		<input type="hidden" id="subMethod" name="subMethod" value="${param.subMethod }" />

		<input type="hidden" id="project_id" name="project_id" value="${item.project_id}" />
		<input type="hidden" id="plan_id" name="plan_id" value="${item.plan_id}" />
		<input type="hidden" id="plan_name" name="plan_name" value="${item.plan_name}" />
		<input type="hidden" id="original_plan_id" name="original_plan_id" value="${item.plan_id}" />
		<input type="hidden" id="original_plan_name" name="original_plan_name" value="${item.plan_name}" />
		
		<input type="hidden" id="tid" name="tid" value="${param.tid}" />

		<input type="hidden" id="proj_total_budget" name="proj_total_budget" value="${item.proj_total_budget}" />
		<input type="hidden" id="staff_id" name="staff_id" value="${item.staff_id }" />
		<input type="hidden" id="staff_dept_id" name="staff_dept_id" value="${item.staff_dept_id }" />
						

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
				<td colspan="3" width="75%">
					<%-- <c:if test="${param.subMethod == 'insert' }" > --%>
					<input name="project_name" id="project_name" type="text" size="60" value="${item.project_name }" maxlength="100"	class="input01 essence" />
<%-- 					</c:if>
					<c:if test="${param.subMethod == 'update' }" >${item.project_name }
					<input name="project_name" id="project_name" type="hidden" size="60" value="${item.project_name }"  />
					</c:if> --%>
					
				</td>	
			</tr>
			<tr>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 중장기정보화계획 명칭</td>
				<td colspan="3" width="75%"><a href="#" onclick="javascript:popPlanView();"> <span id="plan_name_span"
						style="display: inline-block; height: 18px; width: 200px; padding-left: 20px; padding-right: 40px; color: #9E9C9C; background-color: #EAEBE8">&nbsp;${item.plan_name}</span>
				</a> <img src="${wc}/img/btn_find02.gif" align="absmiddle" onclick="javascript:popPlanSearch();" /><label class="error" id="plan_id_error"></label></td>
			</tr>
			<tr>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업시작년월</td>
				<td width="25%"><input name="proj_start_month" id="proj_start_month" style="width: 59%" type="text" class="startMonth" value="${item.proj_start_month}" />&nbsp;ex)
					201302</td>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업종료년월</td>
				<td width="25%"><input name="proj_end_month" id="proj_end_month" style="width: 59%" type="text" value="${item.proj_end_month}" />&nbsp;ex) 201312</td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 예상사업비용</td>
				<td colspan="3">
					<table style="width: 80%;">
						<tr>
							<td style="width: 50%; text-align: right; padding-right: 20px;">기획비용</td>
							<td style="width: 50%; text-align: right; padding-right: 20px;"><input type='text' size='25' style='text-align: right'
									value='<fmt:formatNumber value="${item.planning_cost }" />' name='planning_cost' id='planning_cost' class='input01' onkeyup='fn_checkNumber3(this);'
									onblur="fn_calc();" />&nbsp;백만원</td>
						</tr>
						<tr>
							<td style="width: 50%; text-align: right; padding-right: 20px;">구축비용</td>
							<td style="width: 50%; text-align: right; padding-right: 20px;"><input type='text' size='25' style='text-align: right'
									value='<fmt:formatNumber value="${item.construction_cost }" />' name='construction_cost' id='construction_cost' class='input01' onkeyup='fn_checkNumber3(this);'
									onblur="fn_calc();" />&nbsp;백만원</td>
						</tr>
						<tr>
							<td style="width: 50%; text-align: right; padding-right: 20px;">운영/유지보수비용</td>
							<td style="width: 50%; text-align: right; padding-right: 20px;"><input type='text' size='25' style='text-align: right'
									value='<fmt:formatNumber value="${item.operation_cost }" />' name='operation_cost' id='operation_cost' class='input01' onkeyup='fn_checkNumber3(this);'
									onblur="fn_calc();" />&nbsp;백만원</td>
						</tr>
						<tr>
							<td style="width: 50%; text-align: right; padding-right: 20px;">지원비용</td>
							<td style="width: 50%; text-align: right; padding-right: 20px;"><input type='text' size='25' style='text-align: right'
									value='<fmt:formatNumber value="${item.supporting_cost }" />' name='supporting_cost' id='supporting_cost' class='input01' onkeyup='fn_checkNumber3(this);'
									onblur="fn_calc();" />&nbsp;백만원</td>
						</tr>
						<tr>
							<td style="width: 50%; text-align: right; padding-right: 20px; background-color: #D7DEE0;">총사업비용</td>
							<td style="width: 50%; text-align: right; padding-right: 20px;">
								<%-- 												<input type='text' size='25' style='text-align: right' value='<fmt:formatNumber value="${item.proj_total_budget }" />' name='proj_total_budget' class='input01'
														onkeyup='fn_checkNumber3(this);' />&nbsp;백만원 --%> <span id='proj_total_budget_span'><fmt:formatNumber value="${item.proj_total_budget }" /></span>&nbsp;백만원
							</td>
						</tr>
					</table>

				</td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 예산확정 여부</td>
				<td colspan="3"><t:radiobox codeId="bdg_yn" name="budget_decision_yn" checkValue="${item.budget_decision_yn }" defaultCheck="N" /></td>
			</tr>
	
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 시행계획 설명</td>
				<td colspan="3"><textarea id="project_desc" name="project_desc" class="" cols="75" rows="5" style="width: 660px; height: 100px; font-size: 9pt;"
				maxlength="1600" onkeyup="return textarea_maxlength(this);" onChange="return textarea_maxlength(this);" >${item.project_desc}</textarea></td>
			</tr>
			<tr>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업주관부서</td>
				<td width="25%"><input name="staff_dept" id="staff_dept" style="width: 99%" type="text" value="${item.staff_dept }" readonly="readonly" /></td>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업담당자</td>
				<td width="25%"><input
						name="staff_name" id="staff_name" style="width: 59%" type="text" value="${item.staff_name }"  readonly="readonly" />
						<img src="${wc}/img/btn_find02.gif" align="absmiddle" onclick="javascript:popUsersSearch();" /><label class="error" id="users_id_error"></label>

				</td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 연간시행계획 진행단계</td>
				<td colspan="3">
				<select name="status" id="status">
												<t:options codeId="status" checkValue="${item.status}" />
										</select>
				</td>
			</tr>					
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업관련자료</td>
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
		</table>
		<!-- 여백 -->
		<div class="btnArea">
			<t:button href="javascript:fn_insert();" value="저장" auth="admin,AUTHOR_ADMIN,pmsManager" deptOption="${item.staff_dept_id }"/>
			<c:if test="${param.subMethod=='update' }">
				<t:button href="javascript:goViewProj('${item.project_id }', '${wc}/viewProj.do');" value="취소" auth="admin,AUTHOR_ADMIN,pmsManager" deptOption="${item.staff_dept_id }"/>
			</c:if>
			<c:if test="${param.subMethod=='insert' }">
				<t:button href="javascript:goList('${wc}/listProj.do');" value="취소" auth="admin,AUTHOR_ADMIN,pmsManager" />
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

		var planning_cost = Number(document.formx.planning_cost.value.replace(
				/,/g, ""));
		var construction_cost = Number(document.formx.construction_cost.value
				.replace(/,/g, ""));
		var operation_cost = Number(document.formx.operation_cost.value
				.replace(/,/g, ""));
		var supporting_cost = Number(document.formx.supporting_cost.value
				.replace(/,/g, ""));

		var inc = fn_commaSplit(planning_cost + construction_cost
				+ operation_cost + supporting_cost);

		document.formx.proj_total_budget.value = inc;
		$("#proj_total_budget_span").text(inc);
	}

	function popPlanSearch() {
		var url = "${wc}/listPlanPop.do?vid=item&pageUnit=10&curPage=1";
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
						'height=520px,width=680px,menubar=no,toolbar=no,location=no, resizable=yes, status=no,scrollbars=no,top='
								+ py + ',left=' + px);
		searchPlan.focus();

	}
	
	function popUsersSearch() {
		
		var url = "${wc}/listUsersPop.do?pageUnit=10&curPage=1";
		/*		var openParam = "resizable: 0; scroll: 1; center: 1; scroll: no; dialogHeight:520px; dialogWidth:820px; ";
		window.showModalDialog(url,"p_tmplatInqire", openParam);  */
		var sw = screen.availWidth;
		var sh = screen.availHeight;
		var px = (sw - 580) / 2;
		var py = (sh - 480) / 2;
		var searchPlan = window
				.open(
						url,
						'searchPlan',
						'height=520px,width=580px,menubar=no,toolbar=no,location=no, resizable=yes, status=no,scrollbars=no,top='
								+ py + ',left=' + px);
		searchPlan.focus();

	}
	function popPlanView() {

		var cue = document.formx.plan_id.value;
		if (cue == null || cue == '') {
			popPlanSearch();
			return false;
		}

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
	
	function users_name_change(id, name, dept, dept_id) {
		if (id == '') {

		} else {
			$("#staff_id").val(id);
			$("#staff_dept_id").val(dept_id);
			$("#staff_dept").val(dept);
			$("#staff_name").val(name);
		}
	}
	
	
	
	function fn_insert() {
		
		if( document.formx.plan_id.value == '' || 
				document.formx.plan_id.value == null || 
				document.formx.plan_id.value == 'undefined' ){
			$('#plan_id_error').text('중장기 사업계획을 선택하십시요.');
			//alert('중장기 사업계획을 선택하십시요.');
			return;
		}
		if (!$('#formx').valid()) {
			return;
		}
		document.formx.planning_cost.value = document.formx.planning_cost.value
				.replace(/,/g, "");
		document.formx.construction_cost.value = document.formx.construction_cost.value
				.replace(/,/g, "");
		document.formx.operation_cost.value = document.formx.operation_cost.value
				.replace(/,/g, "");
		document.formx.supporting_cost.value = document.formx.supporting_cost.value
				.replace(/,/g, "");
		document.formx.proj_total_budget.value = document.formx.proj_total_budget.value
				.replace(/,/g, "");

		if (confirm('<spring:message code="common.regist.msg" />')) {
			document.formx.action = "<c:url value='saveProj.do'/>";
			document.formx.submit();
		}

	}

	$(document).ready(function() {

		$('#formx').validate({

			rules : {

				proj_start_month : {
					yearMonth : true
				},
				proj_end_month : {
					yearMonth : true,
					yearMonthEnd : true
				},
				project_name : {
					required : true,
					minlength : 3,
				    remote: {
				          url: "${wc}/checkProjectName.do",
				          type: "post",
				          data: {
				            project_name : function() {
				              return $( "#project_name" ).val();
				            },
				            project_id : function() {
					              return $( "#project_id" ).val();
					        }
				          }
				    }					
				}
			},
			messages : {
				project_name : {
					required : "명칭을 입력하시오.",
					minlength : jQuery.format("명칭은 {0}자 이상"),
					remote : "같은 이름의 연간계획이 있습니다."					
				},
				proj_start_month : {
					required : "사업시작년월을 입력하십시요."

				},
				proj_end_month : {
					required : "사업종료년월을 입력하십시요."
				}	
			}
		});
		
		
		$('div.category').addClass('categoryhelp');
		
		$('div.category').qtip({
			   content: '연간시행계획 기본 데이터를 입력합니다. \
					   <br>범정부연동으로 같은 이름의 연간시행계획이 \
					   <br>있으면 안됩니다. 중장기 정보화 옆의 돋보기 버튼을\
					   <br> 클릭하여 상위 중장기를 선택하십시요. 상위 중장기\
					   <br>계획이 없으면 레가시를 선택하십시요. 사업시작년월은 \
					   <br>201305 식으로 \'-\' 없이 입력하십시요. 사업담당자는\
					   <br>직원을 선택하면 부서는 자동 선택 됩니다. 하단의 \
					   <br>진행단계 변경 셀렉트 박스는 부득이한 경우에만 \
					   <br>강제 변경하십시요. 입력할때마다 자동 관리 됩니다.',
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
