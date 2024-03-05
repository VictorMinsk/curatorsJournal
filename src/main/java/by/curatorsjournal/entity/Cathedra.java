package by.curatorsjournal.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
 * Класс Кафедра
 *
 * @author V.A.Nichyporuk
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cathedras")
public class Cathedra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;//название кафедры

    @OneToMany
    @JoinColumn(name = "cathedra_id")
    private List<Speciality> specialities;//список специальностей

    @OneToMany
    @JoinColumn(name = "cathedra_id")
    private List<Curator> curators;//список кураторов

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "head_id", referencedColumnName = "id")
    private HeadOfDepartment headOfDepartment;//заведующий кафедрой

}
