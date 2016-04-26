package com.manager.common.fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.manager.common.exceptions.UploadFileException;
import com.manager.control.base.BaseController;
import com.manager.sys.model.FileModel;
 

@Controller
public class FileUploadController extends BaseController{
	
	public static final int BUFFER_SIZE = 4096;

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		//model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}
	
	
	@RequestMapping(value="/multipartFileUpload",method=RequestMethod.GET)
	//@RequestBody
	public String fileUploadForm() {
		return "";
	}
	
	
	@RequestMapping(value="/multipartFileUpload",method=RequestMethod.POST)
	@ResponseBody
	public String processUpload(@RequestParam(value="files[]",required=false) MultipartFile   multipartRequest, HttpServletResponse response) throws IOException {
		//model.addAttribute("message", "File '" + file.getOriginalFilename() + "' uploaded successfully");
		String path = "D:\\software\\apache-tomcat-8.0.28\\wtpwebapps\\sysManager\\upload\\";//file.getParameter("path");
		//List<FileModel> arrList = new ArrayList<FileModel>();
		FileModel fileModel = new FileModel(); 
		if(multipartRequest != null){
				String newFileName = UUID.randomUUID().toString();//生产新文件名
				if(multipartRequest != null && StringUtils.hasText(multipartRequest.getOriginalFilename())){
 					fileModel.setNewFileName(newFileName+multipartRequest.getOriginalFilename().substring(multipartRequest.getOriginalFilename().lastIndexOf(".")));
					fileModel.setFileSize(multipartRequest.getSize());
					fileModel.setOldFileName(multipartRequest.getOriginalFilename());
					fileModel.setFileType(multipartRequest.getContentType());
					try {
						String filePath = this.uploadFile(multipartRequest,path,newFileName+multipartRequest.getOriginalFilename().substring(multipartRequest.getOriginalFilename().lastIndexOf(".")));
						fileModel.setDownFileUrL(FileModel.getDownFilePath()+File.separator + filePath);
					} catch (UploadFileException e) {
						e.printStackTrace();
					}
					//arrList.add(fileModel);
				}
			
		}
		return fileModel.getDownFileUrL();
	 
	}
	
	
	public void processUpload1(@RequestParam(value="files[]",required=false) MultipartFile   files, HttpServletResponse response) throws IOException {
		/*//model.addAttribute("message", "File '" + file.getOriginalFilename() + "' uploaded successfully");
		String path = "D:\\software\\apache-tomcat-8.0.28\\wtpwebapps\\sysManager\\upload\\";//file.getParameter("path");
		List<FileModel> arrList = new ArrayList<FileModel>();
		if(files != null){
			Iterator<String> iterator = file.getFileNames();
			while(iterator.hasNext()){
				String newFileName = UUID.randomUUID().toString();//生产新文件名
				MultipartFile multipartRequest = file.getFile((String)iterator.next());//获取单个文件信息
				if(multipartRequest != null && StringUtils.hasText(multipartRequest.getOriginalFilename())){ 
					FileModel fileModel = new FileModel(); 
 					fileModel.setNewFileName(newFileName+multipartRequest.getOriginalFilename().substring(multipartRequest.getOriginalFilename().lastIndexOf(".")));
					fileModel.setFileSize(multipartRequest.getSize());
					fileModel.setOldFileName(multipartRequest.getOriginalFilename());
					fileModel.setFileType(multipartRequest.getContentType());
					try {
						String filePath = this.uploadFile(multipartRequest,path,newFileName);
						fileModel.setDownFileUrL(FileModel.getDownFilePath()+File.separator + filePath);
					} catch (UploadFileException e) {
						e.printStackTrace();
					}
					arrList.add(fileModel);
				}
			}
			
		}*/
	 
		
	}
	
	private String  uploadFile(MultipartFile file,String path,String newFileName) throws  UploadFileException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(new Date());
		path = path + File.separator+date;
		File filePath = new File(path);
		InputStream inputStream = null;
		OutputStream os = null;
		try{
			if(!filePath.exists()){
				 filePath.mkdirs();
			}
			inputStream = file.getInputStream();
			os = new FileOutputStream(path + File.separator + newFileName);
			//file.transferTo(filePath);
			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.flush();
			//StreamUtils.copy(inputStream,os);//文件上传
		}catch(IOException io){
			throw new UploadFileException("文件删除失败",io);
		}finally{
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) { 
					e.printStackTrace();
				}
			}
			if(os != null){
				try {
					os.close();
				} catch (IOException e) { 
					e.printStackTrace();
				}
			}
		}
		return (date +"/" + newFileName);
	}
	
	@RequestMapping(value="/deleteFile",method=RequestMethod.GET)
	public String deleteFile(String fileName) {
		
		System.out.println("delteFile: " + fileName );
		
		return "";
	}
	
	
}
