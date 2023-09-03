package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Students;
import com.example.demo.repository.StudentRepository;
import jakarta.transaction.Transactional;
	 
	@Service
	@Transactional
	
	public class Studentservice {
	 
	    @Autowired
	    private StudentRepository repo;
	     
	    public List<Students> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(Students product) {
	        repo.save(product);
	    }
	     
	    public Students get(Integer id) {
	        return repo.findById(id).get();
	    }

		
	     
	    public void delete(Integer id) {
	        repo.deleteById(id);
	    }
	}

