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



		<!-- 서치조건  -->
		<input type="hidden" name="s_project_name" id="s_project_name" value="${param.s_project_name }" />
		<input type="hidden" name="s_proj_start_month" id="s_proj_start_month" value="${param.s_proj_start_month }" />
		<input type="hidden" name="s_proj_end_month" id="s_proj_end_month" value="${param.s_proj_end_month }" />
		<input type="hidden" name="s_status" id="s_status" value="${param.s_status }" />
		<input type="hidden" name="s_year" id="s_year" value="${param.s_year }" />
		<input type="hidden" name="s_plan_id" id="s_plan_id" value="${param.s_plan_id }" />
		<input type="hidden" name="s_plan_name" id="s_plan_name" value="${param.s_plan_name }" />


		<!--  ea 파일 연동에 필요함. -->

		<input type="hidden" name="project_name" id="project_name" value="${item.project_name }" />

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
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 수행산출물</td>
				<td colspan="3">
					<table style="border: 0px; border-bottom: 0px; border-top: 0px; width: 100%;">
						<c:forEach items="${outputFiles}" var="file">
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
		<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
			<colgroup>
				<col width="25%" />
				<col width="75%" />

			</colgroup>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 관리산출물</td>
				<td colspan="3">
					<table style="border: 0px; border-bottom: 0px; border-top: 0px; width: 100%;">
						<c:forEach items="${adminFiles}" var="file">
							<tr id="idxFile${file.file_id }">
								<td style="border: 0px;"><a href="javascript:fn_egov_downFile('${file.file_id }')"> ${file.file_name }&nbsp;[${file.ref_id }&nbsp;byte] </a> <img
									src="${wc }/eams/images/button/btn_del2.gif" style="vertical-align: middle;" onclick="javascript:fn_ajax_deleteFile('${file.file_id}')" /></td>
							</tr>
						</c:forEach>


						<div id="idxFileDelMsg"></div>
					</table>
					<table width="100%" cellspacing="0" cellpadding="0" border="0" align="center" class="tb_in01">
						<tr>
							<td><input name="file_1" id="FileUploader2" type="file" title="첨부파일" style="width: 90px;height:26px;" /></td>
						</tr>
						<tr>
							<td>
								<div id="egovComFileList2"></div>
							</td>
						</tr>
					</table>

				</td>
			</tr>
		</table>
		<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
			<colgroup>
				<col width="25%" />
				<col width="75%" />

			</colgroup>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> EA요청자료 (등록후 저장시 자동으로 EAMS에 현행화 요청됩니다.)</td>
				<td colspan="3">
					<table style="border: 0px; border-bottom: 0px; border-top: 0px; width: 100%;">
						<c:forEach items="${eareqFiles}" var="file">
							<tr id="idxFile${file.file_id }">
								<td style="border: 0px;"><a href="javascript:fn_egov_downFile('${file.file_id }')"> ${file.file_name }&nbsp;[${file.ref_id }&nbsp;byte] </a> <img
									src="${wc }/eams/images/button/btn_del2.gif" style="vertical-align: middle;" onclick="javascript:fn_ajax_deleteFile('${file.file_id}')" /></td>
							</tr>
						</c:forEach>


						<div id="idxFileDelMsg"></div>
					</table>
					<table width="100%" cellspacing="0" cellpadding="0" border="0" align="center" class="tb_in01">
						<tr>
							<td><input name="file_2" id="FileUploader3" type="file" title="첨부파일" style="width: 90px;height:26px;" /></td>
						</tr>
						<tr>
							<td>
								<div id="egovComFileList3"></div>
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
	function fn_insert() {

		if (!$('#formx').valid()) {
			return;
		}

		if (confirm('<spring:message code="common.regist.msg" />')) {
			document.formx.action = "<c:url value='saveProj.do'/>";
			document.formx.submit();
		}

	}

	$(document)
			.ready(
					function() {

						$('#FileUploader2')
								.MultiFile(
										{
											list : '#egovComFileList2',
											STRING : {
												remove : '<img src="${wc}/eams/images/button/btn_del3.png" alt="x"/>',
												selected : '선택한 파일: $file',
												denied : '업로드할 수 없는 파일입니다 $ext!',
												duplicate : '이미 선택한 파일입니다:\n$file!'
											}
										});
						$('#FileUploader3')
						.MultiFile(
								{
									list : '#egovComFileList3',
									STRING : {
										remove : '<img src="${wc}/eams/images/button/btn_del3.png" alt="x"/>',
										selected : '선택한 파일: $file',
										denied : '업로드할 수 없는 파일입니다 $ext!',
										duplicate : '이미 선택한 파일입니다:\n$file!'
									}
								});

						$('div.category').addClass('categoryhelp');
						
						$('div.category').qtip({
							   content: '파일삭제는 확인 버튼을 누르면 즉시 삭제됩니다. \
									   <br>파일 추가는 반드시 저장 버튼을 클릭해야합니다. \
									   <br>EA 요청자료에 EA현행화를 위한 엑셀파일을 \
									   <br>업로드 할 수 있습니다. \
									   <br>EA 요청자료는 자동으로 EA 현행화 요청이 됩니다. .',
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
