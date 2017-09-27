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

import espl.employeeSafety.Entity.Sos;
import espl.employeeSafety.Service.SosService;

@RestController
@RequestMapping("/api/soss")
public class SosController {
	@Autowired
	private SosService sosService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Sos>> getAllSoss(){
		return new ResponseEntity<List<Sos>>(sosService.getAllSoss(),HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Sos> getSosById(@PathVariable("id") int id) {
		return new ResponseEntity<Sos>(sosService.getSosById(id), HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteSos(@PathVariable("id") int id) {
		sosService.deleteSos(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sos> updateSos(@PathVariable("id") int id, @RequestBody Sos sos) {
		sos.setId(id);
		return new ResponseEntity<Sos>(sosService.updateSos(id, sos), HttpStatus.OK); 
	}

	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insertSos(@RequestBody Sos sos) {
		sosService.addSos(sos);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
