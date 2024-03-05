package by.curatorsjournal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс Родитель (законный представитель)
 *
 * @author V.A.Nichyporuk
 */
@Entity 
@Getter
@Setter 
@AllArgsConstructor 
@NoArgsConstructor
@Table(name = "parents")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String relation;//отношение к студенту (степень родства)
    private String surname;//фамилия
    private String name;//имя
    private String patronymic;//отчество
    private String address;//место жительства
    private String placeOfWork;//место работы
    private String phoneNumber;//номер телефона
}
