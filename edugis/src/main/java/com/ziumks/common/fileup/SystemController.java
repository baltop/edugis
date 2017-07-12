package com.ziumks.common.fileup;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziumks.common.base.BaseController;
import com.ziumks.common.base.Bus;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SystemController extends BaseController {

	private static final Logger log = LoggerFactory.getLogger(SystemController.class);

	@Resource
	private SystemService systemService;
	
	@Resource
	private MessageSource messageSource;

	@RequestMapping(value = "/deleteFile.do", method = RequestMethod.POST)
	@ResponseBody
	public Map deleteFile(Bus paraBus, HttpServletRequest request, HttpServletResponse response ) throws IOException, SQLException {
		
		systemService.deleteFile(paraBus);
		
		Map ret = new HashMap();
		ret.put("result", "성공");

		// 확인
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.writeValue(System.out, ret);
		if( "error".equals((String)ret.get("result")) ){
			response.getWriter().write("울버린");
			response.setStatus( HttpServletResponse.SC_BAD_REQUEST  );
			return null;
		}
		return ret;
	}

	
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/fileDown.do")
	public void fileDownload(Bus paraBus, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException   {

		// String atchFileId = (String) commandMap.get("atchFileId");
		// String fileSn = (String) commandMap.get("fileSn");

		// Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();

		// FileVO fileVO = new FileVO();
		// fileVO.setAtchFileId(atchFileId);
		// fileVO.setFileSn(fileSn);
		// FileVO fvo = fileService.selectFileInf(fileVO);
		// String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
		String filePath = messageSource.getMessage("upload.fileFolder", null, "/home/files",  Locale.US);
		
		Map fileInfo = systemService.selectFile(paraBus);
		File uFile = new File( filePath + (String) fileInfo.get("file_path"));
		int fSize = (int) uFile.length();

		if (fSize > 0) {
			String mimetype = "application/x-msdownload";

			// response.setBufferSize(fSize); // OutOfMemeory 발생
			response.setContentType(mimetype);
			// response.setHeader("Content-Disposition",
			// "attachment; filename=\"" +
			// URLEncoder.encode(fvo.getOrignlFileNm(), "utf-8") + "\"");
			setDisposition((String)fileInfo.get("file_name"), request, response);
			response.setContentLength(fSize);

			/*
			 * FileCopyUtils.copy(in, response.getOutputStream()); in.close();
			 * response.getOutputStream().flush();
			 * response.getOutputStream().close();
			 */
			BufferedInputStream in = null;
			BufferedOutputStream out = null;

			try {
				in = new BufferedInputStream(new FileInputStream(uFile));
				out = new BufferedOutputStream(response.getOutputStream());

				FileCopyUtils.copy(in, out);
				out.flush();
			} catch (Exception ex) {
				// ex.printStackTrace();
				// 다음 Exception 무시 처리
				// Connection reset by peer: socket write error
				log.debug("IGNORED: " + ex.getMessage());
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (Exception ignore) {
						// no-op
						log.debug("IGNORED: " + ignore.getMessage());
					}
				}
				if (out != null) {
					try {
						out.close();
					} catch (Exception ignore) {
						// no-op
						log.debug("IGNORED: " + ignore.getMessage());
					}
				}
			}

		} else {
			response.setContentType("application/x-msdownload");

			PrintWriter printwriter = response.getWriter();
			printwriter.println("<html>");
			printwriter.println("<br><br><br><h2>Could not get file name:<br>" + (String)fileInfo.get("file_name") + "</h2>");
			printwriter.println("<br><br><br><center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
			printwriter.println("<br><br><br>&copy; webAccess");
			printwriter.println("</html>");
			printwriter.flush();
			printwriter.close();
		}
	}

	private void setDisposition(String filename, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String browser = getBrowser(request);

		String dispositionPrefix = "attachment; filename=";
		String encodedFilename = null;

		if (browser.equals("MSIE")) {
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Firefox")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Opera")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Chrome")) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < filename.length(); i++) {
				char c = filename.charAt(i);
				if (c > '~') {
					sb.append(URLEncoder.encode("" + c, "UTF-8"));
				} else {
					sb.append(c);
				}
			}
			encodedFilename = sb.toString();
		} else {
			throw new RuntimeException("Not supported browser");
			// throw new IOException("Not supported browser");
		}

		response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);

		if ("Opera".equals(browser)) {
			response.setContentType("application/octet-stream;charset=UTF-8");
		}
	}

	private String getBrowser(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		if (header.indexOf("MSIE") > -1) {
			return "MSIE";
		} else if (header.indexOf("Chrome") > -1) {
			return "Chrome";
		} else if (header.indexOf("Opera") > -1) {
			return "Opera";
		}
		return "Firefox";
	}

	
	
	
}
