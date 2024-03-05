package by.curatorsjournal.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс Учебная группа
 *
 * @author V.A.Nichyporuk
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupNumber;//номер группы
    @OneToOne(fetch = FetchType.EAGER)
    private Curator curator;//куратор
    @OneToOne
    private Student head;//староста
    @OneToOne
    private Student vicehead;//заместитель старосты
    @OneToOne
    private Student profOrg;//профорг
    @OneToMany
    @JoinColumn(name = "group_id")
    private List<Student> students;//список студентов группы
    @OneToMany
    @JoinColumn(name = "group_id")
    private List<InformationHour> informationHours;//информационные часы группы
    @OneToMany
    @JoinColumn(name = "group_id")
    private List<Tradition> traditions;//традиции группы
    @OneToMany
    @JoinColumn(name = "group_id")
    private List<IdeologicalWork> ideologicalWorks;//идеологическая и воспитательная работа
    @OneToMany
    @JoinColumn(name = "group_id")
    private List<PsychPedCharacter> psychPedCharacters;//психолого-педагогическая характеристика
    @OneToMany
    @JoinColumn(name = "group_id")
    private List<SocPedCharacter> socPedCharacters;//социально-педагогическая характерстистика

    public List<Student> getStudents() {
        if (students != null) {
            return students;
        } else {
            return new ArrayList<Student>();
        }
    }

    public List<InformationHour> getInformationHours() {
        if (informationHours != null) {
            return informationHours;
        } else {
            return new ArrayList<InformationHour>();
        }
    }

}
