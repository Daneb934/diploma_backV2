package kz.jillzay.prof_test.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "section")
public class Section {
    @Id
    private Integer id;

    private String name;

//    @JsonIgnore
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "section")
//    List<SectionQuestion> sectionQuestions;
}
