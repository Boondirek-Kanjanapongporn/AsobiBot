package Commands;

import com.Asobi.Asobi;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Hello extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Asobi.PREFIX + "hello")){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("Hello " + event.getAuthor().getName() + ", How may I help you?").queue();
        }
    }
}
