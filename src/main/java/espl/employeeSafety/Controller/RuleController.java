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

import espl.employeeSafety.Entity.Rule;
import espl.employeeSafety.Service.RuleService;

@RestController
@RequestMapping("/api/rules")
public class RuleController {
	@Autowired
	private RuleService ruleService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Rule>> getAllRules(){
		return new ResponseEntity<List<Rule>>(ruleService.getAllRules(),HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Rule> getRuleById(@PathVariable("id") int id) {
		return new ResponseEntity<Rule>(ruleService.getRuleById(id), HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRule(@PathVariable("id") int id) {
		ruleService.deleteRule(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rule> updateRule(@PathVariable("id") int id, @RequestBody Rule rule) {
		rule.setId(id);
		return new ResponseEntity<Rule>(ruleService.updateRule(id, rule), HttpStatus.OK); 
	}

	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insertRule(@RequestBody Rule rule) {
		ruleService.addRule(rule);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
