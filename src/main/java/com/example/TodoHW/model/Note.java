package com.example.TodoHW.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "notes")
public class Note {


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NotNull
//    @Size(max = 100)
    private String title;
//    @Size(max = 255)
    private String content;


}
