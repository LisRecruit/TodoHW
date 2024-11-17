package com.example.service;

import com.example.model.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class NoteService {
    public Map<Long, Note> notes = new HashMap<>();
    private Long generateId (){
        Random random = new Random();
        while (true){
            Long key = random.nextLong();
            if (!notes.containsKey(key)){
                return key;
            }
        }
    }

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        note.setId(generateId());
        notes.put(note.getId(), note);
        return note;
    }


    public void deleteById(Long id){
        if(notes.containsKey(id)){
            notes.remove(id);
            System.out.println("Note removed");
        } else {
            throw new NoSuchElementException("Note not found");
        }
    }

    public void update (Note note) {
        if(notes.containsKey(note.getId())){
            notes.put(note.getId(), note);
        } else {
            throw new NoSuchElementException("Note not found");
        }
    }

    public Note getById (Long id){
        return notes.get(id);
    }

}
