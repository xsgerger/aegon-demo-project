package com.aegon.aegondemoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aegon.aegondemoproject.entity.SurveyEntity;

@Repository
public interface SurveyRepository extends JpaRepository<SurveyEntity, String> {

}
