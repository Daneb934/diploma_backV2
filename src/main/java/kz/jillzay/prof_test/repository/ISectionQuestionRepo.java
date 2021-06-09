package kz.jillzay.prof_test.repository;

import kz.jillzay.prof_test.model.entity.Question;
import kz.jillzay.prof_test.model.entity.Section;
import kz.jillzay.prof_test.model.entity.SectionQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISectionQuestionRepo extends JpaRepository<SectionQuestion, Integer> {
//    @Query(value = "select sq.question from SectionQuestion sq where sq.section = :section")
//    List<Question> getQuestionBySection(Section section);

//    @Query(value = "from SectionQuestion sq where sq.questionId = :questionId")
    List<SectionQuestion> getSectionQuestionByQuestionId(Integer questionId);

    List<SectionQuestion> getSectionQuestionBySectionId(Integer sectionId);
}

