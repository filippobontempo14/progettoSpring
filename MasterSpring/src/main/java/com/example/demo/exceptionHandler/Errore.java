package com.example.demo.exceptionHandler;

public class Errore {
	
	private String msg,path,nomeStatus;
	private int status;
	
	public Errore() {
		
	}

	public Errore(int status,String nomeStatus, String msg, String path) {
		
		this.msg = msg;
		this.path = path;
		this.nomeStatus = nomeStatus;
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getNomeStatus() {
		return nomeStatus;
	}

	public void setNomeStatus(String nomeStatus) {
		this.nomeStatus = nomeStatus;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
