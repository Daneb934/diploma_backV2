package kz.jillzay.prof_test.repository;

import kz.jillzay.prof_test.model.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAnswerRepo extends JpaRepository<Answer, Integer> {
    List<Answer> findByQuestionId(Integer questionId);
    Optional<Answer> findByQuestionIdAndAnswerOption(Integer questionId, String option);
}
