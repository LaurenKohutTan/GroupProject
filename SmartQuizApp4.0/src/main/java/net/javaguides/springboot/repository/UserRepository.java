package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.User;

/**
 * Interface repository that holds User objects corresponding with sql database 
 * @author QuestionBankGroup
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
