package com.blog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  // constructor with arguments
@AllArgsConstructor // default constructor
public class PostDto {
    private long id;
    @NotEmpty
    @Size(min = 2 , message = "Title should be atleast 2 characters") //@Size annotation should be applied only on String.
    private String title;
    @NotEmpty
    @Size(min = 4 , message = "Desciption should be atleast 4 characters")
    private String description;
    @NotEmpty
    @Size(min = 4 , message = "Desciption should be atleast 4 characters")
    private String content;

}

// If data correct controller layer will give data to service.
// If not correct controller layer will give error msg  to postman.