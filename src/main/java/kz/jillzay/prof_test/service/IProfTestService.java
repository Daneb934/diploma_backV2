package kz.jillzay.prof_test.service;

import kz.jillzay.prof_test.model.dto.AnswerDto;
import kz.jillzay.prof_test.model.dto.AnswerSectionDto;
import kz.jillzay.prof_test.model.dto.SectionDto;
import java.util.List;
import java.util.Map;

public interface IProfTestService {
    List<SectionDto> getAllQuestions();
    String calculateResult(Map<String, List<AnswerDto>> answerDtoMap);
}
