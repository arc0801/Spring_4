package com.arc.s4.util;

import java.io.File;
import java.util.Calendar;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileSaver {

	public String save(String realPath, MultipartFile multipartFile) throws Exception {
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		Calendar ca = Calendar.getInstance();
		Long name = ca.getTimeInMillis();
		int index = multipartFile.getOriginalFilename().lastIndexOf(".");
		String fileName = name + multipartFile.getOriginalFilename().substring(index);
		
		file = new File(realPath, fileName);
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		return fileName;
	}
}
