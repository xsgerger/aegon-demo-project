package com.aegon.aegondemoproject;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.aegon.aegondemoproject.entity.SurveyEntity;
import com.aegon.aegondemoproject.repository.SurveyRepository;
import com.aegon.aegondemoproject.service.SurveyServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class AegonDemoProjectApplicationTests {

	@InjectMocks
	private SurveyServiceImpl surveyService;
	@Mock
	private SurveyRepository surveyRepository;

	@Test
	public void saveSurvey() {
		SurveyEntity surveyEntity = new SurveyEntity();
		surveyEntity.setId(UUID.randomUUID().toString());
		surveyEntity.setTopic("Test");
		surveyEntity.setNpmScore(0);
		when(surveyService.saveSurvey(surveyEntity)).thenReturn(surveyEntity);
		assertEquals(surveyEntity, surveyService.saveSurvey(surveyEntity));
	}

}
