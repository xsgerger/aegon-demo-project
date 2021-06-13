package com.aegon.aegondemoproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.aegondemoproject.entity.AnswerEntity;
import com.aegon.aegondemoproject.service.AnswerService;

@RequestMapping("/answer")
@RestController
@CrossOrigin(origins = "*")
public class AnswerController {

	private final AnswerService answerService;

	public AnswerController(AnswerService answerService) {
		this.answerService = answerService;
	}

	@GetMapping
	public List<AnswerEntity> findAllAnswers() {
		return answerService.getAnswersList();
	}

	@GetMapping("/topic/{id}")
	public List<AnswerEntity> listAnswersByTopic(@PathVariable String topicId) {
		return answerService.getAnswersByTopicList(topicId);
	}

	@PostMapping
	public AnswerEntity saveAnswer(@RequestBody AnswerEntity answer) {
		return answerService.saveAnswer(answer);
	}
}
