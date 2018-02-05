package com.service;


public class Main {
    public static void main(String[] args){
      String token=  TokenHandler.getInstance().createToken(6);
      System.out.print(TokenHandler.getInstance().getUserIdByToken(token));
    }
}
