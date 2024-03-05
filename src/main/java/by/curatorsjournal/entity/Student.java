package by.curatorsjournal.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Класс Студент
 *
 * @author V.A.Nichyporuk
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String surname;//фамилия
    private String name;//имя
    private String patronymic;//отчество
    private String phone;//номер телефона
    @DateTimeFormat(pattern = "dd.mm.yyyy")
    @Temporal(TemporalType.DATE)
    private Date birthDate;//дата рождения
    private String passport;//паспортные данные
    private String citizenship;//гражданство
    private String graduated;//сведения об оконченных учереждениях образования
    private String placeOfResidence;//место и адрес проживания в период обучения
    private String chronicDiseases;//хронические заболевания
    private String PEGroup;//группа по физической культуре
    private String individualInformation;//индивидуальная информация
    private String email;//адрес электронной почты
    private boolean gender;//пол: 0 -- женский, 1 -- мужской
    private boolean BRSMmember;//член БРСМ
    private boolean orphan;//дети-сироты
    private boolean withoutParentCare;//дети, оставшиеся без попечения родителей
    private boolean psychophysical;//студенты с особенностями психофизического развития
    private boolean invalidParents;//имеющие родителей инвалидов 1, 2 группы
    private boolean largeFamily;//из многодетных семей
    private boolean singleFamily;//из неполная семья
    private boolean affectedRegions;//из регионов пострадавших от катастрофы на Чернобыльской АЭС
    private boolean expelledFamilies;//из семей отсленнных из зон радиоактивного загрязнения
    private boolean outOfTowner;//иногородиние
    private byte residence;//проживает: 
                           //1 -- с родителями, 2 -- в общежитии, 3 -- у родственников, 4 -- на частной квартире

    @OneToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "student_id")
    private List<Parent> parents;//список родителей и/или других родственников, законных представителях

    @OneToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "student_id")
    private List<Encouragement> encouragements;//сведения о поощрениях
    @OneToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "student_id")
    private List<DisciplinaryLiability> disciplinaryLiabilities;//сведения о дисциплинарных взысканиях
    @OneToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "student_id")
    private List<HealthCard> healthCards;//карта здоровья
    
     @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Progress> progress;
}
