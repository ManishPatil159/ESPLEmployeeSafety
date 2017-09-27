package espl.employeeSafety.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import espl.employeeSafety.Entity.InOfficeEmployees;
import espl.employeeSafety.Service.InOfficeEmployeesService;

@RestController
@RequestMapping("/api/inofficeemployees")
public class InOfficeEmployeesController {
	@Autowired
	private InOfficeEmployeesService inofficeemployeesService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<InOfficeEmployees>> getAllInOfficeEmployeess(){
		return new ResponseEntity<List<InOfficeEmployees>>(inofficeemployeesService.getAllInOfficeEmployeess(),HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<InOfficeEmployees> getInOfficeEmployeesById(@PathVariable("id") int id) {
		return new ResponseEntity<InOfficeEmployees>(inofficeemployeesService.getInOfficeEmployeesById(id), HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteInOfficeEmployees(@PathVariable("id") int id) {
		inofficeemployeesService.deleteInOfficeEmployees(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InOfficeEmployees> updateInOfficeEmployees(@PathVariable("id") int id, @RequestBody InOfficeEmployees inofficeemployees) {
		inofficeemployees.setId(id);
		return new ResponseEntity<InOfficeEmployees>(inofficeemployeesService.updateInOfficeEmployees(id, inofficeemployees), HttpStatus.OK); 
	}

	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insertInOfficeEmployees(@RequestBody InOfficeEmployees inofficeemployees) {
		inofficeemployeesService.addInOfficeEmployees(inofficeemployees);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
