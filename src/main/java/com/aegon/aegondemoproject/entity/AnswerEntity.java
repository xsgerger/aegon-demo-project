package com.aegon.aegondemoproject.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode (callSuper = true)
public class AnswerEntity extends BaseEntity {

	@Max (value = 10)
	@Positive
	private int score;

	private String feedback;

	@ManyToOne (targetEntity = SurveyEntity.class)
	private SurveyEntity survey;

	public AnswerEntity(SurveyEntity survey) {
		this.survey = survey;
	}
}
