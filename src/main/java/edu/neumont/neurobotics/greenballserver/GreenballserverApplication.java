package edu.neumont.neurobotics.greenballserver;

import edu.neumont.neurobotics.greenballserver.Controller.CommandListener;
import edu.neumont.neurobotics.greenballserver.Controller.SecurityInfo;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreenballserverApplication {

	public static void main(String[] args) {
		JDA api = JDABuilder.createDefault(SecurityInfo.BOT_TOKEN).build();
		api.addEventListener(new CommandListener());
		SpringApplication.run(GreenballserverApplication.class, args);
	}

}
