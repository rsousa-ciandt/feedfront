package com.ciandt.feedfront.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciandt.feedfront.entities.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

}
	