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

import espl.employeeSafety.Entity.RuleMapping;
import espl.employeeSafety.Service.RuleMappingService;

@RestController
@RequestMapping("/api/rulemappings")
public class RuleMappingController {
	@Autowired
	private RuleMappingService rulemappingService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<RuleMapping>> getAllRuleMappings(){
		return new ResponseEntity<List<RuleMapping>>(rulemappingService.getAllRuleMappings(),HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<RuleMapping> getRuleMappingById(@PathVariable("id") int id) {
		return new ResponseEntity<RuleMapping>(rulemappingService.getRuleMappingById(id), HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRuleMapping(@PathVariable("id") int id) {
		rulemappingService.deleteRuleMapping(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RuleMapping> updateRuleMapping(@PathVariable("id") int id, @RequestBody RuleMapping rulemapping) {
		rulemapping.setId(id);
		return new ResponseEntity<RuleMapping>(rulemappingService.updateRuleMapping(id, rulemapping), HttpStatus.OK); 
	}

	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insertRuleMapping(@RequestBody RuleMapping rulemapping) {
		rulemappingService.addRuleMapping(rulemapping);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
