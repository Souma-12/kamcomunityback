package com.association.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "message")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@CreationTimestamp
	private LocalDateTime dateAjout;

	@UpdateTimestamp
	private LocalDateTime dateModif;

	@NotNull
	@Enumerated(EnumType.STRING)
	private MessageStatut status = MessageStatut.UNREAD;

	@Column(name = "message", nullable = false)
	private String message;

	@Column(name = "readAt")
	private LocalDateTime readAt;

	@ManyToOne(optional = false)
	private Utilisateur sender;

	@ManyToOne(optional = false)
	private Utilisateur receiver;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(Long id, LocalDateTime dateAjout, LocalDateTime dateModif, @NotNull MessageStatut status,
			String message, LocalDateTime readAt, Utilisateur sender, Utilisateur receiver) {
		super();
		this.id = id;
		this.dateAjout = dateAjout;
		this.dateModif = dateModif;
		this.status = status;
		this.message = message;
		this.readAt = readAt;
		this.sender = sender;
		this.receiver = receiver;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(LocalDateTime dateAjout) {
		this.dateAjout = dateAjout;
	}

	public LocalDateTime getDateModif() {
		return dateModif;
	}

	public void setDateModif(LocalDateTime dateModif) {
		this.dateModif = dateModif;
	}

	public MessageStatut getStatus() {
		return status;
	}

	public void setStatus(MessageStatut status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getReadAt() {
		return readAt;
	}

	public void setReadAt(LocalDateTime readAt) {
		this.readAt = readAt;
	}

	public Utilisateur getSender() {
		return sender;
	}

	public void setSender(Utilisateur sender) {
		this.sender = sender;
	}

	public Utilisateur getReceiver() {
		return receiver;
	}

	public void setReceiver(Utilisateur receiver) {
		this.receiver = receiver;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", dateAjout=" + dateAjout + ", dateModif=" + dateModif + ", status=" + status
				+ ", message=" + message + ", readAt=" + readAt + ", sender=" + sender + ", receiver=" + receiver + "]";
	}

	
}
