package com.palmyralabs.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palmyralabs.workflow.entity.ActionTypeEntity;

@Repository
public interface ActionTypeRepository extends JpaRepository<ActionTypeEntity, String> {

}
