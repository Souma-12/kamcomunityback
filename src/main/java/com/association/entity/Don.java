package com.association.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "don")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Don implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private double montant;
	@Column
	@CreationTimestamp
	private Date dateAjout;
	@Column
	private String description;

	@ManyToOne
	@JoinColumn(name="utilisateur_id")
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="association_id")
	private Association association;

	public Don() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Don(Long id, double montant, Date dateAjout, String description, Utilisateur utilisateur,
			Association association) {
		super();
		this.id = id;
		this.montant = montant;
		this.dateAjout = dateAjout;
		this.description = description;
		this.utilisateur = utilisateur;
		this.association = association;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	@Override
	public String toString() {
		return "Don [id=" + id + ", montant=" + montant + ", dateAjout=" + dateAjout + ", description=" + description
				+ ", utilisateur=" + utilisateur + ", association=" + association + "]";
	}

	
}
