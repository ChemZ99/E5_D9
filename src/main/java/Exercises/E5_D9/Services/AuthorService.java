package Exercises.E5_D9.Services;

import Exercises.E5_D9.Entities.Author;
import Exercises.E5_D9.Entities.Blog;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class AuthorService {
    private List<Author> authors = new ArrayList<>();
    Exception ex;

    public Author save(Author target) {
        Random rndm = new Random();
        target.setId(rndm.nextLong(1,10000));
        this.authors.add(target);
        return target;
    }

    public List<Author> getAuthors() {
        return this.authors;
    }

    public Author findById(long id) throws FileNotFoundException {
        Author a = null;
        for (Author author: this.authors) {
            if (author.getId() == id) {
                a = author;
            }
        }
        if (a == null) {
            throw new FileNotFoundException();
        } else  {
            return a;
        }
    }
    public void findByIdAndDelete(long id) {
        ListIterator<Author> iterator = this.authors.listIterator();
        while (iterator.hasNext()) {
            Author target = iterator.next();
            if (target.getId() == id) {
                iterator.remove();
            }
        }
    }
    public Author findByIdAndUpdate(long id, Author target) throws FileNotFoundException {
        Author a = null;
        for (Author author:this.authors) {
            if (author.getId() == id) {
                a = author;
                a.setId(id);
                a.setName(target.getName());
                a.setSurname(target.getSurname());
                a.setEmail(target.getEmail());
                a.setBirth(target.getBirth());
                a.setAvatar(target.getAvatar());
            }
        }
        if (a == null) {
            throw new FileNotFoundException();
        } else {
            return a;
        }
    }
}
