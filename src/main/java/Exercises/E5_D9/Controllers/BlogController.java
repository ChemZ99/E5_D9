package Exercises.E5_D9.Controllers;

/* -------------------------- USERS CRUD ------------------------------------

1. GET http://localhost:3001/Blog (+ query params opzionali)
2. POST http://localhost:3001/Blog (+ body)
3. GET http://localhost:3001/Blog/:id
4. PUT http://localhost:3001/Blog/:id (+ body)
5. DELETE http://localhost:3001/Blog/:id

*/

import Exercises.E5_D9.Entities.Blog;
import Exercises.E5_D9.Services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/Blog")
public class BlogController {
@Autowired
    private BlogService blogService;

@GetMapping("")
    public List<Blog> getBlogs(){
    return blogService.getBlogs();
}

@PostMapping("")
@ResponseStatus(HttpStatus.CREATED)
    public Blog saveBlog(@RequestBody Blog target) {
    return blogService.save(target);
}

@GetMapping("/{id}")
    public Blog findById(@PathVariable long id) throws FileNotFoundException {
    return blogService.findById(id);
}

@PutMapping("/{id}")
    public Blog findByIdAndUpdate(@PathVariable long id, @RequestBody Blog target) throws FileNotFoundException {
    return blogService.findByIdAndUpdate(id, target);
}

@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable long id) {
    blogService.findByIdAndDelete(id);
}
}
