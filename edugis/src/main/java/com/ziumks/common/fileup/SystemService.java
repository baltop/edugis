package com.ziumks.common.fileup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ziumks.common.base.BaseService;
import com.ziumks.common.base.Bus;
import com.ziumks.common.base.PmsExcelException;
import com.ziumks.common.base.UnderBus;
// import com.ziumks.proj.ProjManageService;
import com.ziumks.common.util.DateUtil;
import com.ziumks.common.util.ExcelReader;

@Service
public class SystemService extends BaseService {

	private static final Logger log = LoggerFactory.getLogger(SystemService.class);

	@SuppressWarnings("unchecked")
	public List<UnderBus> listFiles(Bus para, String refName, String refGroup) throws SQLException {
		log.info("SystemService.listFiles ");
		para.put("ref_id", para.getString(refName));
		para.put("ref_group", refGroup);
		List<UnderBus> list = dao.queryForList("system.listFileByRefId", para);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<UnderBus> listFilesByStr(Bus para, String refName, String refGroup) throws SQLException {
		log.info("SystemService.listFilesByStr ");
		para.put("ref_id", para.getString(refName));
		para.put("ref_group", refGroup);
		List<UnderBus> list = dao.queryForList("system.listFileByRefStr", para);
		return list;
	}

	@SuppressWarnings("rawtypes")
	public Map selectFile(Bus paraBus) throws SQLException {
		log.info("SystemService.selectFile ");
		Map fileInfo = (Map) dao.queryForObject("system.selectFile", paraBus);
		return fileInfo;
	}

	public void saveUpFile(Bus paraBus, HttpServletRequest request) throws FileNotFoundException, IOException, SQLException {

		log.debug("SystemService.fileUpload");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart)
			return;

		paraBus.put("isMultipart", isMultipart);

		// String filePath =
		// request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
		// messageSource.getMessage("message", new String[] {"jjaeko"},
		// "no surch", Locale.KOREA);
		String filePath = messageSource.getMessage("upload.fileFolder", null, "/home/eams/files/pms", Locale.US);
		// String filePath = "/home/files";

		String filePath2 = "/" + DateUtil.getToday("yyyyMM") + "/";
		// filePath = StringUtil.replace(filePath, "\\", "/");

		File file2 = new File(filePath + filePath2);
		if (!file2.isDirectory()) {
			file2.mkdir();
		}
		// 전달 받은 Request값을 MultipartHttpServletRequest로 바인딩 시킨다.
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		String inputName = paraBus.getString("inputName");
		if ("".equals(inputName)) {
			inputName = "file_0";
		}

		List<MultipartFile> files = multipartRequest.getFiles(inputName);

		Iterator<MultipartFile> it = files.iterator();
		MultipartFile file = null;
		int sort_order = 0;

		while (it.hasNext()) {
			file = it.next();
			sort_order++;

			String fileName = file.getOriginalFilename();
			// String temp = URLDecoder.decode( fileName );
			if (fileName == null || "".equals(fileName)) {
				continue;
			}
			// File destination = File. createTempFile("file", fileName, file2);
			paraBus.put("file_name", fileName);
			paraBus.put("sort_order", sort_order);
			String sFileName = fileName + System.currentTimeMillis();
			paraBus.put("file_path", filePath2 + sFileName);
			paraBus.put("file_size", file.getSize());
			paraBus.put("use_yn", "Y");
			File destination = new File(filePath + filePath2 + sFileName);
			FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(destination));
			dao.insert("system.insertFile", paraBus);

		}

		return;
	}

	public void deleteFile(Bus paraBus) throws SQLException {
		dao.delete("system.deleteFile", paraBus);

	}

	public void deleteFiles(Bus paraBus, String id) throws SQLException {
		paraBus.put("ref_id", paraBus.get(id));
		dao.delete("system.deleteFileByRefId", paraBus);
	}

	public void saveUpFileEams(Bus paraBus, HttpServletRequest request) throws FileNotFoundException, IOException, SQLException {
		try {
			log.debug("SystemService.fileUpload.saveUpFileEams");
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (!isMultipart)
				return;

			paraBus.put("isMultipart", isMultipart);

			// String filePath =
			// request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
			// messageSource.getMessage("message", new String[] {"jjaeko"},
			// "no surch", Locale.KOREA);
			String filePath = messageSource.getMessage("upload.fileFolder", null, "/home/files", Locale.US);
			// String filePath = "/home/files";

			String filePath2 = "/" + DateUtil.getToday("yyyyMM") + "/";
			// filePath = StringUtil.replace(filePath, "\\", "/");

			File file2 = new File(filePath + filePath2);
			if (!file2.isDirectory()) {
				file2.mkdir();
			}
			// 전달 받은 Request값을 MultipartHttpServletRequest로 바인딩 시킨다.
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

			String inputName = paraBus.getString("inputName");
			if ("".equals(inputName)) {
				inputName = "file_0";
			}

			List<MultipartFile> files = multipartRequest.getFiles(inputName);

			Iterator<MultipartFile> it = files.iterator();
			MultipartFile file = null;
			int sort_order = 0;
			boolean eamsFile = false;

			MultipartEntity mpEntity = new MultipartEntity();
			int op = 1;

			String multiFileName = "";

			while (it.hasNext()) {
				file = it.next();
				sort_order++;

				String fileName = file.getOriginalFilename();

				if (fileName == null || "".equals(fileName)) {
					continue;
				}
				// File destination = File. createTempFile("file", fileName,
				// file2);
				paraBus.put("file_name", fileName);
				paraBus.put("sort_order", sort_order);
				String sFileName = fileName + System.currentTimeMillis();
				paraBus.put("file_path", filePath2 + sFileName);
				paraBus.put("file_size", file.getSize());
				paraBus.put("use_yn", "Y");
				File destination = new File(filePath + filePath2 + sFileName);
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(destination));
				dao.insert("system.insertFile", paraBus);

				System.out.println("pms file filename [" + fileName + "]");
				if (op == 1) {
					multiFileName = fileName;
				} else {
					multiFileName = multiFileName + ":" + fileName;
				}

				ContentBody cbFile = new FileBody(destination, URLEncoder.encode(fileName, "UTF-8"), "application/vnd.ms-excel", "UTF-8");
				// ContentBody cbFile = new FileBody(destination, fileName,
				// "application/vnd.ms-excel", "UTF-8");
				mpEntity.addPart("file_" + op++, cbFile);
				eamsFile = true;
			}

			if (eamsFile) {

				HttpClient httpclient = new DefaultHttpClient();
				httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
				httpclient.getParams().setParameter("http.protocol.content-charset", "UTF-8");

				String eamsUrl = messageSource.getMessage("upload.eamsurl", null, "http://127.0.0.1:8050/eams/cm/mgmt/mgmtInsert.do", Locale.US);
				System.out.println("+++++++++++++++++++++++++++++++++++++ eamsUrl " + eamsUrl);
				HttpPost httppost = new HttpPost(eamsUrl);
				// HttpPost httppost = new
				// HttpPost("http://192.168.43.15:8050/kospo/cm/mgmt/mgmtInsert.do");

				ContentBody mgmtName = new StringBody(paraBus.getString("project_name") + " 의 현행화 자동연계 요청", Charset.forName("UTF-8"));
				mpEntity.addPart("mgmtName", mgmtName);

				ContentBody mgmtDesc = new StringBody("정보화 사업관리의 산출물 등록에서 자동으로 연계되는 현행화 요청입니다.", Charset.forName("UTF-8"));
				mpEntity.addPart("mgmtDesc", mgmtDesc);

				ContentBody registerUser = new StringBody(paraBus.getString("register_id"), Charset.forName("UTF-8"));
				mpEntity.addPart("registerUser", registerUser);
				System.out.println("sendFileName [" + multiFileName + "]");
				ContentBody sendFileName = new StringBody(multiFileName, Charset.forName("UTF-8"));
				mpEntity.addPart("sendFileName", sendFileName);

				httppost.setEntity(mpEntity);

				HttpResponse response = httpclient.execute(httppost);
				System.out.println(response.getStatusLine());
				try {
					HttpEntity resEntity = response.getEntity();
					if (resEntity != null) {
						System.out.println(EntityUtils.toString(resEntity));
						resEntity.consumeContent();
					}
				} finally {
					httppost.releaseConnection();
					httpclient.getConnectionManager().shutdown();
				}
			}
			mpEntity = null;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	@SuppressWarnings("rawtypes")
	@Transactional(value = "txManager", rollbackFor = PmsExcelException.class)
	public List saveUpExcel(Bus paraBus, HttpServletRequest request) throws FileNotFoundException, IOException, SQLException, PmsExcelException, InvalidFormatException {

		log.debug("SystemService.saveUpExcel");
		List<Bus> errorList = new ArrayList<Bus>();
		List<Bus> resultList = new ArrayList<Bus>();
		List<Bus> dbList = new ArrayList<Bus>();
		Bus errorItem = null;
		boolean insertErrorOccured = false;

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart)
			return errorList;

		paraBus.put("isMultipart", isMultipart);

		String filePath = messageSource.getMessage("upload.fileFolder", null, "/home/eams/files/pms", Locale.US);

		filePath += "/temp";

		String filePath2 = "/" + new Date().getTime() + "/";

		File file2 = new File(filePath + filePath2);
		if (!file2.isDirectory()) {
			file2.mkdir();
		}
		// 전달 받은 Request값을 MultipartHttpServletRequest로 바인딩 시킨다.
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		String inputName = paraBus.getString("inputName");
		if ("".equals(inputName)) {
			inputName = "file_0";
		}

		List<MultipartFile> files = multipartRequest.getFiles(inputName);

		Iterator<MultipartFile> it = files.iterator();
		MultipartFile file = null;

		while (it.hasNext()) {
			file = it.next();

			String fileName = file.getOriginalFilename();

			if (fileName == null || "".equals(fileName)) {
				continue;
			}

			ExcelReader er = new ExcelReader();
			List<Map<Integer, String>> list = er.readExcel(file.getInputStream());
			int row = 0;
			Bus dbin = null;

			Bus resultItem = null;

			for (Map<Integer, String> para : list) {
				System.out.println("============================== row is " + row++);
				if (row < 4)
					continue;

				dbin = new UnderBus();
				errorItem = new UnderBus();
				resultItem = new UnderBus();

				int idx = 1;
				if (para.get(idx) == null || "".equals(para.get(idx))) {
					break;
				}
				dbin.put("project_name", para.get(idx++));
				dbin.put("plan_name", para.get(idx++));
				dbin.put("proj_start_month", para.get(idx++));
				dbin.put("proj_end_month", para.get(idx++));
				dbin.put("status", "100");
				dbin.put("proj_total_budget", para.get(idx++));
				dbin.put("planning_cost", para.get(idx++));
				dbin.put("construction_cost", para.get(idx++));
				dbin.put("operation_cost", para.get(idx++));
				dbin.put("supporting_cost", para.get(idx++));
				dbin.put("budget_decision_yn", para.get(idx++));
				dbin.put("staff_dept", paraBus.getString("register_dept_name"));
				dbin.put("staff_name", paraBus.getString("register_name"));
				dbin.put("project_desc", para.get(idx++));
				dbin.put("request_budget", para.get(idx++));
				dbin.put("allocation_budget", para.get(idx++));
				dbin.put("budget_increase", para.get(idx++));
				dbin.put("wbs_code", para.get(idx++));

				System.out.println("6666666666666666666666666666666666");
				System.out.println(dbin.toString());
				Integer pname_check = (Integer) dao.queryForObject("proj.checkProjectName", dbin);
				if (pname_check == null) {
					try {

						Integer planId = (Integer) dao.queryForObject("plan.checkPlanName", dbin);
						if (planId == null) {
							dbin.put("plan_id", 100000);
						} else {
							dbin.put("plan_id", planId);
						}

						dao.insert("proj.insertProj", dbin);
						// daoEAMS.insert("eams.insertProj", dbin);
					} catch (SQLException e) {
						insertErrorOccured = true;

						errorItem.put("errorRow", row - 1);
						errorItem.put("errorDesc", e.getMessage());
						errorList.add(errorItem);
						continue;
					}
				} else {
					insertErrorOccured = true;

					errorItem.put("errorRow", row - 1);
					errorItem.put("errorDesc", dbin.getString("project_name") + " : 같은 이름의 시행계획이 있습니다.");
					errorList.add(errorItem);
					continue;
				}
				// 성공

				resultItem.put("errorRow", row - 1);
				resultItem.put("errorDesc", dbin.getString("project_name") + " : 입력되었습니다.");
				// 성공시는 resultList에 붙음.
				resultList.add(resultItem);
				dbList.add(dbin);

			}

		}

		if (insertErrorOccured) {
			throw new PmsExcelException(errorList);
		}

		try {
			for (Bus dbin : dbList) {
				// 톰캣이 멀티 DB jta transaction을 지원하지 않아 eams 의 완벽한 롤백을 지원하지 못함.
				// pms 에러시는 아예 인서트 안하니까 문제가 없는데 pms 성공후 eams
				// insert시 에러나면 pms는 롤백하는데 eams는 기 입력된 것은 롤백 못함.
				daoEAMS.insert("eams.insertProj", dbin);
				dbin.put("relation_id", dbin.getString("project_id")+"_"+dbin.getString("plan_id"));
				daoEAMS.insert("eams.insertProjRelation", dbin);
			}
		} catch (SQLException se) {
			errorItem.put("errorRow", 0);
			errorItem.put("errorDesc", "EAMS 연동중에 DATABASE 에러가 발생했습니다..");
			errorList.add(errorItem);
			throw new PmsExcelException(errorList);
		}

		return resultList;
	}

}
