package com.cpa.idms.backend.dao.admin;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.idms.backend.dao.admin.constants.DepartmentConstants;
import com.cpa.idms.backend.dao.admin.constants.DocumentCategoryConstants;
import com.cpa.idms.backend.dao.admin.entities.Department;
import com.cpa.idms.backend.dao.admin.entities.DocumentCategory;


@Repository
@Transactional
public interface DocumentCategoryRepository extends JpaRepository<DocumentCategory,Long> {
	
	@Query(value = DocumentCategoryConstants.FIND_ALL_DOCUMENT_CATEGORIES, nativeQuery = true)
	List <DocumentCategory> findAllDocumentCategories();
	
	
}
