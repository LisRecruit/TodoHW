package com.example.TodoHW.mapper;

import com.example.TodoHW.model.Note;
import com.example.TodoHW.model.dto.NoteCreateRequest;
import com.example.TodoHW.model.dto.NoteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;



@Mapper(componentModel = "spring",
nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NoteMapper {
    NoteResponse toNoteResponse (Note note);
    @Mapping(target = "id", ignore = true)
    Note toNote(NoteCreateRequest createRequest);
}
