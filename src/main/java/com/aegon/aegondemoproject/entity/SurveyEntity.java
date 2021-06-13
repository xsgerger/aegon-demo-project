package com.aegon.aegondemoproject.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode (callSuper = true)
public class SurveyEntity extends BaseEntity {

	private String topic;

	private int npmScore;
}
