package com.example.TodoHW;

import com.example.model.Note;
import com.example.service.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class NoteServiceTest {
    private NoteService noteService;

    @BeforeEach
    void setUp() {
        noteService = new NoteService();
    }

    @Test
    void testAddNote() {
        Note note = new Note();
        note.setContent("Test content");

        Note addedNote = noteService.add(note);

        assertNotNull(addedNote.getId());
        assertEquals("Test content", addedNote.getContent());
        assertTrue(noteService.notes.containsKey(addedNote.getId()));
    }

    @Test
    void testListAllNotes() {
        Note note1 = new Note();
        note1.setContent("Note 1");
        Note note2 = new Note();
        note2.setContent("Note 2");

        noteService.add(note1);
        noteService.add(note2);

        List<Note> notes = noteService.listAll();

        assertEquals(2, notes.size());
        assertTrue(notes.stream().anyMatch(n -> n.getContent().equals("Note 1")));
        assertTrue(notes.stream().anyMatch(n -> n.getContent().equals("Note 2")));
    }

    @Test
    void testDeleteNoteById() {
        Note note = new Note();
        note.setContent("To be deleted");

        Note addedNote = noteService.add(note);
        Long id = addedNote.getId();

        assertTrue(noteService.notes.containsKey(id));

        noteService.deleteById(id);

        assertFalse(noteService.notes.containsKey(id));
    }

    @Test
    void testDeleteNoteByIdThrowsException() {
        Long nonExistentId = 999L;

        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            noteService.deleteById(nonExistentId);
        });

        assertEquals("Note not found", exception.getMessage());
    }

    @Test
    void testUpdateNote() {
        Note note = new Note();
        note.setContent("Original content");

        Note addedNote = noteService.add(note);
        Long id = addedNote.getId();

        Note updatedNote = new Note();
        updatedNote.setId(id);
        updatedNote.setContent("Updated content");

        noteService.update(updatedNote);

        Note retrievedNote = noteService.getById(id);
        assertEquals("Updated content", retrievedNote.getContent());
    }

    @Test
    void testUpdateNoteThrowsException() {
        Note note = new Note();
        note.setId(999L);
        note.setContent("Non-existent note");

        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            noteService.update(note);
        });

        assertEquals("Note not found", exception.getMessage());
    }

    @Test
    void testGetById() {
        Note note = new Note();
        note.setContent("Note to retrieve");

        Note addedNote = noteService.add(note);
        Long id = addedNote.getId();

        Note retrievedNote = noteService.getById(id);

        assertNotNull(retrievedNote);
        assertEquals("Note to retrieve", retrievedNote.getContent());
    }

    @Test
    void testGetByIdReturnsNullForNonExistentNote() {
        Note note = noteService.getById(999L);
        assertNull(note);
    }

}
