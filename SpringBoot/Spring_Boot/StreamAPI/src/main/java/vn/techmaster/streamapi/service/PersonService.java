package vn.techmaster.streamapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.streamapi.dao.PersonDAOImpl;
import vn.techmaster.streamapi.model.Person;

import java.util.List;
import java.util.Map;

@Service
public class PersonService {
    @Autowired
    PersonDAOImpl personDAOImpl;
    public List<Person> getAllPersons() {
        return personDAOImpl.getAll();
    }
    public List<Person> sortPeopleByFullName(){
        return personDAOImpl.sortPeopleByFullName();
    }
    public List<Person> sortPeopleByFullNameReversed(){
        return personDAOImpl.sortPeopleByFullNameReversed();
    }
    public List<String> getSortedJobs(){
        return personDAOImpl.getSortedJobs();
    }
    public List<String> getSortedCities(){
        return personDAOImpl.getSortedCities();
    }
    public List<String> femaleNames(){
        return personDAOImpl.femaleNames();
    }
    public Person highestEarned(){
        return personDAOImpl.highestEarner();
    }
    public List<Person> bornAfter1990(){
        return personDAOImpl.bornAfter1990();
    }
    public double avgSalary(){
        return personDAOImpl.averageSalary();
    }
    public double avgAge(){
        return personDAOImpl.averageAge();
    }
    public List<Person> nameContains(String key){
        return personDAOImpl.nameContains(key);
    }
    public List<Person> sortedByAgeByMale(){
        return personDAOImpl.sortedByAgeForMale();
    }
    public Person longestName(){
        return personDAOImpl.longestName();
    }
    public List<Person> aboveAverageSalary(){
        return personDAOImpl.aboveAverageSalary();
    }
    public Map<String,List<Person>> groupPeopleByCity(){
        return personDAOImpl.groupPeopleByCity();
    }
    public Map<String,Integer> groupJobByCount(){
        return personDAOImpl.groupJobByCount();
    }
    public List<Person> inSalaryRange(int start, int end){
        return personDAOImpl.inSalaryRange(start,end);
    }
    public List<Person> startsWith(String prefix){
        return personDAOImpl.startsWith(prefix);
    }
    public List<Person> sortByBirthYearDescending(){
        return personDAOImpl.sortByBirthYearDescending();
    }
    public List<Person> top5HighestPaid(){
        return personDAOImpl.top5HighestPaid();
    }
    public List<Person> inAgeRange(int start, int end){
        return personDAOImpl.inAgeRange(start,end);
    }

}
