package com.aegon.aegondemoproject.view;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Controller;

import com.aegon.aegondemoproject.controller.AnswerController;
import com.aegon.aegondemoproject.controller.SurveyController;
import com.aegon.aegondemoproject.entity.AnswerEntity;
import com.aegon.aegondemoproject.entity.SurveyEntity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Controller
@Data
@ViewScoped
@RequiredArgsConstructor
public class AnswerViewController implements Serializable {
	private static final long serialVersionUID = -7166489747466741103L;


	private final transient AnswerController answerController;
	private AnswerEntity answerEntity;
	private List<AnswerEntity> answerEntityList;
	private SurveyEntity surveyEntity;
	private List<AnswerEntity> answerAllEntityList;
	private boolean allAnswerRendered;
	private List<Integer> scoreList=new ArrayList<>();


	public void viewOlustur(SurveyEntity surveyEntity) {
		if(surveyEntity==null){
			this.answerAllEntityList=answerController.findAllAnswers();
			allAnswerRendered=true;
		}else{
			this.surveyEntity=surveyEntity;
			searchList();
			allAnswerRendered=false;
		}

	}

	public void save (){
		this.answerEntity= answerController.saveAnswer(this.answerEntity);
		searchList();
	}

	private void searchList(){
		newAnswer();
		this.answerEntityList=answerController.listAnswersByTopic(surveyEntity.getId());

	}
	public void newAnswer(){
		answerEntity=new AnswerEntity(this.surveyEntity);

	}

	public void surveyRedirect() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("/survey.xhtml");

	}

}
