<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>
<ol class="breadcrumb">
  <li><a href="#">Home</a></li>
  <li><a href="#">System</a></li>
  <li class="active">코드관리</li>
</ol>

<div class="page-header">
  <h1>코드 관리</h1>
</div>




<!-- ********** 여기서 부터 본문 내용 *************** -->
<form name="formx">
<input name="curPage" id="curPage" type="hidden" value="${param.curPage }" />
<input name="pageSize" id="pageSize" type="hidden" value="${param.pageSize }" />
<input name="subMethod" id="subMethod" type="hidden" value="" />

<div class="row">
  <div class="form-group col-xs-8">
    <input type="text" class="form-control" placeholder="Search">
  </div>
  <div class=" col-xs-4">
    <button type="submit" class="btn btn-default">Submit</button> 
  </div>
</div>

<div>전체건수 <span class="badge"><t:totalCnt listName="list" /></span></div>

<div class="panel panel-default listpanel">
  <!-- Default panel contents -->
  <div class="panel-heading">코드 리스트</div>
  <table class="table"  >
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
  			<td style="text-align: left;padding-left:40px;">${item.code_group }</td>
  			<td style="text-align: left; padding-left: 20px;">${item.code_group_name }</td>
  			<td>${item.code }</td>
  			<td style="text-align: left; padding-left: 20px;">${item.code_name}</td>
  			<td style="text-align: right; padding-right: 14px;">${item.sort_order }</td>
  			<td style="text-align: right; padding-right: 14px;">${item.use_yn}</td>
  			<td style="display:none;text-align: right; padding-right: 14px;">${item.description}</td>
  		</tr>
  	</c:forEach>
  
  </table>
</div>

<!-- list -->


<!--페이징 시작 -->
<div class="row">
<div class="col-xs-8 col-xs-offset-4">
	<t:pager curPage="${param.curPage }" totalCnt="${list[0].totalCnt }" pageRow="${param.pageSize }" />
</div>
</div>



<!-- hidden area -->
<div id="codeInput" style="display:none;">
  <div class="panel panel-default inputpanel">
	<table class="table">
		<colgroup>
			<col width="25%" />
			<col width="25%" />
			<col width="25%" />
			<col width="25%" />
		</colgroup>
		<tr id="header">
			<td class="td_title" width="25%">코드그룹</td>
			<td width="25%">
				<input name="code_group" id="code_group" type="text" value="" maxlength="6"	class="input01 essence" readOnly="readOnly" style="border:none;"/>
			</td>
      </tr><tr>
			<td class="td_title" width="25%"> 코드그룹 명칭</td>
			<td width="25%">
				<input name="code_group_name" id="code_group_name" type="text" value="" maxlength="60"	class="input01 essence" />
			</td>	
		</tr>
		<tr>
			<td class="td_title" width="25%"> 코드</td>
			<td width="25%">
				<input name="code" id="code" type="text" value="" maxlength="3"	class="input01 essence" /><br />
				코드아이디를 변경하시면 신규로 등록됩니다. 
			</td>	
	</tr><tr>	
    	<td class="td_title" width="25%"> 코드 값</td>
			<td width="25%">
				<input name="code_name" id="code_name" type="text" value="" maxlength="60"	class="input01 essence" />
			</td>	
		</tr>
		<tr>
			<td class="td_title" width="25%">순서</td>
			<td width="25%">
				<input name="sort_order" id="sort_order" type="text" value="" maxlength="10"	class="form-control" />
			</td>	
		</tr><tr>	
      <td class="td_title" width="25%"> 코드 사용여부</td>
			<td  width="75%">
				<input name="use_yn" id="use_yn" type="radio" value="Y" >사용</input>
				<input name="use_yn" id="use_yn" type="radio" value="N" >사용안함</input>
			</td>	
		</tr>			
		<tr>
			<td class="td_title" width="25%"> 코드 설명</td>
			<td >
				<input name="description" id="description" type="text" value="" maxlength="3000" class="form-control"/><br />
			</td>	

		</tr>
	</table>	
			
  </div>
  <div class="form-horizontal">
    
    <input name="search" id="search" class="form-control"/>
    <label>코드 설명</label>
  </div>
</form> <!-- ********** 여기까지 내용 *************** -->
  
  

    <form class="form-horizontal">
        <div class="form-group">
            <label for="inputEmail" class="control-label col-xs-2">Email</label>
            <div class="col-xs-10">
                <input type="email" class="form-control" id="inputEmail" placeholder="Email">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-2">Password</label>
            <div class="col-xs-10">
                <input type="password" class="form-control" id="inputPassword" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <div class="checkbox">
                    <label><input type="checkbox"> Remember me</label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
        </div>
    </form>

  
  
  
  
  
  
  
  
  
  
  
  
  
  <div class="btn-group">
	<button type="button" class="btn btn-default" id="saveButton">저장</button>
	<button type="button" class="btn btn-default" id="cancelButton">취소</button>
  </div>	

</div>
<!-- hidden area -->




<script type="text/javascript">

	function onpagersubmit(pageNo) {


		if (pageNo == 'undefined') {
			pageNo = '1';
		}
		document.formx.curPage.value = pageNo;
		document.formx.action = '${wc}/system/listCode.do';
		document.formx.submit();
		return false;
	}

	
	$(document).ready(function() {

		
		$("div.listpanel > table > tbody > tr").on('click', function() {
			if( this.rowIndex ==0){
				return;
			};
			
			$('#codeInput').show();
	        //goView( $(this).attr('id'),$(this).attr('name'));
	        $('#code_group').val( $(this).children('td:first').text() );
	        $('#code_group_name').val( $(this).children('td:eq(1)').text() );
	        
	        $('#code').val(  $(this).children('td:eq(2)').text() );
	        $('#code_name').val( $(this).children('td:eq(3)').text() );

	        $('#sort_order').val( $(this).children('td:eq(4)').text() );
	        $('#description').val( $(this).children('td:eq(6)').text() );
	        var use = $(this).children('td:eq(5)').text();
	        $('input:radio[name=use_yn]:input[value='+use +']').attr("checked",true);
	        
	        var pos=$("#footer").position().top;
			$("html, body").animate({scrollTop:pos},'slow');
	        
	    });
		
		$('div.listpanel > table > tbody > tr').hover(function() {
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
		
		$('#saveButton').on('click', function(){
			$('#codeInput').hide();
		});
		
		$('div.category').addClass('categoryhelp');
		
		$('div.category').qtip({
			   content: '정보화사업시스템 코드 관리 페이지임. \
					   <br>EA 관리자 권한이 있는 경우에 수정이 \
					   <br>가능함. 코드의 경우는 신규나 삭제가 \
					   <br>불가하고 사용안함으로 수정해야 함.  \
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
		
	}); // document ready

</script>

<%@include file="/WEB-INF/inc/end.jspf"%>
