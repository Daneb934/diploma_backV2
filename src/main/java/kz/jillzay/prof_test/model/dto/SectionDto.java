package kz.jillzay.prof_test.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class SectionDto {
    private String sectionName;
    private List<QuestionDto> questions;
}
