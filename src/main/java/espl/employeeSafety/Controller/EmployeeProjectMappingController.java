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

import espl.employeeSafety.Entity.EmployeeProjectMapping;
import espl.employeeSafety.Service.EmployeeProjectMappingService;

@RestController
@RequestMapping("/api/employeesprojectmappings")
public class EmployeeProjectMappingController {
	@Autowired
	private EmployeeProjectMappingService employeesEmployeeProjectMappingMappingService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EmployeeProjectMapping>> getAllEmployeeProjectMappings(){
		return new ResponseEntity<List<EmployeeProjectMapping>>(employeesEmployeeProjectMappingMappingService.getAllEmployeeProjectMappings(),HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<EmployeeProjectMapping> getEmployeeProjectMappingById(@PathVariable("id") int id) {
		return new ResponseEntity<EmployeeProjectMapping>(employeesEmployeeProjectMappingMappingService.getEmployeeProjectMappingById(id), HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployeeProjectMapping(@PathVariable("id") int id) {
		employeesEmployeeProjectMappingMappingService.deleteEmployeeProjectMapping(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeProjectMapping> updateEmployeeProjectMapping(@PathVariable("id") int id, @RequestBody EmployeeProjectMapping employeesprojectmapping) {
		employeesprojectmapping.setId(id);
		return new ResponseEntity<EmployeeProjectMapping>(employeesEmployeeProjectMappingMappingService.updateEmployeeProjectMapping(id, employeesprojectmapping), HttpStatus.OK); 
	}

	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insertEmployeeProjectMapping(@RequestBody EmployeeProjectMapping employeesprojectmapping) {
		employeesEmployeeProjectMappingMappingService.addEmployeeProjectMapping(employeesprojectmapping);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
