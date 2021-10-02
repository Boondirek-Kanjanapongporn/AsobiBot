package com.Asobi;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Asobi {
    // Asobi - ODkzODk1OTMyNDYxMDg4ODM5.YViHdg.-q52yGqRQql4T4xoHyVubXOmEZQ
    // BoonBot - ODkzODk4MTUxNDYxNzg1NjAx.YViJhw.D1pqNGhqNnEIr569sMbuwCUx_gA
    // NonBot - ODkzODk4NTMwOTc5MjA5Mjg3.YViJ4Q.f81UmfIJyGLXWlA6LUGQQ0J69Ek
    // BirdBot - ODkzODk4NzU2MDA3Nzg4NjA0.YViKFw.fkEa_WLkVoNIIUS3FoRfxajHVg8

    public static JDA jda;

    public static void main(String[] args) throws LoginException {

        jda = JDABuilder.createDefault("").build();
        jda.getPresence().setStatus(OnlineStatus.IDLE);
        jda.getPresence().setActivity(Activity.watching("Pornhub"));
    }
}
