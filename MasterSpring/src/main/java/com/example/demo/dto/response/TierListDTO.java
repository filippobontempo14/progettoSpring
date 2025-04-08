package com.example.demo.dto.response;

import java.util.ArrayList;
import java.util.List;

public class TierListDTO {
	
	private List <String> s=new ArrayList<>();
	private List <String> a=new ArrayList<>();
	private List <String> b=new ArrayList<>();
	private List <String> c=new ArrayList<>();
	private List <String> d=new ArrayList<>();
	
	public TierListDTO() {
		
	}
	public List<String> getS() {
		return s;
	}
	public void setS(List<String> s) {
		this.s = s;
	}
	public List<String> getA() {
		return a;
	}
	public void setA(List<String> a) {
		this.a = a;
	}
	public List<String> getB() {
		return b;
	}
	public void setB(List<String> b) {
		this.b = b;
	}
	public List<String> getC() {
		return c;
	}
	public void setC(List<String> c) {
		this.c = c;
	}
	public List<String> getD() {
		return d;
	}
	public void setD(List<String> d) {
		this.d = d;
	}
	
	
}
