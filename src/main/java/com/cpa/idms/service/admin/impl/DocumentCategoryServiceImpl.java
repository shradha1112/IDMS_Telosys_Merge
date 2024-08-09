package com.cpa.idms.service.admin.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.idms.backend.dao.admin.DepartmentRepository;
import com.cpa.idms.backend.dao.admin.DocumentCategoryRepository;
import com.cpa.idms.backend.dao.admin.entities.Department;
import com.cpa.idms.backend.dao.admin.entities.DocumentCategory;
import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.DepartmentService;
import com.cpa.idms.service.admin.DocumentCategoryService;
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.service.admin.dto.DepartmentDTO;
import com.cpa.idms.service.admin.dto.DocumentCategoryDTO;
import com.cpa.idms.service.admin.dto.mapper.DepartmentMapper;
import com.cpa.idms.service.admin.dto.mapper.DocumentCategoryMapper;
import com.cpa.idms.util.FormatConverterUtils;


@Service
public class DocumentCategoryServiceImpl implements DocumentCategoryService {
	private static final Logger LOG = LoggerFactory.getLogger(DocumentCategoryServiceImpl.class);
	
	@Autowired
	private DocumentCategoryRepository documentCategoryRepo;
	
	@Autowired
	private DocumentCategoryMapper documentCategoryMapper;
	
	@Autowired
	private IDMSBaseService idmsBaseService;
	
	
	@Override
	public List<DocumentCategoryDTO> retrieveAllDocumentCategories() {
		try {
			System.out.println("In interfaceeee department servicee impl");
			List<DocumentCategory> documentCategoryList = documentCategoryRepo.findAllDocumentCategories();
		
			return (documentCategoryList != null) ? documentCategoryMapper.entityListTodocumentCategoryDTOList(documentCategoryList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving all document categories ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public DocumentCategoryDTO insertDocuemntCategory(DocumentCategoryDTO docuemntCategoryDTOinsert) throws IdmsBaseException{
	try {
			if (docuemntCategoryDTOinsert != null) {
				DocumentCategory docuemntCategory = documentCategoryMapper.documentCategoryDTOToEntity(docuemntCategoryDTOinsert);
				DocumentCategory inserteddocuemntCategory = documentCategoryRepo.save(docuemntCategory);

				return (inserteddocuemntCategory != null) ? documentCategoryMapper.entityToDocumentCategoryDTO(inserteddocuemntCategory) : null;
			}
		} catch (Exception e) {
			LOG.error("Error while inserting DocuemntCategory {} ", e);
		}
		return null;
	}

	@Override
		public DocumentCategoryDTO retrieveDocuemntCategoryById(Long categoryId) throws IdmsBaseException{
	try {
			if(categoryId != null) {
				DocumentCategory docuemntCategory = documentCategoryRepo.findOne(categoryId);
				return (docuemntCategory != null) ? documentCategoryMapper.entityToDocumentCategoryDTO(docuemntCategory) : null;
			}
		}catch (Exception e) {
				LOG.error("Error Message",e);
		}
		return null;
	}
	
	@Override
	public 	DocumentCategoryDTO updateDocuemntCategory(DocumentCategoryDTO docuemntCategoryDTOUpdate) throws IdmsBaseException{
	try{
		if(docuemntCategoryDTOUpdate !=null){
			DocumentCategory docuemntCategory = documentCategoryMapper.documentCategoryDTOToEntity(docuemntCategoryDTOUpdate);
			DocumentCategory UpdateddocuemntCategory = documentCategoryRepo.saveAndFlush(docuemntCategory);
			return (UpdateddocuemntCategory != null) ? documentCategoryMapper.entityToDocumentCategoryDTO(UpdateddocuemntCategory) : null;
					
		}
	}
	catch (Exception e){
			LOG.error("Error while updating DocuemntCategory {} ", e);
		}
	return null;
	}


	@Override
	public Boolean deleteById(Long categoryId) throws IdmsBaseException{
	try {
		DocumentCategory docuemntCategory = documentCategoryRepo.findOne(categoryId);
			if (docuemntCategory != null) {
				StaffMember loginUser = idmsBaseService.currentUser();
				FormatConverterUtils.setInitialDeleteValues(docuemntCategory, loginUser);
				documentCategoryRepo.saveAndFlush(docuemntCategory);
				return true;
			}
		} catch (Exception e) {
			LOG.error("Error while deleting DocuemntCategory {} ", e);
		}
		return false;


	}

}