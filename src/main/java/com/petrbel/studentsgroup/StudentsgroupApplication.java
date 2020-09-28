package com.petrbel.studentsgroup;

import com.petrbel.studentsgroup.domain.Person;
import com.petrbel.studentsgroup.domain.StudentsGroup;
import com.petrbel.studentsgroup.repository.PersonRepository;
import com.petrbel.studentsgroup.repository.StudentsGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class StudentsgroupApplication {


    public static void main(String[] args) {
        SpringApplication.run(StudentsgroupApplication.class, args);
    }
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private StudentsGroupRepository repository2;
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private PersonRepository repository;

 @PostConstruct
    public void init() {
    repository2.save(new StudentsGroup("15-15",1));
    repository2.save(new StudentsGroup("15-16", 2));
     repository2.save(new StudentsGroup("15-17", 3));
     repository2.save(new StudentsGroup("15-18", 4));
     repository2.save(new StudentsGroup("15-19", 1));
    repository2.save(new StudentsGroup("15-20",1));
    repository2.save(new StudentsGroup("15-21", 2));
     repository2.save(new StudentsGroup("15-22", 3));
     repository2.save(new StudentsGroup("15-23", 4));
     repository2.save(new StudentsGroup("15-24", 3));
    repository2.save(new StudentsGroup("15-25",1));
    repository2.save(new StudentsGroup("16-1", 2));
     repository2.save(new StudentsGroup("16-2", 3));
     repository2.save(new StudentsGroup("16-3", 1));
     repository2.save(new StudentsGroup("16-4", 3));
        repository2.save(new StudentsGroup("16-5", 2));
     repository2.save(new StudentsGroup("16-6", 3));
     repository2.save(new StudentsGroup("16-7", 2));
     repository2.save(new StudentsGroup("16-8", 3));




     repository.save(new Person("Татьяна Лужова","15-15" ));
     repository.save(new Person("Петр Иванов","15-16"));
     repository.save(new Person("Сергей Чурсин","15-16"));
     repository.save(new Person("Александр Беляев","15-17"));
     repository.save(new Person("Даниил Кацман","15-17"));
     repository.save(new Person("Виктор Серебренников","15-17"));
    repository.save(new Person("Максим Пыжов","15-18" ));
     repository.save(new Person("Тимур Щеколдин","15-18"));
     repository.save(new Person("Антон Чукреев","15-18"));
     repository.save(new Person("Алексей Генералов","15-18"));
     repository.save(new Person("Олег Рубан","15-19"));
     repository.save(new Person("Альберт Таранов","15-20"));
     repository.save(new Person("Дмитрий Пучков","15-21"));
    repository.save(new Person("Артем Мурашев","15-21" ));
     repository.save(new Person("Анна Сидорова","15-22"));
     repository.save(new Person("Елена Чумак","15-22"));
     repository.save(new Person("Элеонора Васильева","15-22"));
     repository.save(new Person("Виктория Ким","15-23"));
     repository.save(new Person("Наталья Безикова","15-23"));
     repository.save(new Person("Федор Безруков","15-23"));
     repository.save(new Person("Елена Чумак","15-23"));
     repository.save(new Person("Элеонора Васильева","15-24"));
     repository.save(new Person("Екатерина Воронина","15-24"));
     repository.save(new Person("Святосвлав Святка","15-24"));
      repository.save(new Person("Павел Никитин","15-25"));
      repository.save(new Person("Яна Романенко","16-1"));
     repository.save(new Person("Карина Цаплина","16-1"));
     repository.save(new Person("Зинаида Полкина","16-2"));
     repository.save(new Person("Надежда Фролова","16-2"));
     repository.save(new Person("Тамара Лесникова","16-2"));
        repository.save(new Person("Зоя Фоменко","16-3"));
      repository.save(new Person("Олеся Шлюпкина","16-4"));
     repository.save(new Person("Анастасия Машурова","16-4"));
     repository.save(new Person("Лев Холявко","16-4"));
     repository.save(new Person("Борис Богомолов","16-5"));
     repository.save(new Person("Кирилл Маков","16-5"));
        repository.save(new Person("Иван Шило","16-6"));
     repository.save(new Person("Вячеслав Дмитрачков","16-6"));
      repository.save(new Person("Оксана Девяткина","16-6"));
     repository.save(new Person("Маруся Климова","16-7"));
     repository.save(new Person("Антон Дачный","16-7"));
     repository.save(new Person("Марат Блочный","16-8"));
     repository.save(new Person("Юлия Санжарова","16-8"));
        repository.save(new Person("Кира Филимонова","16-8"));

    }
}
