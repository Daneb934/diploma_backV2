package kz.jillzay.prof_test.controller;

import kz.jillzay.prof_test.model.dto.AnswerDto;
import kz.jillzay.prof_test.model.dto.AnswerSectionDto;
import kz.jillzay.prof_test.model.dto.ResultDto;
import kz.jillzay.prof_test.model.dto.SectionDto;
import kz.jillzay.prof_test.service.IProfTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/prof/")
@RequiredArgsConstructor
public class ProfTestController {

    private final IProfTestService profTestService;

    @GetMapping("questions")
    public List<SectionDto> getQuestionBySection() {
        return profTestService.getAllQuestions();
    }

    @PostMapping("answers")
        public ResultDto calculateResult(@RequestBody Map<String, List<AnswerDto>> answerDtoMap) {
        return new ResultDto(profTestService.calculateResult(answerDtoMap));
    }

}
