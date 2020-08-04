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
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "utilisateur")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_utilisateur;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String username;
	@Column
	private String adresse;//min
	@Column
	private String langue;//min
	@Column
	private String nationnalite;
	@Column
	private Date dateAjout;
	@Column
	private Date dateModif;
	@Email
	@Column
	private String email;
	@Column
	private String password;
	
	@ManyToMany
	@JoinTable(name = "utilisateur_has_association", joinColumns = @JoinColumn(name = "id_utilisateur"), inverseJoinColumns = @JoinColumn(name = " id_association"))
	List<Association> associations;

	@ManyToOne
	private Role role;

	@ManyToOne
	private Pays pays;

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(Long id_utilisateur, String nom, String prenom, String username, String adresse, String langue,
			String nationnalite, Date dateAjout, Date dateModif, @Email String email, String password,
			List<Association> associations, Role role, Pays pays) {
		super();
		this.id_utilisateur = id_utilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.adresse = adresse;
		this.langue = langue;
		this.nationnalite = nationnalite;
		this.dateAjout = dateAjout;
		this.dateModif = dateModif;
		this.email = email;
		this.password = password;
		this.associations = associations;
		this.role = role;
		this.pays = pays;
	}

	public Long getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(Long id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String getNationnalite() {
		return nationnalite;
	}

	public void setNationnalite(String nationnalite) {
		this.nationnalite = nationnalite;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public Date getDateModif() {
		return dateModif;
	}

	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Association> getAssociations() {
		return associations;
	}

	public void setAssociations(List<Association> associations) {
		this.associations = associations;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Utilisateur [id_utilisateur=" + id_utilisateur + ", nom=" + nom + ", prenom=" + prenom + ", username="
				+ username + ", adresse=" + adresse + ", langue=" + langue + ", nationnalite=" + nationnalite
				+ ", dateAjout=" + dateAjout + ", dateModif=" + dateModif + ", email=" + email + ", password="
				+ password + ", associations=" + associations + ", role=" + role + ", pays=" + pays + "]";
	}

	

}
