package com.Asobi;

import Commands.*;
import Events.GuildMemberJoin;
import Events.GuildMemberRemove;
import Events.GuildMessageReactionAdd;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Asobi {

    public static JDA jda;
    public static String PREFIX = "aso-";

    public static void main(String[] args) throws LoginException {

        jda = JDABuilder.createDefault("ODkzODk4MTUxNDYxNzg1NjAx.YViJhw.5ityUR3qjunoQTbqD0RU2f1JR0I").build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("With Your Emotions"));

        jda.addEventListener(new Clear());
        jda.addEventListener(new Hello());
        jda.addEventListener(new Info());
        jda.addEventListener(new Secret());
        jda.addEventListener(new GuildMemberJoin());
        jda.addEventListener(new GuildMemberRemove());
        jda.addEventListener(new GuildMessageReactionAdd());
    }
}
