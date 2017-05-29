package com.sneak.modelo;

import org.springframework.web.multipart.MultipartFile;

public class FileModel {
	
	private MultipartFile file;
	
	public FileModel() {
	}

    public MultipartFile getFile() {
    	return file;
    }

    public void setFile(MultipartFile file) {
    	this.file = file;
    }
}
