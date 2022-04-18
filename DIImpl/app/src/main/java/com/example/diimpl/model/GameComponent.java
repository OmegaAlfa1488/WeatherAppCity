package com.example.diimpl.model;

import dagger.Component;

@Component(modules = GameModule.class)
public interface GameComponent {
    void inject(GameSession obj);
}