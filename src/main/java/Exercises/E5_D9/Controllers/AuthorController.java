package Exercises.E5_D9.Controllers;

/* -------------------------- USERS CRUD ------------------------------------

1. GET http://localhost:3001/Blog (+ query params opzionali)
2. POST http://localhost:3001/Blog (+ body)
3. GET http://localhost:3001/Blog/:id
4. PUT http://localhost:3001/Blog/:id (+ body)
5. DELETE http://localhost:3001/Blog/:id

*/

import Exercises.E5_D9.Entities.Author;
import Exercises.E5_D9.Entities.Blog;
import Exercises.E5_D9.Services.AuthorService;
import Exercises.E5_D9.Services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/Author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author target) {
        return authorService.save(target);
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable long id) throws FileNotFoundException {
        return authorService.findById(id);
    }

    @PutMapping("/{id}")
    public Author findByIdAndUpdate(@PathVariable long id, @RequestBody Author target) throws FileNotFoundException {
        return authorService.findByIdAndUpdate(id, target);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable long id) {
        authorService.findByIdAndDelete(id);
    }
}
