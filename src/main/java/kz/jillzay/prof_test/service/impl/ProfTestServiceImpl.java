package kz.jillzay.prof_test.service.impl;

import kz.jillzay.prof_test.model.dto.AnswerDto;
import kz.jillzay.prof_test.model.dto.OptionDto;
import kz.jillzay.prof_test.model.dto.QuestionDto;
import kz.jillzay.prof_test.model.dto.SectionDto;
import kz.jillzay.prof_test.model.entity.Answer;
import kz.jillzay.prof_test.model.entity.Section;
import kz.jillzay.prof_test.model.entity.SectionQuestion;
import kz.jillzay.prof_test.model.entity.SectionSign;
import kz.jillzay.prof_test.repository.*;
import kz.jillzay.prof_test.service.IProfTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfTestServiceImpl implements IProfTestService {

    private final ISectionRepo sectionRepo;
    private final ISectionQuestionRepo sectionQuestionRepo;
    private final IQuestionRepo questionRepo;
    private final IAnswerRepo answerRepo;
    private final ISectionSignRepo sectionSignRepo;

    @Override
    public List<SectionDto> getAllQuestions() {
        List<SectionDto> result = new ArrayList<>();
        List<Section> sections = sectionRepo.findAll();
        sections.forEach(section -> {
            SectionDto sectionDto = new SectionDto();
            sectionDto.setSectionName(section.getName());
            sectionDto.setQuestions(createQuestionsDto(sectionQuestionRepo.getSectionQuestionBySectionId(section.getId())));
            result.add(sectionDto);
        });
        return result;
    }


    @Override
    public String calculateResult(Map<String, List<AnswerDto>> answerDtoMap) {
        String[] result = {""};

        sectionRepo.findAll()
                .forEach(section -> {
                    if (answerDtoMap.containsKey(section.getName())) {
                        List<AnswerDto> answers = answerDtoMap.get(section.getName());
                        int score = 0;

                        for (AnswerDto answerDto : answers) {
                            Optional<Answer> optionalAnswer = answerRepo.findByQuestionIdAndAnswerOption(answerDto.getQuestionId(), answerDto.getOption());
                            if (optionalAnswer.isPresent()) {
                                score+=optionalAnswer.get().getScore();
                            }
                        }

                        SectionSign sectionSign = sectionSignRepo.getSectionSign(section.getId(), score);
                        result[0] +=sectionSign.getSign();
                    }

        });

        return result[0];
    }


    private List<QuestionDto> createQuestionsDto(List<SectionQuestion> questionBySection) {
        List<QuestionDto> result = new ArrayList<>();
        questionBySection.forEach(questionSection -> {
            QuestionDto questionDto = new QuestionDto();
            questionDto.setQuestionId(questionSection.getQuestionId());
            questionRepo.findById(questionSection.getQuestionId())
                    .ifPresent(question ->
                            questionDto.setQuestion(question.getText()));
            questionDto.setOptions(createOptionsDto(questionSection.getQuestionId()));
            result.add(questionDto);
        });

        return result;
    }

    private List<OptionDto> createOptionsDto(Integer questionId) {
        List<OptionDto> result = new ArrayList<>();
        List<Answer> answers = answerRepo.findByQuestionId(questionId);

        answers.forEach(answer -> {
            OptionDto optionDto = new OptionDto();
            optionDto.setOption(answer.getAnswerOption());
            result.add(optionDto);
        });

        return result;
    }

}
