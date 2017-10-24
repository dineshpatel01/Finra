package com.FinraTask.dinesh.repository;

import org.springframework.data.repository.CrudRepository;

import com.FinraTask.dinesh.entity.File;

public interface UploadRespository extends CrudRepository<File, String> {

}
