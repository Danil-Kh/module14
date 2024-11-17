package org.example.module14;

import org.example.module14.Exceptions.UnableDeleteNote;
import org.example.module14.Exceptions.UnableFindNote;
import org.example.module14.Exceptions.UnableUpdateNote;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.*;

@SpringBootApplication
@Service
public class NodeCrudServise {
    private static Note note;
    private static Map<Long, Note> notes = new HashMap();
    private static Random idGenerator = new Random();


    public List<Note> listAllNotes() {
        return new ArrayList<>(notes.values());
    }
    public static void deleteById(long id){
        int allNotes = notes.size();
        notes.remove(id);
        if (allNotes == notes.size()){
            throw new UnableDeleteNote();
        }
    }
    public void updateNote(Note note){
       if (notes.containsKey(note.getId())){
           notes.put(note.getId(), note);
       }
       else{
           throw new UnableUpdateNote();
       }
    }
    public Note getNoteById(long id){
        if (notes.containsKey(id)){
           return notes.get(id);
        }
        else{
            throw new UnableFindNote();
        }
    }

   public Note addNote(Note note) {
        Long id = Math.abs(idGenerator.nextLong());
       while (true) {
           if (notes.containsKey(id)) {
               id = Math.abs(idGenerator.nextLong());
           }
           else {
               note.setId(id);
               notes.put(id, note);
               return note;
           }
       }

   }
}
