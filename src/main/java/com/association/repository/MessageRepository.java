package com.association.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.association.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	
	
	@Query("select message from Message message where message.receiver.id =:id")
	List<Message> findByReceiver(Long id);

	
}
