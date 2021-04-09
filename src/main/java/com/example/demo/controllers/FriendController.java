package com.example.demo.controllers;

import models.Friend;
import models.Response;
import org.springframework.web.bind.annotation.*;
import repos.FriendDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-08 <br>
 * Time: 14:40 <br>
 * Project: LiveSpringInitilizrDemo <br>
 */
@RestController
public class FriendController {

    FriendDAO fdb = new FriendDAO();
    List<Friend> friends = fdb.getAllFriends();

    @RequestMapping("/friends")
    public List<Friend> getAllFriends(){
        return friends;
    }

    @RequestMapping("/friend")
    public Friend getRandomFriend(){
        if(friends.size() == 0) return new Friend(0,"John Doe","Nowhere 3","0704040404");
        Random rand = new Random();
        int nr = rand.nextInt(friends.size());
        return friends.get(nr);
    }

    @RequestMapping("/friend/{id}")
    public Friend getSpecificFriend(@PathVariable int id){
        for(Friend f : friends){
            if(f.getId() == id) return f;
        }
        return new Friend(0,"John Doe","Nowhere 3","0704040404");
    }

    @RequestMapping("/friend/{idFrom}/{idTo}")
    public List<Friend> getSomeFriends(@PathVariable int idFrom, @PathVariable int idTo){
        List<Friend> list = new ArrayList<>();
        for(Friend f : friends){
            if(f.getId() >= idFrom && f.getId() <= idTo) list.add(f);
        }
        if(list.size() == 0) list.add(new Friend(0,"John Doe","Nowhere 3","0704040404"));
        return list;
    }

    @RequestMapping("/friend/{id}/delete")
    public Response deleteFriend(@PathVariable int id){
        int friendIndexToRemove = -1;

        for(int i = 0; i < friends.size(); i++){
            if(friends.get(i).getId() == id){
                friendIndexToRemove = i;
            }
        }

        if(friendIndexToRemove == -1){
            return new Response("Hittades ej i databasen...",false);
        }
        Friend removed = friends.remove(friendIndexToRemove);
        return new Response("Tagig bort kompis: " + removed.toString(),true);
    }

    @RequestMapping("/addfriend/{name}/{phone}")
    public Response addFriend(@PathVariable String name,@PathVariable String phone){
        int id = getNextId();
        System.out.println(id);
        Friend friend = new Friend(id,name,"John Doe Street 666",phone);
        friends.add(friend);
        return new Response("Added: " + friend.toString(),true);
    }

    public int getNextId(){
        int nr = -1;
        for(Friend f : friends){
            if(f.getId() >= nr) nr = f.getId()+1;
        }
        return nr;
    }

    @RequestMapping("/friendsinhtml")
    public String getAllFriendsInHtml(){
        String text = "<html><head></head><body><h1>Vänlistan</h1><ul>";
        for(Friend f : friends){
            text += "<li>" + f.getName() + " - " + f.getPhoneNr() + "</li>";
        }
        text += "</ul></body><html>";
        return text;
    }

    @PostMapping("/friend/add")
    public String addFriendWithPost(@RequestBody Friend friend){
        friends.add(friend);
        return "Added friend: " + friend.toString();
    }

    @PostMapping("/friend/upsert")
    public Response upsertFriend(@RequestBody Friend friend){
        int friendIndexToUpdate = -1;

        for(int i = 0; i < friends.size(); i++){
            if(friends.get(i).getId() == friend.getId()){
                friendIndexToUpdate = i;
            }
        }
        if(friendIndexToUpdate == -1){
            friends.add(friend);
            return new Response("New friend added",true);
        }
        else{
            friends.set(friendIndexToUpdate,friend);
            return new Response("Old friend updated",true);
        }
    }

}
