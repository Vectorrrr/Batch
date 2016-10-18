package com.vanya.step.reader;

import com.vanya.model.Person;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.Scanner;

/**
 * Created by Hladush Ivan
 * on 14.10.16.
 */
public class FileReader implements ItemReader<Person>{
    @Autowired
    private Converter<String, Person> converter;

    private Scanner scanner;

    public FileReader(String fileName ) {
        scanner=new Scanner(ClassLoader.getSystemResourceAsStream(fileName));
    }

    @Override
    public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(scanner.hasNextLine()){
            String s = scanner.nextLine();
            System.out.println(s);
            return converter.convert(s);
        }else{
            return null;
        }
    }

    @AfterStep
    public void destroy(){
        scanner.close();
    }
}
