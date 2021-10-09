package Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class GuildMemberRemove extends ListenerAdapter {
    String[] messages = {
            "[member] has left... :(",
            "Wave goodbye to [member] !!  😢",
            "[member] jumped out of the server.",
            "Goodbye [member]... Men do not cry  😟",
            "Sob* Sob*, We will miss you [member].",
            "RIP [member]...  ✝",
            "Press 'F' for [member]",
            "It is time to depart with [member].",
            "Until next time, [member] bye bye!!!",
            "[member] have gone to a better server",
    };

    public void onGuildMemberRemove(GuildMemberRemoveEvent event){
        Random rand = new Random();
        int number = rand.nextInt(messages.length);

        EmbedBuilder remove = new EmbedBuilder();
        remove.setColor(0xf48342);
        remove.setDescription(messages[number].replace("[member]", event.getUser().getName()));

        event.getGuild().getDefaultChannel().sendMessageEmbeds(remove.build()).queue();
    }
}
