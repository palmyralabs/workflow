package com.palmyralabs.workflow.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.palmyralabs.workflow.entity.ActionTypeEntity;
import com.palmyralabs.workflow.model.ActionTypeModel;
import com.palmyralabs.workflow.service.TestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TestController {

	private final TestService testService;

	@GetMapping("/get/repoCall")
	public ActionTypeEntity getValue(@RequestParam(value = "id") String id) {
		return testService.findById(id);
	}

	@PostMapping("/post/repoCall")
	public ActionTypeEntity postValue(@RequestBody ActionTypeModel model) {
		return testService.save(model);
	}

	@PutMapping("/put/repoCall")
	public ActionTypeEntity putValue(@RequestBody ActionTypeModel model) {
		return testService.put(model);
	}
	
	@DeleteMapping("/delete/repoCall")
	public ActionTypeModel deleteValue(@RequestBody ActionTypeModel model) {
		return testService.delete(model);
	}

}
