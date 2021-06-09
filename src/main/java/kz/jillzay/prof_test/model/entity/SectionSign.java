package kz.jillzay.prof_test.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "section_sign")
public class SectionSign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String sign;

    @Column(name = "score_min")
    private Integer scoreMin;

    @Column(name = "score_max")
    private Integer scoreMax;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @Column(name = "section_id")
//    @JoinColumn(name = "section_id")
//    private Section section;

    @Column(name = "section_id")
    private Integer sectionId;

}
