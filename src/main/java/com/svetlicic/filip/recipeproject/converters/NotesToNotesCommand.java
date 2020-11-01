package com.svetlicic.filip.recipeproject.converters;

import com.svetlicic.filip.recipeproject.commands.NotesCommand;
import com.svetlicic.filip.recipeproject.model.Notes;
import lombok.Synchronized;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand {

    @Synchronized
    @Nullable
    public NotesCommand convert(Notes notes){

        if (notes == null) {
            return null;
        }

        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(notes.getId());
        notesCommand.setRecipeNotes(notes.getRecipeNotes());
        return notesCommand;
    }
}
