package com.roms.portal.payload;

import lombok.Data;

@Data
public class AuthResponsePayload {
    public String userName;
    public String token;

//    TODO: Complete the is empty function
//    public boolean isEmpty(){
//        return  userName.isEmpty() && token.isEmpty() && userName.isBlank() &&;
//    }
}
