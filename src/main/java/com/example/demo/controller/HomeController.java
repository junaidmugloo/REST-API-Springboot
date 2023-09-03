package com.example.demo.controller;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Students;
import com.example.demo.service.Studentservice;
import jakarta.transaction.Transactional;

@RestController
@Service
@Transactional
public class HomeController  {

	 @Autowired
	 private Studentservice  repo1;

	@GetMapping("/")
	public String index() {
		return "Welcome";
	}
	@GetMapping("/students")
	public List<Students> list() {
    return repo1.listAll();	
	}

	@PostMapping("/insert")
	public Students Insert(@RequestBody Students students1){	
	
		repo1.save(students1);
		return students1;
	}
    
	@GetMapping("/students/{id}")
	public ResponseEntity<Students> get(@PathVariable Integer id) {
    try {
        Students s1 = repo1.get(id);
        return new ResponseEntity<Students>(s1, HttpStatus.OK);
    } catch (NoSuchElementException e) {
        return new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
    }   
}

@PutMapping("/student/{id}")
public ResponseEntity<?> update(@RequestBody Students s1, @PathVariable Integer id) {
    try {
        repo1.get(id);
		s1.setId(id);
		repo1.save(s1);
        return new ResponseEntity<>(HttpStatus.OK);
    
	} catch (NoSuchElementException e) {
        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
    }      
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<?> delete(@PathVariable Integer id) {
    Students found=repo1.get(id);
	if(found.getId()==id) {
	repo1.delete(id);
	return new ResponseEntity<>("User Deleted",HttpStatus.OK);
	}
	else
        return new ResponseEntity<>("User Not Found",HttpStatus.OK);
    } 
		  //this is the url for api version two
	
}




