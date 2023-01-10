package br.com.getNet.data.factory.users;

import br.com.getNet.data.pojo.createUser.BodyCreateUser;

public class UserDataFactory {

    public static BodyCreateUser dataCreateUser(String name, String job){

        BodyCreateUser bodyCreateUser = new BodyCreateUser(name, job);
        return bodyCreateUser;
    }
}
