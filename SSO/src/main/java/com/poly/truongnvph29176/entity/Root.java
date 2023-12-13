package com.poly.truongnvph29176.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Root{
    public String at_hash;
    public String sub;
    public boolean email_verified;
    public String iss;
    public String given_name;
    public String locale;
    public String nonce;
    public String picture;
    public ArrayList<String> aud;
    public String azp;
    public String name;
    public Date exp;
    public String family_name;
    public Date iat;
    public String email;
}
