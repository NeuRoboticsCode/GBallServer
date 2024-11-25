/**
 * @author rmeeks
 * @createdOn 11/21/2024 at 1:14 PM
 * @projectName greenballserver
 * @packageName edu.neumont.neurobotics.greenballserver.Model;
 */
package edu.neumont.neurobotics.greenballserver.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ScoreSave {

    @Id
    int id;
    int score;
    Date time;

    public ScoreSave() {
        setScore(0);
        setTime(new Date());
    }

    public ScoreSave(int id,int score, Date time) {
        setId(id);
        setScore(score);
        setTime(time);
    }

    @Override
    public String toString(){
        return String.valueOf(score);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
