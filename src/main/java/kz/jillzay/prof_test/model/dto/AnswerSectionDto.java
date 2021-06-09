package kz.jillzay.prof_test.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class AnswerSectionDto {
    private String sectionName;
    private List<AnswerDto> answers;
}
