package Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class GuildMemberJoin extends ListenerAdapter {
    String[] messages = {
                    "[member] joined. You must construct additional pylons.",
                    "Never gonna give [member] up. Never let [member] down!",
                    "Hey! Listen! [member] has joined!",
                    "Ha! [member] has joined! You activated my trap card!",
                    "We've been expecting you, [member].",
                    "It's dangerous to go alone, take [member]!",
                    "Swoooosh. [member] just landed.",
                    "Brace yourselves. [member] just joined the server.",
                    "A wild [member] appeared.",
                    "[member] just arrived. Seems too OP - please nerf.",
                    "A [member] has spawned in the server.",
                    "[member] just showed up. Hold my beer.",
                    "[member] joined your party.",
                     };
    public void onGuildMemberJoin(GuildMemberJoinEvent event){
        Random rand = new Random();
        int number = rand.nextInt(messages.length);

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(0x66d8ff);
        join.setDescription(messages[number].replace("[member]", event.getUser().getName()));

        event.getGuild().getDefaultChannel().sendMessageEmbeds(join.build()).queue();

        // Add Role
        event.getGuild().addRoleToMember(event.getUser().getId(), event.getGuild().getRolesByName("Newbie", false).get(0));
    }
}
