<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sstpop.jspf"%>

		<!-- ///////////////////오른쪽 내용 영역/////////////////////-->
		<!-- contGen +++ start -->
		<div id="contGen" class="">
			<div style="text-align:center;margin-top:20px;">
				<span style="font-size:14px;color:#771E0A">중장기정보화계획 선택</span> <span style="font-size:12px;color:#858684;"> (해당로우를 클릭하세요.)</span>
			</div>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>

					<td>
						<!-- ********** 여기서 부터 본문 내용 *************** -->
						<form name="formx" id="formx" action="" method="post">
							<input name="curPage" type="hidden" value="${param.curPage }" />
							
							<input name="subMethod" type="hidden" value="insert" />
							<input name="plan_id" type="hidden" value="" />
							<input name="pageUnit" type="hidden" value="10" />
							<input name="vid" type="hidden" value="" />
							<!-- search -->
							<p style="margin-top: 15px;"></p>

							<table width="100%" cellpadding="4" cellspacing="0" border="0" class="tb_01_01">
								<col width="90%" />
								<col width="10%" />
								<tr>
									<td>
										<table width="100%" cellpadding="4" cellspacing="0" border="0">
											<col width="20%" />
											<col width="25%" />
											<col width="20%" />
											<col width="25%" />
											<col width="10%" />
											<!-- 이름 -->
											<tr>
												<td class="tb_title" valign="middle"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" align="absmiddle" />&nbsp;중장기정보화계획명</td>
												<td><input name="s_plan_name" id="s_plan_name"  style="width: 99%" type="text" class="text_left" value="${param.s_plan_name}" /></td>

												<td class="tb_title" valign="middle"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" align="absmiddle" />&nbsp;중장기정보화계획유형</td>
												<td><select name="s_ptype" id="s_ptype">
														<option value="">=전체=</option>
														<t:options codeId="pltype" checkValue="${param.s_ptype}" />
												</select></td>

												 
											</tr>
											<tr>
												<td class="tb_title" valign="middle"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" align="absmiddle" />&nbsp;사업시작년월</td>
												<td><input name="s_plan_start_month" id="s_plan_start_month" style="width: 59%" type="text" class="startMonth" value="${param.s_plan_start_month}" /><br />ex) 201302</td>
												<td class="tb_title" valign="middle"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" align="absmiddle" />&nbsp;사업종료년월</td>
												<td><input name="s_plan_end_month" id="s_plan_end_month" style="width: 59%" type="text"  value="${param.s_plan_end_month}" /><br />ex) 201312</td>
											</tr>
										</table>
									</td>
									<td><a href="javascript:onpagersubmit(1);"><img src="${wc}/eams/images/eams/common/btn_search.gif" alt="검색버튼" width="50" height="21" class="v_mid"
											style="float: right; padding-right: 3px; padding-bottom: 2px;" /></a></td>
								</tr>
							</table>
							<div style="height:2px;">&nbsp;</div>
							<!--출력수 끝 -->
							<!-- list -->
							<div class="tb_list">
								<table class="tb_02" style="TABLE-layout: fixed" width="100%" border="0" cellspacing="0" cellpadding="0">
									<col width="50%" />
									<col width="10%" />
									<col width="10%" />
									<col width="10%" />

									<tr>
										<td class="tb_title">정보화사업명</td>
										<td class="tb_title">정보화사업유형</td>
										<td class="tb_title">사업시작년월</td>
										<td class="tb_title">사업종료년월</td>

									</tr>
<!-- 									<tr id="" name="" style="cursor: pointer;">
										<td style="background-color:#FDE6A8;" colspan='4'><span style="color:#8E3824;" >선택 취소</span></td>
									</tr> -->
									<c:if test="${fn:length(list) < 1 }">
										<tr>
											<td colspan="5">자료가 없습니다. 다른 검색조건을 선택해주세요.</td>
										</tr>
									</c:if>
									<tbody>
									<c:forEach items="${list }" var="item">
										<tr id="${item.plan_id }" name="${item.plan_name }"  style="cursor: pointer;">
											
											<td>${item.PLAN_NAME }</td>
											<td><t:codevalue codeId="pltype" checkValue="${item.PTYPE }" /></td>
											<td><t:yearMon value="${item.PLAN_START_MONTH }" /></td>
											<td><t:yearMon value="${item.PLAN_END_MONTH }" /></td>

										</tr>
									</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- list -->


							<!--페이징 시작 -->
							<div class="pagination">
								<t:pager curPage="${param.curPage }" totalCnt="${list[0].totalCnt }" pageRow="${param.pageUnit }" />
							</div>
							<!-- 페이징 끝 -->
							<!-- button -->
		<div class="btnArea">
			<span class="btn"><a href="javascript:window.close();">닫기</a></span>
		</div>
							<!-- button -->
							<p style="margin-top: 15px;"></p>
						</form> <!-- ********** 여기까지 내용 *************** -->
					</td>
				</tr>
			</table>
		</div>
		<!-- contGen +++ end -->
		<!-- ///////////////////오른쪽 내용 영역/////////////////////-->
	</div>
	<!-- contBody +++ end -->




<script type="text/javascript">
	<!--
	
	
	

	
	function onpagersubmit(pageNo) {


		if (!$('#formx').valid()) {
			return;
		}	
	
		if (pageNo == 'undefined') {
			pageNo = '1';
		}
		document.formx.curPage.value = pageNo;
		document.formx.vid.value = '${param.vid}';
		document.formx.action = '${wc}/listPlanPop.do';
		document.formx.submit();
		return false;
	}




	function goView(id, name) {
		
		var vid = '${param.vid}';

		if (vid=='item'){
			// 신규 나 업데이트일때
			if (opener && !opener.closed){ 
				opener.document.formx.plan_name.value = name;

				opener.document.formx.plan_id.value = id;
				window.opener.plan_name_change(id, name);
				opener.focus(); 
			} 
		}
		else {
			// 검색조건 찾기일때
			if (opener && !opener.closed){ 
				opener.document.formx.s_plan_name.value = name;
				opener.document.formx.s_plan_id.value = id;
				opener.focus(); 
			} 
		}

		window.close(); 

	}




	
	$(document).ready(function() {
		

		$("div.tb_list > table > tbody > tr").live('click', function() {
	        goView( $(this).attr('id'),$(this).attr('name'));
	        //get <td> element values here!!??
	    });
		
		$('div.tb_list > table > tbody > tr').hover(function() {
		    $(this).addClass('hover');
		}, function() {
		    $(this).removeClass('hover');
		});

		
	});
	

		//-->
	</script>





</body>
</html>
