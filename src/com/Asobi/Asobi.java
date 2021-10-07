package com.Asobi;

import Commands.*;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.Command;

import javax.security.auth.login.LoginException;

public class Asobi {

    public static JDA jda;
    public static String PREFIX = "aso-";

    public static void main(String[] args) throws LoginException {

        jda = JDABuilder.createDefault("").build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.watching("Boring Comedy Shows"));

        jda.addEventListener(new Clear());
        jda.addEventListener(new Hello());
        jda.addEventListener(new Info());
    }
}
