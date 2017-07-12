<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>


<!-- ///////////////////오른쪽 내용 영역/////////////////////-->
<!-- contGen +++ start -->
<div id="contGen" class="s_contain">
	<div class="ttl">
		<h2>정보화사업 게시판</h2>
		<div class="category">정보화사업 &gt; 정보화사업게시판</div>
	</div>

	<form name="formx" id="formx" action="" method="post"  enctype="multipart/form-data">
		<input name="curPage" type="hidden" value="${param.curPage}" />
		<input name="pageUnit" id="pageUnit" type="hidden" value="${param.pageUnit }" />
		<input name="subMethod" type="hidden" value="${param.subMethod }" />

		<!--  검색조건  -->
		<input name="s_thread_search" type="hidden" value="${param.s_thread_search }" />
		<input name="s_ptype" type="hidden" value="${param.s_ptype }" />

		<input name="thread_id" type="hidden" value="${item.thread_id }" />
		<input name="bbs_id" id="bbs_id" type="hidden" value="${param.bbs_id}" />

		<table width="910" cellpadding="6" cellspacing="0" border="0" class="tb_03">
			<colgroup>
				<col width="25%" />
				<col width="25%" />
				<col width="25%" />
				<col width="25%" />
			</colgroup>
			<tr>
				<td class="td_title" ><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 글제목</td>
				<td colspan="3"><input name="thread_title" id="thread_title" type="text" size="60" value="${item.thread_title }" maxlength="100" class="input01" /></td>
			</tr>
			<c:if test="${param.subMethod=='view' }">
			<tr>
				<td class="td_title" ><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 작성일</td>
				<td  ><input name="thread_title" id="thread_title" type="text" size="20" value="${item.register_date }" maxlength="100" class="input01" /></td>
				<td class="td_title" ><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 작성자</td>
				<td ><input name="thread_title" id="thread_title" type="text" size="20" value="${item.tr_register_id }" maxlength="100" class="input01" /></td>				
			</tr>

			</c:if>
			<tr>
				<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 본문</td>
				<td colspan="3"><textarea id="thread" name="thread" class="textarea01" cols="75" rows="15" style="width: 660px; font-size: 9pt; ">${item.thread}</textarea>
				</td>
			</tr>
			<t:fileup value="첨부파일" id="gg" />
		</table>
		<!-- 여백 -->
		<div class="btnArea">
			<c:if test="${param.subMethod=='view' }">
				<t:button href="javascript:updateItem('${wc }/system/formBbs.do');" value="수정" auth="admin,AUTHOR_ADMIN" />
				<t:button href="javascript:deleteItem('${wc }/system/deleteBbs.do');" value="삭제" auth="admin,AUTHOR_ADMIN" />
				<span class="btn"><a href="javascript:goList('${wc}/system/listBbs.do');">목록</a></span>
			</c:if>
			<c:if test="${param.subMethod=='insert'}">
				<span class="btn"><a href="javascript:fn_insert();">저장</a></span>
				<span class="btn"><a href="javascript:goList('${wc }/system/listBbs.do');">취소</a></span>
				<span class="btn"><a href="javascript:goList('${wc }/system/listBbs.do');">목록</a></span>
			</c:if>
			<c:if test="${ param.subMethod=='update'}">
				<span class="btn"><a href="javascript:fn_insert();">저장</a></span>
				<span class="btn"><a href="javascript:goView('${item.thread_id }', '${wc }/system/viewBbs.do');">취소</a></span>
				<span class="btn"><a href="javascript:goList('${wc }/system/listBbs.do');">목록</a></span>
			</c:if>			
		</div>

	</form>
</div>
<!-- contGen +++ end -->
<!-- ///////////////////오른쪽 내용 영역/////////////////////-->








<script type="text/javascript">
<!--

	function goView(id, url) {
	
		document.formx.subMethod.value = 'view';
		document.formx.action = url;
		document.formx.submit();
		return false;
	}

	function fn_insert() {

		if (!$('#formx').valid()) {
			return;
		}

		if (confirm('<spring:message code="common.regist.msg" />')) {
			document.formx.subMethod.value = 'view';
			document.formx.action = "<c:url value='/system/saveBbs.do'/>";
			document.formx.submit();
		}

	}
	
	$(document).ready(function() {

		$('#formx').validate({

			rules : {
				thread_title : {
					required : true,
					minlength : 3
				},
				thread : {
					required : true
				}
			},
			messages : {
				thread_title : {
					required : "제목을 입력하십시요.",
					minlength : jQuery.format("제목은 {0}자 이상")
				},
				thread : {
					required : "본문을 입력하십시요."

				}
			}
		});

	});
	
//-->
</script>


<%@include file="/WEB-INF/inc/end.jspf"%>
