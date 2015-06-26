package com.org.webService.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.org.webService.entity.WebService;
import com.org.webService.entity.WebServiceKey;
import com.org.webService.service.WebServiceJob;

@SessionScoped
@ManagedBean(name = "webServiceBean")
public class WebServiceBean {
	
	@Inject
	WebService webService;
	
	@Inject
	WebServiceKey webServiceKey;
	
	@PostConstruct
	public void init(){
		limparDados();
	}
	
	public void adicionarKeyFrom(){
		if(getWebServiceKey().getKey()!= null && !getWebServiceKey().getKey().equals("")
				&& getWebServiceKey().getValue()!= null && !getWebServiceKey().getValue().equals("")){
			getWebService().getListKeyFrom().add(getWebServiceKey());
			limparWebServiceKey();
		}
	}
	
	public void adicionarKeyTo(){
		if(getWebServiceKey().getKey()!= null && !getWebServiceKey().getKey().equals("")
				&& getWebServiceKey().getValue()!= null && !getWebServiceKey().getValue().equals("")){
			getWebService().getListKeyTo().add(getWebServiceKey());
			limparWebServiceKey();
		}
	}
	
	public void testarUrlFromGet(){
		if(getWebService().getUrlFrom()!= null){
			WebServiceJob webServiceJob = new WebServiceJob();
			String resposta = webServiceJob.testarWebServiceGet(getWebService().getUrlFrom());
			getWebService().setRespostaFrom(resposta);
		}
	}
	
	public void testarUrlPost(){
		
	}
	
	
	
	public void removerKeyTo(WebServiceKey webKey){
		getWebService().getListKeyTo().remove(webKey);
	}
	
	public void removerKeyFrom(WebServiceKey webKey){
		getWebService().getListKeyFrom().remove(webKey);
	}
	
	public void limparDados(){
		setWebService(new WebService());
		setWebServiceKey(new WebServiceKey());
	}
	
	public void limparWebServiceKey(){
		setWebServiceKey(new WebServiceKey());
	}

	public WebService getWebService() {
		return webService;
	}

	public void setWebService(WebService webService) {
		this.webService = webService;
	}

	public WebServiceKey getWebServiceKey() {
		return webServiceKey;
	}

	public void setWebServiceKey(WebServiceKey webServiceKey) {
		this.webServiceKey = webServiceKey;
	}

}

