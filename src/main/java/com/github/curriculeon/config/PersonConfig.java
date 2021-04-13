package com.github.curriculeon.config;

import com.github.curriculeon.models.Person;
import com.github.curriculeon.services.PersonService;
import com.github.git_leon.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class PersonConfig {
    private PersonService personService;

    @Autowired
    public PersonConfig(PersonService personService) {
        this.personService = personService;
    }

    @PostConstruct
    public void setup() {
        for (int i = 0; i < 20; i++) {
            String randomName = RandomUtils.createString('A', 'Z', 10);
            Person person = new Person();
            person.setName(randomName);
            personService.create(person);
        }
    }
}
