package net.codejava;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/students")
	public List<Student>list(){
		return service.listAll();
	}

	@GetMapping("/students/{no}")
	public ResponseEntity<Student> get(@PathVariable Integer no){
		try {
			Student student = service.get(no);
			return new ResponseEntity<Student>(student,HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/students")
	public void add(@RequestBody Student student) {
		service.save(student);
	}
	
	@PutMapping("/students/{no}")
	public ResponseEntity<?> update(@RequestBody Student student,@PathVariable Integer no) {
		try {
			Student existStudent=service.get(no);
			service.save(student);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NoSuchElementException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	@DeleteMapping("/students/{no}")
	public void delete(@PathVariable Integer no) {
		service.delete(no);
	}
}
