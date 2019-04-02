package cn.org.cerambycidae.bean;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class Gender {
	private SelectItem[]  genders={
			new SelectItem("男"),
			new SelectItem("女")
	};
	private SelectItem selected_gender;
	
	public SelectItem[] getGenders() {
		return genders;
	}	
	public void setGenders(SelectItem[] genders) {
		this.genders = genders;
	}
	public SelectItem getSelected_gender() {
		return selected_gender;
	}
	public void setSelected_gender(SelectItem selected_gender) {
		this.selected_gender = selected_gender;
	}

	
}
