package com.vanya.converter.mapper;

import com.vanya.model.Player;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.LineTokenizer;

/**
 * Created by Hladush Ivan
 * on 16.10.16.
 */
public class DefualtLineMapper implements LineMapper<Player>{

    private FieldSetMapper<Player> setMapper;
    private LineTokenizer tokenizer;

    @Override
    public Player mapLine(String line, int lineNumber) throws Exception {
        System.out.println("DefualtLineMapper accept string "+line+"~~~~~~~~~~~~~~");
        return setMapper.mapFieldSet(tokenizer.tokenize(line));
    }

    public void setSetMapper(FieldSetMapper<Player> setMapper) {
        this.setMapper = setMapper;
    }

    public void setTokenizer(LineTokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }
}
