package com.cpa.idms.service.admin.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.cpa.idms.backend.dao.admin.OrganizationRepository;
import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.service.admin.dto.StaffMemberDTO;


/**
 * Mapper for the entity StaffMember and its DTO called StaffMember DTO
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */

@Mapper(componentModel = "spring",
imports = {com.cpa.idms.util.FormatConverterUtils.class})
public abstract class StaffMemberMapper {
	
	@Autowired
	public OrganizationRepository orgMapperRepo;

	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	@Mapping(target = "organizationId", expression = "java(entity.getOrganization().getOrganizationId())")
	public abstract StaffMemberDTO entityToStaffMemberDTO(StaffMember entity);

	/**
	 * Maps StaffMember DTO to Entity 
	 * 
	 * @param dto
	 * 		DTO of StaffMember
	 * @return ActivityType
	 * 		Entity of StaffMember
	 */
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
	@Mapping(target = "organization", expression = "java(orgMapperRepo.findOne(dto.getOrganizationId()))")
	public abstract StaffMember staffMemberDTOToEntity(StaffMemberDTO dto);

	/**
	 * Maps List of StaffMember Entities to DTOs
	 * 
	 * @param entities
	 * 		List of StaffMember entities
	 * @return 
	 * 		List of StaffMember DTOs
	 */
	public abstract List<StaffMemberDTO> entityListToStaffMemberDTOList(List<StaffMember> entities);


}
