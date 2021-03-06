<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>
<style>

/* jquery.ui.theme.css 17 라인 에서 카피. 이유는 UI-TAB 탭과 겹쳐서 수정 불가.
Component containers
----------------------------------*/
.ui-widget { font-family: Lucida Grande,Lucida Sans,Arial,sans-serif; font-size: 1.1em; }
.ui-widget .ui-widget { font-size: 1em; }
.ui-widget input, .ui-widget select, .ui-widget textarea, .ui-widget button { font-family: Lucida Grande,Lucida Sans,Arial,sans-serif; font-size: 1em; }
.ui-widget-content { border: 0px solid #aaaaaa/*{borderColorContent}*/; background: #ffffff/*{bgColorContent}*/ url(images/ui-bg_flat_75_ffffff_40x100.png)/*{bgImgUrlContent}*/ 50%/*{bgContentXPos}*/ 50%/*{bgContentYPos}*/ repeat-x/*{bgContentRepeat}*/; color: #222222/*{fcContent}*/; }
.ui-widget-content a { color: #362b36; }
.ui-widget-header { border: 0px solid #aed0ea; background: #deedf7 /* url(images/ui-bg_highlight-soft_100_deedf7_1x100.png) 50% 50% repeat-x */; color: #222222; font-weight: bold; }
.ui-widget-header a { color: #222222; }

/* Interaction states
----------------------------------*/
.ui-state-default, .ui-widget-content .ui-state-default, .ui-widget-header .ui-state-default { border: 0px solid #aed0ea; background: #d7ebf9 /* url(images/ui-bg_glass_80_d7ebf9_1x400.png) 50% 50% repeat-x */; font-weight: bold; color: #2779aa; }
.ui-state-default a, .ui-state-default a:link, .ui-state-default a:visited { color: #2779aa; text-decoration: none; }
.ui-state-hover, .ui-widget-content .ui-state-hover, .ui-widget-header .ui-state-hover, .ui-state-focus, .ui-widget-content .ui-state-focus, .ui-widget-header .ui-state-focus { border: 0px solid #74b2e2; background: #e4f1fb /* url(images/ui-bg_glass_100_e4f1fb_1x400.png) 50% 50% repeat-x */; font-weight: bold; color: #0070a3; }
.ui-state-hover a, .ui-state-hover a:hover { color: #0070a3; text-decoration: none; }
.ui-state-active, .ui-widget-content .ui-state-active, .ui-widget-header .ui-state-active { border: 0px solid #2694e8; background: #3baae3 /* url(images/ui-bg_glass_50_3baae3_1x400.png) 50% 50% repeat-x */; font-weight: bold; color: #ffffff; }
.ui-state-active a, .ui-state-active a:link, .ui-state-active a:visited { color: #ffffff; text-decoration: none; }


</style>
<!-- ///////////////////오른쪽 내용 영역/////////////////////-->
<!-- contGen +++ start -->
<div id="contGen" class="s_contain">
	<div class="ttl">
		<h2>정보화사업 계약업체관리</h2>
		<div class="category">정보화사업 &gt; 정보화사업 계약업체관리</div>
	</div>
	<table width="910" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="20"></td>
			<td>
				<!-- ********** 여기서 부터 본문 내용 *************** -->
				<form name="formx" id="formx" action="${wc}/system/saveContractor.do" method="post">
					<input name="curPage" id="curPage" type="hidden" value="${param.curPage }" />
					<input name="pageUnit" id="pageUnit" type="hidden" value="${param.pageUnit }" />
					<input name="subMethod" id="subMethod" type="hidden" value="" />

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
										<td class="tb_title" valign="middle"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" align="absmiddle" />&nbsp;업체명 검색</td>
										<td><input name="s_name_search" id="s_name_search" style="width: 69%;" type="text" class="text_left" value="${param.s_name_search}" /></td>
									</tr>
								</table>
							</td>
							<td><a href="javascript:onpagersubmit(1);"><img src="${wc}/eams/images/eams/common/btn_search.gif" alt="검색버튼" width="50" height="21" class="v_mid"
									style="float: right; padding-right: 3px; padding-bottom: 2px;" /></a></td>
						</tr>
					</table>
					<!-- formx end !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  -->
					<!-- </form> -->
					<!--출력수 시작-->
					<table class="board_remark" width="100%">
						<tr>
							<td><span style="find-size: 11px;"><t:totalCnt listName="list" /> </span></td>
							<td class="ar" align="right"></td>
							<td class="ar" width="95"></td>
						</tr>
					</table>
					<!--출력수 끝 -->
					<!-- list -->
					<div class="tb_list">
					
						<div id="exampleGrid" ></div>
						
					</div>
					<!-- list -->
					<!-- button -->
					<div class="btnArea" id="btnArea2">
						<span class="btn"><a href="#" id="createNew" title="신규">신규</a></span>
					</div>

					<!-- button -->

					<!--페이징 시작 -->
					<div class="pagination">
						<t:pager curPage="${param.curPage }" totalCnt="${list[0].totalCnt }" pageRow="${param.pageUnit }" />
					</div>
					<!-- 페이징 끝 -->

					<p style="margin-top: 15px;"></p>

					<div id="contractorInput">
						<div id="contractor_id_span"></div>

						<table width="580" cellpadding="6" cellspacing="0" border="0" class="tb_03">
							<colgroup>
								<col width="25%" />
								<col width="25%" />
								<col width="25%" />
								<col width="25%" />
							</colgroup>
							<tr>
								<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 업체명</td>
								<td colspan="3" width="25%"><input name="contractor_id" id="contractor_id" type="hidden" size="40" value="" maxlength="80" class="input01" /> <input
										name="contractor_name" id="contractor_name" type="text" size="40" value="" maxlength="80" class="input01" /></td>
							</tr>
							<tr>
								<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업자번호</td>
								<td width="25%"><input name="registration_number" id="registration_number" type="text" size="16" value="" maxlength="20" class="input01 essence" /></td>
							</tr>
							<tr>
								<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 연락처</td>
								<td colspan="3" width="25%"><input name="phone" id="phone" type="text" size="20" value="" maxlength="30" class="input01 essence" /></td>

							</tr>
							<tr>
								<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 코드 사용여부</td>
								<td colspan="3" width="75%"><input name="use_yn" id="use_yn" type="radio" value="Y">사용</input> <input name="use_yn" id="use_yn" type="radio" value="N">사용안함</input>
								</td>
							</tr>
						</table>





						<!-- button -->
						<div class="btnArea">

							<span class="btn"><a href="#" id="saveForm" title="저장">저장</a></span> <span class="btn"><a href="javascript:hideThis();" title="취소">취소</a></span>
						</div>
						<!-- button -->



					</div>
					<div id="beforesubmit" style="display: none"></div>
					

					
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

		if (pageNo == 'undefined') {
			pageNo = '1';
		}
		document.formx.curPage.value = pageNo;
		document.formx.action = '${wc}/system/listContractor.do';
		document.formx.submit();
		return false;
	}

	/*  
	 *  취소버튼을 누르면 입력폼이 사라짐. 신규버튼은 다시 보이게 함. 
	 *  로우를 클릭하면 입력판이 생기게 하는 이벤트 핸들러를 다시 등록함.
	 */
	function hideThis() {

		$("#contractorInput").dialog("close");

	}

	$(document).ready(function() {

		$(document).delegate("div.tb_list > table > tbody > tr", 'click', function() {
			$('#contractor_id').val($(this).attr('id'));

			$('#contractor_id_span').attr('class', 'update_contr');
			$('#contractor_id_span').text('수정');

			$('#contractor_name').val($(this).children('td:first').text());
			$('#registration_number').val($(this).children('td:eq(1)').text());
			$('#phone').val($(this).children('td:eq(2)').text());
			// Y N 값에 따라 래디오버튼의 값을 셋팅
			var use = $(this).children('td:eq(3)').text();
			$('input:radio[name=use_yn]:input[value=' + use + ']').attr("checked", true);
			
			$("#contractorInput").dialog("open");
		});

		// 로우에 마우스 후버시 색깔 바꾸기
		$('div.tb_list > table > tbody > tr').hover(function() {
			$(this).addClass('hover');
		}, function() {
			$(this).removeClass('hover');
		});

		$('#formx').validate({
			rules : {
				contractor_name : {
					required : true
				}
			},
			messages : {
				contractor_name : {
					required : "업체명을 입력하십시요."
				}
			}
		});

		$("#contractorInput").dialog({
			autoOpen : false,
			height : 300,
			width : 620,
			modal : true,
			resizable : false,
			title : '거래업체등록',
			close : function() {
				allFields.val("").removeClass("ui-state-error");
			}
		});

		$("#createNew").click(function() {

			$('#contractor_id').val('');
			$('#contractor_id_span').attr('class', 'insert_contr');
			$('#contractor_id_span').text('신규');
			$('#contractor_name').val('');
			$('#registration_number').val('');
			$('#phone').val('');
			// Y로 초기화 
			$('input:radio[name=use_yn]:input[value="Y"]').attr("checked", true);

			$("#contractorInput").dialog("open");
		});

		$("#saveForm").click(function() {

			// 아래 코드가 없으면 submit시 다이어로그 안의 input이 submit 안됨.
			// submit 순간 원래 dom에 옮겨 붙여야 함.
			$("#contractorInput").prependTo("#beforesubmit");

			document.formx.subMethod.value = 'insert';
			document.formx.action = '${wc}/system/saveContractor.do';

			$('#formx').submit(	);
			$("#contractorInput").dialog("close");
		});



		
	        $("#exampleGrid").simplePagingGrid({
	            columnNames: ["업체아이디", "업체명", "연락처"],
	            columnKeys: ["code_id", "code", "code_name"],
	            columnWidths: ["50%", "25%", "25%"],
	            sortable: [true, true, true],
	            initialSortColumn: "code_id",
	            dataUrl: "/pms/xo/listContra.do",
	            minimumVisibleRows : 10,
	            showGotoPage:false,
	            pageRenderedEvent:rr,
	            ajaxError: pp
	        });
				
	        
	        
	        
			// 로우에 마우스 후버시 색깔 바꾸기



	}); // $(document).ready(function()
			
			function pp (event, jqxhr, settings, exception){
		alert(settings);
	}
			function rr (event, jqxhr, settings, exception){
				
				$('table.tb_02 > tbody > tr').hover(function() {
				    $(this).addClass('hover');
				}, function() {
				    $(this).removeClass('hover');
				});
				
				$(document).delegate("table.tb_02 > tbody > tr", 'click', function() {
					$('#contractor_id').val($(this).attr('id'));

					$('#contractor_id_span').attr('class', 'update_contr');
					$('#contractor_id_span').text('수정');

					$('#contractor_name').val($(this).children('td:first').text());
					$('#registration_number').val($(this).children('td:eq(1)').text());
					$('#phone').val($(this).children('td:eq(2)').text());
					// Y N 값에 따라 래디오버튼의 값을 셋팅
					var use = $(this).children('td:eq(3)').text();
					$('input:radio[name=use_yn]:input[value=' + use + ']').attr("checked", true);
					
					$("#contractorInput").dialog("open");
				});
			}

//-->
</script>

<%--   

페이지 상단에 붙일것. 모달 다이어로그 뒤의 화면을 40%투명도로 회색으로 보여준다.

.ui-widget-overlay { 
    background: #aaaaaa  !important;
    opacity: 40 !important;
    filter:Alpha(Opacity=40) !important;  
}



.ui-widget-overlay
{
  opacity: .50 !important; /* Make sure to change both of these, as IE only sees the second one */
  filter: Alpha(Opacity=50) !important;

  background-color: rgb(50, 50, 50) !important; /* This will make it darker */
}



 --%>

<%@include file="/WEB-INF/inc/end.jspf"%>
