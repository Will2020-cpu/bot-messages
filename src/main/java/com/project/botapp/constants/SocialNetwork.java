package com.project.botapp.constants;

public enum SocialNetwork {
    FACEBOOK("FACEBOOK"),
    WHATSAPP("WHATSAPP"),
    DISCORD("DISCORD");

    private final String social;

    SocialNetwork(String social){
        this.social = social;
    }

    public String getSocial(){
        return social;
    }
}
