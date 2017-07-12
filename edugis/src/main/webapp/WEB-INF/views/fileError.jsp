<%@ page contentType="text/html; charset=UTF-8"%> 
<%@ taglib uri="/WEB-INF/tlds/knkal.tld" prefix="cx"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>KOSPO : pms</title>
<style>
body{
font-family: "malgun gothic", dotum;
}

</style>
<script type="text/javascript">
if ("<c:out value='${msg}' default='' />" != "") {
	alert("<c:out value='${msg}'/>");
}
</script>
<link href="<c:url value='/css/egovframework/com.css' />" rel="stylesheet" type="text/css" />

<script language="javascript">
function fncGoAfterErrorPage(){
    history.back(-2);
}
</script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center" valign="top"><br />
    <br />
    <br />
    <table width="600" border="0" cellpadding="0" cellspacing="0" background="er_images/blue_bg.jpg">
      <tr>
        <td align="center"><table width="100%" border="0" cellspacing="9" cellpadding="0">
          <tr>
            <td bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="left"><img src="<c:url value='/eams/images/eams/common/top_logo.gif'/>"  /></td>
                
              </tr>
              <tr>
                <td><br />
                  <br /></td>
              </tr>

              <tr>
                <td align="center"><table width="520" border="0" cellspacing="2" cellpadding="2">
                  <tr>
                    <td width="74" align="center"><img src="<c:url value='/eams/images/egovframework/cmm/danger.jpg'/>" width="74" height="74" /></td>
                    													
                    <td width="399" align="left" class="lt_text2">File  Error</td>
                  </tr>
                  <tr>
                    <td colspan='2' align="left" valign="top" class="lt_text5">${detail}</td>
                  </tr>
                  <tr>
                    <td colspan='2'  align="left" valign="top" style="font-size:9pt;">${msg}</td>
                  </tr>                  
                </table>
                  <table width="500" border="0" cellspacing="2" cellpadding="2">
                                  </table></td>
              </tr>
              <tr>
                <td><br />
                  <br /></td>
              </tr>
              <tr>
                <td align="center"><a href="javascript:fncGoAfterErrorPage();"><img src="<c:url value='/eams/images/egovframework/cmm/go_history.jpg'/>" width="90" height="29" border="0"/></a></td>
                
              </tr>
            </table>
              <br /></td>
          </tr>
        </table></td>
      </tr>
    </table>
    </td>
  </tr>
</table>
</body>
</html>
