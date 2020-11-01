package com.svetlicic.filip.recipeproject.converters;

import com.svetlicic.filip.recipeproject.commands.NotesCommand;
import com.svetlicic.filip.recipeproject.model.Notes;
import lombok.Synchronized;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes {

    @Synchronized
    @Nullable
    public Notes convert(NotesCommand notesCommand){

        if (notesCommand == null) {
            return null;
        }

        Notes notes = new Notes();
        notes.setId(notesCommand.getId());
        notes.setRecipeNotes(notesCommand.getRecipeNotes());
        return notes;
    }
}
