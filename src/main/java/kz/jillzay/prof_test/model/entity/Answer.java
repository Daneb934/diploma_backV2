package kz.jillzay.prof_test.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "question_id")
    private Integer questionId;

    private Integer score;

    //Вариант ответ
    @Column(name = "option")
    private String answerOption;

    private String text;

}
