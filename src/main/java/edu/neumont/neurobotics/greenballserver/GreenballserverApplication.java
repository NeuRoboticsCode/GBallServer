package edu.neumont.neurobotics.greenballserver;

import edu.neumont.neurobotics.greenballserver.Controller.CommandListener;
import edu.neumont.neurobotics.greenballserver.Controller.SecurityInfo;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreenballserverApplication {

	public static void main(String[] args) {
		JDA api = JDABuilder.createDefault(SecurityInfo.BOT_TOKEN).enableIntents(GatewayIntent.MESSAGE_CONTENT).build();
		api.addEventListener(new CommandListener());
		String test = "artsdew";
		SpringApplication.run(GreenballserverApplication.class, args);
	}

}
