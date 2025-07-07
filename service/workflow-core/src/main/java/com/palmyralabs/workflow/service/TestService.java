package com.palmyralabs.workflow.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.palmyralabs.workflow.entity.ActionTypeEntity;
import com.palmyralabs.workflow.model.ActionTypeModel;
import com.palmyralabs.workflow.repository.ActionTypeRepository;

@Service
public class TestService {

	private ActionTypeRepository actionTypeRepo;

	public TestService(ActionTypeRepository actionTypeRepo) {
		this.actionTypeRepo = actionTypeRepo;
	}

	public ActionTypeEntity findById(String id) {
		return actionTypeRepo.findById(id).get();
	}

	public ActionTypeEntity save(ActionTypeModel model) {
		ActionTypeEntity entity = new ActionTypeEntity();

		entity.setId(model.getId());
		entity.setName(model.getName());
		entity.setCode(model.getCode());
		entity.setCreatedBy("Local User");
		entity.setCreatedOn(LocalDateTime.now());
		return actionTypeRepo.save(entity);
	}

	public ActionTypeEntity put(ActionTypeModel model) {
		ActionTypeEntity entity = new ActionTypeEntity();
		if(!actionTypeRepo.findById(model.getId()).isEmpty()) {
			entity = actionTypeRepo.findById(model.getId()).get();
			entity.setName(model.getName());
			entity.setCode(model.getCode());
			entity.setLastUpdBy("Test User");
			entity.setLastUpdOn(LocalDateTime.now());
			return actionTypeRepo.save(entity);
		}
		return entity;
	}

	public ActionTypeModel delete(ActionTypeModel model) {
		ActionTypeEntity entity = new ActionTypeEntity();

		entity.setId(model.getId());
		entity.setName(model.getName());
		entity.setCode(model.getCode());
		actionTypeRepo.delete(entity);
		
		return model;
	}
}
