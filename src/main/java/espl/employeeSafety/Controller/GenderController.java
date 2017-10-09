package espl.employeeSafety.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import espl.employeeSafety.Entity.Gender;
import espl.employeeSafety.Service.GenderService;

@RestController
@RequestMapping("/api/genders")
public class GenderController {
	@Autowired
	private GenderService genderService;

	/*@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Gender>> getAllGenders(){
		return new ResponseEntity<List<Gender>>(genderService.getAllGenders(),HttpStatus.OK);
	}*/
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Resource<Gender>>> getAllGenders() {

		Collection<Gender> genders = genderService.getAllGenders();
		List<Resource<Gender>> resources = new ArrayList<Resource<Gender>>();
		for (Gender gender : genders) {
			resources.add(getAllGenders(gender));
		}
		return new ResponseEntity<>( resources,HttpStatus.OK);

	}
	private Resource<Gender> getAllGenders(Gender gender) {

		Resource<Gender> resource = new Resource<Gender>(gender);

		resource.add(linkTo(methodOn(GenderController.class).getGenderById(gender.getId())).withSelfRel());
		
		return resource;

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
