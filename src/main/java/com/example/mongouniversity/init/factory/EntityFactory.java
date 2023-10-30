package com.example.mongouniversity.init.factory;

import java.util.List;

public interface EntityFactory<T> {
    T createEntity();
    List<T> createEntities(int number);
}
