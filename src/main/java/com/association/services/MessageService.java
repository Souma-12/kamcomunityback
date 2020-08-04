package com.association.services;

import java.util.List;

import com.association.entity.Message;

public interface MessageService {

	public Message getById(Long id);

	Message create(Message message);

	Message update(Message message);

	List<Message> findAll();

	void delete(Long id);

	public List<Message> getAll();

	List<Message> getAllByReciver(Long id);}
