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

import espl.employeeSafety.Entity.Designation;
import espl.employeeSafety.Service.DesignationService;

@RestController
@RequestMapping("/api/designations")
public class DesignationController {
	@Autowired
	private DesignationService designationService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Designation>> getAllDesignations(){
		return new ResponseEntity<List<Designation>>(designationService.getAllDesignations(),HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Designation> getDesignationById(@PathVariable("id") int id) {
		return new ResponseEntity<Designation>(designationService.getDesignationById(id), HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteDesignation(@PathVariable("id") int id) {
		designationService.deleteDesignation(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Designation> updateDesignation(@PathVariable("id") int id, @RequestBody Designation designation) {
		designation.setId(id);
		return new ResponseEntity<Designation>(designationService.updateDesignation(id, designation), HttpStatus.OK); 
	}

	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insertDesignation(@RequestBody Designation designation) {
		designationService.addDesignation(designation);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
