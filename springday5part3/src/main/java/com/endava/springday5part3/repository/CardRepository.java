package com.endava.springday5part3.repository;

import com.endava.springday5part3.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
}
