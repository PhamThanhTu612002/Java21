package vn.techmaster.streamapi.dao;

import org.springframework.stereotype.Repository;
import vn.techmaster.streamapi.database.PersonDB;
import vn.techmaster.streamapi.model.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @Override
    public void printListPeople(List<Person> persons) {
        persons.forEach(System.out::println);
    }

    @Override
    public List<Person> getAll() {
        return PersonDB.personList;
    }

    @Override
    public List<Person> sortPeopleByFullName() {
        return PersonDB.personList.stream().sorted(Comparator.comparing(Person::getFullname)).toList();
    }

    @Override
    public List<Person> sortPeopleByFullNameReversed() {
        return PersonDB.personList.stream().sorted(((o1, o2) -> o2.getFullname().compareTo(o1.getFullname()))).toList();
    }

    @Override
    public List<String> getSortedJobs() {
        List<String> listJob = new ArrayList<>();
        PersonDB.personList.forEach(person -> listJob.add(person.getJob()));
        return listJob.stream().sorted().toList();
    }

    @Override
    public List<String> getSortedCities() {
        List<String> listCities= new ArrayList<>();
        PersonDB.personList.forEach(person -> listCities.add(person.getCity()));
        return listCities.stream().sorted().toList();
    }

    @Override
    public List<String> femaleNames() {
        List<String> listFemaleNames= new ArrayList<>();
        PersonDB.personList.stream().filter(person -> person.getGender().equalsIgnoreCase("female"))
                .forEach(person -> listFemaleNames.add(person.getFullname()));
        return listFemaleNames;
    }

    @Override
    public Person highestEarner() {
       return PersonDB.personList.stream().max((o1, o2) -> o1.getSalary() - o2.getSalary()).get();
    }

    @Override
    public List<Person> bornAfter1990() {
        List<Person> listPerson = new ArrayList<>();
        PersonDB.personList.stream().filter(person -> person.getBirthday().getYear() > 1990).forEach(listPerson::add);
        return listPerson;
    }

    @Override
    public double averageSalary() {
        return (double) (PersonDB.personList.stream().mapToInt(Person::getSalary).sum() / (long) PersonDB.personList.size());
    }

    @Override
    public double averageAge() {
        return (PersonDB.personList.stream().mapToInt(person -> Period.between(person.getBirthday(),LocalDate.now()).getYears()).average().orElse(0.0));
    }

    @Override
    public List<Person> nameContains(String keyword) {
        return PersonDB.personList.stream().filter(person -> person.getFullname().contains(keyword)).toList();
    }

    @Override
    public List<Person> sortedByAgeForMale() {
        return PersonDB.personList.stream().filter(person -> person.getGender().equalsIgnoreCase("Male")).sorted(Comparator.comparingInt(o -> o.getBirthday().getYear())).toList();
    }

    @Override
    public Person longestName() {
        return PersonDB.personList.stream().max(Comparator.comparingInt(name -> name.getFullname().length())).get();
    }

    @Override
    public List<Person> aboveAverageSalary() {
        return PersonDB.personList.stream().filter(person -> person.getSalary() > averageSalary()).toList();
    }

    @Override
    public Map<String, List<Person>> groupPeopleByCity() {
        return PersonDB.personList.stream().collect(Collectors.groupingBy(Person::getCity));
    }

    @Override
    public Map<String, Integer> groupJobByCount() {
        return PersonDB.personList.stream().collect(Collectors.groupingBy(Person::getJob,Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
    }

    @Override
    public List<Person> inSalaryRange(int start, int end) {
        return PersonDB.personList.stream().filter(person -> person.getSalary() >= start && person.getSalary() <= end).collect(Collectors.toList());
    }

    @Override
    public List<Person> startsWith(String prefix) {
        return PersonDB.personList.stream().filter(person -> person.getFullname().startsWith(prefix)).toList();
    }

    @Override
    public List<Person> sortByBirthYearDescending() {
        return PersonDB.personList.stream().sorted((o1,o2) -> o2.getBirthday().compareTo(o1.getBirthday())).toList();
    }

    @Override
    public List<Person> top5HighestPaid() {
        return PersonDB.personList.stream().sorted((o1,o2) -> o2.getSalary() - o1.getSalary()).limit(5).toList();
    }

    @Override
    public List<Person> inAgeRange(int start, int end) {
        return PersonDB.personList.stream().filter(person -> Period.between(person.getBirthday(),LocalDate.now()).getYears()>= start && Period.between(person.getBirthday(),LocalDate.now()).getYears() <= end).collect(Collectors.toList());
    }
}
