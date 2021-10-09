package Events;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReactionAdd extends ListenerAdapter {
    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event){
        if (event.getReactionEmote().getName().equals("❌") && !event.getUser().equals(event.getJDA().getSelfUser())){
            event.getChannel().deleteMessageById(event.getMessageId()).queue();
        }
    }
}
