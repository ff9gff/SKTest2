package com.sj.project.domain;

import org.springframework.web.multipart.MultipartFile;

public class EditorVO {
	private MultipartFile Filedata;
	
	public EditorVO() {
		
	}

	public EditorVO(MultipartFile filedata) {
		super();
		Filedata = filedata;
	}

	public MultipartFile getFiledata() {
		return Filedata;
	}

	public void setFiledata(MultipartFile filedata) {
		Filedata = filedata;
	}
}