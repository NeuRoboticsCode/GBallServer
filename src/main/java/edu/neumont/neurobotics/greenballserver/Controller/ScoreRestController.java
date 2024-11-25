/**
 * @author rmeeks
 * @createdOn 11/21/2024 at 12:57 PM
 * @projectName greenballserver
 * @packageName edu.neumont.neurobotics.greenballserver.Controller;
 */
package edu.neumont.neurobotics.greenballserver.Controller;

import edu.neumont.neurobotics.greenballserver.Model.ScoreSave;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
@EnableJpaRepositories
@RequestMapping("/gballserver")
public class ScoreRestController {
    JDA api = JDABuilder.createDefault(SecurityInfo.BOT_TOKEN)
            .enableIntents(GatewayIntent.MESSAGE_CONTENT)
            .addEventListeners(new CommandListener())
            .build();

    @Autowired
    ScoreRepository scoreRepository;

    @RequestMapping(path="/add", method = RequestMethod.POST)
    public void addToScore(){
        int score = 0;
        if (scoreRepository.findById(1).isPresent()){
            Optional<ScoreSave> saveoptional = scoreRepository.findById(1);
            ScoreSave save = saveoptional.get();
            score = save.getScore() + 1;
        }
        scoreRepository.save(new ScoreSave(1,score,new Date()));
        CommandListener.sendUpdate("Score update " + score, api.getTextChannelById(1310687222625992707l));
    }

    @RequestMapping(path = "/score",method = RequestMethod.GET)
    public String showScore(){
        Optional<ScoreSave> saveoptional = scoreRepository.findById(1);
        ScoreSave save = saveoptional.get();
        return Integer.toBinaryString(save.getScore());
    }

    @RequestMapping(path = "/reset",method = RequestMethod.DELETE)
    public void resetScore(){
        scoreRepository.deleteAll();
        addToScore();
    }
}
