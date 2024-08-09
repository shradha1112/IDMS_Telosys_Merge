package com.cpa.idms.service.admin.dto.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.cpa.idms.backend.dao.admin.entities.MasterLookup;
import com.cpa.idms.service.admin.dto.MasterLookupDTO;

@Mapper(componentModel = "spring",
imports = {com.cpa.idms.util.FormatConverterUtils.class})
public abstract class MasterLookupMapper {

	
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	public abstract MasterLookupDTO entityToMasterLookupDTO(MasterLookup entity);

	public abstract MasterLookup masterLookupDTOToEntity(MasterLookupDTO dto);

	public abstract List<MasterLookupDTO> entityListToMasterLookupDTOList(List<MasterLookup> entities);
}
