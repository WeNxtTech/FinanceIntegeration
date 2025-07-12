/* Decompiler 9ms, total 302ms, lines 29 */
package com.finance.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserInfoService implements UserDetailsService {
//   @Autowired
//   private UserMasterRepository userrrepo;

   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Optional<LM_MENU_USERS> userDetail = null;
      LM_MENU_USERS userDetails = new LM_MENU_USERS();
      userDetails.setUserId("admin");
      userDetails.setUser_passwd("admin");
      userDetail = Optional.of(userDetails);
      return (UserDetails)userDetail.map(UserInfoDetails::new).orElseThrow(() -> {
         return new UsernameNotFoundException("User not found " + username);
      });
   }
}