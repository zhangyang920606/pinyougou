package com.pinyougou.service;

import com.pinyougou.pojp.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    private SellerService sellerService;

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("经过了UserDetailsServiceImpl");


        List<GrantedAuthority> grantAuths=new ArrayList();
        grantAuths.add(new SimpleGrantedAuthority("ROLE_SELLER"));

        TbSeller tbSeller = sellerService.findOne(username);
        if(tbSeller!=null){
          if(tbSeller.getStatus().equals("1")){
              return new User(username,tbSeller.getPassword(),grantAuths);
          }else {
              return null;
          }
        }else {
            return null;
        }


    }
}
