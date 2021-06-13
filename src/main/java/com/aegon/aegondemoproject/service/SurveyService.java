package com.aegon.aegondemoproject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aegon.aegondemoproject.entity.SurveyEntity;

public interface SurveyService {

	SurveyEntity saveSurvey(SurveyEntity survey);

	List<SurveyEntity> getSurveysList();

	ResponseEntity<SurveyEntity> getSurveyById(String topicId);
}
