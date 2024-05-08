package com.blog.controller;

import com.blog.payload.PostDto;
import com.blog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // API controller layer - TO build a controller layer in API.
// For API front end here is postman .It can be any other tool.Postman is one of the testing tool of API.
@RequestMapping("/api/posts")
public class PostController {


    private PostService postService;

    public PostController(PostService postService) {

        this.postService = postService;
    }

    @PostMapping      //used to craete post.                                                                                                        // For CRUD operations creating post we have to use PostmMpping.
                                                                                                                              // Whenever we want to save JSON object to database - PostMapping.
    public ResponseEntity <?> createPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult){                   // 1. Data from postman comes to createPost(postDto).
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);  // This line will get the message(Title should be atleast 2 characters)in PostDto class (title).
        }
        PostDto dto = postService.createPost(postDto);                                                                        // To display "post is created " in postman app
        return new ResponseEntity<>(dto, HttpStatus.CREATED);                                                                 // 1."ResponseEntity"
                                                                                                                              // 2.return new ResponseEntity<>("Post is created", HttpStatus.CREATED);
                                                                                                                              // To display id,dispaly,content,description on poastman we have to write <PostDto>
                                                                                                                              // To copy data from JSON to PostDto we have to add @RequestBody.

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Post is Deleted!!!",HttpStatus.OK);
    }


    // To get all data from database:

    //http://localhost:8080/api/posts?pageNo=0&pageSize=5&sortBy=namen&sortDir=asc
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(
            @RequestParam(name="pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(name="pageSize", defaultValue = "3", required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) {

        List<PostDto> postDtos = postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(postDtos,HttpStatus.OK);

    }

    //http://localhost:8080/api/posts?postId=1

    @PutMapping
    public ResponseEntity<PostDto> updatePost(
            @RequestParam("postId") long postId, // @RequestParam - it fetch the value from the url and put that into "postId"
            @RequestBody PostDto postDto          // copy the data from JSON to PostDto postDto
    ){

        PostDto dto = postService.updatePost(postId, postDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
