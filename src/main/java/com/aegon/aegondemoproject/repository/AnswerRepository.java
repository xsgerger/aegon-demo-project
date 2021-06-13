package com.aegon.aegondemoproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aegon.aegondemoproject.entity.AnswerEntity;

@Repository
public interface AnswerRepository  extends JpaRepository<AnswerEntity, String> {

	List<AnswerEntity> findAllBySurveyId(String id);

}
