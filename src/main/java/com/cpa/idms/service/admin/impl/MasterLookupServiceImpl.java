package com.cpa.idms.service.admin.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.idms.backend.dao.admin.MasterLookupRepository;
import com.cpa.idms.backend.dao.admin.entities.MasterLookup;
import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.service.admin.MasterLookupService;
import com.cpa.idms.service.admin.dto.MasterLookupDTO;
import com.cpa.idms.service.admin.dto.mapper.MasterLookupMapper;

@Service
public class MasterLookupServiceImpl implements MasterLookupService {
	private static final Logger LOG = LoggerFactory.getLogger(MasterLookupServiceImpl.class);
	
	@Autowired
	private MasterLookupRepository masterLookupRepo;
	
	@Autowired
	private MasterLookupMapper masterLookupMapper;
	
	@Autowired
	private IDMSBaseService ehrBaseService;
	
	@Override
	public List<String> retrieveAllMasterLookupType(Long organizationId) {
		try {
			return masterLookupRepo.findAllMasterLookupType(organizationId);
		}
		catch (Exception e){
			LOG.error("Error while retrieving all Master Lookup Types {} ", e);
		}
		return Collections.emptyList();
	}
	

	@Override
	public List<MasterLookupDTO> retrieveAllMasterLookup(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllActiveMasterLookup(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving all Master Lookup {} ", e);
		}
		return Collections.emptyList();
	}
	
	
	@Override
	public List<MasterLookupDTO> retrieveAllAddressStates(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllAddressStates(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving address states {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<MasterLookupDTO> retrieveAllPatientStatus(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllPatientStatus(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving patient status {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<MasterLookupDTO> retrieveAllCredentials(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllCredentials(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving credential {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<MasterLookupDTO> retrieveAllProviderTypes(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllProviderTypes(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving credential {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<MasterLookupDTO> retrieveAllSpecialisationForStud() {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllSpecialiazationTypes();
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving credential {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<MasterLookupDTO> retrieveAllFrequency(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllFrequency(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving frequency {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<MasterLookupDTO> retrieveAllRoute(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllRoute(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving Route {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<MasterLookupDTO> retrieveAllTitle(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllTitle(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving patient status {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public MasterLookupDTO persistMasterLookup(MasterLookupDTO masterLookupDTO) {
		try {
			if(masterLookupDTO != null) {
				MasterLookup newMasterLookup = masterLookupMapper.masterLookupDTOToEntity(masterLookupDTO);
				MasterLookup createdMasterLookup = masterLookupRepo.save(newMasterLookup);
				return (createdMasterLookup != null) ? masterLookupMapper.entityToMasterLookupDTO(createdMasterLookup) : null;
			}
		}
		catch (Exception e){
			LOG.error("Error while inserting master lookup{} ", e);
		}
		return null;
	}


	@Override
	public boolean deleteMasterLookupById(Long lookupId) {
		try {
			StaffMember loginUser = ehrBaseService.currentUser();
			MasterLookup masterToDelete = masterLookupRepo.findOne(lookupId);
			if (masterToDelete != null) {
				masterToDelete.setLastUpdatedBy(loginUser.getLoginId());
				masterToDelete.setLastUpdatedDate(new Date());
				masterToDelete.setActiveFlag("N");
				masterLookupRepo.saveAndFlush(masterToDelete);
			}
		}
		catch (Exception e){
			LOG.error("Error while removing Master Lookup" ,e);
		}
		return false;
	}


	@Override
	public List<MasterLookupDTO> retriveAllMasterLookupByRefill(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllMasterLookUpByRefillType(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving patient status {} ", e);
		}
		return Collections.emptyList();
	}


	@Override
	public List<MasterLookupDTO> retriveAllMasterLookupByDISCONTINUEDREASON(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllMasterLookUpByDISCONTINUEDREASONType(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving patient status {} ", e);
		}
		return Collections.emptyList();
	}


	@Override
	public List<MasterLookupDTO> retrieveAllRace(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllRace(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving patient status {} ", e);
		}
		return Collections.emptyList();
	}


	@Override
	public List<MasterLookupDTO> retrieveAllEthnicity(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllEthnicity(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving patient status {} ", e);
		}
		return Collections.emptyList();
	
	}


	@Override
	public List<MasterLookupDTO> retrieveAllLanguage(Long organizationId) {
		try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAllLanguages(organizationId);
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving patient status {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public MasterLookupDTO retrieveMasterLookupById(Long lookupId) throws IdmsBaseException{
		try {
		if(lookupId != null) {
			MasterLookup masterLookup = masterLookupRepo.findOne(lookupId);
			return (masterLookup != null) ? masterLookupMapper.entityToMasterLookupDTO(masterLookup) : null;
		}
		}catch (Exception e) {
			LOG.error("Error Message",e);
		}
		return null;
	}
	
	@Override
	public List<MasterLookupDTO> retrieveAllMasterLookup() throws IdmsBaseException {
	try {
			List<MasterLookup> masterLookupList = masterLookupRepo.findAll();
			return (masterLookupList != null) ? masterLookupMapper.entityListToMasterLookupDTOList(masterLookupList) : null;
		} catch (Exception e) {
		LOG.error("Error message",e);		
		}
		return Collections.emptyList();
	}
	
	@Override
	public 	MasterLookupDTO updateMasterLookup(MasterLookupDTO masterLookupDTOUpdate) throws IdmsBaseException{
	try{
		if(masterLookupDTOUpdate !=null){
						MasterLookup masterLookup = masterLookupMapper.masterLookupDTOToEntity(masterLookupDTOUpdate);
				MasterLookup UpdatedmasterLookup = masterLookupRepo.saveAndFlush(masterLookup);
				return (UpdatedmasterLookup != null) ? masterLookupMapper.entityToMasterLookupDTO(UpdatedmasterLookup) : null;
					
		}
	}
	catch (Exception e){
			LOG.error("Error while updating MasterLookup {} ", e);
		}
	return null;
	}
	
	
}
