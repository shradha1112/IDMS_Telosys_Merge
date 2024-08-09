package com.cpa.idms.service.admin;

import java.util.List;

import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.dto.DocumentCategoryDTO;

public interface DocumentCategoryService {

	List<DocumentCategoryDTO> retrieveAllDocumentCategories();
	DocumentCategoryDTO insertDocuemntCategory(DocumentCategoryDTO docuemntCategoryDTOinsert) throws IdmsBaseException;
	DocumentCategoryDTO retrieveDocuemntCategoryById(Long categoryId) throws IdmsBaseException;
	DocumentCategoryDTO updateDocuemntCategory(DocumentCategoryDTO docuemntCategoryDTOUpdate) throws IdmsBaseException;
	  	Boolean deleteById(Long categoryId) throws IdmsBaseException;

}

