package com.aegon.aegondemoproject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aegon.aegondemoproject.entity.SurveyEntity;
import com.aegon.aegondemoproject.repository.SurveyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SurveyServiceImpl implements SurveyService{

	private final SurveyRepository surveyRepository;

	@Override
	public SurveyEntity saveSurvey(SurveyEntity survey) {
		return surveyRepository.saveAndFlush(survey);
	}

	@Override
	public List<SurveyEntity> getSurveysList() {

		return surveyRepository.findAll();
	}

	@Override
	public ResponseEntity<SurveyEntity> getSurveyById(String topicId) {
		SurveyEntity survey = surveyRepository.findById(topicId)
				.orElse(null);
		return ResponseEntity.ok(survey);
	}
}
