<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>

<!-- ///////////////////오른쪽 내용 영역/////////////////////-->
<!-- contGen +++ start -->
<div id="contGen" class="s_contain">
	<div class="ttl">
		<h2>중장기정보화계획</h2>
		<div class="category">정보화사업 &gt; 중장기정보화계획</div>
	</div>

	<form name="formx" id="formx" action="" method="post" enctype="multipart/form-data">
		<input name="curPage" type="hidden" value="${param.curPage}" />
		<input name="pageUnit" id="pageUnit" type="hidden" value="${param.pageUnit }" />
		<input name="subMethod" type="hidden" value="${param.subMethod }" />
		<input name="plan_id" type="hidden" value="${item.plan_id}" />

		<!-- 서치조건  -->
		<input name="s_plan_name" type="hidden" value="${param.s_plan_name }" />
		<input name="s_plan_start_month" type="hidden" value="${param.s_plan_start_month }" />
		<input name="s_plan_end_month" type="hidden" value="${param.s_plan_end_month }" />
		<input name="s_ptype" type="hidden" value="${param.s_ptype }" />

		<table width="910" cellpadding="6" cellspacing="0" border="0" class="tb_03">
			<colgroup>
				<col width="25%" />
				<col width="" />
				<col width="25%" />
				<col width="" />
			</colgroup>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 중장기정보화계획 명칭</td>
				<td colspan="3">
					<c:if test="${param.subMethod == 'insert' }" >
					<input name="plan_name" id="plan_name" type="text" size="60" value="${item.plan_name }" maxlength="100"	class="input01 essence" />
					</c:if>
					<c:if test="${param.subMethod == 'update' }" >${item.plan_name }
					<input name="plan_name" id="plan_name" type="hidden" size="60" value="${item.plan_name }"  />
					</c:if>				
				</td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 중장기정보화계획 유형</td>
				<td colspan="3"><t:radiobox codeId="pltype" name="ptype" checkValue="${item.ptype }" defaultCheck="001" /> <%-- 							<input type="radio" class="nostyle" name="ptype" id="ptype" value="001" <c:if test="${item.ptype == '001' || empty item.ptype }">checked="checked"</c:if> />계속사업&nbsp;
							<input type="radio" class="nostyle" name="ptype" id="ptype"	value="002" <c:if test="${item.ptype == '002'}">checked="checked"</c:if> />신규사업
		 --%></td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업시작년월</td>
				<td>&nbsp;<input name="plan_start_month" id="plan_start_month" style="text-align: left" type="text" maxlength="6" class="input01 essense startMonth" size="10"
						value="${item.plan_start_month }" />&nbsp;년월 ex)201302
				</td>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업종료년월</td>
				<td>&nbsp;<input name="plan_end_month" style="text-align: left" type="text" maxlength="6" class="input01 essense" size="10" value="${item.plan_end_month }" />&nbsp;년월
					ex)201310
				</td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 총사업비</td>
				<td colspan="3">&nbsp;<input type='text' size='25' maxlength="10" style='text-align: right' value='<fmt:formatNumber value="${item.total_budget}" />' name='total_budget'
						class='input01' onkeyup='fn_checkNumber3(this);' />&nbsp;백만원
				</td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업설명</td>
				<td colspan="3"><textarea id="plan_desc" name="plan_desc" class="textarea" cols="75" rows="5" style="width: 660px; height: 100px;" 
				maxlength="1600" onkeyup="return textarea_maxlength(this);" onChange="return textarea_maxlength(this);">${item.plan_desc}</textarea></td>
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
			
			<t:button href="javascript:fn_insert();" value="저장" auth="admin,AUTHOR_ADMIN" />
			<c:if test="${param.subMethod=='update' }">
				<t:button href="javascript:goView('${item.plan_id }', '${wc }/viewPlan.do');" value="취소" auth="admin,AUTHOR_ADMIN" />
			</c:if>
			<c:if test="${param.subMethod=='insert' }">
				<t:button href="javascript:goList('${wc }/listPlan.do');" value="취소" auth="admin,AUTHOR_ADMIN" />
			</c:if>
			<span class="btn"><a href="javascript:goList('${wc }/listPlan.do');">목록</a></span>
		</div>

	</form>
</div>
<!-- contGen +++ end -->
<!-- ///////////////////오른쪽 내용 영역/////////////////////-->







<script type="text/javascript">
<!--
	function fn_insert() {

		if (!$('#formx').valid()) {
			return;
		}
		document.formx.total_budget.value = document.formx.total_budget.value
				.replace(/,/g, "");

		if (confirm('<spring:message code="common.regist.msg" />')) {
			document.formx.action = "<c:url value='savePlan.do'/>";
			document.formx.submit();
		}

	}

	function goView(id, url) {

		document.formx.subMethod.value = 'view';
		document.formx.plan_id.value = id;
		document.formx.action = url;
		document.formx.submit();
		return true;
	}

	$(document).ready(function() {

		$('#formx').validate({

			rules : {
				plan_name : {
					required : true,
					minlength : 3,
				    remote: {
				          url: "${wc}/checkPlanName.do",
				          type: "post",
				          data: {
				            plan_name : function() {
				              return $( "#plan_name" ).val();
				            }
				          }
				    }
				},
				plan_start_month : {
					required : true,
					yearMonth : true
					
				},
				plan_end_month : {
					required : true,
					yearMonth : true,
					yearMonthEnd : true
				},
				total_budget : {
					required : true					
				}
			},
			messages : {
				plan_name : {
					required : "명칭을 입력하십시요.",
					minlength : jQuery.format("명칭은 {0}자 이상"),
					remote : "같은 이름의 중장기계획이 있습니다."
				},
				plan_start_month : {
					required : "사업시작년월을 입력하십시요."

				},
				plan_end_month : {
					required : "사업종료년월을 입력하십시요."
				},
				total_budget : {
					required : "총사업비를 입력하십시요."					
				}

			}
		});

	});
//-->
</script>



<%@include file="/WEB-INF/inc/end.jspf"%>
