<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sstpop.jspf"%>

		<!-- ///////////////////오른쪽 내용 영역/////////////////////-->
		<!-- contGen +++ start -->
		<div id="contGen" class="">
			<div style="text-align:center;margin-top:20px;">
				<span style="font-size:14px;color:#771E0A">담당자 선택</span> <span style="font-size:12px;color:#858684;"> (해당로우를 클릭하세요.)</span>
			</div>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>

					<td>
						<!-- ********** 여기서 부터 본문 내용 *************** -->
						<form name="formx" id="formx" action="" method="post">
							<input name="curPage" type="hidden" value="${param.curPage }" />
							<input name="vid" type="hidden" value="${param.vid }" />

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
											<col width="30%" />
											<col width="15%" />
											<col width="30%" />
											<col width="10%" />
											<!-- 이름 -->
											<tr>
												<td class="tb_title" valign="middle"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" align="absmiddle" />&nbsp;사용자명</td>
												<td><input name="s_name" id="s_name"  style="width: 99%" type="text" class="text_left" value="${param.s_name}" /></td>
												<%-- 어드민이 아니면 자신의 부서만 나오므로 부서명 검색이 필요없음.  --%>
												
												<td class="tb_title" valign="middle"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" align="absmiddle" />&nbsp;부서명</td>
												<td><input name="s_dept_name" id="s_dept_name"  style="width: 99%" type="text" class="text_left" value="${param.s_dept_name}" /></td>
												
												 
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
									<col width="20%" />
									<col width="40%" />
									<col width="40%" />

									<tr>
										<td class="tb_title">사번</td>
										<td class="tb_title">사용자명</td>
										<td class="tb_title">부서명</td>

									</tr>

									<c:if test="${fn:length(list) < 1 }">
										<tr>
											<td colspan="5">자료가 없습니다. 다른 검색조건을 선택해주세요.</td>
										</tr>
									</c:if>
									<tbody>
									<c:forEach items="${list }" var="item">

										<tr id="${item.user_id }" name="${item.user_name }" dept="${item.dept_formal_name }" dept_id="${item.dept_id }" style="cursor: pointer;">
											
											<td style="text-align:left;padding-left:10px;">${item.user_id }</td>
											<td style="text-align:left;">${item.user_name }</td>
											<td style="text-align:left;" >${item.dept_formal_name }</td>

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
		document.formx.action = '${wc}/listUsersPop.do';
		document.formx.submit();
		return false;
	}




	function goView(id, name,dept, dept_id) {
		if (opener && !opener.closed){ 
			
			window.opener.users_name_change(id, name, dept, dept_id);
			opener.focus(); 
		} 
		window.close(); 
	}




	
	$(document).ready(function() {
		

		$("div.tb_list > table > tbody > tr").live('click', function() {
			
	        goView( $(this).attr('id'),$(this).attr('name') ,$(this).attr('dept') ,$(this).attr('dept_id')  );
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
