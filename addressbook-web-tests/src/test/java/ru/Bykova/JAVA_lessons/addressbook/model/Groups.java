package ru.Bykova.JAVA_lessons.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupData> {

    private Set<GroupData> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<GroupData>(groups.delegate);
    }

    public Groups() {
        this.delegate = new HashSet<GroupData>();
    }

    @Override
    protected Set<GroupData> delegate() {
        return delegate;//метод delegate возвращает объект
    }

    public Groups withAdded(GroupData group) {//доб свои собств методы.этот метод возвр новый объект с доб новой группой
       Groups groups = new Groups(this);
       groups.add(group);//добавление
       return groups;//возвр копию с добавл.группой
    }

    public Groups without(GroupData group) {//метод дел копию,из кот удалена к-л группа
        Groups groups = new Groups(this);
        groups.remove(group);//удаление
        return groups;//возвр копию с добавл.группой
    }
}
