package com.vanya.converter.mapper;

import com.vanya.model.Player;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

/**
 * Created by Hladush Ivan
 * on 16.10.16.
 */
public class PlayerFieldSetMapper implements FieldSetMapper<Player> {
    @Override
    public Player mapFieldSet(FieldSet fieldSet) {
        return new Player(fieldSet.readString(0),
                fieldSet.readString(1),
                fieldSet.readString(2),
                fieldSet.readString(3),
                fieldSet.readInt(4),
                fieldSet.readInt(5)
        );
    }
}
