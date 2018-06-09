package br.com.agenda.core.profile;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_profile")
public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME", length=60)
	@Enumerated(EnumType.STRING)
	private ProfileType name;

	public Profile() {
	}
	
	
	
	public Profile(ProfileType name) {
		super();
		this.name = name;
	}

	public ProfileType getName() {
		return name;
	}

	public void setName(ProfileType name) {
		this.name = name;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}
	
	

}
