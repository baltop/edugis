<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>

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
				<form name="formx" id="formx" action="" method="post">
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
										<td><input name="s_name_search" id="s_name_search" style="width: 69%; " type="text" class="text_left" value="${param.s_name_search}" /></td>
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
							<td class="ar" width="95">
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
							<tr>
								<td class="tb_title">업체명</td>
								<td class="tb_title">사업자번호</td>
								<td class="tb_title">연락처</td>

								<td class="tb_title">사용여부</td>								
							</tr>
							<c:if test="${fn:length(list) < 1 }">
								<tr>
									<td colspan="5">자료가 없습니다. 다른 검색조건을 선택해주세요.</td>
								</tr>
							</c:if>
							<c:forEach items="${list }" var="item" varStatus="status">
								<tr id="${item.contractor_id }">
									<td style="text-align: left;padding-left:40px;">${item.contractor_name }</td>
									<td style="text-align: left; padding-left: 20px;">${item.registration_number }</td>
									<td>${item.phone }</td>

									<td style="text-align: right; padding-right: 14px;">${item.use_yn}</td>
								</tr>
							</c:forEach>

						</table>
					</div>
					<!-- list -->
					<!-- button -->
					<div class="btnArea"  id="btnArea2">
						<span class="btn"><a href="javascript:newContractor();" title="신규">신규</a></span>
					</div>

					<!-- button -->

					<!--페이징 시작 -->
					<div class="pagination">
						<t:pager curPage="${param.curPage }" totalCnt="${list[0].totalCnt }" pageRow="${param.pageUnit }" />
					</div>
					<!-- 페이징 끝 -->

					<p style="margin-top: 15px;"></p>
					
					<div id="contractorInput" style="display:none;">
					<div id="contractor_id_span"  ></div>
					<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
						<colgroup>
							<col width="25%" />
							<col width="25%" />
							<col width="25%" />
							<col width="25%" />
						</colgroup>
						<tr >
							<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 업체명</td>
							<td colspan="3" width="25%">
								<input name="contractor_id" id="contractor_id" type="hidden" size="40" value="" maxlength="80"	class="input01" />
								
								<input name="contractor_name" id="contractor_name" type="text" size="40" value="" maxlength="80"	class="input01" />
							</td>	
						</tr>
						<tr>
							<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업자번호</td>
							<td width="25%">
								<input name="registration_number" id="registration_number" type="text" size="16" value="" maxlength="20"	class="input01 essence" />
							</td>	
						</tr>
						<tr>
							<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 연락처</td>
							<td colspan="3" width="25%">
								<input name="phone" id="phone" type="text" size="20" value="" maxlength="30"	class="input01 essence" />
							</td>	

						</tr>
						<tr>
							<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 코드 사용여부</td>
							<td colspan="3" width="75%">
								<input name="use_yn" id="use_yn" type="radio" value="Y" >사용</input>
								<input name="use_yn" id="use_yn" type="radio" value="N" >사용안함</input>
							</td>	
						</tr>						
					</table>					
					
					
					<!-- button -->
					<div class="btnArea">

						<span class="btn"><a href="javascript:addNew('${wc}/system/saveContractor.do');" title="저장">저장</a></span>
						<span class="btn"><a href="javascript:hideThis();" title="취소">취소</a></span>
					</div>

					<!-- button -->
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
		document.formx.action = '${wc}/system/listContractor.do';
		document.formx.submit();
		return false;
	}


	/*  
	 *  취소버튼을 누르면 입력폼이 사라짐. 신규버튼은 다시 보이게 함. 
	 *  로우를 클릭하면 입력판이 생기게 하는 이벤트 핸들러를 다시 등록함.
	 */
	function hideThis(){
		$('#btnArea2').show();
		$('#contractorInput').hide();
		$(document).delegate( "div.tb_list > table > tbody > tr" , 'click', update_contractor);
	}
	
	/*  
	 *  신규버튼을 누르면 신규버튼을 감추고 입력 폼을 보여줌.
	 *  각 폼 인풋은 초기화 해주어야 함. 그렇지 않으면 이전에 로우를 
	 *  클릭하여 인풋에 보관된 내용이 보임.
	 */
	function newContractor(){
		$('#btnArea2').hide();
		$('#contractorInput').show();

		$('#contractor_id').val('' );
		$('#contractor_id_span').attr('class', 'insert_contr');
        $('#contractor_id_span').text('신규');
        $('#contractor_name').val( '' );
        $('#registration_number').val( '' );
        $('#phone').val(  '' );
        // Y로 초기화 
        $('input:radio[name=use_yn]:input[value="Y"]').attr("checked",true);
        // 상단의 테이블의 로우를 클릭하면 위의 데이터가 인풋폼에 자동으로 복사되는데 그것을 방지함.
        // 방지 안하면 신규인지 업데이트인지 헷갈히게 됨. 
        $("div.tb_list > table > tbody > tr").die("click");
	    // $(document).delegate( "div.tb_list > table > tbody > tr" , 'click', function(){return false;});
	    // 최신버전의 jquery는 live()  die() 대신에 on() off()를 사용하도록 권장함.
	    // http://api.jquery.com/live/
	    
	    // 화면에 입력판이 하단에 표시되는데 알보일 경우에 대비하여 화면을 제일 아래로 내려보냄.
        var pos=$("#footer").position().top;
		$("html, body").animate({scrollTop:pos},'slow'); 
		
		
	}
	
	
	/*  
	 *  Row를 클릭하여 수정 모드로 들어감.
	 *  각 폼 인풋은 click한 tr 아래의 td의 값으로 채워짐.
	 */
	 function update_contractor() {
			
			$('#btnArea2').hide();
			$('#contractorInput').show();

			$('#contractor_id').val( $(this).attr('id') );
			
			$('#contractor_id_span').attr('class', 'update_contr');
	        $('#contractor_id_span').text('수정');
	        
	        $('#contractor_name').val( $(this).children('td:first').text() );
	        $('#registration_number').val( $(this).children('td:eq(1)').text() );
	        $('#phone').val(  $(this).children('td:eq(2)').text() );
			// Y N 값에 따라 래디오버튼의 값을 셋팅
	        var use = $(this).children('td:eq(3)').text();
	        $('input:radio[name=use_yn]:input[value='+use +']').attr("checked",true);
	        // 다시 상단의 테이블 로우를 클릭하여 값을 가져오는 기능을 중지시킴.
	        // 다른 것을 수정하려면 취소버튼을 눌러야 함.
	        $("div.tb_list > table > tbody > tr").die("click");
	        // 제일 하단으로 내려감.
	        var pos=$("#footer").position().top;
			$("html, body").animate({scrollTop:pos},'slow'); 
			// 폼 발리데이션을 다시 함. 안하면 이전의 에러가 그냥 보임.
			$('#formx').valid();
	 }
	
	
	$(document).ready(function() {

		
		$(document).delegate( "div.tb_list > table > tbody > tr" , 'click', update_contractor);
		// live() 대신 delegate를 써야함. 최종적으로 jquery 1.7 이후에는 on()을 권장함.
		// $("div.tb_list > table > tbody > tr").on('click', update_contractor);
		
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
		
		

		
	});   // $(document).ready(function() 
			
			

			
//-->
</script>



<%@include file="/WEB-INF/inc/end.jspf"%>
