/* Decompiler 12ms, total 305ms, lines 50 */
package com.finance.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfoDetails implements UserDetails {
   private String name = "admin";
   private String password = "admin";
   private List<GrantedAuthority> authorities;

   public UserInfoDetails(LM_MENU_USERS userInfo) {
      userInfo.setUser_group_id("1");
      this.authorities = (List)Arrays.stream(userInfo.getUser_group_id().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
   }

   public Collection<? extends GrantedAuthority> getAuthorities() {
      return this.authorities;
   }

   public String getPassword() {
      return this.password;
   }

   public String getUsername() {
      return this.name;
   }

   public boolean isAccountNonExpired() {
      return true;
   }

   public boolean isAccountNonLocked() {
      return true;
   }

   public boolean isCredentialsNonExpired() {
      return true;
   }

   public boolean isEnabled() {
      return true;
   }
}