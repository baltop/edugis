<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>

<!-- ///////////////////오른쪽 내용 영역/////////////////////-->
<!-- contGen +++ start -->
<div id="contGen" class="s_contain">
	<div class="ttl">
		<h2>정보화사업 코드관리</h2>
		<div class="category">정보화사업 &gt; 정보화사업 코드관리 </div>
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
										<td class="tb_title" valign="middle"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" align="absmiddle" />&nbsp;코드그룹명 검색</td>
										<td><input name="sCodeSearch" id="sCodeSearch" style="width: 69%; " type="text" class="text_left" value="${param.sCodeSearch}" /></td>
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
							<col width="20%" />
							<col width="20%" />
							<col width="20%" />
							<col width="20%" />
							<col width="10%" />
							<col width="10%" />
							<tr>
								<td class="tb_title">코드그룹</td>
								<td class="tb_title">코드그룹명</td>
								<td class="tb_title">코드</td>
								<td class="tb_title">코드값</td>
								<td class="tb_title">순서</td>
								<td class="tb_title">사용여부</td>								
							</tr>
							<c:if test="${fn:length(list) < 1 }">
								<tr>
									<td colspan="5">자료가 없습니다. 다른 검색조건을 선택해주세요.</td>
								</tr>
							</c:if>
							<c:forEach items="${list }" var="item" varStatus="status">
								<tr>
									<td style="text-align: left;padding-left:40px;">${item.codeId }</td>
									<td style="text-align: left; padding-left: 20px;">${item.codeIdName }</td>
									<td>${item.code }</td>
									<td style="text-align: left; padding-left: 20px;">${item.codeName}</td>
									<td style="text-align: right; padding-right: 14px;">${item.sortOrder }</td>
									<td style="text-align: right; padding-right: 14px;">${item.useYn}</td>
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

					<p style="margin-top: 15px;"></p>
					<div id="codeInput" style="display:none;">
					<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
						<colgroup>
							<col width="25%" />
							<col width="25%" />
							<col width="25%" />
							<col width="25%" />
						</colgroup>
						<tr>
							<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 코드그룹 아이디</td>
							<td width="25%">
								<input name="codeId" id="codeId" type="text" size="40" value="" maxlength="6"	class="input01 essence" readOnly="readOnly" style="border:none;"/>
							</td>	
							<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 코드그룹 아이디 명칭</td>
							<td width="25%">
								<input name="codeIdName" id="codeIdName" type="text" size="40" value="" maxlength="60"	class="input01 essence" />
							</td>	
						</tr>
						<tr>
							<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 코드</td>
							<td width="25%">
								<input name="code" id="code" type="text" size="10" value="" maxlength="3"	class="input01 essence" /><br />
								코드아이디를 변경하시면 신규로 등록됩니다. 
							</td>	
							<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 코드 값</td>
							<td width="25%">
								<input name="codeName" id="codeName" type="text" size="40" value="" maxlength="60"	class="input01 essence" />
							</td>	
						</tr>
						<tr>
							<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" />순서</td>
							<td width="25%">
								<input name="sortOrder" id="sortOrder" type="text" size="10" value="" maxlength="10"	class="input01 essence" />
							</td>	
							<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 코드 사용여부</td>
							<td  width="75%">
								<input name="useYn" id="useYn" type="radio" value="Y" >사용</input>
								<input name="useYn" id="useYn" type="radio" value="N" >사용안함</input>
								<input name="registerDate" id="registerDate" type="hidden" value="21/02/1962"/>

							</td>	
						</tr>						
					</table>					
					
					
					<!-- button -->
					<div class="btnArea">

						<span class="btn"><a href="javascript:addNew('${wc}/xo/saveCode.do');" title="저장">저장</a></span>
						<span class="btn"><a href="javascript:hideThis();" title="취소">취소</a></span>
					</div>
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
	function goView(id, url) {

		document.formx.subMethod.value = 'view';
		document.formx.thread_id.value = id;
		document.formx.action = url;
		document.formx.submit();
		return false;
	}

	function onpagersubmit(pageNo) {

		if (!$('#formx').valid()) {
			return;
		}

		if (pageNo == 'undefined') {
			pageNo = '1';
		}
		document.formx.curPage.value = pageNo;
		document.formx.action = '${wc}/xo/listCode.do';
		document.formx.submit();
		return false;
	}

	function hideThis(){
		$('#codeInput').hide();
		
	}
	
	$(document).ready(function() {

		$("div.tb_list > table > tbody > tr").live('click', function() {
			
			$('#codeInput').show();
	        //goView( $(this).attr('id'),$(this).attr('name'));
	        $('#codeId').val( $(this).children('td:first').text() );

	        $('#codeIdName').val( $(this).children('td:eq(1)').text() );

	        
	        $('#code').val(  $(this).children('td:eq(2)').text() );
	        $('#codeName').val( $(this).children('td:eq(3)').text() );
	        $('#sortOrder').val( $(this).children('td:eq(4)').text() );
	        var use = $(this).children('td:eq(5)').text();
	        $('input:radio[name=useYn]:input[value='+use +']').attr("checked",true);
	        
	        var pos=$("#footer").position().top;
			$("html, body").animate({scrollTop:pos},'slow');
	        //get <td> element values here!!??
	    });
		
		$('div.tb_list > table > tbody > tr').hover(function() {
		    $(this).addClass('hover');
		}, function() {
		    $(this).removeClass('hover');
		});

		$('#formx').validate({

			rules : {
				code : {
					required : true
				},
				code_name : {
					required : true
				}
			},
			messages : {
				code : {
					required : "코드를 입력하십시요."
				},
				code_name : {
					required : "코드값을 입력하십시요."
				}
			}
		});
		
		
		
	});
//-->
</script>




<%@include file="/WEB-INF/inc/end.jspf"%>
