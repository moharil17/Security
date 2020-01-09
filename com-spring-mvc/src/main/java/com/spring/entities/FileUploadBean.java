package com.spring.entities;

import java.util.Arrays;

import javax.persistence.Column;


public class FileUploadBean {

	private int id;

	@Column(name = "file_data")
	private byte[] fileData;

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	@Override
	public String toString() {
		return "FileUploadBean [id=" + id + ", fileData=" + Arrays.toString(fileData) + "]";
	}

}
