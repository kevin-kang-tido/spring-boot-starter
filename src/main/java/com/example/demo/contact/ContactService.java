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
        ls.add(new Contact(++id, "kevintido","kevintido@gmail.com","01333555", null));
    }
    public static List<Contact> show(){
        return ls;
    }
    public static void AddContact(Contact c) {
        ls.add(c);
    }

    // delete contract 
public void deleteContact(int id) {
    ls.removeIf(contact -> contact.getId() == id);
}


    // 

    public Contact findContact(int id) {
        return ls.stream()
                 .filter(contact -> contact.getId() == id)
                 .findFirst()
                 .orElse(null); 
    }
    


    public static void updateContact(int id,Contact contact) {

        for(int i=0;i<ls.size();i++) {
        if(ls.get(i).getId()==id) {

        ls.remove(i);
        AddContact(contact);

        }
     }
    }



}
