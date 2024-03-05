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
 * Класс Социально-педагогическая характеристика учебной группы
 *
 * @author V.A.Nichyporuk
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "soc_ped_character")
public class SocPedCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private byte allStudents;//всего студентов
    private byte boys;//юноши
    private byte girls;//девушки
    private byte BRSMmembers;//члены БРСМ
    private byte orphansUnder18;//дети сироты (до 18 лет)
    private byte withoutParentCareUnder18;//дети, оставшиеся без попечения родителей (до 18 лет)
    private byte orphansAndWithoutParentCare18to23;//лица из числа детей-сирот и детей, оставшихся без попечения родитлей (18-23 года)
    private byte psychophysical;//студенты с особенностями психофизического развития
    private byte invalidParents;//имеющие родителей инвалидов 1, 2 группы
    private byte largeFamilies;//из многодетных семей
    private byte singleFamilies;//из неполная семья
    private byte affectedRegions;//из регионов пострадавших от катастрофы на Чернобыльской АЭС
    private byte expelledFamilies;//из семей отсленнных из зон радиоактивного загрязнения
    private byte outOfTowners;//иногородние
    private byte liveWithParents;//проживают с родителями
    private byte liveInDormitory;//проживают в общежитии
    private byte liveWithRelatives;//проживают у родственников
    private byte liveInApartments;//проживают на частных квартирах
    private String otherInformation;//другие сведения
}
