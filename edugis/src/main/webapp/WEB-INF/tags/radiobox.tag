<%@tag import="com.ziumks.common.util.Settings"%>
<%@tag import="java.util.*"%>
<%@ tag body-content="empty"%>
<%@ attribute name="codeId" required="true"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="checkValue" required="false"%>
<%-- <%@ attribute name="key" required="false" %>
<%@ attribute name="heading" required="false" %> --%>
<%@ attribute name="defaultCheck" required="false"%>
<%@ attribute name="readOnly" required="false"%>
<%
	//<input type="checkbox" name="rst_mkt_shar_yn" id="rst_mkt_shar_yn" value="1"  checked>EX</input>
	//<input type="checkbox" name="rst_mkt_shar_yn" id="rst_mkt_shar_yn" value="2">FIRB</input>
	//<input type="checkbox" name="rst_mkt_shar_yn" id="rst_mkt_shar_yn" value="3"  checked>AIRB</input>
	//  ret.rst_mkt_shar_yn  [1,3]
	//
	//<input type="checkbox" name="rst_mkt_shar_yn" id="rst_mkt_shar_yn" value="Y"  checked></input>
	//  ret.rst_mkt_shar_yn   [Y]

	String read = "";

	if ("yes".equals(readOnly)) {
		// radio는 readonly 안먹음.
		read = " disabled='disabled' ";
	}
	if (codeId != null && !"".equals(codeId)) {
		boolean checkOn = false;
		List oo = Settings.get(codeId);
		if (oo == null || oo.size() == 0) {
			return;
		}
		if (checkValue != null && !"".equals(checkValue)) {

			Iterator it = oo.iterator();
			while (it.hasNext()) {
				String[] item = (String[]) it.next();
				if("yes".equals(readOnly) || "N".equals(item[2] )){
					read = " disabled='disabled' ";
				}
				else {
					read = "";
				}
				if (checkValue.indexOf(item[0]) > -1) {
					out.println("<input type='radio' name=\"" + name + "\" id=\"" + name + "\"  value=\"" + item[0] + "\" " + read + " checked >" + item[1] + "</input>");
					checkOn = true;
				} else {
					out.println("<input type='radio' name=\"" + name + "\" id=\"" + name + "\"  value=\"" + item[0] + "\" " + read + "  >" + item[1] + "</input>");
				}
			}
		} else if (!checkOn) {

			Iterator it = oo.iterator();
			while (it.hasNext()) {
				String[] item = (String[]) it.next();
				if("yes".equals(readOnly) || "N".equals(item[2] )){
					read = " disabled='disabled' ";
				}
				else {
					read = "";
				}
				if (defaultCheck.indexOf(item[0]) > -1) {
					out.println("<input type='radio' name=\"" + name + "\" id=\"" + name + "\"  value=\"" + item[0] + "\" " + read + "  checked >" + item[1] + "</input>");
				} else {
					out.println("<input type='radio' name=\"" + name + "\" id=\"" + name + "\"  value=\"" + item[0] + "\" " + read + "  >" + item[1] + "</input>");
				}
			}
		}
	}
	/*
	 else {
	 if (key == null) key="";
	 if (heading == null)  heading = "";
	 if( checkValue != null && !"".equals(checkValue) && checkValue.indexOf( key) >-1 ){
	 out.println("<input type='radio' name=\""+ name  + "\" id=\""+name+"\"  value=\"" + key + "\" checked >"+ heading + "</input>");			
	 }
	 else{
	 out.println("<input type='radio' name=\""+ name  + "\" id=\""+name+"\"  value=\"" + key + "\" >"+ heading + "</input>");
	 }
	 }
	 */
%>
