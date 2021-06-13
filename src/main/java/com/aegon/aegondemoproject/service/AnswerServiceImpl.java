package com.aegon.aegondemoproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.aegon.aegondemoproject.entity.AnswerEntity;
import com.aegon.aegondemoproject.entity.SurveyEntity;
import com.aegon.aegondemoproject.repository.AnswerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService{

	private final AnswerRepository answerRepository;
	private final SurveyService surveyService;

	@Override
	public AnswerEntity saveAnswer(AnswerEntity answer) {
		SurveyEntity surveyEntity = npmScoreCalculate(answer);
		answer.setSurvey(surveyEntity);
		answerRepository.save(answer);
		return answerRepository.save(answer);
	}

	/**
	 * https://www.wiseback.com/tr/nps-nedir-nps-nasil-hesaplanir/
	 * 0 – 6 = Detractor
	 * 7 – 8 = Passive
	 * 9 – 10 = Promoter
	 *
	 * NPS = (Promoter – Detractor) / (Total Answer) x 100
	 * @param answer
	 * @return
	 */
	private SurveyEntity npmScoreCalculate(AnswerEntity answer){
		List<AnswerEntity> answers = answerRepository.findAllBySurveyId(answer.getSurvey().getId());
		if(answers ==null){
			answers=new ArrayList<>();
		}
		answers.add(answer);
		int promoter=0;
		int detractor=0;
		for(AnswerEntity selectedAnswer:answers){
			if (selectedAnswer.getScore() >= 9) {
				promoter++;
			} else if (selectedAnswer.getScore() <= 6) {
				detractor++;
			}
		}
		int npmScore = (int) (100 * ((float) (promoter - detractor) / answers.size()));
		SurveyEntity survey = answer.getSurvey();
		survey.setNpmScore(npmScore);
		SurveyEntity surveyEntity = surveyService.saveSurvey(survey);
		return surveyEntity;

	}

	@Override
	public List<AnswerEntity> getAnswersByTopicList(String topicId) {
		return answerRepository.findAllBySurveyId(topicId);
	}

	@Override
	public List<AnswerEntity> getAnswersList() {
		return answerRepository.findAll();
	}
}
