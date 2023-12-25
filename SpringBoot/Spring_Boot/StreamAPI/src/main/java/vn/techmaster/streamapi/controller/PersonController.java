package vn.techmaster.streamapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.streamapi.model.Person;
import vn.techmaster.streamapi.service.PersonService;

import java.util.List;
import java.util.Map;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;
    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons(){
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.CREATED);
    }
    @GetMapping("/sortPersons")
    public ResponseEntity<List<Person>> sortPersonsByName(){
        return new ResponseEntity<>(personService.sortPeopleByFullName(),HttpStatus.OK);
    }
    @GetMapping("/sortReversePerson")
    public ResponseEntity<List<Person>> sortPersonsByNameReverse(){
        return new ResponseEntity<>(personService.sortPeopleByFullNameReversed(),HttpStatus.OK);
    }
    @GetMapping("/jobs")
    public ResponseEntity<List<String>> getSortJobs(){
        return new ResponseEntity<>(personService.getSortedJobs(),HttpStatus.OK);
    }
    @GetMapping("/cities")
    public ResponseEntity<List<String>> getSortCities(){
        return new ResponseEntity<>(personService.getSortedCities(),HttpStatus.OK);
    }
    @GetMapping("/femaleNames")
    public ResponseEntity<List<String>> femaleNames(){
        return new ResponseEntity<>(personService.femaleNames(),HttpStatus.OK);
    }
    @GetMapping("/highestEarned")
    public ResponseEntity<Person> highestEarned (){
        return new ResponseEntity<>(personService.highestEarned(),HttpStatus.OK);
    }
    @GetMapping("bornAfter1990")
    public ResponseEntity<List<Person>> bornAfter1990(){
        return new ResponseEntity<>(personService.bornAfter1990(),HttpStatus.OK);
    }
    @GetMapping("avgSalary")
    public ResponseEntity<Double> avgSalary(){
        return new ResponseEntity<>(personService.avgSalary(),HttpStatus.OK);
    }
    @GetMapping("/avgAge")
    public ResponseEntity<Double> avgAge(){
        return new ResponseEntity<>(personService.avgAge(),HttpStatus.OK);
    }
    @GetMapping("/{key}")
    public ResponseEntity<List<Person>> nameContains(@PathVariable String key){
        return new ResponseEntity<>(personService.nameContains(key),HttpStatus.OK);
    }
    @GetMapping("/sortedAgeByMale")
    public ResponseEntity<List<Person>> sortedAgeByMale(){
        return new ResponseEntity<>(personService.sortedByAgeByMale(),HttpStatus.OK);
    }
    @GetMapping("/longestName")
    public ResponseEntity<Person> longestName(){
        return new ResponseEntity<>(personService.longestName(),HttpStatus.OK);
    }
    @GetMapping("/aboveAvgSalary")
    public ResponseEntity<List<Person>> aboveAvgSalary(){
        return new ResponseEntity<>(personService.aboveAverageSalary(),HttpStatus.OK);
    }
    @GetMapping("/groupPeopleByCity")
    public ResponseEntity<Map<String,List<Person>>> groupPeopleByCity(){
        return new ResponseEntity<>(personService.groupPeopleByCity(),HttpStatus.OK);
    }
    @GetMapping("/groupJobByCount")
    public ResponseEntity<Map<String,Integer>> groupJobByCount(){
        return new ResponseEntity<>(personService.groupJobByCount(),HttpStatus.OK);
    }
    @GetMapping("/salary{start}/{end}")
    public ResponseEntity<List<Person>> inSalaryRange(@PathVariable int start, @PathVariable int end){
        return new ResponseEntity<>(personService.inSalaryRange(start,end),HttpStatus.OK);
    }
    @GetMapping("/startWith{prefix}")
    public ResponseEntity<List<Person>> startsWith(@PathVariable String prefix){
        return new ResponseEntity<>(personService.startsWith(prefix),HttpStatus.OK);
    }
    @GetMapping("/sortByBirthYearDescending")
    public ResponseEntity<List<Person>> sortByBirthYearDescending(){
        return new ResponseEntity<>(personService.sortByBirthYearDescending(),HttpStatus.OK);
    }
    @GetMapping("/top5HighestPaid")
    public ResponseEntity<List<Person>> top5HighestPaid(){
        return new ResponseEntity<>(personService.top5HighestPaid(),HttpStatus.OK);
    }
    @GetMapping("age{start}/{end}")
    public ResponseEntity<List<Person>> inRangeAge(@PathVariable int start, @PathVariable int end){
        return new ResponseEntity<>(personService.inAgeRange(start,end),HttpStatus.OK);
    }
}
