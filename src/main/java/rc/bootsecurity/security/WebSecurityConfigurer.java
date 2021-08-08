package rc.bootsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
//@EnableSpringDataWebSupport
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter
{

    @Autowired
    UserDetailsService userDetailsService;

//    private UserDetailsServiceImpl userDetailsService;
//
//
//    public WebSecurityConfigurer(UserDetailsServiceImpl userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(authenticationProvider());
//        //auth.encoder
//    }


//    @Bean
//    //@Autowired UserDetailsServiceImpl userDetailsService
//    DaoAuthenticationProvider authenticationProvider(
//            //UserDetailsServiceImpl userDetailsService
//    ) {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//
//        return daoAuthenticationProvider;
//    }


    @Bean
    //@SessionScope
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



//    @Bean
//    public SimpleUrlAuthenticationFailureHandler authenticationFailureHandler() {
//        SimpleUrlAuthenticationFailureHandler failureHandler =
//                new SimpleUrlAuthenticationFailureHandler();
//        failureHandler.setUseForward(true);
//        failureHandler.setDefaultFailureUrl("/");
//        return failureHandler;
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/profile/**").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/api/public/test1").hasAuthority("ACCESS_TEST1")
                .antMatchers("/api/public/test2").hasAuthority("ACCESS_TEST2")
                .antMatchers("/api/public/users").hasRole("ADMIN")
                .and()
                .formLogin()
//                    .failureHandler(new SimpleUrlAuthenticationFailureHandler() {{
//                                                //setUseForward(true);
//                                                setDefaultFailureUrl("/login?error");
//                                    }})
                    .failureForwardUrl("/login?error")
                    .loginProcessingUrl("/signin")
                        //.permitAll()
                    .loginPage("/login")
                        .permitAll()
                    .usernameParameter("username")
                    .passwordParameter("password")

                .and()
                .logout()
                    .logoutUrl("/logout")
                    //.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login") //login
                .and()

//                .logout()
//                .logoutUrl("/perform_logout")
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")

//                .exceptionHandling()

                .rememberMe()
                    .tokenValiditySeconds(2592000)
                    .key("mySecret!")
                    .rememberMeParameter("checkRememberMe")
                    .userDetailsService(userDetailsService);
    }

}
