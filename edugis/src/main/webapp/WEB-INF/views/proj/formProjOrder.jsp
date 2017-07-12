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


		<input type="hidden" id="order_staff_id" name="order_staff_id" value="${item.order_staff_id}" />
		<input type="hidden" id="order_dept_id" name="order_dept_id" value="${item.order_dept_id}" />
		<!-- 서치조건  -->
		<input type="hidden" name="s_project_name" id="s_project_name" value="${param.s_project_name }" />
		<input type="hidden" name="s_proj_start_month" id="s_proj_start_month" value="${param.s_proj_start_month }" />
		<input type="hidden" name="s_proj_end_month" id="s_proj_end_month" value="${param.s_proj_end_month }" />
		<input type="hidden" name="s_status" id="s_status" value="${param.s_status }" />
		<input type="hidden" name="s_year" id="s_year" value="${param.s_year }" />
		<input type="hidden" name="s_plan_id" id="s_plan_id" value="${param.s_plan_id }" />
		<input type="hidden" name="s_plan_name" id="s_plan_name" value="${param.s_plan_name }" />





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
				<col width="25%" />
				<col width="25%" />
				<col width="25%" />
			</colgroup>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업공고명칭</td>
				<td colspan="3"><input name="proj_order_name" id="proj_order_name" type="text" size="60" value="${item.proj_order_name }" maxlength="100" class="input01 essence" /></td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업발주일</td>
				<td colspan="3"><input name="order_date" id="order_date" type="text" size="12" value="<t:dispDate value="${item.order_date }"/>" maxlength="12"
						class="input01 essence" readOnly="readonly" /></td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 발주방법</td>
				<td colspan="3"><t:radiobox codeId="order" name="order_type" checkValue="${item.order_type }" defaultCheck="001" /></td>
			</tr>
			<tr>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 발주주관부서</td>
				<td width="25%"><input name="order_dept" id="order_dept" type="text" size="30" value="${item.order_dept }" maxlength="80" class="input01 essence"  readonly="readonly" /></td>
				</td>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 발주담당자</td>
				<td width="25%"><input name="order_staff_name" id="order_staff_name" type="text" size="10" value="${item.order_staff_name }" maxlength="80"
						class="input01 essence"  readonly="readonly"  />
						<img src="${wc}/img/btn_find02.gif" align="absmiddle" onclick="javascript:popUsersSearch();" /><label class="error" id="order_users_id_error"></td>
			</tr>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 발주 관련자료</td>
				<td>
					<table style="border: 0px; border-bottom: 0px; border-top: 0px; width: 100%;">
						<c:forEach items="${files}" var="file">
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




<script type="text/javaScript">
<!--

	/*
	CalAddCss(); // !!제일 상단에 필수!!
		id		:텍스트박스Id   // *필수
		type	:day,mon	    // 둘중 하나입력		,기본값> 일달력 출력
		minYear :xxxx			// 최소년도 4자리 입력	,기본값> 2000
		maxYear :xxxx  			// 최대년도 4자리 입력	,기본값> 현재년도
		splitKey:'-','/'		// 달력 구분값        	,기본값> '-'
		todayYN :'y','n'		// today 표시         	,기본값> 안보여주기
		iconYN  :'y','n'		// 달력그림표시여부	  	,기본값> 안보여주기
		iconUrl :fullUrl 혹은 해당위치 상대경로 url'	,기본값> jquery 사이트 달력
		initCal({
			id : "order_date",
			type : "day",
			today : "y",
			icon : "y"
		});
			
	 */


		
//-->
</script>


<script type="text/javascript">
<!--
	function popPlanView() {
		var url = "${wc}/viewPlan.do?subMethod=viewPop&plan_id="
				+ document.formx.plan_id.value;

		var sw = screen.availWidth;
		var sh = screen.availHeight;
		var px = (sw - 680) / 2;
		var py = (sh - 480) / 2;
		var viewPlan = window
				.open(
						url,
						'searchPlan',
						'height=420px,width=960px,menubar=no,toolbar=no,location=no, resizable=yes, status=no,scrollbars=yes,top='
								+ py + ',left=' + px);
		viewPlan.focus();
	}

	function popUsersSearch() {
		
		var url = "${wc}/listUsersPop.do?pageUnit=10&curPage=1";
		/*		var openParam = "resizable: 0; scroll: 1; center: 1; scroll: no; dialogHeight:520px; dialogWidth:820px; ";
		window.showModalDialog(url,"p_tmplatInqire", openParam);  */
		var sw = screen.availWidth;
		var sh = screen.availHeight;
		var px = (sw - 580) / 2;
		var py = (sh - 480) / 2;
		var searchPlan = window
				.open(
						url,
						'searchPlan',
						'height=520px,width=580px,menubar=no,toolbar=no,location=no, resizable=yes, status=no,scrollbars=no,top='
								+ py + ',left=' + px);
		searchPlan.focus();
	
	}
	
	function users_name_change(id, name, dept, dept_id) {
		if (id == '') {

		} else {
			$("#order_staff_id").val(id);
			$("#order_dept_id").val(dept_id);
			$("#order_dept").val(dept);
			$("#order_staff_name").val(name);
		}
	}


	function fn_insert() {

		if (!$('#formx').valid()) {
			return;
		}
		document.formx.order_date.value = document.formx.order_date.value
				.replace(/-/g, "");
		if (confirm('<spring:message code="common.regist.msg" />')) {
			document.formx.action = "<c:url value='saveProj.do'/>";
			document.formx.submit();
		}

	}

	$(document).ready(function() {
		

		
/* 		jQuery.datepicker.setDefaults({
			buttonImageOnly : true,
			buttonText : "달력",
			showButtonPanel : true,
			showMonthAfterYear : true,
			changeMonth : true,
			changeYear : true,
			yearSuffix : '',
			monthNames : [ '01', '02', '03', '04', '05', '06', '07',
					'08', '09', '10', '11', '12' ],
			monthNamesShort : [ '01', '02', '03', '04', '05', '06',
					'07', '08', '09', '10', '11', '12' ],
			buttonImage : "${wc}/img/calendar.gif"
		}); */
		
	    $('#order_date').datepicker( {
	        changeMonth: true,
	        changeYear: true,
	        showButtonPanel: true,
	        dateFormat: 'yy-MM-dd',
	        buttonText : "달력",
			monthNames : [ '01', '02', '03', '04', '05', '06', '07',
							'08', '09', '10', '11', '12' ],
					monthNamesShort : [ '01', '02', '03', '04', '05', '06',
							'07', '08', '09', '10', '11', '12' ],
	            showOn: "button",
	            buttonImage: "img/calendar.gif",
	            buttonImageOnly: false
	    });
		
	    $('#order_date').datepicker('setDate', new Date());

		$('#formx').validate({

			rules : {
				proj_order_name : {
					required : true,
					minlength : 3,
				    remote: {
				          url: "${wc}/checkProjectOrderName.do",
				          type: "post",
				          data: {
				        	  proj_order_name : function() {
				              return $( "#proj_order_name" ).val();
				            },
				            project_id : function() {
					              return $( "#project_id" ).val();
					        }
				          }
				    }					
				},
				order_date : {
					required : true
				}
			},
			messages : {
				proj_order_name : {
					required : "공고명을 입력하시오.",
					minlength : jQuery.format("공고명은 {0}자 이상"),
					remote : "같은 이름의 발주공고명이 있습니다."			
				},
				order_date : {
					required : "발주일을 입력하시오."
				}				
			}
		});
		
		$('div.category').addClass('categoryhelp');
		
		$('div.category').qtip({
			   content: '발주공고명은 변경할 수 있습니다.. \
					   <br>변경시 이후 단계에서는 변경된 사업명이 표시됩니다. \
					   <br>발주공고명도 다른 발주 공고와 같은 명칭을 쓸수 없습니다.\
					   <br>연간시행계획 기안자와 발주 담당자가 다를 경우 다르게\
					   <br>지정할 수 있습니다. \
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
					   max: 600
				   }
			   }
			});

		

	});
//-->
</script>




<%@include file="/WEB-INF/inc/end.jspf"%>
