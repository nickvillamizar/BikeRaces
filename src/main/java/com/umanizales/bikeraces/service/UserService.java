package com.umanizales.bikeraces.service;

import com.umanizales.bikeraces.model.Rol;
import com.umanizales.bikeraces.model.User;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class UserService {
    private List<Rol> roles;

    private List<User> usuarios;


    public UserService(){
        roles=new ArrayList<>();
        usuarios=new ArrayList<>();

        roles.add(new Rol("0088","administrador"));
        roles.add(new Rol("00763","usuario"));
        usuarios.add(new User("jhonjairo125","5456464",new Rol("001","administrador")));
        usuarios.add(new User("holalindo23","54548",new Rol("002","usuario")));

    }
    public String addRol(Rol rol){
        for (Rol rol1: roles){
            if(rol1.getCode().equals(rol.getCode()) || rol1.getDescription().equals(rol.getDescription())){
                return "no se puede agregar lo sentimos es una lastima";
            }

        }
        this.roles.add(rol);
        return "se agrego bien el rol mi bro ";

    }

    public List<User> getUsuarios() {
        return this.usuarios;
    }

    public Boolean verifyAccess(User user){
        for (User user1: usuarios){
            if (user1.getRol().getCode().equals(user.getRol().getCode())&& user.getRol().getDescription().equals("administrador")){
                return true;
            }
        }
        return false;

    }
}
