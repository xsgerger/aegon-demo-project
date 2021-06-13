package com.aegon.aegondemoproject.view;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Controller;

import com.aegon.aegondemoproject.controller.SurveyController;
import com.aegon.aegondemoproject.entity.SurveyEntity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Controller
@Data
@ViewScoped
@RequiredArgsConstructor
public class SurveyViewController implements Serializable {
	private static final long serialVersionUID = -7166489747466741103L;


	private final transient SurveyController surveyController;
	private final transient AnswerViewController answerViewController;
	private SurveyEntity surveyEntity;
	private List<SurveyEntity> surveyEntityList;

	@PostConstruct
	public void viewOlustur() {
		newSurvey();
		surveyEntityList=surveyController.findAllSurveys();
	}

	public void save (){
		this.surveyEntity= surveyController.saveSurvey(this.surveyEntity);
		viewOlustur();
	}

	public void newSurvey(){
		surveyEntity=new SurveyEntity();

	}

	public void answerRedirect() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("/answer.xhtml");
		answerViewController.viewOlustur(surveyEntity);
	}
	public void allAnswerRedirect() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("/answer.xhtml");
		answerViewController.viewOlustur(null);
	}

}
