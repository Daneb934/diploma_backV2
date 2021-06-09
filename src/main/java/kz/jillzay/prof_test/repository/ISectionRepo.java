package kz.jillzay.prof_test.repository;

import kz.jillzay.prof_test.model.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISectionRepo extends JpaRepository<Section, Integer> {

}
