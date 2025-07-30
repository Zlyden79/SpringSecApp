package ru.netology.zlyden.DaoHibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.zlyden.DaoHibernate.domain.Person;
import ru.netology.zlyden.DaoHibernate.repository.PersonsRepository;

import java.util.List;

@Service
public class PersonsService {
    private final PersonsRepository personsRepository;

    @Autowired
    public PersonsService(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    public List<Person> getAllPersons() {
        return personsRepository.findAll();
    }

    public List<Person> getPersonsByCity(String city) {
        return personsRepository.findByIgnoreCaseCityOfLiving(city);
    }

    public List<Person> getPersonsByAge(int age) {
        return personsRepository.findByHumanAgeLessThanOrderByHumanAgeAsc(age);
    }

    public List<Person> getPersonsByNameSurname(String name, String surname) {
        return personsRepository.findByHumanNameIgnoreCaseAndHumanSurnameIgnoreCase(name, surname);
    }

}

