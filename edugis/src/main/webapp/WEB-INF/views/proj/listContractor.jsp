<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sstpop.jspf"%>

		<!-- ///////////////////오른쪽 내용 영역/////////////////////-->
		<!-- contGen +++ start -->
		<div id="contGen" class="">
			<div style="text-align:center;margin-top:20px;">
				<span style="font-size:14px;color:#771E0A">계약업체 선택</span> <span style="font-size:12px;color:#858684;"> (해당로우를 클릭하세요.)</span>
			</div>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>

					<td>
						<!-- ********** 여기서 부터 본문 내용 *************** -->
						<form name="formx" id="formx" action="" method="post">
							<input name="curPage" type="hidden" value="${param.curPage }" />
							<input name="project_id" type="hidden" value="${param.project_id }" />	
						


							<input name="pageUnit" type="hidden" value="10" />
							<!-- search -->
								
							<p style="margin-top: 15px;"></p>



							<table width="100%" cellpadding="4" cellspacing="0" border="0" class="tb_01_01">
								<col width="90%" />
								<col width="10%" />
								<tr>
									<td>
										<table width="100%" cellpadding="4" cellspacing="0" border="0">
											<col width="15%" />
											<col width="85%" />
											<tr>
												<td class="tb_title" valign="middle"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" align="absmiddle" />&nbsp;업체명</td>
												<td><input name="s_name" id="s_name"  style="width:59%" type="text" class="text_left" value="${param.s_name}" /></td>
											</tr>
										</table>
									</td>
									<td><a href="javascript:onpagersubmit(1);"><img src="${wc}/eams/images/eams/common/btn_search.gif" alt="검색버튼" width="50" height="21" class="v_mid"
											style="float: right; padding-right: 3px; padding-bottom: 2px;" /></a></td>
								</tr>
							</table>
							<!--출력수 끝 -->
							<!-- list -->
							<div class="tb_list">
								<table class="tb_02" style="TABLE-layout: fixed" width="100%" border="0" cellspacing="0" cellpadding="0">
									<col width="50%" />
									<col width="30%" />
									<col width="20%" />
									<tr>
										<td class="tb_title">업체명</td>
										<td class="tb_title">사업자등록번호</td>
										<td class="tb_title">연락처</td>
									</tr>

									<c:if test="${fn:length(list) < 1 }">
										<tr>
											<td colspan="5">자료가 없습니다. 다른 검색조건을 선택해주세요.</td>
										</tr>
									</c:if>
									<tbody>
									<c:forEach items="${list }" var="item">

										<tr id="${item.contractor_id }" name="${item.contractor_name }"  style="cursor: pointer;" title="${item.memo }">
											
											<td style="text-align:left;padding-left:10px;">${item.contractor_name }</td>
											<td style="text-align:left;">${item.registration_number }</td>
											<td style="text-align:left;">${item.phone }</td>

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
								<div class="btnArea" style="margin-right:20px;">
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
		document.formx.action = '${wc}/listContractor.do';
		document.formx.submit();
		return false;
	}




	function goView(id, name) {
		if (opener && !opener.closed){ 
			window.opener.contactee_change(id, name);
			opener.focus(); 
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
