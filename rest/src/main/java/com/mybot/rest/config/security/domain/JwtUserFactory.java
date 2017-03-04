package com.mybot.rest.config.security.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.mybot.domain.user.User;

public final class JwtUserFactory {

	private JwtUserFactory() {
	}

	public static JwtUser create(User user) {
		return new JwtUser(user.getEmail(), user.getFirstName(), user.getLastName(), user.getEmail(),
				user.getPassword(), mapToGrantedAuthorities(user.getRoles()), true);
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
		List<GrantedAuthority> ret = new ArrayList<>();
		ret.add(new SimpleGrantedAuthority(authorities.get(0)));
		return ret;
	}
}
