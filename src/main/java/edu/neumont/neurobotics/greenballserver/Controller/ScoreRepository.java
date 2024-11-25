/**
    @author rmeeks
    @createdOn 11/21/2024 at 1:13 PM
    @projectName greenballserver
 @packageName edu.neumont.neurobotics.greenballserver.Controller;*/
package edu.neumont.neurobotics.greenballserver.Controller;

import edu.neumont.neurobotics.greenballserver.Model.ScoreSave;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends CrudRepository<ScoreSave, Integer> {
}
