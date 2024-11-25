/**
 * @author rmeeks
 * @createdOn 11/25/2024 at 12:37 PM
 * @projectName greenballserver
 * @packageName edu.neumont.neurobotics.greenballserver.Controller;
 */
package edu.neumont.neurobotics.greenballserver.Controller;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public class CommandListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        Message message = event.getMessage();
        String content = message.getContentRaw();
        if (content.equals("!help")){
            message.delete().queue();
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Test").queue();
        }
        if (content.equals("!score")){
            message.delete().queue();
        }
    }

    public static void sendUpdate(String message, TextChannel channel){
        channel.sendMessage(message).queue();
    }
}
