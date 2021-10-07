package Commands;

import com.Asobi.Asobi;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class Clear extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if(args[0].equalsIgnoreCase(Asobi.PREFIX + "clear")){
            if (args.length < 2){
                EmbedBuilder error = new EmbedBuilder();
                error.setColor(0xEED202);
                error.setTitle("⚠  Specify Amount to Delete");
                error.setDescription("Try: '" + Asobi.PREFIX + "clear [# of messages]'");
                event.getChannel().sendMessage(error.build()).queue();
            }
            else {
                try{
                    List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                    event.getChannel().deleteMessages(messages).queue();

                    // Success
                    EmbedBuilder success = new EmbedBuilder();
                    success.setColor(0x22ff2a);
                    success.setTitle("✅  Successfully Deleted " + args[1] + " Messages!!!");
                    event.getChannel().sendMessage(success.build()).queue();
                }
                catch (Exception e){
                    if(e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")){
                        // Too many messages
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff3923);
                        error.setTitle("⛔  Too Many Messages Selected");
                        error.setDescription("Between 1-100 messages can be deleted at a time...");
                        event.getChannel().sendMessage(error.build()).queue();
                    }
                    else{
                        // Messages too old
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff3923);
                        error.setTitle("⛔ Selected Messages Are Too Old!!");
                        error.setDescription("Messages older than 2 weeks cannot be deleted");
                        event.getChannel().sendMessage(error.build()).queue();
                    }
                }
            }
        }

    }
}
