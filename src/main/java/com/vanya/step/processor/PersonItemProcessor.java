package com.vanya.step.processor;

import com.vanya.model.Person;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by Hladush Ivan
 * on 14.10.16.
 */
public class PersonItemProcessor  implements ItemProcessor<Person,Person>{
    @Override
    public Person process(Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = new Person(firstName, lastName);
        return transformedPerson;
    }
}
