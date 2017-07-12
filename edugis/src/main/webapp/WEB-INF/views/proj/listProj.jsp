<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>

<!-- ///////////////////오른쪽 내용 영역/////////////////////-->
<!-- contGen +++ start -->
<div id="contGen" class="s_contain">
	<div class="ttl" >
		<h2 id="top_title" >연간시행계획</h2>
		<div class="category" >정보화사업 &gt; 연간시행계획 </div>
	</div>
	<table width="910" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="20"></td>
			<td>
				<!-- ********** 여기서 부터 본문 내용 *************** -->
				<form name="formx" id="formx" action="" method="post">
					<input name="curPage" id="curPage" type="hidden" value="${param.curPage }" />
					<input name="subMethod" id="subMethod" type="hidden" value="insert" />
					<input name="project_id" id="project_id" type="hidden" value="" />
					<input name="s_plan_id" id="s_plan_id" type="hidden" value="${param.s_plan_id }" />

					<!-- search -->
					<p style="margin-top: 15px;"></p>

					<table width="100%" cellpadding="4" cellspacing="0" border="1" class="tb_01">
						<col width="90%" />
						<col width="10%" />
						<tr>
							<td>
								<table width="100%" cellpadding="4" cellspacing="0" border="0">
									<col width="20%" />
									<col width="40%" />
									<col width="15%" />
									<col width="20%" />
									<col width="10%" />
									<!-- 이름 -->
									<tr>
										<td class="tb_title" valign="middle"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" align="absmiddle" />&nbsp;연간시행계획명</td>
										<td><input name="s_project_name" id="s_project_name" style="width: 99%" type="text" class="text_left" value="${param.s_project_name}" /></td>

										<td class="tb_title" valign="middle"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" align="absmiddle" />&nbsp;시행계획상태</td>
										<td><select name="s_status" id="s_staus">
												<option value="">=전체=</option>
												<t:options codeId="status" checkValue="${param.s_status}" />
										</select></td>


										<td></td>
									</tr>
									<tr>
										<td class="tb_title" valign="middle"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" align="absmiddle" />&nbsp;중장기사업</td>
										<td colspan="3" valign="middle"><input name="s_plan_name" id="s_plan_name" style="width: 59%; color: #9E9C9C; background-color: #EAEBE8" type="text"
												value="${param.s_plan_name}" readonly="readonly" /> <img src="${wc}/img/btn_find02.gif" align="absmiddle" onclick="javascript:popPlanSearch();" /></td>
									</tr>
									<tr>
										<td class="tb_title" valign="middle"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" align="absmiddle" />&nbsp;사업년도</td>
										<td><t:yearSelect selected="${param.s_year }" id="s_year" firstOption="<option value='' > 전체 </option>"/></td>
										<td></td>
										<td></td>
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
							<col width="10%" />							
							<col width="10%" />
							<col width="10%" />
							<col width="10%" />
							<tr>
								<td class="tb_title">연간시행계획명</td>
								<td class="tb_title">중장기사업</td>
								<td class="tb_title">진행상태</td>
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
									
									<td class="left" style="padding-left:30px;"><a href="#" onclick="javascript:goViewProj('${item.project_id }', '${wc}/viewProj.do');">${item.project_name }</a></td>
									<td class="left">${item.plan_name }</td>
									<td class="left">${item.tr_status }</td>
									<td><t:yearMon value="${item.proj_start_month }" /></td>
									<td><t:yearMon value="${item.proj_end_month }" /></td>
									<td style="text-align: right; padding-right: 14px;" ><fmt:formatNumber value="${item.proj_total_budget }" /></td>
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

						
						<t:button href="javascript:addNew('${wc}/formProj.do?tid=reg');" value="신규" auth="admin,AUTHOR_ADMIN,pmsManager" />
						<t:button href="javascript:addNew('${wc}/formProj.do?tid=excelup');" value="Excel 일괄신규" auth="admin,AUTHOR_ADMIN" />

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
		document.formx.action = '${wc}/listProj.do';
		document.formx.submit();
		return false;
	}

	function popPlanSearch() {
		var url = "${wc}/listPlanPop.do?pageUnit=10&curPage=1";
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
						'height=600px,width=680px,menubar=no,toolbar=no,location=no, resizable=yes, status=no,scrollbars=no,top='
								+ py + ',left=' + px);
		searchPlan.focus();
	}

	$(document).ready(	function() {

			jQuery("#excel").click(function() {
					try {
						//alert($("select[name='s_ptype']").val() );
						// $('input:radio[name="s_ptype"]:checked').val()
						var excel_iframe = document	.createElement('iframe');
						excel_iframe.style.display = "none";
						excel_iframe.src = "${wc}/excelDownProj.do?subMethod=excel"
								+ "&s_project_name="
								+ $('#s_project_name').val()
								+ "&s_proj_start_month="
								+ $('#s_proj_start_month').val()
								+ "&s_proj_end_month="
								+ $('#s_proj_end_month').val()
								+ "&s_plan_id="
								+ $('#s_plan_id').val()
								+ "&s_status="
								+ $("select[name='s_status']").val()
								+ "&s_year="
								+ $("select[name='s_year']").val();

						document.body
								.appendChild(excel_iframe);
						excel_iframe.location.load();
					} catch (err) {
					}
			});

/* 			$('#formx').validate({

				rules : {
					s_proj_start_month : {
						yearMonth : true
					},
					s_proj_end_month : {
						yearMonth : true
					}
				},
				messages : {

				}
			}); */

			
			$('div.tb_list > table > tbody > tr').hover(function() {
			    $(this).addClass('hover');
			}, function() {
			    $(this).removeClass('hover');
			});
			
			
			
			$('#s_project_name').attr("readonly",false);
			
			$('div.category').addClass('categoryhelp');
			
			$('div.category').qtip({
				   content: '목록은 기본으로 올해의 데이터만 표시 \
						   <br>됩니다. 검색항목에서 사업년도를 변경하면\
						   <br>이전년도의 자료가 표시됩니다. \
						   <br>검색조건을 초기화 하려면 메뉴를 클릭하십시요.',
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
						   max: 500
					   }
				   }
				});
						
	}); //$(document).ready(function() {
//-->
</script>



<%@include file="/WEB-INF/inc/end.jspf"%>
