package src.main.java.net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Question;

/**
 * Interface repository that holds Question objects corresponding with sql database 
 * @author QuestionBankGroup
 *
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

	java.util.List<Question> findAll();
	//void save(QuestionRegistrationDto registrationDto);

}
