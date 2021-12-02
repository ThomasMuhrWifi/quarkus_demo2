package at.cgsit.train.quarkus.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DemoServiceNew {

    public String reverseEcho(String inputString){
        StringBuilder sb= new StringBuilder(inputString);
        sb.reverse();
        return sb.toString().toUpperCase();
    }
}
