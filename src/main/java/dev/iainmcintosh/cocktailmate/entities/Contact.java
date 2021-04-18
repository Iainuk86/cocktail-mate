package dev.iainmcintosh.cocktailmate.entities;

import lombok.Data;

@Data
public class Contact {

    private String name;
    private String email;
    private String subject;
    private String message;

}
