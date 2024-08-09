package com.cpa.idms.web.rest.admin;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.DepartmentService;
import com.cpa.idms.service.admin.DocumentCategoryService;
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.service.admin.ProjectService;
import com.cpa.idms.service.admin.dto.DepartmentDTO;
import com.cpa.idms.service.admin.dto.DocumentCategoryDTO;
import com.cpa.idms.service.admin.dto.ProjectDTO;
import com.cpa.idms.util.FormatConverterUtils;

@RestController
@RequestMapping("/api/rest/admin")
@CrossOrigin(origins = {"http://localhost:4300"})
public class DocumentCategoryWebService {
	
	private static final Logger LOG = LoggerFactory.getLogger( DocumentCategoryWebService.class);

	
	@Autowired
	private DocumentCategoryService documentCategoryService;
	
	@Autowired
	private IDMSBaseService idmsBaseService;



	@GetMapping("/getListOfDocumentCategories")
	public ResponseEntity<List <DocumentCategoryDTO>> getListOfDocumentCategories() {
		List<DocumentCategoryDTO> documentCategoryListResp = documentCategoryService.retrieveAllDocumentCategories();
		return new ResponseEntity<> (documentCategoryListResp, HttpStatus.OK);
		
	}	
	
	@PostMapping("/createDocuemntCategory")
	public ResponseEntity<DocumentCategoryDTO> insertDocuemntCategory(@RequestBody DocumentCategoryDTO docuemntCategoryDTO){
		try{
				if(docuemntCategoryDTO!=null) {				
					StaffMember loginUser = idmsBaseService.currentUser();
					FormatConverterUtils.setInitialDefaultValues(docuemntCategoryDTO, loginUser);
				
					DocumentCategoryDTO datadocuemntCategoryDTO = documentCategoryService.insertDocuemntCategory(docuemntCategoryDTO);
					return new ResponseEntity<> (datadocuemntCategoryDTO, HttpStatus.OK);
			}
		}catch (Exception e) {
			LOG.error("Error while inserting DocuemntCategory {}",e);
		}
		
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	}
	
	@GetMapping("/getDocuemntCategoryById")
	public ResponseEntity<DocumentCategoryDTO> getDocuemntCategoryById(@RequestParam("id") Long categoryId) {
		DocumentCategoryDTO docuemntCategoryDTO;
		try {
			docuemntCategoryDTO =  documentCategoryService.retrieveDocuemntCategoryById( categoryId);
			return new ResponseEntity<> (docuemntCategoryDTO, HttpStatus.OK);
		} catch (IdmsBaseException e) {
			LOG.error("Error while retrieving By DocuemntCategory ID {}",e);
		}
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers , HttpStatus.NOT_IMPLEMENTED);
	}


	
	@PutMapping("/updateDocuemntCategory")
	public ResponseEntity<DocumentCategoryDTO> updateDocuemntCategory(@RequestBody DocumentCategoryDTO docuemntCategoryDTO){
		try{
			  if(docuemntCategoryDTO!=null) {				
				StaffMember loginUser = idmsBaseService.currentUser();
				FormatConverterUtils.setInitialDefaultValues(docuemntCategoryDTO, loginUser);
				DocumentCategoryDTO datadocuemntCategoryDTO = documentCategoryService.updateDocuemntCategory(docuemntCategoryDTO);
				return new ResponseEntity<> (datadocuemntCategoryDTO, HttpStatus.OK);
			}
		}catch (Exception e) {
			LOG.error("Error while updating DocuemntCategory {}",e);
		}
		
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	}


	@DeleteMapping("/removeDocuemntCategoryById")
	public ResponseEntity<Void> deleteDocuemntCategoryById(@Valid @RequestParam("id") Long categoryId){
	HttpHeaders headers= new HttpHeaders();
		try {
			Boolean flag = documentCategoryService.deleteById(categoryId);
			if(flag)
				return new ResponseEntity<> (headers, HttpStatus.OK);
			else
				return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
		}catch (Exception e) {
			LOG.error("Error while deleting By DocuemntCategory ID {}",e);
		}
		
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	
	}
	
	
}
