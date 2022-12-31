package com.kh.upload.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardVo {
	
	private String no;
	private String title;
	private String content;
	private MultipartFile[] f;
	private String originName;
	private String filePath;
	private String enrollDate;

}
