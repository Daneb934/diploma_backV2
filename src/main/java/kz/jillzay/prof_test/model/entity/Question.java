package kz.jillzay.prof_test.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.aspectj.weaver.loadtime.Options;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;

//    @JsonIgnore
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question")
//    private List<Answer> options;

}
