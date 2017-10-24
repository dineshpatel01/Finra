package com.FinraTask.dinesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.FinraTask.dinesh.entity.File;
import com.FinraTask.dinesh.controller.UploadController;
import com.FinraTask.dinesh.services.UploadService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class UploadController {

	private static String UPLOADED_FOLDER = "upload/";

	@Autowired
	private UploadService uploadservice;

	@RequestMapping(value = "/uploads")
	public List<File> showAllFiles() {
		return uploadservice.getAllFiles();
	}

	@RequestMapping(value = "/uploads", method = RequestMethod.POST)
	public File singleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		byte[] bytes = file.getBytes();
		Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
		Files.write(path, bytes);
		File f1 = uploadservice.metadata(file);
		uploadservice.addFile(f1);
		return f1;

	}

}
