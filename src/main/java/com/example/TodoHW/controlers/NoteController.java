package com.example.TodoHW.controlers;

import com.example.TodoHW.model.Note;
import com.example.TodoHW.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@Controller
@RequestMapping("/note")
public class NoteController {
    public static final String REDIRECT_TO_LIST = "redirect:/note/list";

    @Autowired
    private NoteService noteService;

    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", noteService.listAll());
        return "note_list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") Long id) {
        noteService.deleteById(id);
        return REDIRECT_TO_LIST;
    }

    @GetMapping("/edit")
    public String editNoteForm(@RequestParam("id") Long id, Model model) {
        model.addAttribute("note", noteService.getById(id));
        return "note_edit";
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute Note note) {
        noteService.update(note);
        return REDIRECT_TO_LIST;
    }

    @GetMapping("/add")
    public String showAddNoteForm(Model model){
        model.addAttribute("note", new Note());
        return "add_note";
    }
    @PostMapping("/add")
    public String addNote (@ModelAttribute("note") Note note) {
        noteService.add(note);
        return REDIRECT_TO_LIST;
    }

}
