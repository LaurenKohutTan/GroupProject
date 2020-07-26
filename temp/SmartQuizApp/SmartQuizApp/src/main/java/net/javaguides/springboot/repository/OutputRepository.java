package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Output;

@Repository
public interface OutputRepository extends JpaRepository<Output, Integer>{
	java.util.List<Output> findAll();
}
