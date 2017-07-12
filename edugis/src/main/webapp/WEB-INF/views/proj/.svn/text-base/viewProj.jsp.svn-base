<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>


<!-- ///////////////////오른쪽 내용 영역/////////////////////-->
<!-- contGen +++ start -->
<div id="contGen" class="s_contain">
	<div class="ttl">
		<h2>연간시행계획</h2>
		<div class="category">정보화사업 &gt; 연간시행계획</div>
	</div>

	<form name="formx" id="formx" action="" method="post">
		<input type="hidden" name="curPage" id="curPage" value="${param.curPage}" />
		<input name="pageUnit" id="pageUnit" type="hidden" value="${param.pageUnit }" />
		<input type="hidden" name="subMethod" id="subMethod" value="update" />
		<input type="hidden" name="project_id" id="project_id" value="${item.project_id }" />
		<input type="hidden" name="plan_id" id="plan_id" value="${item.plan_id }" />


		<input type="hidden" name="s_project_name" id="s_project_name" value="${param.s_project_name }" />
		<input type="hidden" name="s_proj_start_month" id="s_proj_start_month" value="${param.s_proj_start_month }" />
		<input type="hidden" name="s_proj_end_month" id="s_proj_end_month" value="${param.s_proj_end_month }" />
		<input type="hidden" name="s_status" id="s_status" value="${param.s_status }" />
		<input type="hidden" name="s_year" id="s_year" value="${param.s_year }" />
		<input type="hidden" name="s_plan_id" id="s_plan_id" value="${param.s_plan_id }" />
		<input type="hidden" name="s_plan_name" id="s_plan_name" value="${param.s_plan_name }" />

		<img alt="status" src="${wc }/img/status.png" style="margin-left:7px;">

		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">연간시행계획</a></li>
				<li><a href="#tabs-2">계획검토(EA)</a></li>
				<li><a href="#tabs-3">예산관리</a></li>
				<li><a href="#tabs-4">발주관리</a></li>
				<li><a href="#tabs-5">발주검토(EA)</a></li>
				<li><a href="#tabs-6">계약관리</a></li>
				<li><a href="#tabs-7">수행관리</a></li>
				<li><a href="#tabs-8">산출물관리</a></li>
			</ul>
			<!-- ############################################################################################################# -->
			<!-- 계획관리 -->
			<div id="tabs-1">
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
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 예상사업비용</td>
						<td colspan="3">
							<table style="width: 40%;">
								<tr>
									<td style="width: 50%; text-align: right; padding-right: 20px;">기획비용</td>
									<td style="width: 50%; text-align: right; padding-right: 20px;"><fmt:formatNumber value="${item.planning_cost }" />&nbsp;백만원</td>
								</tr>
								<tr>
									<td style="width: 50%; text-align: right; padding-right: 20px;">구축비용</td>
									<td style="width: 50%; text-align: right; padding-right: 20px;"><fmt:formatNumber value="${item.construction_cost }" />&nbsp;백만원</td>
								</tr>
								<tr>
									<td style="width: 50%; text-align: right; padding-right: 20px;">운영/유지보수비용</td>
									<td style="width: 50%; text-align: right; padding-right: 20px;"><fmt:formatNumber value="${item.operation_cost }" />&nbsp;백만원</td>
								</tr>
								<tr>
									<td style="width: 50%; text-align: right; padding-right: 20px;">지원비용</td>
									<td style="width: 50%; text-align: right; padding-right: 20px;"><fmt:formatNumber value="${item.supporting_cost }" />&nbsp;백만원</td>
								</tr>
								<tr>
									<td style="width: 50%; text-align: right; padding-right: 20px; background-color: #D7DEE0;">총사업비용</td>
									<td style="width: 50%; text-align: right; padding-right: 20px;"><fmt:formatNumber value="${item.proj_total_budget }" />&nbsp;백만원</td>
								</tr>
							</table>

						</td>
					</tr>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 예산확정 여부</td>
						<td colspan="3"><t:radiobox codeId="bdg_yn" name="budget_decision_ynr" checkValue="${item.budget_decision_yn }" defaultCheck="N" readOnly="yes" /></td>
					</tr>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 시행계획 설명</td>
						<td colspan="3"><textarea id="project_desc" name="project_desc" class="" cols="75" rows="5" style="width: 660px; height: 100px; font-size: 9pt;"
								readonly="readonly">${item.project_desc}</textarea></td>
					</tr>
					<tr>
						<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업주관부서</td>
						<td width="25%">${item.staff_dept }</td>
						<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업담당자</td>
						<td width="25%">${item.staff_position }&nbsp;&nbsp;${item.staff_name }</td>
					</tr>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 연간시행계획 진행단계</td>
						<td colspan="3">${item.tr_status }</td>
					</tr>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업관련자료</td>
						<td colspan="3"><c:if test="${fn:length(regFiles) > 0 }">
								<table style="border: 0px; border-bottom: 0px; border-top: 0px; width: 100%;">
									<c:forEach items="${regFiles}" var="file">
										<tr>
											<td style="border: 0px;"><a href="javascript:fn_egov_downFile('${file.file_id }')"> ${file.file_name }&nbsp;[<fmt:formatNumber
														value="${file.file_size }" />&nbsp;byte]
											</a></td>
										</tr>
									</c:forEach>


									<div id="idxFileDelMsg"></div>
								</table>
							</c:if> <c:if test="${fn:length(regFiles) < 1 }">
										첨부파일이 없습니다.
										</c:if></td>
					</tr>
				</table>
				<!-- 여백 -->
				<div class="btnArea">
					<t:button href="javascript:updateItem('${wc}/formProj.do?tid=reg');" value="수정"  auth="admin,AUTHOR_ADMIN,pmsManager" deptOption="${item.staff_dept_id }"/>
					<t:button href="javascript:deleteItem('${wc}/deleteProj.do?tid=reg');" value="삭제" auth="admin,AUTHOR_ADMIN,pmsManager" deptOption="${item.staff_dept_id }"/>
					<span class="btn"><a href="javascript:goList('${wc}/listProj.do');">목록</a></span>
				</div>
			</div>


			<!-- ############################################################################################################# -->
			<!-- 계획 검토 관리 -->
			<div id="tabs-2" class="eacheck">
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

				<c:if test="${fn:length(reviewList) > 0 }">
					<c:forEach items="${reviewList}" var="reviewItem" varStatus="status">
						<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
							<colgroup>
								<col width="25%" />
								<col width="75%" />
							</colgroup>
							<tr>
								<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 시행계획 검토 항목</td>
								<td>${reviewItem.review_title }</td>
							</tr>
							<tr>
								<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 시행계획 검토내역</td>
								<td><textarea id="review_content" name="review_content" class="" cols="75" rows="5" style="width: 660px; height: 100px; font-size: 9pt;"
										readonly>${reviewItem.review_content}</textarea></td>
							</tr>

							<tr>
								<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업관련자료</td>
								<td><c:if test="${fn:length(reviewItem.files) > 0 }">
										<table style="border: 0px; border-bottom: 0px; border-top: 0px; width: 100%;">
											<c:forEach items="${reviewItem.files}" var="file">
												<tr>
													<td style="border: 0px;"><a href="javascript:fn_egov_downFile('${file.file_id }')"> ${file.file_name }&nbsp;[<fmt:formatNumber
																value="${file.file_size }" />&nbsp;byte]
													</a></td>
												</tr>
											</c:forEach>


											<div id="idxFileDelMsg"></div>
										</table>
									</c:if> <c:if test="${fn:length(reviewItem.files) < 1 }">
										첨부파일이 없습니다.
										</c:if></td>
							</tr>
						</table>
						<!-- 여백 -->
						<div class="btnArea">

							<t:button href="javascript:updateItem('${wc}/formProj.do?tid=review&review_id=${reviewItem.review_id}');" value="수정" auth="admin,AUTHOR_ADMIN" />
							<t:button href="javascript:deleteItem('${wc}/deleteProjReview.do?tid=review&review_id=${reviewItem.review_id}');" value="삭제" auth="admin,AUTHOR_ADMIN" />
							<span class="btn"><a href="javascript:goList('${wc}/listProj.do');">목록</a></span>
							
						</div>
						<c:if test="${status.last}">
							<div class="btnArea">
								<hr />
								<t:button href="javascript:updateItem('${wc}/formProj.do?tid=review');" value="추가" auth="admin,AUTHOR_ADMIN" />
								<span class="btn"><a href="javascript:goList('${wc}/listProj.do');">목록</a></span>
							</div>
						</c:if>
					</c:forEach>
				</c:if>
				<c:if test="${fn:length(reviewList) < 1 }">
					<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
						<colgroup>
							<col width="25%" />
							<col width="75%" />
						</colgroup>
						<tr>
							<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" />&nbsp;</td>
							<td>연간시행계획 검토 내역이 없습니다.</td>
						</tr>
					</table>
					<div class="btnArea">
						
					<t:button href="javascript:updateItem('${wc}/formProj.do?tid=review');" value="수정"  auth="admin,AUTHOR_ADMIN" />

						<span class="btn"><a href="javascript:goList('${wc}/listProj.do');">목록</a></span>
					</div>
				</c:if>

			</div>


			<!-- ############################################################################################################# -->
			<!-- 예산관리 -->
			<div id="tabs-3">
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
						<col width="75%" />

					</colgroup>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 예산편성정보</td>
						<td>
							<table style="width: 60%;">
								<tr>
									<td style="width: 50%; text-align: right; padding-right: 20px;">신청사업예산</td>
									<td style="width: 50%; text-align: right; padding-right: 20px;"><fmt:formatNumber value="${item.request_budget }" />&nbsp;백만원</td>
								</tr>
								<tr>
									<td style="width: 50%; text-align: right; padding-right: 20px;">배정예산</td>
									<td style="width: 50%; text-align: right; padding-right: 20px;"><fmt:formatNumber value="${item.allocation_budget }" />&nbsp;백만원</td>
								</tr>
								<tr>
									<td style="width: 50%; text-align: right; padding-right: 20px; background-color: #D7DEE0;">예산증감액</td>
									<td style="width: 50%; text-align: right; padding-right: 20px;"><fmt:formatNumber value="${item.budget_increase }" />&nbsp;백만원</td>
								</tr>
								<tr>
									<td style="width: 50%; text-align: right; padding-right: 20px;">예산코드</td>
									<td style="width: 50%; text-align: right; padding-right: 20px;">${item.wbs_code }</td>
								</tr>

							</table>

						</td>
					</tr>
<%--
 					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 예산확정 여부</td>
						<td><t:radiobox codeId="bdg_yn" name="budget_decision_yn" checkValue="${item.budget_decision_yn }" defaultCheck="N" readOnly="yes" /></td>
					</tr> 
--%>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 예산관련자료</td>
						<td colspan="3"><c:if test="${fn:length(budgetFiles) > 0 }">
								<table style="border: 0px; border-bottom: 0px; border-top: 0px; width: 100%;">
									<c:forEach items="${budgetFiles}" var="file">
										<tr>
											<td style="border: 0px;"><a href="javascript:fn_egov_downFile('${file.file_id }')"> ${file.file_name }&nbsp;[<fmt:formatNumber
														value="${file.file_size }" />&nbsp;byte]
											</a></td>
										</tr>
									</c:forEach>


									<div id="idxFileDelMsg"></div>
								</table>
							</c:if> <c:if test="${fn:length(budgetFiles) < 1 }">
										첨부파일이 없습니다.
										</c:if></td>
					</tr>
				</table>
				<!-- 여백 -->
				<div class="btnArea">
					
					<t:button href="javascript:updateItem('${wc}/formProj.do?tid=budget');" value="수정"  auth="admin,AUTHOR_ADMIN,pmsManager" deptOption="${item.staff_dept_id }"/>

					<span class="btn"><a href="javascript:goList('${wc}/listProj.do');">목록</a></span>
				</div>
			</div>


			<!-- ############################################################################################################# -->
			<!-- 발주관리 -->
			<div id="tabs-4">
				<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
					<colgroup>
						<col width="25%" />
						<col width="25%" />
						<col width="25%" />
						<col width="25%" />
					</colgroup>
					<tr>
						<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 연간시행계획 명칭</td>
						<td colspan="3" width="75%">${item.proj_order_name }</td>
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
						<td colspan="3">${item.proj_order_name }</td>
					</tr>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업발주일</td>
						<td colspan="3"><t:dispDate value="${item.order_date }" /></td>
					</tr>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 발주방법</td>
						<td colspan="3"><t:radiobox codeId="order" name="order_typer" checkValue="${item.order_type }" defaultCheck="001" readOnly="yes" /></td>
					</tr>
					<tr>
						<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 발주주관부서</td>
						<td width="25%">${item.order_dept }</td>
						<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 발주담당자</td>
						<td width="25%">${item.order_staff_position }&nbsp;&nbsp;${item.order_staff_name }</td>
					</tr>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 발주관련자료</td>
						<td colspan="3"><c:if test="${fn:length(orderFiles) > 0 }">
								<table style="border: 0px; border-bottom: 0px; border-top: 0px; width: 100%;">
									<c:forEach items="${orderFiles}" var="file">
										<tr>
											<td style="border: 0px;"><a href="javascript:fn_egov_downFile('${file.file_id }')"> ${file.file_name }&nbsp;[<fmt:formatNumber
														value="${file.file_size }" />&nbsp;byte]
											</a></td>
										</tr>
									</c:forEach>


									<div id="idxFileDelMsg"></div>
								</table>
							</c:if> <c:if test="${fn:length(orderFiles) < 1 }">
										첨부파일이 없습니다.
										</c:if></td>
					</tr>
				</table>
				<!-- 여백 -->
				<div class="btnArea">
					
					<t:button href="javascript:updateItem('${wc}/formProj.do?tid=order');" value="수정"  auth="admin,AUTHOR_ADMIN,pmsManager" deptOption="${item.staff_dept_id }"/>

					<span class="btn"><a href="javascript:goList('${wc}/listProj.do');">목록</a></span>
				</div>
			</div>


			<!-- ############################################################################################################# -->
			<!-- 발주검토 -->
			<div id="tabs-5">
				<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
					<colgroup>
						<col width="25%" />
						<col width="25%" />
						<col width="25%" />
						<col width="25%" />
					</colgroup>
					<tr>
						<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 연간시행계획 명칭</td>
						<td colspan="3" width="75%">${item.proj_order_name }</td>
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

				<c:if test="${fn:length(checkList) > 0 }">
					<c:forEach items="${checkList}" var="checkItem" varStatus="status">
						<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
							<colgroup>
								<col width="25%" />
								<col width="75%" />
							</colgroup>
							<tr>
								<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 시행계획 발주검토 항목</td>
								<td>${checkItem.check_title }</td>
							</tr>
							<tr>
								<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 시행계획 발주검토내역</td>
								<td><textarea id="check_content" name="check_content" class="" cols="75" rows="5" style="width: 660px; height: 100px; font-size: 9pt; "
										readonly>${checkItem.check_content}</textarea></td>
							</tr>

							<tr>
								<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 발주검토 관련자료</td>
								<td><c:if test="${fn:length(checkItem.files) > 0 }">
										<table style="border: 0px; border-bottom: 0px; border-top: 0px; width: 100%;">
											<c:forEach items="${checkItem.files}" var="file">
												<tr>
													<td style="border: 0px;"><a href="javascript:fn_egov_downFile('${file.file_id }')"> ${file.file_name }&nbsp;[<fmt:formatNumber
																value="${file.file_size }" />&nbsp;byte]
													</a></td>
												</tr>
											</c:forEach>


											<div id="idxFileDelMsg"></div>
										</table>
									</c:if> <c:if test="${fn:length(checkItem.files) < 1 }">
										첨부파일이 없습니다.
										</c:if></td>
							</tr>
						</table>
						<!-- 여백 -->
						<div class="btnArea">

							<t:button href="javascript:updateItem('${wc}/formProj.do?tid=check&check_id=${checkItem.check_id}');" value="수정" auth="admin,AUTHOR_ADMIN" />
							<t:button href="javascript:deleteItem('${wc}/deleteProjCheck.do?tid=check&check_id=${checkItem.check_id}');" value="삭제" auth="admin,AUTHOR_ADMIN" />
							<span class="btn"><a href="javascript:goList('${wc}/listProj.do');">목록</a></span>
						</div>
						<c:if test="${status.last}">
							<div class="btnArea">
								<hr />
								
								<t:button href="javascript:updateItem('${wc}/formProj.do?tid=check');" value="추가" auth="admin,AUTHOR_ADMIN" />
							</div>
						</c:if>
					</c:forEach>
				</c:if>
				<c:if test="${fn:length(checkList) < 1 }">
					<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
						<colgroup>
							<col width="25%" />
							<col width="75%" />
						</colgroup>
						<tr>
							<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" />&nbsp;</td>
							<td>연간시행계획 발주 검토 내역이 없습니다.</td>
						</tr>
					</table>
					<div class="btnArea">
						
					<t:button href="javascript:updateItem('${wc}/formProj.do?tid=check');" value="수정"  auth="admin,AUTHOR_ADMIN" />

						<span class="btn"><a href="javascript:goList('${wc}/listProj.do');">목록</a></span>
					</div>
				</c:if>



			</div>
			<!--  발주 검토 -->


			<!-- ############################################################################################################# -->
			<!-- 계약관리  -->
			<div id="tabs-6">
				<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
					<colgroup>
						<col width="25%" />
						<col width="25%" />
						<col width="25%" />
						<col width="25%" />
					</colgroup>
					<tr>
						<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 연간시행계획 명칭</td>
						<td colspan="3" width="75%">${item.proj_order_name }</td>
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
						<col width="75%" />

					</colgroup>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 계약일</td>
						<td><t:dispDate value="${item.contract_date }" /></td>
					</tr>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 계약종료일</td>
						<td><t:dispDate value="${item.contract_end_date }" /></td>
					</tr>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 계약금액</td>
						<td><fmt:formatNumber value="${item.contract_price }" />&nbsp;백만원 <span style="display: inline; padding-left: 120px;">&nbsp;</span> <t:radiobox codeId="vat"
								name="contract_price_typer" checkValue="${item.contract_price_type}" defaultCheck="001" readOnly="yes" /></td>
					</tr>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 계약업체</td>
						<td><span class="pms_sub">업체명 : </span> ${item.contractee }
						<span class="pms_sub">업체전화번호 : </span> ${item.contractee_phone }
						<span class="pms_sub">사업자번호 : </span> ${item.contractee_reg }</td>
					</tr>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 계약업체 담당자</td>
						<td><span class="pms_sub">담당자 : </span> ${item.contractee_staff_name }
						<span class="pms_sub">직위 : </span> ${item.contractee_staff_position }
						<span class="pms_sub">연락처 : </span> ${item.contractee_staff_phone }
						</td>
					</tr>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 계약관련자료</td>
						<td><c:if test="${fn:length(contractFiles) > 0 }">
								<table style="border: 0px; border-bottom: 0px; border-top: 0px; width: 100%;">
									<c:forEach items="${contractFiles}" var="file">
										<tr>
											<td style="border: 0px;"><a href="javascript:fn_egov_downFile('${file.file_id }')"> ${file.file_name }&nbsp;[<fmt:formatNumber
														value="${file.file_size }" />&nbsp;byte]
											</a></td>
										</tr>
									</c:forEach>


									<div id="idxFileDelMsg"></div>
								</table>
							</c:if> <c:if test="${fn:length(contractFiles) < 1 }">
										첨부파일이 없습니다.
										</c:if></td>
					</tr>
				</table>
				<!-- 여백 -->
				<div class="btnArea">
					
					<t:button href="javascript:updateItem('${wc}/formProj.do?tid=contract');" value="수정"  auth="admin,AUTHOR_ADMIN,pmsManager" deptOption="${item.staff_dept_id }"/>

					<span class="btn"><a href="javascript:goList('${wc}/listProj.do');">목록</a></span>
				</div>
			</div>
			<!-- 계약관리  -->


			<!-- ############################################################################################################# -->
			<!--  수행관리  -->
			<div id="tabs-7">
				<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
					<colgroup>
						<col width="25%" />
						<col width="25%" />
						<col width="25%" />
						<col width="25%" />
					</colgroup>
					<tr>
						<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 연간시행계획 명칭</td>
						<td colspan="3" width="75%">${item.proj_order_name }</td>
					</tr>
					<tr>
						<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 중장기정보화계획 명칭</td>
						<td colspan="3" width="75%"><a href="#" onclick="javascript:popPlanView();">${item.plan_name }</a></td>
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
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업수행 내용</td>
						<td colspan="3"><textarea id="proj_content" name="proj_content" class="" cols="75" rows="5"
								style="width: 660px; height: 100px; font-size: 9pt;" readonly="readonly" disabled style="font-family:'맑은 고딕'">${item.proj_content}</textarea></td>
					</tr>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업유형</td>
						<td colspan="3" ><div style="margin-right:70px;">
												<t:radiobox codeId="projtp" name="proj_type" checkValue="${item.proj_type }" defaultCheck="001" readOnly="yes" />
												<c:if test="${item.proj_type =='010' }" > [ ${item.proj_type_verbose} ]
												</c:if>
												</div>
						</td>
					</tr>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 사업비용세부정보</td>
						<td colspan="3">
							<table style="width: 60%;">
								<tr>
									<td style="width: 50%; text-align: right; padding-right: 20px;">H/W비용</td>
									<td style="width: 50%; text-align: right; padding-right: 20px;"><fmt:formatNumber value="${item.proj_hardware_cost }" />&nbsp;백만원</td>
								</tr>
								<tr>
									<td style="width: 50%; text-align: right; padding-right: 20px;">S/W비용</td>
									<td style="width: 50%; text-align: right; padding-right: 20px;"><fmt:formatNumber value="${item.proj_software_cost }" />&nbsp;백만원</td>
								</tr>
								<tr>
									<td style="width: 50%; text-align: right; padding-right: 20px;">시스템개발비용</td>
									<td style="width: 50%; text-align: right; padding-right: 20px;"><fmt:formatNumber value="${item.proj_develope_cost }" />&nbsp;백만원</td>
								</tr>
								<tr>
									<td style="width: 50%; text-align: right; padding-right: 20px;">컨설팅비용</td>
									<td style="width: 50%; text-align: right; padding-right: 20px;"><fmt:formatNumber value="${item.proj_consulting_cost }" />&nbsp;백만원</td>
								</tr>
								<tr>
									<td style="width: 50%; text-align: right; padding-right: 20px;">정보자원유지보수비용</td>
									<td style="width: 50%; text-align: right; padding-right: 20px;"><fmt:formatNumber value="${item.proj_resource_maintenance_cost }" />&nbsp;백만원</td>
								</tr>
								<tr>
									<td style="width: 50%; text-align: right; padding-right: 20px;">개발시스템유지보수비용</td>
									<td style="width: 50%; text-align: right; padding-right: 20px;"><fmt:formatNumber value="${item.proj_system_maintenance_cost }" />&nbsp;백만원</td>
								</tr>
								<tr>
									<td style="width: 50%; text-align: right; padding-right: 20px;">정보서비스운영비용</td>
									<td style="width: 50%; text-align: right; padding-right: 20px;"><fmt:formatNumber value="${item.proj_operation_cost }" />&nbsp;백만원</td>
								</tr>
								<tr>
									<td style="width: 50%; text-align: right; padding-right: 20px; background-color: #D7DEE0;">총사업비용</td>
									<td style="width: 50%; text-align: right; padding-right: 20px;"><fmt:formatNumber value="${item.proj_total_cost }" />&nbsp;백만원</td>
								</tr>
							</table>
						</td>
					</tr>


				</table>
				<!-- 여백 -->
				<div class="btnArea">
					 
					<t:button href="javascript:updateItem('${wc}/formProj.do?tid=perform');" value="수정"  auth="admin,AUTHOR_ADMIN,pmsManager" deptOption="${item.staff_dept_id }"/>

					<span class="btn"><a href="javascript:goList('${wc}/listProj.do');">목록</a></span>
				</div>
			</div>
			<!--  수행관리  -->


			<!-- ############################################################################################################# -->
			<!-- 수행산출물 관리  -->
			<div id="tabs-8">
				<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
					<colgroup>
						<col width="25%" />
						<col width="25%" />
						<col width="25%" />
						<col width="25%" />
					</colgroup>
					<tr>
						<td class="td_title" width="25%"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 연간시행계획 명칭</td>
						<td colspan="3" width="75%">${item.proj_order_name }</td>
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
						<col width="75%" />

					</colgroup>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 수행산출물</td>
						<td><c:if test="${fn:length(outputFiles) > 0 }">
								<table style="border: 0px; border-bottom: 0px; border-top: 0px; width: 100%;">
									<c:forEach items="${outputFiles}" var="file">
										<tr>
											<td style="border: 0px;"><a href="javascript:fn_egov_downFile('${file.file_id }')"> ${file.file_name }&nbsp;[<fmt:formatNumber
														value="${file.file_size }" />&nbsp;byte]
											</a></td>
										</tr>
									</c:forEach>


									<div id="idxFileDelMsg"></div>
								</table>
							</c:if> <c:if test="${fn:length(outputFiles) < 1 }">
										첨부파일이 없습니다.
										</c:if></td>
					</tr>
				</table>
				<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
					<colgroup>
						<col width="25%" />
						<col width="75%" />

					</colgroup>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> 관리산출물</td>
						<td><c:if test="${fn:length(adminFiles) > 0 }">
								<table style="border: 0px; border-bottom: 0px; border-top: 0px; width: 100%;">
									<c:forEach items="${adminFiles}" var="file">
										<tr>
											<td style="border: 0px;"><a href="javascript:fn_egov_downFile('${file.file_id }')"> ${file.file_name }&nbsp;[<fmt:formatNumber
														value="${file.file_size }" />&nbsp;byte]
											</a></td>
										</tr>
									</c:forEach>


									<div id="idxFileDelMsg2"></div>
								</table>
							</c:if> <c:if test="${fn:length(adminFiles) < 1 }">
										첨부파일이 없습니다.
										</c:if></td>
					</tr>
				</table>
				<table width="880" cellpadding="6" cellspacing="0" border="0" class="tb_03">
					<colgroup>
						<col width="25%" />
						<col width="75%" />

					</colgroup>
					<tr>
						<td class="td_title"><img src="${wc}/eams/images/eams/common/icon_bul2.gif" /> EA요청자료</td>
						<td><c:if test="${fn:length(eareqFiles) > 0 }">
								<table style="border: 0px; border-bottom: 0px; border-top: 0px; width: 100%;">
									<c:forEach items="${eareqFiles}" var="file">
										<tr>
											<td style="border: 0px;"><a href="javascript:fn_egov_downFile('${file.file_id }')"> ${file.file_name }&nbsp;[<fmt:formatNumber
														value="${file.file_size }" />&nbsp;byte]
											</a></td>
										</tr>
									</c:forEach>


									<div id="idxFileDelMsg2"></div>
								</table>
							</c:if> <c:if test="${fn:length(eareqFiles) < 1 }">
										첨부파일이 없습니다.
										</c:if></td>
					</tr>
				</table>
				
				<!-- 여백 -->
				<div class="btnArea">
					<t:button href="javascript:updateItem('${wc}/formProj.do?tid=output');" value="수정"  auth="admin,AUTHOR_ADMIN,pmsManager" deptOption="${item.staff_dept_id }"/>
					<span class="btn"><a href="javascript:goList('${wc}/listProj.do');">목록</a></span>
				</div>
			</div>


		</div>
		<!-- 수행산출물 관리  -->

	</form>
</div>
<!-- contGen +++ end -->
<!-- ///////////////////오른쪽 내용 영역/////////////////////-->







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

	$(document).ready(function() {

		var tidIndex = '<c:out value="${param.tid}" default="reg"/>';
		var tabsIndex = 0;
		if (tidIndex == 'review') {
			tabsIndex = 1;
		} else if (tidIndex == 'budget') {
			tabsIndex = 2;
		} else if (tidIndex == 'order') {
			tabsIndex = 3;
		} else if (tidIndex == 'check') {
			tabsIndex = 4;
		} else if (tidIndex == 'contract') {
			tabsIndex = 5;
		} else if (tidIndex == 'perform') {
			tabsIndex = 6;
		} else if (tidIndex == 'output') {
			tabsIndex = 7;
		}

		$("#tabs").tabs({
			active : tabsIndex
		});

		
		$('div.category').addClass('categoryhelp');
		
		$('div.category').qtip({
			   content: '단계별 탭을 클릭하여 연간시행계획 내역을 조회합니다. \
			   <br>수정하시려면 하단의 수정버튼 (권한이 없으면 안보임)\
			   <br>삭제버튼은 시행계획 단계 전체를 삭제합니다. \
			   <br>계획검토(EA),발주검토(EA)는 EA담당자만 입력가능합니다. \
			   <br> 산출물 입력까지 완료해야 성과평가에 목록이 표시됩니다.\
			   <br> 신규입력은 목록화면에서 신규버튼을 클릭하십시요.\
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
