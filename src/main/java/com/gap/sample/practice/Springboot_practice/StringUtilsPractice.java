package com.gap.sample.practice.Springboot_practice;

import org.apache.tomcat.util.buf.StringUtils;

import java.util.UUID;

public class StringUtilsPractice {

    enum Color
    {
        RED, GREEN, BLUE;
    }

    public boolean deleted;
    public String description;
    public int historyVersion=1;
    public static void main(String[] args) {
       // UUID uuid = UUID.nameUUIDFromBytes(byte[] bytes);

        UUID ss = UUID.randomUUID();
        //System.out.println(uuid);
        System.out.println("UUID is =>"+ss);

        Color color = Color.RED;
        System.out.println(color);
        if(true){

        }else if(false){

        }


    }
  /*  public String getTransactionType() {

        return this.deleted?ASSORTED_CUSTOMER_CHOICE_DELETED.getDescription()
                :this.historyVersion>1?ASSORTED_CUSTOMER_CHOICE_UPDATED.getDescription():
                ASSORTED_CUSTOMER_CHOICE_CREATED.getDescription();
        *//*if (this.deleted) {
            //return ASSORTED_CUSTOMER_CHOICE_DELETED.getDescription();
            return description;
        } else if(this.historyVersion>1){
           // if (this.historyVersion > 1) {
            //ASSORTED_CUSTOMER_CHOICE_UPDATED.getDescription();
                return description;
            //}
            return description;
        }*//*
    }*/
}
