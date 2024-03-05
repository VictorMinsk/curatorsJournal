package by.curatorsjournal.controller;

import by.curatorsjournal.entity.Cathedra;
import by.curatorsjournal.entity.Curator;
import by.curatorsjournal.entity.DisciplinaryLiability;
import by.curatorsjournal.entity.Encouragement;
import by.curatorsjournal.entity.Faculty;
import by.curatorsjournal.entity.Group;
import by.curatorsjournal.entity.HeadOfDepartment;
import by.curatorsjournal.entity.IdeologicalWork;
import by.curatorsjournal.entity.InformationHour;
import by.curatorsjournal.entity.Methodist;
import by.curatorsjournal.entity.Parent;
import by.curatorsjournal.entity.Progress;
import by.curatorsjournal.entity.PsychPedCharacter;
import by.curatorsjournal.entity.Role;
import by.curatorsjournal.entity.Speciality;
import by.curatorsjournal.entity.Student;
import by.curatorsjournal.entity.Tradition;
import by.curatorsjournal.entity.User;
import by.curatorsjournal.service.CathedraService;
import by.curatorsjournal.service.CuratorService;
import by.curatorsjournal.service.DisciplinaryLiabilityService;
import by.curatorsjournal.service.DisciplineService;
import by.curatorsjournal.service.EncouragementService;
import by.curatorsjournal.service.FacultyService;
import by.curatorsjournal.service.GroupService;
import by.curatorsjournal.service.HeadOfDepartmentService;
import by.curatorsjournal.service.IdeologicalWorkService;
import by.curatorsjournal.service.InformationHourService;
import by.curatorsjournal.service.MethodistService;
import by.curatorsjournal.service.ParentService;
import by.curatorsjournal.service.ProgressService;
import by.curatorsjournal.service.PsychPedCharacterService;
import by.curatorsjournal.service.SpecialityService;
import by.curatorsjournal.service.StudentService;
import by.curatorsjournal.service.TraditionService;
import by.curatorsjournal.service.UserService;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Класс контроллер
 *
 * @author V.A.Nichyporuk
 */
@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CuratorService curatorService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private InformationHourService informationHourService;
    @Autowired
    private TraditionService traditionService;
    @Autowired
    private PsychPedCharacterService psychPedCharacterService;
    @Autowired
    private IdeologicalWorkService ideologicalWorkService;
    @Autowired
    private ParentService parentService;
    @Autowired
    private EncouragementService encouragementService;
    @Autowired
    private DisciplinaryLiabilityService disciplinaryLiabilityService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private CathedraService cathedraService;
    @Autowired
    private MethodistService methodistService;
    @Autowired
    private HeadOfDepartmentService headOfDepartmentService;
       @Autowired
    private DisciplineService disciplineService;
            @Autowired
    private ProgressService progressService;

    @InitBinder
    //инициализация формата даты
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-dd-mm"), true, 10));
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        userService.createRoles();
        userService.saveAdminUser();
     //   model.addAttribute("userForm", new User());
     //   return "registration";
     return "login";
    }

   /* @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        if (!userService.saveCuratorUser(userForm)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/";
    }*/

 /*   @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }

    @PostMapping("/admin")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
            @RequestParam(required = true, defaultValue = "") String action,
            Model model) {
        if (action.equals("delete")) {
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }*/

    @GetMapping("/main")
    //маппинг запроса главной страницы приложения
    public String mainPage(Model model) {
        //определение текущего пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //определение роли текущего пользователя
        boolean hasAdminRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        boolean hasCuratorRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_CURATOR"));
        boolean hasMethodistRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_METHODIST"));
        boolean hasHeadOfDepartmentRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_HEAD_OF_DEPARTMENT"));
        //загрузка главной страницы приложения в соотвествии с ролью пользователя
        if (hasAdminRole) {
            return adminMain(model);
        }
        if (hasCuratorRole) {
            return curatorMain(model);
        }
        if (hasMethodistRole) {
            return methodistMain(model);
        }
        if (hasHeadOfDepartmentRole) {
            return headOfDepartmentMain(model);
        }
        return "login";
    }

    @PostMapping(value = "/group")
    //меню группы
    public String groupMenu(@RequestParam(required = true, defaultValue = "") Long groupId, Model model) {
        model.addAttribute("groupsList", curatorService.getGroups(1));
        model.addAttribute("selGroup", groupService.getById(groupId));
        return "curatorMain";
    }

    //главная страница администратора
    public String adminMain(Model model) {
        model.addAttribute("facultiesList", facultyService.getAll());
        model.addAttribute("tradition", new Tradition());
        return "adminMain";
    }

    //главная страница методиста
    public String methodistMain(Model model) {
        //определение текущего пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Methodist methodist = methodistService.getByUserId(username);
        //определение факультета методиста
        Faculty faculty = methodistService.getFaculty(methodist.getId());
        model.addAttribute("faculty", faculty);
        model.addAttribute("methodist", methodist);
        model.addAttribute("tradition", new Tradition());
        return "methodistMain";
    }

    //главная страница заведующего кафедрой
    public String headOfDepartmentMain(Model model) {
         //определение текущего пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        HeadOfDepartment headOfDepartment = headOfDepartmentService.getByUserId(username);
         //определение кафедры
        Cathedra cathedra = headOfDepartmentService.getCathedra(headOfDepartment.getId());
        model.addAttribute("cathedra", cathedra);
        model.addAttribute("headOfDepartment", headOfDepartment);
        model.addAttribute("tradition", new Tradition());
        System.out.println(curatorService.getGroups(cathedra.getCurators().get(0).getId()).get(0).getGroupNumber());
        return "headOfCathedraMain";
    }

      //главная страница кафедры
    public String curatorMain(Model model) {
         //определение текущего пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        //получение списка групп куратора
        Curator curator = curatorService.getByUserId(username);
        List<Group> groups = curatorService.getGroups(curator.getId());
        model.addAttribute("groupsList", groups);
        if (groups.isEmpty()) model.addAttribute("emp",true);
        else{
             model.addAttribute("emp",false);model.addAttribute("selGroup", curatorService.getGroups(curator.getId()).get(0));
        }
        return "curatorMain";
    }

    @PostMapping("/aboutHeadOfCathedra")
    public String showAboutHead(@RequestParam(required = true, defaultValue = "") Long headId, Model model) {
        HeadOfDepartment headOfDepartment = headOfDepartmentService.getById(headId);
                 headOfDepartment.getUser().setPassword("");
        model.addAttribute("headOfCathedra", headOfDepartment);
        model.addAttribute("cathedra", headOfDepartmentService.getCathedra(headId));
        return "editHeadOfCathedra";
    }
    
     @PostMapping("/showFaculty")
    public String showAboutFaculty(@RequestParam(required = true, defaultValue = "") Long facultyId, Model model) {
         Faculty faculty = facultyService.getById(facultyId);
        model.addAttribute("faculty", faculty);
        model.addAttribute("methodist", faculty.getMethodists().get(0));
        model.addAttribute("tradition", new Tradition());
        return "methodistMain";
    }
    
     @PostMapping("/showCathedra")
    public String showAboutCathedra(@RequestParam(required = true, defaultValue = "") Long cathedraId, Model model) {
        Cathedra cathedra = cathedraService.getById(cathedraId);
        model.addAttribute("cathedra", cathedra);
        model.addAttribute("headOfDepartment", cathedra.getHeadOfDepartment());
        model.addAttribute("tradition", new Tradition());
        return "headOfCathedraMain";
    }
    
     @PostMapping("/showGroup")
    public String showAboutGroup(@RequestParam(required = true, defaultValue = "") Long cathedraId, Model model) {
        Cathedra cathedra = cathedraService.getById(cathedraId);
        model.addAttribute("cathedra", cathedra);
        model.addAttribute("headOfDepartment", cathedra.getHeadOfDepartment());
        model.addAttribute("tradition", new Tradition());
        return "headOfCathedraMain";
    }

    @GetMapping("/aboutCurator")
    public String showAboutCurator(@RequestParam(required = true, defaultValue = "") Long groupId, Model model) {
        Group group = groupService.getById(groupId);
        Curator curator = group.getCurator();
        model.addAttribute("group", group);
        model.addAttribute("curator", curator);
        model.addAttribute("groupList", curatorService.getGroups(curator.getId()));
        return "aboutCurator";
    }

    @GetMapping("/disciplinesList")
    public String showDisciplinesList(@RequestParam(required = true, defaultValue = "") Long specId, Model model) {
        Speciality speciality = specialityService.getById(specId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        HeadOfDepartment headOfDepartment = headOfDepartmentService.getByUserId(username);
        model.addAttribute("speciality", speciality);
        model.addAttribute("headOfDepartment", headOfDepartment);
        model.addAttribute("tradition", new Tradition());
        return "disciplinesList";
    }

    @PostMapping("/aboutMethodist")
    public String showAboutMethodist(@RequestParam(required = true, defaultValue = "") Long methodistId, Model model) {
        Methodist methodist = methodistService.getById(methodistId);
        Faculty faculty = methodistService.getFaculty(methodist.getId());
        model.addAttribute("faculty", faculty);
        methodist.getUser().setPassword("");
        model.addAttribute("methodist", methodist);
        return "editMethodist";
    }

    @PostMapping("/addCuratorForm")
    public String showAddCurator(@RequestParam(required = true, defaultValue = "") Long cathedraId, Model model) {
        model.addAttribute("curator", new Curator());
        model.addAttribute("cathedra", cathedraService.getById(cathedraId));
        model.addAttribute("action", "Добавить");
        model.addAttribute("action1", "Сохранить");
        return "addCurator";
    }

    @GetMapping("/showAddMethodist")
    public String showAddMethodist(@RequestParam(required = true, defaultValue = "") Long facultyId, Model model) {
        model.addAttribute("methodist", new Methodist());
        model.addAttribute("user", new User());
        model.addAttribute("faculty", facultyService.getById(facultyId));
        return "addMethodist";
    }

    @PostMapping("/addMethodist")
    public String addMethodist(@ModelAttribute("methodist") Methodist methodist, @RequestParam(required = true, defaultValue = "") Long facultyId, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
             model.addAttribute("faculty", facultyService.getById(facultyId));
           return "addMethodist";
        }
        if (!methodist.getUser().getPassword().equals(methodist.getUser().getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
          model.addAttribute("faculty", facultyService.getById(facultyId));
         return "addMethodist";
        }
            if (!userService.saveMethodistUser(methodist.getUser())) {
                model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
               model.addAttribute("faculty", facultyService.getById(facultyId));
              return "addMethodist";
            }
            methodistService.createMethodist(methodist, facultyId);
            return adminMain(model);
    }
    
       @PostMapping("/editMethodist")
    public String editMethodist(@ModelAttribute("methodist") Methodist methodist, @RequestParam(required = true, defaultValue = "") Long facultyId, BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
             model.addAttribute("faculty", facultyService.getById(facultyId));
           return "editMethodist";
        }
      if (!methodist.getUser().getPassword().equals("")){
        if (!methodist.getUser().getPassword().equals(methodist.getUser().getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
          model.addAttribute("faculty", facultyService.getById(facultyId));
         return "editMethodist";
        }
        methodist.getUser().setRoles(Collections.singleton(new Role(3L, "ROLE_METHODIST")));    
        userService.changePassword(methodist.getUser());
      }
            methodistService.saveMethodist(methodist, facultyId);
            return methodistMain(model);
        }
    
     @PostMapping("/editHead")
    public String editHead(@ModelAttribute("headOfCathedra") HeadOfDepartment headOfDepartment, @RequestParam(required = true, defaultValue = "") Long cathedraId, BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
             model.addAttribute("cathedra", cathedraService.getById(cathedraId));
           return "editHead";
        }
      if (!headOfDepartment.getUser().getPassword().equals("")){
        if (!headOfDepartment.getUser().getPassword().equals(headOfDepartment.getUser().getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
           model.addAttribute("cathedra", cathedraService.getById(cathedraId));
         return "editHead";
        }
        headOfDepartment.getUser().setRoles(Collections.singleton(new Role(4L, "ROLE_HEAD_OF_DEPARTMENT")));    
        userService.changePassword(headOfDepartment.getUser());
      }
      headOfDepartmentService.saveHeadOfDepartment(headOfDepartment, cathedraId);
            return headOfDepartmentMain(model);
        }

    @GetMapping("/showAddHeadOFDepartment")
    public String showAddHeadOfCathedra(@RequestParam(required = true, defaultValue = "") Long cathedraId, Model model) {
        model.addAttribute("headOfCathedra", new HeadOfDepartment());
        model.addAttribute("user", new User());
        model.addAttribute("cathedra", cathedraService.getById(cathedraId));
        return "addHeadOfCathedra";
    }

    @PostMapping("/addHead")
    public String addHead(@ModelAttribute("headOfCathedra") HeadOfDepartment headOfDepartment, @RequestParam(required = true, defaultValue = "") Long cathedraId, BindingResult bindingResult, Model model) {
       if (bindingResult.hasErrors()) {
            return "addHead";
        }
        if (!headOfDepartment.getUser().getPassword().equals(headOfDepartment.getUser().getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "addHead";
        }
        if (!userService.saveHeadOfDepartmentUser(headOfDepartment.getUser())) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "addHead";
        }
        headOfDepartmentService.createHeadOfDepartment(headOfDepartment, cathedraId);
  //    userService.changePassword(headOfDepartment.getUser());
        return methodistMain(model);

    }

    @PostMapping(value = "/active")
    public String showGroupActive(@RequestParam(required = true, defaultValue = "") Long groupId, Model model) {
        Group g = groupService.getById(groupId);
        model.addAttribute("group", g);
        List<Student> students = groupService.getStudentsOfGroup(groupId);
        HashMap<String, String> studentsSurnames = new HashMap<String, String>();
        for (int i = 0; i < students.size(); i++) {
            studentsSurnames.put(String.valueOf(students.get(i).getId()), students.get(i).getSurname() + " "
                    + students.get(i).getName() + " " + students.get(i).getPatronymic());
        }
        model.addAttribute("students", studentsSurnames);
        return "active";
    }

    @PostMapping(value = "/addActive")
    public String addActive(@ModelAttribute("group") Group group, @RequestParam(required = true, defaultValue = "") Long groupId, BindingResult bindingResult, Model model) {
        groupService.saveActive(group, groupId);
        return showGroupActive(groupId, model);
    }

    @PostMapping(value = "/healthCard")
    public String showHealthCard(@RequestParam(required = true, defaultValue = "") Long groupId, Model model) {
        Group g = groupService.getById(groupId);
        model.addAttribute("studentList", g.getStudents());
        model.addAttribute("group", g);
        return "healthCard";
    }

    @PostMapping(value = "/character")
    public String showGroupCharacter(@RequestParam(required = true, defaultValue = "") Long groupId, Model model) {
        model.addAttribute("characteristics", groupService.getCharacteristicsOfGroup(groupId));
        model.addAttribute("psychPedCharacter", new PsychPedCharacter());
        Group g = new Group();
        g.setId(groupId);
        model.addAttribute("group", g);
        return "character";
    }

    @PostMapping(value = "/curator-time")
    public String showCuratorTime(@RequestParam(required = true, defaultValue = "") Long groupId, Model model) {
        model.addAttribute("ideologicalWorkList", groupService.getIdeologicalWorkOfGroup(groupId));
        model.addAttribute("ideologicalWork", new IdeologicalWork());
        Group g = new Group();
        g.setId(groupId);
        model.addAttribute("group", g);
        return "curator-time";
    }

    @PostMapping(value = "/clock")
    public String showClock(@RequestParam(required = true, defaultValue = "") Long groupId, Model model) {
        model.addAttribute("informationHours", groupService.getInfoHoursOfGroup(groupId));
        model.addAttribute("informationHour", new InformationHour());
        Group g = new Group();
        g.setId(groupId);
        model.addAttribute("group", g);
        return "clock";
    }

    @PostMapping(value = "/tradic")
    public String showTraditions(@RequestParam(required = true, defaultValue = "") Long groupId, Model model) {
        model.addAttribute("traditions", groupService.getTraditionsOfGroup(groupId));
        model.addAttribute("tradition", new Tradition());
        Group g = new Group();
        g.setId(groupId);
        model.addAttribute("group", g);
        return "tradic";
    }

    
    @PostMapping(value = "/progress")
    public String showProgress(@RequestParam(required = true, defaultValue = "") Long groupId, Model model) {
     /*   model.addAttribute("traditions", groupService.getTraditionsOfGroup(groupId));
        model.addAttribute("tradition", new Tradition());*/
     model.addAttribute("exams", disciplineService.getExamsForGroup(groupId));
      model.addAttribute("setOffs", disciplineService.getSetOffsForGroup(groupId));
       model.addAttribute("CP", disciplineService.getCourseProjectsForGroup(groupId));
            model.addAttribute("progressTable", progressService.getMarksForGroup(groupId));
        Group g = new Group();
        g.setId(groupId);
        model.addAttribute("group", g);
        return "progress";
    }
    
    @PostMapping(value = "/studentsList")
    public String showStudentsList(@RequestParam(required = true, defaultValue = "") Long groupId, Model model) {
        Group g = groupService.getById(groupId);
        model.addAttribute("studentList", g.getStudents());
        model.addAttribute("group", g);
        return "studentsList";
    }

    @GetMapping(value = "/addStudentForm")
    public String showAddStudent(@RequestParam(required = true, defaultValue = "") Long groupId, Model model) {
        model.addAttribute("student", new Student());
        Group g = new Group();
        g.setId(groupId);
        model.addAttribute("action", "Добавить");
        model.addAttribute("action1", "Добавить");
        model.addAttribute("group", g);
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestParam(required = true, defaultValue = "") Long groupId, @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
        studentService.createStudent(student, groupId);
        return showStudentsList(groupId, model);
    }

    @PostMapping("/editStudent")
    public String showEditStudent(@RequestParam(required = true, defaultValue = "") Long studentId, @RequestParam(required = true, defaultValue = "") Long groupId, Model model) {
        model.addAttribute("student", studentService.getById(studentId));
        model.addAttribute("group", groupService.getById(groupId));
        model.addAttribute("action", "Редактировать");
        model.addAttribute("action1", "Сохранить изменения");
        return "addStudent";
    }

    @PostMapping("/delStudent")
    public String deleteStudent(@RequestParam(required = true, defaultValue = "") Long studentId, Model model) {
        long groupId = groupService.getGroupIdByStudent(studentId);
        if (studentService.delStudent(studentId)) {
            return showStudentsList(groupId, model);
        } else {
            model.addAttribute("errorMessage", "Студент не может быть удален т.к. входит в актив группы");
            return showStudentCard(studentId, studentService.getGroupId(studentId), model);
        }

    }

    @PostMapping("/studentCard")
    public String showStudentCard(@RequestParam(required = true, defaultValue = "") Long studentId, @RequestParam(required = true, defaultValue = "") Long groupId, Model model) {
        if (studentId == 0) {
            return groupMenu(groupId, model);
        }
        /* Group g=new Group();
        g.setId((long)1);*/
        model.addAttribute("group", groupService.getById(groupId));
        model.addAttribute("student", studentService.getById(studentId));
        model.addAttribute("encouragement", new Encouragement());
        model.addAttribute("disciplinaryLiability", new DisciplinaryLiability());
        return "studentCard";
    }

    @PostMapping("/addClock")
    public String addClock(@ModelAttribute("informationHour") InformationHour informationHour, @RequestParam(required = true, defaultValue = "") Long groupId, BindingResult bindingResult, Model model) {
        informationHourService.createInformationHour(informationHour, groupId);
        return showClock(groupId, model);
    }

    @PostMapping("/addTradic")
    public String addTradition(@ModelAttribute("tradition") Tradition tradition, @RequestParam(required = true, defaultValue = "") Long groupId, BindingResult bindingResult, Model model) {
        traditionService.createTradition(tradition, groupId);
        return showTraditions(groupId, model);
    }

    @PostMapping("/addCharacter")
    public String addCharacter(@ModelAttribute("psychPedCharacter") PsychPedCharacter psychPedCharacter, @RequestParam(required = true, defaultValue = "") Long groupId, BindingResult bindingResult, Model model) {
        psychPedCharacterService.createPsychPedCharacter(psychPedCharacter, groupId);
        return showGroupCharacter(groupId, model);
    }

    @PostMapping("/addIdWork")
    public String addIdWork(@ModelAttribute("ideologicalWork") IdeologicalWork ideologicalWork, @RequestParam(required = true, defaultValue = "") Long groupId, BindingResult bindingResult, Model model) {
        ideologicalWorkService.createIdeologicalWork(ideologicalWork, groupId);
        return showCuratorTime(groupId, model);
    }

    @GetMapping("/addParentForm")
    public String showAddParent(@RequestParam(required = true, defaultValue = "") Long studentId, Model model) {
        model.addAttribute("parent", new Parent());
        model.addAttribute("student", studentService.getById(studentId));
        model.addAttribute("group", groupService.getById(groupService.getGroupIdByStudent(studentId)));
        return "addParent";
    }

    @PostMapping("/addParent")
    public String addParent(@ModelAttribute("parent") Parent parent, @RequestParam(required = true, defaultValue = "") Long studentId, BindingResult bindingResult, Model model) {
        parentService.createParent(parent, studentId);
        model.addAttribute("student", studentService.getById(studentId));
        return showStudentCard(studentId, studentService.getGroupId(studentId), model);
    }

    @PostMapping("/addEnc")
    public String addEncouragement(@ModelAttribute("encouragement") Encouragement encouragement, @RequestParam(required = true, defaultValue = "") long studentId, BindingResult bindingResult, Model model) {
        encouragementService.createEncouragement(encouragement, studentId);
        return showStudentCard(studentId, studentService.getGroupId(studentId), model);
    }

    @PostMapping("/addDisc")
    public String addDisciplinaryLiability(@ModelAttribute("disciplinaryLiability") DisciplinaryLiability disciplinaryLiability, @RequestParam(required = true, defaultValue = "") long studentId, BindingResult bindingResult, Model model) {
        disciplinaryLiabilityService.createDisciplinaryLiability(disciplinaryLiability, studentId);
        return showStudentCard(studentId, studentService.getGroupId(studentId), model);
    }

    @PostMapping("/showEditCurator")
    public String showEditCurator(@RequestParam(required = true, defaultValue = "") Long curatorId, @RequestParam(required = true, defaultValue = "") Long groupId, Model model) {
         Curator curator = curatorService.getById(curatorId);
                 curator.getUser().setPassword("");
        model.addAttribute("curator", curator);
        model.addAttribute("selGroup", groupService.getById(groupId));
        return "editCurator";
    }

    @PostMapping("/addCurator")
    public String addCurator(@ModelAttribute("curator") Curator curator, @RequestParam(required = true, defaultValue = "") Long cathedraId, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addCurator";
        }
        if (!curator.getUser().getPassword().equals(curator.getUser().getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "addCurator";
        }
        if (!userService.saveCuratorUser(curator.getUser())) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "addCurator";
        }
        curatorService.createCurator(curator, cathedraId);
        return headOfDepartmentMain(model);
    }

    @PostMapping("/editCurator")
    public String editCurator(@ModelAttribute("curator") Curator curator, @RequestParam(required = true, defaultValue = "") long groupId, BindingResult bindingResult, Model model) {
         if (bindingResult.hasErrors()) {
             model.addAttribute("group", groupService.getById(groupId));
           return "editCurator";
        }
      if (!curator.getUser().getPassword().equals("")){
        if (!curator.getUser().getPassword().equals(curator.getUser().getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
           model.addAttribute("group", groupService.getById(groupId));
         return "editCurator";
        }
        curator.getUser().setRoles(Collections.singleton(new Role(1L, "ROLE_CURATOR")));    
        userService.changePassword(curator.getUser());
      }
    curatorService.saveCurator(curator);
        return showAboutCurator(groupId, model);
    }
    
    
     @PostMapping("/editTradition")
    public String showEditTradition(@RequestParam(required = true, defaultValue = "") long traditionId, @RequestParam(required = true, defaultValue = "") long groupId, Model model) {
        Tradition tradition=traditionService.getById(traditionId);
           model.addAttribute("action", "Редактировать");
             model.addAttribute("action1", "Сохранить изменения");
        model.addAttribute("tradition", tradition);
          model.addAttribute("group", groupService.getById(groupId));
        return "addTradition";
    }
    
     @GetMapping("/delTradition")
    public String deleteTradition(@RequestParam(required = true, defaultValue = "") long traditionId, @RequestParam(required = true, defaultValue = "") long groupId, Model model) {
        traditionService.delTradition(traditionId);
        return showTraditions(groupId, model);
    }
    
     
     @PostMapping("/editеTradition")
    public String showAddTradition(@RequestParam(required = true, defaultValue = "") long traditionId, @RequestParam(required = true, defaultValue = "") long groupId, Model model) {
        Tradition tradition=traditionService.getById(traditionId);
   model.addAttribute("action", "Добавить");
             model.addAttribute("action1", "Добавить");
        model.addAttribute("tradition", tradition);
          model.addAttribute("group", groupService.getById(groupId));
        return "addTradition";
    }
     
}
