package com.aegon.aegondemoproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.aegondemoproject.entity.SurveyEntity;
import com.aegon.aegondemoproject.service.SurveyService;

@RequestMapping("/survey")
@RestController
@CrossOrigin(origins = "*")
public class SurveyController {

	private final SurveyService surveyService;

	public SurveyController(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	@PostMapping
	public SurveyEntity saveSurvey(@RequestBody SurveyEntity survey) {
		return surveyService.saveSurvey(survey);

	}

	@GetMapping
	public List<SurveyEntity> findAllSurveys() {
		return surveyService.getSurveysList();
	}
}
