<%@tag import="com.ziumks.common.util.Settings"%>
<%@tag import="java.util.*"%>
<%@ tag body-content="empty" %> 
<%@ attribute name="codeId" required="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="checkValue" required="false" %>
<%@ attribute name="key" required="false" %>
<%@ attribute name="heading" required="false" %>

<%
//<input type="checkbox" name="rst_mkt_shar_yn" id="rst_mkt_shar_yn" value="1"  checked>EX</input>
//<input type="checkbox" name="rst_mkt_shar_yn" id="rst_mkt_shar_yn" value="2">FIRB</input>
//<input type="checkbox" name="rst_mkt_shar_yn" id="rst_mkt_shar_yn" value="3"  checked>AIRB</input>
//  ret.rst_mkt_shar_yn  [1,3]
//
//<input type="checkbox" name="rst_mkt_shar_yn" id="rst_mkt_shar_yn" value="Y"  checked></input>
//  ret.rst_mkt_shar_yn   [Y]

if( codeId !=null && !"".equals(codeId)){
	
	List oo = Settings.get(codeId);
	if (oo==null || oo.size()==0){
		return;
	}
	if( checkValue != null && !"".equals(checkValue)){
		
		Iterator it = oo.iterator();
		while(it.hasNext()) {
			String[] item = (String[])it.next();
			
			if ( checkValue.indexOf(item[0])>-1 ){
				out.println("<input type='checkbox' name=\""+ name  + "\" id=\""+name+"\"  value=\"" + item[0] + "\" checked >"+ item[1] + "</input>");
			}else{
				out.println("<input type='checkbox' name=\""+ name  + "\" id=\""+name+"\"  value=\"" + item[0] + "\" >"+ item[1] + "</input>");
			}
		}
	}
	else {
		Iterator it = oo.iterator();
		while(it.hasNext()) {
			String[] item = (String[])it.next();
			out.println("<input type='checkbox' name=\""+ name  + "\" id=\""+name+"\"  value=\"" + item[0] + "\" >"+ item[1] + "</input>");
		}	
	}
}
else {
	if (key == null) key="";
	if (heading == null)  heading = "";
	if( checkValue != null && !"".equals(checkValue) && checkValue.indexOf( key) >-1 ){
		out.println("<input type='checkbox' name=\""+ name  + "\" id=\""+name+"\"  value=\"" + key + "\" checked >"+ heading + "</input>");			
	}
	else{
		out.println("<input type='checkbox' name=\""+ name  + "\" id=\""+name+"\"  value=\"" + key + "\" >"+ heading + "</input>");
	}
}


%>
