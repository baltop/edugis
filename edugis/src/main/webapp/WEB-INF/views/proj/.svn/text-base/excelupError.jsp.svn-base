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
		<input type="hidden" name="pageUnit" id="pageUnit" value="${param.pageUnit }" />
		<input type="hidden" id="subMethod" name="subMethod" value="${param.subMethod }" />

		<input type="hidden" id="tid" name="tid" value="${param.tid}" />

		<!-- 서치조건  -->
		<input type="hidden" name="s_project_name" id="s_project_name" value="${param.s_project_name }" />
		<input type="hidden" name="s_proj_start_month" id="s_proj_start_month" value="${param.s_proj_start_month }" />
		<input type="hidden" name="s_proj_end_month" id="s_proj_end_month" value="${param.s_proj_end_month }" />
		<input type="hidden" name="s_status" id="s_status" value="${param.s_status }" />
		<input type="hidden" name="s_year" id="s_year" value="${param.s_year }" />
		<input type="hidden" name="s_plan_id" id="s_plan_id" value="${param.s_plan_id }" />
		<input type="hidden" name="s_plan_name" id="s_plan_name" value="${param.s_plan_name }" />




		<c:if test="${errorStatus =='yes' }">
		<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
			<colgroup>
				<col width="25%" />
				<col width="75%" />

			</colgroup>

			<tr>

				<td width="25%" class="td_title" ><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 엑셀업로드 중 다음 에러가 발생했습니다.</td>
				<td>엑셀파일을 수정한 후 다시 업로드 하십시요.</td>
			</tr>


			<tr>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" />엑셀 열 번호</td>
				<td > 에러내용
				</td>
			</tr>
			<c:forEach items="${errorList}" var="error">			
			<tr>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" />  ${error.errorRow }</td>
				<td >

					${error.errorDesc }

				</td>
			</tr>	
			</c:forEach>
		</table>
		</c:if>
		<c:if test="${errorStatus == 'no' }">
		<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
			<colgroup>
				<col width="25%" />
				<col width="75%" />

			</colgroup>

			<tr>

				<td width="25%" class="td_title" ><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 엑셀업로드</td>
				<td>엑셀파일을 성공적으로 업로드 하였습니다.</td>
			</tr>


			<tr>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" />엑셀 열 번호</td>
				<td > 처리내용
				</td>
			</tr>
			<c:forEach items="${errorList}" var="error">			
			<tr>
				<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" />  ${error.errorRow }</td>
				<td >

					${error.errorDesc }

				</td>
			</tr>	
			</c:forEach>
		</table>		
		</c:if>
		
		
		
		
		<!-- 여백 -->
		<div class="btnArea">
		
			<span class="btn"><a href="javascript:goList('${wc}/listProj.do');">목록</a></span>
		</div>

	</form>
</div>
<!-- contGen +++ end -->
<!-- ///////////////////오른쪽 내용 영역/////////////////////-->







<script type="text/javascript">
<!--


	
	
	function fn_insert() {
		
		if( document.formx.file_0.value == "" ){
			alert('업로드할 엑세파일을 선택하십시요.');
			return;
		}
		var filename = document.formx.file_0.value;
		
  		if( 0 > filename.indexOf('.xls')  ){
			alert('엑셀파일만 업로드 가능합니다.');
			return;
		}  

		if (confirm('<spring:message code="common.regist.msg" />')) {
			document.formx.action = "<c:url value='saveExcel.do'/>";
			document.formx.submit();
		}

	}

	$(document).ready(function() {

		$('#formx').validate({

			rules : {

				proj_start_month : {
					yearMonth : true
				},
				proj_end_month : {
					yearMonth : true,
					yearMonthEnd : true
				},
				project_name : {
					required : true,
					minlength : 3,
				    remote: {
				          url: "${wc}/checkProjectName.do",
				          type: "post",
				          data: {
				            project_name : function() {
				              return $( "#project_name" ).val();
				            },
				            project_id : function() {
					              return $( "#project_id" ).val();
					        }
				          }
				    }					
				}
			},
			messages : {
				project_name : {
					required : "명칭을 입력하시오.",
					minlength : jQuery.format("명칭은 {0}자 이상"),
					remote : "같은 이름의 연간계획이 있습니다."					
				},
				proj_start_month : {
					required : "사업시작년월을 입력하십시요."

				},
				proj_end_month : {
					required : "사업종료년월을 입력하십시요."
				}	
			}
		});

	});
//-->
</script>




<%@include file="/WEB-INF/inc/end.jspf"%>
