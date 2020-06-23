package com.example.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {

  public abstract Question findById(long id);
}