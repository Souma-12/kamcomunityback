package com.association.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.association.entity.Message;
import com.association.services.MessageService;

@RestController
@RequestMapping("/api/message")
@CrossOrigin(origins = "*")
public class MessageController {

	Logger log = LoggerFactory.getLogger(MessageController.class);
	@Autowired
	MessageService messageService;

	@GetMapping("/{id}")
	public List<Message> getMessage(@PathVariable("id") String id) {
		log.info(" get message :{}", id);
		List<Message> result = messageService.getAllByReciver(Long.valueOf(id));
		log.info("message :{}", result.toString());
		return result;
	}

	@PostMapping("/send")
	public Message postMessage(@RequestBody Message message) {
		Message result = messageService.create(message);
		log.info("message :{}", result.toString());
		return result;
	}

}
