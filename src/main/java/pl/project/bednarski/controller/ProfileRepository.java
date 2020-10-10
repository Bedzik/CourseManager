package pl.project.bednarski.controller;


import org.springframework.data.repository.CrudRepository;
import pl.project.bednarski.model.Profiles;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profiles,Long> {
    List<Profiles> findByName(String name);
}
