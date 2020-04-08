package br.usjt.devmobile.minhassenhasapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Senha.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    public abstract SenhaDao senhaDao();
}



