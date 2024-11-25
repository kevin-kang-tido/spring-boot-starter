package com.example.demo.contact;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Service
@Setter
@Getter
@AllArgsConstructor
public class ContactService {
    private static List<Contact> ls=new ArrayList<>();
    private static int id=0;
    static {
        ls.add(new Contact(++id, "sothea","kevintido@gmail.com","01333555"));
    }
    public static List<Contact> show(){
        return ls;
    }
    public static void AddContact(Contact c) {
        ls.add(c);
    }
}
