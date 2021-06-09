package kz.jillzay.prof_test.repository;

import kz.jillzay.prof_test.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepo extends JpaRepository<Question, Integer> {

}
