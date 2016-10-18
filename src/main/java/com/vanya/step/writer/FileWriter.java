package com.vanya.step.writer;

import com.vanya.model.Person;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Hladush Ivan
 * on 14.10.16.
 */
public class FileWriter implements ItemWriter<Person> {
    private static int number = 1;
    private PrintWriter printWriter;

    @BeforeStep
    public void createWriter() throws IOException {
        File f= new File(number+".txt");
        number++;
        f.createNewFile();
        printWriter=new PrintWriter(f);
    }
    @Override
    public void write(List<? extends Person> persons) throws Exception {
        System.out.println("~~~~~~~~~Start write~~~~~~~~~");
        for (Person person : persons) {
            printWriter.write(person.toString()+"\n");
        }
    }

    @AfterStep
    public void destroy(){
        printWriter.close();
    }
}
