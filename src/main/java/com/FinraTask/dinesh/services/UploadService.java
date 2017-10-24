package com.FinraTask.dinesh.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.FinraTask.dinesh.entity.File;
import com.FinraTask.dinesh.repository.UploadRespository;

@Service
public class UploadService {

	private static String UPLOADED_FOLDER = "upload/";
	@Autowired
	private UploadRespository uploadRespository;

	public void addFile(File file) {

		uploadRespository.save(file);
	}

	public List<File> getAllFiles() {
		List<File> files = new ArrayList<>();
		for (File file : uploadRespository.findAll()) {
			files.add(file);
		}
		return files;
	}

	public File metadata(MultipartFile file) throws IOException {
		File newFile = new File();
		newFile.setFileName((file.getOriginalFilename()));
		newFile.setFileType(file.getContentType());
		newFile.setFileSource(UPLOADED_FOLDER + file.getOriginalFilename());
		return newFile;

	}

}
