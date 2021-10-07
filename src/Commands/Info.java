package Commands;

import com.Asobi.Asobi;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Info extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Asobi.PREFIX + "info")){
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("ASOBI Discord Bot  🤖");
            info.appendDescription("A Multi-functional Bot built for Entertainment and Educational purposes to assist both gamers and students alike");
            info.addField("Creators:", "Boondirek K., Krittawat S., Somboon S.", false);
            info.addField("Language:", "Java", false);
            info.addField("Framework:", "JDA (Java Discord API)", false);
            info.addField("Get Started!!", "Try typing 'aso-commands'", true);
            info.setImage("https://i.imgur.com/dWH4uVo.png");
            info.setColor(0xe6e6e6);
            info.setFooter("All Copyrights reserved © 2021");
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
        }
    }
}