package com.org.webService.entity;

import java.util.ArrayList;
import java.util.List;

public class WebService {
	
	private Long id;
	
	private String urlFrom;
	
	private List<WebServiceKey> listKeyFrom;
	
	private String urlTo;
	
	private List<WebServiceKey> listKeyTo;
	
	private String respostaFrom;
	
	private String respostaTo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrlFrom() {
		return urlFrom;
	}

	public void setUrlFrom(String urlFrom) {
		this.urlFrom = urlFrom;
	}

	public String getUrlTo() {
		return urlTo;
	}

	public void setUrlTo(String urlTo) {
		this.urlTo = urlTo;
	}

	public List<WebServiceKey> getListKeyFrom() {
		if(listKeyFrom == null){
			listKeyFrom = new ArrayList<WebServiceKey>();
		}
		return listKeyFrom;
	}

	public void setListKeyFrom(List<WebServiceKey> listKeyFrom) {
		this.listKeyFrom = listKeyFrom;
	}

	public List<WebServiceKey> getListKeyTo() {
		if(listKeyTo == null){
			listKeyTo = new ArrayList<WebServiceKey>();
		}
		return listKeyTo;
	}

	public void setListKeyTo(List<WebServiceKey> listKeyTo) {
		this.listKeyTo = listKeyTo;
	}

	public String getRespostaFrom() {
		return respostaFrom;
	}

	public void setRespostaFrom(String respostaFrom) {
		this.respostaFrom = respostaFrom;
	}

	public String getRespostaTo() {
		return respostaTo;
	}

	public void setRespostaTo(String respostaTo) {
		this.respostaTo = respostaTo;
	}

}
