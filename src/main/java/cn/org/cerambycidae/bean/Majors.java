package cn.org.cerambycidae.bean;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class Majors {
	private List<SelectItem> majors;
	private List<SelectItem> specials; 
	private SelectItem special;
	private SelectItem major;
	
	public Majors(){
		specials= new ArrayList<SelectItem>();
		majors = new ArrayList<SelectItem>();
		
		specials.add(new SelectItem("Computer"));
		specials.add(new SelectItem("Software"));
		specials.add(new SelectItem("Network"));
		special=specials.get(0);
		majors.add(new SelectItem("C1"));
		majors.add(new SelectItem("C2"));
		majors.add(new SelectItem("C3"));
		majors.add(new SelectItem("C4"));
		major=majors.get(0);
	}

	public List<SelectItem> getMajors() {
		return majors;
	}

	public void setMajors(List<SelectItem> majs) {
		majors = majs;
	}

	public List<SelectItem> getSpecials() {
		return specials;
	}

	public void setSpecials(List<SelectItem> spes) {
		specials = spes;
	}

	public SelectItem getSpecial() {
		return special;
	}

	public void setSpecial(SelectItem spe) {
		special = spe;
		this.ChangeSpec();
	}

	public SelectItem getMajor() {
		return major;
	}

	public void setMajor(SelectItem maj) {
		major = maj;
		String majorAsString=major.getValue().toString();
		
		if (majorAsString=="C1" || majorAsString=="C2" || majorAsString=="C3" || majorAsString=="C4" ){
			special=specials.get(0);			
		}
		if (majorAsString=="S1" || majorAsString=="S2" || majorAsString=="S3"){
			special=specials.get(1);
		}
		if (majorAsString=="N1" || majorAsString=="N2" || majorAsString=="N3"){
			special=specials.get(2);
		}
	}
	
	public void ChangeSpec(){
		String specAsStr=special.getValue().toString();
		if(specAsStr=="Computer"){
			majors.clear();
			majors.add(new SelectItem("C1"));
			majors.add(new SelectItem("C2"));
			majors.add(new SelectItem("C3"));
			majors.add(new SelectItem("C4"));
			major=majors.get(0);
		}
		if(specAsStr=="Software"){
			majors.clear();
			majors.add(new SelectItem("S1"));
			majors.add(new SelectItem("S2"));
			majors.add(new SelectItem("S3"));
			major=majors.get(0);
		}
		if(specAsStr=="Network"){
			majors.clear();
			majors.add(new SelectItem("N1"));
			majors.add(new SelectItem("N2"));
			majors.add(new SelectItem("N3"));
			major=majors.get(0);
		}
		
	}
	
	public void SpecialChanged(ValueChangeEvent event){
		SelectItem selected=(SelectItem)event.getNewValue();
		this.special=selected;
		this.ChangeSpec();		
	}
}
