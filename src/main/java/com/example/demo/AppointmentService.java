package com.example.demo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// server and serverImpl
@Service
public class AppointmentService {
    private static List<Appointment> apt=new ArrayList<>();
    static {
        apt.add(new Appointment(1, "Kevin", LocalDate.now().plusDays(3), "Amazone"));
        apt.add(new Appointment(2, "LOO", LocalDate.now().plusDays(4), "SiemReap"));
        apt.add(new Appointment(3, "KOKO", LocalDate.now().plusDays(5), "Bathambong"));
    }
    public static List<Appointment> FindUser(String uname){
        return apt;
    }
}
