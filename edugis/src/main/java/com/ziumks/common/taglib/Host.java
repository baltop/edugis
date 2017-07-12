package com.ziumks.common.taglib;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

/**
 *
 * <p>Title: 현재 호스트의 URL을 반환
 *    (예: http://localhost:8088/nb/test.jsp 라면
 *         http://localhost:8088
 *     을 반환)</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) Xydec 2004</p>
 * <p>Company: Xydec</p>
 * @author rock-like
 * @version 1.0
 *
 *
 * @jsp.tag name="host"
 *
 *
 */
public class Host extends TagSupport{

    private static Logger logger = Logger.getLogger(Host.class);

    public Host() {
    }

    public int doStartTag(){
        return SKIP_BODY;
    }

    /**
     * 요 태그는 AI report의 popAI()등의 자바스크립트를 위해서 만든건데,
     * 그 자바스크립트를 이용할때 반드시 이 태그를 써서 호출해야 한다.
     * 그래서, 이 태그를 안 쓰고 호출했을때를 위하여 앞에 ^^를 일부러
     * 붙여서 만들었다.
     *
     * @return
     */
    public int doEndTag(){
        JspWriter out = null;
        try{
            out = pageContext.getOut();
            String url = ((HttpServletRequest)pageContext.getRequest()).getRequestURL().toString();
            int len = url.indexOf("/", 7);
            url = url.substring(0, len);
//            url = "^^" + url;
            out.print(url);
            //http://localhost:8088/nb/nbcr3001R.do
        }catch(Exception e){
            logger.error(e);
        }
        return EVAL_PAGE;
    }

    public void release(){
        super.release();
    }

}