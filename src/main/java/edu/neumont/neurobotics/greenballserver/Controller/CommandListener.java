/**
 * @author rmeeks
 * @createdOn 11/25/2024 at 12:37 PM
 * @projectName greenballserver
 * @packageName edu.neumont.neurobotics.greenballserver.Controller;
 */
package edu.neumont.neurobotics.greenballserver.Controller;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        Message message = event.getMessage();
        String content = message.getContentRaw();
        if (content.equals("!help")){
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Test").queue();
        }
    }
}
