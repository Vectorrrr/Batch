package com.vanya.converter;

import com.vanya.model.Person;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Hladush Ivan
 * on 14.10.16.
 */
public class PersonConverter<S, P> implements Converter<String,Person>{
    @Override
    public Person convert(String source) {
        String values[]=source.split(",");
        Person person=new Person();
        person.setFirstName(values[0]);
        person.setLastName(values[1]);
        return person;
    }
}
