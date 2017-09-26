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

import espl.employeeSafety.Entity.Project;
import espl.employeeSafety.Service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Project>> getAllProjects(){
		return new ResponseEntity<List<Project>>(projectService.getAllProjects(),HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Project> getProjectById(@PathVariable("id") int id) {
		return new ResponseEntity<Project>(projectService.getProjectById(id), HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProject(@PathVariable("id") int id) {
		projectService.deleteProject(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Project> updateProject(@PathVariable("id") int id, @RequestBody Project project) {
		project.setId(id);
		return new ResponseEntity<Project>(projectService.updateProject(id, project), HttpStatus.OK); 
	}

	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insertProject(@RequestBody Project project) {
		projectService.addProject(project);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
