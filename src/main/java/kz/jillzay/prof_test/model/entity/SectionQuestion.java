package kz.jillzay.prof_test.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "section_question")
public class SectionQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "section_id")
//    @Column(name = "section_id")
//    private Section section;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "question_id")
//    @Column(name = "question_id")
//    private Question question;

    @Column(name = "section_id")
    private Integer sectionId;

    @Column(name = "question_id")
    private Integer questionId;


}
