package com.github.curriculeon.services;

import com.github.curriculeon.repositories.PersonRepository;
import com.github.curriculeon.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Iterable<Person> index() {
        List<Person> personList = new ArrayList<>();
        repository.findAll().forEach(personList::add);
        return personList;
    }

    public Person show(Long id) {
        return repository.findById(id).get();
    }

    public Person create(Person person) {
        return repository.save(person);
    }

    public Person update(Long id, Person newPersonData) {
        Person originalPerson = repository.findById(id).get();
        originalPerson.setName(newPersonData.getName());
        return repository.save(originalPerson);
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
