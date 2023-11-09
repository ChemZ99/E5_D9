package Exercises.E5_D9.Services;

import Exercises.E5_D9.Entities.Blog;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class BlogService {
    private List<Blog> blogs = new ArrayList<>();
    Exception ex;

    public Blog save(Blog target) {
        Random rndm = new Random();
        target.setId(rndm.nextLong(1,10000));
        this.blogs.add(target);
        return target;
    }

    public List<Blog> getBlogs() {
        return this.blogs;
    }

    public Blog findById(long id) throws FileNotFoundException {
        Blog b = null;
        for (Blog blog: this.blogs) {
            if (blog.getId() == id) {
                b = blog;
            }
        }
        if (b == null) {
            throw new FileNotFoundException();
        } else  {
            return b;
        }
    }
    public void findByIdAndDelete(long id) {
        ListIterator<Blog> iterator = this.blogs.listIterator();
        while (iterator.hasNext()) {
            Blog target = iterator.next();
            if (target.getId() == id) {
                iterator.remove();
            }
        }
    }
    public Blog findByIdAndUpdate(long id, Blog target) throws FileNotFoundException {
        Blog b = null;
        for (Blog blog:this.blogs) {
            if (blog.getId() == id) {
                b = blog;
                b.setId(id);
                b.setCategory(target.getCategory());
                b.setTitle(target.getTitle());
                b.setCover(target.getCover());
                b.setContent(target.getContent());
                b.setReadTime(target.getReadTime());
            }
        }
        if (b == null) {
            throw new FileNotFoundException();
        } else {
            return b;
        }
    }
}
