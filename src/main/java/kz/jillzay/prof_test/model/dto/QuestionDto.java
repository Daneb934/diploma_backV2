package kz.jillzay.prof_test.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {
    private Integer questionId;
    private String question;
    private List<OptionDto> options;
}
