package com.example.TodoHW.model.dto;

import lombok.Builder;

@Builder
public record NoteResponse(Long id,
                           String title,
                           String content) {

}
