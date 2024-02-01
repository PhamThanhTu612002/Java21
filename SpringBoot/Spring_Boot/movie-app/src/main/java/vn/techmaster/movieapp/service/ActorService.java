package vn.techmaster.movieapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.movieapp.entity.Actor;
import vn.techmaster.movieapp.repository.ActorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActorService {
    @Autowired
    ActorRepository actorRepository;

    public List<Actor> getAllActors(){
        return actorRepository.findAll();
    }
}
