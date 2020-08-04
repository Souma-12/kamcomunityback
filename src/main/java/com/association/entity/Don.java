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
	private Date date_creation;
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

	public Don(Long id, double montant, Date date_creation, String description, Utilisateur utilisateurs,
			Association associations) {
		super();
		this.id = id;
		this.montant = montant;
		this.date_creation = date_creation;
		this.description = description;
		this.utilisateur = utilisateurs;
		this.association = associations;
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

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Utilisateur getUtilisateurs() {
		return utilisateur;
	}

	public void setUtilisateurs(Utilisateur utilisateurs) {
		this.utilisateur = utilisateurs;
	}

	public Association getAssociations() {
		return association;
	}

	public void setAssociations(Association associations) {
		this.association = associations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Don [id=" + id + ", montant=" + montant + ", date_creation=" + date_creation + ", description="
				+ description + ", utilisateur=" + utilisateur + ", association=" + association + "]";
	}

}
