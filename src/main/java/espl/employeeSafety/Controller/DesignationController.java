package espl.employeeSafety.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;





import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.hateoas.Resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.*;
import org.springframework.beans.factory.annotation.Qualifier;
import espl.employeeSafety.Entity.Designation;
import espl.employeeSafety.Entity.Project;
import espl.employeeSafety.Repository.DesignationRepository;
import espl.employeeSafety.Service.DesignationService;

@RestController
@RequestMapping("/api/designations")
public class DesignationController {
	@Autowired
	private DesignationService designationService;
	@Autowired
	private PagedResourcesAssembler<Designation> assembler;
	//@Inject
 //   private CustomResourceAssembler customResourceAssembler;
	

  /*  @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    public PagedResources<Resource> customs(Pageable pageable, PagedResourcesAssembler<Designation> assembler) {
        Page<Designation> customs = designationService.getAllDesignations(pageable);
        return assembler.toResource(customs, customResourceAssembler);
    }*/
/*	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<Designation>> getAllDesignations(Pageable pageable){
		return new ResponseEntity<Page<Designation>>(designationService.getAllDesignations(pageable),HttpStatus.OK);
	}*/
	@RequestMapping(method=RequestMethod.GET, produces = "application/x-spring-data-compact+json")
	@ResponseBody
	public ResponseEntity<PagedResources<Resource<Designation>>> getAllDesignations(Pageable pageable){
		Page<Designation> designations = designationService.getAllDesignations(pageable);
		
		List<Resource<Designation>> resources = new ArrayList<Resource<Designation>>();
		for (Designation designation : designations) {
			resources.add(getAllDesignations(designation));
		}
		int start = pageable.getOffset();
		int end = (start + pageable.getPageSize()) > resources.size() ? resources.size() : (start + pageable.getPageSize());
		Page<Designation> pages = new PageImpl(resources.subList(start, end), pageable, resources.size());
		PagedResources<Resource<Designation>> paged = assembler.toResource(pages);
		
		/*JSONParser parser = new JSONParser(); 
		JSONObject json = (JSONObject) parser.parse(paged);*/

		return new ResponseEntity<>(paged,HttpStatus.OK);
	}
	

/*	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<Resource<Designation>> getAllDesignations() {

		Collection<Designation> designations = designationService.getAllDesignations();
		List<Resource<Designation>> resources = new ArrayList<Resource<Designation>>();
		for (Designation designation : designations) {
			resources.add(getAllDesignations(designation));
		}
		return resources;

	}
*/	private Resource<Designation> getAllDesignations(Designation designation) {

		Resource<Designation> resource = new Resource<Designation>(designation);

		resource.add(linkTo(methodOn(DesignationController.class).getDesignationById(designation.getId())).withSelfRel());
		
		return resource;

	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Designation> getDesignationById(@PathVariable("id") int id) {
		return new ResponseEntity<Designation>(designationService.getDesignationById(id), HttpStatus.OK);
	}
	
	@RequestMapping( value="/search", method=RequestMethod.GET)
	public ResponseEntity<List<Designation>> getEmployeeById(String searchTerm) {
		return new ResponseEntity<List<Designation>>(designationService.searchDesignationName(searchTerm), HttpStatus.OK);
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
