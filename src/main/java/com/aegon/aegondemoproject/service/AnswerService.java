package com.aegon.aegondemoproject.service;

import java.util.List;

import com.aegon.aegondemoproject.entity.AnswerEntity;

public interface AnswerService {
	
	AnswerEntity saveAnswer(AnswerEntity answer);

	List<AnswerEntity> getAnswersByTopicList(String topicId);

	List<AnswerEntity> getAnswersList();

}
