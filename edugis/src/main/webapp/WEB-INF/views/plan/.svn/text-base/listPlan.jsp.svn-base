<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>

<!-- ///////////////////오른쪽 내용 영역/////////////////////-->
<!-- contGen +++ start -->
<div id="contGen" class="s_contain">
	<div class="ttl">
		<h2>중장기정보화계획</h2>
		<div class="category">정보화사업 &gt; 중장기정보화계획</div>
	</div>
	<table width="910" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="20"></td>
			<td>
				<!-- ********** 여기서 부터 본문 내용 *************** -->
				<form name="formx" id="formx" action="" method="post">
					<input name="curPage" id="curPage" type="hidden" value="${param.curPage }" />


					<input name="subMethod" id="subMethod" type="hidden" value="insert" />
					<input name="plan_id" id="plan_id" type="hidden" value="" />
					<!-- search -->
					<p style="margin-top: 15px;"></p>

					<table width="100%" cellpadding="4" cellspacing="0" border="1" class="tb_01">
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
										<td><input name="s_plan_name" id="s_plan_name" style="width: 99%" type="text" class="text_left" value="${param.s_plan_name}" /></td>
										<td class="tb_title" valign="middle"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" align="absmiddle" />&nbsp;중장기정보화계획유형</td>
										<td><select name="s_ptype" id="s_ptype">
												<option value="">=전체=</option>
												<t:options codeId="pltype" checkValue="${param.s_ptype}" />
										</select></td>

									</tr>
									<tr>
										<td class="tb_title" valign="middle"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" align="absmiddle" />&nbsp;사업시작년월</td>
										<td><input name="s_plan_start_month" id="s_plan_start_month" style="width: 59%" type="text" class="startMonth" value="${param.s_plan_start_month}" />&nbsp;ex)
											201302</td>
										<td class="tb_title" valign="middle"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" align="absmiddle" />&nbsp;사업종료년월</td>
										<td><input name="s_plan_end_month" id="s_plan_end_month" style="width: 59%" type="text" value="${param.s_plan_end_month}" />&nbsp;ex) 201312</td>
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
							<td class="ar" align="right"><span class="button small"><a href="#" id="excel">엑셀출력</a></span></td>
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
							<col width="30%" />
							<col width="20%" />
							<col width="20%" />
							<col width="10%" />
							<col width="10%" />
							<tr>
								<td class="tb_title">중장기정보화계획명</td>
								<td class="tb_title">중장기계획유형</td>
								<td class="tb_title">사업시작년월</td>
								<td class="tb_title">사업종료년월</td>
								<td class="tb_title">총사업비용</td>
							</tr>
							<c:if test="${fn:length(list) < 1 }">
								<tr>
									<td colspan="5">자료가 없습니다. 다른 검색조건을 선택해주세요.</td>
								</tr>
							</c:if>
							<c:forEach items="${list }" var="item">
								<tr>

									<td class="left" style="padding-left:30px;"><a href="#" onclick="javascript:goView('${item.plan_id }', '${wc}/viewPlan.do');">${item.PLAN_NAME }</a></td>
									<td><t:codevalue codeId="pltype" checkValue="${item.PTYPE }" /></td>
									<td><t:yearMon value="${item.PLAN_START_MONTH }" /></td>
									<td><t:yearMon value="${item.PLAN_END_MONTH }" /></td>
									<td style="text-align: right; padding-right: 14px;"><fmt:formatNumber value="${item.total_budget }" /></td>
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
						<t:button href="javascript:addNew('${wc}/formPlan.do');" value="신규" auth="admin,AUTHOR_ADMIN" />

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
	
	
	

	
	function onpagersubmit(pageNo) {
		if (!$('#formx').valid()) {
			return;
		}	
		if (pageNo == 'undefined') {
			pageNo = '1';
		}
		document.formx.curPage.value = pageNo;
		document.formx.action = '${wc}/listPlan.do';
		document.formx.submit();
		return false;
	}




	function goView(id, url) {

		document.formx.subMethod.value = 'view';
		document.formx.plan_id.value = id;
		document.formx.action = url;
		document.formx.submit();
		return false;
	}




	
	$(document).ready(function() {
		

		jQuery("#excel").click(function() {

	    	try {
	    		//alert($("select[name='s_ptype']").val() );
	    		// $('input:radio[name="s_ptype"]:checked').val()
		    var excel_iframe = document.createElement('iframe');
		    excel_iframe.style.display = "none";
		    excel_iframe.src = "${wc}/excelDown.do?subMethod=excel" + "&s_plan_name=" + $('#s_plan_name').val() + "&s_plan_start_month=" + $('#s_plan_start_month').val()
		    		+ "&s_plan_end_month=" + $('#s_plan_end_month').val()+ "&s_ptype=" + $("select[name='s_ptype']").val()  ;

		    document.body.appendChild(excel_iframe);
		    excel_iframe.location.load();
	    	} catch (err){
	    	}
	    	
		});
		
		$('#formx').validate({

			rules : {
				s_plan_start_month : { yearMonth : true },
				s_plan_end_month:{ yearMonth:true }
			},
			messages : {


			}
		});
		
		$('div.tb_list > table > tbody > tr').hover(function() {
		    $(this).addClass('hover');
		}, function() {
		    $(this).removeClass('hover');
		});
		
		
		
		
		$('div.category').addClass('categoryhelp');
		
		$('div.category').qtip({
			   content: '중장기정보화계획 목록보기.  \
					   <br>EA 관리자 권한이 있는 경우에 신규, \
					   <br>수정, 삭제가 가능하고 그외 사용자는 \
					   <br>조회만 가능합니다.  \
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
