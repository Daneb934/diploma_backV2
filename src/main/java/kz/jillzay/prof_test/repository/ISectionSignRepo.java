package kz.jillzay.prof_test.repository;

import kz.jillzay.prof_test.model.entity.SectionSign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISectionSignRepo extends JpaRepository<SectionSign, Integer> {

    @Query("from SectionSign ss where ss.sectionId = :sectionId and ss.scoreMin <=:score and ss.scoreMax>=:score")
    SectionSign getSectionSign(Integer sectionId, Integer score);


}
