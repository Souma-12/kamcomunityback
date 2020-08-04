package com.association.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "association")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Association implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_association;
	@Column
	private String nom;
	@Column
	private String presentation;
	@Column
	private String siteWeb;
	@Column
	private String adresse;
	@Column
	private Long taille;
	@Column
	private String type;
	@Column
	private Date fondation;
	@Column
	private String logo;
	@Column
	private Long tel;
	@Column
	private String email;
	
	
	@ManyToOne
	private Pays pays;

	@ManyToMany
	@JoinTable(name = "reseau_has_association", joinColumns = @JoinColumn(name = "id_reseau"), inverseJoinColumns = @JoinColumn(name = "id_association"))
	List<Reseau> reseaux;

	public Association() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Association(Long id_association, String nom, String presentation, String siteWeb, String adresse,
			Long taille, String type, Date fondation, String logo, Long tel, String email, Pays pays,
			List<Reseau> reseaux) {
		super();
		this.id_association = id_association;
		this.nom = nom;
		this.presentation = presentation;
		this.siteWeb = siteWeb;
		this.adresse = adresse;
		this.taille = taille;
		this.type = type;
		this.fondation = fondation;
		this.logo = logo;
		this.tel = tel;
		this.email = email;
		this.pays = pays;
		this.reseaux = reseaux;
	}

	public Long getId_association() {
		return id_association;
	}

	public void setId_association(Long id_association) {
		this.id_association = id_association;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Long getTaille() {
		return taille;
	}

	public void setTaille(Long taille) {
		this.taille = taille;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getFondation() {
		return fondation;
	}

	public void setFondation(Date fondation) {
		this.fondation = fondation;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public List<Reseau> getReseaux() {
		return reseaux;
	}

	public void setReseaux(List<Reseau> reseaux) {
		this.reseaux = reseaux;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Association [id_association=" + id_association + ", nom=" + nom + ", presentation=" + presentation
				+ ", siteWeb=" + siteWeb + ", adresse=" + adresse + ", taille=" + taille + ", type=" + type
				+ ", fondation=" + fondation + ", logo=" + logo + ", tel=" + tel + ", email=" + email + ", pays=" + pays
				+ ", reseaux=" + reseaux + "]";
	}

	
	
}
