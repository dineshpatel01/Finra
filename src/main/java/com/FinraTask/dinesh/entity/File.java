package com.FinraTask.dinesh.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class File {
	
	@Id
	private String FileName;
	private String FileType;
	private String FileSource;

	public String getFileSource() {
		return FileSource;
	}

	@Override
	public String toString() {
		return "File [FileName=" + FileName + ", FileType=" + FileType + ", FileSource=" + FileSource + "]";
	}

	public void setFileSource(String fileSource) {
		FileSource = fileSource;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public String getFileType() {
		return FileType;
	}

	public void setFileType(String fileType) {
		FileType = fileType;
	}
}
