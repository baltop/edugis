<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>

<!-- ///////////////////오른쪽 내용 영역/////////////////////-->
<!-- contGen +++ start -->
<div id="contGen" class="s_contain">
	<c:if test="${param.bbs_id == '3001' }" >
	<div class="ttl">
		<h2>정보화사업 공지</h2>
		<div class="category">정보화사업 &gt; 정보화사업 공지</div>
	</div>
	</c:if>
	<c:if test="${param.bbs_id == '3002' }" >	
	<div class="ttl">
		<h2>정보화사업 자료실</h2>
		<div class="category">정보화사업 &gt; 정보화사업 자료실</div>
	</div>	
	</c:if>
	<table width="910" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="20"></td>
			<td>
				<!-- ********** 여기서 부터 본문 내용 *************** -->
				<form name="formx" id="formx" action="" method="post">
					<input name="curPage" id="curPage" type="hidden" value="${param.curPage }" />
					<input name="subMethod" id="subMethod" type="hidden" value="insert" />
					<input name="bbs_id" id="bbs_id" type="hidden" value="${param.bbs_id}" />



					<input name="thread_id" id="thread_id" type="hidden" value="" />

					<!-- search -->
					<p style="margin-top: 15px;"></p>

					<table width="100%" cellpadding="4" cellspacing="0" border="1" class="tb_01">
						<col width="90%" />
						<col width="10%" />
						<tr>
							<td>
								<table width="100%" cellpadding="4" cellspacing="0" border="0">
									<col width="20%" />
									<col width="65%" />

									<col width="10%" />
									<!-- 이름 -->
									<tr>
										<td class="tb_title" valign="middle"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" align="absmiddle" />&nbsp;게시판 검색</td>
										<td><%-- <select name="s_ptype" id="s_ptype">
												<t:options codeId="bbssh" checkValue="${param.s_ptype}" />
										</select>  --%>제목검색 : <input name="s_thread_search" id="s_thread_search" style="width: 69%; " type="text" class="text_left" value="${param.s_thread_search}" /></td>
									</tr>

								</table>
							</td>
							<td><a href="javascript:onpagersubmit(1);"><img src="${wc}/eams/images/eams/common/btn_search.gif" alt="검색버튼" width="50" height="21" class="v_mid"
									style="float: right; padding-right: 3px; padding-bottom: 2px;" /></a></td>
						</tr>
					</table>

					<!--출력수 시작-->
					<table class="board_remark" width="100%">
						<tr>
							<td><span style="find-size: 11px;"><t:totalCnt listName="list" /> </span></td>
							<td class="ar" align="right"></td>
							<td class="ar" width="95">출력수 <select name="pageUnit" class="search_select" id="pageUnit" onchange="onpagersubmit('1')">
									<option value='15' <c:if test="${param.pageUnit == '15'}">selected="selected"</c:if>>15</option>
									<option value='25' <c:if test="${param.pageUnit == '25'}">selected="selected"</c:if>>25</option>
									<option value='50' <c:if test="${param.pageUnit == '50'}">selected="selected"</c:if>>50</option>
									<option value='100' <c:if test="${param.pageUnit == '100'}">selected="selected"</c:if>>100</option>
							</select>
							</td>
						</tr>
					</table>
					<!--출력수 끝 -->
					<!-- list -->
					<div class="tb_list">
						<table class="tb_02" style="TABLE-layout: fixed" width="100%" border="0" cellspacing="0" cellpadding="0">
							<col width="60%" />
							<col width="10%" />
							<col width="10%" />

							<col width="20%" />
							<tr>
								<td class="tb_title">제목</td>
								<td class="tb_title">글쓴이</td>
								<td class="tb_title">조회</td>

								<td class="tb_title">일자</td>
							</tr>
							<c:if test="${fn:length(list) < 1 }">
								<tr>
									<td colspan="5">자료가 없습니다. 다른 검색조건을 선택해주세요.</td>
								</tr>
							</c:if>
							<c:forEach items="${list }" var="item">
								<tr>
									<td style="text-align: left;padding-left:40px;"><a href="#" onclick="javascript:goView('${item.thread_id }', '${wc }/system/viewBbs.do');">${item.thread_title }</a></td>
									<td>${item.tr_register_id }</td>
									<td>${item.read_count }</td>

									<td style="text-align: right; padding-right: 14px;">${item.register_date}</td>
								</tr>
							</c:forEach>

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
						<t:button href="javascript:addNew('${wc}/system/formBbs.do');" value="신규" auth="admin,AUTHOR_ADMIN" />
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





<script type="text/javascript">
<!--
	function goView(id, url) {

		document.formx.subMethod.value = 'view';
		document.formx.thread_id.value = id;
		document.formx.action = url;
		document.formx.submit();
		return false;
	}

	function onpagersubmit(pageNo) {

		if (pageNo == 'undefined') {
			pageNo = '1';
		}
		document.formx.curPage.value = pageNo;
		document.formx.action = '${wc}/system/listBbs.do';
		document.formx.submit();
		return false;
	}

	$(document).ready(function() {

		$('div.tb_list > table > tbody > tr').hover(function() {
		    $(this).addClass('hover');
		}, function() {
		    $(this).removeClass('hover');
		});
		
		

		$('div.category').addClass('categoryhelp');
		
		$('div.category').qtip({
			   content: '정보화 사업관리의 공지 및 자료실임. \
					   <br>EA 관리자 권한이 있는 경우에 신규, \
					   <br>수정, 삭제가 가능하고 그외 사용자는 \
					   <br>조회만 가능함.  \
				',
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
					   max: 400
				   }
			   }
			});

		
		
	});
//-->
</script>




<%@include file="/WEB-INF/inc/end.jspf"%>
