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
 * Класс Факультет
 *
 * @author V.A.Nichyporuk
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "faculties")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int code;//код факультета
    private String title;//название факультета
    private String shortTitle;//сокращенное название

    @OneToMany
    @JoinColumn(name = "faculty_id")
    private List<Cathedra> cathedras;//список кафедр факультета

    @OneToMany
    @JoinColumn(name = "faculty_id")
    private List<Methodist> methodists;//список методистов факультета
}
