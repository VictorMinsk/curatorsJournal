package by.curatorsjournal.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс Специальность
 *
 * @author V.A.Nichyporuk
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "specialities")
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;//код специальности
    private String title;//название специальности
    private byte termOfStudy;//срок обучения

    @OneToMany
    @JoinColumn(name = "speciality_id")
    private List<Group> groups;//список групп

    @OneToMany
    @JoinColumn(name = "speciality_id")
    private List<Discipline> disciplines;//список учебных дисциплин
}
