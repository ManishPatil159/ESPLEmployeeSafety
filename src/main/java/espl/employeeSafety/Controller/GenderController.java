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

import espl.employeeSafety.Entity.Gender;
import espl.employeeSafety.Service.GenderService;

@RestController
@RequestMapping("/api/genders")
public class GenderController {
	@Autowired
	private GenderService genderService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Gender>> getAllGenders(){
		return new ResponseEntity<List<Gender>>(genderService.getAllGenders(),HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Gender> getGenderById(@PathVariable("id") int id) {
		return new ResponseEntity<Gender>(genderService.getGenderById(id), HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteGender(@PathVariable("id") int id) {
		genderService.deleteGender(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gender> updateGender(@PathVariable("id") int id, @RequestBody Gender gender) {
		gender.setId(id);
		return new ResponseEntity<Gender>(genderService.updateGender(id, gender), HttpStatus.OK); 
	}

	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insertGender(@RequestBody Gender gender) {
		genderService.addGender(gender);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
